package testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selenium.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_003 extends BaseTest
{
	
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void startProcess(String btype) throws Exception 
  {
	  System.out.println("start Process");
	    init();
		test =  report.createTest("TC_005");
		test.log(Status.INFO,"init the properties files...");
		
		//LB- 3.141.59 (or)4.11.0 , WDM-5.5.2
		launch(btype);
		test.log(Status.PASS, "Opening the Browser : " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.FAIL, "Navigating to application url : " + childProp.getProperty("amazonurl"));	  
  }
  
  @Test(groups = {"regression","sanity"})
  public void amazonTest() 
  {
	  System.out.println("Amazontest");
	    selectOption("amazondropbox_id","Books");
		test.log(Status.PASS, "Selecting option Books By using locator : " + orProp.getProperty("amazondropbox_id"));
		
		typeText("amazonserachtext_name","Harry Potter");
		test.log(Status.INFO, "Entered the text Harry Potter By using Locator :  "+ orProp.getProperty("amazonserachtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.PASS, "Clicked on element by Using locator : " + orProp.getProperty("amazonsearchbutton_xpath"));
  }

  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess()
  {
	  System.out.println("end process");
	  report.flush();
	  driver.quit();
  }

}
