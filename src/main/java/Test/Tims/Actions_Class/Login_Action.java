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

	// Dashboard

	public void Dashboard_dev_Url() throws IOException {
		String urlKey = determineUrlKey("dashboard_dev");
		driver.get(urlKey);
	}

	public void Dashboard_staging_Url() throws IOException {
		String urlKey = determineUrlKey("dashboard_staging");
		driver.get(urlKey);
	}

	public void clickLoginButton_Dashboard() {
		// click on login
		WebWait.elementToBeClickable(driver, loginLocators.getLoginBtn_hcp(), Duration.ofSeconds(30));
		WebButton.clickButton(loginLocators.getLoginBtn_hcp());
		// WebWait.waitForDOMLoad(driver, null);

	}

	public void login_dev_Dashboard() throws IOException {
		Dashboard_dev_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_dev_dashboard"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_dev_dashboard"));
		clickLoginButton_Dashboard();
	}

	public void login_staging_Dashboard() throws IOException {
		Dashboard_staging_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_staging_dashboard"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_staging_dashboard"));
		clickLoginButton_Dashboard();
	}

	// Tims
	public void Tims_staging_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("Tims_staging");
		driver.get(urlKey);

	}

	public void Tims_dev_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("Tims_dev");
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

	public void login_Tims_dev() throws IOException {
		Tims_dev_Url();
		enterEmailID(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims_dev"));
		enterPassword(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims_dev"));
		clickLoginButton();

	}

	public void login_Tims_Staging() throws IOException {
		Tims_staging_Url();
		enterEmailID(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims_staging"));
		enterPassword(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims_staging"));
		clickLoginButton();

	}

	// HCP
	public void HCP_dev_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("HCP_dev");
		driver.get(urlKey);

	}

	public void HCP_staging_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("HCP_staging");
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

	public void login_dev_HCP() throws IOException {
		HCP_dev_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp_dev"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_hcp_dev"));
		clickLoginButton_hcp();

	}

	public void login_staging_HCP() throws IOException {
		HCP_staging_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp_staging"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_hcp_staging"));
		clickLoginButton_hcp();

	}

}
