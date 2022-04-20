package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	public Properties Pro;

	public ConfigDataProvider() throws IOException {
		File src = new File("C:\\Users\\Akshay Sharma\\Demo Workspace\\WCI_Inc_Automation\\src\\main\\java\\resources\\config.properties");
		FileInputStream file = new FileInputStream(src);
		Pro = new Properties();
		Pro.load(file);
	} 
	public String getBrowser() 
	{
		return Pro.getProperty("Browser");
	}
	public String getBaseUrl() {
		return Pro.getProperty("BaseUrl");
	}
	public String getPassWord() {
		return Pro.getProperty("Password");
	}
	public String getUserSponsorCa() {
		return Pro.getProperty("UserSponsorCa");
	}
	public String getUserSponsorQc() {
		return Pro.getProperty("UserSponsorQc");
	}
	public String getUserSponsorNs() {
		return Pro.getProperty("UserSponsorNS");
	}	
	public String getUserMMCa() {
		return Pro.getProperty("UnameMMCa");
	}
	public String getUserMMQc() {
		return Pro.getProperty("UnameMMQc");
	}
	public String getUserMMNs() {
		return Pro.getProperty("UnameMMNS");
	}	
	public String getUserFSACa() {
		return Pro.getProperty("UnameFSACa");
	}
	public String getUserFSAQc() {
		return Pro.getProperty("UnameFSAQc");
	}
	public String getUserFSANs() {
		return Pro.getProperty("UnameFSANS");
	}	
	public String getUserEACa() {
		return Pro.getProperty("UnameEACa");
	}
	public String getUserEAQc() {
		return Pro.getProperty("UnameEAQc");
	}
	public String getUserEANs() {
		return Pro.getProperty("UnameEANS");
	}	
}

