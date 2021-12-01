package com.crm.workFlowLibrary;

import org.apache.log4j.Logger;

import com.crm.genericLibrary.GetLogger;
import com.crm.pageLibrary.HomePage;
import com.crm.pageLibrary.VendorPage;

public class VendorWorkFlowLibrary {
	Logger log=GetLogger.writeLog(CampaignWorkFlowLibrary.class);
	VendorPage vendor;
	public boolean createVendor(HomePage homePage,String vendorname)
	{
	log.info("navigating to vendor page ");
     vendor=homePage.navigateToVendorPage();
	vendor.createVendor(vendorname);
	log.info("Verifying create vendor test status");
	boolean vendorStatus=vendor.verifyVendorCreated(vendorname);
	return  vendorStatus;
	}
	
	public boolean searchvendor(HomePage homePage,String vendorname)
	{
		log.info("navigating to vendor page");
		vendor=homePage.navigateToVendorPage();
		vendor.search(vendorname);
		log.info("verifying search result");
		
		return false;
	}

	public void deleteVendor(HomePage homePage,String vendorname)
	{
		log.info("navigating to vendor page");
		vendor=homePage.navigateToVendorPage();
		vendor.deleteVendor(vendorname);
		
}
	
}
