package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CommunicationManagement 
{
  @Test
  public void checkMailConfirmation(ITestContext context) 
  {
	  String bookingID = (String)context.getAttribute("bID");
	  System.out.println("checkMailConfirmation : " +  bookingID);
  }
  
  @Test
  public void checkMobileConfirmation(ITestContext context) 
  {
	  String bookingID = (String)context.getAttribute("bID");
	  System.out.println("checkMobileConfirmation : " +  bookingID);
  }
}
