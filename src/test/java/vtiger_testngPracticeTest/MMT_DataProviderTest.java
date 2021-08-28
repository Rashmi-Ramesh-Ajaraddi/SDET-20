package vtiger_testngPracticeTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class MMT_DataProviderTest {
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;

	@Test(dataProvider ="bookTicketDataProvider")
	public void bookTicketsTest(String source, String destination, int NumTickets) {
		System.out.println("=============Launch the Browser=======");
		driver = new ChromeDriver();
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/flights/");
		
	
	}
	@DataProvider
	public Object[][] bookTicketDataProviderTest() throws Exception{
		Object[][] objArray = new Object[5][3];
		objArray[0][0] = "Banaglore";
		objArray[0][1] = "Delhi";
		objArray[0][2] = 10;
		
		objArray[1][0] = "Banaglore";
		objArray[1][1] = "Chennai";
		objArray[1][2] = 20;

		objArray[2][0] = "Kerala";
		objArray[2][1] = "Banaglore";
		objArray[2][2] = 30;
		
		objArray[3][0] = "Dubai";
		objArray[3][1] = "Banaglore";
		objArray[3][2] = 50;
		
		objArray[4][0] = "Banaglore";
		objArray[4][1] = "Jharkand";
		objArray[4][2] = 40;
		
		return objArray;
	}

}
