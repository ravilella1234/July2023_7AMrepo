package browseroptionspack;

import org.omg.IOP.ProfileIdHelper;
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
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		//options.addArguments("--headless");
		options.addArguments("--private");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//firefox.exe -p
		ProfilesIni allprofiles = new ProfilesIni();
		FirefoxProfile profile = allprofiles.getProfile("August2023FF");
		
		//about:config
		profile.setPreference("dom.webnotifications.enabled", false); 
		
		//To ignore certrificate errors 
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		
		//Working with proxy setting
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "192.168.10.1");
		profile.setPreference("network.proxy.socks_port", 1947);
		
		
		options.setProfile(profile);
		//WebDriver driver = WebDriverManager.firefoxdriver().capabilities(options).create();
		//WebDriverManager.firefoxdriver().setup();
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ravi\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");
		System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "C:\\Users\\ravi\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://www.amazon.in");
		System.out.println(driver.getTitle());

	}

}
