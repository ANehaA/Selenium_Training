package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VisualTest {
	ChromeDriver driver;
	@Test
	public void Verify_Text_Color_Before_After() throws InterruptedException

	{
		 WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Login to Application
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//Get actual color of the Dashboard tab
		String ActColorCode = driver.findElement(By.linkText("Dashboard")).getCssValue("Color");
		System.out.println("Color code in RGB=" + ActColorCode);
		String ExpColorCodeInRGB = "rgb(255, 255, 255)";
		Assert.assertEquals(ActColorCode, ExpColorCodeInRGB);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Admin")).click();
		String AfterColorCode = driver.findElement(By.linkText("Dashboard")).getCssValue("Color");
		System.out.println("Color code in RGB=" + AfterColorCode);
		String PostExpColorCodeInRGB = "rgb(93, 93, 93)";
		Assert.assertEquals(AfterColorCode, PostExpColorCodeInRGB);
		driver.quit();

	}
	
	@Test
	public void Tooltip() throws InterruptedException {

		 WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(6000);
		WebElement element = driver.findElement(By.cssSelector("a[title='T-shirts']"));
		// Get tooltip text
		String toolTipText = element.getAttribute("title");
		System.out.println("Tool tip text present :- " + toolTipText);

		// Compare toll tip text
		Assert.assertEquals("T-shirts", toolTipText);
		driver.quit();
	}
}
