package Keymethods;

import java.awt.AWTException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;

import PageFactory.HelpdeskPageobject;

public class GrcExpand extends HelpdeskPageobject{
	
public GrcExpand(WebDriver driver,ExtentReports extentreport,String GRCMobileNumber,String  GRCNewCompanyName,
		String CINNumber,String Helpdeskuserid,String helpdeskpassword,String assignedtoName) throws ElementClickInterceptedException, InterruptedException, AWTException {
GRCPage grcpage = new GRCPage(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);
		
driver.close();	
	
}



}