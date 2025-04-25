package Test.Hcp.Actions_Class;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Test.Hcp.Locators_Class.Tims_TC_For_HCP_Smoke_Locators;
import Test.Tims.Actions_Class.Create_test_kit_For_PG_Actions;
import Test.Tims.Locators_Class.Login_Locators;
import Wrappers.ReadGmail;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;

public class Tims_TC_For_HCP_Smoke_Actions extends BaseClass {

	public WebDriver driver;
	Login_Locators loginLocators = null;
	Tims_TC_For_HCP_Smoke_Locators tims_TC_For_HCP_Smoke_Locators = null;
	Create_test_kit_For_PG_Actions create_test_kit_For_PG_Actions = null;
	WebScrollView webScrollView = null;

	public Tims_TC_For_HCP_Smoke_Actions(WebDriver driver) {
		this.driver = driver;
		loginLocators = new Login_Locators(driver);
		tims_TC_For_HCP_Smoke_Locators = new Tims_TC_For_HCP_Smoke_Locators(driver);
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
	public void login_Tims() throws IOException, InterruptedException {
		Tims_Url();
		enterEmailID(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims"));
		enterPassword(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims"));
		clickLoginButton();
		create_test_kit_For_PG_Actions = new Create_test_kit_For_PG_Actions(getDriver());
		create_test_kit_For_PG_Actions.clickOn_Enable_Later();

	}
	
	//67 &69s
	public void functionalityOfBarcodeWithPGPL() throws InterruptedException
	{
		String filePath = System.getProperty("user.dir") +"/TestData/hcp_smoke_thyriod_blood.csv";
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.gettestKitMenu());
		Thread.sleep(2000);
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.getmarkKitReceivedBtn());
		Thread.sleep(2000);
		WebTextBox.sendInputUpdate(tims_TC_For_HCP_Smoke_Locators.getbarcodeTxt(), "PGN-DUZ-9447");
		Thread.sleep(2000);
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.getnextBtn());
		Thread.sleep(2000);
		webScrollView = new WebScrollView();
		webScrollView.scrollDownVertically(getDriver());
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.getmarkAsReceivedBtn());
		Thread.sleep(2000);
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.getuploadCsvBtn());
		Thread.sleep(2000);
		WebTextBox.sendInputUpdate(tims_TC_For_HCP_Smoke_Locators.getbrowseCsv(), filePath);
		Thread.sleep(2000);
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.getuploadCsvAfterAddingFileBtn());
		Thread.sleep(2000);
				
	}
	//68
		public void functionalityOfMarkAsReceivedConfirmEmail() throws InterruptedException
	{
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.gettestKitMenu());
		Thread.sleep(2000);
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.getmarkKitReceivedBtn());
		Thread.sleep(2000);
		WebTextBox.sendInputUpdate(tims_TC_For_HCP_Smoke_Locators.getbarcodeTxt(), "PGS-LUH-0658");
		Thread.sleep(2000);
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.getnextBtn());
		Thread.sleep(2000);
		webScrollView = new WebScrollView();
		webScrollView.scrollDownVertically(getDriver());
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.getmarkAsReceivedBtn());
		Thread.sleep(3000);
	}
		public void ReadGmail (String GetData) throws Exception
		{
			            ReadGmail readGmail = new ReadGmail();
			            readGmail.getButtonURL(GetData);			           
		}
	
	public void functionalityOfBarcodeError() throws InterruptedException
	{
		String ActualStatus = "error";
		WebButton.clickButton(tims_TC_For_HCP_Smoke_Locators.gettestKitMenu());
		Thread.sleep(2000);
		WebTextBox.sendInputUpdate(tims_TC_For_HCP_Smoke_Locators.getprimaryBarcodeSearch(),"PGY-TKK-1426");
		Thread.sleep(5000);
		String BarcodeStatus = tims_TC_For_HCP_Smoke_Locators.getbarcodeErrorStatus().getText();
		System.out.print(BarcodeStatus);
		Assert.assertEquals(BarcodeStatus, ActualStatus);
		
	}	
	

}
