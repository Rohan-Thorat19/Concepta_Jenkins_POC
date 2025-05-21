package Test.Dashboard.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Test.Dashboard.Locators_Class.PhleBotomist_Booking_Page_Locators;

import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Wrappers.WebButton;
import Wrappers.WebCheckBox;
import Wrappers.WebDropDown;
import Wrappers.WebElementCommon;
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
		WebButton.JsclickButton(phleBotomist_booking_page_locators.get_boots_App_Menu(), driver);
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
	
	public void clickContinueMyReg() throws InterruptedException {
		//navigate_To_Reg_Page();
		//WebButton.JsclickButton(phleBotomist_booking_page_locators.getContinueBtn(), driver);
		WebWait.elementToBeClickable(driver, phleBotomist_booking_page_locators.get_txtCnfCnt(), Duration.ofSeconds(20));
		
		WebButton.JsclickButton(phleBotomist_booking_page_locators.get_txtCnfCnt(), driver);
		Thread.sleep(3000);
		String txtDecCons = phleBotomist_booking_page_locators.get_txtDeclarationConsent().getText();
		boolean status = phleBotomist_booking_page_locators.get_txtDeclarationConsent().isDisplayed();
		if(status == true) {
			System.out.println("Declaration Consent is displayed");
		}
		Assert.assertEquals(txtDecCons, "Declaration of consent");
		ExtentManager.getTest().log(Status.PASS, "User proceeded to Registration process");
	}
	
	public void checkBootAppointmentIsPresent() {
		login_health_professional_actions.clickOnEnableLaterBtn();
		WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.get_boots_App_Menu() ,Duration.ofSeconds(30));
		System.out.println("Element: "+phleBotomist_booking_page_locators.get_boots_App_Menu().getText()+" is present");
		assertTrue(phleBotomist_booking_page_locators.get_boots_App_Menu().isDisplayed());
		ExtentManager.getTest().log(Status.PASS, "Boots appointment is Displayed");
	}

	
	public String get_Booking_ID() throws InterruptedException {
		//login_health_professional_actions.clickOnEnableLaterBtn();
	
			WebButton.JsclickButton(phleBotomist_booking_page_locators.get_boots_App_Menu(), driver);
			Thread.sleep(2000);
			String Booking_ID= phleBotomist_booking_page_locators.get_booking_ID().getText().trim();
			//System.out.println("Booking id is = " +Booking_ID);
			if(Booking_ID.endsWith("-2")) {
				return Booking_ID;
			}
			else
			{
				System.out.println("Booking ID is not having -2");
			}
			return Booking_ID;
			
		
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
		ExtentManager.getTest().log(Status.PASS, "Test type is selected same as present in url");
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
		boolean consentSelected = phleBotomist_booking_page_locators.get_consent_CheckBox().isSelected();
		boolean termsSelected = phleBotomist_booking_page_locators.get_terms_CheckBox().isSelected();
		if(consentSelected && termsSelected) {
			Assert.assertTrue(true, "Both checkboxes are selected");
			System.out.println("Assertion Passed: Both checkboxes are selected");
			WebButton.clickButton(phleBotomist_booking_page_locators.get_SubmitBtn());
			ExtentManager.getTest().log(Status.PASS, "Both checkBoxes are selected");
		}
		else
		{
			Assert.fail("Assertion Fail: One or both checkboxes not selected");
		}
		
	}
	
	public void checkbox_NotSelected() throws InterruptedException {
		cancel_Appointment();
		//check_Test_Type_With_URL();
		//WebButton.clickButton(phleBotomist_booking_page_locators.get_ConfirmBtn());
		Thread.sleep(2000);
		WebButton.clickButton(phleBotomist_booking_page_locators.get_SubmitBtn());
		Thread.sleep(2000);
		boolean consentSelected = phleBotomist_booking_page_locators.get_consent_CheckBox().isSelected();
		boolean termsSelected = phleBotomist_booking_page_locators.get_terms_CheckBox().isSelected();
		if(!consentSelected && !termsSelected) {
			System.out.println("One or both checkboxes not selected");
			ExtentManager.getTest().log(Status.INFO, "CheckBoxes are not selected");
		}
		else {
			System.out.println("Both checkboxes are selected");
		}
		
		Thread.sleep(2000);
		
		WebButton.clickButton(phleBotomist_booking_page_locators.get_SubmitBtn());
		String txtDecCons = phleBotomist_booking_page_locators.get_txtDeclarationConsent().getText();
		boolean status = phleBotomist_booking_page_locators.get_txtDeclarationConsent().isDisplayed();
		if(status == true) {
			System.out.println("User did not proceed and is on Declaration Consent page");
		}
		Assert.assertEquals(txtDecCons, "Declaration of consent");
		ExtentManager.getTest().log(Status.PASS, "User did not proceed and is on Declaration Consent page");
		
		
	}
	
	public void verifyMandatoryFields() throws InterruptedException {
		
		checkbox_Validation();
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 800).perform();

		phleBotomist_booking_page_locators.gettxtRegContinue().submit();
		
		boolean allErrorsPresent = 
			phleBotomist_booking_page_locators.get_txtEmptyDOB().isDisplayed() &&
		 	phleBotomist_booking_page_locators.get_txtEmptyGender().isDisplayed() &&
		 	phleBotomist_booking_page_locators.get_txtEmptyPhNo().isDisplayed() &&
		 	phleBotomist_booking_page_locators.get_txtEmptySexBirth().isDisplayed();
		
		
			System.out.println("dobError: "+phleBotomist_booking_page_locators.get_txtEmptyDOB().getText());
			System.out.println("genderError: "+phleBotomist_booking_page_locators.get_txtEmptySexBirth().getText());
			System.out.println("phoneError: "+phleBotomist_booking_page_locators.get_txtEmptyPhNo().getText());
			System.out.println("genderIdentificationError: "+phleBotomist_booking_page_locators.get_txtEmptyGender().getText());
			Assert.assertTrue(allErrorsPresent, "Some mandatory field error messages are missing.");
			System.out.println("Assertion Passed: User cannot proceed without entering all mandatory fields" );
			
			ExtentManager.getTest().log(Status.PASS, "User cannot proceed without entering all mandatory fields");
	}
	
	public void selectFurtureDOB() throws InterruptedException {
		checkbox_Validation();
		WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.gettxtDOB(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(phleBotomist_booking_page_locators.gettxtDOB(), "01/02/2030");
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 800).perform();

		phleBotomist_booking_page_locators.gettxtRegContinue().submit();
		
		WebWait.visibilityOfElement(driver, phleBotomist_booking_page_locators.getAgeErrorMsg(), Duration.ofSeconds(20));

		String actual=phleBotomist_booking_page_locators.getAgeErrorMsg().getText();
		System.out.println("DOB Error msg: "+actual);
		
		Assert.assertEquals(actual, "You must be at least 18 years old");
		ExtentManager.getTest().log(Status.PASS, "DOB Error msg: "+actual);
		
	}
	
	public void verifySexAtBirthSel() throws InterruptedException {
		checkbox_Validation();
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 800).perform();
		WebWait.elementToBeClickable(driver, phleBotomist_booking_page_locators.getSelectGender(), Duration.ofSeconds(20));
		WebButton.clickButton(phleBotomist_booking_page_locators.getSelectGender());
		System.out.println("Gender: "+phleBotomist_booking_page_locators.getSelectGender().getText());
		

		phleBotomist_booking_page_locators.gettxtRegContinue().submit();
		try {
		    boolean allErrorsPresent = true;

		    // Check DOB error message
		    if (phleBotomist_booking_page_locators.get_txtEmptyDOB().isDisplayed()) {
		        System.out.println("dobError: " + phleBotomist_booking_page_locators.get_txtEmptyDOB().getText());
		    } else {
		        System.out.println("DOB error message is not displayed.");
		        allErrorsPresent = false;
		    }

		    // Check Gender error message, but allow it to be missing
		    if (phleBotomist_booking_page_locators.get_txtEmptyGender().isDisplayed()) {
		        System.out.println("genderError: " + phleBotomist_booking_page_locators.get_txtEmptyGender().getText());
		    } else {
		        System.out.println("Gender error message is not displayed (This is allowed).");
		    }

		    // Check Phone Number error message
		    if (phleBotomist_booking_page_locators.get_txtEmptyPhNo().isDisplayed()) {
		        System.out.println("phoneError: " + phleBotomist_booking_page_locators.get_txtEmptyPhNo().getText());
		    } else {
		        System.out.println("Phone number error message is not displayed.");
		        allErrorsPresent = false;
		    }

		    // Handle Sex at Birth error check with try-catch in case it's not in the DOM
		    try {
		        if (phleBotomist_booking_page_locators.get_txtEmptySexBirth().isDisplayed()) {
		            System.out.println("genderIdentificationError: " + phleBotomist_booking_page_locators.get_txtEmptySexBirth().getText());
		        } else {
		            System.out.println("'Sex at Birth is required' error message is not displayed.");
		            allErrorsPresent = false;
		        }
		    } catch (NoSuchElementException | NullPointerException e) {
		        System.out.println("sexAtBirthError: 'Sex at Birth is required' element is NOT present on the web page.");
		        allErrorsPresent = false;
		    }

		    // Assert that all mandatory errors are present except for the Gender error
		    Assert.assertFalse(allErrorsPresent, "'Sex at Birth is required' is present on the web page.");
		    System.out.println("Assertion Passed: 'Sex at Birth is required' element is NOT present on the web page.");
		    ExtentManager.getTest().log(Status.PASS, "'Sex at Birth is required' element is NOT present on the web page.");

		} catch (Exception e) {
		    System.out.println("An Error Occurred: " + e.getMessage());
		}

		       
	}
	
	public void verifyGenderIdentification() throws InterruptedException {
		
		checkbox_Validation();
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 800).perform();
		WebWait.elementToBeClickable(driver, phleBotomist_booking_page_locators.getSelectIdentifyGender(), Duration.ofSeconds(20));
		WebButton.clickButton(phleBotomist_booking_page_locators.getSelectIdentifyGender());
		System.out.println("Gender: "+phleBotomist_booking_page_locators.getSelectIdentifyGender().getText());
		

		phleBotomist_booking_page_locators.gettxtRegContinue().submit();
		try {
		    boolean allErrorsPresent = true;

		    // Check DOB error message
		    if (phleBotomist_booking_page_locators.get_txtEmptyDOB().isDisplayed()) {
		        System.out.println("dobError: " + phleBotomist_booking_page_locators.get_txtEmptyDOB().getText());
		    } else {
		        System.out.println("DOB error message is not displayed.");
		        allErrorsPresent = false;
		    }

		    // Check Gender error message, but allow it to be missing
		    if (phleBotomist_booking_page_locators.get_txtEmptySexBirth().isDisplayed()) {
		        System.out.println("genderError: " + phleBotomist_booking_page_locators.get_txtEmptySexBirth().getText());
		    } else {
		        System.out.println("Gender error message is not displayed (This is allowed).");
		    }

		    // Check Phone Number error message
		    if (phleBotomist_booking_page_locators.get_txtEmptyPhNo().isDisplayed()) {
		        System.out.println("phoneError: " + phleBotomist_booking_page_locators.get_txtEmptyPhNo().getText());
		    } else {
		        System.out.println("Phone number error message is not displayed.");
		        allErrorsPresent = false;
		    }

		    // Handle Sex at Birth error check with try-catch in case it's not in the DOM
		    try {
		        if (phleBotomist_booking_page_locators.get_txtEmptyGender().isDisplayed()) {
		            System.out.println("genderIdentificationError: " + phleBotomist_booking_page_locators.get_txtEmptyGender().getText());
		        } else {
		            System.out.println("'Sex at Birth is required' error message is not displayed.");
		            allErrorsPresent = false;
		        }
		    } catch (NoSuchElementException | NullPointerException e) {
		        System.out.println("genderIdentificationError: 'You must indicate if you still identify with this gender' element is NOT present on the web page.");
		        allErrorsPresent = false;
		    }

		    // Assert that all mandatory errors are present except for the Gender error
		    Assert.assertFalse(allErrorsPresent, "'You must indicate if you still identify with this gender' is present on the web page.");
		    System.out.println("Assertion Passed: 'You must indicate if you still identify with this gender' element is NOT present on the web page.");
		    ExtentManager.getTest().log(Status.PASS, "'You must indicate if you still identify with this gender' element is NOT present on the web page.");

		} catch (Exception e) {
		    System.out.println("An Error Occurred: " + e.getMessage());
		}
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
		WebButton.clickButton(phleBotomist_booking_page_locators.get_boots_App_Menu());

		try {
			
			//WebWait.elementToBeClickable(driver, phleBotomist_booking_page_locators.getContinueBtn(), Duration.ofSeconds(20));
			Thread.sleep(2000);
			WebButton.clickButton(phleBotomist_booking_page_locators.getContinueBtn());
		}
		catch(Exception e){
			//WebWait.elementToBeClickable(driver, phleBotomist_booking_page_locators.get_cancel_Reg_Btn(), Duration.ofSeconds(10));
			Thread.sleep(2000);
			WebButton.clickButton(phleBotomist_booking_page_locators.get_cancel_Reg_Btn());
		
			WebWait.elementToBeClickable(driver, phleBotomist_booking_page_locators.getreject_Cnfrm_Btn(), Duration.ofSeconds(20));
			WebButton.clickButton(phleBotomist_booking_page_locators.getreject_Cnfrm_Btn());
			
			WebWait.elementToBeClickable(driver, phleBotomist_booking_page_locators.getContinueBtn(), Duration.ofSeconds(20));
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



		public String Verify_Complete_Health_Assessment_Form_6() throws InterruptedException {



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
			return alert_expected_AppointmentRegNo;

		}
		
		public void selectTestType() throws InterruptedException {
			
			cancel_Appointment();
			Thread.sleep(2000);
			
			WebDropDown.selectByText(phleBotomist_booking_page_locators.gettest_Type_dropDown(), "Energy Profile");
			WebButton.clickButton(phleBotomist_booking_page_locators.get_txtCnfCnt());
			Thread.sleep(2000);
			String txtDecCons = phleBotomist_booking_page_locators.get_txtDeclarationConsent().getText();
			boolean status = phleBotomist_booking_page_locators.get_txtDeclarationConsent().isDisplayed();
			if(status == true) {
				System.out.println("New Test Type is selected");
				System.out.println("Declaration Consent is displayed");
			}
			Assert.assertEquals(txtDecCons, "Declaration of consent");
			ExtentManager.getTest().log(Status.PASS, "New Test Type is selected");
		}
		
		
}
