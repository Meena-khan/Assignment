package com.ether.genericLibrary;


/**
 * @author Meena Khan
 *
 */
public interface Constants {
	String frameworkPath=System.getProperty("user.dir");
	String excelFilePath=frameworkPath+"\\src\\main\\resources\\com\\ether\\excelData\\etherData.xlsx";
	String screenShotFolderPath=frameworkPath+"\\ScreenShot\\";
    String registorPath =frameworkPath+"\\src\\main\\java\\com\\ether\\pageLibrary\\register.properties";
    String extensionPath =frameworkPath+"\\src\\main\\resources\\com\\app\\app.crx";
    String pathToChrome ="C:\\Users\\Meena Khan\\AppData\\Local\\Google\\Chrome";
	String etherUrl="https://etherscan.io/register";
	Long implicitWait=(long) 30;
	Long pageLoadTime=(long)50;

   
}
