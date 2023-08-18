package com.selenium;

public class TC_002 extends BaseTest
{

	public static void main(String[] args) 
	{
		launch("Chrome");
		
		navigateUrl("https://www.bestbuy.com");
	}

}
