package com.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orProp;
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
		
		fis = new FileInputStream(projectPath+"\\src\\test\\resources\\or.properties");
		orProp = new Properties();
		orProp.load(fis);
	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			FirefoxOptions option = new FirefoxOptions();
			option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ravi\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
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
	
	public static void clickElement(String locatorKey) 
	{
		//driver.findElement(By.xpath(locator)).click();
		getElement(locatorKey).click();
	}

	public static void typeText(String locatorKey, String text) 
	{
		//driver.findElement(By.name(locator)).sendKeys(text);
		getElement(locatorKey).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		//driver.findElement(By.id(locator)).sendKeys(option);
		getElement(locatorKey).sendKeys(option);
		
	}
	
	public static WebElement getElement(String locatorKey)
	{
		WebElement element = null;
		
		//check for element present
		if(!isElementPresent(locatorKey))
			//Report the failure
			System.out.println("Element is not present : " + locatorKey);
		
		element = driver.findElement(getLocator(locatorKey));
		/*if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}*/
		return element;
	}

	public static boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Checking for Element Present : " + locatorKey);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		
		/*if(locatorKey.endsWith("_id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_name")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_classname")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_xpath")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_css")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_linktext")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orProp.getProperty(locatorKey))));
		}*/
		
		return true;
	}
	
	public static By getLocator(String locatorKey)
	{
		By by = null;
		if(locatorKey.endsWith("_id")) {
			by = By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_classname")) {
			by = By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by = By.xpath(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by = By.cssSelector(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linktext")) {
			by = By.linkText(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(orProp.getProperty(locatorKey));
		}
		
		return by;
	}

}
