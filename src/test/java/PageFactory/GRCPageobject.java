package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GRCPageobject extends HelpdeskPageobject{

	@FindBy(xpath = "//input[@placeholder='Mobile number or Email']")
	public static WebElement GRCUsername;

	@FindBy(xpath = "(//input[@style='width: 1em; text-align: center;'])[1]")
	public static WebElement GRCOTP1;

	@FindBy(xpath = "(//input[@style='width: 1em; text-align: center;'])[2]")
	public static WebElement GRCOTP2;

	@FindBy(xpath = "(//input[@style='width: 1em; text-align: center;'])[3]")
	public static WebElement GRCOTP3;

	@FindBy(xpath = "(//input[@style='width: 1em; text-align: center;'])[4]")
	public static WebElement GRCOTP4;

	@FindBy(xpath = "(//div[@class='styles_details__BqLwC'])[1]")
	public static WebElement GRCMailId0;

	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	public static WebElement GRCMailIdConfirm;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public static WebElement GRCPhonenumberConfirm;
	
	@FindBy(xpath = "//div[@class='styles_footerContainer__UOnmt']/child::button")
	public static WebElement GRCOTPConfirm;
	
	@FindBy(xpath = "//span[contains(text(),'Add new business')]")
	public static WebElement addnewEntity;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public static WebElement Letsgo;
	
	@FindBy(xpath = "//div[@class='styles_dropdownToggle__oqhXx ']")
	public static WebElement ChooseBusinessType;
	
	@FindBy(xpath = "//li[contains(text(),'Private Limited Company(PVT)')]")
	public static WebElement PrivateLimitedCompany;
	
	@FindBy(xpath = "(//input[@class='styles_textInput__k8w0C'])[1]")
	public static WebElement CompanyName;
	
	@FindBy(xpath = "(//input[@class='styles_textInput__k8w0C'])[2]")
	public static WebElement CINNo;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public static WebElement Continue;
	
	@FindBy(xpath = "//div//p[contains(text(),'Business Industry')]")
	public static WebElement BusinessIndustry;
	
	@FindBy(xpath = "//li[contains(text(),'Agriculture / Dairy Farming')]")
	public static WebElement AgricultureAndDairyFarming;
	
	@FindBy(xpath = "//div[@class='search-wrapper searchWrapper ']")
	public static WebElement SubIndustry;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public static WebElement Continue2;
	
	@FindBy(xpath = "//button[contains(text(),'Skip')]")
	public static WebElement Skip;
	
	@FindBy(xpath = "//p[contains(text(),'Continue')]")
	public static WebElement LetsGetStartedContinue;
	
	@FindBy(xpath = "//a[contains(text(),' Add business')]")
	public static WebElement AddNewBusiness2;
	
	@FindBy(xpath = "//button[@class='styles_dropdownBtn__I6_4i']/child::p")
	public static WebElement OpenEntityList;
	
	@FindBy(xpath = "(//div[@class='styles_accountsList__qfPzH']/child::div)[2]")
	public static WebElement EntitySelect2;
	
	@FindBy(xpath = "(//div[@class='styles_btnContainer__sVb_P']/child::button)[2]")
	public static WebElement ProfileMenu;
	
	@FindBy(xpath = "//p[contains(text(),'View Profile')]")
	public static WebElement ViewProfile ;

	@FindBy(xpath = "//div[contains(text(),'Need help')]")
	public static WebElement Needhelp ;
	
	@FindBy(xpath = "(//div[@class='styles_needHelpModal__xIW3p']/child::div/div)[6]")
	public static WebElement clickVideo ;
	
	@FindBy(xpath = "//video[@class='video-stream html5-main-video']")
	public static WebElement VideoOpen ;
	
	@FindBy(xpath = "(//button[contains(text(),'Buy now')])[1]")
	public static WebElement RecommendedBuyNow ;
	
	@FindBy(xpath = "(//button[contains(text(),'Get it now')])[1]")
	public static WebElement ComplianceCalenderBuyNow ;
	
	@FindBy(xpath = "//button[@class='styles_closeBtn__ULw05']")
	public static WebElement ComplianceCalenderClose ;
	
	@FindBy(xpath = "(//img[@alt='close'])[1]")
	public static WebElement RecommendedClose ;
	
	@FindBy(xpath = "//img[@alt='My Services']")
	public static WebElement MyServiceCTA ;
	
	@FindBy(xpath = "//div[@class='styles_block__VmXBP']/child::*")
	public static WebElement FirstService ;
	
	@FindBy(xpath = "(//div[@class='styles_name__cFS1i'])[1]")
	public static WebElement Status1 ;
	
	@FindBy(xpath = "//span[contains(text(),'Messages')]")
	public static WebElement MessagesCTA ;
	
	@FindBy(xpath = "(//div[@class='styles_right__Sy2Zs']/child::div)[1]")
	public static WebElement ReplyMessage ;
	
	@FindBy(xpath = "//div[@class='ql-editor ql-blank']")
	public static WebElement ReplyNote ;
	

	@FindBy(xpath = "//img[@alt='Attach Icon']")
	public static WebElement messageAttachment ;
	

	@FindBy(xpath = "(//button[contains(text(),'Buy now')])[1]")
	public static WebElement BuyNowService;
	
	@FindBy(xpath = "(//div[@class='styles_actions__3cTZr']/child::button)[1]")
	public static WebElement GetItNowCompliancecalender;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public static WebElement Continueservice;
	
	@FindBy(xpath = "//div[@class='styles_navigation__3_FcC']/child::button")
	public static WebElement Paytoservice;
	
	@FindBy(xpath = "//p[@class='styles_ticket__KKyjG']/child::b")
	public static WebElement GetServiceID;

	@FindBy(xpath = "//div[@class='styles_replyBoxButtons__kRj9v']/child::span/child::button")
	public static WebElement Sendmessage;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public static WebElement ContinueGST;
	
	@FindBy(xpath = "//p[contains(text(),'Yes, continue')]")
	public static WebElement AreyouintrestedinGST;
	
	@FindBy(xpath = "//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb']")
	public static WebElement GSTRegistrationState;
	
	@FindBy(xpath = "(//div[@class='styles_resultBox__OmW_g '])[1]")
	public static WebElement Selectindustryquestion1;
	
	@FindBy(xpath = "//img[@alt='closeIcon']")
	public static WebElement Closepopup;
	
	@FindBy(xpath = "//button[@id='2']")
	public static WebElement Slide1;
	
	@FindBy(xpath = "//button[@id='3']")
	public static WebElement Slide2;
	
	@FindBy(xpath = "//button[@id='4']")
	public static WebElement Slide3;
	
	@FindBy(xpath = "(//div[@class='styles_btnWrap__auxlS '])[1]/child::button")
	public static WebElement updatepersonalprofile;
	
	@FindBy(xpath = "//input[@name='name']")
	public static WebElement personalprofilename;
	

	
	@FindBy(xpath = "(//div[@class='styles_container__BL2LZ false']/child::div)[1]")
	public static WebElement Closehelp1;
	
	@FindBy(xpath = "//h3[contains(text(),'First time in India. Only on Zolvit.')]")
	public static WebElement FirstTimeInIndia;
	
	@FindBy(xpath = "//div[@class='styles_imgWrapper__uoce0']/child::img")
	public static WebElement Closehelp2;
	
	@FindBy(xpath = "(//div[@class='styles_footer__lphBw']//u[contains(text(),'Know more')])[1]")
	public static WebElement Knowmore;
	
	@FindBy(xpath = "(//div[@class='styles_footer__lphBw']//button[contains(text(),' Unlock now')])[1]")
	public static WebElement Unlocknow	;
	
	@FindBy(xpath = "//button[@class='styles_closeBtn__ULw05']")
	public static WebElement KnowmoreClosePopup;
	
	@FindBy(xpath = "//div[@class='styles_title-container__bb51p']/child::img")
	public static WebElement UnlocknowClosePopup;
	
	@FindBy(xpath = "//button[contains(text(),'Completed')]")
	public static WebElement MyserviceCompleted;
	
	@FindBy(xpath = "//button[contains(text(),'Discontinued')]")
	public static WebElement MyserviceDiscontinued;
	
	@FindBy(xpath = "//div[@class='styles_title-container__bb51p']/child::img")
	public static WebElement MyserviceExpired;
	
	@FindBy(xpath = "//div[@class='unMappedServices_widgetEnd__aqc5o']/child::img")
	public static WebElement UnlikedDownArrow;
	
	@FindBy(xpath = "(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary  css-1b18ji1'])[1]")
	public static WebElement SelectBusinessToLinkCTA;
	
	@FindBy(xpath = "//li[contains(text(),'TATA COMMUNICATIONS LIMITED')]")
	public static WebElement TCSSelectbusinessToLink;
	
	@FindBy(xpath = "//button[contains(text(),'Confirm linking')]")
	public static WebElement ConfirmLinking;
	
	@FindBy(xpath = "(//p[contains(text(),'Know more')])[1]")
	public static WebElement MyintrestKnowmore;
	
	@FindBy(xpath = "//div[@class='styles_container__6vyhB']/child::img")
	public static WebElement MyintrestKnowMorePopupClose;
	
	@FindBy(xpath = "//input[@placeholder='Search all services']")
	public static WebElement SearchAllSevice;
	
	@FindBy(xpath = "//li[contains(text(),'Online Company Registration')]")
	public static WebElement Onlinecompanyregstration;
	
	@FindBy(xpath = "//p[@class='styles_title__QEOoZ']")
	public static WebElement Topservices;
	
	@FindBy(xpath = "//button[@class='styles_knowMore__TKFN4']")
	public static WebElement TopserviceKnowmore;
	
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	public static WebElement Home;
	
	
	

	
	
	
	
	
	
	
	

}
