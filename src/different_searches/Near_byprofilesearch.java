package different_searches;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Near_byprofilesearch extends basic_searchbaseclass {
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
		driver.findElement(nearbysearchfield).click();
	}

	// @Test
	public void Test_with_validdata() {
		WebElement searchinputfield = driver.findElement(nearbysearchinputfield);
		if (searchinputfield.isDisplayed() && searchinputfield.isEnabled())
			searchinputfield.sendKeys("12");
		driver.findElement(nearbysearchbutton).click();
	}

	@Test
	public void Test_with_Nodata() {
		WebElement searchinputfield = driver.findElement(nearbysearchinputfield);
		searchinputfield.sendKeys("");
		driver.findElement(nearbysearchbutton).click();
		String pagesource = driver.getPageSource();
		if (pagesource.contains("Please enter the distance")) {
			System.out.println("Validation messages are displayed");
		} else {
			System.out.println("No Validation messages are displayed");
		}
	}

}
