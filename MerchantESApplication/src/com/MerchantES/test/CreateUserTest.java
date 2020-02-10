package com.MerchantES.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MerchantES.initialization.MerchantESApplicationSetUp;
import com.MerchantES.pages.AdminDashboardPage;
import com.MerchantES.pages.CreateNewUserPage;
import com.MerchantES.pages.UsersListViewPage;
import com.MerchantES.utilities.PropUtils;

//This class inherits the parent class and has the test methods defined

public class CreateUserTest extends MerchantESApplicationSetUp {
	
	/*
	 * This method verifies that errors are thrown
	 * when a duplicate user with the same username and email are entered
	 * as the exising one.
	 */

	@Test(priority = 2)
	public void invalidUserTest()
	{
		AdminDashboardPage adminPage=new AdminDashboardPage(driver);
		adminPage.clickUsersTab();
		
		UsersListViewPage ulPage=new UsersListViewPage(driver);
		ulPage.clickNewUser();

		CreateNewUserPage crUserPage=new CreateNewUserPage(driver);
		crUserPage.enterUserDetails("Kathy","pass","Kathy@noreply.com");
		crUserPage.clickCreateUser();
		
		
		String expectedError="has already been taken";		
		
		String actualNameError=crUserPage.getUserNameErrorMessage().trim();
		Assert.assertEquals(actualNameError, expectedError);	
		
		
		String actualEmailError= crUserPage.getEmailErrorMessage().trim();
		Assert.assertEquals(actualEmailError, expectedError);
		
	}
	
	/*
	 * This method verifies the user is created with the correct input values
	 */
	
	@Test(priority = 1)
	public void validUserTest() {			

		AdminDashboardPage adminPage=new AdminDashboardPage(driver);
		adminPage.clickUsersTab();	
		
		UsersListViewPage ulPage=new UsersListViewPage(driver);
		ulPage.clickNewUser();
		
		CreateNewUserPage crUserPage=new CreateNewUserPage(driver);
		crUserPage.enterUserDetails("Kathy","pass","Kathy@noreply.com");
		crUserPage.clickCreateUser();		
		
		adminPage.clickUsersTab();
		String actUserCreated=ulPage.verifyCreatedUser();
		Assert.assertEquals(actUserCreated,"Kathy");
		
	}

	
	
	
	
	
	


}
