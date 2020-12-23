package com.OrangeHRM;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OffsetExample {

		 @Test
		 public void moveByOffset() throws InterruptedException
		 {
		  WebDriverManager.chromedriver().setup();
		  ChromeDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get( "https://www.yatra.com/");
		  /*WebElement element = driver.findElementByXPath("//a[contains(text(),'My Account')]");
		  Point pt = element.getLocation();

		     int NumberX=pt.getX();
		     int NumberY=pt.getY();*/

		     Actions act= new Actions(driver);
		     //act.moveByOffset(NumberX, NumberY).click().build().perform();
		     act.moveByOffset(100, 200).click().build().perform();
		        //Thread.sleep(6000);
		     //driver.findElementById("signInBtn").click();
		     Thread.sleep(5000);
		     driver.quit();
}
	}
