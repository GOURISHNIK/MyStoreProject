package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass{
	public WebDriver driver;
	public IndexPage indexPage;
	public LoginPage loginPage;
	public HomePage homePage;
	
	
	@Test
	public void loginTest() {
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.loginValidation(prop.getProperty("email"), prop.getProperty("password"));
		String actualHomePageUrl=homePage.getHomePageUrl();
		String expectedHomePageUrl=prop.getProperty("HomePageUrl");
		Assert.assertEquals(actualHomePageUrl,expectedHomePageUrl);
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
