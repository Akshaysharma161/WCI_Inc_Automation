package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import pageObjects.POMPublicHomePage;
import resources.Common_Methods;
import resources.base;

public class PublicHomePage extends base {
	public WebDriver driver;
	ExtentTest extent;
	Common_Methods common;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void Login_Sponsor_California() throws InterruptedException {
		driver.get(config.getBaseUrl());
		driver.manage().window().maximize();
		Thread.sleep(3000);
		POMPublicHomePage login = new POMPublicHomePage(driver);
		login.sponsorLoginCa();
		Thread.sleep(5000);
		login.handleSecurityQue();
		login.clickOnnext();		
	}

	@Test(priority = 2)
	public void Login_FSA_California() throws InterruptedException {
		driver.get(config.getBaseUrl());
		driver.manage().window().maximize();
		Thread.sleep(5000); 
		POMPublicHomePage login = new POMPublicHomePage(driver);
		login.FSALoginCa();
		Thread.sleep(2000);
		login.handleSecurityQue();
		login.clickOnnext();
	}

	@Test(priority = 3)
	public void Login_MM_California() throws InterruptedException {
		driver.get(config.getBaseUrl());
		driver.manage().window().maximize();
		Thread.sleep(5000);
		POMPublicHomePage login = new POMPublicHomePage(driver);
		login.MMLoginCa();
		Thread.sleep(2000);
		login.handleSecurityQue();
		login.clickOnnext();
	}

	@Test(priority = 4)
	public void Login_EA_California() throws InterruptedException {
		driver.get(config.getBaseUrl());
		driver.manage().window().maximize();
		Thread.sleep(5000);
		POMPublicHomePage login = new POMPublicHomePage(driver);
		login.EALoginCa();
		Thread.sleep(2000);
		login.handleSecurityQue();
		login.clickOnnext();
		
	}
}
