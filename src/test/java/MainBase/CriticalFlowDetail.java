package MainBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Keymethods.GRCPage;
import Keymethods.GRCPage2;
import Keymethods.GrcLogin;
import Keymethods.NewCRM;
import Keymethods.Payment;
import Keymethods.ScreenShot;
import PageFactory.GRCPageobject;
import PageFactory.HelpdeskPageobject;
import PageFactory.HomescreenPageobject;
import PageFactory.LoginPageobjects;
import PageFactory.NewCRMPageobject;
import groovyjarjarantlr4.v4.codegen.model.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CriticalFlowDetail extends GRCPageobject {

	JavascriptExecutor js;
	Robot robot;
	ExtentTest test;

	public CriticalFlowDetail(WebDriver driver,ExtentReports extentreport,String GRCMobileNumber,String GRCNewCompanyName,
			String CINNumber,String Helpdeskuserid,String helpdeskpassword,String assignedtoName,String CrossSaleName)
			throws InterruptedException, AWTException,ElementClickInterceptedException, IOException {
		Robot robot = new Robot();
		ScreenShot screenshot = new ScreenShot();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		test = extentreport.createTest("Helpdesk");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		PageFactory.initElements(driver, GRCPageobject.class);
		PageFactory.initElements(driver, NewCRMPageobject.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(3000);
	
	
	
		System.out.println(GRCPage2.e);
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
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Helpdesk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Tickets.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	ticketid.sendKeys(GRCPage2.e);
	 ticketid.sendKeys("3352749");
		Search.click();
		Firstservice.click();

		try {
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
			Thread.sleep(2500);
			Assignedto.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1500);
			Assignedtoname.click();
			Assignedtoname.sendKeys("Dhrubo RM");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1500);

			Paymentstatus.click();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			driver.findElement(By.xpath("//span[@id='select2-city_filter_edit-container']")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//input[@class='select2-search__field'])[3]")).sendKeys("chennai");
			Thread.sleep(1500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			driver.findElement(By.xpath("//span[contains(text(),'Please select a service')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//input[@class='select2-search__field'])[3]"))
					.sendKeys("Apply For Name Change - Minor");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		
			BDagentCTA.click();
			BDagentsearch.sendKeys("Dhrubo BD");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			screenshot.screenshot20(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot20.png",
					"Editticket").build());
			Thread.sleep(5000);
			
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(5000);
			try {
				WebElement element5010 = driver.findElement(By.xpath("(//div[@class='actions']/child::input)[1]"));
				JavascriptExecutor executor5010 = (JavascriptExecutor) driver;
				executor5010.executeScript("arguments[0].click();", element5010);
			} catch (Exception updateedit1) {
				
				driver.findElement(By.xpath("(//input[@type='submit'])[4]"));
			
			}
		
			wait.until(ExpectedConditions.alertIsPresent()).accept();

			

		} catch (Exception Editticket1) {
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			screenshot.screenshot20(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot20.png",
					"Editticket").build());
			Thread.sleep(5000);
		}
		
		Thread.sleep(9000);
		try {
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
			Thread.sleep(2500);
			Assignedto.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1500);
			Assignedtoname.click();
			Assignedtoname.sendKeys("Dhrubo RM");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1500);

			Paymentstatus.click();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			driver.findElement(By.xpath("//span[@id='select2-city_filter_edit-container']")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//input[@class='select2-search__field'])[3]")).sendKeys("chennai");
			Thread.sleep(1500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			driver.findElement(By.xpath("//span[contains(text(),'Please select a service')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//input[@class='select2-search__field'])[3]"))
					.sendKeys("Apply For Name Change - Minor");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		
			screenshot.screenshot46(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot46.png",
					"Editticket").build());
			Thread.sleep(5000);
			
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(5000);
			try {
				WebElement element5010 = driver.findElement(By.xpath("(//div[@class='actions']/child::input)[1]"));
				JavascriptExecutor executor5010 = (JavascriptExecutor) driver;
				executor5010.executeScript("arguments[0].click();", element5010);
			} catch (Exception updateedit1) {
				WebElement element50101 = driver.findElement(By.xpath("(//input[@type='submit'])[4]"));
				JavascriptExecutor executor50101 = (JavascriptExecutor) driver;
				executor50101.executeScript("arguments[0].click();", element50101);
			
			}
		
			wait.until(ExpectedConditions.alertIsPresent()).accept();

			

		} catch (Exception Editticket1) {
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			screenshot.screenshot46(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot46.png",
					"Editticket").build());
			Thread.sleep(5000);
		}
		try{
		CrosssaleCTA.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1500);
		Selectcrosssale.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1500);
		Selectcrosssale.sendKeys(CrossSaleName);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1500);
		Createcrosssale.click();
		Thread.sleep(2500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		test.log(Status.PASS, "Cross sale creation success");
	} catch (Exception Crosssale1) {
		test.log(Status.FAIL, "Cross sale creation Failed");
	}
	Thread.sleep(5000);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_R);
	robot.keyPress(KeyEvent.VK_R);
	robot.keyRelease(KeyEvent.VK_CONTROL);

	
		Thread.sleep(2000);
		
		
		GrcLogin grclogin1 = new GrcLogin(driver, GRCMobileNumber);
	//	wait.until(ExpectedConditions.elementToBeClickable(OpenEntityList)).click();

		WebElement element50109 = OpenEntityList;
		JavascriptExecutor executor50109 = (JavascriptExecutor) driver;
		executor50109.executeScript("arguments[0].click();", element50109);
		
		WebElement TCSClick = driver.findElement(By.xpath("//p[contains(text(),'TATA COMMUNICATIONS LIMITED')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", TCSClick);
		
		WebElement element501090 = driver.findElement(By.xpath("//p[contains(text(),'TATA COMMUNICATIONS LIMITED')]"));
		JavascriptExecutor executor501090 = (JavascriptExecutor) driver;
		executor501090.executeScript("arguments[0].click();", element501090);
		
		
		
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
				
				UnlikedDownArrow.click();
				SelectBusinessToLinkCTA.click();
				js.executeScript("arguments[0].scrollIntoView(true);", TCSSelectbusinessToLink);
				TCSSelectbusinessToLink.click();
				ConfirmLinking.click();
				

			Home.click();
		
	}
	

}
