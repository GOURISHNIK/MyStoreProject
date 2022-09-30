package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {

	public WebDriver driver;

	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[normalize-space()='Create an account']")
	WebElement createAnAccountText;

	@FindBy(id = "id_gender1")
	private WebElement mr;

	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;

	@FindBy(name = "firstname")
	private WebElement customerNirstName;

	@FindBy(name = "lastname")
	private WebElement customerLastName;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(name = "address1")
	private WebElement address;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "id_state")
	private WebElement state;

	@FindBy(name = "postcode")
	private WebElement postCode;

	@FindBy(name = "id_country")
	private WebElement country;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "phone_mobile")
	private WebElement mobile;

	@FindBy(name = "alias")
	private WebElement ref;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;

	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month,
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone) throws Throwable {
		
		if(gender.equalsIgnoreCase("Mr")) {
			mr.click();
		} else {
			mrs.click();
		}
		
		//action.type(firstName, fName);
		firstName.sendKeys(fName);
		//action.type(lastName, lName);
		lastName.sendKeys(lName);
		//action.type(passWord, pswd);
		passWord.sendKeys(pswd);
		


		//action.selectByValue(days, day);
		selectByValu(days, day);
		//action.selectByValue(months, month);
		Select s1 = new Select(months);
		Thread.sleep(1000);
		s1.selectByIndex(5);
		//selectByValu(months, month);
		//action.selectByValue(years, year);
		selectByValu(years, year);
		//action.type(companyName, comPany);
		companyName.sendKeys(comPany);
		//action.type(address, addr);
		address.sendKeys(addr);
		//action.type(city, cityString);
		city.sendKeys(cityString);
		//action.selectByVisibleText(stateName, state);
		state.sendKeys(stateName);
		//action.type(postCode, zip);
		postCode.sendKeys(zip);
		//action.selectByVisibleText(countryName, country);
		country.sendKeys(countryName);
		//action.type(mobile, mobilePhone);
		mobile.sendKeys(mobilePhone);
	}

	public HomePage validateRegistration() throws Throwable {
		registerBtn.click();
		return new HomePage(driver);
	}

	public void selectByValu(WebElement ele, String vtext) {
		try {
			Select s = new Select(ele);
			s.selectByValue(vtext);
			System.out.println("element is selected");
		} catch (Exception e) {
			System.out.println("element is not selected" );
		}
		
	}

	public boolean accountCreatedTextValidation() throws InterruptedException {
		Thread.sleep(4000);
		return createAnAccountText.isDisplayed();

	}

	public void createAccount(String gender, String fName, String lName, String pswd, int i, String month, String year,
			String comPany, String addr, String cityString, String stateName, String zip, String countryName,
			String mobilePhone) {
		// TODO Auto-generated method stub
		
	}
}
