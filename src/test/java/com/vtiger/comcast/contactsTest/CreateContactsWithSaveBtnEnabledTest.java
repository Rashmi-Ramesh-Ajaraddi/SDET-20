package com.vtiger.comcast.contactsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.pomrepositorylib.ContactsInfoPage;
import com.vtiger.comcast.pomrepositorylib.ContactsPage;
import com.vtiger.comcast.pomrepositorylib.CreateNewContactsPage;
import com.vtiger.comcast.pomrepositorylib.HomePage;
//@Listeners(com.vtiger.comcast.genericUtility.ListImpClass.class)

public class CreateContactsWithSaveBtnEnabledTest extends BaseClass {

	@Test
	public void CreateContactsSaveEnabledTest() throws Throwable {
		
		int randomInt = jLib.getRanDomNumber();
		String ContName = eLib.getDataFromExcel("Sheet1", 5, 2) + randomInt;

		HomePage homePage = new HomePage(driver);
		homePage.getContactsLink().click();
		
		ContactsPage contact = new ContactsPage(driver);
		contact.getCreateContactsImg().click();
		
		CreateNewContactsPage createContacts = new CreateNewContactsPage(driver);
		createContacts.CreateContacts(ContName, true);
		
		ContactsInfoPage continform = new ContactsInfoPage(driver);

		String  actSuccesfullMg =  continform.getSuccesfullMsg().getText();
		boolean VerifySuccessSaveMsg = actSuccesfullMg.contains(ContName);
        Assert.assertTrue(VerifySuccessSaveMsg);     	
	}
	
	@Test
	
	public void CreateContactCancelBtnTest() throws Throwable {
		
		int randomInt = jLib.getRanDomNumber();
		String ContName = eLib.getDataFromExcel("Sheet1", 5, 2) + randomInt;

		HomePage homePage = new HomePage(driver);
		homePage.getContactsLink().click();
		
		ContactsPage contact = new ContactsPage(driver);
		contact.getCreateContactsImg().click();
		
		CreateNewContactsPage createContacts = new CreateNewContactsPage(driver);
		createContacts.CreateContacts(ContName);
		
		String  actSuccesfullMg = contact.getContactsCancelTextMsg().getText();

		boolean VerifySuccessSaveMsg = actSuccesfullMg.contains("Contacts");
        Assert.assertTrue(VerifySuccessSaveMsg);     	

	}	
}

		
		


