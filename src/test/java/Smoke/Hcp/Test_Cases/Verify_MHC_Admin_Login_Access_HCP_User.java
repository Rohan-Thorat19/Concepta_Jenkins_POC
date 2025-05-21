package Smoke.Hcp.Test_Cases;

import org.testng.annotations.Test;

import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Hcp.Actions_Class.MHC_Admin_Login_Access_HCP_User_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class Verify_MHC_Admin_Login_Access_HCP_User extends BaseClass
{
	public Login_Health_Professional_Actions login_health_professional_actions;
	MHC_Admin_Login_Access_HCP_User_Actions mHC_admin_login_access_hCP_user_actions;
	String AccountUrl;
//	Login_Tims loginTest;
	
	public Login_Action login;
	@Test
	
	public void Verify_Admin_has_access_to_the_Add_Phlebotomist_section() throws Exception {

		// Initialization
		login = new Login_Action(getDriver());
		login.login_Tims_For_HCP();
		mHC_admin_login_access_hCP_user_actions = new MHC_Admin_Login_Access_HCP_User_Actions(getDriver());
		AccountUrl = mHC_admin_login_access_hCP_user_actions.Load_Csv_And_Confirm_Email_Account_Button();
	}
		
	@Test(dependsOnMethods = "Verify_Admin_has_access_to_the_Add_Phlebotomist_section")
	
	public void Verify_Phlebotomist_has_an_account_on_portal()
	{
		login_health_professional_actions = new Login_Health_Professional_Actions(getDriver());
		login_health_professional_actions.Account_Creation_Url_Check(AccountUrl);
		
			
	}
		
}
	
