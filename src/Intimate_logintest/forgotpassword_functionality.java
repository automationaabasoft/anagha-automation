package Intimate_logintest;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class forgotpassword_functionality extends base_class
{
    String invalidmobilenumber = "1245877";
    String validmobilenumbernotregistered = "8078918959";
    String validmobilenumberregistered = "9207251659"; 
    String invalidotp = "258495";
    String characterotp= "abcds";
    String newpassword = "123456";
    String confirmpassword = "123456";
    
	WebDriver driver;
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://version2.intimatematrimony.com/edit-profile/");
		driver.findElement(forgotpasswordfield).click();
	}
	//@Test() 
	public void testwith_emptymobilenumber()
	{
		driver.findElement(submitbuttonfield).click();
		boolean iswebidvalidationisDisplayed = driver.findElement(Webidvalidation).isDisplayed();
		Assert.assertTrue(iswebidvalidationisDisplayed,"Validation message for empty mobile number should be displayed.");			
	}
	//@Test()
	public void testwith_invalidmobilenumber()
	{
		driver.findElement(mobilenumberfield).sendKeys(invalidmobilenumber);
		driver.findElement(submitbuttonfield).click();
		boolean iswebidvalidationisDisplayed = driver.findElement(Webidvalidation).isDisplayed();
		Assert.assertTrue(iswebidvalidationisDisplayed,"Validation message for invalid mobile number should be displayed.");		
	}
	//@Test()
	public void testwith_validmobilenumber_notregistered()
	{
		driver.findElement(mobilenumberfield).sendKeys(validmobilenumbernotregistered);
		driver.findElement(submitbuttonfield).click();
		boolean iswebidvalidationisDisplayed = driver.findElement(Webidvalidation).isDisplayed();
		Assert.assertTrue(iswebidvalidationisDisplayed,"Validation message for notregistered  mobile number should be displayed.");						
	}
	//@Test()
	public void testwith_validmobilenumber_registered()
	{
		driver.findElement(mobilenumberfield).sendKeys(validmobilenumberregistered);
		driver.findElement(submitbuttonfield).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement successModal = wait.until(ExpectedConditions.visibilityOfElementLocated(successpopupwindow));
        Assert.assertTrue(successModal.isDisplayed(),"Success modal should be displayed after valid submission");
	}
	//@Test()
	public void testwith_invalidotp() 
	{
		driver.findElement(mobilenumberfield).sendKeys(validmobilenumberregistered);
		driver.findElement(submitbuttonfield).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(successpopupclosebutton));
		closeBtn.click();
		driver.findElement(otpfield).sendKeys(invalidotp);		
		driver.findElement(otpsubmitfield).click();		
		WebElement failureMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(otpfailuremessagepopup));
		Assert.assertTrue(failureMessage.isDisplayed(),"failure modal should be displayed after invalid submission");
	}		
	//@Test()
	public void testwith_characterin_otpfield()
	
	{
		driver.findElement(mobilenumberfield).sendKeys(validmobilenumberregistered);
		driver.findElement(submitbuttonfield).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(successpopupclosebutton));
		closeBtn.click();
		driver.findElement(otpfield).sendKeys(characterotp);		
		driver.findElement(otpsubmitfield).click();	
		WebElement otpError = driver.findElement(otperrormessage);
		Assert.assertTrue(otpError.isDisplayed(),"OTP validation message is not displayed");
		Assert.assertEquals(otpError.getText(),"OTP should be numeric", "Incorrect validation message");			
	}
	@Test()
	public void testwith_validotp() throws InterruptedException
	{
		driver.findElement(mobilenumberfield).sendKeys(validmobilenumberregistered);
		driver.findElement(submitbuttonfield).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(successpopupclosebutton));
		closeBtn.click();		
		wait.until(driver -> !driver.findElement(otpfield).getAttribute("value").isEmpty());
		Thread.sleep(3000);
		driver.findElement(otpsubmitfield).click();
		WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.closeBtn")));
		closeButton.click();
		driver.findElement(newpasswordfield).sendKeys(newpassword);
		driver.findElement(confirmpasswordfield).sendKeys(confirmpassword);
		
		driver.findElement(forgotpasswordsubmitbutton).click();
		boolean isSuccessVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(forgotpasswordsuccesspopup)).isDisplayed();		
		if (isSuccessVisible) {
		    System.out.println("Password changed successfully");
		} else {
		    System.out.println("Password change success message not displayed");
		}
		
		
		
		
	}
	 
}	
		
		
		
		
	

