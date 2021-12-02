package com.ether.genericLibrary;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * @author Meena Khan
 *
 */
public class WebDriverBusinessLib {

	ObjectRepository obj = new ObjectRepository();
	JavascriptExecutor js = (JavascriptExecutor) Driver.driver;

	/**
	 * implicit wait
	 */
	public void implicitLoadTime() {
		Driver.driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
	}

	/**
	 * method to navigate through the etherscan register page
	 * 
	 * @return
	 * @throws IOException
	 */
	public Boolean navigateToAPP() throws IOException {
		Boolean flag = false;
		Properties registrationPage = obj.getObjectPage(Constants.registorPath);
		String registrationValidationText = registrationPage.getProperty("registrationPageTxt");

		Driver.driver.get(Constants.etherUrl);
		implicitLoadTime();
		if (Driver.driver.findElement(By.xpath(registrationValidationText)).isDisplayed()) {
			flag = true;
		}
		return flag;
	}


	/**
	 * method to register a user successful
	 * @param userName
	 * @param email
	 * @param password
	 * @param confirmPassword
	 * @param captchaFill
	 * @return
	 * @throws IOException
	 */
	public boolean fillRegistrationForm(String userName, String email, String password, String confirmPassword,
			Boolean captchaFill) throws IOException {

		Boolean flag = false;
		Properties registrationPage = obj.getObjectPage(Constants.registorPath);

		String usernameNamebox = registrationPage.getProperty("userNameEdt");
		String emailbox = registrationPage.getProperty("emailEdt");
		String passwordbox = registrationPage.getProperty("passwordEdt");
		String confirmPassowrdbox = registrationPage.getProperty("confirmPasswordEdt");
		String termAndCondition = registrationPage.getProperty("termAndConditionChbk");
		String subscribeNewsletter = registrationPage.getProperty("subscribeNewsletterChbx");
		String captcha = registrationPage.getProperty("captchaChbx");
		String creatAccount = registrationPage.getProperty("creatAccountBtn");
		String sucessfulRegistrationText = registrationPage.getProperty("sucessfulRegistration");
		String captchaValidationMsgText = registrationPage.getProperty("captchaValidationMsg");

		Driver.driver.findElement(By.xpath(usernameNamebox)).sendKeys(userName);
		Driver.driver.findElement(By.xpath(emailbox)).sendKeys(email);
		Driver.driver.findElement(By.xpath(passwordbox)).sendKeys(password);
		Driver.driver.findElement(By.xpath(confirmPassowrdbox)).sendKeys(confirmPassword);
		JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
		js.executeScript("window.scrollBy(0,250)", "");
		js.executeScript("arguments[0].click();", Driver.driver.findElement(By.xpath(termAndCondition)));
		js.executeScript("arguments[0].click();", Driver.driver.findElement(By.xpath(subscribeNewsletter)));

		Driver.driver.manage().window().maximize();
		if (captchaFill == true) {
			Driver.driver.findElement(By.xpath(captcha)).click();
			implicitLoadTime();

			js.executeScript("window.scrollBy(0,250)", "");
			Driver.driver.findElement(By.xpath(creatAccount)).click();
			implicitLoadTime();

			if (Driver.driver.findElement(By.xpath(sucessfulRegistrationText)).isDisplayed()) {
				System.out.println("Registration is successful");
				flag = true;
			} else {
				System.out.println("Registration is failed");
				flag = false;
			}
		} else {
			js.executeScript("window.scrollBy(0,250)", "");
			Driver.driver.findElement(By.xpath(creatAccount)).click();
			implicitLoadTime();

			if (Driver.driver.findElement(By.xpath(captchaValidationMsgText)).isDisplayed()) {
				System.out.println("captcha validation message is successful");
				flag = true;
			} else {
				System.out.println("captcha validation message is failed");
				flag = false;
			}
		}

		return flag;
	}

