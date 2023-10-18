package testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.ExtentManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class RegTest 
{
	ExtentReports reports;
	ExtentTest test;
  
  @BeforeMethod
  public void init() 
  {
	  reports = ExtentManager.getInstance();
	  test = reports.createTest("RegTest");
  }
  
  @Test
  public void regTest() 
  {
	  test.log(Status.INFO, "Registration Stared");
	  test.log(Status.PASS, "Registration Ended");
  }

  @AfterMethod
  public void quit() 
  {
	  reports.flush();
  }

}
