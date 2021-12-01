package com.crm.workFlowLibrary;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.crm.genericLibrary.GetLogger;
import com.crm.pageLibrary.HomePage;
import com.crm.pageLibrary.Leadspage;

public class LeadWorkFlowLibrary {

	Logger log=GetLogger.writeLog(LeadWorkFlowLibrary.class);
	public boolean createLead(HomePage homePage,String leadsFirstName, String leadsLastName){
		/*Navigate to leads page*/
		log.info("Navigating to leads page from home page.");
		Leadspage leadsPage=homePage.navigateToLeadsPage();

		/*Click on add lead btn*/
		leadsPage.addlead();

		/*Fill all mandatory fields on leads create page*/
		log.info("Creating lead with first name: "+leadsFirstName+" and last name: "+leadsLastName);
		leadsPage.createLead(leadsFirstName, leadsLastName);

		/*Verify lead created*/
		log.info("Verifying leads create test status");
		boolean leadStatus=leadsPage.verifyLeadCreated(leadsLastName);
		
		/*Delete lead created*/
		//leadsPage.deleteLeadOnDetailsPage();
		
		return leadStatus;
	}
}
