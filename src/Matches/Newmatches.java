package Matches;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Newmatches extends Matches_baseclass {
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
		driver.findElement(matchesfield).click();
	}

	// @Test
	public void profile_visibility_check() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> profileLinks = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(profilesdisplayed));
		Assert.assertTrue(profileLinks.size() > 0, "No profiles were found after clicking Matches.");
		System.out.println("Total profiles found: " + profileLinks.size());
	}

	// @Test
	public void profiletypefilterapply() {
		driver.findElement(onlywithphotofilter).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(profileimages));
		List<WebElement> profilePhotoAnchors = driver.findElements(profileimages);
		boolean allHaveImages = true;
		for (WebElement anchor : profilePhotoAnchors) // looping through each profile images
		{
			List<WebElement> imgs = anchor.findElements(profileimagefields);
			if (imgs.isEmpty() || imgs.get(0).getAttribute("src").trim().isEmpty()) {// checking if the image field is
																						// empty
				allHaveImages = false;
				break;
			}
		}
		Assert.assertTrue(allHaveImages, "One or more profiles are missing profile images!");
		System.out.println("All profiles contain images.");
	}

	// @Test
	public void single_filtercheck() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 120);");
		Thread.sleep(1000);
		driver.findElement(maritalstatusfield).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> viewProfileLinks = driver.findElements(viewprofilefield);
		for (int i = 0; i < viewProfileLinks.size(); i++) {
			viewProfileLinks = driver.findElements(viewprofilefield);
			WebElement link = viewProfileLinks.get(i);
			link.click();
			WebElement statusField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(maritalstatusprofilefield));
			String status = statusField.getText().trim();
			System.out.println("Profile " + (i + 1) + " Status: " + status);
			Assert.assertEquals(status, "Single", "Profile " + (i + 1) + " is NOT Single");
			driver.navigate().back();
			wait.until(ExpectedConditions.presenceOfElementLocated(viewprofilefield));
		}
		System.out.println("All profiles verified with status 'Single'.");
	}

	// @Test
	public void occupation() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 600);");
		Thread.sleep(1000);
		driver.findElement(occupationfield).click();
		{
			List<WebElement> occupationElements = driver.findElements(alloccupationfield);
			boolean allMatch = true;
			for (int i = 0; i < occupationElements.size(); i++) {
				String occupationText = occupationElements.get(i).getText().trim();
				System.out.println("Profile " + (i + 1) + " Occupation: " + occupationText);
				if (!occupationText.equals("Accounts/Finance Professional")) {
					allMatch = false;
					System.out.println("Mismatch found at profile " + (i + 1));
					break;
				}
			}
			Assert.assertTrue(allMatch, "One or more occupations are not 'Accounts/Finance Professional'");
			System.out.println("All occupations are 'Accounts/Finance Professional'");
		}
	}

	// @Test
	public void casefield() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(1000);
		driver.findElement(castfieldbornagain).click();
		js.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(1000);
		driver.findElement(castfieldknanya).click();
		js.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(1000);
		driver.findElement(castfieldpentagost).click();
		js.executeScript("window.scrollBy(0, 500);");
		Thread.sleep(1000);
		driver.findElement(castprotestant).click();
		List<WebElement> casteElements = driver.findElements(allcastfield);
		String expectedCaste = "Caste - Anglo Indian";
		boolean allCasteMatch = true;
		int profileIndex = 1;
		for (WebElement casteElement : casteElements) {
			String casteText = casteElement.getText().trim();
			System.out.println("Profile " + profileIndex + " caste: " + casteText);
			if (!casteText.equals(expectedCaste)) {
				System.out.println("Mismatch found at Profile " + profileIndex + ": " + casteText);
				allCasteMatch = false;
			}
			profileIndex++;
		}
		Assert.assertTrue(allCasteMatch, "One or more profiles have a caste different from 'Caste - Anglo Indian'");
	}

	// @Test
	public void complexionfilter() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.scrollBy(0, 1200);");
			Thread.sleep(1000);
			WebElement checkbox = driver.findElement(darkcomplextioncheckbox);
			js.executeScript("arguments[0].click();", checkbox);
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderfield));
			} catch (Exception ignored) {
			}
			for (int attempt = 0; attempt < 3; attempt++) {
				try {
					WebElement viewProfileLink = wait
							.until(ExpectedConditions.elementToBeClickable(profileLinkLocator));
					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", viewProfileLink);
					js.executeScript("arguments[0].click();", viewProfileLink);
					js.executeScript("window.scrollBy(0, 200);");
					Thread.sleep(100);
					WebElement complexionElement = wait
							.until(ExpectedConditions.visibilityOfElementLocated(complextionfield));
					String actualComplexion = complexionElement.getText().trim();
					System.out.println("Extracted complexion: " + actualComplexion);
					if (!actualComplexion.equalsIgnoreCase("Dark")) {
						throw new AssertionError(
								"Test Failed: Expected complexion to be 'Dark' but found '" + actualComplexion + "'");
					} else {
						System.out.println("Test Passed: Complexion is 'Dark'");
					}
					break; // success, exit loop
				} catch (StaleElementReferenceException e) {
					System.out.println("Retrying due to stale element... attempt " + (attempt + 1));
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Complexion test failed: " + e.getMessage());
		}
	}

	// @Test
	public void sendinterestbutton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200);");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {
			WebElement alreadySent = wait.until(ExpectedConditions.visibilityOfElementLocated(alreadyinterestedbutton));
			String dataInterested = alreadySent.getAttribute("data-interested");
			if ("Yes".equalsIgnoreCase(dataInterested)) {
				System.out.println("Profile already sent interested request.");
			} else {
				System.out.println("Button shows 'Interested' but attribute is not 'Yes'");
			}
		} catch (TimeoutException e) {
			WebElement sendInterestButton = wait.until(ExpectedConditions.elementToBeClickable(sendinterestbutton));
			sendInterestButton.click();
			System.out.println("Clicked on Send Interest button");
			wait.until(ExpectedConditions.textToBePresentInElement(sendInterestButton, "Interested"));
			System.out.println("Interest sent successfully.");
		}
	}

	// @Test
	public void cotactbuttonclick() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300);");
		Thread.sleep(1000);
		WebElement contactButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(contactbutton));
		contactButton.click();
		System.out.println("Clicked Contact button");
		Thread.sleep(2000);
		if (driver.getPageSource().contains("message-content")) {
			System.out.println("contact Popup window displayed successfully");
		} else {
			System.out.println("Popup not present in page source after click");
		}
	}

	@Test
	public void shortlistbuttonverifications() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(excludealreadycontacted).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(shortlistbuttonfield));
		List<WebElement> shortlistButtons = driver.findElements(shortlistbuttonfield);
		System.out.println("Total shortlist buttons found: " + shortlistButtons.size());
		Assert.assertTrue(shortlistButtons.size() > 0, "No shortlist buttons found");
		for (int i = 0; i < shortlistButtons.size(); i++) {
			WebElement button = shortlistButtons.get(i);
			String buttonText = button.getText().trim();
			if (!buttonText.equals("Shortlist")) {
				System.out.println("Mismatch found at index " + i + ": Found text -> '" + buttonText + "'");
				Assert.fail("Shortlist button shows incorrect text (e.g., already shortlisted) at index: " + i);
			}
			String receiverId = button.getAttribute("data-receiver");
			System.out.println("Verified Shortlist button at index " + i + ", Receiver ID: " + receiverId);
		}
		System.out.println("All shortlist buttons are correctly labeled as 'Shortlist'.");
	}

	// @Test
	public void excludealreadyviewedprofilecheck() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement initialprofilecount = wait
				.until(ExpectedConditions.visibilityOfElementLocated(initialprofilecountfield));
		String text = initialprofilecount.getText().trim();
		int initialCount = Integer.parseInt(text);
		System.out.println("Initial profile count is " +initialCount);
		driver.findElement(excludealreadyviewedfield).click();
		WebElement updatedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(updatedprofilecountfield));
		String updatedText = updatedElement.getText().trim();
		int updatedCount = Integer.parseInt(updatedText);
		System.out.println("Updated profile count is " + updatedCount);
		if (updatedCount < initialCount) {
			System.out.println("Test Passed: Updated count is less than initial count.");
		} else {
			throw new AssertionError("Test Failed: Updated count (" +updatedCount
					+ ") is NOT less than initial count (" + initialCount + ")");
		}
	}

	// @Test
	public void excludealreadycontactedprofilecheck() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.findElement(excludealreadycontacted).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(sendinterestbuttonfields));
		List<WebElement> sendInterestButtons = driver.findElements(sendinterestbuttonfields);
		System.out.println("Total profiles found with 'Send Interest' button: " +sendInterestButtons.size());
		Assert.assertTrue(sendInterestButtons.size() > 0, "No profiles found with 'Send Interest'!");
		for (int i = 0; i < sendInterestButtons.size(); i++) {
			WebElement button = sendInterestButtons.get(i);
			String buttonText = button.getText().trim();
			Assert.assertTrue(button.isDisplayed(), "'Send Interest' button not visible at index: " + i);
			if (!buttonText.equals("Send Interest")) {
				System.out.println("Mismatch at profile index " + i + ": Found text -> " + buttonText);
				Assert.fail("Unexpected button text at index " + i);
			}
		}

		System.out.println("All profiles have the correct 'Send Interest' button displayed.");
	}

	// @Test
	public void ageFilteringWithSlider() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement minHandle = wait.until(ExpectedConditions.presenceOfElementLocated(minimumagefilterhandler));
		Actions actions = new Actions(driver);
		actions.clickAndHold(minHandle).moveByOffset(30, 0).release().perform();// Change age filter to 27 to 29
		Thread.sleep(500);
		List<WebElement> profileElements = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(profileagefield));
		for (WebElement profile : profileElements) {
			String text = profile.getText().trim();
			if (!text.contains("Yrs")) {
				continue;
			}
			try {
				String ageString = text.split(" ")[0].trim(); // get "31"
				int age = Integer.parseInt(ageString);
				System.out.println("Displyed profile age : " + age);
				Assert.assertTrue(age >= 28 && age <= 31, "Profile age is out of range (28–31): " + age);
				System.out.println(" Age displayed in between 28-31");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}
