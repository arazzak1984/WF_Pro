package com.qa.WellsFargoPro;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage1 {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	// Compile Class....
	
	@FindBy(id="userid")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement PassField;
	
	@FindBy(xpath="//label[@class='lsc']")
	WebElement CheckB;
	
	@FindBy(id="btnSignon")
	WebElement Login;
	
	public HomePage1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUser(String user) throws IOException {
		Username.clear();
		Username.sendKeys(user);
	}
	
	public void enterPass(String password) throws IOException {
		PassField.clear();
		PassField.sendKeys(password);
	}
	
	public void CheckBox() {
	
		CheckB.click();
		
	}
	
	public void enterLogin() {
		Login.click();
	}
	public void goBack() {
		driver.navigate().back();
	}
	
	
	
	
}
