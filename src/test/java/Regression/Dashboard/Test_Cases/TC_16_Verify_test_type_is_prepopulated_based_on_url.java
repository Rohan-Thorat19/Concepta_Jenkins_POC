package Regression.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;

import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_16_Verify_test_type_is_prepopulated_based_on_url extends BaseClass {

	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;

	Login_Action Login_action;
	
	@Test
	public void Verify_test_type_is_prepopulated_based_on_url_SOFT_685_F3() throws IOException, InterruptedException {
		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard2();
		
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		
		
		phleBotomist_booking_page_action.check_Test_Type_With_URL();

	}
}
