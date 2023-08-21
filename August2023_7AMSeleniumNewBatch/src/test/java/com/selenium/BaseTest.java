package com.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	public static FileInputStream fis;
	
	public static void init() throws Exception
	{
		System.out.println(projectPath);
		fis = new FileInputStream(projectPath+"\\src\\test\\resources\\data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath+"\\src\\test\\resources\\environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectPath+"\\src\\test\\resources\\"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		String url = childProp.getProperty("amazonurl");
		System.out.println(url);
	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			FirefoxOptions option = new FirefoxOptions();
			option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ravi\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver(option);
		}
		else if(p.getProperty(browser).equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(childProp.getProperty(url));
		//driver.navigate().to(url);
	}

}
