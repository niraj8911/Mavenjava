package com.yatra.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.yatra.qa.util.TestUtil;
import com.yatra.qa.util.WebEventListener;

public class TestBase 
{
	public static WebDriver driver;
	 public static Properties prop;
	 public  static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;


public TestBase()
{
try
{
	prop = new Properties();
	FileInputStream ip = new FileInputStream("C:/Users/nk891/Desktop/Automation/Mavenjava/src/main/java/com/yatra/qa/config/property");
	prop.load(ip);
}
     catch(FileNotFoundException e)
     {
    	 e.printStackTrace();
    	 
     }
     catch(IOException e)
{
	  e.printStackTrace();
}
}

@SuppressWarnings("deprecation")
public static void initialization()
 {

		 System.setProperty("webdriver.chrome.driver","C:/Users/nk891/Desktop/Exe/chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 
		 e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
		 
		driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT,TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

	 
	 driver.get(prop.getProperty("Url"));
	
	 
	 
	 
	 
	 
	 
 }
















}