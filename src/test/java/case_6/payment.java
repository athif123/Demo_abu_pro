package case_6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Selenium_01.Case_Study.Driver;

public class payment {
	WebDriver driver;
	@BeforeTest
	  public void home() {
		 driver=Driver.getDriver("chrome");
		// driver.get("http://10.232.237.143:443/TestMeApp");
		  
	  }
  @Test(priority=2)
  public void payment_() {
	  
	 driver.get("http://10.232.237.143:443/TestMeApp/fetchProd.htm?val=home&catid=11290&subcatid=112101");
	  driver.findElement(By.linkText("Add to cart")).click();
      driver.findElement(By.linkText("Cart")).click();
	  driver.findElement(By.linkText("Checkout")).click();
	  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	  //ass
	  WebElement radio;
	  radio=driver.findElement(By.xpath("//input[@type='radio' and @value='HDFC Bank']"));
	  radio.click();
	  driver.findElement(By.linkText("Continue")).click();
	  driver.findElement(By.name("username")).sendKeys("asdfgh");
	  driver.findElement(By.name("password")).sendKeys("12345678");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
  }
//  @Test(priority=1)
//  public void doLogin() {
//	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	    driver.findElement(By.name("SignIn")).click();
//	    driver.findElement(By.name("userName")).sendKeys("vinu123");
//		driver.findElement(By.name("password")).sendKeys("123456");
//		driver.findElement(By.name("login")).click();	  
  }

