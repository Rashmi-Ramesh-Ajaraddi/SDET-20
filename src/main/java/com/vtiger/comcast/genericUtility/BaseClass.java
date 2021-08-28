package com.vtiger.comcast.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;
	
	/*Object Creation for Lib*/
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public SoftAssert soft = new SoftAssert();
	
	@BeforeSuite(groups = {"SmokeTesting" , "FullRegressionTesting"})
	public void ConfigBSTest() {
		System.out.println("================connect to DB=============");
		
	}
	
	/*@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTesting" , "FullRegressionTesting"})
	public void ConfigBCTest(String BROWSER) throws Throwable {
		System.out.println("=============Launch the Browser=======");
		if(BROWSER.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equals("opera")) {
			driver= new OperaDriver();
		}else {
			driver= new ChromeDriver();

		}
		
	}*/
	
	@BeforeClass(groups = {"SmokeTesting" , "FullRegressionTesting"})
	public void ConfigBCTest() throws Throwable {
		System.out.println("=============Launch the Browser=======");
		driver = new ChromeDriver();
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
		sDriver = driver;
	}
	
	@BeforeMethod(groups = {"SmokeTesting" , "FullRegressionTesting"})
	public void ConfigBMTest() throws Throwable {
		/*common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		/* Navigate to app*/
		   driver.get(URL);
		   LoginPage loginPage = new LoginPage(driver);
		   loginPage.loginToApp(USERNAME, PASSWORD);
		}
	
	@AfterMethod(groups = {"SmokeTesting" , "FullRegressionTesting"})
	public void ConfigAMTest() {
		HomePage homePage = new HomePage(driver);
		homePage.LogOut();
	}
	
	@AfterClass(groups = {"SmokeTesting" , "FullRegressionTesting"})
	public void ConfigAC() {
		System.out.println("===============Close the browser===============");
		driver.quit();
	}
	
	@AfterSuite(groups = {"SmokeTesting" , "FullRegressionTesting"})
	public void CreateContactsAS() {
		System.out.println("============close DB===========");
	}
}
