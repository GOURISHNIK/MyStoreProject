package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;

public class SearchResultPage extends Action{

	public WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath = "//body//div[@id='center_column']/ul/li[1]/div[1]")
	//@FindBy(xpath="//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
	@FindBy(xpath="//body//a[1]/img[@title='Printed Summer Dress'][@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']")
	WebElement validateProductNameSearchedInIndexPageIsAvailable;

	public boolean isProductAvailable() {
		return validateProductNameSearchedInIndexPageIsAvailable.isDisplayed();

	}

	public AddToCartPage clickOnProduct() {
		fluentWait(driver, validateProductNameSearchedInIndexPageIsAvailable, 10);
		System.out.println("clickOnProcut method initiated");
		//validateProductNameSearchedInIndexPageIsAvailable.click();
		System.out.println("trying to click on validateProductNameSearchedInIndexPageIsAvailable");
		javaScriptClick(driver, validateProductNameSearchedInIndexPageIsAvailable);
		System.out.println("clicked sussessfully on validateProductNameSearchedInIndexPageIsAvailable");
		return new AddToCartPage(driver);

	}
}
