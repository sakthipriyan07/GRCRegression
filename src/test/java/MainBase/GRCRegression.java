package MainBase;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Keymethods.Driver;
import Keymethods.GrcExpand;
import PageFactory.HelpdeskPageobject;

public class GRCRegression  extends HelpdeskPageobject {

		JavascriptExecutor js;
		Robot robot;
		ExtentTest test;
public GRCRegression(WebDriver driver) {
		}


	
public  void OnboardingFlowForNewUsers(WebDriver driver,ExtentReports extentreport,String GRCMobileNumber,String  GRCNewCompanyName,
		String CINNumber,String Helpdeskuserid,String helpdeskpassword,String assignedtoName) throws ElementClickInterceptedException, InterruptedException, AWTException {
    GrcExpand grcexpand = new GrcExpand(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);


}
public void OnboardingFlowForExistingUsers(WebDriver driver,ExtentReports extentreport,String GRCMobileNumber,String  GRCNewCompanyName,
		String CINNumber,String Helpdeskuserid,String helpdeskpassword,String assignedtoName) throws ElementClickInterceptedException, InterruptedException, AWTException {
	GrcExpand grcexpand = new GrcExpand(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);

}
public void RedactedMail(WebDriver driver,ExtentReports extentreport,String GRCMobileNumber,String  GRCNewCompanyName,
String CINNumber,String Helpdeskuserid,String helpdeskpassword,String assignedtoName) throws ElementClickInterceptedException, InterruptedException, AWTException {
	GrcExpand grcexpand = new GrcExpand(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);

}
public void CreateNewAccountUsingGRCURL(WebDriver driver,ExtentReports extentreport,String GRCMobileNumber,String  GRCNewCompanyName,
		String CINNumber,String Helpdeskuserid,String helpdeskpassword,String assignedtoName) throws ElementClickInterceptedException, InterruptedException, AWTException {
	GrcExpand grcexpand4= new GrcExpand(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);

}
public void ExistingUserLoggedInThruGRC(WebDriver driver,ExtentReports extentreport,String GRCMobileNumber,String  GRCNewCompanyName,
		String CINNumber,String Helpdeskuserid,String helpdeskpassword,String assignedtoName) throws ElementClickInterceptedException, InterruptedException, AWTException {
	GrcExpand grcexpand5 = new GrcExpand(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);

}
public void ComplianceReminderMail(WebDriver driver,ExtentReports extentreport,String GRCMobileNumber,String  GRCNewCompanyName,
		String CINNumber,String Helpdeskuserid,String helpdeskpassword,String assignedtoName) throws ElementClickInterceptedException, InterruptedException, AWTException {
	GrcExpand grcexpand6 = new GrcExpand(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
    		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);


}
}