package Smoke.Tims.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Create_test_kit_For_PG_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class T04_Verify_PG_Barcode_Format extends BaseClass{

	public Create_test_kit_For_PG_Actions create_test_kit_actions;
	T01_Verify_Tims_Login_Valid_Cred loginTest;
	Login_Action Login_action;
	
    @Test
	public void Verify_Barcode_format_SOFT_262_V2_Smoke() throws IOException, InterruptedException {
		
	//	loginTest = new Login_Tims();
		Login_action = new Login_Action(getDriver());
	//	loginTest.loginToTims();
		Login_action.login_Tims();
		create_test_kit_actions = new Create_test_kit_For_PG_Actions(getDriver());

		create_test_kit_actions.barcode_Format_Verification();
	}
}
