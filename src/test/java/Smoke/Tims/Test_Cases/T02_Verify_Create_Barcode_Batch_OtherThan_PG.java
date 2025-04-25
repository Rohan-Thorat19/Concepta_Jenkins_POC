package Smoke.Tims.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Create_test_kit_For_PG_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class T02_Verify_Create_Barcode_Batch_OtherThan_PG extends BaseClass{

	// Declaration
		public Create_test_kit_For_PG_Actions create_test_kit_actions;
		T01_Verify_Tims_Login_Valid_Cred loginTest;
		Login_Action Login_action;
		
	    @Test
		public void Barcode_Batch_Other_Than_PG_SOFT_262_F3_Smoke() throws IOException, InterruptedException {
			

			Login_action = new Login_Action(getDriver());
			Login_action.login_Tims();
			create_test_kit_actions = new Create_test_kit_For_PG_Actions(getDriver());

			create_test_kit_actions.other_than_Phlebotomy_Gold();

		}
}
