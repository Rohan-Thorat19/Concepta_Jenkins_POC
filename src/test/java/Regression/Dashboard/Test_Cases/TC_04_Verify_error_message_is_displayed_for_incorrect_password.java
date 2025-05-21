package Regression.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import initializer.BaseClass;

public class TC_04_Verify_error_message_is_displayed_for_incorrect_password extends BaseClass {

	@Test
	public void Verify_error_message_is_displayed_for_incorrect_password_SOFT_682_F3() throws IOException {
		Login_Boot_Actions login_boot_actions;
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.boot_Url();
		login_boot_actions.enterEmailID_boot("timik88241@inkight.com");
		login_boot_actions.enterPassword_boot("Aress12");
		login_boot_actions.clickLoginButton_boot();
		
		Assert.assertEquals(login_boot_actions.incorrectPasswordMsg(), "Incorrect password.");
		
	}
}
