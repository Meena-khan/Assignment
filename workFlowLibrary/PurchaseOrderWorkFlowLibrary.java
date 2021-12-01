package com.crm.workFlowLibrary;

import org.apache.log4j.Logger;
 


import com.crm.genericLibrary.GetLogger;
import com.crm.pageLibrary.HomePage;
import com.crm.pageLibrary.PurchaseOrderPage;

public class PurchaseOrderWorkFlowLibrary {

	Logger log=GetLogger.writeLog(PurchaseOrderWorkFlowLibrary.class);
	
	public boolean createPurchaseOrder(HomePage homePage,String poItemName, String poVendorName, String poStatus, String poBillingAddress, String poShippingAddress){
		/*Navigate to purchase order page*/
		log.info("Navigating to purchase order page from home page.");
		PurchaseOrderPage purchaseOrderPage = homePage.navigateToPurchaseOrderPage();

		/*Click on add purchase order btn*/
		purchaseOrderPage.addPurchaseOrder();

		/*Fill all mandatory fields on purchase order create page*/
		log.info("Creating contact with item name: "+poItemName+" and order status: "+poStatus);
		purchaseOrderPage.createPurchaseOrder(poItemName, poVendorName, poStatus, poBillingAddress, poShippingAddress);

		/*Verify purchase order created*/
		log.info("Verifying purchase order create test status");
		boolean poVerifyStatus=purchaseOrderPage.verifyPurchaseOrderCreated("Purchase Order - "+poItemName, poStatus);
		
		return poVerifyStatus;
	}
	
	public void deletePurchaseOrder(HomePage homePage)
	{
	//	Navigate to purchase order page
		log.info("Navigating to purchase order page from home page.");
		PurchaseOrderPage purchaseOrderPage = homePage.navigateToPurchaseOrderPage();
	
		log.info("Click on checkbox field.");
		/*click on checkbox.*/
		purchaseOrderPage.getCheckBoxField().click();
		
		log.info("Click on actions Button.");
		/*click on Actions btn.*/
		purchaseOrderPage.getActionsField().click();
		
	log.info("Click on delete button.");
		/*click on Delete btn.*/
		purchaseOrderPage.getDeleteField().click();
		
		log.info("Click on yes button.");
		/*click on yes btn.*/
		purchaseOrderPage.getYesField().click();
		
		log.info("Purchase Order field is deleted.");
	}

	public void editPurchaseOrder(HomePage homePage, String subject) {
		/*Navigate to Edit purchase order page*/
		log.info("Navigating to Edit purchase order page from home page.");
		PurchaseOrderPage purchaseOrderPage = homePage.navigateToPurchaseOrderPage();
		
		
		
		
		purchaseOrderPage.getCheckbtn().click();
		 log.info("Click on check button");
		purchaseOrderPage.getActionbtn().click();
		 log.info("Click on action button");
		purchaseOrderPage.getEditbtn().click();
		 log.info("Click on Edit button");
		purchaseOrderPage.getSubjectbox().sendKeys(subject);
		 log.info("Enter value in subject box");

	
}
}
