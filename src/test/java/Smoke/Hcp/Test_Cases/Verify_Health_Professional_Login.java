package Smoke.Hcp.Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;

import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Tims.Actions_Class.Login_Action;
import Wrappers.WebCommonPath;
import dataSources.Excel;
import initializer.BaseClass;

public class Verify_Health_Professional_Login extends BaseClass {

	// Declaration
	public Login_Health_Professional_Actions login_health_professional_actions;
//	Login_Tims loginTest;
	Login_Action Login_action;
	
    @Test
	public void Hcp_Login() throws IOException, InterruptedException {
		
//		loginTest = new Login_Tims();
		Login_action = new Login_Action(getDriver());
//		loginTest.login_Tims();
		Login_action.login_dev_HCP();
		login_health_professional_actions = new Login_Health_Professional_Actions(getDriver());

		login_health_professional_actions.verify_hcp_locin();;

	}
	
    
}
	


