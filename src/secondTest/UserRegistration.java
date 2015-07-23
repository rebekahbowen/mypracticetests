package secondTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistration {
	FirefoxDriver driver = new FirefoxDriver ();
	String MainURL= "http://www.qa14.hq.noths.com";

	@Test
	public void UserRegistrationTest () throws InterruptedException {
	String Email = RandomStringUtils.randomAlphabetic(7) + "@noths.com";
	driver.get(MainURL+"/user/new"); //Navigating to User Registration
	
	driver.findElementById("user_email").sendKeys(Email); //Entering in required details
	driver.findElementById("user_email_confirmation").sendKeys(Email);
	new Select(driver.findElementById("user_title")).selectByVisibleText("miss"); 
	driver.findElementById("user_first_name").sendKeys("Rebekah"); 
	driver.findElementById("user_last_name").sendKeys("Bowen"); 
	new Select(driver.findElementById("user_telephone_alpha2")).selectByVisibleText("Barbados [1]");
	driver.findElementById("user_telephone").sendKeys("07431222000");
	driver.findElementById("user_password").sendKeys("password123");
	driver.findElementById("user_password_confirmation").sendKeys("password123");
	driver.findElementById("user_default_billing_address_attributes_post_code").sendKeys("IG8 0UL"); //Enter a postcode
	driver.findElementByXPath("//*[@id='new_user']/div[3]/fieldset[1]/ol/li[2]/span/a").click(); //Click the Find Address button
	Thread.sleep(2000); //Sleep
	new Select(driver.findElementByXPath("//*[@id='new_user']/div[3]/fieldset[1]/ol/li[3]/span/select")).selectByIndex(1); //Select the first item in the list
	driver.findElementById("communication_preference_accepts_email").click();
	driver.findElementByXPath("//*[@id='new_user']/fieldset/input").click(); //Submitting the form
	if (driver.getPageSource().contains("Rebekah Bowen")) {
    System.out.println("Test has Passed");
    } else {
        System.err.println("Test has Failed!");
    } 
	
	}
}
