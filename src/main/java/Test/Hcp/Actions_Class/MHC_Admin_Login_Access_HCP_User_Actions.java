package Test.Hcp.Actions_Class;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Test.Hcp.Locators_Class.MHC_Admin_Login_Access_HCP_User_Locators;
import Test.Kit.Locators_Class.Login_Locators;
import Wrappers.ReadGmail;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;
import Test.Kit.Locators_Class.Login_Locators;

public class MHC_Admin_Login_Access_HCP_User_Actions extends BaseClass
{
	public WebDriver driver;
	Login_Locators loginLocators = null;
	ReadGmail readgmail = null;
	MHC_Admin_Login_Access_HCP_User_Locators mHC_admin_login_access_hCP_user_locators = null;
	String filePath = System.getProperty("user.dir") + "\\TestData\\phlebotomist_sample_data.csv";
	String getURL;
	
	
	public MHC_Admin_Login_Access_HCP_User_Actions(WebDriver driver) {
		this.driver = driver;
		mHC_admin_login_access_hCP_user_locators = new MHC_Admin_Login_Access_HCP_User_Locators(driver);
	}

	 
	 //Tims
	 public void Tims_Url() throws IOException {
			// Performing action on URL
		 String urlKey = determineUrlKey("Tims");
		 driver.get(urlKey);
			
		}
	 public void EnableLater()
	 {
		// mHC_admin_login_access_hCP_user_locators.Enable_Later().click();
		 
		 WebWait.elementToBeClickable(driver,  mHC_admin_login_access_hCP_user_locators.Enable_Later(), Duration.ofSeconds(30));
		WebButton.JsclickButton( mHC_admin_login_access_hCP_user_locators.Enable_Later(), driver);
		WebButton.clickButton( mHC_admin_login_access_hCP_user_locators.Enable_Later());
	 }
	 
	 //30 31
	 public String Load_Csv_And_Confirm_Email_Account_Button() throws Exception
	 {
		 Thread.sleep(5000);
		 WebButton.JsclickButton(mHC_admin_login_access_hCP_user_locators.hcpUserLink(), driver);
		 WebButton.JsclickButton(mHC_admin_login_access_hCP_user_locators.importPhlebotomistButton(), driver);
		 mHC_admin_login_access_hCP_user_locators.uploadCsvSection().sendKeys(filePath);
		 WebButton.JsclickButton( mHC_admin_login_access_hCP_user_locators.saveButton(), driver);
		 Thread.sleep(7000);
		 if(mHC_admin_login_access_hCP_user_locators.dataAdded().isDisplayed())
		 {
			 readgmail = new ReadGmail ();
			 getURL  = readgmail.getButtonURL("Phlebotomist") ;  
			 System.out.print(getURL);
		 }
		 return getURL;
		 
	 }
	

}
