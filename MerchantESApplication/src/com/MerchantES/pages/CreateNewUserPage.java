package com.MerchantES.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This class has methods that define the actions done while creating a new user.The method names have been
//chosen to be self descriptive

public class CreateNewUserPage {
	private By userNameLoc= (By.id("user_username"));	
	private By passwordLoc=By.id("user_password");
	private By emailIdLoc=By.id("user_email");
	private By createUserLoc=By.xpath("//input[@value='Create User']");	
	private By errorUserNameLoc1=By.xpath("//input[@id='user_username']/following::p[@class='inline-errors'][1]");
	private By errorEmailLoc2=By.xpath("//input[@id='user_email']/following::p[@class='inline-errors']");
	
	private WebDriver driver;
	
	public CreateNewUserPage(WebDriver driver) 
	{		
		this.driver=driver;		
	}	
	   /*
	   * Locates elements and fills the empty fields with the String values.
	   * 
	   * @param {string} userName field
	   * @param {string} password field
	   * @param {string} email field
	   */
	
	public void enterUserDetails(String userName,String password, String email)
	{
		driver.findElement(userNameLoc).sendKeys(userName);	
		driver.findElement(passwordLoc).sendKeys(password);
		driver.findElement(emailIdLoc).sendKeys(email);	
	}
	
	/*
	 * Locates CreateUser element and clicks on it
	 */
	public void clickCreateUser() 
	{			
		driver.findElement(createUserLoc).click();				
	}
	
	/*
	 * Retrieves the error text thrown for the incorrect Username field
	 * @param {return} the error message
	 */
	public String getUserNameErrorMessage()
	{
		String actualNameError=driver.findElement(errorUserNameLoc1).getText();
		return actualNameError;
	}
	
	/*
	 * Retrieves the error text thrown for the incorrect email field
	 * @param {return} the error message
	 */
	
	public String getEmailErrorMessage() 
	{		
		String actualEmailError=driver.findElement(errorEmailLoc2).getText();
		return actualEmailError;
	}

}
