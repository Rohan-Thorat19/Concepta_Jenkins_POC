package Test.Tims.Actions_Class;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Test.Tims.Locators_Class.Email_fields_Locators;
import Test.Tims.Locators_Class.Tims_Customer_Events_Locators;
import Wrappers.WebButton;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class Tims_Customer_Events {
	public WebDriver driver;
	Tims_Customer_Events_Locators tims_customer_events_locators;

	Login_Action login_action;

	public Tims_Customer_Events(WebDriver driver) {
		this.driver = driver;
		login_action = new Login_Action(driver);
		tims_customer_events_locators = new Tims_Customer_Events_Locators(driver);

	}

	public void Check_customer_event_emails() throws IOException {
		login_action.login_Tims_dev();
		WebWait.elementToBeClickable(driver, tims_customer_events_locators.gettxtUserOption(),
				Duration.ofSeconds(20000));
		WebButton.JsclickButton(tims_customer_events_locators.gettxtUserOption(), driver);
		WebWait.elementToBeClickable(driver, tims_customer_events_locators.gettxtUserName(), Duration.ofSeconds(20000));
		WebButton.JsclickButton(tims_customer_events_locators.gettxtUserName(), driver);
		WebWait.elementToBeClickable(driver, tims_customer_events_locators.gettxtEmailTab(), Duration.ofSeconds(20000));
		WebButton.JsclickButton(tims_customer_events_locators.gettxtEmailTab(), driver);
		WebWait.elementToBeClickable(driver, tims_customer_events_locators.gettxtTriggerEmail(),
				Duration.ofSeconds(20000));
		String Expected_String = "phlebotomist-appointment-registration";
		String Actual_String = tims_customer_events_locators.gettxtTriggerEmail().getText().trim();
		System.out.println("Expected Trigger value : " + Expected_String);
		assertEquals(Actual_String, Expected_String);
		ExtentManager.getTest().log(Status.PASS, "No matching value found.");

	}
}
