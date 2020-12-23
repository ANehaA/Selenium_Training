package com.OrangeHRM;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActivity {
	@Test
	public void moveByOffset() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        WebElement text = driver.findElement(By.name("q"));
        
        Actions make  = new Actions(driver);
        
        org.openqa.selenium.interactions.Action keyboardEvents = make.keyDown(text, Keys.SHIFT).sendKeys("Selenium Webdriver Java")
       .keyUp(text, Keys.SHIFT).doubleClick().contextClick().build();
       keyboardEvents.perform();
      
}
}
