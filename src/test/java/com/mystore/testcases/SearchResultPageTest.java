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
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	public WebDriver driver;
	public IndexPage indexPage;
	public SearchResultPage searchResultPage;

	@Test
	public void productAvailabilityTest() {
		searchResultPage = indexPage.searchProductClick("Printed Dress");
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result, "productAvailabilityTest searched product not found");

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