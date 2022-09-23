package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass{
	public WebDriver driver;
	public IndexPage indexPage;
	public LoginPage loginPage;
	public HomePage homePage;
	public AccountCreationPage accountCreationPage;
	
	
	@Test
	public void createAccountTest() throws InterruptedException {
		loginPage=indexPage.clickOnSignIn();
			System.out.println("index page sign in success");
		accountCreationPage=loginPage.createNewAccount(prop.getProperty("emailForNewAccountCreation"));
			System.out.println("create new account clicked");
		boolean result = accountCreationPage.accountCreatedTextValidation();
		Thread.sleep(4000);
			System.out.println("create new account text verified");
		Assert.assertTrue(result, "Account not created");
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
