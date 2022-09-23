package com.mystore.testcases;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {

	public WebDriver driver;
	public IndexPage indexPage;

	@Test
	public void myStoreLogoTest() {
			System.out.println("validating myStoreLogoTest");
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result,"myStoreLogo is not displayed");
			System.out.println("myStoreLogo is validated successfully");
	}

	@Test
	public void myStoreTitle() {	
			System.out.println("vaidating myStoreTitle");
		String actTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
			System.out.println("myStoreTitle is validated successfully");
	}

	@BeforeMethod
	public void setUp() {
			System.out.println("setup started");
		driver = launchApp();
			System.out.println("driver launched");
		indexPage = new IndexPage(driver);
			System.out.println("IndexPage obj created");
			System.out.println("setUp method closed");

	}

	@AfterMethod
	public void tearDown() {
			System.out.println("tearDown method started");
		driver.quit();
			System.out.println("tearDown method closed");
	}

}
