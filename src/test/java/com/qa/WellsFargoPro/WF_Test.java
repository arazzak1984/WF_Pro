package com.qa.WellsFargoPro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class WF_Test {
	WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(String user, String password) throws InterruptedException, Exception {
		  
		  HomePage1 p1=new HomePage1(driver);
		  p1.enterUser(user);
		  Thread.sleep(3000);
		  p1.enterPass(password);
		  Thread.sleep(3000);
		  //p1.CheckBox();
		//Assert.assertTrue(driver.findElement(By.xpath("//label[@class='lsc']")).isSelected());
		  //Thread.sleep(3000);
		  p1.enterLogin();
		  Thread.sleep(3000);
		  p1.goBack();
		  
	  }

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "ars", "234" },
	      new Object[] { "roksan", "789" },
	    };
	  }
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver","C:\\Driver Latest/chromedriver.exe");
	      driver= new ChromeDriver();
	      driver.get("https://wellsfargo.com/");
	      driver.manage().window().maximize();
	      Thread.sleep(3000);
	  }

	  @AfterClass
	  public void afterClass() {
		  
	  }

}
