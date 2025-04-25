package Smoke.Tims.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Actions_Class.Phlebotomist_User_Create_Delete_Action;
import initializer.BaseClass;

public class T07_Verify_invalid_Inputs_for_Phleb_Account_Creation extends BaseClass{
	public Phlebotomist_User_Create_Delete_Action phlebotomist_user_create_delete_action;
//	Login_Tims loginTest;
	Login_Action Login_action;
	
	
	
	
    @Test
	public void Verify_Error_Message_Display_for_Invalid_Inputs_SOFT_538_UI6() throws IOException, InterruptedException {
		

		Login_action = new Login_Action(getDriver());	
		
		Login_action.login_Tims();
		
		phlebotomist_user_create_delete_action = new Phlebotomist_User_Create_Delete_Action(getDriver());
		
		phlebotomist_user_create_delete_action.validated_Email_Field();
	
	}
}
