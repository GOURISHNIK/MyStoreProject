package com.mystore.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class javaScriptClickTest {
	public Properties prop;
	public WebDriver driver;

	public void loadConfig() throws InterruptedException {
		/*
		 * try { prop = new Properties(); FileInputStream ip = new FileInputStream(
		 * System.getProperty("user.dir") + "\\Configuration\\config.properties");
		 * prop.load(ip);
		 * 
		 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
		 * e) { e.printStackTrace(); }
		 * 
		 * 
		 */
		String browserName = "chrome";
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/index.php?");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(2000);
		// a.moveToElement(driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[1]/div/a[1]"))).click().build().perform();
		WebElement ele12= driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[1]/div/a[1]"));
		
		//a.moveToElement(ele12,0, 200).click(ele12).build().perform();
		
		
		js.executeScript("arguments[0].click();", ele12);
		
		
		/*
		 * String dollarValue=driver.findElement(By.xpath(
		 * "//p//span[contains(text(),'$28.98')]")).getText();
		 * System.out.println(dollarValue); String
		 * regExp1=dollarValue.replaceAll("[^a-zA-Z0-9]",""); String
		 * regExp2=dollarValue.replaceAll("[$]",""); System.out.println(regExp1);
		 * System.out.println(regExp2);
		 */

	}
}