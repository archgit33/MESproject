package com.MerchantES.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UsersListViewPage {
	private By newUserLoc=By.linkText("New User");
	private By createdUserLoc=By.xpath("//table[@id='index_table_users']/tbody/tr[1]/td[3]");	
	private By selectUNLoc=By.xpath("//div[@id='q_username_input']/select");
	private By selectEmailLoc=By.xpath("//div[@id='q_email_input']/select");
	
	private WebDriver driver;
	
	public UsersListViewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void clickNewUser() {
		
		driver.findElement(newUserLoc).click();	
		
	}
		
	public void filterUserName(String UNFilter) {
		WebElement selectUN=driver.findElement(selectUNLoc);
		selectUN.click();
		Select textele=new Select(selectUN);
		textele.selectByVisibleText(UNFilter);
	}
	
	public void filterEmail(String emailFilter) {
		WebElement selectEmail=driver.findElement(selectEmailLoc);
		selectEmail.click();
		Select textele=new Select(selectEmail);
		textele.selectByVisibleText(emailFilter);
	}
	
	public void selectFromDate(String fDate)
	{
		driver.findElement(By.id("q_created_at_gteq_datetime")).sendKeys(fDate);
	}
	
	public void selectToDate(String tDate)
	{
		driver.findElement(By.id("q_created_at_lteq_datetime")).sendKeys(tDate);
	}
	
	public String verifyCreatedUser() {
		String actualUserCreated=driver.findElement(createdUserLoc).getText().trim();
		return actualUserCreated;
		
	}
	
	public void clickOnFilter() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Filter']")).click();;
		Thread.sleep(10000);
			
	}
	
	public void checkUsername(String userName) {
		driver.findElement(By.id("q_username")).sendKeys(userName);
	}
	
	public void checkEmail(String email) {
		driver.findElement(By.id("q_email")).sendKeys(email);
	}
}


