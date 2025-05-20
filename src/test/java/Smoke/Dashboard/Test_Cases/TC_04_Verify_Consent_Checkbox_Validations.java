package Smoke.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_04_Verify_Consent_Checkbox_Validations extends BaseClass{
	// Declaration
			public Login_Health_Professional_Actions login_health_professional_actions;
			PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
//			Login_Tims loginTest;
			Login_Action Login_action;
			
		    @Test
			public void Verify_Consent_Checkbox_Validations_SOFT_684_F1() throws IOException, InterruptedException {
				
//				loginTest = new Login_Tims();
				Login_action = new Login_Action(getDriver());
//				loginTest.login_Tims();
				Login_action.login_dev_Dashboard();
				
				phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
				
				
				phleBotomist_booking_page_action.checkbox_Validation();

			}
}
