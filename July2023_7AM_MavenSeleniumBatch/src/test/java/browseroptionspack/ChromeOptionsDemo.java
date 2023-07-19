package browseroptionspack;

import java.util.Collections;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsDemo 
{

	public static void main(String[] args) 
	{
		
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		//option.addArguments("--headless");
		option.addArguments("--disable-notifications");
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		//https://expired.badssl.com/
		option.addArguments("--ignore-certificate-errors");
		//option.addArguments("--proxy-server=http://192.168.10.1:1947");
		
		option.addArguments("--disable-infobars");
		option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);*/
		
		WebDriver driver = WebDriverManager.chromedriver().capabilities(option).create();
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "D:\\April2022WD\\July2023_7AM_MavenSeleniumBatch\\logs\\chrome.log");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		//driver.get("https://www.redbus.in/");
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
	}

}
