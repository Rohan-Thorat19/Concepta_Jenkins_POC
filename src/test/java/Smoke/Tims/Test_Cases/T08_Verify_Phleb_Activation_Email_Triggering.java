package Smoke.Tims.Test_Cases;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Actions_Class.Phlebotomist_User_Create_Delete_Action;
import initializer.BaseClass;

public class T08_Verify_Phleb_Activation_Email_Triggering extends BaseClass{
	public Phlebotomist_User_Create_Delete_Action phlebotomist_user_create_delete_action;
//	Login_Tims loginTest;
	Login_Action Login_action;
	
	
	
	
    @Test
	public void Verify_Phleb_Activation_Email_Triggering_SOFT_563_F1() throws Exception {
		

		Login_action = new Login_Action(getDriver());	
		
		Login_action.login_Tims_dev();
		
		phlebotomist_user_create_delete_action = new Phlebotomist_User_Create_Delete_Action(getDriver());
		
		phlebotomist_user_create_delete_action.create_phleb_Account();
	
	}

}
