package different_searches;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webid_search extends basic_searchbaseclass {
	String validwebid = "OTP1559880HEM";
	String invalidwebid = "1234677";
	String nodata = "";
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://version2.intimatematrimony.com/edit-profile/");
		driver.findElement(username).sendKeys(number);
		driver.findElement(loginpasswordfield).sendKeys(password);
		driver.findElement(loginbutton).click();
		WebElement closebutton = driver.findElement(closepopupfield);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", closebutton);
		driver.findElement(basic_searchfield).click();
		driver.findElement(webidsearchfield).click();

	}

	// @Test
	public void Testing_with_invalidwebid()// Testing with invalid webid
	{
		WebElement inputfield = driver.findElement(webidsearch);
		if (inputfield.isDisplayed() && inputfield.isEnabled()) {
			inputfield.click();
			inputfield.sendKeys(invalidwebid, Keys.ENTER);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement failureMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(webidsearch_failurepopup));
			Assert.assertTrue(failureMsg.isDisplayed(), "Failure popup is not displayed");
		} else {
			System.out.println("Field is not interactable");
		}

	}

	// @Test
	public void Testing_with_nodata()// Testing with no data
	{
		WebElement inputfield = driver.findElement(webidsearch);
		inputfield.click();
		inputfield.sendKeys(nodata, Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement failureMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(webidsearch_failurepopup));
		Assert.assertTrue(failureMsg.isDisplayed(), "Failure popup is not displayed");

	}

	// @Test
	public void Testing_with_validwebid()// Testing with valid webid
	{
		WebElement inputfield = driver.findElement(webidsearch);
		inputfield.click();
		inputfield.sendKeys(validwebid, Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement displayedWebIdElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(webidfieldaftersearch));
		String actualWebId = displayedWebIdElement.getText().trim();
		Assert.assertEquals(actualWebId, validwebid, "Displayed Web ID does not match the searched Web ID");
	}

}