package com.mystore.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public Logger logger;
	public WebDriver driver;
	public IndexPage indexPage;
	public LoginPage loginPage;
	public HomePage homePage;
	
	
	@Test
	public void loginTest() {
		logger.debug("=========loginTest started=========");
		logger.debug("user is going to click in sign in");
		loginPage=indexPage.clickOnSignIn();
		logger.debug("enter email and password to login");
		homePage=loginPage.loginValidation(prop.getProperty("email"), prop.getProperty("password"));
		String actualHomePageUrl=homePage.getHomePageUrl();	
		String expectedHomePageUrl=prop.getProperty("HomePageUrl");
		logger.debug("checking login status");
		Assert.assertEquals(actualHomePageUrl,expectedHomePageUrl);
		logger.info("login is success");
		logger.info("=========loginTest completed=========");
	}
	
	@BeforeMethod
	public void setUp() {
		logger = LogManager.getLogger();
			logger.debug("setup started");
		driver = launchApp();
		logger.debug("driver launched");
		indexPage = new IndexPage(driver);
		logger.debug("IndexPage obj created");
		logger.info("setUp method closed");

	}

	@AfterMethod
	public void tearDown() {
		logger.debug("tearDown method started");
		driver.quit();
		logger.info("tearDown method closed");
	}

}
