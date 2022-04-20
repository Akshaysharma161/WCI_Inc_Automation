package pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class CreateEvent extends base {
	public String randomString;

	public static Actions action;
	private By btnAdminstration = By.xpath("//span[text()='Administration']");
	private By btnEvent = By.xpath("//a[text()='Event']");
	private By btnCreateEvent = By.xpath("//span[text()='CREATE NEW EVENT']");
	private By textBoxEventID = By.xpath("//input[@id='eventId']");
	private By eventTypeDropDown = By.xpath("//select[@id='demo-customized-select']");
	private By eventName = By.xpath("//input[@id='eventNameInEnglish']");
	private By ParticipatingJurisdictions = By.xpath("//div[@id='demo-customized-select']");
	private By btnCalifornia = By.xpath("//*[@id='menu-participatingJurisdictions']//ul/li[2]");
	private By btnQuebec = By.xpath("//*[@id='menu-participatingJurisdictions']//ul/li[3]");
	private By frenchEventName = By.xpath("//*[@id='eventNameInFrench']");
	private By currencyAcc = By.xpath("(//div[@id='demo-customized-select'])[2]");
	private By tagUSD = By.xpath("//*[@id='menu-']/div[3]/ul/li[2]");
	private By tagCAD = By.xpath("//*[@id='menu-']/div[3]/ul/li[3]");
	private By textBoxUSD = By.xpath("//input[@name='USD']");
	private By textBoxCAD = By.xpath("//input[@name='CAD']");
	private By dropDownVintage1 = By.xpath("(//*[@name='vintages'])[1]");
	private By dropDownVintage2 = By.xpath("(//*[@name='vintages'])[2]");

	private By textBoxVintage1 = By.xpath("(//input[@name='vintagesAllowancesAvailable'])[1]");
	private By textBoxVintage2 = By.xpath("(//input[@name='vintagesAllowancesAvailable'])[2]");
	private By drpdownVintageType1 = By.xpath("(//select[@name='vintageType'])[1]");
	private By drpdownVintageType2 = By.xpath("(//select[@name='vintageType'])[2]");
	private By drpdownProCessOrder1 = By.xpath("(//select[@name='processingOrder'])[1]");
	private By drpdownProCessOrder2 = By.xpath("(//select[@name='processingOrder'])[2]");

	private By dateBiddingPeroidOpen = By.xpath("(//input[@placeholder='Date'])[1]");
	private By dateBiddingPeriodClose = By.xpath("(//input[@placeholder='Date'])[2]");
	private By dateEventAppOpen = By.xpath("(//input[@placeholder='Date'])[3]");
	private By dateEventAppClose = By.xpath("(//input[@placeholder='Date'])[4]");
	private By dateBidGuaranteesubDeadline = By.xpath("(//input[@placeholder='Date'])[5]");
	private By dropdownBidderConfe = By.xpath("//select[@name='biddersConferenceJurisdiction']");
	private By dateBidResultAvail = By.xpath("(//input[@placeholder='Date'])[6]");
	private By dateEventClosure = By.xpath("(//input[@placeholder='Date'])[7]");
	private By dateFinantialSettlement = By.xpath("(//input[@placeholder='Date'])[8]");
	private By dateBidderConference = By.xpath("(//input[@placeholder='Date'])[9]");

	private By dropdownAlgorithm = By.xpath("//select[@name='algorithm']");
	private By btnSave = By.xpath("//span[text()='SAVE']");

	// private By btnAlert = By.xpath("(//button[@type='button'])[16]");
	private By eventDetailsBtn = By.xpath("//*[@id='event-list']/table/tbody/tr[1]/td[9]");
	private By btnApproveCal = By.xpath("//button[@aria-label='approval1Status']");
	private By btnApprovalQue = By.xpath("//button[@aria-label='approval2Status']");
	private By btnSubmit1 = By.xpath("(//span[text()='SUBMIT'])[1]");
	private By btnSubmit2 = By.xpath("(//span[text()='SUBMIT'])[2]");
	private By btnAlert2 = By.xpath("(//button[@type='button'])[15]");
	private By btnProfile = By.xpath("//span[contains(text(),'Welcome, ')]");
	private By btnLogout = By.xpath("//li[text()='Logout']");

	public CreateEvent(WebDriver driver) {
		CreateEvent.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void generateString() {
	    int length = 12;
	    boolean useLetters = true;
	    boolean useNumbers = true;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	    randomString =("Event_"+generatedString);
	}


	public void createEvent() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clickbtnAdmin();
		Thread.sleep(5000);
		clickbtnEvent();
		clickbtnCreateEvent();

		// EVENT BASICS
		generateString();
		gettextBoxEvent(); // Event Id
		selectEventTypeFromDropDown();
		enterEventName();
		selectJurisdiction();
		Thread.sleep(3000);

		// EVENT DETAILS
		currencyAcc();
		selectVintage();
		selectVintageType();
		selectProcessingOrder(); // Dates and Times
		selectDates();
		selectAlgorithm();
	}

	public void CaliforniaJuridictionApprovalForEventCreation() throws InterruptedException {

//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(btnAlert));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

//		Thread.sleep(5000);
//		clickbtnAdmin();
//		Thread.sleep(3000);
//		clickbtnEvent();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
//		WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(eventDetailsBtn));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		driver.findElement(eventDetailsBtn).click();

//		JavascriptExecutor js =(JavascriptExecutor)driver;
//		js.executeScript("Window.scrollBy(0,1000)");
		Thread.sleep(8000);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnApproveCal));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		driver.findElement(btnApproveCal).click();
		Thread.sleep(2000);
		driver.findElement(btnSubmit1).click();
		Thread.sleep(5000);
