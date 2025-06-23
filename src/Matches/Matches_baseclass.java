package Matches;

import org.openqa.selenium.By;

public class Matches_baseclass {
	String number ="8330059098 ";
	String password = "123456";
	public By username = By.xpath("//*[@id='loginModel_username']");
	public By loginpasswordfield = By.xpath("//*[@id='loginModel_password']");
	public By loginbutton = By.xpath("//*[@id='formLogin']/div[4]/button");
	public By matchesfield = By.xpath("/html/body/div[1]/div/div[2]/ul/li[3]/div/label/ul/li/a");
	public By profilesdisplayed = By.xpath("//a[contains(@href, '/profileview/?ID=')]");
	public By onlywithphotofilter = By.xpath("//*[@id=\"AdvanceSearch\"]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/label");
	public By profileimages = By.cssSelector("a.photo");
	public By maritalstatusfield = By.xpath("//*[@id=\"AdvanceSearch\"]/div[2]/div/div[1]/div/div/div/div/div[1]/ul/li/a");
	public By viewprofilefield = By.xpath("//a[contains(text(),'View Profile')]");
	public By maritalstatusprofilefield = By.xpath("/html/body/div[2]/div/div/div[1]/div[4]/div/div[2]/ul[2]/li[6]/span[2]");
	public By occupationfield = By.xpath("//*[@id=\"AdvanceSearch\"]/div[3]/div/div/div/div/div[1]/div/div[2]/ul/li[1]/a");
	public By alloccupationfield = By.xpath("//div[contains(@class,'profile-card')]//div[contains(text(),'Professional')]");
	public By castfieldbornagain = By.xpath("//*[@id=\"AdvanceSearch\"]/div[2]/div/div[2]/div/div/div[1]/div/div[1]/ul/li[2]/span");
	public By castfieldknanya = By.xpath("//*[@id=\"AdvanceSearch\"]/div[2]/div/div[2]/div/div/div[1]/div/div[1]/ul/li[3]/span");
	public By castfieldpentagost = By.xpath("//*[@id=\"AdvanceSearch\"]/div[2]/div/div[2]/div/div/div[1]/div/div[1]/ul/li[3]/a");
	public By castprotestant = By.xpath("//*[@id=\"AdvanceSearch\"]/div[2]/div/div[2]/div/div/div[1]/div/div[1]/ul/li[2]/a");
	public By allcastfield = By.xpath("//div[@class='content' and contains(text(), 'Caste -')]");
	public By darkcomplextioncheckbox = By.id("copmlex_298");
	public By loaderfield = By.cssSelector(".loading-indicator");
	public By profileLinkLocator = By.xpath("//div[@class='searchData']//div[@class='Profile'][1]//a[contains(@href,'profileview')]");
	public By complextionfield = By.xpath("//div[@id='profile-details']//span[contains(@class,'ansSec')]");
	public By alreadyinterestedbutton = By.xpath("//div[contains(@class,'content') and text()='Interested']");
	public By sendinterestbutton =  By.xpath("//div[contains(@class,'content') and text()='Send Interest']");
	public By shortlistbutton = By.cssSelector("div.content.send-shortlist");
	public By profileimagefields = By.tagName("img");
	public By initialprofilecountfield = By.cssSelector("div.content");
	public By excludealreadyviewedfield = By.xpath("//*[@id=\"AdvanceSearch\"]/div[1]/div[2]/div[1]/div/div/div[3]/div/div/label");
	public By updatedprofilecountfield = By.cssSelector("div.content");
	public By excludealreadycontacted = By.xpath("//*[@id=\"AdvanceSearch\"]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/label");
	public By contactbutton = By.xpath("//div[contains(@class,'view-contact')]");
	public By minimumagefilterhandler = By.cssSelector(".min-slider-handle");
	public By profileagefield = By.cssSelector(".content");
	public By sendinterestbuttonfields = By.xpath("//div[@class='content short']");
	public By shortlistbuttonfield = By.xpath("//div[@class='content send-shortlist']");
	
	
	
	
	
	
	
	
	
	
	
	
	//public By 
	
	

	
	

}
