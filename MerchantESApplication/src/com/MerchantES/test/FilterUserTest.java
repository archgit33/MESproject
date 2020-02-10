package com.MerchantES.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MerchantES.initialization.MerchantESApplicationSetUp;
import com.MerchantES.pages.AdminDashboardPage;
import com.MerchantES.pages.UsersListViewPage;
import com.MerchantES.utilities.PropUtils;

public class FilterUserTest extends MerchantESApplicationSetUp {
	
	/*
	 * This test method filters the users based on the 
	 * username, email, specified and also based on 
	 * the from and to dates specified
	 */

@Test
 public void checkUserExistsTest() throws InterruptedException	{
	 
	 
		AdminDashboardPage adminPage=new AdminDashboardPage(driver);
		adminPage.clickUsersTab();
		
		UsersListViewPage ulPage=new UsersListViewPage(driver);
		ulPage.filterUserName("Contains");
		ulPage.checkUsername("");
		ulPage.filterEmail("Contains");
		ulPage.checkEmail("noreply.com");
		ulPage.selectFromDate("2019-12-10");
		ulPage.selectToDate("2020-02-09");
		ulPage.clickOnFilter();
		
		
		
		
		
 }

}
