package Test.Dashboard.Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhleBotomist_Booking_Page_Locators {
	public WebDriver driver;

	public PhleBotomist_Booking_Page_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//h1[contains(text(),'MY REGISTRATION')]")
	private WebElement regTxt;

	public WebElement getregTxt() {
		return regTxt;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Boots appointment')]")
	private WebElement boots_App_Menu;

	public WebElement get_boots_App_Menu() {
		return boots_App_Menu;
	}
	
	@FindBy(xpath = "//p/strong")
	WebElement booking_ID;

	public WebElement  get_booking_ID() {
		return booking_ID;
	}
	
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continueBtn;

	public WebElement getContinueBtn() {
		return continueBtn;
	}
	
	@FindBy(xpath = "//span/button[contains(text(),'Cancel registration')]")
	private WebElement cancel_Reg_Btn;

	public WebElement get_cancel_Reg_Btn() {
		return cancel_Reg_Btn;
	}
	
	@FindBy(id = "input-test_type")
	private WebElement test_Type_dropDown;

	public WebElement gettest_Type_dropDown() {
		return test_Type_dropDown;
	}
	
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement reject_Cnfrm_Btn;

	public WebElement getreject_Cnfrm_Btn() {
		return reject_Cnfrm_Btn;
	}
	
	
	@FindBy(xpath = "//button[contains(text(),'Confirm & Continue')]")
	private WebElement ConfirmBtn;

	public WebElement get_ConfirmBtn() {
		return ConfirmBtn;
	}
	
	@FindBy(className  = "invalid-feedback")
	private WebElement required_errorMsg;

	public WebElement get_Required_Error_Msg() {
		return required_errorMsg;
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SubmitBtn;

	public WebElement get_SubmitBtn() {
		return SubmitBtn;
	}
	
	@FindBy(id = "consentGiven")
	private WebElement consent_CheckBox;
	
	public WebElement get_consent_CheckBox() {
		return consent_CheckBox;
	}
	
	@FindBy(id = "termsAccepted")
	private WebElement terms_CheckBox;
	
	public WebElement get_terms_CheckBox() {
		return terms_CheckBox;
	}
	
	@FindBy(xpath = "//*[@id=\"firstname\"]")
	private WebElement firstName;
	
	public WebElement getFirstName() {
		return firstName;
	}
	
	@FindBy(xpath = "//*[@id=\"lastname\"]")
	private WebElement lastName;
	
	public WebElement getLastName() {
		return lastName;
	}
	
	@FindBy(xpath = "//input[@id='dob']")
	private WebElement txtDOB;

	public WebElement gettxtDOB() {
		return txtDOB;
	}
	
	@FindBy(xpath ="//*[contains(text(),'You must be at least 18 years old')]")
	private WebElement ageErrorMsg;
	
	public WebElement getAgeErrorMsg() {
		return ageErrorMsg;
	}
	
	@FindBy(xpath = "//input[@id='number']")
	private WebElement txtMobNo;

	public WebElement gettxtMobNo() {
		return txtMobNo;
	}
	
	@FindBy(xpath = "//label[normalize-space()='Male']")
	private WebElement txtGender;

	public WebElement getSelectGender() {
		return txtGender;
	}
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement txtIdentifyGender;

	public WebElement getSelectIdentifyGender() {
		return txtIdentifyGender;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement txtRegContinue;

	public WebElement gettxtRegContinue() {
		return txtRegContinue;
	}
	
	@FindBy(xpath = "//div[contains(text(),'User details confirmed!')]")
	private WebElement details_cfrm_Msg;

	public WebElement get_details_cfrm_Msg() {
		return details_cfrm_Msg;
	}
	@FindBy(xpath = "//a[contains(text(),'Start health assessment')]")
	private WebElement assessment_start_Btn;

	public WebElement get_assessment_start_Btn() {
		return assessment_start_Btn;
	}
	@FindBy(css = ".steps div")
	private List<WebElement> assessment_steps;

	public  List<WebElement> get_assessment_steps() {
		return assessment_steps;
	}
	
	@FindBy(xpath = "//div[normalize-space()='First name is required']")
	private WebElement txtEmptyFirstName;
	
	public WebElement getTextEmptyFirstName() {
		return txtEmptyFirstName;
	}
	
	@FindBy(xpath = "//div[normalize-space()='Last name is required']")
	private WebElement txtEmptyLastName;
	
	public WebElement getTextEmptyLastName() {
		return txtEmptyLastName;
	}
	
	
	@FindBy(xpath = "//div[normalize-space()='Date of Birth is required']")
	private WebElement txtEmptyDOB;

	public WebElement get_txtEmptyDOB() {
		return txtEmptyDOB;
	}

	@FindBy(xpath = "//div[normalize-space()='Phone number is required']")
	private WebElement txtEmptyPhNo;

	public WebElement get_txtEmptyPhNo() {
		return txtEmptyPhNo;
	}

	@FindBy(xpath = "//div[normalize-space()='Sex at Birth is required']")
	private WebElement txtEmptySexBirth;

	public WebElement get_txtEmptySexBirth() {
		return txtEmptySexBirth;
	}

	@FindBy(xpath = "//div[normalize-space()='You must indicate if you still identify with this gender']")
	private WebElement txtEmptyGender;

	public WebElement get_txtEmptyGender() {
		return txtEmptyGender;
	}

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	private WebElement txtHealthassessmentContinue;

	public WebElement get_txtHealthassessmentContinue() {
		return txtHealthassessmentContinue;
	}

	@FindBy(xpath = "//input[@id='1']")
	private WebElement txtHeight;

	public WebElement get_txtHeight() {
		return txtHeight;
	}

	@FindBy(xpath = "//input[@id='2']")
	private WebElement txtWeight;

	public WebElement get_txtWeight() {
		return txtWeight;
	}

	@FindBy(xpath = "//label[normalize-space()='Imperial']")
	private WebElement txtUnit;

	public WebElement get_txtUnit() {
		return txtUnit;
	}

	@FindBy(xpath = "//select[@id='input-4']")
	private WebElement txtSmokeYes;

	public WebElement get_txtSmokeYes() {
		return txtSmokeYes;
	}

	@FindBy(xpath = "//select[@id='input-5']")
	private WebElement txtSmokeCount;

	public WebElement get_txtSmokeCount() {
		return txtSmokeCount;
	}

	@FindBy(xpath = "//select[@id='input-6']")
	private WebElement txtAlcohol;

	public WebElement get_txtAlcohol() {
		return txtAlcohol;
	}

	@FindBy(xpath = "//select[@id='input-7']")
	private WebElement txtAlcoholCount;

	public WebElement get_txtAlcoholCount() {
		return txtAlcoholCount;
	}

	@FindBy(xpath = "//button[normalize-space()='Confirm & Continue']")
	private WebElement txtCnfCnt;

	public WebElement get_txtCnfCnt() {
		return txtCnfCnt;
	}

	@FindBy(xpath = "//select[@id='input-1']")
	private WebElement txtPhysicalActivityYes;

	public WebElement get_txtPhysicalActivityYes() {
		return txtPhysicalActivityYes;
	}

	@FindBy(xpath = "//select[@id='input-2']")
	private WebElement txtPhysicalActivityLight;

	public WebElement get_txtPhysicalActivityLight() {
		return txtPhysicalActivityLight;
	}

	@FindBy(xpath = "//select[@id='input-3']")
	private WebElement txtPhysicalActivityModerate;

	public WebElement get_txtPhysicalActivityModerate() {
		return txtPhysicalActivityModerate;
	}

	@FindBy(xpath = "//select[@id='input-4']")
	private WebElement txtPhysicalActivityVigorous;

	public WebElement get_txtPhysicalActivityVigorous() {
		return txtPhysicalActivityVigorous;
	}

	@FindBy(xpath = "//button[normalize-space()='Confirm and continue']")
	private WebElement txtPhysicalActivityCnfCtn;

	public WebElement get_txtPhysicalActivityCnfCtn() {
		return txtPhysicalActivityCnfCtn;
	}

	@FindBy(id = "input-1")
	private WebElement txtMedicalConditonYes;

	public WebElement get_txtMedicalConditonYes() {
		return txtMedicalConditonYes;
	}

	@FindBy(xpath = "//input[@value='Anaemia']")
	private WebElement txtCheckAnaemia;

	public WebElement get_txtCheckAnaemia() {
		return txtCheckAnaemia;
	}

	@FindBy(xpath = "//input[@value='Dementia']")
	private WebElement txtCheckDementia;

	public WebElement get_txtCheckDementia() {
		return txtCheckDementia;
	}

	@FindBy(xpath = "//button[normalize-space()='Confirm and continue']")
	private WebElement txtMedicalconditionsCnfCtn;

	public WebElement get_txtMedicalconditionsCnfCtn() {
		return txtMedicalconditionsCnfCtn;
	}

	@FindBy(id = "input-0")
	private WebElement txtMedicationYes;

	public WebElement get_txtMedicationYes() {
		return txtMedicationYes;
	}

	@FindBy(xpath = "//label[normalize-space()='Blood pressure medication']")
	private WebElement txtCheckBloodpressuremedication;

	public WebElement get_txtCheckBloodpressuremedication() {
		return txtCheckBloodpressuremedication;
	}

	@FindBy(xpath = "//input[@value='Blood pressure medication']")
	private WebElement txtCheckContraceptives;

	public WebElement get_txtCheckContraceptives() {
		return txtCheckContraceptives;
	}

	@FindBy(xpath = "//button[normalize-space()='Confirm and continue']")
	private WebElement txtMedicationCnfCtn;

	public WebElement get_txtMedicationCnfCtn() {
		return txtMedicationCnfCtn;
	}

	@FindBy(xpath = "//h1[normalize-space()='Assessment summary']")
	private WebElement txtAssessmentsummary;

	public WebElement get_txtAssessmentsummary() {
		return txtAssessmentsummary;
	}

	@FindBy(xpath = "//button[normalize-space()='Assessment submit']")
	private WebElement txtAssessmentsubmit;

	public WebElement get_txtAssessmentsubmit() {
		return txtAssessmentsubmit;

	}

	@FindBy(css = "div[class='col-md-12'] p strong")
	private WebElement txtAppointmentRegNo;

	public WebElement get_txtAppointmentRegNo() {
		return txtAppointmentRegNo;
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Declaration of consent']")
	private WebElement txtDeclarationConsent;
	
	public WebElement get_txtDeclarationConsent() {
		return txtDeclarationConsent;
	}
}
