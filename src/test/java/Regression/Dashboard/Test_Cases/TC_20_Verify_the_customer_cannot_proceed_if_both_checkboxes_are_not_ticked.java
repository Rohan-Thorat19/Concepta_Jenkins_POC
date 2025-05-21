package Regression.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_20_Verify_the_customer_cannot_proceed_if_both_checkboxes_are_not_ticked extends BaseClass {

	Login_Action Login_action;
	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
	
	@Test
	public void Verify_the_customer_cannot_proceed_if_both_checkboxes_are_not_ticked_SOFT_684_F3() throws IOException, InterruptedException {
		
		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard2();
		

		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		phleBotomist_booking_page_action.checkbox_NotSelected();
	}
}
