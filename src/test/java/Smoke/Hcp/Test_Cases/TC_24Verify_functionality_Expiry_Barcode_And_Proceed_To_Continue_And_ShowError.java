package Smoke.Hcp.Test_Cases;
import java.io.IOException;
import org.testng.annotations.Test;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Hcp.Actions_Class.Patients_Details_Actions;
import initializer.BaseClass;

public class TC_24Verify_functionality_Expiry_Barcode_And_Proceed_To_Continue_And_ShowError extends BaseClass {
	// Declaration
	public Patients_Details_Actions patients_details_actions;
	//public Login_Action Login_action;
	public Login_Health_Professional_Actions login_health_professional_actions; 
	
	 @Test
	 public void Verify_functionality_Expiry_Barcode_And_Proceed_To_Continue_And_ShowError() throws InterruptedException, IOException
	 {
		 login_health_professional_actions = new Login_Health_Professional_Actions(getDriver());
			login_health_professional_actions.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.functionality_Expiry_Barcode_And_Proceed_To_Continue();
	 }
}
