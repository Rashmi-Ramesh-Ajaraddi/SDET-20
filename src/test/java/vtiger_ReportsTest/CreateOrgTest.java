package vtiger_ReportsTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CreateOrgTest {
	public WebDriver driver;
	public ExtentHtmlReporter reporter; 
	public ExtentReports reports;
	public ExtentTest test;
	
	
	@BeforeSuite
	public void ConfigBSTest() {
		System.out.println("=============Before Suite===============");
		reporter = new ExtentHtmlReporter("./SDET_20/ExtentReports20/SDET20_reports.html");
		reporter.config().setDocumentTitle("SDET");
		reporter.config().setTheme(Theme.STANDARD);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}
	
	@BeforeClass
	public void ConfigBCTest() {
		System.out.println("=============Launch the browser===============");
		driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void ConfigBMTest() throws Throwable {
		System.out.println("==========Login to vtiger==================");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();	
	}
	@Test
	
	public void HomeTitleTest() {
		
		test = reports.createTest("HomeTitle");
		String expectedTitleHome = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String actualTitleHome=driver.getTitle();
		System.out.println(expectedTitleHome);
		System.out.println(actualTitleHome);
		Assert.assertEquals(actualTitleHome, expectedTitleHome);
		/*if(actualTitleHome.equals(expectedTitleHome)){
			System.out.println("Pass : : Home page Title is correct ");
		}
		else {
			System.out.println("Fail : : Home page Title is Incorrect ");
	}	*/	
}
	@Test
	public void OrgTitleTest() {
		test =reports.createTest("OrgTitle");
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		String actualTitleOrg = driver.getTitle();
		String expectedTitleOrg = "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
		System.out.println(actualTitleOrg);
		System.out.println(expectedTitleOrg);
		Assert.assertEquals(actualTitleOrg, expectedTitleOrg);

		/*if(actualTitleOrg.equals(expectedTitleOrg)){
			System.out.println("Pass : : Org page Title is correct ");
		}
		else {
			System.out.println("Fail : : Org page Title is Incorrect ");
			}*/	
	}	
	@AfterMethod
	public void ConfigAMTest() {
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(administrator).perform();
		WebElement SignOut = driver.findElement(By.linkText("Sign Out"));
		SignOut.click();
}
	
	@AfterClass
	public void ConfigACTest() {
		System.out.println("===============Close the browser===============");
		driver.quit();
	}
	
	@AfterSuite
	public void CreateContactsASTest() {
		reports.flush();
		System.out.println("============Close the DB===========");
	}


}
