package com.OrangeHRM;



import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Mobile_Browser_View_Flight_Login {
	ChromeDriver driver;
	  @Test
	  public void SignOn() {
			driver.get("https://www.borrowlenses.com/");
			

	  }
	  @BeforeTest
	  public void LaunchBrowser() {
		  WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
	       // ChromeOptions iPhoneOption = new ChromeOptions();
	        //driver = new ChromeDriver(iPhoneOption);
	        Dimension d = new Dimension(640, 960);
	        driver.manage().window().maximize();
	        driver.manage().window().setSize(d);

	  }

	  @AfterTest
	  public void CloseBrowser() {
			driver.quit();
	  }
}
