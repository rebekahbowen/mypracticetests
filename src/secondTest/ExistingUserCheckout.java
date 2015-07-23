
package secondTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExistingUserCheckout {
	  FirefoxDriver driver= new FirefoxDriver();
	  String MainURL= "http://www.qa14.hq.noths.com";
	//Wait at element level
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  
	@Test	
	public void NewUserCheckout () throws InterruptedException{
		String Email = RandomStringUtils.randomAlphabetic(7) + "@noths.com";
		String Password = "password123";
		
		login();
		
	driver.get(MainURL + "/kushdiforkids/product/i-was-charlotte-first-t-shirt" );
	//new Select(driver.findElementById("line_item_options_attributes_1_product_option_value_id_currency_GBP")).selectByVisibleText("Age 1-2");
	selectDropdown("line_item_options_attributes_1_product_option_value_id_currency_GBP","Age 1-2");
 	//new Select(driver.findElementById("line_item_options_attributes_2_product_option_value_id_currency_GBP")).selectByVisibleText("Red");
	selectDropdown("line_item_options_attributes_2_product_option_value_id_currency_GBP","Red");
	driver.findElementById("add_to_cart").click();
	WebElement ShoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shopping_buttons']/a[2]"))); //Wait for the button to appear
    ShoppingCart.click(); //Clicking checkout
	
	
	}
    public void login(){
    	driver.get(MainURL + "/session/new#login");
		driver.findElementById("email").sendKeys("admin@notonthehighstreet.com");
		driver.findElementById("password").sendKeys("logmein1");
		driver.findElementById("button_existing_customer").click();
    }
    
    public void selectDropdown(String id,String value){
    	 new Select(driver.findElementById(id)).selectByVisibleText(value);
    }
    
}
