package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {

	public WebDriver driver;

	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	WebElement iConfirmMyOrderButton;

	public OrderConfirmationPage clickOnIConfirmMyOrderButton() {
		iConfirmMyOrderButton.click();
		return new OrderConfirmationPage(driver);
	}

}
