package selenium;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		selectOption("amazonserchdropbox_id","Books");
		
		typeText("amazonserchtext_name","Happy Potter");
		
		clickElement("amazonserchbutton_xpath");
			
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		/*WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		loc.sendKeys("Electronics");
		Thread.sleep(3000);
		loc.sendKeys("Books");*/
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Happy Potter");
		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	}

}
