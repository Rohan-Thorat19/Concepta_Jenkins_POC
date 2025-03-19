package Dashboard.Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;

import PreTestDataActions.PreDataAction;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Kit.Actions_Class.Create_test_kit_Actions;
import Test.Kit.Actions_Class.Login_Action;
import Wrappers.WebCommonPath;
import dataSources.Excel;
import initializer.BaseClass;

public class Verify_Dashboard_Login extends BaseClass {

	// Declaration
	Login_Action Login_action;
	PreDataAction preDataAction=null;
	
   /* @Test
	public void Hcp_Login() throws IOException, InterruptedException {
		
//		loginTest = new Login_Tims();
		Login_action = new Login_Action(getDriver());
//		loginTest.login_Tims();
		Login_action.login_HCP();
		login_health_professional_actions = new Login_Health_Professional_Actions(getDriver());

		login_health_professional_actions.verify_hcp_locin();;

	}*/
	
	@Test
	 public void Dashboard_login_Test_Data_Creation_for_HCP_Smoke()throws IOException, InterruptedException
	 { 		
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboardfor_HcpSmoke();
		preDataAction = new PreDataAction(getDriver());
		preDataAction.Create_Account();
	 }
	
    
}
	


