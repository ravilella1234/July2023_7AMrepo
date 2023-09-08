package webdriverscreenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify2 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().reset();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		driver.findElement(By.id("APjFqb")).sendKeys("hyderabad");
		String text = driver.findElement(By.id("APjFqb")).getAttribute("value");
		//String text = driver.findElement(By.id("APjFqb")).getText();
		System.out.println("Text : " +  text);
	}

}
