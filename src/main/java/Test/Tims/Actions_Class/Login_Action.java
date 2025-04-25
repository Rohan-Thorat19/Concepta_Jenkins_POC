package Test.Tims.Actions_Class;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Test.Tims.Locators_Class.Login_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;

public class Login_Action extends BaseClass {

	public WebDriver driver;
	Login_Locators loginLocators = null;

	public Login_Action(WebDriver driver) {
		this.driver = driver;
		loginLocators = new Login_Locators(driver);
	}

	// Tims
	public void Tims_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("Tims");
		driver.get(urlKey);

	}

	public void enterEmailID(String EmailID) {
		// Performing action on Email ID Text Box
		WebTextBox.sendInputUpdate(loginLocators.getemailAddress(), EmailID);

	}

	public void enterPassword(String Password) {
		// Performing action on Password Text Box
		WebTextBox.sendInputUpdate(loginLocators.getpassword(), Password);
	}

	public void clickLoginButton() {
		// click on login
		WebWait.elementToBeClickable(driver, loginLocators.getLoginBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(loginLocators.getLoginBtn());
		// WebWait.waitForDOMLoad(driver, null);
	}

	// HCP
	public void HCP_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("HCP");
		driver.get(urlKey);

	}

	public void enterEmailID_hcp(String EmailID) {
		// Performing action on Email ID Text Box
		WebTextBox.sendInputUpdate(loginLocators.getemailAddress_hcp(), EmailID);

	}

	public void enterPassword_hcp(String Password) {
		// Performing action on Password Text Box
		WebTextBox.sendInputUpdate(loginLocators.getpassword_hcp(), Password);
	}

	public void clickLoginButton_hcp() {
		// click on login
		WebWait.elementToBeClickable(driver, loginLocators.getLoginBtn_hcp(), Duration.ofSeconds(30));
		WebButton.clickButton(loginLocators.getLoginBtn_hcp());
		// WebWait.waitForDOMLoad(driver, null);
	}

	public void login_Tims() throws IOException {
		Tims_Url();
		enterEmailID(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims"));
		enterPassword(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims"));
		clickLoginButton();

	}

	public void login_HCP() throws IOException {
		HCP_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_hcp"));
		clickLoginButton_hcp();

	}

	public void Dashboard_Url() throws IOException {
		String urlKey = determineUrlKey("dashboard");
		driver.get(urlKey);
	}

	public void login_Dashboard() throws IOException {
		Dashboard_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_dashboard"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_dashboard"));
		clickLoginButton_Dashboard();
	}

	public void login_Tims_For_HCP() throws IOException, InterruptedException {
		Tims_Url();
		enterEmailID(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims_for_hcp"));
		enterPassword(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims_for_hcp"));
		clickLoginButton();
		// clickOn_Enable_Later();

	}

	public void clickLoginButton_Dashboard() {
		// click on login
		WebWait.elementToBeClickable(driver, loginLocators.getLoginBtn_hcp(), Duration.ofSeconds(30));
		WebButton.clickButton(loginLocators.getLoginBtn_hcp());
		// WebWait.waitForDOMLoad(driver, null);

	}
}
