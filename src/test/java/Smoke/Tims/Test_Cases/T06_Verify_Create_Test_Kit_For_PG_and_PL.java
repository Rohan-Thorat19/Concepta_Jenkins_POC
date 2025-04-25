package Smoke.Tims.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Create_test_kit_For_PG_Actions;
import Test.Tims.Actions_Class.Create_test_kit_For_PL_Actions;
import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Locators_Class.Create_test_kit_For_PL_Locators;
import initializer.BaseClass;

public class T06_Verify_Create_Test_Kit_For_PG_and_PL extends BaseClass{

	// Declaration
		public Create_test_kit_For_PG_Actions create_test_kit_PG_actions;
		Create_test_kit_For_PL_Actions create_test_kit_PL_actions;
//		Login_Tims loginTest;
		Login_Action Login_action;
		
	    @Test
		public void Create_kit_For_PG_Soft_265_F1_Smoke() throws IOException, InterruptedException {
			
//			loginTest = new Login_Tims();
			Login_action = new Login_Action(getDriver());
//			loginTest.login_Tims();
			Login_action.login_Tims();
			create_test_kit_PG_actions = new Create_test_kit_For_PG_Actions(getDriver());

			create_test_kit_PG_actions.Test_Kit_Creation_PG();
			create_test_kit_PL_actions = new Create_test_kit_For_PL_Actions(getDriver());

			create_test_kit_PL_actions.Test_Kit_Creation_PL();

		}
}
