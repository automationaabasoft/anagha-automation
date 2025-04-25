package Intimate_matrimony_web;

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

public class intimate_profileupdate extends base_testclass {
	public String number = "9207251659";
	public String aboutfield = "I am a dedicated and passionate engineer currently working at  X  company ";
	public String address = "XYZ,Kochi,Eranakulam";
	public String password = "123456";
	public String cousrename = "Engineering";
	public String university = "LPU University";
	public String place = "kochi";
	public String yearvalue = "2022";
	public String fathername = "Mahadevan";
	public String mothername = "Jane Doe";
	public String job_name = "Government Service";
	public String jathakam = "sudha jadhakam";
	public String caste = "Ezhava";
	public String countrycodevalue = "In";
	public String maritalstatusvalue = "Single";
	public String bodytypevalue = "Medium";
	public String physicalstatusvalue = "Normal";
	public String complextionvalue = "Fair";
	public String heightvalue = "165";
	public String weightvalue = "65";
	public String countryvalue = "India";
	public String districtvalue = "Kannur";
	public String starvalue = "Aswathi";
	public String rasivalue = "chingam";
	public String motherjobvalue = "Education";
	public String jobcategoryvalue ="juniour clerk";
	public String motherjobcateogory = "LP School assistant";
	public String fathereducationvalue ="Bachelors - Arts";
	public String mothereducationvalue = "Bachelors - Arts";
	public String fathereducationdetails = "B.A.";
	public String mothereducationdetails = "B.A.";
	public String familyvalue = "Liberal";
	public String familytype = "small";
	public String financialstatus = "Middle class";
	public String occupation = "Fashion Designer";
	public String employeedropdown = "private";
	public String companynamevalue = "Abasoft";
	public String designationvalue = "Developer";
	public String placenamevalue = "kochi";
	public String educationstartyear = "2021";
	public String educationcompletionyear = "2022";
	public String partnerheightvalue = "167";
	public String partnerheighttovalue = "200";
	public String partnerdecription = "Looking for a supportive and family-oriented partner.";

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
		js.executeScript("arguments[0].click();",closebutton);
		driver.findElement(editbutton).click();		
	}

	//@Test(priority = 1) // profile update
	public void login() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");				
		WebElement element = driver.findElement(aboutmyself);
		js.executeScript("arguments[0].click();",element);	
		driver.findElement(descriptionfield).sendKeys(aboutfield);
		driver.findElement(savebutton).click();
		WebElement popupwindow = driver.findElement(closepopup);
		js.executeScript("arguments[0].click();",popupwindow);		
	}

	// @Test(priority=2)//Basic details
	public void basicdetails() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement editbutton = driver.findElement(basicdetails);
		js.executeScript("arguments[0].click();",editbutton);		
		WebElement countrycodedropdown = driver.findElement(countrycode);
		countrycodedropdown.click();
		WebElement countrysearchinput = driver.findElement(countrycodesearchfield);
		countrysearchinput.sendKeys(countrycodevalue,Keys.ENTER);
		WebElement maritalstatusdropdown = driver.findElement(maritalstatus);
		maritalstatusdropdown.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement maritalstatussearchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(maritalstatussearchfield));
		maritalstatussearchInput.sendKeys(maritalstatusvalue,Keys.ENTER);
		WebElement bodytypedropdown = driver.findElement(bodytype);
		bodytypedropdown.click();
		WebElement bodytypesearchinput = wait.until(ExpectedConditions.visibilityOfElementLocated(bodytypesearchfield));
		bodytypesearchinput.sendKeys(bodytypevalue,Keys.ENTER);
		WebElement physicalstatusdropdown = driver.findElement(physicalstatusdropdownfield);
		physicalstatusdropdown.click();
		WebElement physicalstatussearch = wait.until(ExpectedConditions.visibilityOfElementLocated(physicalstatussearchfield));
		physicalstatussearch.sendKeys(physicalstatusvalue,Keys.ENTER);		
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(500);
		WebElement complexiondropdown = driver.findElement(complextion);
		complexiondropdown.click();
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(complextionsearchfield));
		searchBox.sendKeys(complextionvalue,Keys.ENTER);		
		WebElement heightdropdown = driver.findElement(heightdropdownfield);
		heightdropdown.click();
		WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(heightsearchfield));
		input.sendKeys(heightvalue,Keys.ENTER);
		WebElement weightdropdown = driver.findElement(weightfield);
		weightdropdown.click();
		WebElement weightinput = wait.until(ExpectedConditions.visibilityOfElementLocated(Weightsearchfield));
		weightinput.click();
		weightinput.sendKeys(weightvalue,Keys.ENTER);
		WebElement basicdetailssavebutton = driver.findElement(basicdetailssave);
		js.executeScript("arguments[0].click();",basicdetailssavebutton);
	}

	// @Test(priority=3)//Address info
	public void addressfield() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");		
		WebElement editaddressbutton = driver.findElement(editaddressbuttonfield);
		js.executeScript("arguments[0].click();",editaddressbutton);
		WebElement presentaddress = driver.findElement(presentaddressfield);
		presentaddress.clear();
		presentaddress.sendKeys(address);
		WebElement checkbox = driver.findElement(permenantcheckbox);
		checkbox.click();
		WebElement communicationaddresscheckbox = driver.findElement(communicationaddress);
		communicationaddresscheckbox.click();
		js.executeScript("window.scrollBy(0,100)");		
		WebElement addresssavebutton = driver.findElement(addresssavebuttonfield);
		js.executeScript("arguments[0].click();",addresssavebutton);		
	}

	 @Test(priority=4)//location info
	public void locationinfo() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");		
		WebElement locationinfo = driver.findElement(locationinfofield);
		js.executeScript("arguments[0].click();",locationinfo);
		WebElement Countrydropdown = driver.findElement(countrydropdown);
		Countrydropdown.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement countryinput = wait.until(ExpectedConditions.visibilityOfElementLocated(countrycodesearchfield));
		countryinput.sendKeys(countryvalue,Keys.ENTER);
		WebElement districtdropdown = driver.findElement(districtdropdownfield);
		districtdropdown.click();
		js.executeScript("window.scrollBy(0,200)");		
		WebElement districtInput = wait.until(ExpectedConditions.visibilityOfElementLocated(countrycodesearchfield));
		districtInput.sendKeys(districtvalue,Keys.ENTER);		
		js.executeScript("window.scrollBy(0,200)");		
		WebElement locationsavebutton = driver.findElement(locationsavebuttonfield);
		js.executeScript("arguments[0].click();",locationsavebutton);
		WebElement closebutton = driver.findElement(closepopup);
		js.executeScript("arguments[0].click();",closebutton);	
	}

	// @Test(priority=5)//religion info
	public void religioninfo() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement religioneditbutton = driver.findElement(Religionedit);		
		js.executeScript("arguments[0].click();",religioneditbutton);
		WebElement castedropdown = driver.findElement(castdropdownfield);
		castedropdown.click();		
		WebElement castsearchbox = driver.findElement(castsearchfield);
		castsearchbox.sendKeys(caste,Keys.ENTER);		
		WebElement jathakamdropdown = driver.findElement(Jadhakamdropdown);
		jathakamdropdown.click();
		WebElement jathakamsearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(Jadhakamsearchfield));
		jathakamsearchBox.sendKeys(jathakam,Keys.ENTER);		
		WebElement stardropdown = driver.findElement(stardropdownfield);
		stardropdown.click();
		WebElement starsearchinput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		starsearchinput.sendKeys(starvalue,Keys.ENTER);
		WebElement rasidropdown = driver.findElement(rashidropdown);
		rasidropdown.click();
		WebElement rasiinput = wait.until(ExpectedConditions.visibilityOfElementLocated(rashisearchfiled));
		rasiinput.sendKeys(rasivalue,Keys.ENTER);
		WebElement religionsaveButton = wait.until(ExpectedConditions.elementToBeClickable(religionsavebutton));
		religionsaveButton.click();
		WebElement closebutton = driver.findElement(closepopup);
		js.executeScript("arguments[0].click();",closebutton);	
	}

	// @Test(priority=4) //career information
	public void educationinformation() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1400)");
		WebElement editcareerfield = driver.findElement(editcareer);
		js.executeScript("arguments[0].click();",editcareerfield);		
		driver.findElement(coursename).sendKeys(cousrename);
		driver.findElement(university_name).sendKeys(university);
		driver.findElement(placename).sendKeys(place);
		driver.findElement(Year).sendKeys(yearvalue);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement addbutton = wait.until(ExpectedConditions.elementToBeClickable(addbuttonfield));
		addbutton.click();		
		js.executeScript("window.scrollBy(0,100)");		
		WebElement saveeducationInfobutton = driver.findElement(Saveducation);
		saveeducationInfobutton.click();		
		WebElement okbutton = wait.until(ExpectedConditions.elementToBeClickable(popupOkbuttonfield));
		okbutton.click();		
		js.executeScript("window.scrollBy(0,-400)");		
	}

	 //@Test(priority=5)//family details
	public void familyinfo() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		js.executeScript("window.scrollBy(0,1600)");
		Thread.sleep(300);
		WebElement editfamilyinfobutton = driver.findElement(editfamilydetailsfield);
		editfamilyinfobutton.click();
		WebElement fathernameinput = wait.until(ExpectedConditions.visibilityOfElementLocated(fathernameinputfield));
		fathernameinput.clear();
		fathernameinput.sendKeys(fathername);
		WebElement mothernameinput = wait.until(ExpectedConditions.visibilityOfElementLocated(mothernameinputfield));
		mothernameinput.clear();
		mothernameinput.sendKeys(mothername);
		WebElement fatherjobdropdown = driver.findElement(fatherjobdropdownfield);
		fatherjobdropdown.click();
		WebElement jobsearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		jobsearchBox.sendKeys(job_name,Keys.ENTER);
		WebElement motherJobDropdown = driver.findElement(motherjobdropdown);
		motherJobDropdown.click();
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(300);
		WebElement motherjobsearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		motherjobsearchBox.sendKeys(motherjobvalue,Keys.ENTER);
		WebElement fatherJobcategory = driver.findElement(Fatherjobcategory);
		fatherJobcategory.click();
		WebElement jobcategorysearchbox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		jobcategorysearchbox.sendKeys(jobcategoryvalue,Keys.ENTER);
		WebElement motherjobcategory = driver.findElement(motherjobcategoryfield);
		motherjobcategory.click();
		WebElement motherjobcategorysearchbox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		motherjobcategorysearchbox.sendKeys(motherjobcateogory,Keys.ENTER);
		WebElement fathereducationdropdown = driver.findElement(fathereducationdropdownfield);
		fathereducationdropdown.click();
		WebElement educationsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		educationsearch.sendKeys(fathereducationvalue,Keys.ENTER);
		WebElement mothereducationdropdown = driver.findElement(mothereducationdropdownfield);
		mothereducationdropdown.click();
		WebElement mothereducationsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		mothereducationsearch.sendKeys(mothereducationvalue,Keys.ENTER);
		WebElement fathereducationdetailsdropdown = driver.findElement(fathereducationdetailsfield);
		fathereducationdetailsdropdown.click();
		WebElement fathereducationdetail = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		fathereducationdetail.sendKeys(fathereducationdetails,Keys.ENTER);
		WebElement mothereducationdetaildropdown = driver.findElement(mothereducationdetailsfield);
		mothereducationdetaildropdown.click();
		WebElement mothereducationdetail = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		mothereducationdetail.sendKeys(mothereducationdetails,Keys.ENTER);
		js.executeScript("window.scrollBy(0,100)");		
		WebElement familyvaluedropdown = driver.findElement(familyvaluedropdownfield);
		familyvaluedropdown.click();
		WebElement familyvaluesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		familyvaluesearch.sendKeys(familyvalue,Keys.ENTER);
		WebElement famTypeDropdown = driver.findElement(Familytypedropdownfield);
		famTypeDropdown.click();
		WebElement familytypesearchbox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		familytypesearchbox.sendKeys(familytype,Keys.ENTER);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(200);
		WebElement financialdropdown = driver.findElement(financialdropdownfield);
		financialdropdown.click();
		WebElement financialdropdownsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		financialdropdownsearch.sendKeys(financialstatus,Keys.ENTER);
		WebElement familyinfosavebutton = driver.findElement(familyinfosavebuttonfield);
		familyinfosavebutton.click();		
	}

	@Test (priority=6)//career information
	public void careerinformation() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1700)");
		Thread.sleep(300);
		WebElement careerinfoedit = driver.findElement(Careerinfoeditbutton);
		js.executeScript("arguments[0].click();",careerinfoedit);		
		WebElement occupationdropdown = driver.findElement(Occupationdropdown);
		occupationdropdown.click();
		WebElement occupationsearchbox = driver.findElement(Occupationsearchbox);
		occupationsearchbox.click();
		occupationsearchbox.sendKeys(occupation,Keys.ENTER);
		WebElement employedropdown = driver.findElement(employedropdownfield);
		employedropdown.click();
		WebElement EmployeedropsearchBox = driver.findElement(employeesearchbox);
		EmployeedropsearchBox.click();
		EmployeedropsearchBox.sendKeys(employeedropdown,Keys.ENTER);
		WebElement companyname = driver.findElement(Companyname);
		companyname.sendKeys(companynamevalue);
		WebElement designation = driver.findElement(designationfield);
		designation.sendKeys(designationvalue);
		WebElement place = driver.findElement(Placename);
		place.sendKeys(placenamevalue);
		WebElement Year = driver.findElement(year);
		Year.sendKeys(educationstartyear);
		WebElement Toyear = driver.findElement(toyear);
		Toyear.sendKeys(educationcompletionyear);	
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(100);
		WebElement careeraddbutton = driver.findElement(Careerinfofield);
		js.executeScript("arguments[0].click();",careeraddbutton);
		WebElement careerSavebutton = driver.findElement(Careersavefield);
		js.executeScript("arguments[0].click();",careerSavebutton);					
	}

	 @Test(priority=5)//partner preference
	public void partnerpreference() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		js.executeScript("window.scrollBy(0,2900)");		
		WebElement editbutton = driver.findElement(partnerpreferencefield);
		js.executeScript("arguments[0].click();",editbutton);
		WebElement heightFeetdropdown = driver.findElement(heightfeetdropdownfield);
		heightFeetdropdown.click();
		WebElement heightfeetdropdownsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		heightfeetdropdownsearch.sendKeys(partnerheightvalue,Keys.ENTER);
		WebElement heighttodropdown = wait.until(ExpectedConditions.elementToBeClickable(heighttodropdownfield));
		heighttodropdown.click();
		WebElement heighttosearchfield = wait.until(ExpectedConditions.visibilityOfElementLocated(searchfield));
		heighttosearchfield.sendKeys(partnerheighttovalue,Keys.ENTER);
		WebElement basicinfosavebutton = wait.until(ExpectedConditions.elementToBeClickable(basicinfosavebuttonfield));
		basicinfosavebutton.click();		
		js.executeScript("window.scrollBy(0,800)");
		WebElement locationpreferenceditbutton = driver.findElement(locationpreferenceeditbuttonfield);
		js.executeScript("arguments[0].click();",locationpreferenceditbutton);		
		WebElement editotherpreferencebutton = driver.findElement(otherpreferencesfield);
		js.executeScript("arguments[0].scrollIntoView(true);",editotherpreferencebutton);
		js.executeScript("arguments[0].click();",editotherpreferencebutton);
		WebElement otherComments = driver.findElement(addcomments);
		otherComments.clear();
		otherComments.sendKeys(partnerdecription);
		js.executeScript("window.scrollBy(0,200)");
		WebElement otherpreferencesavebutton = driver.findElement(Otherpreferencesavebutton);
		js.executeScript("arguments[0].click();",otherpreferencesavebutton);
	}
}
