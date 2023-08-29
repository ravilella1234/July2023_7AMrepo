package com.selenium;

public class TC_003 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		//LB- 3.141.59 (or)4.11.0 , WDM-5.5.2
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		selectOption("amazondropbox_id","Books");
		
		typeText("amazonserachtext_name","Harry Potter");
		
		clickElement("amazonsearchbutton_xpath");
				
		
		/*WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		loc.sendKeys("Books");
		
		driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.className("nav-input nav-progressive-attribute")).click();
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();*/
	}

	
}
