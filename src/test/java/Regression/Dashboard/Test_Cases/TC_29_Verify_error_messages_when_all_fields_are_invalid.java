package Regression.Dashboard.Test_Cases;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_29_Verify_error_messages_when_all_fields_are_invalid extends BaseClass {

	Login_Action Login_action;
	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
	
	@Test
	public void Verify_error_messages_when_all_fields_are_invalid_SOFT_686_F9() throws IOException, InterruptedException, TimeoutException {
		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard2();
		
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		phleBotomist_booking_page_action.verifyInvalidFields();
	}
}
