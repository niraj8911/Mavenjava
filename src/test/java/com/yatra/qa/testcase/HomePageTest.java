package com.yatra.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yatra.qa.base.TestBase;
import com.yatra.qa.pages.ContactsPage;
import com.yatra.qa.pages.HomePage;
import com.yatra.qa.pages.loginPage;
import com.yatra.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
loginPage loginpage;
HomePage  homepage;
ContactsPage contactspage;
TestUtil testutil;
public HomePageTest()
{
	super();
}

@BeforeMethod
public void setup()
{
	initialization();
	loginpage = new loginPage();
	testutil = new TestUtil();
	homepage =loginpage.login(prop.getProperty("userName"),prop.getProperty("password"));
	contactspage = new ContactsPage();
}
 


@Test(priority=1)
public void verifyHomePageTitleTest()
{
	String homePageTitle=homepage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle,"CRMPRO","Home page Title not Match");
	
}
@Test(priority=2)
  public void verifyUserNameTest()
  {
	testutil.switchToFrame();
    boolean flag=homepage.verifyCorrectUserName();
    
   Assert.assertTrue(flag);

  }

@Test
public void verifyContactsLinkTest()
{
      testutil.switchToFrame();
	contactspage =homepage.clickOnContactsLink();
}
@Test
public void verifyTasksLinkTest()
{
    testutil.switchToFrame();
	homepage.clickOnTasksLink();
}



@AfterMethod
public void tearDown()
{
	driver.quit();
}




}