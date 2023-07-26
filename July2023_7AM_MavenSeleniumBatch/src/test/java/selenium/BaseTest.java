package selenium;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static FileInputStream fis;
	public static String projectPath = System.getProperty("user.dir");
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orProp;
	
	public static void init() throws Exception
	{
		System.out.println(System.getProperty("user.dir"));
		//FileInputStream fis = new FileInputStream("D:\\April2022WD\\July2023_7AM_MavenSeleniumBatch\\src\\test\\resources\\data.properties");
		 fis = new FileInputStream(projectPath +"\\src\\test\\resources\\data.properties");
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
	
	public static void launch(String browserType)
	{
		if(p.getProperty(browserType).equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(p.getProperty(browserType).equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(p.getProperty(browserType).equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(childProp.getProperty(url));
		//driver.navigate().to(url);
	}
	
	public static void clickElement(String locatorkey) {
		//driver.findElement(By.xpath(orProp.getProperty(locatorkey))).click();
		getElement(locatorkey).click();
	}

	public static void typeText(String locatorkey, String text) {
		//driver.findElement(By.name(orProp.getProperty(locatorkey))).sendKeys(text);
		getElement(locatorkey).sendKeys(text);
	}

	public static void selectOption(String locatorkey, String option) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorkey))).sendKeys(option);
		getElement(locatorkey).sendKeys(option);
	}
	
	public static WebElement getElement(String locatorkey) 
	{
		WebElement element = null;
		
		if(locatorkey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorkey)));
		}
		
		return element;
	}

}
