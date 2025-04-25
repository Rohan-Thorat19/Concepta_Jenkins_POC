package Smoke.Dashboard.Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;

import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Tims.Actions_Class.Create_test_kit_For_PG_Actions;
import Test.Tims.Actions_Class.Login_Action;
import Wrappers.WebCommonPath;
import dataSources.Excel;
import initializer.BaseClass;

public class Verify_Dashboard_Login extends BaseClass {

	// Declaration
	public Login_Health_Professional_Actions login_health_professional_actions;
//	Login_Tims loginTest;
	Login_Action Login_action;
	
    @Test
	public void Verify_DashBoard_Login() throws IOException, InterruptedException {
		
//		loginTest = new Login_Tims();
		Login_action = new Login_Action(getDriver());
//		loginTest.login_Tims();
		Login_action.login_Dashboard();

	}
	
    
}
	


