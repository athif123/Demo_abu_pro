package Selenium_01.Case_Study;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class demo {
	static WebDriver driver;
	  @BeforeTest
	  public void openBrowser() {
		  driver=Driver.getDriver("chrome");

//		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.04.30\\Desktop\\Drivers\\chromedriver.exe" );
//		  driver=new ChromeDriver();
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //Assert.assertEquals(driver.getTitle(),"TESTME" );
		  System.out.println("launched testme");
	  }
		  
	  
	  @Test (priority=1)
	  public void testLogin() {
 		  driver.findElement(By.linkText("SignIn")).click();
		  driver.findElement(By.name("userName")).sendKeys("kalam123");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abcd123");
		  driver.findElement(By.name("Login")).click();
//		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		  WebDriverWait wait = new WebDriverWait(driver,10);
//		  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("triptype")));
		  Assert.assertEquals(driver.getTitle(), "Home");
		  System.out.println("logged in successfully");
		  
	  }

	@Test (priority=2)
	public void AddtoCart() {
		Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.linkText("All Categories"))).build().perform();
	    //driver.findElement(By.linkText("Electronics")).click();;
         //driver.findElement(By.linkText("Head Phone")).click();
       driver.findElement(By.xpath("//*[@id='menu3']/li[2]/ul/li[1]/a/span")).click();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       driver.findElement(By.linkText("Head Phone")).click();
       
     //*[@id='submenuul11290']/li[1]/a/span
	  
	    driver.findElement(By.linkText("Add to cart")).click();
	      driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
	      //driver.findElement(By.xpath("//input[@class=' fa fa-shopping-cart']")).click();
		 /* driver.findElement(By.linkText("Checkout")).click();
		  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();//cart
		 // driver.close();
		  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  WebElement radio;                         // Payment GateWayPage
		  radio=driver.findElement(By.xpath("//input[@type='radio' and @value='HDFC Bank']"));
		  radio.click();
		  driver.findElement(By.linkText("Continue")).click();
		  driver.findElement(By.name("username")).sendKeys("qwerty1");
		  driver.findElement(By.name("password")).sendKeys("123456780");
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
		 
		*/
	}
}
	
  