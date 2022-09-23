package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass{

	public WebDriver driver;
	public IndexPage indexPage;
	public SearchResultPage searchResultPage;
	public AddToCartPage addToCartPage;
	public OrderPage orderPage;
	public LoginPage loginPage;
	public AddressPage addressPage;
	public ShippingPage shippingPage;
	public PaymentPage paymentPage;
	public OrderConfirmationPage orderConfirmationPage;

	@Test
	public void endToEndTest() throws InterruptedException {
		searchResultPage = indexPage.searchProductClick("Printed Dress");
		// Thread.sleep(4000);
		addToCartPage = searchResultPage.clickOnProduct();
		System.out.println("cliked on the product sussessfully");
		// Thread.sleep(4000);
		addToCartPage.eneterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProceedToCheckoutButton();
		loginPage = orderPage.clickOnProceedToCheckOutButton();
		addressPage=loginPage.loginGuestUserToNavigateToAddressPage(prop.getProperty("email"), prop.getProperty("password"));
		shippingPage=addressPage.clickOnProceedToCheckout();
		shippingPage.clickTermsAndConditons();
		paymentPage=shippingPage.clickOnProceedToCheckoutButton();
		OrderSummaryPage orderSummaryPage=paymentPage.clickOnPayByBankWire();
		OrderConfirmationPage orderConfirmationPage=orderSummaryPage.clickOnIConfirmMyOrderButton();
		String actualOrderConfirmationMsg=orderConfirmationPage.orderSuccessMsgValidation();
		System.out.println(actualOrderConfirmationMsg);
		String expedtedOderConfimationMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualOrderConfirmationMsg, expedtedOderConfimationMsg);
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



