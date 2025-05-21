package Regression.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_11_Verify_the_navigation_for_Phlebotomist_booking_URL_visit extends BaseClass {

	Login_Health_Professional_Actions login_health_professional_actions;
	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
//	Login_Tims loginTest;
	Login_Action Login_action;
	
	@Test
	public void Verify_the_navigation_for_Phlebotomist_booking_URL_visit_SOFT_683_F2() throws IOException, InterruptedException {
		Login_Boot_Actions login_boot_actions;
		
		Login_action = new Login_Action(getDriver());
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		
//		login_boot_actions = new Login_Boot_Actions(getDriver());
//		login_boot_actions.boot_Url();
//		login_boot_actions.enterEmailID_boot("joxal79046@deusa7.com");
//		login_boot_actions.enterPassword_boot("Aress@12");
//		
//		login_boot_actions.clickLoginButton_boot();
		//login_health_professional_actions.clickOnEnableLaterBtn();
		Login_action = new Login_Action(getDriver());
//		loginTest.login_Tims();
		Login_action.login_Dashboard();
		
		phleBotomist_booking_page_action.navigate_To_Reg_Page();
	}
}
