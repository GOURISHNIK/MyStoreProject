package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

	public WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//strong[normalize-space()='Your order on My Store is complete.']")
	WebElement orderSuccessMsg;
	
	public String orderSuccessMsgValidation() {
		return orderSuccessMsg.getText();
	}

}
