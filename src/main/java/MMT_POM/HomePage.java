package MMT_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath="//span[text() ='From']")
	private WebElement fromDrop;
	
	@FindBy(xpath="//input[@placeholder='From']")
	private WebElement fromTF;
	
	@FindAll({ @FindBy(xpath = "//p[text() = 'Goa, India']")})	
	private WebElement PlaceText1;
	
	@FindBy(xpath="//span[text() ='To']")
	private WebElement toDestn;
	
	@FindBy(xpath="//input[@placeholder='To']")
	private WebElement toTF;
	
	@FindAll({ @FindBy(xpath = "//p[text()= 'Bengaluru International Airport']")})	
	private WebElement DestText;
	
	@FindBy(xpath = "//label[@for='travellers']")
	private WebElement Traveller1;

	
	
	public void loginToApp() {
		fromDrop.click();
		fromTF.sendKeys("Goa");
		PlaceText1.click();
		toDestn.click();
		toTF.sendKeys("Bengaluru");
		DestText.click();
		Traveller1.click();
		
		
		
		
		
		
		
		
	}


}
