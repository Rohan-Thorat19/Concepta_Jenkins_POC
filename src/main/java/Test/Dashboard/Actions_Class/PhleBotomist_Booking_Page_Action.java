package Test.Dashboard.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Test.Dashboard.Locators_Class.PhleBotomist_Booking_Page_Locators;

import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Wrappers.WebButton;
import Wrappers.WebCheckBox;
import Wrappers.WebDropDown;
import Wrappers.WebMouseOperation;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import Wrappers.WebelementDisplay;
import initializer.ExtentManager;

public class PhleBotomist_Booking_Page_Action {
	
	public WebDriver driver;
	PhleBotomist_Booking_Page_Locators phleBotomist_booking_page_locators;
	
	Login_Health_Professional_Actions login_health_professional_actions;

	public PhleBotomist_Booking_Page_Action(WebDriver driver) {
		this.driver = driver;
		login_health_professional_actions = new Login_Health_Professional_Actions(driver);		
		phleBotomist_booking_page_locators = new PhleBotomist_Booking_Page_Locators(driver);
	}
	
	public void navigate_To_Reg_Page() throws InterruptedException {
		login_health_professional_actions.clickOnEnableLaterBtn();
		try {
		WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.getregTxt() ,Duration.ofSeconds(30));
		String alert_expected = phleBotomist_booking_page_locators.getregTxt().getText().trim();
		System.out.println("Registration Page Heading= " + alert_expected);
		String ActualValue = "MY REGISTRATION";
		assertEquals(ActualValue, alert_expected);
		assertTrue(phleBotomist_booking_page_locators.get_boots_App_Menu().isDisplayed());
		ExtentManager.getTest().log(Status.PASS, "Navigated to Registration Page");
		}
		catch(Exception e){
			System.out.println("Registration is aleady In Progress.");
		}
		
	}
	
	
	public void check_Test_Type_With_URL() throws InterruptedException {
		//navigate_To_Reg_Page();
		cancel_Appointment();
		//WebButton.clickButton(phleBotomist_booking_page_locators.getContinueBtn());
		Thread.sleep(2000);
		Select dropdown = new Select(phleBotomist_booking_page_locators.gettest_Type_dropDown());
		WebElement selectedValue = dropdown.getFirstSelectedOption();
		String testName = selectedValue.getText().split(" ")[0];
		System.out.println("Text is = " +testName);		
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains(testName.toLowerCase())) {
			System.out.println("Test type is Matched = "+testName);
		}
		
	}
	
	
	public void without_Selecting_Test_Type() throws InterruptedException {
		//navigate_To_Reg_Page();
		cancel_Appointment();
		Thread.sleep(2000);
		WebDropDown.selectByIndex(phleBotomist_booking_page_locators.gettest_Type_dropDown(), "0", driver);
		//WebDropDown.selectByValue(driver, phleBotomist_booking_page_locators.gettest_Type_dropDown(), "");
		WebButton.clickButton(phleBotomist_booking_page_locators.get_ConfirmBtn());
		WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_Required_Error_Msg() ,Duration.ofSeconds(30));
		String alert_expected = phleBotomist_booking_page_locators.get_Required_Error_Msg().getText().trim();
		System.out.println("Error Messgae= " + alert_expected);
		String ActualValue = "Test type is required";
		assertEquals(ActualValue, alert_expected);
		ExtentManager.getTest().log(Status.PASS, "Blank Test Type Does not Proceed");		
	}
	
	public void checkbox_Validation() throws InterruptedException {
		cancel_Appointment();
		//check_Test_Type_With_URL();
		//WebButton.clickButton(phleBotomist_booking_page_locators.get_ConfirmBtn());
		Thread.sleep(2000);
		WebButton.clickButton(phleBotomist_booking_page_locators.get_SubmitBtn());
		
		ExtentManager.getTest().log(Status.INFO, "CheckBoxes are not selected");
		Thread.sleep(2000);
		WebCheckBox.checkBoxTest(phleBotomist_booking_page_locators.get_consent_CheckBox());
		WebCheckBox.checkBoxTest(phleBotomist_booking_page_locators.get_terms_CheckBox());
		WebButton.clickButton(phleBotomist_booking_page_locators.get_SubmitBtn());
		ExtentManager.getTest().log(Status.PASS, "Both checkBoxes are selected");
		
	}
	
	public void confirm_Details_Form(String DOB, String boot_Reg_Mob) throws InterruptedException {

		WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.gettxtDOB(), Duration.ofSeconds(30));
		WebButton.JsclickButton(phleBotomist_booking_page_locators.gettxtDOB(), driver);
		WebTextBox.sendInputUpdate(phleBotomist_booking_page_locators.gettxtDOB(), DOB);
		WebTextBox.sendInputUpdate(phleBotomist_booking_page_locators.gettxtMobNo(), boot_Reg_Mob);
		WebButton.JsclickButton(phleBotomist_booking_page_locators.getSelectGender(), driver);
		WebButton.JsclickButton(phleBotomist_booking_page_locators.getSelectIdentifyGender(), driver);
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 800).perform();

		phleBotomist_booking_page_locators.gettxtRegContinue().submit();
		
		WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_details_cfrm_Msg() ,Duration.ofSeconds(30));
		String alert_expected = phleBotomist_booking_page_locators.get_details_cfrm_Msg().getText().trim();
		System.out.println("Details Confirm Messgae= " + alert_expected);
		String ActualValue = "User details confirmed!";
		assertEquals(ActualValue, alert_expected);
		ExtentManager.getTest().log(Status.PASS, "User details are confirmed");

	}
	
	public void health_Assessment_Form_Nav() throws InterruptedException {
		checkbox_Validation();
		confirm_Details_Form("03031998","3333333333");
		WebButton.clickButton(phleBotomist_booking_page_locators.get_assessment_start_Btn());
		if(!phleBotomist_booking_page_locators.get_assessment_steps().isEmpty()) {
			int no_of_Steps = phleBotomist_booking_page_locators.get_assessment_steps().size();
			System.out.println("Health Assessment Form is opened with "+ no_of_Steps +" Steps");
		}
		else
		{
			System.out.println("Health Assessment form is not opened");
		}
		
		
	}
	
	public void cancel_Appointment() throws InterruptedException {
		login_health_professional_actions.clickOnEnableLaterBtn();
//		if(phleBotomist_booking_page_locators.getregTxt().isDisplayed()) {
//			WebButton.clickButton(phleBotomist_booking_page_locators.getContinueBtn());		
//		}
//		else
//		{
//			WebButton.clickButton(phleBotomist_booking_page_locators.get_cancel_Reg_Btn());
//		}
		try {
			Thread.sleep(2000);
			WebButton.clickButton(phleBotomist_booking_page_locators.getContinueBtn());
		}
		catch(Exception e){
			WebWait.elementToBeClickable(driver, phleBotomist_booking_page_locators.get_cancel_Reg_Btn(), Duration.ofSeconds(10));
			Thread.sleep(2000);
			WebButton.clickButton(phleBotomist_booking_page_locators.get_cancel_Reg_Btn());
			Thread.sleep(2000);
			WebButton.clickButton(phleBotomist_booking_page_locators.getreject_Cnfrm_Btn());
			Thread.sleep(2000);
			WebButton.clickButton(phleBotomist_booking_page_locators.getContinueBtn());
			
		}
		
	}
		
		public void health_Assessment_Form_Nav_without_data() throws InterruptedException {

			checkbox_Validation();

			Actions actions = new Actions(driver);

			actions.scrollByAmount(0, 800).perform();



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.gettxtRegContinue(),

					Duration.ofSeconds(30));

			phleBotomist_booking_page_locators.gettxtRegContinue().submit();



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtEmptyDOB(),

					Duration.ofSeconds(30));

			String alert_expected_DOB = phleBotomist_booking_page_locators.get_txtEmptyDOB().getText().trim();

			System.out.println("Error Message= " + alert_expected_DOB);

			String ActualValue_DOB = "Date of Birth is required";

			assertEquals(ActualValue_DOB, alert_expected_DOB);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtEmptyPhNo(),

					Duration.ofSeconds(30));

			String alert_expected_phNo = phleBotomist_booking_page_locators.get_txtEmptyPhNo().getText().trim();

			System.out.println("Error Message= " + alert_expected_phNo);

			String ActualValue_phNo = "Phone number is required";

			assertEquals(ActualValue_phNo, alert_expected_phNo);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtEmptySexBirth(),

					Duration.ofSeconds(30));

			String alert_expected_SexBirth = phleBotomist_booking_page_locators.get_txtEmptySexBirth().getText().trim();

			System.out.println("Error Message= " + alert_expected_SexBirth);

			String ActualValue_SexBirth = "Sex at Birth is required";

			assertEquals(ActualValue_SexBirth, alert_expected_SexBirth);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtEmptyGender(),

					Duration.ofSeconds(30));

			String alert_expected_EmptyGender = phleBotomist_booking_page_locators.get_txtEmptyGender().getText().trim();

			System.out.println("Error Message= " + alert_expected_EmptyGender);

			String ActualValue_EmptyGender = "You must indicate if you still identify with this gender";

			assertEquals(ActualValue_EmptyGender, alert_expected_EmptyGender);



			ExtentManager.getTest().log(Status.PASS, "Blank Test Type Does not Proceed");



		}



		public void Verify_Complete_Health_Assessment_Form_1(String Height, String Weight, String SmokeYes,

				String SmokeCount, String AlcoholYes, String AlcoholCount) throws InterruptedException {



			// Height and weight



			health_Assessment_Form_Nav();

			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtHealthassessmentContinue(),

					Duration.ofSeconds(30));

			WebButton.JsclickButton(phleBotomist_booking_page_locators.get_txtHealthassessmentContinue(), driver);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtHeight(), Duration.ofSeconds(30));

			WebTextBox.sendInput(phleBotomist_booking_page_locators.get_txtHeight(), Height);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtWeight(), Duration.ofSeconds(30));

			WebTextBox.sendInput(phleBotomist_booking_page_locators.get_txtWeight(), Weight);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtSmokeYes(),

					Duration.ofSeconds(30));



			WebDropDown.searchAndSelect(driver, phleBotomist_booking_page_locators.get_txtSmokeYes(), SmokeYes);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtSmokeCount(),

					Duration.ofSeconds(30));



			WebDropDown.searchAndSelect(driver, phleBotomist_booking_page_locators.get_txtSmokeCount(), SmokeCount);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtAlcohol(),

					Duration.ofSeconds(30));



			WebDropDown.searchAndSelect(driver, phleBotomist_booking_page_locators.get_txtAlcohol(), AlcoholYes);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtAlcoholCount(),

					Duration.ofSeconds(30));

			WebDropDown.searchAndSelect(driver, phleBotomist_booking_page_locators.get_txtAlcoholCount(), AlcoholCount);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtCnfCnt(), Duration.ofSeconds(30));

			WebButton.JsclickButton(phleBotomist_booking_page_locators.get_txtCnfCnt(), driver);



		}



		public void Verify_Complete_Health_Assessment_Form_2(String ActivityYes, String LightActivity,

				String ModerateActivity, String VigorousActivity) throws InterruptedException {



			// Exercise



			Verify_Complete_Health_Assessment_Form_1("60", "100", "Yes", "0 - 5", "Yes", "0 - 7");

			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtPhysicalActivityYes(),

					Duration.ofSeconds(30));



			WebDropDown.searchAndSelect(driver, phleBotomist_booking_page_locators.get_txtPhysicalActivityYes(),

					ActivityYes);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtPhysicalActivityLight(),

					Duration.ofSeconds(30));



			WebDropDown.searchAndSelect(driver, phleBotomist_booking_page_locators.get_txtPhysicalActivityLight(),

					LightActivity);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtPhysicalActivityModerate(),

					Duration.ofSeconds(30));



			WebDropDown.searchAndSelect(driver, phleBotomist_booking_page_locators.get_txtPhysicalActivityModerate(),

					ModerateActivity);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtPhysicalActivityVigorous(),

					Duration.ofSeconds(30));



			WebDropDown.searchAndSelect(driver, phleBotomist_booking_page_locators.get_txtPhysicalActivityVigorous(),

					VigorousActivity);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtPhysicalActivityCnfCtn(),

					Duration.ofSeconds(30));

			WebButton.JsclickButton(phleBotomist_booking_page_locators.get_txtPhysicalActivityCnfCtn(), driver);



		}



		public void Verify_Complete_Health_Assessment_Form_3(String medicalCondition) throws InterruptedException {



			// Medical conditions



			Verify_Complete_Health_Assessment_Form_2("Yes", "1", "1", "1");



			Thread.sleep(2000);

			WebDropDown.selectByValue(driver, phleBotomist_booking_page_locators.get_txtMedicalConditonYes(),

					medicalCondition);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtCheckAnaemia(),

					Duration.ofSeconds(30));



			WebCheckBox.checkBoxTest(phleBotomist_booking_page_locators.get_txtCheckAnaemia());



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtCheckDementia(),

					Duration.ofSeconds(30));



			WebCheckBox.checkBoxTest(phleBotomist_booking_page_locators.get_txtCheckDementia());



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtMedicalconditionsCnfCtn(),

					Duration.ofSeconds(30));

			WebButton.JsclickButton(phleBotomist_booking_page_locators.get_txtMedicalconditionsCnfCtn(), driver);

			Thread.sleep(3000);



		}



		public void Verify_Complete_Health_Assessment_Form_4(String Medication) throws InterruptedException {



			// Medication

			Verify_Complete_Health_Assessment_Form_3("Yes");



			Thread.sleep(2000);

			WebDropDown.selectByValue(driver, phleBotomist_booking_page_locators.get_txtMedicationYes(), Medication);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtCheckBloodpressuremedication(),

					Duration.ofSeconds(30));



			WebCheckBox.checkBoxTest(phleBotomist_booking_page_locators.get_txtCheckBloodpressuremedication());



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtCheckContraceptives(),

					Duration.ofSeconds(30));



			WebCheckBox.checkBoxTest(phleBotomist_booking_page_locators.get_txtCheckContraceptives());



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtMedicationCnfCtn(),

					Duration.ofSeconds(30));

			WebButton.JsclickButton(phleBotomist_booking_page_locators.get_txtMedicationCnfCtn(), driver);



		}



		public void Verify_Complete_Health_Assessment_Form_5() throws InterruptedException {



			// Assessment summary



			Verify_Complete_Health_Assessment_Form_4("Yes");



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtAssessmentsummary(),

					Duration.ofSeconds(30));

			String alert_expected_Assessmentsummary = phleBotomist_booking_page_locators.get_txtAssessmentsummary()

					.getText().trim();

			System.out.println("Message= " + alert_expected_Assessmentsummary);

			String ActualValue_Assessmentsummary = "Assessment summary";

			assertEquals(ActualValue_Assessmentsummary, alert_expected_Assessmentsummary);



			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtAssessmentsubmit(),

					Duration.ofSeconds(30));

			WebButton.JsclickButton(phleBotomist_booking_page_locators.get_txtAssessmentsubmit(), driver);



		}



		public void Verify_Complete_Health_Assessment_Form_6() throws InterruptedException {



			// APPOINTMENT CONFIRMATION



			Verify_Complete_Health_Assessment_Form_5();

			WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_txtAppointmentRegNo(),

					Duration.ofSeconds(30));

			String alert_expected_AppointmentRegNo = phleBotomist_booking_page_locators.get_txtAppointmentRegNo().getText()

					.trim();

			System.out.println("Reg. No.=" + alert_expected_AppointmentRegNo);



			String pattern = "^[A-Za-z]{2}\\d{5}$";

			assertTrue(alert_expected_AppointmentRegNo.matches(pattern),

					"Register number does not match the expected format");

		}
	

}
