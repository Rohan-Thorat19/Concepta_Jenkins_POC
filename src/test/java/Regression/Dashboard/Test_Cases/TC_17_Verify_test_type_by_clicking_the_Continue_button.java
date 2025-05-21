package Regression.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_17_Verify_test_type_by_clicking_the_Continue_button extends BaseClass {
	
	Login_Action Login_action;
	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
	
	@Test
	public void Verify_test_type_by_clicking_the_Continue_button_SOFT_685_F4() throws IOException, InterruptedException {
		
		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard2();
		

		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		
		phleBotomist_booking_page_action.check_Test_Type_With_URL();
		phleBotomist_booking_page_action.clickContinueMyReg();

	}
}
