package com.crm.workFlowLibrary;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.crm.genericLibrary.GetLogger;
import com.crm.pageLibrary.ContactsPage;
import com.crm.pageLibrary.HomePage;
import com.crm.pageLibrary.OpportunitiesPage;

public class ContactWorkFlowLibrary {

	Logger log=GetLogger.writeLog(ContactWorkFlowLibrary.class);

	public boolean createContact(HomePage homePage,String contactFirstName, String contactLastName){
		/*Navigate to contacts page*/
		log.info("Navigating to contacts page from home page.");
		ContactsPage contactsPage=homePage.navigateToContactsPage();

		/*Click on add contacts btn*/
		contactsPage.addContacts();

		/*Fill all mandatory fields on contacts create page*/
		log.info("Creating contact with first name: "+contactFirstName+" and last name: "+contactLastName);
		contactsPage.createContact(contactFirstName, contactLastName);

		/*Verify contact created*/
		log.info("Verifying contact create test status");
		boolean contactStatus=contactsPage.verifyContactCreated(contactLastName);
		
		/*Delete contact created*/
		//contactsPage.deleteContactOnDetailsPage();
		
		return contactStatus;
	}

	public void getContactList(HomePage homePage){
		/*Navigate to contacts page*/
		log.info("Navigating to contacts page from home page.");
		ContactsPage contactsPage=homePage.navigateToContactsPage();
		
		contactsPage.getContactListRecord();
		
	}
	
	public void createAndDelteContact(HomePage homePage, String contactFirstName, String contactLastName) {
		/*Navigate to contacts page*/
		log.info("Navigating to contacts page from home page.");
		ContactsPage contactsPage=homePage.navigateToContactsPage();

		/*Click on add contacts btn*/
		contactsPage.addContacts();

		/*Fill all mandatory fields on contacts create page*/
		log.info("Creating contact with first name: "+contactFirstName+" and last name: "+contactLastName);
		contactsPage.createContact(contactFirstName, contactLastName);
		
		/*Delete Contact*/
		contactsPage.deleteContactOnDetailsPage();
	}
}
