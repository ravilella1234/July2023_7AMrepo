package com.selenium;

import com.aventstack.extentreports.Status;

public class TC_005 extends BaseTest
{
	
	public static void main(String[] args) throws Exception 
	{
		init();
		test =  report.createTest("TC_005");
		test.log(Status.INFO,"init the properties files...");
		
		//LB- 3.141.59 (or)4.11.0 , WDM-5.5.2
		launch("chromebrowser");
		test.log(Status.PASS, "Opening the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.FAIL, "Navigating to application url : " + childProp.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		test.log(Status.PASS, "Selecting option Books By using locator : " + orProp.getProperty("amazondropbox_id"));
		
		typeText("amazonserachtext_name","Harry Potter");
		test.log(Status.INFO, "Entered the text Harry Potter By using Locator :  "+ orProp.getProperty("amazonserachtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.PASS, "Clicked on element by Using locator : " + orProp.getProperty("amazonsearchbutton_xpath"));
		
		report.flush();
	}
}
