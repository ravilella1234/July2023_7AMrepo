package com.selenium;

import org.apache.log4j.Logger;

public class TC_004 extends BaseTest
{
	private static Logger log = Logger.getLogger(TC_004.class);
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("init the properties files...");
		
		//LB- 3.141.59 (or)4.11.0 , WDM-5.5.2
		launch("chromebrowser");
		log.info("Opening the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigating to application url : " + childProp.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		log.info("Selecting option Books By using locator : " + orProp.getProperty("amazondropbox_id"));
		
		typeText("amazonserachtext_name","Harry Potter");
		log.info("Entered the text Harry Potter By using Locator :  "+ orProp.getProperty("amazonserachtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on element by Using locator : " + orProp.getProperty("amazonsearchbutton_xpath"));
	}
}
