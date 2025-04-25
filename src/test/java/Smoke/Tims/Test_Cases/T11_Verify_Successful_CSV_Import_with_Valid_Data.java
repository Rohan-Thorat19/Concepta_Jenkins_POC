package Smoke.Tims.Test_Cases;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Actions_Class.Phlebotomist_csv_import_Actions;
import Test.Tims.Actions_Class.Store_Location_Actions;
import initializer.BaseClass;

public class T11_Verify_Successful_CSV_Import_with_Valid_Data extends BaseClass{
	Login_Action Login_action;
	Phlebotomist_csv_import_Actions  phlebotomist_csv_import_actions;
	
	 @Test
		public void Verify_Successful_Creation_Of_New_Store_Location_SOFT_543_F1() throws Exception {
			

			Login_action = new Login_Action(getDriver());	
		
			
			Login_action.login_Tims();
			phlebotomist_csv_import_actions = new Phlebotomist_csv_import_Actions(getDriver());
			
			phlebotomist_csv_import_actions.download_User_Sample_Csv();

		
		}

}
