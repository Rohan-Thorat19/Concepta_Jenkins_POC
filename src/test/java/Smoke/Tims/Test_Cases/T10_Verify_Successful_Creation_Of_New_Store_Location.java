package Smoke.Tims.Test_Cases;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Actions_Class.Phlebotomist_User_Create_Delete_Action;
import Test.Tims.Actions_Class.Store_Location_Actions;
import initializer.BaseClass;

public class T10_Verify_Successful_Creation_Of_New_Store_Location extends BaseClass{
	Login_Action Login_action;
	Store_Location_Actions store_location_actions;
	 @Test
		public void Verify_Successful_Creation_Of_New_Store_Location_SOFT_543_F1() throws Exception {
			

			Login_action = new Login_Action(getDriver());	
			store_location_actions = new Store_Location_Actions(getDriver());
			
			Login_action.login_Tims_dev();
			store_location_actions.create_New_Location();

		
		}

}
