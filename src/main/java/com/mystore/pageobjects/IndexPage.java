package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends Action{
	public WebDriver driver;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	WebElement signInButton;

	@FindBy(xpath = "//img[@alt='My Store']")
	WebElement myStoreLogo;

	@FindBy(id = "search_query_top")
	WebElement searchProductBox;

	@FindBy(name = "submit_search")
	WebElement searchButton;

	
	public LoginPage clickOnSignIn() {
		signInButton.click();
		return new LoginPage(driver);
	}

	public boolean validateLogo() {
		return myStoreLogo.isDisplayed();
		

	}

	public String getMyStoreTitle() {
		return driver.getTitle();

	}

	public SearchResultPage searchProductClick(String enterProductNameToSearch) {
		searchProductBox.sendKeys(enterProductNameToSearch);
		searchButton.click();
		return new SearchResultPage(driver);
	}
}
