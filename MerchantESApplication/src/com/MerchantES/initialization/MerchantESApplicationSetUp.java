package com.MerchantES.initialization;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.MerchantES.utilities.PropUtils;

public class MerchantESApplicationSetUp {

	public WebDriver driver;
	

	@BeforeMethod
	public void initialization() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String browserUrl=PropUtils.getValueUsingKey("TestUtils/data.properties","defaultUrl");
		driver.get(browserUrl);
		

	}
	
	@AfterMethod
	public void quitBrowser()
	{
	driver.quit();	
	}

}
