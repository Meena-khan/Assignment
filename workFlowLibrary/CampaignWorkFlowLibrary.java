package com.crm.workFlowLibrary;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.crm.genericLibrary.GetLogger;
import com.crm.pageLibrary.CampaignPage;
import com.crm.pageLibrary.HomePage;

public class CampaignWorkFlowLibrary {
	Logger log=GetLogger.writeLog(CampaignWorkFlowLibrary.class);
			
	public boolean createCampaign(HomePage homePage,String campaignName, String campaignClosingDate){
		/*Navigate to campaign page*/
		log.info("Navigating to campaign page from home page.");
		CampaignPage campaignPage= homePage.navigateToCampaignsPage();

		/*Click on add campaign btn*/
		campaignPage.addCampaign();

		/*Fill all mandatory fields on campaign create page*/
		log.info("Creating campaign with campaign name: "+campaignName+" and campaign closing date:"+campaignClosingDate);
		campaignPage.createCampaign(campaignName, campaignClosingDate);

		/*Verify campaign created*/
		log.info("Verifying campaign create test status");
		boolean campaignStatus=campaignPage.verifyCampaignCreated(campaignName);
		
		/*Delete campaign created*/
		//campaignPage.deleteCampaignOnDetailsPage();
		
		return campaignStatus;
	}

}
