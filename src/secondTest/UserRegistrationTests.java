package secondTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class UserRegistrationTests {
  FirefoxDriver driver= new FirefoxDriver();
  String MainURL= "http://www.qa14.hq.noths.com";
//Wait at element level
  WebDriverWait wait = new WebDriverWait(driver, 20);
  
	@Test
public void NewUserCheckout () throws InterruptedException{
		String Email = RandomStringUtils.randomAlphabetic(7) + "@noths.com";
		String Password = "password123";
		
		driver.get(MainURL+ "/attic/product/silver-stars-ear-stud");  //Navigating to a Product
		driver.findElementById("add_to_cart").click(); //Adding a product to the cart
		WebElement ShoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shopping_buttons']/a[2]"))); //Wait for the button to appear
        ShoppingCart.click(); //Clicking checkout
        driver.findElementByXPath("//*[@id='edit_cart']/table/tbody[1]/tr[1]/td/table/tbody/tr/td[2]/span/button").click();  //Continue as a new customer
        driver.findElementById("button_new_customer").click();
        driver.findElementById("user_email").sendKeys(Email);//Enter an email address
        driver.findElementById("user_email_confirmation").sendKeys(Email); //Enter the same email address to confirm
        new Select(driver.findElementById("user_title")).selectByVisibleText("miss"); //Enter a title
        driver.findElementById("user_first_name").sendKeys("Rebekah"); //Enter a first name
        driver.findElementById("user_last_name").sendKeys("Bowen"); //Enter a last name
        new Select(driver.findElementById("user_telephone_alpha2")).selectByVisibleText("Mexico [52]"); //Enter a telephone dialling code
        driver.findElementById("user_password").sendKeys(Password); //Enter a telephone number
        driver.findElementById("user_password_confirmation").sendKeys(Password); //Enter a password
        driver.findElementById("button_continue").click(); //Enter a password confirmation
        driver.findElementById("address_new_address_post_code").sendKeys("IG80UL"); //Enter a postcode
        driver.findElementByXPath("//*[@id='new_address_form']/fieldset[1]/ol/li[2]/span/a").click(); //Find the'Find Address' button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='new_address_form']/fieldset[1]/ol/li[3]/span/select"))); //Wait for 'choose address' to appear 
        new Select(driver.findElementByXPath("//*[@id='new_address_form']/fieldset[1]/ol/li[3]/span/select")).selectByIndex(1); //Select the 1st item in the dropdown list
        driver.findElementByXPath("//*[@id='new_address_form']/fieldset[2]/input").click(); //Add the address
        driver.findElementById("button_continue").click(); //Select continue - to the payment page
        driver.findElementByXPath("//*[@id='content']/form/input").click(); //Select radio button
        driver.findElementById("payment_medium_payment_form_credit_card").click();
        new Select(driver.findElementByXPath("//*[@id='checkout_credit_card_attributes_type']")).selectByVisibleText("Visa Debit or Electron"); //Select the dropdown and select Visa
        driver.findElementById("checkout_credit_card_attributes_number").sendKeys("4263971921001307"); //Enter credit card number
        driver.findElementById("checkout_credit_card_attributes_name").sendKeys("Hans Peter Luhn"); // Enter cardholder name
        new Select(driver.findElementById("checkout_credit_card_attributes_expiry_month")).selectByVisibleText("2"); //Enter month of expiration
        new Select(driver.findElementById("checkout_credit_card_attributes_expiry_year")).selectByVisibleText("2018"); //Enter year of expiration
        driver.findElementById("checkout_credit_card_attributes_verification_value").sendKeys("999"); //Enter card CVV
        driver.findElementById("checkout_skip_3d_secure").click(); //Skip 3DS 
        driver.findElementById("process_payment_button").click(); //Click 'process payment' 
        Thread.sleep(2000);
        if (driver.getPageSource().contains("SUCCESSFUL")) {
        System.out.println("Test has Passed");
        } else {
        	System.err.println("Test has Failed!");
        }
	
        }

@AfterMethod
public void cleanup (){
driver.quit();
	
}

	
	
}
