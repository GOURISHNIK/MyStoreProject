package com.mystore.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.dataProviderExcel;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	public WebDriver driver;
	public IndexPage indexPage;
	public LoginPage loginPage;
	public HomePage homePage;
	public AccountCreationPage accountCreationPage;

	@Test
	public void createAccountTest() throws InterruptedException {
		loginPage = indexPage.clickOnSignIn();
		System.out.println("index page sign in success");
		accountCreationPage = loginPage.createNewAccount(prop.getProperty("emailForNewAccountCreation"));
		System.out.println("create new account clicked");
		boolean result = accountCreationPage.accountCreatedTextValidation();
		Thread.sleep(4000);
		System.out.println("create new account text verified");
		Assert.assertTrue(result, "Account not created");
	}

	// >>>>>>>>>>>>>>>>>>>>>>creating account without data providers

	@Test(enabled = false)
	public void creaatingAccountTesting() throws Throwable {

		loginPage = indexPage.clickOnSignIn();
		System.out.println("index page sign in success");
		accountCreationPage = loginPage.createNewAccount(prop.getProperty("emailForNewAccountCreation"));
		System.out.println("create new account clicked");
		Thread.sleep(2000);

		accountCreationPage.createAccount("Mrs", "TestUser", "UserTest", "hgsdtyf", "9", "May", "1985", "ABCDEF",
				"EDFG123", "San", "Alabama", "91436", "United States", "8489875678");
		Thread.sleep(2000);
	}

	// ---------------------------------------------------------with data provider

	@Test(dataProvider = "testDataInput", dataProviderClass = dataProviderExcel.class)
	public void creaatingAccountTestingDp(String gender, String fName, String lName, String pswd, String day,
			String month, String year, String comPany, String addr, String cityString, String stateName, String zip,
			String countryName, String mobilePhone) throws Throwable {

		loginPage = indexPage.clickOnSignIn();
		System.out.println("index page sign in success");
		accountCreationPage = loginPage.createNewAccount(prop.getProperty("emailForNewAccountCreation"));
		System.out.println("create new account clicked");
		Thread.sleep(2000);

		accountCreationPage.createAccount(gender, fName, lName, pswd, day, month, year, comPany, addr, cityString,
				stateName, zip, countryName, mobilePhone);

		/*
		 * accountCreationPage.createAccount("Mrs","TestUser","UserTest",
		 * "hgsdtyf","9","May","1985","ABCDEF","EDFG123","San","Alabama",
		 * "91436","United States","8489875678");
		 */
		Thread.sleep(10000);
	}

	// --------------------with dataprovider as hashmap
	@Test(dataProvider = "HM", dataProviderClass = dataProviderExcel.class)
	public void createAccountTestHM(HashMap<String, String> hashMapValue) throws Throwable {

		loginPage = indexPage.clickOnSignIn();
		System.out.println("index page sign in success");
		accountCreationPage = loginPage.createNewAccount(prop.getProperty("emailForNewAccountCreation"));
		System.out.println("create new account clicked");
		Thread.sleep(2000);

		// accountCreationPage.createAccount(gender, fName, lName, pswd, day, month,
		// year, comPany, addr, cityString,
		// stateName, zip, countryName, mobilePhone);

		accountCreationPage.createAccount(hashMapValue.get("Gender"), hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"), hashMapValue.get("SetPassword"), hashMapValue.get("Day"),
				hashMapValue.get("Month"), hashMapValue.get("Year"), hashMapValue.get("Company"),
				hashMapValue.get("Address"), hashMapValue.get("City"), hashMapValue.get("State"),
				hashMapValue.get("Zipcode"), hashMapValue.get("Country"), hashMapValue.get("MobilePhone"));

	}

	
	
	
	
	
	
	
	
	
	
	
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// dataprovider with NewExcelLibrary getTestDataNewExcelLibrary
	@Test(dataProvider = "testDataInputNewExcelLibrary", dataProviderClass = dataProviderExcel.class)
	public void creaatingAccountTestingWithDataProviderAndNewExcelLibrary(String gender, String fName, String lName,
			String pswd, String day, String month, String year, String comPany, String addr, String cityString,
			String stateName, String zip, String countryName, String mobilePhone) throws Throwable {

		loginPage = indexPage.clickOnSignIn();
		System.out.println("index page sign in success");
		accountCreationPage = loginPage.createNewAccount(prop.getProperty("emailForNewAccountCreation"));
		System.out.println("create new account clicked");
		Thread.sleep(2000);

		accountCreationPage.createAccount(gender, fName, lName, pswd, day, month, year, comPany, addr, cityString,
				stateName, zip, countryName, mobilePhone);

		/*
		 * accountCreationPage.createAccount("Mrs","TestUser","UserTest",
		 * "hgsdtyf","9","May","1985","ABCDEF","EDFG123","San","Alabama",
		 * "91436","United States","8489875678");
		 */
		Thread.sleep(10000);
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

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
