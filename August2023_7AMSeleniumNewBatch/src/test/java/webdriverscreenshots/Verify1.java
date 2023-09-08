package webdriverscreenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify1 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().reset();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		 //String actualLink = driver.findElement(By.linkText("Gmail")).getText();
		String actualLink = driver.findElement(By.linkText("Gmail")).getAttribute("innerHTML");
		 String expectedLink = "Gmail";
		 
		 System.out.println("Actual Link : "+actualLink );
		 System.out.println("Expected Link : "+expectedLink );
		 
		 if(actualLink.equals(expectedLink))
			 System.out.println("Both links are equal..");
		 else
			 System.out.println("Both links are not equal...");
	}

}
