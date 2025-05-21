package Regression.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Dashboard.Locators_Class.Login_Boot_Locators;
import Wrappers.WebTextBox;
import initializer.BaseClass;

public class TC_08_Verify_email_input_field_with_invalid_email_format extends BaseClass{
	
	Login_Boot_Locators login_boot_locators;
	
	@Test
	public void TC_08_Verify_email_input_field_with_invalid_email_format_SOFT_682_F7() throws IOException {
		login_boot_locators = new Login_Boot_Locators(getDriver());
		Login_Boot_Actions login_boot_actions;
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.boot_Url();
//		login_boot_actions.enterEmailID_boot("timik1inkight.com");
//		login_boot_actions.enterPassword_boot("Aress@12");
//		login_boot_actions.clickLoginButton_boot();
		
		WebTextBox.sendInputUpdate(login_boot_locators.getEmailaddress_boot(), "timik1inkight.com");
		WebTextBox.sendInputUpdate(login_boot_locators.getPassword_boot(), "Aress@12");
		login_boot_actions.clickLoginButton_boot();
		Assert.assertEquals(login_boot_actions.invalidEmailMsg(), "Please enter a valid email");
		
	}
}
