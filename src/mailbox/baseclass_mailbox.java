package mailbox;

import org.openqa.selenium.By;

public class baseclass_mailbox {
	String number ="8330059098";
	String password = "123456";
	public By username = By.xpath("//*[@id='loginModel_username']");
	public By loginpasswordfield = By.xpath("//*[@id='loginModel_password']");
	public By loginbutton = By.xpath("//*[@id='formLogin']/div[4]/button");
	public By closepopupfield = By.xpath("//div[@class='closeBtn closeModalBtn' and @data-type='edu']");
	public By mailboxfield = By.xpath("/html/body/div[1]/div/div[2]/ul/li[4]/a");
	public By whointerestedmefield = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div[2]/div/button[1]");
	public By Myinterestsfield = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div[2]/div/button[2]");
	public By interestsentbutton = By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div[1]/div/div[5]/button[1]");
	public By shortlistbuttons = By.xpath("//button[contains(text(),'Shortlist')]");
	public By profileId_store = By.xpath("//div[@class='code goToPage']");
	public By deletebutton = By.xpath("//div[@class='HoroscopeOnline' and text()='Delete']");
	public By confirmationpopup = By.xpath("//button[contains(@class, 'btn-confirm-remove-message') and normalize-space(text())='Yes']");
	public By closebutton = By.className("closeBtn");
	public By remainingprofilefield = By.xpath("//div[@class='code goToPage']");
	public By shortlistbuttonfield = By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div[2]/div/div[5]/button[7]");
	public By webidfield = By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[3]");
	public By shortlistsection = By.xpath("//label[text()='Shortlist']");
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
