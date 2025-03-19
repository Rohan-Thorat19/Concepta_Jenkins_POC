package Test.Kit.Actions_Class;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Test.Hcp.Locators_Class.Login_Health_Professional_Locators;
import Test.Kit.Locators_Class.Create_test_kit_Locators;
import Test.Kit.Locators_Class.Login_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;


public class Login_Action extends BaseClass {

	public WebDriver driver;
	Login_Locators loginLocators = null;
	Login_Health_Professional_Locators login_health_professional_locators = null;
	Create_test_kit_Locators create_test_kit_Locators;
	public Login_Action(WebDriver driver) {
		this.driver = driver;
		loginLocators = new Login_Locators(driver);
	}

	 
	 //Tims
	 public void Tims_Url() throws IOException {
			// Performing action on URL
		 String urlKey = determineUrlKey("Tims");
		 driver.get(urlKey);
			
		}
	 
	 //31
	 public void Account_Creation_Url_Check(String URL)
	 {
		 driver.get(URL);		 
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
		//WebWait.waitForDOMLoad(driver, null);
	}
	
	//HCP
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
		//WebWait.waitForDOMLoad(driver, null);
	}
	
	
	
	
	public void login_Tims() throws IOException {
		Tims_Url();
		enterEmailID(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims"));
		enterPassword(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims"));
		clickLoginButton();
		
	}
	
	public void login_Tims_For_HCP() throws IOException, InterruptedException {
		Tims_Url();
		enterEmailID(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims_for_hcp"));
		enterPassword(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims_for_hcp"));
		clickLoginButton();
		//clickOn_Enable_Later();
		
	}
	
	public void HitAccountGmailURL(String URL)
	{
		Account_Creation_Url_Check(URL);
	}
	
	public void login_HCP() throws IOException, InterruptedException {
		HCP_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_hcp"));
		clickLoginButton_hcp();
		Thread.sleep(5000);
				
	}
	public void login_HCP_With_Valid_Data() throws IOException, InterruptedException {
		HCP_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_hcp"));
		clickLoginButton_hcp();
		String loggedInUrl = driver.getTitle();
		String expectedUrl = "https://hcp-portal-staging.myhealthchecked.com/patient-record";
		Thread.sleep(3000);
		if (loggedInUrl ==expectedUrl)
		{
			System.out.print("Logged in successsfully");
		}
			
				
	}
	
		
	//32
	public void login_HCP_With_Invalid_Data() throws IOException, InterruptedException {
		HCP_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Invalid_Password_hcp"));
		clickLoginButton_hcp();
		login_health_professional_locators  = new Login_Health_Professional_Locators(driver);
		Thread.sleep(3000);
		if(login_health_professional_locators.invalid_Error_msg().isDisplayed())
		{
			System.out.print("Error msg is displayed");
		}
		
	}
	
	public void clickOn_Enable_Later() throws InterruptedException 
	{

		WebWait.elementToBeClickable(driver, create_test_kit_Locators.Enable_Later(), Duration.ofSeconds(30));
		WebButton.JsclickButton(create_test_kit_Locators.Enable_Later(), driver);
		WebButton.clickButton(create_test_kit_Locators.Enable_Later());
	}
	
public void Dashboard_Url() throws IOException
 {
	String urlKey = determineUrlKey("dashboard_url");
	 driver.get(urlKey);
 }

public void Dashboard_Url_for_HcpSmoke() throws IOException
 {
	String urlKey = determineUrlKey("dashboard_url_dev");
	 driver.get(urlKey);
 }

	public void login_Dashboard() throws IOException
	{
		Dashboard_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_dashboard"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_dashboard"));
		clickLoginButton_Dashboard();
		
	}

	public void login_Dashboardfor_HcpSmoke()throws IOException
	{
		Dashboard_Url_for_HcpSmoke();				
	}

	public void clickLoginButton_Dashboard() {
		// click on login 
		WebWait.elementToBeClickable(driver, loginLocators.getLoginBtn_hcp(), Duration.ofSeconds(30));
		WebButton.clickButton(loginLocators.getLoginBtn_hcp());
		//WebWait.waitForDOMLoad(driver, null);
		
	}
}
