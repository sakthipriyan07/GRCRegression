package Keymethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import MainBase.CriticalFlowDetail;
import PageFactory.GRCPageobject;

public class GrcLogin {

	ExtentTest test;

	public GrcLogin(WebDriver driver, String GRCMobileNumber) throws InterruptedException, AWTException {
		PageFactory.initElements(driver, GRCPageobject.class);
		Robot robot = new Robot();
		driver.get("https://grc.vakilsearch.com/grc/login");
		Thread.sleep(2500);
		
		GRCPageobject.GRCUsername.sendKeys("8056016697");
		Thread.sleep(2500);
		GRCPageobject.	GRCPhonenumberConfirm.click();
		Thread.sleep(3000);
		
		GRCPageobject.GRCOTP1.sendKeys("0");
		GRCPageobject.GRCOTP2.sendKeys("0");
		GRCPageobject.GRCOTP3.sendKeys("0");
		GRCPageobject.GRCOTP4.sendKeys("0");
		Thread.sleep(1500);
	
		try {
			GRCPageobject.	GRCOTPConfirm.click();
		} catch (NoSuchElementException Login) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
	}
}
