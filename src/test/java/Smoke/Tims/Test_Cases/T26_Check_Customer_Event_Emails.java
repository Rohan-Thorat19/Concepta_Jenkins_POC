package Smoke.Tims.Test_Cases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Email_functionality;
import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Actions_Class.Tims_Customer_Events;
import initializer.BaseClass;

public class T26_Check_Customer_Event_Emails extends BaseClass {

	public Login_Action login;
	Tims_Customer_Events tims_customer_events;
	WebDriver driver;

	@Test
	public void verify_Ref_ID_SOFT_1045_TC_004() throws Exception {
		login = new Login_Action(getDriver());
		tims_customer_events = new Tims_Customer_Events(getDriver());
		tims_customer_events.Check_customer_event_emails();
	}
}
