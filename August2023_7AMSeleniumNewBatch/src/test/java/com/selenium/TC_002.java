package com.selenium;

public class TC_002 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		launch("Chrome");
		
		navigateUrl("https://www.amazon.in");
	
		driver.manage().window().maximize();
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().back();
		
		Thread.sleep(5000);
		
		driver.navigate().forward();
		
		Thread.sleep(5000);
		
		driver.navigate().refresh();
		
		//driver.close();
		
		driver.quit();
	}
}
