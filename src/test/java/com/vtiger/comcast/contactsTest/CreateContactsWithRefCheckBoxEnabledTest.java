package com.vtiger.comcast.contactsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.pomrepositorylib.ContactsInfoPage;
import com.vtiger.comcast.pomrepositorylib.ContactsPage;
import com.vtiger.comcast.pomrepositorylib.CreateNewContactsPage;
import com.vtiger.comcast.pomrepositorylib.HomePage;

//@Listeners(com.vtiger.comcast.genericUtility.ListImpClass.class)

public class CreateContactsWithRefCheckBoxEnabledTest extends BaseClass{
	
	@Test(groups = "SmokeTesting")
	
public void CreateContactsSaveEnabledTest() throws Throwable {
		
		/*test script Data*/
		int randomInt = jLib.getRanDomNumber();
		String ContName = eLib.getDataFromExcel("Sheet1", 5, 2) + randomInt;

        /*step 2 : navigate to Contacts*/
		HomePage homePage = new HomePage(driver);
		homePage.getContactsLink().click();
		
        /*step 3 : navigate to "create new Contacts"page by click on "+" image */
		ContactsPage contact = new ContactsPage(driver);
		contact.getCreateContactsImg().click();
		
        /*step 4 : create Contacts*/
		CreateNewContactsPage createContacts = new CreateNewContactsPage(driver);
		createContacts.CreateContacts(ContName, true);
		
	    /*step 5 : verify the successful msg with org name*/
		ContactsInfoPage continform = new ContactsInfoPage(driver);

		String  actSuccesfullMg =  continform.getSuccesfullMsg().getText();
        boolean VerifySuccessSaveMsg = actSuccesfullMg.contains(ContName);
        Assert.assertTrue(VerifySuccessSaveMsg);     	
	}
	

	@Test(groups = {"FullRegressionTesting"})
	public void CreateContWithReferenceTest() throws Throwable {
			
		int randomInt = jLib.getRanDomNumber();
		
		/*test script Data*/
		String ContName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomInt;
		
        /*step 2 : navigate to Contacts*/
		HomePage homePage = new HomePage(driver);
		homePage.getContactsLink().click();
			
        /*step 3 : navigate to "create new Contacts"page by click on "+" image */
		ContactsPage contact = new ContactsPage(driver);
		contact.getCreateContactsImg().click();
			
		CreateNewContactsPage createContacts = new CreateNewContactsPage(driver);
		createContacts.CreateContacts(ContName, true, false);
			
		ContactsInfoPage continform = new ContactsInfoPage(driver);

		/*Verification of Create Contacts*/
		String  actSuccesfullMg =  continform.getSuccesfullMsg().getText();
		boolean VerifySuccessSaveMsg = actSuccesfullMg.contains(ContName);
	    Assert.assertTrue(VerifySuccessSaveMsg);     	
		
		/*Verification of Reference dropdown enable*/

	     String  actRefSuccMsg = continform.getRefDropDownEnabled().getText();
	     boolean VerifyRefDropdownEnabled = actRefSuccMsg.contains("yes");
	     soft.assertTrue(VerifyRefDropdownEnabled);
	     soft.assertAll();
	     
}
	
	@Test(groups = {"FullRegressionTesting"})
	
public void CreateContWithNotifyTest() throws Throwable {
		
		/*test script Data*/
		int randomInt = jLib.getRanDomNumber();
		String ContName = eLib.getDataFromExcel("Sheet1", 5, 2) + randomInt;

        /*step 2 : navigate to Contacts*/
		HomePage homePage = new HomePage(driver);
		homePage.getContactsLink().click();
		
        /*step 3 : navigate to "create new Contacts"page by click on "+" image */
		ContactsPage contact = new ContactsPage(driver);
		contact.getCreateContactsImg().click();
		
		CreateNewContactsPage createContacts = new CreateNewContactsPage(driver);
		createContacts.CreateContacts(ContName, "a");
		
		ContactsInfoPage continform = new ContactsInfoPage(driver);

		/*Verification of Create Contacts*/

		String  actSuccesfullMg =  continform.getSuccesfullMsg().getText();
		boolean VerifySuccessSaveMsg = actSuccesfullMg.contains(ContName);
	    Assert.assertTrue(VerifySuccessSaveMsg);     	
		
		/*Verification of Notofication dropdown enable*/

		String  actNotiSuccMsg = continform.getNotifyDropDownEnabled().getText();
		boolean VerifyNotofyDropdownEnabled = actNotiSuccMsg.contains("yes");
	     soft.assertTrue(VerifyNotofyDropdownEnabled);
	     soft.assertAll();
	     
	}
        @Test(groups = {"FullRegressionTesting"})
        
        public void CreateContWithPortalTest() throws Throwable {
        	
    		/*test script Data*/
        	int randomInt = jLib.getRanDomNumber();
    		/*test script Data*/
    		String ContName = eLib.getDataFromExcel("Sheet1", 5, 2) + randomInt;
    		
            /*step 2 : navigate to Contacts*/
    		HomePage homePage = new HomePage(driver);
    		homePage.getContactsLink().click();
    		
            /*step 3 : navigate to "create new Contacts"page by click on "+" image */
    		ContactsPage contact = new ContactsPage(driver);
    		contact.getCreateContactsImg().click();
    	
    		CreateNewContactsPage createContacts = new CreateNewContactsPage(driver);
    		createContacts.CreateContactsPort(ContName, driver);
    		
    		ContactsInfoPage continform = new ContactsInfoPage(driver);

    		/*Verification of Create Contacts*/

    		String  actSuccesfullMg =  continform.getSuccesfullMsg().getText();
    		boolean VerifySuccessSaveMsg = actSuccesfullMg.contains(ContName);
    	    Assert.assertTrue(VerifySuccessSaveMsg);     	
    		
			/*Verification of  Portal dropdown enable*/

    		String  actPortSuccMsg = continform.getPortalDropDownEnabled().getText();
    		boolean VerifyPortDropdownEnabled = actPortSuccMsg.contains("yes");
   	     	soft.assertTrue(VerifyPortDropdownEnabled);
   	     	soft.assertAll();
   	         	
	}
}

