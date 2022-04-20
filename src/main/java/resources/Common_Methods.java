package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Common_Methods {
	public WebDriver driver;

//	private By btnLogin = By.xpath("//span[text()='Log in']");
	private By btnHome = By.xpath("//*[contains(text(),'Home')]"); 
	
	public Common_Methods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean privateHomePageLoaded(){
		 new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(btnHome));
		 String str = driver.findElement(btnHome).getText();
		 Assert.assertEquals(str, "Home");
		 return true;
        
   }
}
