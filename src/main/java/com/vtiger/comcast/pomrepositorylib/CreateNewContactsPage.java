package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.BaseClass;

public class CreateNewContactsPage extends BaseClass{
	WebDriver driver;
	public CreateNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement ConLastName;
	
	@FindBy(name="reference")
	private WebElement RefereCheckBox;
	
	@FindBy(name="notify_owner")
	private WebElement NotifyOwnerCheckbox;
	
	@FindBy(name="portal")
	private WebElement PortalCheckbox;
	

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement ConSaveBtn;
	
	@FindBy(xpath ="//input[@title='Cancel [Alt+X]']")
	private WebElement ConCancelBtn;
	
	@FindBy(id="email")
	private WebElement EmailEdt;
	
	public void CreateContacts(String ContName){
		ConLastName.sendKeys(ContName);
		ConCancelBtn.click();
	}
	public void CreateContacts(String ContName, boolean f){
		ConLastName.sendKeys(ContName);
		ConSaveBtn.click();
	}
	public void CreateContacts(String ContName ,boolean j, boolean s){
		ConLastName.sendKeys(ContName);
		RefereCheckBox.click();
		ConSaveBtn.click();
	}
	
	public void CreateContacts(String ContName, String a){
		ConLastName.sendKeys(ContName);
		NotifyOwnerCheckbox.click();
		ConSaveBtn.click();
	}
	
	public void CreateContactsPort(String ContName, WebDriver driver){
		ConLastName.sendKeys(ContName);
		PortalCheckbox.click();
		ConSaveBtn.click();
		wLib.acceptAlert(driver);
		
		EmailEdt.sendKeys("abc@gmail.com");
		ConSaveBtn.click();
	}
}