package browserOptionspack;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.firefox.ProfilesIni;

public class FirefoxOptionsDemo 
{

	public static void main(String[] args) 
	{
		FirefoxOptions option = new FirefoxOptions();
		option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		//option.addArguments("--headless");
		
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		option.addArguments("--private");
		
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//firefox.exe -p
		ProfilesIni allprofile = new ProfilesIni();
		FirefoxProfile profile = allprofile.getProfile("August2023FF");
		
		//about:config
		profile.setPreference("dom.webnotifications.enabled", false);
		
		//to ignore certificate errors
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		
		// Working with proxy Settings
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "192.168.0.1");
		profile.setPreference("network.proxy.socks_port", 1947);
		
		option.setProfile(profile);
		
		System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "C:\\Users\\ravi\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ravi\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(option);
		
		driver.get("https://www.amazon.in");
		System.out.println(driver.getTitle());
		
	}

}
