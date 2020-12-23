package com.OrangeHRM;

import org.testng.annotations.DataProvider;

public class OrangeHRM_testData {
	@DataProvider(name = "Login")
	 public Object[][] getDataforLogin() {
	  // Multidimensional Object
	  // 3X3 or 4X3 or 4X5
	  return new Object[][] {

	    { "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "Admin", "admin123" },
	    { "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "dixit5", "admin123" },
	    { "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "kumar", "admin123" }
	    };

}
	
	 @DataProvider(name = "LoginScenario")
	 public Object[][] getDataforLoginscenarios() {
	  // Multidimensional Object
	  // 3X3 or 4X3 or 4X5
	  return new Object[][] {

	    { "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "Admin", "admin123" },
	    { "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "dixit5", "admin123" },
	    { "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "kumar", "admin123" }
	    };
}
}
