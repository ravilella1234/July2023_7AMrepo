package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	
	public static void launch(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			FirefoxOptions option = new FirefoxOptions();
			option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ravi\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver(option);
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(url);
		//driver.navigate().to(url);
	}

}
