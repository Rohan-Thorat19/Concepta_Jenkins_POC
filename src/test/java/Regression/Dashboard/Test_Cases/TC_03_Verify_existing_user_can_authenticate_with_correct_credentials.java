package Regression.Dashboard.Test_Cases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Dashboard.Locators_Class.Login_Boot_Locators;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Tims.Actions_Class.Login_Action;
import Wrappers.WebButton;
import Wrappers.WebWait;
import initializer.BaseClass;

public class TC_03_Verify_existing_user_can_authenticate_with_correct_credentials extends BaseClass {
	
	public Login_Health_Professional_Actions login_health_professional_actions;
	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
	
	Login_Boot_Locators login_boot_locators;
	Login_Action Login_action;
	Login_Boot_Actions login_boot_actions;
	@Test
	public void Verify_existing_user_can_authenticate_with_correct_credentials_SOFT_682_F2() throws IOException, InterruptedException{
		
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		Login_Health_Professional_Actions login_health_professional_actions = new Login_Health_Professional_Actions(getDriver());
		login_health_professional_actions.clickOnEnableLaterBtn();
		Login_Boot_Actions login_boot_actions = new Login_Boot_Actions(getDriver());
		Assert.assertEquals(login_boot_actions.welcomeTextMsg(), "Welcome to your personalised MyHealthChecked panel.");
	}
	
	
}
