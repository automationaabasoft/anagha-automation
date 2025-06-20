package Intimate_logintest;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;


public class intimate_login extends base_class{
	public String number = "";
	public String password = "";
	public String invalidwebid = "abcd";
	public String invalidpassword = "12345";
	public String validwebid = "9207251659";
	public String validpassword = "123456";	
	
	WebDriver driver;
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://version2.intimatematrimony.com/edit-profile/");
	}
	//@Test//Empty field checking test 
	public void emptyfieldcheck()
	{
		driver.findElement(username).sendKeys(number);
		driver.findElement(loginpasswordfield).sendKeys(password);
		driver.findElement(loginbutton).click();
		boolean isusernameValidationDisplayed = driver.findElement(usernamevalidation).isDisplayed();
	    Assert.assertTrue(isusernameValidationDisplayed, "Validation message should be displayed for empty username");
	    boolean ispasswordValidationDisplayed=driver.findElement(passwordvalidation).isDisplayed();
	    Assert.assertTrue(ispasswordValidationDisplayed,"Validation message should be displayed for empty password");
		}
	//@Test//Testing with invalid username and password
	public void invalidlogintest()
	{
		driver.findElement(username).sendKeys(invalidwebid);
		driver.findElement(loginpasswordfield).sendKeys(invalidpassword);
		driver.findElement(loginbutton).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement failureMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(failureModal));
        Assert.assertTrue(failureMessage.isDisplayed(), "Failure modal should be displayed on invalid login.");
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destDir = new File("screenshots");
        if (!destDir.exists()) {
            destDir.mkdir();// create folder if it doesn't exist
        }
        File destFile = new File(destDir, "login-failure.png");
        try {
            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to save screenshot.");
        }             						
	}
	@Test()
	public void validlogintest()
	{
		driver.findElement(username).sendKeys(validwebid);
		driver.findElement(loginpasswordfield).sendKeys(validpassword);
		driver.findElement(loginbutton).click();
		
		
	}
}