package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	public WebDriver driver;
	public IndexPage indexPage;
	public SearchResultPage searchResultPage;
	public AddToCartPage addToCartPage;
	
	
	@Test
	public void addToCartTest() throws InterruptedException {
		searchResultPage = indexPage.searchProductClick("Printed Dress");
		//Thread.sleep(4000); 
		addToCartPage=searchResultPage.clickOnProduct();
		System.out.println("cliked on the product sussessfully");
		//Thread.sleep(4000);
		addToCartPage.eneterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
	
		boolean result = addToCartPage.productSuccessfullyAddedMsg();
		Assert.assertTrue(result, "addToCartTest product not added");
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
