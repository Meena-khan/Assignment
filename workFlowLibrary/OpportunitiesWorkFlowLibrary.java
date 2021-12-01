package com.crm.workFlowLibrary;

import org.apache.log4j.Logger;

import com.crm.genericLibrary.GetLogger;
import com.crm.pageLibrary.ContactsPage;
import com.crm.pageLibrary.HomePage;
import com.crm.pageLibrary.OpportunitiesPage;

public class OpportunitiesWorkFlowLibrary {

	Logger log=GetLogger.writeLog(OpportunitiesWorkFlowLibrary.class);

	public boolean createOpportunitiesAndVerify(HomePage homePage,String opportunitiesName, String closingDate){
		/*Navigate to opportunity page*/
		log.info("Navigating to Opportunities page from home page.");
		OpportunitiesPage opportunityPage=homePage.navigateToOpportunitiesPage();

		/*Create opportunity*/
		log.info("Creating Opportunities with  name: "+opportunitiesName);
		opportunityPage.CreateOpportunities(opportunitiesName, closingDate);

		/*Verify opportunity created*/
		log.info("Verifying opportunities create test status");
		boolean contactStatus=opportunityPage.verifyOpportunitiesCreated(opportunitiesName);
		
		return contactStatus;
	}
	
	public void createOpportunityAndDelete(HomePage homePage,String opportunityName, String closingDate){
		/*Navigate to opportunity page*/
		log.info("Navigating to Opportunities page from home page.");
		OpportunitiesPage opportunityPage=homePage.navigateToOpportunitiesPage();

		

		/*Fill all mandatory fields on opportunity create page*/
		log.info("Creating Opportunities with  name: "+opportunityName);
		opportunityPage.CreateOpportunities(opportunityName, closingDate);
		
		/*Delete opportunity*/
		opportunityPage.deleteContactOnDetailsPage();
		
		
	}


}
