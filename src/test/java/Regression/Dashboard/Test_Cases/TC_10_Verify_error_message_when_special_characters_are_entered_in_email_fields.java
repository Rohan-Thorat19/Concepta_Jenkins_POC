package Regression.Dashboard.Test_Cases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PreTestDataActions.PreDataAction;
import PreTestDataLocators.PreDataLocators;
import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Wrappers.WebButton;
import Wrappers.WebTextBox;
import initializer.BaseClass;

public class TC_10_Verify_error_message_when_special_characters_are_entered_in_email_fields extends BaseClass {

	PreDataLocators preDataLocators;
	
	@Test
	public void Verify_error_message_when_special_characters_are_entered_in_email_fields_SOFT_682_F9() throws IOException, InterruptedException {
		
		PreDataAction preDataAction = new PreDataAction(getDriver());
		preDataAction.verifySpecialChar_FName_LName();
		
	}
}
