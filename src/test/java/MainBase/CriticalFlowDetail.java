package MainBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.poifs.property.Parent;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Keymethods.GrcLogin;
import Keymethods.NewCRM;
import Keymethods.Payment;
import PageFactory.GRCPageobject;
import PageFactory.HelpdeskPageobject;
import PageFactory.HomescreenPageobject;
import PageFactory.LoginPageobjects;
import PageFactory.NewCRMPageobject;
import groovyjarjarantlr4.v4.codegen.model.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CriticalFlowDetail extends HelpdeskPageobject {

	JavascriptExecutor js;
	Robot robot;
	ExtentTest test;

	public CriticalFlowDetail(WebDriver driver, String Helpdeskuserid, String helpdeskpassword, String notesname,
			String notedescrption, String QNameOfCustomer, String qaddress, String qpincode, String Professionalfees,
			String assignedtoName, String BDAgentName, String CrossSaleName, String GRCMobileNumber,
			String CrmUsernames, String CrmUserpassword, ExtentReports extentreport)
			throws InterruptedException, AWTException,ElementClickInterceptedException {
		Robot robot = new Robot();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		test = extentreport.createTest("Helpdesk");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		PageFactory.initElements(driver, GRCPageobject.class);
		PageFactory.initElements(driver, NewCRMPageobject.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(3000);
		try {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'My Interests')]")));
			driver.findElement(By.xpath("//span[contains(text(),'My Interests')]")).click();

		} catch (NoSuchElementException e7) {
			GrcLogin grclogin = new GrcLogin(driver, GRCMobileNumber);
			driver.findElement(By.xpath("//span[contains(text(),'My Interests')]")).click();
		} catch (ElementClickInterceptedException MyintrestIntercepted) {
			Thread.sleep(2500);
			driver.findElement(By.xpath("//div[contains(text(),'Continue your service request from here ')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'My Interests')]")).click();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		String Ticketid1 = HomescreenPageobject.FirstTicketID.getText().substring(1);
//System.out.println(Ticketid1);
		String e = driver.findElement(By.xpath("(//div[@class='styles_ticketDetail__jg4A0']//child::P)[1]")).getText()
				.substring(1);
		
		String MyInterestURL = driver.getCurrentUrl();
		String MyInterestURL1 = "https://grc.vakilsearch.com/grc/my-interests";
				if (MyInterestURL1.contains(MyInterestURL)) {
					test.log(Status.PASS, "MyInterestURL");
					System.out.println(MyInterestURL);
				} else {
					test.log(Status.FAIL,"MyInterestURL not same"+MyInterestURL);
					System.out.println(MyInterestURL1);
				}
		if (e.matches(e)) {
			test.log(Status.PASS, "Create a ticket from the vakilsearch.com");
		} else {

			test.log(Status.FAIL, "no lead is Create a ticket from the vakilsearch.com");
		}

		System.out.println(e);
		driver.get("https://helpdesk.vakilsearch.com/login");

		Thread.sleep(10000);
		Username.sendKeys(Helpdeskuserid);
		String text1 = Username.getText();
		String text2 = "testingsa_2_2020@vakilsearch.com";
		System.out.println(text1);
//		if (text1.contains(text2)) {
//			test.log(Status.PASS, "Yes");
//		} else {
//
//			test.log(Status.FAIL, "Username Not same");
//		}

		Password.sendKeys(helpdeskpassword);
		Signin.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Helpdesk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Tickets.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ticketid.sendKeys(e);

		Search.click();
		Firstservice.click();

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='editBtn']")));
			js.executeScript("arguments[0].scrollIntoView(true);", Editticket);
			Editticket.click();

		} catch (ElementClickInterceptedException elementintercptedEdit) {
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			Thread.sleep(3000);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@id='select2-city_filter_edit-container']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//input[@class='select2-search__field'])[3]")).sendKeys("chennai");
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Updateticket.click();
		Thread.sleep(2000);
		driver.get("https://grc.vakilsearch.com/grc/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'My Services')]")).click();Thread.sleep(2500);
		String MyServicesURL = driver.getCurrentUrl();
		String MyServicesURL1 = "https://grc.vakilsearch.com/grc/my-services/VXgxRXQ2SmVrYjNVVUFqdy58fC4yNGVkZWY1Y2RiLnx8Lgnrb6u54cOopAREu9iUZ7tVC8tWpLxMKzDegk-Cfsq3izkmU5zfatcKoNKh7FMYAfM0QGoRyW_1QwmmyOXIUuXotaHZOToRrel1bUc8MBmB";
				if (MyServicesURL.contains(MyServicesURL1)) {
					test.log(Status.PASS, "MyServicesURL");
					System.out.println(MyServicesURL1);
				} else {
					test.log(Status.FAIL,"MyServicesURL not same"+ MyServicesURL);
					System.out.println(MyServicesURL);
				}
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='styles_unMappedContent__aTAEP']/child::div"))).click();		
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//div[@class='unMappedServiceTile_shadowBlock__wSHo3']/child::div)[2]/child::span)[2]"))).click();
				
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);	
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);	
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Confirm linking')]"))).click();

		
	}

}
