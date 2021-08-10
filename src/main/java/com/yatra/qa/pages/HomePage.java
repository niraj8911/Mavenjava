package com.yatra.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yatra.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'User: Niraj kumar')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[4]/a")
	WebElement Contactslink;
	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[4]/ul/li[1]/aa")
	WebElement newcontacts;
	
	
	@FindBy(xpath="//a[conatins(text(),'Tasks']")
	WebElement Taskslink;
	
	@FindBy(xpath="//a[conatins(text(),'Deals']")
	WebElement Dealslink;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyCorrectUserName()
	{
		 return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle()
	{
		 return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		Contactslink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink()
	{
		Dealslink.click();
		
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		Taskslink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(Contactslink).build().perform();
		newcontacts.click();
}
}