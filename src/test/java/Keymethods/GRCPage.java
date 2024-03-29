package Keymethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import PageFactory.GRCPageobject;
import PageFactory.HelpdeskPageobject;
import groovyjarjarantlr4.v4.parse.ANTLRParser.element_return;

public class GRCPage extends GRCPageobject {
	ExtentTest test;

	public GRCPage(WebDriver driver, ExtentReports extentreport, String GRCMobileNumber, String GRCNewCompanyName,
			String CINNumber) throws InterruptedException, AWTException, ElementClickInterceptedException, IOException {
//		Set<String> allwindowsid = driver.getWindowHandles();
//		List<String> all = new ArrayList<>();
//		all.addAll(allwindowsid);
//		driver.switchTo().window(all.get(5));
//		List<String> all7 = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(all7.get(1));

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		Robot robot = new Robot();
		Actions actions = new Actions(driver);
		ScreenShot screenshot = new ScreenShot();
		test = extentreport.createTest("GRC Regression");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		PageFactory.initElements(driver, GRCPageobject.class);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMddyyyyHHMMSS");
		String Date2 = dateFormat1.format(new Date());
		driver.get("https://grc.vakilsearch.com/grc/login");
		Thread.sleep(2500);

		GRCUsername.sendKeys(GRCMobileNumber);
		Thread.sleep(2500);
		GRCPhonenumberConfirm.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@style='width: 1em; text-align: center;'])[1]")));
		GRCOTP1.sendKeys("0");
		GRCOTP2.sendKeys("0");
		GRCOTP3.sendKeys("0");
		GRCOTP4.sendKeys("0");
		Thread.sleep(1500);
		screenshot.screenshot1(driver, extentreport);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String Date1 = dateFormat.format(new Date());
		System.out.println(Date1);
		test.log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"\\\\14.140.167.188\\Vakilsearch\\GRCRegressionAutomation\\" + Date1 + "\\Screenshot1.png",
						"DashboardURL1").build());
		try {
			GRCOTPConfirm.click();
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

		Thread.sleep(6500);
		try {
			WebElement element41 = driver.findElement(By.xpath("//img[@alt='closeIcon']"));
			JavascriptExecutor executor41 = (JavascriptExecutor) driver;
			executor41.executeScript("arguments[0].click();", element41);
		} catch (Exception Closepopup) {
			System.out.println("No popup");
		}

		Thread.sleep(4000);
		String DashboardURL = driver.getCurrentUrl().substring(0, 37);
		String DashboardURL1 = "https://grc.vakilsearch.com/grc/dashboard";
		if (DashboardURL1.contains(DashboardURL)) {

			screenshot.screenshot2(driver, extentreport);
			test.log(Status.PASS,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\GRCRegressionAutomation\\" + Date1 + "\\Screenshot2.png",
							"DashboardURL1").build());

		} else {

			screenshot.screenshot2(driver, extentreport);
			test.log(Status.FAIL,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\GRCRegressionAutomation\\" + Date1 + "\\Screenshot2.png",
							"DashboardURL1").build());

		}

		try {
			Closepopup.click();
		} catch (Exception Closepopup) {
			System.out.println("No popup");
		}

		try {
			Thread.sleep(2000);
			WebElement element4 = driver.findElement(By.xpath("//span[contains(text(),'Add new business')]"));
			JavascriptExecutor executor4 = (JavascriptExecutor) driver;
			executor4.executeScript("arguments[0].click();", element4);

		} catch (Exception addnewEntity) {
			WebElement element6 = driver.findElement(By.xpath("//div[@class='styles_dropdown__kgL4A']/child::button"));
			JavascriptExecutor executor6 = (JavascriptExecutor) driver;
			executor6.executeScript("arguments[0].click();", element6);

			WebElement element42 = driver.findElement(By.xpath("//a[contains(text(),' Add business')]"));
			JavascriptExecutor executor42 = (JavascriptExecutor) driver;
			executor42.executeScript("arguments[0].click();", element42);

		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary']")));
		Letsgo.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='styles_dropdownToggle__oqhXx ']")));
		ChooseBusinessType.click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//li[contains(text(),'Private Limited Company(PVT)')]")));
		PrivateLimitedCompany.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='styles_textInput__k8w0C'])[1]")));

		CompanyName.click();
		CompanyName.sendKeys(GRCNewCompanyName);
		CINNo.click();
		CINNo.sendKeys(CINNumber + Date2);
		Thread.sleep(3500);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue')]")));
			Continue.click();
			Thread.sleep(2500);
		} catch (Exception e102) {
			wait.until(ExpectedConditions.elementToBeClickable(Continue));
			actions.moveToElement(Continue).click().build().perform();
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//p[contains(text(),'Business Industry')]")));
		BusinessIndustry.click();
		Thread.sleep(1500);
		AgricultureAndDairyFarming.click();
		Thread.sleep(1500);
		SubIndustry.click();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);
		Continue2.click();
		Thread.sleep(2500);
		WebElement element90 = driver
				.findElement(By.xpath("//button[contains(text(),'Skip')]/parent::div/child::button"));
		JavascriptExecutor executor90 = (JavascriptExecutor) driver;
		executor90.executeScript("arguments[0].click();", element90);
		// Skip.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Continue')]")));
		LetsGetStartedContinue.click();
		Thread.sleep(2500);
		try {
			Closepopup.click();
		} catch (Exception Closepopup) {
			System.out.println("No popup");
		}
		try {

			Closepopup.click();
		} catch (Exception Closepopup) {
			System.out.println("No popup");
		}
		Thread.sleep(4500);
		WebElement element410 = driver.findElement(By.xpath("//button[@class='styles_dropdownBtn__I6_4i']/child::p"));
		JavascriptExecutor executor410 = (JavascriptExecutor) driver;
		executor410.executeScript("arguments[0].click();", element410);
		
		Thread.sleep(2500);
		// **just for option
