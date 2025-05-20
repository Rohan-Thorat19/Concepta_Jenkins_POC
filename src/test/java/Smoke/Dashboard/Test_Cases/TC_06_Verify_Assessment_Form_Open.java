package Smoke.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_06_Verify_Assessment_Form_Open extends BaseClass{
	
				public Login_Health_Professional_Actions login_health_professional_actions;
				PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;

				Login_Action Login_action;
				
			    @Test
				public void Verify_Health_Assessment_Form_Open_SOFT_687_F1() throws IOException, InterruptedException {
					

					Login_action = new Login_Action(getDriver());

					Login_action.login_dev_Dashboard();
					
					phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
					
					
					phleBotomist_booking_page_action.health_Assessment_Form_Nav();
				}

}
