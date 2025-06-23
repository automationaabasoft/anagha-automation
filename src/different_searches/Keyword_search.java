package different_searches;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Keyword_search extends basic_searchbaseclass {
	String validkeyword = "Doctor";
	String invalidkeyword = "#$%^";
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
		driver.findElement(keywordsearchfield).click();
	}

	// @Test
	public void Testing_with_validkeyword() throws InterruptedException// Testing with valid keywords

	{
		WebElement keywordfield = driver.findElement(keywordsearchinputfield);
		if (keywordfield.isDisplayed() && keywordfield.isEnabled()) {
			keywordfield.sendKeys(validkeyword);
			driver.findElement(keywordsearchbutton).click();
			List<WebElement> jobElements = driver.findElements(jobfields);
			for (WebElement jobEl : jobElements) {
				String jobText = jobEl.getText().trim();
				System.out.println("Found profile job: " + jobText);
				assert jobText.equals("Doctor") : "Profile found with a job different from 'Doctor': " + jobText;
			}
		} else {
			System.out.println("Field is not interactable");
		}
	}

	@Test
	public void Testing_with_Invalidkeyword() {
		WebElement keywordfield = driver.findElement(keywordsearchinputfield);
		keywordfield.sendKeys(invalidkeyword);
		driver.findElement(keywordsearchbutton).click();
		String nodatamessage = driver.findElement(keywordsearch_errormessagefield).getText();
		String Expectedmessage = "No data found!";
		if (nodatamessage.equalsIgnoreCase(Expectedmessage)) {
			System.out.println("No profiles found");
		} else {
			System.out.println("Test fails,profiles are displayed");
		}
	}
}
