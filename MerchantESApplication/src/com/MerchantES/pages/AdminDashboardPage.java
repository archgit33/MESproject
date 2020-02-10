package com.MerchantES.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This class defines the methods on the first logon page

public class AdminDashboardPage {
	
	private By usersLoc=By.linkText("Users");
	
	private WebDriver driver;
	
	public AdminDashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/*
	 * Locates User button element and clicks on it
	 */
	public void clickUsersTab()
	{
		driver.findElement(usersLoc).click();
	}

}
