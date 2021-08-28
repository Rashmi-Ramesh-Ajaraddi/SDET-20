package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath = "//a[text() = 'Contacts']")
	private WebElement contactsLink;
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdministrator() {
		return administrator;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void LogOut() {
		Actions act = new Actions(driver);
		act.moveToElement(administrator).perform();
		signOutLink.click();
		
	}

}
