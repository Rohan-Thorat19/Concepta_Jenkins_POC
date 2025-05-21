package Test.Tims.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Test.Dashboard.Actions_Class.PhleBotomist_Booking_Page_Action;
import Test.Hcp.Actions_Class.Patients_Details_Actions;
import Test.Tims.Locators_Class.Create_test_kit_For_PL_Locators;
import Test.Tims.Locators_Class.Phlebotomist_csv_import_Locators;
import Wrappers.CSVUploaderWithTextReplacement;
import Wrappers.ReadGmail;
import Wrappers.Table_Traverse;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.ExtentManager;

public class Phlebotomist_csv_import_Actions {
	public WebDriver driver;
	Create_test_kit_For_PG_Actions create_test_kit_For_PG_actions;
	Phlebotomist_csv_import_Locators phlebotomist_csv_import_locators;
	PhleBotomist_Booking_Page_Action phleBotomist_booking_page_action;
	Patients_Details_Actions patients_details_actions;
	Login_Action Login_action;
	String primary_barcode;
	String status;
	ReadGmail readgmail;

	public Phlebotomist_csv_import_Actions(WebDriver driver) {
		this.driver = driver;

		phlebotomist_csv_import_locators = new Phlebotomist_csv_import_Locators(driver);
		phleBotomist_booking_page_action = new PhleBotomist_Booking_Page_Action(driver);
		patients_details_actions = new Patients_Details_Actions(driver);
		create_test_kit_For_PG_actions = new Create_test_kit_For_PG_Actions(driver);

	}

	public void import_phlebotomist_User_Csv() throws InterruptedException, IOException {
		create_test_kit_For_PG_actions.clickOn_Enable_Later();

		WebButton.clickButton(phlebotomist_csv_import_locators.gethcp_User_Menu());
		// WebButton.clickButton(phlebotomist_csv_import_locators.getdownload_CSV());
		WebButton.clickButton(phlebotomist_csv_import_locators.getimport_CSV());

		String filePath = System.getProperty("user.dir") + "/TestData/phlebotomist_sample_data.csv";
		phlebotomist_csv_import_locators.getchooes_CSV().sendKeys(filePath);
		Thread.sleep(2000);
		WebButton.clickButton(phlebotomist_csv_import_locators.save_file());
		try {
			WebWait.visibilityOfElement(driver, phlebotomist_csv_import_locators.get_cvs_Upload_Success_Msg(),
					Duration.ofSeconds(30));
			Thread.sleep(3000);
			String alert_expected = phlebotomist_csv_import_locators.get_cvs_Upload_Success_Msg().getText().trim();
			System.out.println("File Importing Success Message= " + alert_expected);
			String ActualValue = "CSV uploaded. Success: 1, Failures: 0";
			assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Uploaded Successfully");

		} catch (Exception e) {
			String alert_not_expected = phlebotomist_csv_import_locators.cvs_Upload_Fail_Msg().getText().trim();
			System.out.println("File Importing Failed Message= " + alert_not_expected);
			ExtentManager.getTest().log(Status.FAIL, "User is Already Present");
		}
//		finally{
//			
//		}

	}

	public void email_Triggered_To_User() throws Exception {
		ReadGmail readGmail = new ReadGmail();
		readGmail.getButtonURL("Welcome to MyHealthChecked!");

	}

	public void partial_Result_Email_Received() throws Exception {
		ReadGmail readGmail = new ReadGmail();
		readGmail.getButtonURL("ExtractID");

	}

	public void email_content_Create_Account_Link() throws Exception {
		ReadGmail readGmail = new ReadGmail();
		readGmail.getButtonURL("Click on the button below to create your account");

	}

	public void upload_Blood_Result_CSV(String targetText, String replacement) throws IOException {
		WebButton.JsclickButton(phlebotomist_csv_import_locators.getTestkit(), driver);
		WebButton.JsclickButton(phlebotomist_csv_import_locators.get_upload_Blood_Result_CSV(), driver);
		String filePath = System.getProperty("user.dir") + "/TestData/Partial Result.csv";
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, filePath,
				phlebotomist_csv_import_locators.getupload_File_Button(), targetText, replacement);
		WebButton.JsclickButton(phlebotomist_csv_import_locators.get_file_upload_Btn(), driver);
	}

	public void mark_Kit_Received(String barcode) throws InterruptedException {
		WebButton.JsclickButton(phlebotomist_csv_import_locators.getTestkit(), driver);
		WebButton.JsclickButton(phlebotomist_csv_import_locators.get_Mark_Kit_Received_btn(), driver);
		Thread.sleep(2000);
		WebTextBox.sendInput(phlebotomist_csv_import_locators.get_Mark_Kit_Barcode_Field(), barcode);
		WebButton.JsclickButton(phlebotomist_csv_import_locators.get_next_Buttond(), driver);
		Thread.sleep(2000);
		WebButton.JsclickButton(phlebotomist_csv_import_locators.get_mark_Received_Button(), driver);

	}

	public void upload_Partial_Result() throws Exception {
		Login_action = new Login_Action(driver);
		readgmail = new ReadGmail();
		//String booking_Id = phleBotomist_booking_page_action.Verify_Complete_Health_Assessment_Form_6();
		Login_action.login_Tims_Staging();
		primary_barcode = create_test_kit_For_PG_actions.Test_Kit_Creation_PG();
		Login_action.login_staging_HCP();
		String BookingID = readgmail.getButtonURL("ExtractID");
		patients_details_actions.Valid_Patients_Details_Case12(BookingID, "Sagar", "D");
		patients_details_actions.register_Patient(primary_barcode);
		Login_action.login_Tims_Staging();
		System.out.println("Primary code is " + primary_barcode);
		mark_Kit_Received(primary_barcode);
		upload_Blood_Result_CSV("PGK-WJF-8747", primary_barcode);
		System.out.println("Barcode replaced successfully");
		Thread.sleep(2000);
		driver.navigate()
				.to("https://hcp-portal-staging.myhealthchecked.com/login");
		String new_Booking_Id = phleBotomist_booking_page_action.get_Booking_ID();
		System.out.println("New Booking ID is = " + new_Booking_Id);

	}
	
	public String test_Kit_Satus() throws IOException, InterruptedException {
		Login_action = new Login_Action(driver);
		Login_action.login_Tims_Staging();
		create_test_kit_For_PG_actions.clickOn_Enable_Later();
		WebButton.JsclickButton(phlebotomist_csv_import_locators.getTestkit(), driver);
		int j = Table_Traverse.getColoumnName(phlebotomist_csv_import_locators.get_Table_Headers(), "Primary barcode");
		System.out.println("Barcode to check the status = "+primary_barcode);
		Thread.sleep(2000);
		List<WebElement> table_Value = driver.findElements(By.xpath("//tbody/tr/td[" + j + "]"));
		for (int i = 0; i < table_Value.size(); i++) {
			if (table_Value.get(i).getText().trim().equalsIgnoreCase(primary_barcode)) {
				System.out.println("Selected barcode is :" + table_Value.get(i).getText());
				status = driver
						.findElement(By.xpath("(//tr[td/a[contains(@href, '/admin/test-kits/')]]/td[5])["+(i+1)+"]")).getText();	
			}
		}
		return status;
	}

}
