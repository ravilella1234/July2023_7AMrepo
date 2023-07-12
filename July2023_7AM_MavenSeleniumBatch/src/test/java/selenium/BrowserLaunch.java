package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		
		WebDriver driver ;
		
		//webdriver.gecko.driver
		//webdriver.edge.driver
		//webdriver.ie.driver
		//System.setProperty("webdriver.chrome.driver", "C:/Users/ravi/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.amazon.in");
				
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ravi\\Downloads\\geckodriver-v0.33.0-win-aarch64 (1)\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 driver.get("https://www.bestbuy.com");
	}

}
