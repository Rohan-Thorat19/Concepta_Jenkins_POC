package Smoke.Tims.Test_Cases;

import javax.mail.Message;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Email_functionality;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class T24_Verify_email_includes_valid_Booking_Ref_ID extends BaseClass {

	public Login_Action login;
	Email_functionality email_functionality;
	WebDriver driver;

	@Test
	public void verify_Ref_ID_SOFT_1044_TC_003() throws Exception {
		login = new Login_Action(getDriver());
		email_functionality = new Email_functionality(getDriver());
		email_functionality.getRegNoFromEmail();

	}

}
