package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;

public class LoginPage extends Action{

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "passwd")
	WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	WebElement signInButton;

	@FindBy(id = "email_create")
	WebElement emailForRegistration;

	@FindBy(xpath = "//button//span[normalize-space()='Create an account']")
	WebElement createAnAccountButton;

	public HomePage loginValidation(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		//signInButton.click();
		javaScriptClick(driver, signInButton);
		return new HomePage(driver);
	}
	
	public AddressPage loginGuestUserToNavigateToAddressPage(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		//signInButton.click();
		javaScriptClick(driver, signInButton);
		return new AddressPage(driver);
	}

	public AccountCreationPage createNewAccount(String email) {
			System.out.println("enter email for new account creation");
		emailForRegistration.sendKeys(email);
			System.out.println("email enteredfor new account creation");
		createAnAccountButton.click();
			System.out.println("createAnAccountButton has been clicked");
		//javaScriptClick(driver, createAnAccountButton);
		return new AccountCreationPage(driver);
	}
	
	
}
