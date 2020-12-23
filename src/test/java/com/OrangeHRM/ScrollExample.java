package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollExample {
	ChromeDriver driver;
    @Test
    public void ByPage() throws InterruptedException {
    	 WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	
    	//System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
        //driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application		
        driver.get("https://www.shutterfly.com/");
		Thread.sleep(2000);
		driver.findElementByClassName("overlay-modal-close").click();
		Thread.sleep(2000);
        //This will scroll the web page till end.		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        driver.findElementByLinkText("Order Status").click();
    }
    
    @Test
    public void ByVisibleElement() throws InterruptedException {
    	//System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
        //driver = new ChromeDriver();
    	 WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver();
    	 driver.manage().window().maximize();
      JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get( "https://www.shutterfly.com/");
		Thread.sleep(6000);
		driver.findElementByClassName("overlay-modal-close").click();
		//driver.findElementByLinkText("Order Status").click();
		//Thread.sleep(6000);
		WebElement Element = driver.findElementByLinkText("Order Status");
        //This will scroll the page till the element is found		
	     js.executeScript("arguments[0].scrollIntoView();", Element);
	     Thread.sleep(2000);
	     Element.click();
    }
    @Test
    public void ScrollHorizontally() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application		
        driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");

        WebElement Element = driver.findElement(By.linkText("VBScript"));
        Thread.sleep(2000);
        //This will scroll the page Horizontally till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
}
