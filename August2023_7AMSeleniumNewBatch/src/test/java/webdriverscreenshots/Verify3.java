package webdriverscreenshots;

import com.aventstack.extentreports.Status;
import com.selenium.BaseTest;

public class Verify3 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test =  report.createTest("Verify3");
		test.log(Status.INFO,"init the properties files...");
		
		//LB- 3.141.59 (or)4.11.0 , WDM-5.5.2
		launch("chromebrowser");
		test.log(Status.PASS, "Opening the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("googleurl");
		test.log(Status.PASS, "Navigating to application url : " + childProp.getProperty("googleurl"));
		
		
		//String actualLink = driver.findElement(By.linkText("Gmail")).getAttribute("innerHTML");
		String expectedLink = "gmail";
		
		if(!isLinksEqual(expectedLink))
			reportFailure("Both links are not equal...");
		else
			reportPass("Both links are equal...");
		
		report.flush();
			
	}

	

}
