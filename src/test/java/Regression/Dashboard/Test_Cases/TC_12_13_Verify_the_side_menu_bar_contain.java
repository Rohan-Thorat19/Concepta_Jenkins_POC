package Regression.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Dashboard.Locators_Class.PhleBotomist_Booking_Page_Locators;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Tims.Actions_Class.Login_Action;
import Wrappers.WebButton;
import Wrappers.WebElementCommon;
import initializer.BaseClass;
import initializer.ExtentManager;

public class TC_12_13_Verify_the_side_menu_bar_contain extends BaseClass {
	
	Login_Health_Professional_Actions login_health_professional_actions;
	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
	PhleBotomist_Booking_Page_Locators phleBotomist_booking_page_locators;
//	Login_Tims loginTest;
	Login_Action Login_action;
	
	@Test
	public void Verify_the_side_menu_bar_contain_SOFT_683_F3() throws IOException {
		
		Login_action = new Login_Action(getDriver());
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		
		Login_action.login_Dashboard2();
		phleBotomist_booking_page_action.checkBootAppointmentIsPresent();
		
	}
	@Test(dependsOnMethods = "Verify_the_side_menu_bar_contain_SOFT_683_F3")
	public void Verify_whether_the_Continue_button_is_clickable_SOFT_683_F4() throws IOException, InterruptedException {
		Login_action = new Login_Action(getDriver());
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		phleBotomist_booking_page_locators = new PhleBotomist_Booking_Page_Locators(getDriver());
		
		Login_action.login_Dashboard2();
		phleBotomist_booking_page_action.navigate_To_Reg_Page();
		
		Assert.assertTrue(WebElementCommon.isClickable(phleBotomist_booking_page_locators.getContinueBtn()));
		WebButton.JsclickButton(phleBotomist_booking_page_locators.getContinueBtn(),getDriver());
		ExtentManager.getTest().log(Status.PASS, "Continue Button is Clicked");
	}
	
	
}
