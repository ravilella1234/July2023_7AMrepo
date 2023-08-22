package browserOptionspack;

import java.util.Collections;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
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
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		//option.addArguments("--disable-infobars");
		option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		//option.addArguments("--incognito");
		//option.addArguments("--proxy-server=http://192.168.10.1:1947");
		option.addArguments("--ignore-certificate-errors"); //https://expired.badssl.com/
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		//WebDriver driver = WebDriverManager.chromedriver().capabilities(option).create();
		
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		//driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
