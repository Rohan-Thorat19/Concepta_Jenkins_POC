package Test.Dashboard.Actions_Class;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.bouncycastle.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import Test.Dashboard.Locators_Class.Login_Boot_Locators;

//import com.aventstack.extentreports.Status;


import Test.Hcp.Locators_Class.Login_Health_Professional_Locators;


import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;

public class Login_Boot_Actions extends BaseClass {

	public WebDriver driver;
	Login_Boot_Locators login_boot_locators;

	public Login_Boot_Actions(WebDriver driver) {
		this.driver = driver;
		login_boot_locators = new Login_Boot_Locators(driver);
	}

	public void boot_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("dashboard_dev");
		driver.get(urlKey);

	}
	
	

	public void enterEmailID_boot(String EmailID) {
		// Performing action on Email ID Text Box
		WebTextBox.sendInputUpdate(login_boot_locators.getEmailaddress_boot(), EmailID);

	}

	public void enterPassword_boot(String Password) {
		// Performing action on Password Text Box
		WebTextBox.sendInputUpdate(login_boot_locators.getPassword_boot(), Password);
	}

	public void clickLoginButton_boot() {
		// click on login
		WebWait.elementToBeClickable(driver, login_boot_locators.getLoginBtn_boot(), Duration.ofSeconds(30));
		WebButton.clickButton(login_boot_locators.getLoginBtn_boot());

	}

	public void verifySuccessMsg_boot() throws InterruptedException, IOException {
		WebWait.visibilityOfElement(driver, login_boot_locators.getSuccessMsg_boot(), Duration.ofSeconds(30));
		System.out.println(login_boot_locators.getSuccessMsg_boot().getText());
		//Assertion.CheckAssert(driver, login_boot_locators.getSuccessMsg_boot().getText(),
				//PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Assertion_expected"));

	}

	public void checkEnableBtn() throws IOException, InterruptedException {

		WebWait.elementToBeClickable(driver, login_boot_locators.getEnableLater(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.getEnableLater(), driver);

	}
	
	public String welcomeTextMsg() {
		WebWait.visibilityOfElement(driver, login_boot_locators.getWelcomeMsg_boot(), Duration.ofSeconds(30));
		System.out.println(login_boot_locators.getWelcomeMsg_boot().getText());
		return login_boot_locators.getWelcomeMsg_boot().getText();
	}
	
	public String incorrectPasswordMsg() {
		WebWait.visibilityOfElement(driver, login_boot_locators.getMsgIncorrectPassword_boot(), Duration.ofSeconds(30));
		System.out.println(login_boot_locators.getMsgIncorrectPassword_boot().getText());
		return login_boot_locators.getMsgIncorrectPassword_boot().getText();
	}
	
	public String invalidEmailMsg() {
		WebWait.visibilityOfElement(driver, login_boot_locators.getErrorInvalidEmail_boot(), Duration.ofSeconds(30));
		System.out.println("Error: "+login_boot_locators.getErrorInvalidEmail_boot().getText());
		return login_boot_locators.getErrorInvalidEmail_boot().getText();
	}

	public void checkContinueBtn() throws IOException, InterruptedException {
		WebButton.clickButton(login_boot_locators.getboots_Appointment());
		//WebWait.elementToBeClickable(driver, login_boot_locators.getboots_Appointment(), Duration.ofSeconds(30));

		Thread.sleep(2000);
		//WebWait.elementToBeClickable(driver, login_boot_locators.getContinueBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(login_boot_locators.getContinueBtn());
		System.out.println(login_boot_locators.getContinueBtn().getText());
		
		Assert.assertEquals(driver, login_boot_locators.getContinueBtn().getText(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Assertion_continueBtn"));
		WebButton.JsclickButton(login_boot_locators.getContinueBtn(), driver);

	}

	public void clickDropdown() {
		WebWait.elementToBeClickable(driver, login_boot_locators.getdropDownType(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.getdropDownType(), driver);

	}

	public void clickconfirmCtnBtn() throws InterruptedException {
		WebWait.elementToBeClickable(driver, login_boot_locators.getconfirmCtnBtn(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.getconfirmCtnBtn(), driver);

		Thread.sleep(3000);
	}

	public void verifyTestTypeCnfmsg() throws InterruptedException, IOException {
		WebWait.visibilityOfElement(driver, login_boot_locators.gettestTypeCnfm(), Duration.ofSeconds(30));
		System.out.println(login_boot_locators.gettestTypeCnfm().getText());
		Assert.assertEquals(driver, login_boot_locators.gettestTypeCnfm().getText(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Assertion_testTypeConfirm"));

	}

	public void clickEmptyDropdown() {
		WebWait.elementToBeClickable(driver, login_boot_locators.getNoSelectdropDown(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.getNoSelectdropDown(), driver);

	}

	public void clickChkboxSubmit() {
		WebWait.elementToBeClickable(driver, login_boot_locators.getchkboxConsent(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.getchkboxConsent(), driver);
		WebWait.elementToBeClickable(driver, login_boot_locators.getchkboxAccept(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.getchkboxAccept(), driver);
		WebWait.elementToBeClickable(driver, login_boot_locators.getsubmitConsent(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.getsubmitConsent(), driver);
	}

	public void verifyConsentMsg() throws InterruptedException, IOException {
		WebWait.visibilityOfElement(driver, login_boot_locators.getconsentSaveSuccess(), Duration.ofSeconds(30));
		System.out.println(login_boot_locators.getconsentSaveSuccess().getText());
		Assert.assertEquals(driver, login_boot_locators.getconsentSaveSuccess().getText(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Assertion_Consent"));

	}

	public void login_boot() throws IOException, InterruptedException {
		boot_Url();
		enterEmailID_boot(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_boot"));
		enterPassword_boot(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_boot"));
		clickLoginButton_boot();
		checkEnableBtn();
		verifySuccessMsg_boot();
		checkContinueBtn();
		clickDropdown();
		clickconfirmCtnBtn();
		verifyTestTypeCnfmsg();
		clickChkboxSubmit();
		verifyConsentMsg();
	}

	public void negativeWithoutTetstype() throws IOException, InterruptedException {
		boot_Url();
		enterEmailID_boot(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_boot"));
		enterPassword_boot(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_boot"));
		clickLoginButton_boot();
		checkEnableBtn();
		checkContinueBtn();
		clickEmptyDropdown();
		clickconfirmCtnBtn();

	}

}
