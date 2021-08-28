package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement userPassword;
	
	@FindAll({@FindBy(id = "submitButton") , @FindBy(xpath = "//input[@id ='submitButton']")})
	private WebElement loginBtn;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp(String userName, String password) {
		userNameEdt.sendKeys(userName);
		userPassword.sendKeys(password);
		loginBtn.click();
		
	}
	
	
	
	
	


}
