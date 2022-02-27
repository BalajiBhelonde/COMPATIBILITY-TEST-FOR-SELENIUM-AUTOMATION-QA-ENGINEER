package Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Base;
import Pom.LoginPage;
import Pom.SignupPage;



public class Testloginpage extends Base{
	
	private WebDriver driver;
	private LoginPage loginPage;
	private SignupPage signupPage;
	private SoftAssert softassert;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
		
		@BeforeTest()
		@Parameters("browser")
		public void LaunchBrowser(String browser) {
			reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
			ExtentReports extend = new ExtentReports();
			extend.attachReporter(reporter);
			
			System.out.println("Launch the browser");

			if(browser.equals("Chrome")) 
			{
				driver = openChromeBrowser();
			}
			if(browser.equals("Firefox"))
			{
				driver = openFirefoxBrowser();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
		@BeforeClass()
		public void initilizationpomclasses() {
			 loginPage = new LoginPage(driver);
			 signupPage =new SignupPage(driver);
		}
		
		@BeforeMethod()
		public void loginpage() {
			System.out.println("Loginpage");
			driver.get("https://jt-dev.azurewebsites.net/#/SignIn");
		    softassert=new SoftAssert();
		    
		}
		
		@Test()
		public void signupPagdetails() throws InterruptedException {
			
			System.out.println("ToVerifysignPagedetail");
			boolean result= loginPage.Handledropdown();
		    Assert.assertEquals(result, true);
		    loginPage.clickonsignup();
			System.out.println(driver.getCurrentUrl());
			String url=driver.getCurrentUrl();
			System.out.println(url);
			Assert.assertEquals(url, "https://jt-dev.azurewebsites.net/#/SignUp");
			signupPage.Entername();
			signupPage.Enterorganizationame();
			signupPage.Enteremail();
			signupPage.clickcheckbox();
			signupPage.getstarted();
		
			
		  
		}
		
		
		@AfterClass()
		public void Clearobject() {
			loginPage=null;
			signupPage=null;
		}
		
		@AfterTest()
		public void closeBrowser() {
			System.out.println("ClosedBrowser");
			driver.quit();
			driver=null;
			System.gc();
		}

}
