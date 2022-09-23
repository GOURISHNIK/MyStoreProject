package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='My wishlists']")
	WebElement myWishList;

	@FindBy(xpath = "//span[normalize-space()='Order history and details']")
	WebElement orderHistoryAndDetails;

	public boolean myWishListValidation() {
		return myWishList.isDisplayed();
	}

	public boolean orderHistoryAndDetailsLinkIsDisplayed() {
		return orderHistoryAndDetails.isDisplayed();
	}

	public String getHomePageUrl() {
		return driver.getCurrentUrl();
	}

}
