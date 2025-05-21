package Regression.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_26_Verify_sex_at_birth_selection extends BaseClass {

	Login_Action Login_action;
	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
	
	
	@Test
	public void Verify_sex_at_birth_selection_SOFT_686_F6() throws IOException, InterruptedException {
		Login_action = new Login_Action(getDriver());

		Login_action.login_Dashboard2();
		
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(getDriver());
		phleBotomist_booking_page_action.verifySexAtBirthSel();
	}
}
