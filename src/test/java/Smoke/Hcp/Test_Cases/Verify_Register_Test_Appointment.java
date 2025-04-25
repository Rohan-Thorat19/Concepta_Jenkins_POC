package Smoke.Hcp.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Hcp.Actions_Class.Register_Test_Appointment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class Verify_Register_Test_Appointment extends BaseClass {
	Login_Action Login_action;
	Register_Test_Appointment_Actions Register_Test_Appointment_Actions;

	 @Test
		public void HCP_Login_And_Search_Customer() throws IOException, InterruptedException {
			
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			Register_Test_Appointment_Actions = new Register_Test_Appointment_Actions(getDriver());
			
			Register_Test_Appointment_Actions.book_Test_Appointment();

		}
}
