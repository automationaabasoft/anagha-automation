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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Advance_search extends basic_searchbaseclass {
	WebDriver driver;
	String educationcategorydata = "Bachelors - Engineering";
	String educationdetailsdata = "B.Tech";
	String jobcategorydata = "IT & ENGINEERING";
	String jobdetailsdata = "Engineer";
	String countryfielddata = "India";
	String statefielddata = "Kerala";
	String districtfielddata = "Kozhikode";
	String cityfieldata = "Aleppy";
	String jobcountry = "India";
	String currentjobstate = "Kerala";
	String currentjobdistrict = "Kannur";
	String starfielddata = "Aswathi";
	String agefrom = "26";
	String ageto = "35";
	String heightfrom = "167";
	String heightto = "200";
	String castefield = "Nambiar";
	
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
		driver.findElement(advancesearchfield).click();
	}

	 //@Test// basic field
	public void Basic_field() throws InterruptedException {
		driver.findElement(advancesearch_agefromfield).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(advancesearch_agefromsearchfield));
		searchBox.sendKeys(agefrom,Keys.ENTER);
		driver.findElement(advancesearch_agetofield).click();
		WebElement tosearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(advancesearch_agetosearch));
		tosearchBox.sendKeys(ageto,Keys.ENTER);		
		driver.findElement(advancesearch_heightfromdropdown).click();
		WebElement heightFromInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(advancesearch_heightfromsearchfield));
		heightFromInput.sendKeys(heightfrom,Keys.ENTER);		
		driver.findElement(advancesearch_heighttodropdown).click();
		WebElement heightToInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(advancesearch_heighttosearchfield));
		heightToInput.sendKeys(heightto,Keys.ENTER);		
		WebElement dropdownContainer = wait
				.until(ExpectedConditions.elementToBeClickable(advancesearchcastselectiondropdown));
		dropdownContainer.click();
		WebElement searchInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(advancesearchfieldinputfield));
		searchInput.sendKeys(castefield,Keys.ENTER);		
		driver.findElement(advancesearch_maritalstatusfield).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(1000);
		driver.findElement(advancesearchbutton).click();
	}

	 @Test
	public void Education_field() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		driver.findElement(advancesearchexpandbutton).click();
		WebElement educationcateogory = driver.findElement(advancesearch_educationcategoryfield);
		educationcateogory.click();
		educationcateogory.sendKeys(educationcategorydata,Keys.ENTER);
		WebElement educationdetails = driver.findElement(educationdetailsfield);
		educationdetails.click();
		educationdetails.sendKeys(educationdetailsdata,Keys.ENTER);
		WebElement jobcategory = driver.findElement(advancesearch_jobcategoryfield);
		jobcategory.click();
		jobcategory.sendKeys(jobcategorydata,Keys.ENTER);
		WebElement jobdetails = driver.findElement(jobdetailsfield);
		jobdetails.click();
		jobdetails.sendKeys(jobdetailsdata,Keys.ENTER);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		driver.findElement(advancesearchbutton).click();
	}

	// @Test
	public void familylocation() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		WebElement familyinfo = driver.findElement(advancesearch_familyinfoexpandbutton);
		familyinfo.click();
		WebElement countryfield = driver.findElement(countryselectionfield);
		countryfield.click();
		countryfield.sendKeys(countryfielddata,Keys.ENTER);
		WebElement statefield = driver.findElement(stateselectionfield);
		statefield.click();
		statefield.sendKeys(statefielddata,Keys.ENTER);
		WebElement districtfield = driver.findElement(districtselectionfield);
		districtfield.click();
		districtfield.sendKeys(districtfielddata,Keys.ENTER);
		WebElement cityfield = driver.findElement(cityselectionfield);
		cityfield.click();
		cityfield.sendKeys(cityfieldata,Keys.ENTER);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		driver.findElement(advancesearchbutton).click();
	}

	// @Test
	public void joblocation() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		WebElement jobinfo = driver.findElement(jobinfoexpandbutton);
		jobinfo.click();
		WebElement joblocation = driver.findElement(joblocationfield);
		joblocation.click();
		joblocation.sendKeys(jobcountry,Keys.ENTER);
		WebElement jobstate = driver.findElement(jobstatefield);
		jobstate.click();
		jobstate.sendKeys(currentjobstate,Keys.ENTER);
		WebElement jobdistrict = driver.findElement(jobdistrictfield);
		jobdistrict.click();
		jobdistrict.sendKeys(currentjobdistrict,Keys.ENTER);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		driver.findElement(advancesearchbutton).click();
	}

	//@Test
	public void Horoscopefield() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		WebElement horoscope = driver.findElement(horoscopefield);
		horoscope.click();
		WebElement starfield = driver.findElement(starsecectionfield);
		starfield.click();
		starfield.sendKeys(starfielddata,Keys.ENTER);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		driver.findElement(advancesearchbutton).click();
	}
	//@Test
	public void excludeprofiles() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
		Thread.sleep(1000);
		WebElement excludeprofiles = driver.findElement(excludeprofilesfield);
		excludeprofiles.click();
		driver.findElement(alreadycontactedfield).click();
		driver.findElement(alreadyinterestedfield).click();
		driver.findElement(advancesearchbutton).click();		
		
		
		
		
	}
	

}

//		driver.findElement(By.xpath("//*[@id=\"AdvanceSearch\"]/div[3]/div/div/div/div[1]/span/span[1]/span/span/textarea")).sendKeys("India",Keys.ENTER);
//		driver.findElement(By.xpath("//*[@id=\"AdvanceSearch\"]/div[3]/div/div/div/div[2]/span/span[1]/span/span/textarea")).click();
//		driver.findElement(By.xpath("//*[@id=\"AdvanceSearch\"]/div[3]/div/div/div/div[2]/span/span[1]/span/span/textarea")).sendKeys("Kerala",Keys.ENTER);
//		driver.findElement(By.xpath("//*[@id=\"AdvanceSearch\"]/div[3]/div/div/div/div[3]/span/span[1]/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"AdvanceSearch\"]/div[3]/div/div/div/div[3]/span/span[1]/span")).sendKeys("Kozhikode",Keys.ENTER);
//		driver.findElement(By.xpath("//*[@id=\"AdvanceSearch\"]/div[3]/div/div/div/div[4]/span/span[1]/span/span/textarea")).click();
//		driver.findElement(By.xpath("//*[@id=\"AdvanceSearch\"]/div[3]/div/div/div/div[4]/span/span[1]/span/span/textarea")).sendKeys("Aleppy",Keys.ENTER);
//		js.executeScript("window.scrollBy(0,600)");
//		Thread.sleep(1000);
//		driver.findElement(advancesearchbutton).click();
