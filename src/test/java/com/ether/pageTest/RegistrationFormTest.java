package com.ether.pageTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.ether.genericLibrary.Driver;
import com.ether.genericLibrary.ExcelLib;
import com.ether.genericLibrary.WebDriverCommonLib;

/**
 * 
 * @author Meena
 *
 */
public class RegistrationFormTest {

	WebDriver driver;

	ExcelLib excelLib;
	String userName;
	String email;
	String password;
	String confirmPassword;
	
	WebDriverCommonLib webDriverCommonLib = new WebDriverCommonLib();

	@BeforeClass
	public void configBeforeClass() throws InvalidFormatException, IOException {
		driver = Driver.getDriver("chrome");
	}

	@BeforeMethod
	public void configBeforeMtd(XmlTest paramConfig) throws InvalidFormatException, IOException {
		// read data from workbook
		excelLib = new ExcelLib();
		userName = excelLib.getCellData("Ether", 2, 1);
		email = excelLib.getCellData("Ether", 2, 2);
		password = excelLib.getCellData("Ether", 2, 3);
		confirmPassword = excelLib.getCellData("Ether", 2, 4);
	}

	@Test(description = "Validate registeration form of etherscan", priority = 1)
	public void fillRegistrationFormOfEther() throws Exception {
		webDriverCommonLib.navigateToAPP();
		webDriverCommonLib.fillRegistrationForm(userName, email, password, confirmPassword);
	}

	@Test(description = "Validate error message on registeration form of etherscan", priority = 2)
	public void validateErrorMessageOnRegistrationForm() throws Exception {
		webDriverCommonLib.navigateToAPP();
		webDriverCommonLib.fillRegistrationForm(userName, email, password, confirmPassword);
	}

}
