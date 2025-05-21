package Smoke.Tims.Test_Cases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Actions_Class.Phlebotomist_csv_import_Actions;
import initializer.BaseClass;
import initializer.ExtentManager;

public class T14_T15_Verify_New_BookingID_Generated_With_Partial_Result extends BaseClass{

	Login_Action Login_action;
	Phlebotomist_csv_import_Actions  phlebotomist_csv_import_actions;
	
	@Test
	public void Verify_2Booking_Generated_SOFT_1048_TC_01() throws Exception {
		Login_action = new Login_Action(getDriver());

		//Login_action.login_Dashboard();

		phlebotomist_csv_import_actions = new Phlebotomist_csv_import_Actions(getDriver());
		phlebotomist_csv_import_actions.upload_Partial_Result();
	}
	
	@Test(dependsOnMethods = "Verify_2Booking_Generated_SOFT_1048_TC_01")
	public void Partial_Result_Upload_Email_SOFT_1048_TC_02() throws Exception {
		phlebotomist_csv_import_actions = new Phlebotomist_csv_import_Actions(getDriver());
		phlebotomist_csv_import_actions.partial_Result_Email_Received();
		
		
	}
	
	@Test(dependsOnMethods = "Verify_2Booking_Generated_SOFT_1048_TC_01")
	public void verify_Test_Kit_Error_Status() throws IOException, InterruptedException {
		phlebotomist_csv_import_actions = new Phlebotomist_csv_import_Actions(getDriver());
		String status = phlebotomist_csv_import_actions.test_Kit_Satus();
		System.out.println(status);
		assertEquals(status, "error");
		ExtentManager.getTest().log(Status.PASS, "Status of the test kits changed to error");
		
		
		
	}
}
