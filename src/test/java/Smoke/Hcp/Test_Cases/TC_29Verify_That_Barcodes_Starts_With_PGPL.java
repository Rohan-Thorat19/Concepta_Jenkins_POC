package Smoke.Hcp.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Hcp.Actions_Class.Patients_Details_Actions;
import Test.Hcp.Actions_Class.Tims_TC_For_HCP_Smoke_Actions;
import initializer.BaseClass;

public class TC_29Verify_That_Barcodes_Starts_With_PGPL extends BaseClass {

	// Declaration
		public Tims_TC_For_HCP_Smoke_Actions tims_TC_For_HCP_Smoke_Actions;
		//public Login_Action Login_action;
		@Test
		public void Verify_That_Barcodes_Starts_With_PGPL() throws IOException, InterruptedException
	    {
			tims_TC_For_HCP_Smoke_Actions = new Tims_TC_For_HCP_Smoke_Actions(getDriver());
			tims_TC_For_HCP_Smoke_Actions.login_Tims();	
			tims_TC_For_HCP_Smoke_Actions.functionalityOfBarcodeWithPGPL();
	    }

}
