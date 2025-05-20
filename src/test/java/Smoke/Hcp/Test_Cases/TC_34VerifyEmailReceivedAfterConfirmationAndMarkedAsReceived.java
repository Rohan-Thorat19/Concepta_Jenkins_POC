package Smoke.Hcp.Test_Cases;
import org.testng.annotations.Test;

import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Hcp.Actions_Class.Patients_Details_Actions;
import Test.Hcp.Actions_Class.Tims_TC_For_HCP_Smoke_Actions;
import initializer.BaseClass;

public class TC_34VerifyEmailReceivedAfterConfirmationAndMarkedAsReceived extends BaseClass {

	// Declaration
		public Patients_Details_Actions patients_details_actions;
		//public Login_Action Login_action;
		public Login_Health_Professional_Actions login_health_professional_actions; 
		public Tims_TC_For_HCP_Smoke_Actions tims_TC_For_HCP_Smoke_Actions;
		@Test
		public void VerifyEmailReceivedAfterConfirmationAndMarkedAsReceived() throws Exception
	    {
			    login_health_professional_actions = new Login_Health_Professional_Actions(getDriver());
			    login_health_professional_actions.login_HCP();
				patients_details_actions = new Patients_Details_Actions(getDriver());
				patients_details_actions.functionality_Email_Verification_After_Confirmation();
				tims_TC_For_HCP_Smoke_Actions = new Tims_TC_For_HCP_Smoke_Actions(getDriver());
				tims_TC_For_HCP_Smoke_Actions.login_Tims();
				tims_TC_For_HCP_Smoke_Actions.functionalityOfMarkAsReceivedConfirmEmail();
				tims_TC_For_HCP_Smoke_Actions.ReadGmail("Received At Lab");
				
	    }

}
