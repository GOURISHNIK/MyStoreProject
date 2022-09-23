package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {

	public WebDriver driver;
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//h1[normalize-space()='Create an account']")
	WebElement createAnAccountText;
	
	public boolean accountCreatedTextValidation() throws InterruptedException {
		Thread.sleep(4000);
		return createAnAccountText.isDisplayed();
		
	}
}
