package com.ether.genericLibrary;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * 
 * @author Meena
 *
 */
public class Driver {

	public static WebDriver driver;
	public static String ieDriverPath="C:\\Softwares\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe";
	public static String chromeDriverPath="D:\\drivers\\chromedriver.exe";

	@SuppressWarnings("deprecation")
	public static WebDriver getDriver(String browserName){

		if(browserName.equalsIgnoreCase("firefox")){
			FirefoxProfile profile = new FirefoxProfile();
//			((Object) profile).setEnableNativeEvents(true);
			driver=new FirefoxDriver((Capabilities) profile);
		}else if(browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver",ieDriverPath);
			driver=new InternetExplorerDriver();
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("disable-infobars");

			chromeOptions.addExtensions((new File(Constants.extensionPath)));
			driver=new ChromeDriver(chromeOptions);
		
		}
		return driver;
	}
}
