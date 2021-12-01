package com.ether.genericLibrary;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * 
 * @author meena
 *
 */
public class WebDriverCommonLib {
	String screenshotFolder = Constants.screenShotFolderPath;

	/**
	 * implicit wait
	 */
	public void implicitLoadTime() {
		Driver.driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
	}

	public void navigateToAPP() {
		Driver.driver.get(Constants.etherUrl);
		implicitLoadTime();
	}

	public boolean fillRegistrationForm(String userName, String email, String password, String confirmPassword)
			throws IOException {

		ObjectRepository obj = new ObjectRepository();
		Properties registrationPage = obj.getObjectPage(Constants.registorPath);

		String usernameNamebox = registrationPage.getProperty("userNameEdt");
		String emailbox = registrationPage.getProperty("emailEdt");
		String passwordbox = registrationPage.getProperty("passwordEdt");
		String confirmPassowrdbox = registrationPage.getProperty("confirmPasswordEdt");
		String termAndCondition = registrationPage.getProperty("termAndConditionChbk");
		String subscribeNewsletter = registrationPage.getProperty("subscribeNewsletterChbx");
		String captcha = registrationPage.getProperty("captchaChbx");
		String creatAccount = registrationPage.getProperty("creatAccountBtn");
		String solverRecaptcha = registrationPage.getProperty("captchaSolveBtn");
		String retryText = registrationPage.getProperty("retryTxt");


		Driver.driver.findElement(By.xpath(usernameNamebox)).sendKeys(userName);
		Driver.driver.findElement(By.xpath(emailbox)).sendKeys(email);
		Driver.driver.findElement(By.xpath(passwordbox)).sendKeys(password);
		Driver.driver.findElement(By.xpath(confirmPassowrdbox)).sendKeys(confirmPassword);
		JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
		js.executeScript("window.scrollBy(0,250)", "");
		js.executeScript("arguments[0].click();", Driver.driver.findElement(By.xpath(termAndCondition)));
		js.executeScript("arguments[0].click();", Driver.driver.findElement(By.xpath(subscribeNewsletter)));
		js.executeScript("arguments[0].click();", Driver.driver.findElement(By.xpath(captcha)));

//	     WebElement frame =  Driver.driver.findElement(By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']"));

		Driver.driver.manage().window().maximize();
		Driver.driver.findElement(By.xpath(captcha)).click();
		int size = Driver.driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Driver.driver.switchTo().frame(2);
		Driver.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

//		Driver.driver.findElement(By.xpath(solverRecaptcha)).click();
		Driver.driver.switchTo().defaultContent();
		js.executeScript("window.scrollBy(0,250)", "");
		Driver.driver.findElement(By.xpath(creatAccount)).click();
		implicitLoadTime();
		System.out.println("Saving data.");
		Boolean flag= false;
		if(Driver.driver.findElement(By.xpath(retryText)).isDisplayed())
		{
			flag= true;
		}else {
			flag = false;
		}
		return flag;
		
	}
}
