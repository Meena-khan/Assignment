package com.crm.workFlowLibrary;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;

import com.crm.genericLibrary.GetLogger;
import com.crm.genericLibrary.WebDriverCommonLib;
import com.crm.pageLibrary.CampaignPage;
import com.crm.pageLibrary.HomePage;
import com.crm.pageLibrary.PurchaseOrderPage;
import com.crm.pageLibrary.SalesOrderPage;

public class SalesOrderWorkFlowLibrary extends WebDriverCommonLib {
	
	Logger log=GetLogger.writeLog(SalesOrderWorkFlowLibrary.class);
	
	public boolean createSalesOrder(HomePage homePage,String subject, String sostatus,String Billadd, String Shipadd){
		/*Navigate to Sales Order page*/
		implicitLoadTime();
		log.info("Navigating to Sales Order page from home page.");		
		SalesOrderPage salesOrderPage=homePage.navigateToSalesOrderPage();
		
		/*Click on add sales order btn*/
		salesOrderPage.addSalesOrder();

		/*Fill all mandatory fields on sales order page*/
		
	    log.info("Creating sales order with subject: "+subject);
	    salesOrderPage.CreateSalesorder(subject,sostatus, Billadd, Shipadd);
		boolean soverifystatus=salesOrderPage.verifySalesOrderCreated(subject, sostatus);
		
		/*Verify purchaseorder created*/
	
	
	return soverifystatus;	
	}
	public void deleteSalesOrder(HomePage homePage,String subject, String sostatus,String Billadd, String Shipadd,String sub){
		/*Navigate to Sales Order page*/
		implicitLoadTime();
		log.info("Navigating to Sales Order page from home page.");		
		SalesOrderPage salesOrderPage=homePage.navigateToSalesOrderPage();
		
		///*Click on add sales order btn*/
		//salesOrderPage.addSalesOrder();

		///*Fill all mandatory fields on sales order page*/
		
	   // log.info("Creating sales order with subject: "+subject);
	   // salesOrderPage.CreateSalesorder(subject,sostatus, Billadd, Shipadd);
	    salesOrderPage.DeleteSalesorder(sub);
	    
}}