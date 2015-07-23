package myFirstTest;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
	FirefoxDriver driver = new FirefoxDriver();
	
  @Test
  public void OpenBrowser() {
	   driver.get("http://www.noths.com");
	   System.out.println("Page title is - " + driver.getTitle());
	   Assert.assertEquals(driver.getTitle(), "Some title Im expecting");
	   driver.quit();
	   
	   
	   
	   
	  
  }
  

  
  
}



