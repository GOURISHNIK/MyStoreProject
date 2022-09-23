package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;

public class OrderPage extends Action{

	public WebDriver driver;

	public OrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//td[@data-title='Unit price']//span[contains(text(),'$28.98')]")
	WebElement discountedUnitPrice;

	@FindBy(xpath = "//table[@id='cart_summary']//span[@id='total_price']")
	WebElement totalPrice;
	

	@FindBy(xpath = "//p//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutButton;

	public double discountedUnitPriceIs() throws InterruptedException {
		String discountedUnitPrice1=discountedUnitPrice.getText();
		System.out.println(discountedUnitPrice1);
		String dp1 = discountedUnitPrice1.replaceAll("[$]","");
		System.out.println(dp1);
		double dp2 = Double.parseDouble(dp1);
		System.out.println("converted to doubleformat");
		return dp2;
	}

	public double totalPriceIs() throws InterruptedException {
		String tp1= totalPrice.getText();
		String tp2=tp1.replaceAll("[$]","");
		Thread.sleep(4000);
		//Integer tp = Integer.valueOf(tp2);
		//int tp = Integer.parseInt(tp2);
		double tp = Double.parseDouble(tp2);
		return tp;
	}

	public LoginPage clickOnProceedToCheckOutButton() {
		//proceedToCheckOutButton.click();
		javaScriptClick(driver, proceedToCheckOutButton);
		return new LoginPage(driver);
		
	}

}
