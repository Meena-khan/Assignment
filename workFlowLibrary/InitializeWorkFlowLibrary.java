package com.crm.workFlowLibrary;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericLibrary.Driver;
import com.crm.genericLibrary.GetLogger;
import com.crm.pageLibrary.HomePage;
import com.crm.pageLibrary.LoginPage;


/**
 * Step1:Using HomePage object, navigate to campaign page using homePage.navigateToCampaignPage(). 
 * This method returns CampaignPage object
 * 
 * Step2:Using CampaignPage object, create campaign using campaignPage.CreateCampaign().
 * Step3:Verify the campaign created using campaignPage.verifyCampaignCreated()
 * 
 * Step4:Using HomePage object, navigate to leads page using homePage.navigateToLeadPage()
 * 		 This method returns LeadPage object
 * Step5:Using LeadPage object, create lead using leadPage.CreateLead()
 * Step6:Verify the lead created using leadPage.verifyLeadCreated()
 * 
 * Step7:Using HomePage object, navigate to contacts page using homePage.navigateToContactsPage()
 * 		 This method returns ContactsPage object
 * Step8:Using ContactsPage object, create contact using contactsPage.CreateContacts()
 * Step9:Verify the contact created using contactsPage.verifyContactCreated()
 * 
 * Step10:Using HomePage object, navigate to purchase order page using homePage.navigateToPurchaseOrderPage()
 * 		  This method returns PurchaseOrderPage object
 * Step11:Using PurchaseOrderPage object, create purchase order using purchaseOrderPage.createPurchaseOrder()
 * Step12:Verify the purchase order created using purchaseOrderPage.verifyPurchaseOrderCreated();
 * 
 */

public class InitializeWorkFlowLibrary {
	Logger log =GetLogger.writeLog(InitializeWorkFlowLibrary.class);

	public HomePage initialize(String browserName,String url,String username,String password) throws IOException{
		Driver.getDriver(browserName);
		LoginPage loginpage=PageFactory.initElements(Driver.driver, LoginPage.class);
		HomePage homepage=loginpage.login(username, password, url);
		return homepage;				

	}

}