//	OpenEntityList.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='styles_accountsList__qfPzH']/child::div)[2]"))).click();
		// EntitySelect2.click();
		Thread.sleep(1500);

		// **just for option
		wait.until(ExpectedConditions.elementToBeClickable(OpenEntityList)).click();

		EntitySelect2.click();
		Thread.sleep(1500);
		ProfileMenu.click();
		Thread.sleep(1500);
		ViewProfile.click();
		Thread.sleep(1500);
		String ProfileInformationURL = driver.getCurrentUrl();
		String ProfileInformationURL1 = "https://grc.vakilsearch.com/grc/user-profile";

		wait.until(ExpectedConditions.elementToBeClickable(personalprofilename)).click();

		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(2000);
		WebElement element901 = driver
				.findElement(By.xpath("(//div[@class='styles_btnWrap__auxlS '])[1]/child::button"));
		JavascriptExecutor executor901 = (JavascriptExecutor) driver;
		executor901.executeScript("arguments[0].click();", element901);

		screenshot.screenshot18(driver, extentreport);
		test.log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot18.png",
						"Profile Edit Updated").build());
		System.out.println(ProfileInformationURL);
		if (ProfileInformationURL1.contains(ProfileInformationURL)) {
			screenshot.screenshot3(driver, extentreport);
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot3.png",
					"ProfileInformationURL").build());
			System.out.println(ProfileInformationURL);
		} else {
			screenshot.screenshot3(driver, extentreport);
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(
					"\\\\14.140.167.188\\Vakilsearch\\Vakilsearch_Smoke_Testing\\" + Date1 + "\\Screenshot3.png",
					"ProfileInformationURL").build());
			System.out.println(ProfileInformationURL1);
		}

		driver.navigate().back();
		Thread.sleep(2500);
		try {

			Closepopup.click();
		} catch (Exception Closepopup) {
			System.out.println("No popup");
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='styles_gearBtn__s6cgl']")));
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//p[contains(text(),'Business Profile')]")).click();
		Thread.sleep(10000);
		String BusinessProfileURL = driver.getCurrentUrl();
		String BusinessProfileURL1 = "https://grc.vakilsearch.com/grc/business-profile/RnJxd0dES1FCUDJ3NGVPdi58fC4xMmZlNzY2ZmQ3Lnx8LkGMLz4SKeWUMX6ZwI8PGNf5ykJud-YT1HGCasaEjTAsyhcx3Uj9SkWJCjaqocv_3_fOjMyZk0LrBT7p2Mweeez8IVRj_kp5NgllycK73C0H?showBusinessProfile=true";
		if (BusinessProfileURL1.contains(BusinessProfileURL)) {
			test.log(Status.PASS, "BusinessProfileURL");
			System.out.println(BusinessProfileURL1);
		} else {
			test.log(Status.FAIL, "BusinessProfileURL not same" + BusinessProfileURL);
			System.out.println(BusinessProfileURL);
		}

		driver.navigate().back();
		Thread.sleep(10000);

		// *********

		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();
		Thread.sleep(2500);
		Thread.sleep(10000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Users & Roles')]"))).click();

		Thread.sleep(10000);
		String UsersandRolesURL = driver.getCurrentUrl();
		String UsersandRolesURL1 = "https://grc.vakilsearch.com/grc/user_roles/RnJxd0dES1FCUDJ3NGVPdi58fC4xMmZlNzY2ZmQ3Lnx8LkGMLz4SKeWUMX6ZwI8PGNf5ykJud-YT1HGCasaEjTAsyhcx3Uj9SkWJCjaqocv_3_fOjMyZk0LrBT7p2Mweeez8IVRj_kp5NgllycK73C0H";
		if (UsersandRolesURL1.contains(UsersandRolesURL)) {
			test.log(Status.PASS, "UsersAndRolesURL");
			System.out.println(UsersandRolesURL1);
		} else {
			test.log(Status.FAIL, "UsersandRolesURL not same" + UsersandRolesURL);
			System.out.println(UsersandRolesURL);
		}
		driver.navigate().back();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//p[contains(text(),'Users & Roles')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//Button[contains(text(),'Add users')]")).click();
		Thread.sleep(10000);
		String AddUserURL = driver.getCurrentUrl();
		String AddUserURL1 = "https://grc.vakilsearch.com/grc/user_roles/RnJxd0dES1FCUDJ3NGVPdi58fC4xMmZlNzY2ZmQ3Lnx8LkGMLz4SKeWUMX6ZwI8PGNf5ykJud-YT1HGCasaEjTAsyhcx3Uj9SkWJCjaqocv_3_fOjMyZk0LrBT7p2Mweeez8IVRj_kp5NgllycK73C0H";
		if (AddUserURL1.contains(AddUserURL)) {
			test.log(Status.PASS, "AddUserURL");
			System.out.println(AddUserURL1);
		} else {
			test.log(Status.FAIL, "AddUserURL not same" + AddUserURL);
			System.out.println(AddUserURL);
		}
		// driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(10000);
		// *********
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']/child::img")).click();
		Thread.sleep(7500);
		driver.findElement(By.xpath("//p[contains(text(),'Help')]")).click();
		Thread.sleep(7500);
		String HelpURL = driver.getCurrentUrl();
		String HelpURL1 = "https://grc.vakilsearch.com/grc/help";
		if (HelpURL1.contains(HelpURL)) {
			test.log(Status.PASS, "HelpURL");
			System.out.println(HelpURL1);
		} else {
			test.log(Status.FAIL, "HelpURL not same" + HelpURL);
			System.out.println(HelpURL);
		}
		driver.navigate().back();
		Thread.sleep(5500);
		// **********
		driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		Thread.sleep(5500);
		driver.findElement(By.xpath("//p[contains(text(),'Support')]")).click();
		Thread.sleep(5500);
		String SupportURL = driver.getCurrentUrl();
		String SupportURL1 = "https://grc.vakilsearch.com/grc/contact-us";
		if (SupportURL1.contains(SupportURL)) {
			test.log(Status.PASS, "SupportURL");
			System.out.println(SupportURL1);
		} else {
			test.log(Status.FAIL, "SupportURL not same" + SupportURL);
			System.out.println(SupportURL);
		}
		driver.navigate().back();
		Thread.sleep(8000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5500);
		// **************
		// driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		WebElement element9011 = driver.findElement(By.xpath("//span[contains(text(),'Messages')]"));
		JavascriptExecutor executor9011 = (JavascriptExecutor) driver;
		executor9011.executeScript("arguments[0].click();", element9011);

		String MessagesURL = driver.getCurrentUrl();
		String MessagesURL1 = "https://grc.vakilsearch.com/grc/messages";
		if (MessagesURL1.contains(MessagesURL)) {
			test.log(Status.PASS, "MessagesURL");
			System.out.println(MessagesURL1);
		} else {
			test.log(Status.FAIL, "MessagesURL not same" + MessagesURL);
			System.out.println(MessagesURL);
		}

		driver.navigate().back();
		Thread.sleep(5500);
		// ********
		// driver.findElement(By.xpath("//button[@id='km-chat-widget-close-button']")).click();Thread.sleep(2500);
		// driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		WebElement element90111 = driver.findElement(By.xpath("//span[contains(text(),'All Services')]"));
		JavascriptExecutor executor90111 = (JavascriptExecutor) driver;
		executor90111.executeScript("arguments[0].click();", element90111);
		Thread.sleep(2500);
		String AllServicesURL = driver.getCurrentUrl();
		String AllServicesURL1 = "https://grc.vakilsearch.com/grc/services/VXgxRXQ2SmVrYjNVVUFqdy58fC4yNGVkZWY1Y2RiLnx8Lgnrb6u54cOopAREu9iUZ7tVC8tWpLxMKzDegk-Cfsq3izkmU5zfatcKoNKh7FMYAfM0QGoRyW_1QwmmyOXIUuXotaHZOToRrel1bUc8MBmB";
		if (AllServicesURL1.contains(AllServicesURL)) {
			test.log(Status.PASS, "AllServicesURL");
			System.out.println(AllServicesURL1);
		} else {
			test.log(Status.FAIL, "AllServicesURL not same" + AllServicesURL);
			System.out.println(AllServicesURL);
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Buy now')])[1]")))
				.click();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		// BuyNowService.click();
		Thread.sleep(1500);
		try {
			AreyouintrestedinGST.click();
			Thread.sleep(1500);
			ContinueGST.click();
			Thread.sleep(1500);
			AreyouintrestedinGST.click();
			Thread.sleep(1500);
			GSTRegistrationState.click();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			ContinueGST.click();
			Thread.sleep(1500);
			ContinueGST.click();
		} catch (NoSuchElementException AreyouintrestedinGST) {

			try {
				GSTRegistrationState.click();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				ContinueGST.click();
				ContinueGST.click();
			} catch (NoSuchElementException AreyouintrestedinGST1) {

				try {
					Thread.sleep(2500);
					ContinueGST.click();
				} catch (NoSuchElementException ContinueGST) {
					Thread.sleep(3000);
				}
			}

		}

		String ServiceID3 = GetServiceID.getText().substring(1);
		System.out.println(ServiceID3 + "ComplianceCalender Leadcreation");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		driver.navigate().back();
		Thread.sleep(4500);
		// driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Compliances for you')]")).click();
		Thread.sleep(2500);
		String CompliancesForYou = driver.getCurrentUrl();
		String CompliancesForYou1 = "https://grc.vakilsearch.com/grc/compliance-score";
		if (CompliancesForYou.contains(CompliancesForYou1)) {
			test.log(Status.PASS, "CompliancesForYou");
			System.out.println(CompliancesForYou1);
		} else {
			test.log(Status.FAIL, "CompliancesForYouURL not same" + CompliancesForYou);
			System.out.println(CompliancesForYou);
		}
		driver.navigate().back();
		Thread.sleep(2500);
		// driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Payments')]")).click();
		Thread.sleep(2500);
		String PaymentsURL = driver.getCurrentUrl();
		String PaymentsURL1 = "https://grc.vakilsearch.com/grc/payments/VXgxRXQ2SmVrYjNVVUFqdy58fC4yNGVkZWY1Y2RiLnx8Lgnrb6u54cOopAREu9iUZ7tVC8tWpLxMKzDegk-Cfsq3izkmU5zfatcKoNKh7FMYAfM0QGoRyW_1QwmmyOXIUuXotaHZOToRrel1bUc8MBmB";
		if (PaymentsURL.contains(PaymentsURL1)) {
			test.log(Status.PASS, "PaymentsURL");
			System.out.println(PaymentsURL1);
		} else {
			test.log(Status.FAIL, "PaymentsURL not same" + PaymentsURL);
			System.out.println(PaymentsURL);
		}
		driver.navigate().back();
		Thread.sleep(2500);
		// driver.findElement(By.xpath("//button[@class='styles_gearBtn__s6cgl']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Compliance Calendar')]")).click();
		Thread.sleep(2500);
		String ComplianceCalendar = driver.getCurrentUrl();
		String ComplianceCalendar1 = "https://grc.vakilsearch.com/grc/calendar/VXgxRXQ2SmVrYjNVVUFqdy58fC4yNGVkZWY1Y2RiLnx8Lgnrb6u54cOopAREu9iUZ7tVC8tWpLxMKzDegk-Cfsq3izkmU5zfatcKoNKh7FMYAfM0QGoRyW_1QwmmyOXIUuXotaHZOToRrel1bUc8MBmB";
		if (ComplianceCalendar.contains(ComplianceCalendar1)) {
			test.log(Status.PASS, "ComplianceCalendar");
			System.out.println(ComplianceCalendar1);
		} else {
			test.log(Status.FAIL, "ComplianceCalendarURL not same" + ComplianceCalendar);
			System.out.println(ComplianceCalendar);
		}

		driver.navigate().back();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//span[contains(text(),'Rewards')]")).click();
		Thread.sleep(2500);
		String RewardsURL = driver.getCurrentUrl();
		String RewardsURL1 = "https://grc.vakilsearch.com/grc/rewards/VXgxRXQ2SmVrYjNVVUFqdy58fC4yNGVkZWY1Y2RiLnx8Lgnrb6u54cOopAREu9iUZ7tVC8tWpLxMKzDegk-Cfsq3izkmU5zfatcKoNKh7FMYAfM0QGoRyW_1QwmmyOXIUuXotaHZOToRrel1bUc8MBmB";
		if (RewardsURL.contains(RewardsURL1)) {
			test.log(Status.PASS, "RewardsURL");
			System.out.println(RewardsURL1);
		} else {
			test.log(Status.FAIL, "RewardsURL not same" + RewardsURL);
			System.out.println(RewardsURL);
		}
		driver.navigate().back();
		Thread.sleep(2500);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'My Interests')]")));
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

		Thread.sleep(5000);
//		// actions.moveToElement(BuyNowService).click().perform();
//		js1.executeScript("arguments[0].scrollIntoView(true);", BuyNowService);
//		Thread.sleep(1000);
//		js1.executeScript("arguments[0].scrollIntoView(true);", BuyNowService);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Buy now ')])[1]")));
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		Thread.sleep(3000);
		// actions.click(Needhelp);
		Needhelp.click();
		Thread.sleep(1500);
		String NeedHelpURL = driver.getCurrentUrl();
		String NeedHelpURL1 = "https://grc.vakilsearch.com/grc/help";
		if (NeedHelpURL1.contains(NeedHelpURL)) {
			test.log(Status.PASS, "NeedHelpURL");
			System.out.println(NeedHelpURL);
		} else {
			test.log(Status.FAIL, "NeedHelpURL Not Same  " + NeedHelpURL);
			System.out.println(NeedHelpURL1);
		}
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='styles_needHelpModal__xIW3p']/child::div/div)[6]")));
		clickVideo.click();
		Thread.sleep(3500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(8000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);

	}

}
