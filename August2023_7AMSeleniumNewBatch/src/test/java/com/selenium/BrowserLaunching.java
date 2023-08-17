package com.selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunching 
{

	public static void main(String[] args) 
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		
		//webdriver.gecko.driver
		//webdriver.ie.driver
		//webdriver.edge.driver
	}

}
