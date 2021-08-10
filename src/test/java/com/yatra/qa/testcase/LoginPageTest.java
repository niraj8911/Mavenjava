package com.yatra.qa.testcase;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yatra.qa.base.TestBase;
import com.yatra.qa.pages.HomePage;
import com.yatra.qa.pages.loginPage;

public class LoginPageTest extends TestBase

{
	loginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();
		
	}
	
	
	@BeforeMethod
     public void setup()
     {
		initialization();
		loginpage = new loginPage();
     }
	@Test(priority=1)
	
	public void LoginPageTitleTest()
	{
		String title= loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void CrmLogoTest()
	{
		boolean flag = loginpage.validateCrmLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		//String Username =prop.getProperty("username");
		//String Password = prop.getProperty("password");
		homepage=loginpage.login(prop.getProperty("userName"),prop.getProperty("password"));
	}
	
	@AfterMethod 
	public void tearDown()
	{
		driver.quit();
	}

}
