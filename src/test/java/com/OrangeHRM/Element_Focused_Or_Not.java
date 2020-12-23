package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Element_Focused_Or_Not  {
	WebDriver driver;
	@Test(priority=1)
	public void Google_Search_Focus() {
		
	
	driver.manage().window().maximize();
		driver.navigate().to("https://www.google.co.in/");
		
		WebElement element = driver.findElement(By.name("q"));
		// Verify Search box is focused or not
		element.equals(driver.switchTo().activeElement());
		driver.quit();
	}

@Test
public void Login_Edit_Focus() {
	
	
	driver.manage().window().maximize();
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	WebElement element=driver.findElement(By.name("txtUsername"));
	element.equals(driver.switchTo().activeElement());

}
@BeforeTest
public void LaunchBrowser() {
	WebDriverManager.chromedriver().setup();
	// WebDriverManager.firefoxdriver().setup();
	// WebDriverManager.edgedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}

@AfterTest
public void CloseBrowser() {
	// driver.close();//Close will close only current chrome browser
	driver.quit();
}
}
