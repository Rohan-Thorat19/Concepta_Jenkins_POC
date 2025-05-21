package Smoke.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_07_Verify_Complete_Health_Assessment extends BaseClass {
	
	public Login_Health_Professional_Actions login_health_professional_actions;
	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;

	@Test
	public void  Verify_Complete_Health_Assessment_Soft_689_TC_01() throws IOException, InterruptedException {
		Login_Action Login_action;

		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard();

		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());

		phleBotomist_booking_page_action.Verify_Complete_Health_Assessment_Form_5();
	}


}
