package Keymethods;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;

import MainBase.CriticalFlowDetail;
import PageFactory.HelpdeskPageobject;

public class GrcExpand extends HelpdeskPageobject{
	
public GrcExpand(WebDriver driver,ExtentReports extentreport,String GRCMobileNumber,String  GRCNewCompanyName,
		String CINNumber,String Helpdeskuserid,String helpdeskpassword,String assignedtoName ,String CrossSaleName) throws ElementClickInterceptedException, InterruptedException, AWTException, IOException {
//GRCPage2 grcpage = new GRCPage2(driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
	//	CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName);
CriticalFlowDetail criticalflow = new CriticalFlowDetail( driver,extentreport,GRCMobileNumber,GRCNewCompanyName,
		CINNumber,Helpdeskuserid,helpdeskpassword,assignedtoName,CrossSaleName);		

	
}



}