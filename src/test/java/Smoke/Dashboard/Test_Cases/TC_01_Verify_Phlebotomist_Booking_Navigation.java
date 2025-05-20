package Smoke.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Dashboard.Locators_Class.PhleBotomist_Booking_Page_Locators;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_01_Verify_Phlebotomist_Booking_Navigation extends BaseClass {
	// Declaration
		public Login_Health_Professional_Actions login_health_professional_actions;
		PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
//		Login_Tims loginTest;
		Login_Action Login_action;
		
	    @Test
		public void Verify_Registration_Page_Navigation_SOFT_683_F2() throws IOException, InterruptedException {
			
//			loginTest = new Login_Tims();
			Login_action = new Login_Action(getDriver());
//			loginTest.login_Tims();
			Login_action.login_dev_Dashboard();
			
			phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
			
			
			phleBotomist_booking_page_action.navigate_To_Reg_Page();

		}
}
