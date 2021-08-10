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

public class ContactsPageTest  extends TestBase
{
	loginPage loginpage;
	HomePage  homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	
	public ContactsPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new loginPage();
		testutil = new TestUtil();
		homepage =loginpage.login(prop.getProperty("userName"),prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage =homepage.clickOnContactsLink();
	}
    @Test
    public void verifyContactsLabelTest()
    {
    	Assert.assertTrue(contactspage.verifyContactLabel(),"contacts label missing on page");
    
    }
    @Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company)
    {
    	
    	
		homepage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactspage.createNewContact(title, firstName, lastName, company);
    }
    
    @AfterMethod
    
    public void tearDown()
    {
    	//driver.quit();
    }
    

}
