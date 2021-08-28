package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContSuccMsg;

	@FindBy(xpath="//span[@id='dtlview_Reference']")
	private WebElement RefDropDownEnabled;

	@FindBy(xpath="//span[@id='dtlview_Notify Owner']")
	private WebElement NotifyDropDownEnabled;

	@FindBy(xpath="//span[@id='dtlview_Portal User']")
	private WebElement PortalDropDownEnabled;

	
	public WebElement getNotifyDropDownEnabled() {
		return NotifyDropDownEnabled;
	}

	public WebElement getPortalDropDownEnabled() {
		return PortalDropDownEnabled;
	}

	public WebElement getRefDropDownEnabled() {
		return RefDropDownEnabled;
	}

	public WebElement getContSuccMsg() {
		return ContSuccMsg;
		
	}
	

	public WebElement getSuccesfullMsg() {
		// TODO Auto-generated method stub
		return ContSuccMsg;
	}

}
