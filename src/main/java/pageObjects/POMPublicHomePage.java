package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import resources.ObjectRepo;
import resources.base;

public class POMPublicHomePage extends base {

	public WebDriver driver;
	

	private By btnLogin = By.xpath("//span[text()='Log in']");
	private By username = By.xpath("//input[@id='enter_email']");
	private By password = By.xpath("//input[@id='enter_passphrase']");
	private By btnLogin2 = By.xpath("(//span[text()='Log in'])[2]");
	private By securityQue = By.xpath("//label[@class='MuiFormLabel-root Mui-required']");
	private By securityAnswer=By.xpath("//input[@class='MuiInputBase-input MuiInput-input']");
	private By btnNext = By.xpath("//span[contains(text(),'NEXT')]");

	public POMPublicHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void sponsorLoginCa() throws InterruptedException {
		driver.findElement(btnLogin).click();
		Thread.sleep(3000);
		driver.findElement(username).sendKeys(config.getUserSponsorCa());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "California sponsor login successfully");
	}
	
	public void sponsorLoginQc() throws InterruptedException {
		driver.findElement(btnLogin).click();
		
		driver.findElement(username).sendKeys(config.getUserSponsorQc());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Quebec sponsor login successfully");
	}
	
	public void sponsorLoginNs() throws InterruptedException {
		driver.findElement(btnLogin).click();
		driver.findElement(username).sendKeys(config.getUserSponsorNs());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Nova-Scotia sponsor login successfully");
	}
	
	public void FSALoginCa() throws InterruptedException {
		driver.findElement(btnLogin).click();
		driver.findElement(username).sendKeys(config.getUserFSACa());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "California FSA login successfully");
	}
	
	public void FSALoginQc() throws InterruptedException {
		driver.findElement(btnLogin).click();
		driver.findElement(username).sendKeys(config.getUserFSAQc());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Quebec FSA login successfully");
	}
	
	public void FSALoginNs() throws InterruptedException {
		driver.findElement(btnLogin).click();
		driver.findElement(username).sendKeys(config.getUserFSANs());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Nova-Scotia FSA login successfully");
	}
	/*
	 * Login Methods for MM for all jurisdiction 
	 * */
	
	public void MMLoginCa() throws InterruptedException {
		driver.findElement(btnLogin).click();
		driver.findElement(username).sendKeys(config.getUserMMCa());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "California MM login successfully");
	}
	
	public void MMLoginQc() throws InterruptedException {
		driver.findElement(btnLogin).click();
		driver.findElement(username).sendKeys(config.getUserMMQc());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Quebec MM login successfully");
	}
	
	public void MMLoginNs() throws InterruptedException {
		driver.findElement(btnLogin).click();
		driver.findElement(username).sendKeys(config.getUserMMNs());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Nova Scotia MM login successfully");
	}
	/*
	 * Login methods for all EA jurisdiction 
	 * */
	
	public void EALoginCa() throws InterruptedException {
		driver.findElement(btnLogin).click();
		driver.findElement(username).click();
		driver.findElement(username).sendKeys(config.getUserEACa());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "California EA login successfully");
	}
	
	public void EALoginQc() throws InterruptedException {
		driver.findElement(btnLogin).click();
		driver.findElement(username).sendKeys(config.getUserEAQc());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Quebec EA login successfully");
	}
	
	public void EALoginNs() throws InterruptedException {
		driver.findElement(btnLogin).click();
		driver.findElement(username).sendKeys(config.getUserEANs());
		driver.findElement(password).sendKeys(config.getPassWord());
		driver.findElement(btnLogin2).click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Nova Scotia EA login successfully");
	}
	
	public void clickOnnext( ) throws InterruptedException {

		WebElement abc = driver.findElement(btnNext);
		Actions action = new Actions(driver);
		action.moveToElement(abc).click().build().perform();
		action.click(abc).build().perform();
		
		
	}
/*
 *  Methods for handling security questions for all users 
 * */
	public void handleSecurityQue() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@class='MuiFormLabel-root Mui-required']")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		String str = driver.findElement(securityQue).getText().trim();
		System.out.println(str);
		
//		String str1 = "job?";
//		String str2 = "teacher?";
//		String str3 = "card?";
		
		if (str.contains("job?")) {
			driver.findElement(securityAnswer).sendKeys("Answer_1");
			
		} else if (str.contains("teacher?"))
		{
			driver.findElement(securityAnswer).sendKeys("Answer_2");
			
		} else if (str.contains("card?")) 
		{
			driver.findElement(securityAnswer).sendKeys("Answer_3");
			
		} else {
			System.out.println("None of the above security question");
		}
		
	}
	
}
