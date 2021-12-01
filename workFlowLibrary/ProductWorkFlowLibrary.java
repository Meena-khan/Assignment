package com.crm.workFlowLibrary;

import org.apache.log4j.Logger;

import com.crm.genericLibrary.GetLogger;
import com.crm.pageLibrary.CampaignPage;
import com.crm.pageLibrary.HomePage;
import com.crm.pageLibrary.ProductPage;

public class ProductWorkFlowLibrary {
	
	Logger log=GetLogger.writeLog(CampaignWorkFlowLibrary.class);
	
	public boolean createProduct(HomePage homePage,String productName)
	{
		/*Navigate to Product page*/
		log.info("Navigating to Product page from home page.");
		ProductPage productPage= homePage.navigateToProductPage();

		/*Click on add Product btn*/
		productPage.addProduct();

		/*Fill all mandatory fields on product create page*/
		log.info("Creating Product with product name: "+productName);
		productPage.createProduct(productName);

		/*Verify Product created*/
		log.info("Verifying product create test status");
		boolean productStatus= productPage.verifyProductCreated(productName);
		
		
		return productStatus;
	}
	
	
	public boolean createProductWithoutName(HomePage homePage, String ErrorMessage)
	{
		/*Navigate to Product page*/
		log.info("Navigating to Product page from home page.");
		ProductPage productPage= homePage.navigateToProductPage();

		/*Click on add Product btn*/
		productPage.addProduct();

		/*Fill all mandatory fields on product create page*/
		log.info("Creating Product without product name: ");
		productPage.createProduct();

		/*Verify Product created*/
		log.info("Verifying product create test status");
		boolean productErrorStatus= productPage.verifyErrorMsg(ErrorMessage);
		
		
		
		return productErrorStatus;
	}


}
