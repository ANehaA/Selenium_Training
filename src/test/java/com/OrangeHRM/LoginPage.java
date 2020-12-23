package com.OrangeHRM;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginPage {

	@Test
	public void loginWithValidCredentials() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		WebElement userTxtbox= driver.findElementById("txtUsername");
		WebElement passwordTxtbox= driver.findElementById("txtPassword");
		WebElement loginBtn= driver.findElementById("btnLogin");
		userTxtbox.sendKeys("Admin");
		passwordTxtbox.sendKeys("admin123");
		loginBtn.click();
		
		WebElement dashboardTxt= driver.findElementByXPath("//h1[contains(text(),'Dashboard')]");
		Assert.assertTrue("Dashboard loaded, successful login",dashboardTxt.isDisplayed());
		
		driver.close();
	}

}
