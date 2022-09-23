package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.actiondriver.Action;

public class AddToCartPage extends Action {

	public WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "quantity_wanted")
	WebElement quantityField;

	@FindBy(id = "group_1")
	WebElement sizeSelectionDropDown;

	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	WebElement addToCartButton;

	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement productSuccessfullyAddedMsg;
	
	@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
	WebElement proceedToCheckoutButton;

	public void eneterQuantity(String quantity) {
		fluentWait(driver, quantityField, 10);
		quantityField.clear();
		quantityField.sendKeys(quantity);
	}

	public boolean selectSize(String enterSize) {
		return selectByVisibleText(enterSize, sizeSelectionDropDown);
	}

	public void clickOnAddToCart() {
		addToCartButton.click();
	}

	public boolean productSuccessfullyAddedMsg() {
		fluentWait(driver, productSuccessfullyAddedMsg, 10);
		return productSuccessfullyAddedMsg.isDisplayed();
	}
	
	public OrderPage clickOnProceedToCheckoutButton() {
		fluentWait(driver, proceedToCheckoutButton, 10);
		//proceedToCheckoutButton.click();
		javaScriptClick(driver, proceedToCheckoutButton);
		return new OrderPage(driver);
	}
}
