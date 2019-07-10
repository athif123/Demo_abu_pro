package Case_1;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Selenium_01.Case_Study.Driver;

//import myPack.CompleteReport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class OnlineShoppingTest {
	ExtentReports extent;
	WebDriver drive;
	ExtentTest logger;

	@BeforeTest
	  public void openBrowser() {
		  drive=Driver.getDriver("Chrome");                                       //Launch Browser
	       drive.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");                 //URL into the Browser
		   drive.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		   System.out.println("launched testme");
	  }	
	
	
	
  @Test(priority=2)
  public void testLogin() {
	  logger = extent.startTest("passTest");
	  drive.findElement(By.name("userName")).sendKeys("Teamsec05");                       //Enter UserName
	  drive.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");     //Enter Password
	  drive.findElement(By.name("Login")).click();                                       //Click Login
	  Assert.assertEquals(drive.getTitle(), "Home");  
	  logger.log(LogStatus.PASS,"Test Case Passed is passTest");
  }
  
  @Test (priority = 5)
  public void endReportAfterTest(){
	      logger = extent.startTest("failTest");
	      drive=Driver.getDriver("chrome");                                      //Failure Payment GateWayPage
		  drive.get("http://10.232.237.143:443/PaymentGateway/getOrderDetails.htm");   
		  drive.findElement(By.xpath("//*[@id='swit']/div[1]/div/label")).click();
		  drive.findElement(By.id("btn")).click();
		  drive.findElement(By.name("username")).sendKeys("123456");
		  drive.findElement(By.name("password")).sendKeys("Pass@456");
		  drive.findElement(By.xpath("//input[@type='submit']")).click();
		  drive.findElement(By.xpath("//input[@type = 'submit' and @value='PayNow']")).click();
		  drive.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  Assert.assertEquals(drive.getTitle(), "Payment Gateway1");
		  logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
  }
  
  @Test(priority = 3)
  public void testCart(){
	      Actions act = new Actions(drive);
          act.moveToElement(drive.findElement(By.linkText("All Categories"))).build().perform();     //Select All Categories Module
	      drive.findElement(By.linkText("Electronics")).click();                                     //Select Item type from module
	      drive.findElement(By.linkText("Head Phone")).click();                                      //Select Item from Item type module
	      drive.findElement(By.linkText("Add to cart")).click();                                     //Add Items to cart
	      drive.findElement(By.xpath("//a[@href='displayCart.htm']")).click();                       // Select cart 
		  drive.findElement(By.linkText("Checkout")).click();                                        //Click CheckOut
		  drive.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();                   //Click Proceed to pay button to make payment
		  drive.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test (priority = 1)
  public void testRegistration(){
	  drive.findElement(By.linkText("SignUp")).click();                                             //Click SignUp to register user
	  drive.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  drive.findElement(By.name("userName")).sendKeys("Teamsec0050");                                   //Enter UserName
	  drive.findElement(By.name("firstName")).sendKeys("Team");			                            //Enter FirstName
	  drive.findElement(By.name("lastName")).sendKeys("two");                                       //Enter LastName
	  drive.findElement(By.name("password")).sendKeys("12345678");                                 //Enter password
	  drive.findElement(By.name("confirmPassword")).sendKeys("12345678");                           //Enter Confirm password
	  WebElement radio = drive.findElement(By.xpath("//input[@type='radio' and @value='Male']"));   //Select Gender
	  radio.click();
	  drive.findElement(By.name("emailAddress")).sendKeys("teamtwo@team.com");                      //Enter Email
	  drive.findElement(By.name("mobileNumber")).sendKeys("1234567890");                            //Enter mobile number
	  drive.findElement(By.name("dob")).sendKeys("01/01/1998");                                     //Enter DOB
	  drive.findElement(By.name("address")).sendKeys("coimbatore");                                 //Enter Address
	  Select sel=new Select(drive.findElement(By.name("securityQuestion")));                        //Select Security Question
	  sel.selectByVisibleText("What is your favour color?");                      
	  drive.findElement(By.name("answer")).sendKeys("White");                                       //Enter Answer for security question
	  drive.findElement(By.name("Submit")).click();                                                 //Click Register
	  
  }
  
  @Test
  public void startReportBeforeTest(){
	  extent = new ExtentReports(System.getProperty("user.dir")+ "/test-output/answer.html", true);
	  extent.addSystemInfo("Host Name", "TestMe");
	  extent.addSystemInfo("Environment", "Selenium Testing");
	  extent.addSystemInfo("User Name", "Shopiga");
	  
  }
  
  @Test(priority = 4)
  public void testPayment(){
	  logger = extent.startTest("passTest");
	  drive.findElement(By.xpath("//*[@id='swit']/div[1]/div/label")).click();                   //Select Bank name
	  drive.findElement(By.id("btn")).click();                                                   //Click Continue
	  drive.findElement(By.name("username")).sendKeys("123456");                                 //Enter transaction UserName
	  drive.findElement(By.name("password")).sendKeys("Pass@456");                               //Enter transaction Password
	  drive.findElement(By.xpath("//input[@type='submit']")).click();                            //Click submit
	  drive.findElement(By.xpath("//input[@type = 'submit' and @value='PayNow']")).click();      //Click PayNow
	  drive.findElement(By.name("transpwd")).sendKeys("Trans@456");                              //Enter transaction password
	  drive.findElement(By.xpath("//input[@type = 'submit' and @value='PayNow']")).click();      //Click PayNow to proceed to pay
	  Assert.assertEquals(drive.getTitle(), "Order Details");
	  logger.log(LogStatus.PASS,"Test Case Passed is passTest");
  } 
  
  
  
  @AfterMethod
  public void getResult(ITestResult result) throws Exception {
	  if(result.getStatus()==ITestResult.FAILURE){
		  logger.log(LogStatus.FAIL, "Test Case Failed is "+ result.getName());
		  logger.log(LogStatus.FAIL, "Test Case Failed is "+ result.getThrowable());
		  String screenshotPath = OnlineShoppingTest.getScreenshot(drive, result.getName());
		  logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));  
	  }
	  else if(result.getStatus()==ITestResult.SKIP){
		  logger.log(LogStatus.SKIP, "Test Case Skipped is "+ result.getName());		  
	  }
//	  if(result.getStatus()==ITestResult.SUCCESS){
//		  logger.log(LogStatus.PASS, "Test Case Pass is "+ result.getName());
//		  logger.log(LogStatus.PASS, "Test Case Pass is "+ result.getThrowable());
//		  String screenshotPath = OnlineShop.getScreenshot(drive, result.getName());
//		  logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));  
//	  }
//	  else if(result.getStatus()==ITestResult.SKIP){
//		  logger.log(LogStatus.SKIP, "Test Case Skipped is "+ result.getName());		  
//	  }
	  extent.endTest(logger);
	  extent.flush();
  }

  public static String getScreenshot(WebDriver drive,String screenshotName) throws Exception
  {
	 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 TakesScreenshot ts =(TakesScreenshot) drive;
	 File Source = ts.getScreenshotAs(OutputType.FILE);
	 String destination = System.getProperty("user.dir")+"/FailedScreenshots/"+ screenshotName + dateName +".png";
	 File finalDestination = new File(destination);
	 FileUtils.copyFile(Source, finalDestination);
	 return destination;	
  }

  @AfterTest
  public void afterTest() {
  }

}
