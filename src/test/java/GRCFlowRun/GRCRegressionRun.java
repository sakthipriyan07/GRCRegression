package GRCFlowRun;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;


import MainBase.*;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.EmailableReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Keymethods.Base;
import Keymethods.Driver;

import Keymethods.GRCPage;
import Keymethods.NewCRM;
import Keymethods.SendMailSSLWithAttachment;
import PageFactory.HomescreenPageobject;
import PageFactory.HelpdeskPageobject;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GRCRegressionRun {

	ExtentReports extentreport;
	ExtentSparkReporter htmlReporter;
	ExtentTest testcase;
 
	String[][] data = null;

	@DataProvider(name = "itemsdata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = getExcelData();
		return data;
	} 

	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\GRC-Reg-Automation\\Excel\\Items jxl.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet("Sheet5");
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String testData[][] = new String[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				testData[i][j] = sheet.getCell(j, i).getContents();

			}
		}
		System.out.println(testData.toString());
		return testData; 

	}

	public WebDriver driver;

	@BeforeSuite
	public void Login() throws InterruptedException, AWTException {
		extentreport = new ExtentReports();
		htmlReporter = new ExtentSparkReporter("extentreport.html");
		extentreport.attachReporter(htmlReporter);

	}
 
	@BeforeTest
	public void Max() throws InterruptedException, AWTException {
		Driver d = new Driver(driver);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1440, 900));

		driver.manage().window().maximize();

	}

	@BeforeClass
	public void url() throws InterruptedException, AWTException {

		PageFactory.initElements(driver, HomescreenPageobject.class);
		PageFactory.initElements(driver, HelpdeskPageobject.class);
		Thread.sleep(3000);

	} 

	@Test(dataProvider = "itemsdata")
	public void Customercreation100(String Username, String Mobilenumber, String Helpdeskuserid,
			String helpdeskpassword, String notesname, String notedescrption, String QNameOfCustomer, String qaddress,
			String qpincode, String Professionalfees, String assignedtoName, String BDAgentName, String CrossSaleName,
			String GRCMobileNumber, String GRCNewCompanyName, String CINNumber, String CrmUsernames,
			String CrmUserpassword) throws Exception {

		GRCRegression grcregression = new GRCRegression(driver);
	
	//	grcregression.OnboardingFlowForNewUsers(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
	  //  		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);
		grcregression.OnboardingFlowForExistingUsers(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
	    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName,CrossSaleName);
//		grcregression.RedactedMail(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
//	    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);
//		grcregression.CreateNewAccountUsingGRCURL(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
//	    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);
//		grcregression.ExistingUserLoggedInThruGRC(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
//	    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);
//		grcregression.ComplianceReminderMail(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
//	    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);
		
	} 

	@AfterClass
	public void close() {
		// driver.close();
		System.out.println("The close_up process is completed");

	}

	@AfterTest
	public void Report() {
		extentreport.flush();

		System.out.println("Test completed");

	}

	@AfterSuite
	public void cleanup() throws EmailException {
		
		System.out.println("Test completed1");
		//driver.quit();
	}

}
