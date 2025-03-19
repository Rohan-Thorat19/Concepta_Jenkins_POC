package Hcp.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Kit.Actions_Class.Login_Action;
import initializer.BaseClass;

public class Verify_Login_HCP extends BaseClass {

	// Declaration
		public Login_Health_Professional_Actions login_health_professional_actions;
//		Login_Tims loginTest;
		Login_Action Login_action;
		
	    @Test
		public void Verify_Hcp_Login_For_Invalid_Data() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP_With_Invalid_Data();
			Thread.sleep(2000);				
	    }
	    
	    @Test
		public void Verify_Hcp_Login_For_Valid_Data() throws IOException, InterruptedException
	    {			
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP_With_Valid_Data();
			Thread.sleep(2000);				
	    }

}
