package Smoke.Tims.Test_Cases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Actions_Class.Phlebotomist_csv_import_Actions;
import initializer.BaseClass;
import initializer.ExtentManager;

public class T16_Verify_Status_Of_Test_Kits_Change_To_Error extends BaseClass {

	Login_Action Login_action;
	String barcode;
	Phlebotomist_csv_import_Actions  phlebotomist_csv_import_actions;
	
	@Test
	public void verify_Test_Kit_Error_Status() throws Exception {
		phlebotomist_csv_import_actions = new Phlebotomist_csv_import_Actions(getDriver());
		String status = phlebotomist_csv_import_actions.test_Kit_Satus(barcode);
		System.out.println(status);
		assertEquals(status, "error");
		ExtentManager.getTest().log(Status.PASS, "Status of the test kits changed to error");
		
		
		
	}

}
