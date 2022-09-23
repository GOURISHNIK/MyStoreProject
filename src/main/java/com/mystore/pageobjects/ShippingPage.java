package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {

	public WebDriver driver;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='cgv']")
	WebElement termsAndConditions;
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutButton;
	
	public void clickTermsAndConditons() {
		termsAndConditions.click();
				
	}

	public PaymentPage clickOnProceedToCheckoutButton() {
		proceedToCheckoutButton.click();
		return new PaymentPage(driver);
	}
}
