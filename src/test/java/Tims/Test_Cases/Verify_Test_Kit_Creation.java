package Tims.Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;

import Test.Kit.Actions_Class.Create_test_kit_Actions;
import Test.Kit.Actions_Class.Login_Action;
import Wrappers.WebCommonPath;
import dataSources.Excel;
import initializer.BaseClass;

public class Verify_Test_Kit_Creation extends BaseClass {

	// Declaration
	public Create_test_kit_Actions create_test_kit_actions;
//	Login_Tims loginTest;
	Login_Action Login_action;
	
    @Test
	public void Create_kit_Smoke() throws IOException, InterruptedException {
		
//		loginTest = new Login_Tims();
		Login_action = new Login_Action(getDriver());
//		loginTest.login_Tims();
		Login_action.login_Tims();
		create_test_kit_actions = new Create_test_kit_Actions(getDriver());

		create_test_kit_actions.Test_Kit_Creation();

	}
	
    
}
	


