package Regression.Dashboard.Test_Cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PreTestDataActions.PreDataAction;
import PreTestDataLocators.PreDataLocators;
import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Wrappers.WebTextBox;
import initializer.BaseClass;

public class TC_09_Verify_password_field_with_weak_password extends BaseClass {
	
	PreDataLocators preDataLocators;
	
	@Test
	public void TC_09_Verify_password_field_with_weak_password_SOFT_682_F8() throws IOException {
		Login_Boot_Actions login_boot_actions;
		preDataLocators=new PreDataLocators(getDriver());
		PreDataAction predataactions=new PreDataAction(getDriver());
		login_boot_actions = new Login_Boot_Actions(getDriver());
		
		login_boot_actions.boot_Url();
		predataactions.clickSignUpBtn();
		WebTextBox.sendInputUpdate(preDataLocators.getFirstName(), "Marvin");
		WebTextBox.sendInputUpdate(preDataLocators.getLastName(), "Louis");
		WebTextBox.sendInputUpdate(preDataLocators.getEmail(), "testconcepta3@gmail.com");
		WebTextBox.sendInputUpdate(preDataLocators.getPassword(), "1Wdasd");
		
		Assert.assertEquals(predataactions.txtPwdStrength(), "Weak");
		
	}
}
