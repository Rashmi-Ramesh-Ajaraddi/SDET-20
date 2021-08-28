package MMT_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath = "//div[@class='makeFlex column flexOne whiteText latoBold']")
	private WebElement loginLink1;
	
	@FindBy(id="username")
	private WebElement UN;
	
	@FindBy(xpath= "//button[@class='capText font16']")
	private WebElement ContinueBTN;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement PWD;

	@FindBy(xpath= "//span[text() ='Login']")
	private WebElement LOginBtn;
	

	
	public void loginToApp() {
		loginLink1.click();
		UN.sendKeys("rashmiajaraddi@gmail.com");
		ContinueBTN.click();
		PWD.sendKeys("rashmi@123");
		LOginBtn.click();
		
	}
	
	
	

}
