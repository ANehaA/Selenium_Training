package com.OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class LoginTestSuite {
	
	ChromeDriver driver;
		
  @Test(priority=1)
  public void verifySuccessfulLogin() throws InterruptedException {
	  WebElement userTxtbox= driver.findElementById("txtUsername");
		WebElement passwordTxtbox= driver.findElementById("txtPassword");
		WebElement loginBtn= driver.findElementById("btnLogin");
		userTxtbox.sendKeys("Admin");
		String pass1 = "admin123";
		//passwordTxtbox.sendKeys(pass1);
		  byte[] encodedBytes = Base64.encodeBase64(pass1.getBytes());
		  byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
		  passwordTxtbox.sendKeys(new String(decodedBytes));
		 
		
		loginBtn.click();
		WebElement dashboardTxt= driver.findElementByXPath("//h1[contains(text(),'Dashboard')]");
		Assert.assertTrue("Dashboard loaded, successful login",dashboardTxt.isDisplayed());
  }
  
  @Test(priority=4)
  public void logout() throws InterruptedException {
	  WebElement welcomeTxt= driver.findElementById("welcome");
	  welcomeTxt.click();
	  Thread.sleep(5000);
	  WebElement logoutLnk= driver.findElementByXPath("//a[contains(text(),'Logout')]");
	  logoutLnk.click();
	  String ActValue = driver.findElementById("logInPanelHeading").getText();
	   String Expvalue="LOGIN Panel";
	   Assert.assertEquals(ActValue, Expvalue);
	   
	   String ActLoginURL=driver.getCurrentUrl();
	   
	   System.out.println(ActLoginURL);
	   
	   String ActLoginTile=driver.getTitle();
	   String ExpLoginTitle="OrangeHRM";
	   Assert.assertEquals(ActLoginTile, ExpLoginTitle);

  }
  @Test(priority=2)
  public void addAndVerifyUsers() throws InterruptedException {
	  
	  WebElement adminTab= driver.findElementById("menu_admin_viewAdminModule");
	  adminTab.click();
	  WebElement addBtn= driver.findElementByName("btnAdd");
	  addBtn.click();
	  WebElement roleDD= driver.findElementById("systemUser_userType");
	  Select role= new Select(roleDD);
	  role.selectByValue("1");
	  driver.findElementById("systemUser_employeeName_empName").sendKeys("John Smith");
	 
	  String uname= "rrr123456xab";
	  driver.findElementById("systemUser_userName").sendKeys(uname);
	  driver.findElementById("systemUser_password").sendKeys("admin123");
	  driver.findElementById("systemUser_confirmPassword").sendKeys("admin123");
	  Thread.sleep(5000);
	  driver.findElementById("btnSave").click();
	  Thread.sleep(5000);
	  String username= "//a[text(),'%s']";
	  WebElement element = driver.findElement(By.xpath(String.format(username, uname)));
	  Assert.assertTrue("user created",element.isDisplayed());
	  
	  List <WebElement> col = driver.findElements(By.xpath("//table[@id='resultTable']//th"));
	  List <WebElement> row = driver.findElements(By.xpath("//table[@id='resultTable']//tr"));
	  
	  System.out.println(col);
	  System.out.println(row);
	  
	  for(int i=1;i<row.size();i++) {
		 
		  
			   WebElement data = driver.findElement(By.xpath("//table[@id='resultTable']//tr[" + i + "]//td[2]//a"));
			   String actualTxt=data.getText();
			   if(actualTxt.equals(uname)) {
			   driver.findElement(By.xpath("//table[@id='resultTable']//tr[i]//td[1]")).click();
			   driver.findElementById("btnDelete").click();
			   break;
			   }
		  
			   
		  
	  }
	  
  }
  
  //@Test(priority=2)
  public void displayTable() {
	  
	  List <WebElement> col = driver.findElements(By.xpath("//table[@id='resultTable']//th"));
	  List <WebElement> row = driver.findElements(By.xpath("//table[@id='resultTable']//tr"));
	  
	  System.out.println(col);
	  System.out.println(row);
	  
	  for(int i=1;i<row.size();i++) {
		  for(int j=1;j<col.size();j++) {
			   WebElement data = driver.findElement(By.xpath("//table[@id='resultTable']//tr[i]//td[j]"));
			   String actualTxt=data.getText();
			   if(actualTxt.equals(""));
			   driver.findElement(By.xpath("//table[@id='resultTable']//tr[i]//td[j-1]")).click();
		  }
	  }
	  
	  
  }
  
  
  
  
  @BeforeTest
  public void launchBrowser() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void closeBrowser() {
	  driver.close();
  }
  
 // @Test(priority = 3)
  public void Delete_Employees() throws InterruptedException {
   //*[@id="resultTable"]/tbody/tr[1]/td[2]
    List<WebElement> rows=driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));
          int rowsLength=rows.size();
          System.out.println(rowsLength);
   String beforXpath="//*[@id='resultTable']/tbody/tr[";
   String AfterXpath="]/td[2]";
   for(int i=1; i<=rowsLength;i++)
   {
    String name=driver.findElement(By.xpath(beforXpath + i + AfterXpath)).getText();
    System.out.println(name);
    if(name.toLowerCase().contains("Dixit"))
    {
     driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[1]/input")).click();

    }
   }
   driver.findElement(By.id("btnDelete")).click();
   driver.findElement(By.id("dialogDeleteBtn")).click();
  }


}
