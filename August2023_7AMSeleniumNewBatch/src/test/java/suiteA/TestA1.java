package suiteA;

import org.testng.annotations.Test;

public class TestA1 
{
  @Test
  public void testB1() throws Exception 
  {
	  System.out.println("Starting Test A1");
	  Thread.sleep(2000);
	  System.out.println("Ending Test A1");
  }
}
