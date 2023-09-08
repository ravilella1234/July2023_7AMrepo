package webdriverscreenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy3 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().reset();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		//driver.findElement(By.linkText("Gmail")).click();
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getText());
		}
	}

}
