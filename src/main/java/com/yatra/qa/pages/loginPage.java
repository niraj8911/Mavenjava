package com.yatra.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yatra.qa.base.TestBase;

public class loginPage  extends TestBase
{
   @FindBy(xpath="//input[@name='username']")
    WebElement username;
   
   @FindBy(xpath="//input[@name='password']")
   WebElement password;
   
   @FindBy(xpath="//input[contains(@type,'submit')]")
   WebElement loginbtn;
   
   @FindBy(xpath="//button[contains(text(),'Sign Up')]")
   WebElement  SignUpBtn;
   
   @FindBy(xpath="//img[contains(@class,'img-responsive')]")
   WebElement Crmlogo;
   
  //inatilazation  of page factory
   
   public  loginPage()
   {
	   PageFactory.initElements(driver,this);
   }
   public String validateLoginPageTitle()
   {
	   return driver.getTitle();
   }
     public boolean validateCrmLogo()
     {
    	return Crmlogo.isDisplayed();
    	 
     }
     
     public HomePage login(String un,String pwd)
     {
    	 username.sendKeys(un);
    	 password.sendKeys(pwd);
    	 loginbtn.click();
    	 
    	 return new HomePage();
     
}}
