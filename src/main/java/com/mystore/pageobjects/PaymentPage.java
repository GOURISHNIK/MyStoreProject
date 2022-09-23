package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	public WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByBankWirePaymentMethod;


	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheck;
		
	public OrderSummaryPage clickOnPayByBankWire() {
		payByBankWirePaymentMethod.click();
		return new OrderSummaryPage(driver);
	}
}
