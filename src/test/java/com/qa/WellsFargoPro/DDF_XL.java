package com.qa.WellsFargoPro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class DDF_XL {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
  @Test
  public void f() throws IOException, InterruptedException {
	  HomePage1 p=new HomePage1(driver);
	  
	  File src=new File("C:\\Users\\Sumon\\Desktop\\Class Stuff\\Wellsfargo DDF.xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  workbook= new XSSFWorkbook(fis);
	  sheet=workbook.getSheetAt(0);
	  for(int i=1;i<=sheet.getLastRowNum();i++) {
		  cell=sheet.getRow(i).getCell(0);
		  cell.setCellType(CellType.STRING);
		  
	  driver.findElement(By.id("userid")).clear();
	  driver.findElement(By.id("userid")).sendKeys(cell.getStringCellValue());
	  Thread.sleep(3000);
	  cell=sheet.getRow(i).getCell(1);
	  cell.setCellType(CellType.STRING);
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys(cell.getStringCellValue());
	  Thread.sleep(3000);
	  
	  p.CheckBox();
	  Thread.sleep(3000);
	  p.enterLogin();
	  Thread.sleep(3000);
	  p.goBack();
	  
		  
	  }
  }
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Driver Latest/chromedriver.exe");
      driver= new ChromeDriver();
      driver.get("https://wellsfargo.com/");
      driver.manage().window().maximize();
      Thread.sleep(3000);
      driver.manage().deleteAllCookies();
  }

  @AfterClass
  public void afterClass() {
  }

}
