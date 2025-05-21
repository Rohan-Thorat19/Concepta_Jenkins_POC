package Test.Tims.Actions_Class;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Test.Tims.Locators_Class.Create_test_kit_For_PG_Locators;
import Test.Tims.Locators_Class.Email_fields_Locators;
import Wrappers.GetCurrentEmailString;
import Wrappers.ReadGmail;
import Wrappers.WebButton;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class Email_functionality extends GetCurrentEmailString {
	public WebDriver driver;

	Email_fields_Locators email_fields_locators;
	Login_Action login_action;
	ReadGmail readgmail;
	String getURL;

	public Email_functionality(WebDriver driver) {
		this.driver = driver;
		email_fields_locators = new Email_fields_Locators(driver);
		login_action = new Login_Action(driver);
	}

	public void getRegNoFromEmail() throws Exception {
		readgmail = new ReadGmail();
		getURL = readgmail.getButtonURL("ExtractID");

	}

	public void redirectTOEditProfile() throws Exception {

		readgmail = new ReadGmail();
		login_action.login_Dashboard();
		getURL = readgmail.getButtonURL("URL_Redirect_Profile");

		driver.get(getURL);

		WebWait.elementToBeClickable(driver, email_fields_locators.getbtnEnableLater(), Duration.ofSeconds(30));
		WebButton.JsclickButton(email_fields_locators.getbtnEnableLater(), driver);

		String title_expected = email_fields_locators.gettextAssessmentDetails().getText().trim();
		System.out.println("Title = " + title_expected);
		String ActualValue = "Assessment details";
		assertEquals(ActualValue, title_expected);
		ExtentManager.getTest().log(Status.PASS, "Page is not redirected");

	}

}
