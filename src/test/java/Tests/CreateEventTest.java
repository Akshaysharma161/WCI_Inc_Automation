package Tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.CreateEvent;
import pageObjects.POMPublicHomePage;
import resources.ObjectRepo;
import resources.base;

public class CreateEventTest extends base {
	
	
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test
	public void createNewEvent() throws InterruptedException {

		// Step1: Login By Sponsor(California) into the application
		driver.get(config.getBaseUrl());
		driver.manage().window().maximize();
		Thread.sleep(5000);
		POMPublicHomePage login = new POMPublicHomePage(driver);
		login.sponsorLoginCa();
		Thread.sleep(5000);
		login.handleSecurityQue();
		login.clickOnnext();
		ObjectRepo.test.log(Status.PASS, "Security Answer sent Successfully");
		// Step2 : Create event
		CreateEvent abc = new CreateEvent(driver);
		abc.createEvent();
		ObjectRepo.test.log(Status.PASS, "Event Created Successfully");
	}
}
