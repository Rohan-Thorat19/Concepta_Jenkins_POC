package Smoke.Tims.Test_Cases;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Actions_Class.Phlebotomist_csv_import_Actions;
import Test.Tims.Actions_Class.Store_Location_Actions;
import initializer.BaseClass;

public class T11_T12_T13_Verify_Successful_CSV_Import_with_Valid_Data extends BaseClass{
	Login_Action Login_action;
	Phlebotomist_csv_import_Actions  phlebotomist_csv_import_actions;
	
	 @Test
		public void Verify_Successful_Creation_Of_New_Store_Location_SOFT_543_F1() throws Exception {
			

			Login_action = new Login_Action(getDriver());	
			Login_action.login_Tims_dev();
			
			phlebotomist_csv_import_actions = new Phlebotomist_csv_import_Actions(getDriver());
			phlebotomist_csv_import_actions.import_phlebotomist_User_Csv();

		
		}
	 @Test(dependsOnMethods = "Verify_Successful_Creation_Of_New_Store_Location_SOFT_543_F1")
		public void Verify_Email_Triggered_To_All_Added_Phlebotomist_SOFT_562_F15() throws Exception {
			
			phlebotomist_csv_import_actions = new Phlebotomist_csv_import_Actions(getDriver());
			phlebotomist_csv_import_actions.email_Triggered_To_User();

	 }	
	 
	 
	 @Test(dependsOnMethods = "Verify_Email_Triggered_To_All_Added_Phlebotomist_SOFT_562_F15")
		public void Verify_Email_Content_Create_My_Account_Button_SOFT_563_F6() throws Exception {
			
			phlebotomist_csv_import_actions = new Phlebotomist_csv_import_Actions(getDriver());
			phlebotomist_csv_import_actions.email_content_Create_Account_Link();

	 }	
	 

}
