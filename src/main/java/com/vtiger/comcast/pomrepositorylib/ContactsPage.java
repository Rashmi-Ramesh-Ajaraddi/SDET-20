package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactsImg;
	
	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement ContactText;
	
	@FindBy(xpath ="//a[@href='index.php?action=ListView&module=Contacts&parenttab=Marketing']")
	private WebElement ContactsCancelTextMsg;

	public WebElement getContactsCancelTextMsg() {
		return ContactsCancelTextMsg;
	}

	public void setContactsCancelTextMsg(WebElement contactsCancelTextMsg) {
		ContactsCancelTextMsg = contactsCancelTextMsg;
	}

	public WebElement getContactText() {
		return ContactText;
	}

	public WebElement getCreateContactsImg() {
		return createContactsImg;
	}

}
