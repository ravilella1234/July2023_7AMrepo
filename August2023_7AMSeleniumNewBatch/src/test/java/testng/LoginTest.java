package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.ExtentManager;

public class LoginTest 
{
  ExtentReports reports;
  ExtentTest test;
  
  @BeforeMethod
  public void init() 
  {
	  reports = ExtentManager.getInstance();
	  test = reports.createTest("LoginTest");
  }
  
  @Test
  public void loginTest() throws Exception 
  {
	  test.log(Status.INFO, "Starting testcase login");
	  test.log(Status.FAIL, "404 error");
	  test.addScreenCaptureFromPath("C:\\Users\\ravi\\Desktop\\G2.jpg");
	  test.log(Status.INFO, "Opening Browser");
	  test.log(Status.INFO, "logging In");
	  test.log(Status.INFO, "Test Passed");
  }

  @AfterMethod
  public void quit() 
  {
	  reports.flush();
  }

}