	/**
	 * method for verifying the validation message
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean validateErrorMessagesOnRegistrationForm() throws IOException {

		ObjectRepository obj = new ObjectRepository();
		Properties registrationPage = obj.getObjectPage(Constants.registorPath);

		String userNameInvalidAccessText = registrationPage.getProperty("userNameInvalidAccess");
		String emailAddressValidationMsgText = registrationPage.getProperty("emailAddressValidationMsg");
		String passwordValidationMsgText = registrationPage.getProperty("passwordValidationMsg");
		String termAndConditionsValidationMsgText = registrationPage.getProperty("termAndConditionsValidationMsg");
		String creatAccount = registrationPage.getProperty("creatAccountBtn");

		JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
		js.executeScript("window.scrollBy(0,250)", "");

		Driver.driver.findElement(By.xpath(creatAccount)).click();
		Boolean flag = false;

		if (Driver.driver.findElement(By.xpath(userNameInvalidAccessText)).isDisplayed()
				&& Driver.driver.findElement(By.xpath(emailAddressValidationMsgText)).isDisplayed()
				&& Driver.driver.findElement(By.xpath(passwordValidationMsgText)).isDisplayed()
				&& Driver.driver.findElement(By.xpath(termAndConditionsValidationMsgText)).isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * for validating the links on the page and checking the page is landing
	 * successfully
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean validateLinksOnRegistrationPage() throws IOException {

		ObjectRepository obj = new ObjectRepository();
		Properties registrationPage = obj.getObjectPage(Constants.registorPath);

		String termsAndConditionLink = registrationPage.getProperty("termsAndConditionLnk");
		String unsubscribeLink = registrationPage.getProperty("unsubscribeLnk");
		String termOfServiceText = registrationPage.getProperty("termOfServiceTxt");
		String unsubscribeText = registrationPage.getProperty("unsubscribeTxt");

		Driver.driver.findElement(By.xpath(termsAndConditionLink)).click();
		implicitLoadTime();
		Set<String> set = Driver.driver.getWindowHandles();
		Iterator<String> itr = set.iterator();

		String firstWindow = itr.next();
		String secondWindow = itr.next();

		Driver.driver.switchTo().window(secondWindow);
		Boolean flag = false;

		if (Driver.driver.findElement(By.xpath(termOfServiceText)).isDisplayed()) {
			flag = true;
		}

		Driver.driver.close();
		Driver.driver.switchTo().window(firstWindow);

		Driver.driver.findElement(By.xpath(unsubscribeLink)).click();
		implicitLoadTime();
		Set<String> set1 = Driver.driver.getWindowHandles();
		Iterator<String> itr1 = set1.iterator();

		String firstWindow1 = itr1.next();
		String secondWindow1 = itr1.next();

		Driver.driver.switchTo().window(secondWindow1);
		Boolean flag1 = false;

		if (Driver.driver.findElement(By.xpath(unsubscribeText)).isDisplayed()) {
			flag1 = true;
		}
		Driver.driver.close();
		Driver.driver.switchTo().window(firstWindow1);
		Boolean newFlag = false;

		if (flag && flag1) {
			newFlag = true;
		}
		return newFlag;
	}

	/**
	 * validation message verification for incomplete registration form
	 * @param userName
	 * @param email
	 * @return
	 * @throws IOException
	 */
	public boolean validateErrorMessageForIncompleteRegistrationForm(String userName, String email) throws IOException {

		Properties registrationPage = obj.getObjectPage(Constants.registorPath);

		String usernameNamebox = registrationPage.getProperty("userNameEdt");
		String emailbox = registrationPage.getProperty("emailEdt");
		String termAndConditionsValidationMsg = registrationPage.getProperty("termAndConditionsValidationMsg");
		String passwordValidationMsgText = registrationPage.getProperty("passwordValidationMsg");

		String creatAccount = registrationPage.getProperty("creatAccountBtn");

		Driver.driver.findElement(By.xpath(usernameNamebox)).sendKeys(userName);
		Driver.driver.findElement(By.xpath(emailbox)).sendKeys(email);
		JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
		js.executeScript("window.scrollBy(0,250)", "");

		Driver.driver.findElement(By.xpath(creatAccount)).click();
		Boolean flag = false;

		if (Driver.driver.findElement(By.xpath(termAndConditionsValidationMsg)).isDisplayed()
				&& Driver.driver.findElement(By.xpath(passwordValidationMsgText)).isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
}
