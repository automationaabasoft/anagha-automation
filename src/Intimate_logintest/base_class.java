package Intimate_logintest;

import org.openqa.selenium.By;

public class base_class {
	public By username = By.xpath("//*[@id='loginModel_username']");
	public By loginpasswordfield = By.xpath("//*[@id='loginModel_password']");
	public By loginbutton = By.xpath("//*[@id='formLogin']/div[4]/button");
	public By usernamevalidation=By.xpath("//*[@id=\"loginModel_username-error\"]");
	public By passwordvalidation=By.xpath("//*[@id=\"loginModel_password-error\"]");
	public By failureModal = By.xpath("//h4[contains(@class, 'Failure') and text()='Failure']");
	public By forgotpasswordfield = By.xpath("//a[text()='Forgot PassWord?']");
	public By submitbuttonfield = By.xpath("//*[@id=\"formForgotPassword\"]/div[2]/button");
	public By Webidvalidation = By.xpath("//*[@id=\"fpUserName-error\"]");
	public By successpopupclosebutton = By.className("closeBtn");
	public By mobilenumberfield = By.xpath("//*[@id=\"fpUserName\"]");
	public By otpfield = By.xpath("//*[@id=\"vpResetOTP\"]");
	public By otpsubmitfield = By.xpath("//*[@id=\"formOTPVerification\"]/div[2]/button");
	public By otpfailuremessagepopup = By.xpath("//div[@class='modalRow infoModal']//h4[contains(text(),'Failure')]");
	public By otperrormessage=By.id("vpResetOTP-error");
	public By newpasswordfield = By.xpath("//*[@id=\"rpPassword\"]");
	public By confirmpasswordfield = By.xpath("//*[@id=\"rpConfirmPassword\"]");
	public By forgotpasswordsubmitbutton = By.xpath("//*[@id=\"formResetPassword\"]/div[3]/button");
	public By forgotpasswordsuccesspopup = By.cssSelector("div.statusPic img[alt='success']");
	public By successpopupwindow = By.xpath("//div[contains(@class, 'modalRow') and contains(., 'Please check your email/mobile number for the OTP')]");
	public By registrationlink = By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[2]/div[2]/div/a");
	public By registerbuttonclick = By.xpath("//*[@id=\"formValidRegister\"]/div[2]/div[2]/button");
	public By bride_groomfieldvalidation = By.id("BrideOrGroomName-error");
	public By mobilefieldvalidation = By.id("MobileNumber-error");
	public By dobfieldvalidation = By.id("DateOfBirth-error");
	public By religionfieldvalidation = By.id("Religion-error");
	public By castfieldvalidation = By.id("Caste-error");
	public By bride_groomnamefield = By.xpath("//*[@id=\"BrideOrGroomName\"]");
	public By mobilenumberField = By.xpath("//*[@id=\"MobileNumber\"]");
	public By dateofbirthfield = By.id("DateOfBirth");
	public By dateselection = By.xpath("//*[@id=\"formValidRegister\"]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[3]/a[1]");
	
	public By religionfield = By.xpath("//span[@id='select2-Religion-container']");
	public By religionsearchbox = By.xpath("/html/body/span/span/span[1]/input");
	public By religionselectionfield = By.xpath("//li[contains(@class,'select2-results__option') and text()='Hindu']");
	public By castdropdownfield = By.xpath("//span[@id='select2-Caste-container']");
	public By castsearchfield = By.xpath("/html/body/span/span/span[1]/input");
	public By castselectionfield = By.xpath("//li[contains(@class,'select2-results__option') and text()='Ezhava']");
	public By checkboxfield = By.id("Agreed");
	public By panchayathfield = By.id("MuncipalOrPanchyth");
	public By registerbutton = By.xpath("//*[@id=\"formValidRegister\"]/div[2]/div[2]/button");
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
