package Regression.Dashboard.Test_Cases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Tims.Actions_Class.Login_Action;
import Wrappers.WebButton;
import Wrappers.WebWait;
import initializer.BaseClass;

public class TC_31_32_33_34_35_Verify_Health_Assessment_is_mandatory_for_all_tests extends BaseClass{


	Login_Action Login_action;
	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
	
	@Test
	public void Verify_moving_to_the_next_page_when_Continue_button_is_clicked_SOFT_688_F2() throws IOException, InterruptedException {
		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard2();
		
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());

		phleBotomist_booking_page_action.navToNextPageHAForm();
	}
	
	
	@Test(dependsOnMethods = "Verify_moving_to_the_next_page_when_Continue_button_is_clicked_SOFT_688_F2")
	public void Verify_Health_Assessment_is_mandatory_for_all_tests_SOFT_688_F1() throws IOException, InterruptedException {
		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard2();
		
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		phleBotomist_booking_page_action.verifyHealthAssessmentIsMandatory();
	}
	
	@Test(dependsOnMethods = "Verify_moving_to_the_next_page_when_Continue_button_is_clicked_SOFT_688_F2")
	public void Verify_error_message_when_questions_on_the_current_page_are_not_completed_SOFT_688_F3() throws IOException, InterruptedException {
		
		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard2();
		
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		phleBotomist_booking_page_action.verifyHealthAssessmentIsMandatory();
	}
	
	@Test(dependsOnMethods = "Verify_moving_to_the_next_page_when_Continue_button_is_clicked_SOFT_688_F2")
	public void Verify_customer_cannot_proceed_to_the_next_page_if_questions_are_incomplete_SOFT_688_F4() throws IOException, InterruptedException {
		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard2();
		
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		phleBotomist_booking_page_action.verifyHealthAssessmentIsMandatory();
	}
	
	@Test(dependsOnMethods = "Verify_moving_to_the_next_page_when_Continue_button_is_clicked_SOFT_688_F2")
	public void Verify_error_handling_for_incomplete_health_assessment_form_SOFT_688_F7() throws IOException, InterruptedException {
		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard2();
		
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		phleBotomist_booking_page_action.verifyHealthAssessmentIsMandatory();
	}
}
