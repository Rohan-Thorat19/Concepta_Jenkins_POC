package Smoke.Tims.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Phlebotomist_User_Create_Delete_Action;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class T09_Verify_Delete_Phlebotomist_Account extends BaseClass{
	public Phlebotomist_User_Create_Delete_Action phlebotomist_user_create_delete_action;
//	Login_Tims loginTest;
	Login_Action Login_action;
	
	
	
	
    @Test
	public void Verify_Delete_Phlebotomist_Account_SOFT_540_F1() throws IOException, InterruptedException {
		
//		loginTest = new Login_Tims();
		Login_action = new Login_Action(getDriver());
//		loginTest.login_Tims();
		Login_action.login_Tims_dev();
		phlebotomist_user_create_delete_action = new Phlebotomist_User_Create_Delete_Action(getDriver());
		
		
		phlebotomist_user_create_delete_action.delete_User();

	}
}