//		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(btnAlert2));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
//		// driver.findElement(btnAlert2).click();

		// logout
		driver.findElement(btnProfile).click();
		driver.findElement(btnLogout).click();

	}

	public void clickbtnAdmin() throws InterruptedException {
		// new WebDriverWait(driver,
		// 40).until(ExpectedConditions.invisibilityOfElementLocated(btnAdminstration));
		WebElement abc = driver.findElement(btnAdminstration);
		action = new Actions(driver);
		action.moveToElement(abc).build().perform();
		Thread.sleep(3000);
		action.clickAndHold(abc).build().perform();
		action.click(abc).build().perform();

	}

	public void clickbtnEvent() throws InterruptedException {
		WebElement abc1 = driver.findElement(btnEvent);
		action.moveToElement(abc1).build().perform();
		Thread.sleep(3000);
		action.clickAndHold(abc1).build().perform();
		action.click(abc1).build().perform();
	}

	public void clickbtnCreateEvent() {
		driver.findElement(btnCreateEvent).click();
	}

	public void gettextBoxEvent() {
		driver.findElement(textBoxEventID).sendKeys(randomString);
	}

	public void selectEventTypeFromDropDown() {
		WebElement eventType = driver.findElement(eventTypeDropDown);
		Select s = new Select(eventType);
		s.selectByVisibleText("Auction");
	}

	public void enterEventName() {
		driver.findElement(eventName).sendKeys("DemoEt2");
	}

	public void selectJurisdiction() throws InterruptedException {
		driver.findElement(ParticipatingJurisdictions).click();
		driver.findElement(btnCalifornia).click();
		driver.findElement(btnQuebec).click();

		WebElement abc2 = driver.findElement(frenchEventName);
		action.moveToElement(abc2).build().perform();
		Thread.sleep(3000);
		action.clickAndHold(abc2).build().perform();
		action.click(abc2).build().perform();
		driver.findElement(frenchEventName).sendKeys("ABC");
	}

	public void currencyAcc() throws InterruptedException {
		WebElement abc3 = driver.findElement(currencyAcc);
		action.moveToElement(abc3).click().build().perform();
		driver.findElement(tagUSD).click();
		driver.findElement(tagCAD).click();
		WebElement abc4 = driver.findElement(textBoxUSD);
		action.moveToElement(abc4).click().build().perform();
		Thread.sleep(3000);
		action.clickAndHold(abc4).build().perform();
		action.click(abc4).build().perform();
		driver.findElement(textBoxUSD).sendKeys("10");
		driver.findElement(textBoxCAD).sendKeys("11.15");
	}

	public void selectVintage() {
		WebElement dropdownvint = driver.findElement(dropDownVintage1);
		Select select = new Select(dropdownvint);
		select.selectByVisibleText("2022");
		WebElement dropdownvint2 = driver.findElement(dropDownVintage2);
		Select select1 = new Select(dropdownvint2);
		select1.selectByVisibleText("2024");
		driver.findElement(textBoxVintage1).sendKeys("10000");
		driver.findElement(textBoxVintage2).sendKeys("5000");
	}

	public void selectVintageType() {
		WebElement dropdownvintType = driver.findElement(drpdownVintageType1);
		Select select = new Select(dropdownvintType);
		select.selectByVisibleText("Current");
		WebElement dropdownvintType1 = driver.findElement(drpdownVintageType2);
		Select select1 = new Select(dropdownvintType1);
		select1.selectByVisibleText("Advance");
	}

	public void selectProcessingOrder() {
		WebElement dropdownProOrder = driver.findElement(drpdownProCessOrder1);
		Select select = new Select(dropdownProOrder);
		select.selectByVisibleText("1");
		WebElement dropdownProOrder1 = driver.findElement(drpdownProCessOrder2);
		Select select1 = new Select(dropdownProOrder1);
		select1.selectByVisibleText("2");
	}

	public void selectDates() throws InterruptedException {
		driver.findElement(dateBiddingPeroidOpen).click();
		driver.findElement(dateBiddingPeroidOpen).sendKeys("20 Apr 2022 06:40");
		driver.findElement(dateBiddingPeriodClose).click();
		driver.findElement(dateBiddingPeriodClose).sendKeys("20 Apr 2022 06:45");
		driver.findElement(dateEventAppOpen).click();
		driver.findElement(dateEventAppOpen).sendKeys("20 Apr 2022 06:38");
		driver.findElement(dateEventAppClose).click();
		driver.findElement(dateEventAppClose).sendKeys("20 Apr 2022 06:39");
		// driver.findElement(dateBidGuaranteesubDeadline).click();
		// driver.findElement(dateBidGuaranteesubDeadline).sendKeys("19 Apr 2022
		// 06:25");
//
//		WebElement dropdownBidderConfer = driver.findElement(dropdownBidderConfe);
//		Select select1 = new Select(dropdownBidderConfer);
//		select1.selectByVisibleText("All");
//
//		driver.findElement(dateBidderConference).click();
//		driver.findElement(dateBidderConference).sendKeys("19 Apr 2022 06:19");
//
//		driver.findElement(dateBidResultAvail).click();
//		driver.findElement(dateBidResultAvail).sendKeys("19 Apr 2022 06:40");
//		driver.findElement(dateEventClosure).click();
//		driver.findElement(dateEventClosure).sendKeys("19 Apr 2022 06:45");
//		driver.findElement(dateFinantialSettlement).click();
//		driver.findElement(dateFinantialSettlement).sendKeys("19 Apr 2022 06:43");

	}

	public void selectAlgorithm() {
		WebElement dropdownAlg = driver.findElement(dropdownAlgorithm);
		Select select1 = new Select(dropdownAlg);
		select1.selectByVisibleText("Algorithm for Individual/Joint Auctions");
		driver.findElement(btnSave).click();
	}
}
