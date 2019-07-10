package Selenium_01.Case_Study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	static WebDriver driver;
	public static WebDriver getDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.04.30\\Desktop\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("internetexplore"))
		{
			System.setProperty("wedriver.ie.driver","C:\\Users\\training_c2a.04.30\\Desktop\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		}
		else 
			System.out.println("invalid");
		return driver;

	}
}
