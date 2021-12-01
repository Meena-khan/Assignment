package com.crm.workFlowLibrary;

import org.apache.log4j.Logger;

import com.crm.genericLibrary.GetLogger;
import com.crm.genericLibrary.WebDriverCommonLib;
import com.crm.pageLibrary.HomePage;
import com.crm.pageLibrary.InvoicePage;

public class InvoiceWorkFlowLib extends WebDriverCommonLib {
	Logger log=GetLogger.writeLog(InvoiceWorkFlowLib.class);
	public boolean createInvoice(HomePage homepage,String invoiceName,String billingAddress, String shippingAddress,String itemName){
		InvoicePage invoice=homepage.navigteToInvoice();
	boolean invoicestatus=invoice.createInvoice(invoiceName, billingAddress, shippingAddress, itemName);
      return invoicestatus;
	}

}
