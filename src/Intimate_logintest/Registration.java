package Intimate_logintest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends base_class {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://version2.intimatematrimony.com/edit-profile/");
		driver.findElement(registrationlink).click();
	}

	// @Test
	public void fieldvalidationcheck() {
		driver.findElement(registerbuttonclick).click();
		WebElement errorMsg = driver.findElement(bride_groomfieldvalidation);
		Assert.assertTrue(errorMsg.isDisplayed(), "Validation message is not displayed.");
		Assert.assertEquals(errorMsg.getText(), "Bride/groom name is required", "Incorrect validation message.");
		WebElement mobileError = driver.findElement(mobilefieldvalidation);
		Assert.assertTrue(mobileError.isDisplayed(), "Mobile number validation message is not displayed.");
		Assert.assertEquals(mobileError.getText(), "Mobile number is required.","Incorrect mobile number validation message.");
		WebElement dobError = driver.findElement(dobfieldvalidation);
		Assert.assertTrue(dobError.isDisplayed(), "Date of birth error message is not displayed.");
		Assert.assertEquals(dobError.getText(), "Date of birth is required", "Incorrect Date of birth error message.");
		WebElement religionError = driver.findElement(religionfieldvalidation);
		Assert.assertTrue(religionError.isDisplayed(), "Religion error message is not displayed.");
		Assert.assertEquals(religionError.getText(), "Religion is required", "Incorrect Religion error message.");
		WebElement casteError = driver.findElement(castfieldvalidation);
		Assert.assertTrue(casteError.isDisplayed(), "Caste error message is not displayed.");
		Assert.assertEquals(casteError.getText(), "Caste is required", "Incorrect caste error message.");
	}

	// @Test
	public void bride_groomnamecheck() {
		driver.findElement(bride_groomnamefield).sendKeys("12345666");// Testing with only numbers
		driver.findElement(registerbuttonclick).click();
		WebElement errorMsg = driver.findElement(bride_groomfieldvalidation);
		Assert.assertTrue(errorMsg.isDisplayed(), "Validation message is not displayed.");
		driver.findElement(bride_groomnamefield).clear();
		driver.findElement(bride_groomnamefield).sendKeys("#$%^&");// Testing with special characters
		WebElement errorMsg1 = driver.findElement(bride_groomfieldvalidation);
		Assert.assertTrue(errorMsg1.isDisplayed(), "Validation message is not displayed.");
	}

	// @Test
	public void phonenumberfieldcheck() {
		driver.findElement(mobilenumberField).sendKeys("12345678");// Testing with less than 10 numbers
		driver.findElement(registerbuttonclick).click();
		WebElement mobileError = driver.findElement(mobilefieldvalidation);
		Assert.assertTrue(mobileError.isDisplayed(), "Mobile number validation message is not displayed.");
		driver.findElement(mobilenumberField).clear();
		driver.findElement(mobilenumberField).sendKeys("12345678765555");// Testing with more than 10 numbers
		driver.findElement(registerbuttonclick).click();
		WebElement mobileError1 = driver.findElement(mobilefieldvalidation);
		Assert.assertTrue(mobileError1.isDisplayed(), "Mobile number validation message is not displayed.");
		driver.findElement(mobilenumberField).clear();
		driver.findElement(mobilenumberField).sendKeys("acfrtyuoooo");// Testing with characters
		driver.findElement(registerbuttonclick).click();
		Assert.assertTrue(mobileError.isDisplayed(), "Mobile number validation message is not displayed.");
		WebElement mobileError2 = driver.findElement(mobilefieldvalidation);
		Assert.assertTrue(mobileError2.isDisplayed(), "Mobile number validation message is not displayed.");
	}

	@Test
	public void registration() throws InterruptedException {
		driver.findElement(bride_groomnamefield).sendKeys("Abasoft test");
		driver.findElement(mobilenumberField).sendKeys("1113456789");
		Actions actions = new Actions(driver);
		WebElement dobField = driver.findElement(dateofbirthfield);
		actions.moveToElement(dobField).click().perform();
		driver.findElement(dateselection).click();
		Thread.sleep(1000);
		WebElement dropdownTrigger = driver.findElement(religionfield);
		((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('mousedown', {bubbles:true}));", dropdownTrigger);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(religionsearchbox));
		searchBox.sendKeys("Hindu");
		WebElement resultOption = wait.until(ExpectedConditions.elementToBeClickable(religionselectionfield));
		resultOption.click();

		WebElement casteDropdownTrigger = driver.findElement(castdropdownfield);
		((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('mousedown', {bubbles:true}))", casteDropdownTrigger);
		WebElement casteSearchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(castsearchfield));
		casteSearchInput.sendKeys("Ezhava");
		WebElement casteResult = wait.until(ExpectedConditions.elementToBeClickable(castselectionfield));
		casteResult.click();
		WebElement panchayatField = driver.findElement(panchayathfield);
		panchayatField.sendKeys("Kozhuvanal");
		WebElement checkbox = driver.findElement(checkboxfield);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkbox);
		driver.findElement(registerbutton).click();

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(successpopupclosebutton));
		closeBtn.click();
		wait.until(driver -> !driver.findElement(otpfield).getAttribute("value").isEmpty());
		Thread.sleep(3000);
		driver.findElement(otpsubmitfield).click();

	}

}
