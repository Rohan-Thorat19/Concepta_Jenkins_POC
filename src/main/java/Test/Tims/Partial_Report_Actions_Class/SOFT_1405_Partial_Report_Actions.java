package Test.Tims.Partial_Report_Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Test.Tims.Actions_Class.Login_Action;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Dashboard.Locators_Class.Customer_Landing_Locators;
import Test.Dashboard.Locators_Class.Health_Assessment_Locators;
import Test.Tims.Locators_Class.SH_Locators;
import Test.Tims.Partial_Report_Locators_Class.SOFT_1405_Partial_Report_Locators;
import Wrappers.CSVUploaderWithTextReplacement;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;



public class SOFT_1405_Partial_Report_Actions {

	public WebDriver driver;
	public static String Barcode1;
	public static String Barcode2;
	
	SOFT_1405_Partial_Report_Locators soft_1405_Partial_Report_Locators;
	Customer_Landing_Locators customer_landing_locators;
	Customer_Landing_Actions customer_landing_actions;
	Health_Assessment_Locators health_assessment_locators;
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Login_Action login_action;
	Health_Assessment_Actions health_assessment_actions;
	Activate_Test_Kit_Actions activate_test_kit_actions;
	SH_Locators sh_locators;
	
	public SOFT_1405_Partial_Report_Actions(WebDriver driver) {
		this.driver = driver;
		soft_1405_Partial_Report_Locators = new SOFT_1405_Partial_Report_Locators(driver);
		customer_landing_locators = new Customer_Landing_Locators(driver);
		customer_landing_actions = new Customer_Landing_Actions(driver);
		health_assessment_locators = new Health_Assessment_Locators(driver);
		activate_test_kit_locators = new Activate_Test_Kit_Locators(driver);
		login_action = new Login_Action(driver);
		health_assessment_actions = new Health_Assessment_Actions(driver);
		activate_test_kit_actions = new Activate_Test_Kit_Actions(driver);
		sh_locators = new SH_Locators(driver);
	}
	
	public void generateSingleBarcode(String testType) throws InterruptedException, IOException {
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createBloodBatchBtn());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_customerDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_customerDrp(), "Boots");
		WebDropDown.selectByText(activate_test_kit_locators.get_typeDrp(), "blood");
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), "Gold");
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), "2");
		WebButton.clickButton(activate_test_kit_locators.get_saveBtn());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_barcodesHeaderMenuItem(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_barcodesValue(), Duration.ofSeconds(20));
		Barcode1 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.println("Generated Barcode: " + Barcode1);
		ExtentManager.getTest().log(Status.INFO, "Generated Barcode: " + Barcode1);
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createKitBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Barcode1);
		WebButton.JsclickButton(activate_test_kit_locators.get_createBtn(), driver);
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_assignKitTypeHeaderMenu());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_typeOfTestKitDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_typeOfTestKitDrp(), testType);
		Thread.sleep(2000);
		WebElement selectedOption = WebDropDown.getSelectedOption(driver,activate_test_kit_locators.get_typeOfTestKitDrp());
		System.out.println("Kit Type: "+selectedOption.getText());
		ExtentManager.getTest().log(Status.INFO, "Kit Type: "+selectedOption.getText());
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Barcode1);
		Thread.sleep(3000);
		WebButton.JsclickButton(activate_test_kit_locators.get_AssignBtn(), driver);
	}
	
	public void generateBarcodeBatch(String barcodeVariableName, String customer, String subType, String count) {
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_createBloodBatchBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_createBloodBatchBtn());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_customerDrp(), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_customerDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_customerDrp(), customer);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_typeDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_typeDrp(), "blood");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_subTypeDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), subType);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeCountTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), count);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_saveBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_saveBtn());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_barcodesHeaderMenuItem(), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodesHeaderMenuItem(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_barcodesValue(), Duration.ofSeconds(20));
		String barcode = activate_test_kit_locators.get_barcodesValue().getText();
	    System.out.println("Generated Barcode (" + subType + "): " + barcode);
	    ExtentManager.getTest().log(Status.INFO, "Generated Barcode (" + subType + "): " + barcode);

	    if ("Barcode1".equals(barcodeVariableName)) {
	        Barcode1 = barcode;
	    } else if ("Barcode2".equals(barcodeVariableName)) {
	        Barcode2 = barcode;
	    }
		
	}
	
	public void generateDoubleBarcode(String testType, String subType1, String subType2) throws InterruptedException, IOException {
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		
		generateBarcodeBatch("Barcode1", "Boots", subType1, "2");
		generateBarcodeBatch("Barcode2", "Boots", subType2, "2");

		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(10));
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_createKitBtn(), Duration.ofSeconds(10));
		WebButton.clickButton(activate_test_kit_locators.get_createKitBtn());

		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Duration.ofSeconds(10));
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Barcode1);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_secondaryBarcodeTxtForCreateKit(), Duration.ofSeconds(10));
		WebTextBox.sendInput(activate_test_kit_locators.get_secondaryBarcodeTxtForCreateKit(), Barcode2);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_createBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_createBtn(), driver);
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_assignKitTypeHeaderMenu(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_assignKitTypeHeaderMenu(), driver);
		WebWait.waitForDOMLoad(driver, Duration.ofSeconds(20));
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_typeOfTestKitDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_typeOfTestKitDrp(), testType);
		Thread.sleep(2000);
		WebElement selectedOption = WebDropDown.getSelectedOption(driver,activate_test_kit_locators.get_typeOfTestKitDrp());
		System.out.println("Kit Type: "+selectedOption.getText());
		ExtentManager.getTest().log(Status.INFO, "Kit Type: "+selectedOption.getText());
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Barcode1);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_AssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_AssignBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
	}
	
	public void activateTestKitDoubleBarcode(String gender) throws InterruptedException, IOException {
		Thread.sleep(3000);
		login_action.login_dashboard_staging();
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");

		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_checkSecondBarcodePageTitle(), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_submitBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
		health_assessment_actions.selectSexAtBirth(gender);
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		health_assessment_actions.selectIfStillIdentifiesWithGender("Yes");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), health_assessment_actions.getSystemCurrentDate());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
	}
	
	public void activateTestKitSingleBarcode() throws InterruptedException, IOException {
		Thread.sleep(3000);
		login_action.login_dashboard_staging();
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");

		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_submitBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
		health_assessment_actions.selectSexAtBirth("Female");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		health_assessment_actions.selectIfStillIdentifiesWithGender("Yes");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), health_assessment_actions.getSystemCurrentDate());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
	}
	
	public void markKit(String barcode) {
		
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_inputBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(), barcode);
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markAsReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_testMarkedAsReceivedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
	}
	
	public void markKitAsReceived(String singleOrDoubleBarcode) throws IOException, InterruptedException {
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		
		switch (singleOrDoubleBarcode.toLowerCase()) {
        case "single":
            markKit(Barcode1);
            break;

        case "double":
            markKit(Barcode1);
            Thread.sleep(3000); 
            WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
            markKit(Barcode2);
            break;

        default:
            throw new IllegalArgumentException("Invalid barcode type: " + singleOrDoubleBarcode);
		}
				
	}
	
	public void uploadBloodResultsCsv(String fileName, WebElement element, String targetText, String replacementText) throws IOException, InterruptedException {
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadBloodResultCsvBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_uploadBloodResultCsvBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_uploadBloodResultCsvInput(), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadBloodResultCsvInput(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, System.getProperty("user.dir") +"\\TestData\\Partial_Report_CSV\\" +fileName , element, targetText, replacementText);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_csvResultsfileUploadWindowUploadBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_csvResultsfileUploadWindowUploadBtn(), driver);
		
	}
	

	public void uploadBloodResultCsvMultipleReplacements(WebDriver driver, String filePath, WebElement element, Map<String,String> replacements) throws IOException {
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadBloodResultCsvBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_uploadBloodResultCsvBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_uploadBloodResultCsvInput(), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadBloodResultCsvInput(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSVMultipleValues(driver, filePath, element, replacements);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_csvResultsfileUploadWindowUploadBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_csvResultsfileUploadWindowUploadBtn(), driver);
		
	}
	
	public void fullBloodResultPublishedReport() throws InterruptedException, IOException {
		generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Male");
		markKitAsReceived("Double");
		uploadBloodResultsCsv("Energy_Profile_Test_Gold.csv", health_assessment_locators.get_uploadBloodResultCsvInput(),
				"MGC-YUA-9578", Barcode1);
		uploadBloodResultsCsv("Energy_Profile_Test_Lavender.csv", health_assessment_locators.get_uploadBloodResultCsvInput(),
				"MLQ-USY-4392", Barcode2);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		WebWait.elementToBeClickable(driver, sh_locators.get_testReportSideMenu(), Duration.ofSeconds(20));
	    WebButton.clickButton(sh_locators.get_testReportSideMenu());
	    WebWait.elementToBeClickable(driver, sh_locators.get_ReadyForReviewBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_ReadyForReviewBtn());	
		
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), Barcode1);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testKitId(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testKitId(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_headerMenuAssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_headerMenuAssignBtn(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_popUpAssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_popUpAssignBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_doctorAssignedAlert(), Duration.ofSeconds(30));
		System.out.println("Alert: "+customer_landing_locators.get_doctorAssignedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_doctorAssignedAlert().getText());
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerMenuPublishBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerMenuPublishBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_publishYesBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_publishYesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_reportPublishedToasterMsg(), Duration.ofSeconds(10));
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_reportPublishedToasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_reportPublishedToasterMsg().getText());
	}
	
	public void assignDoctor() {
		WebWait.elementToBeClickable(driver, sh_locators.get_testReportSideMenu(), Duration.ofSeconds(20));
	    WebButton.clickButton(sh_locators.get_testReportSideMenu());
	    WebWait.elementToBeClickable(driver, sh_locators.get_ReadyForReviewBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_ReadyForReviewBtn());	
		
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), Barcode1);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testKitId(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testKitId(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_headerMenuAssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_headerMenuAssignBtn(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_popUpAssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_popUpAssignBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_doctorAssignedAlert(), Duration.ofSeconds(40));
		System.out.println("Alert: "+customer_landing_locators.get_doctorAssignedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_doctorAssignedAlert().getText());
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
	}
	
	public void testResultInfoPagevalidation(){
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerMenuPublishBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerMenuPublishBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_publishYesBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_publishYesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_reportPublishedToasterMsg(), Duration.ofSeconds(40));
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_reportPublishedToasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_reportPublishedToasterMsg().getText());
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPartialReportRow(), Duration.ofSeconds(10));
		WebElement partialReportValue = soft_1405_Partial_Report_Locators.get_timsPartialReportRow().findElement(By.xpath("./td"));
		WebWait.visibilityOfElement(driver, partialReportValue, Duration.ofSeconds(10));
		System.out.println(soft_1405_Partial_Report_Locators.get_timsPartialReportRow().getText());
		assertEquals(partialReportValue.getText(), "Yes, first partial report");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsPartialReportRow().getText());
	}
	
	public void dashboardViewReport() throws InterruptedException {
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(60));
		WebWait.visibilityOfElement(driver, customer_landing_actions.getViewResultsBtn(Barcode1), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, customer_landing_actions.getViewResultsBtn(Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, customer_landing_actions.getViewResultsBtn(Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(customer_landing_actions.getViewResultsBtn(Barcode1), driver);
		
	}
	
	public void partialReportTC2() throws InterruptedException, IOException {
		generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Male");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", Barcode1);
		goldReplacements.put("19.9", "Untestable – Insufficient (post-analytical)");
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
	
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Insufficient");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value: "+actualValue);
		System.out.println("Primary Barcode Results Error: "+actualError);
		assertEquals(actualValue, "Untestable – Insufficient (post-analytical)", "Folate value mismatch");
		assertEquals(actualError, "untestable-insufficient-post-analytical", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value: "+actualValue +"<br>"+"Primary Barcode Results Error: "+actualError);
	
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message: "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message: "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error: "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error: "+actualErrorMsg);
	}
	
	public void partialReportTC3() throws InterruptedException, IOException {
		generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Male");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", Barcode1);
		goldReplacements.put("19.9", "Untestable – Clotted (post-analytical)");
		goldReplacements.put("44", "Untestable – Clotted (post-analytical)");
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsALTBiomarker(), Duration.ofSeconds(10));
		String altValue = soft_1405_Partial_Report_Locators.get_timsALTBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsALTBiomarker().getText() +" : "+altValue);
		assertEquals(altValue, "Clotted");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsALTBiomarker().getText() +" : "+altValue);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Clotted");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALTBiomarker(), Duration.ofSeconds(10));
		WebElement altMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALTBiomarker();
		String actualALTValue = altMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualALTError = altMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (ALT): "+actualALTValue);
		System.out.println("Primary Barcode Results Error (ALT): "+actualALTError);
		assertEquals(actualALTValue, "Untestable – Clotted (post-analytical)", "Biomarker value mismatch");
		assertEquals(actualALTError, "untestable-clotted-post-analytical", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (ALT): "+actualALTValue +"<br>"+"Primary Barcode Results Error (ALT): "+actualALTError);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Untestable – Clotted (post-analytical)", "Biomarker value mismatch");
		assertEquals(actualFOLError, "untestable-clotted-post-analytical", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (ALT): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (ALT): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Alanine Transaminase could not be reported.";
		System.out.println("Error (ALT): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALT): "+actualALTErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
	
	}
	
	public void partialReportTC4() throws InterruptedException, IOException {
		generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Male");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", Barcode1);
		goldReplacements.put("19.9", "Untestable – Misc (post-analytical)");
		goldReplacements.put("39.9", "Untestable – Misc (post-analytical)");
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Untestable");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsGGTBiomarker(), Duration.ofSeconds(10));
		String ggtValue = soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().getText() +" : "+ggtValue);
		assertEquals(ggtValue, "Untestable");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().getText() +" : "+ggtValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Untestable – Misc (post-analytical)", "Biomarker value mismatch");
		assertEquals(actualFOLError, "untestable-misc-post-analytical", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsNavNextPageBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsNavNextPageBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsGGTBiomarker(), Duration.ofSeconds(10));
		WebElement ggtMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsGGTBiomarker();
		String actualGGTValue = ggtMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualGGTError = ggtMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (GGT): "+actualGGTValue);
		System.out.println("Primary Barcode Results Error (GGT): "+actualGGTError);
		assertEquals(actualGGTValue, "Untestable – Misc (post-analytical)", "Biomarker value mismatch");
		assertEquals(actualGGTError, "untestable-misc-post-analytical", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (GGT): "+actualGGTValue +"<br>"+"Primary Barcode Results Error (GGT): "+actualGGTError);
		
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (GGT): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (GGT): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualGGTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedGGTError = "Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (GGT): "+actualGGTErrorMsg);
		assertEquals(actualGGTErrorMsg, expectedGGTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (GGT): "+actualGGTErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
		
	}
	
	public void partialReportTC5() throws InterruptedException, IOException {
		generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Male");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", Barcode1);
		goldReplacements.put("19.9", "Untestable – Grossly haemolysed");
		goldReplacements.put("55", "Untestable – Grossly haemolysed");
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Haemolysed");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsALPBiomarker(), Duration.ofSeconds(10));
		String alpValue = soft_1405_Partial_Report_Locators.get_timsALPBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsALPBiomarker().getText() +" : "+alpValue);
		assertEquals(alpValue, "Haemolysed");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsALPBiomarker().getText() +" : "+alpValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Untestable – Grossly haemolysed", "Biomarker value mismatch");
		assertEquals(actualFOLError, "untestable–grossly-haemolysed", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALPBiomarker(), Duration.ofSeconds(10));
		WebElement alpMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALPBiomarker();
		String actualALPValue = alpMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualALPError = alpMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (ALP): "+actualALPValue);
		System.out.println("Primary Barcode Results Error (ALP): "+actualALPError);
		assertEquals(actualALPValue, "Untestable – Grossly haemolysed", "Biomarker value mismatch");
		assertEquals(actualALPError, "untestable–grossly-haemolysed", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (ALP): "+actualALPValue +"<br>"+"Primary Barcode Results Error (GGT): "+actualALPError);
	
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (ALP): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (ALP): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alkaline Phosphatase could not be reported.";
		System.out.println("Error (ALP): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALP): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
		
	}
	
	
	public void partialReportTC6() throws InterruptedException, IOException {
		generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Female");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", Barcode1);
		goldReplacements.put("19.9", "Untestable – Insufficient (sample receipt)");
		goldReplacements.put("39.9", "Untestable – Insufficient (sample receipt)");
		goldReplacements.put("44", "Untestable – Insufficient (sample receipt)");
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Insufficient");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsALTBiomarker(), Duration.ofSeconds(10));
		String altValue = soft_1405_Partial_Report_Locators.get_timsALTBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsALTBiomarker().getText() +" : "+altValue);
		assertEquals(altValue, "Insufficient");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsALTBiomarker().getText() +" : "+altValue);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsGGTBiomarker(), Duration.ofSeconds(10));
		String ggtValue = soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().getText() +" : "+ggtValue);
		assertEquals(ggtValue, "Insufficient");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().getText() +" : "+ggtValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Untestable – Insufficient (sample receipt)", "Biomarker value mismatch");
		assertEquals(actualFOLError, "untestable-insufficient-sample-receipt", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALTBiomarker(), Duration.ofSeconds(10));
		WebElement altMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALTBiomarker();
		String actualALTValue = altMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualALTError = altMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (ALT): "+actualALTValue);
		System.out.println("Primary Barcode Results Error (ALT): "+actualALTError);
		assertEquals(actualALTValue, "Untestable – Insufficient (sample receipt)", "Biomarker value mismatch");
		assertEquals(actualALTError, "untestable-insufficient-sample-receipt", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (ALT): "+actualALTValue +"<br>"+"Primary Barcode Results Error (ALT): "+actualALTError);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsNavNextPageBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsNavNextPageBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsGGTBiomarker(), Duration.ofSeconds(10));
		WebElement ggtMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsGGTBiomarker();
		String actualGGTValue = ggtMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualGGTError = ggtMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (GGT): "+actualGGTValue);
		System.out.println("Primary Barcode Results Error (GGT): "+actualGGTError);
		assertEquals(actualGGTValue, "Untestable – Insufficient (sample receipt)", "Biomarker value mismatch");
		assertEquals(actualGGTError, "untestable-insufficient-sample-receipt", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (GGT): "+actualGGTValue +"<br>"+"Primary Barcode Results Error (GGT): "+actualGGTError);
		
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (Liver Health): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (Liver Health): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualLHErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedLHError = "Alanine Transaminase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (Liver Health): "+actualLHErrorMsg);
		assertEquals(actualLHErrorMsg, expectedLHError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Liver Health): "+actualLHErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
	}
	
	public void partialReportTC7() throws InterruptedException, IOException {
		generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Female");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", Barcode1);
		goldReplacements.put("19.9", "Untestable – Damaged/Empty/Not returned");
		goldReplacements.put("55", "Untestable – Damaged/Empty/Not returned");
		goldReplacements.put("44", "Untestable – Damaged/Empty/Not returned");
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Untestable");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsALTBiomarker(), Duration.ofSeconds(10));
		String altValue = soft_1405_Partial_Report_Locators.get_timsALTBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsALTBiomarker().getText() +" : "+altValue);
		assertEquals(altValue, "Untestable");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsALTBiomarker().getText() +" : "+altValue);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsALPBiomarker(), Duration.ofSeconds(10));
		String alpValue = soft_1405_Partial_Report_Locators.get_timsALPBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsALPBiomarker().getText() +" : "+alpValue);
		assertEquals(alpValue, "Untestable");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsALPBiomarker().getText() +" : "+alpValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Untestable – Damaged/Empty/Not returned", "Biomarker value mismatch");
		assertEquals(actualFOLError, "untestable-damaged-empty-not-returned", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALTBiomarker(), Duration.ofSeconds(10));
		WebElement altMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALTBiomarker();
		String actualALTValue = altMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualALTError = altMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (ALT): "+actualALTValue);
		System.out.println("Primary Barcode Results Error (ALT): "+actualALTError);
		assertEquals(actualALTValue, "Untestable – Damaged/Empty/Not returned", "Biomarker value mismatch");
		assertEquals(actualALTError, "untestable-damaged-empty-not-returned", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (ALT): "+actualALTValue +"<br>"+"Primary Barcode Results Error (ALT): "+actualALTError);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALPBiomarker(), Duration.ofSeconds(10));
		WebElement alpMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALPBiomarker();
		String actualALPValue = alpMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualALPError = alpMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (ALP): "+actualALPValue);
		System.out.println("Primary Barcode Results Error (ALP): "+actualALPValue);
		assertEquals(actualALPValue, "Untestable – Damaged/Empty/Not returned", "Biomarker value mismatch");
		assertEquals(actualALPError, "untestable-damaged-empty-not-returned", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (ALP): "+actualALPValue +"<br>"+"Primary Barcode Results Error (GGT): "+actualALPError);
		
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (Liver Health): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (Liver Health): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualLHErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedLHError = "Alanine Transaminase & Alkaline Phosphatase could not be reported.";
		System.out.println("Error (Liver Health): "+actualLHErrorMsg);
		assertEquals(actualLHErrorMsg, expectedLHError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Liver Health): "+actualLHErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
	}
	
	public void partialReportTC8() throws InterruptedException, IOException {
		generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Male");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", Barcode1);
		goldReplacements.put("19.9", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("55", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("39.9", "Untestable – Clotted (sample receipt)");
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Clotted");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsALPBiomarker(), Duration.ofSeconds(10));
		String alpValue = soft_1405_Partial_Report_Locators.get_timsALPBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsALPBiomarker().getText() +" : "+alpValue);
		assertEquals(alpValue, "Clotted");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsALPBiomarker().getText() +" : "+alpValue);
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsGGTBiomarker(), Duration.ofSeconds(10));
		String ggtValue = soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().getText() +" : "+ggtValue);
		assertEquals(ggtValue, "Clotted");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().getText() +" : "+ggtValue);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Untestable – Clotted (sample receipt)", "Biomarker value mismatch");
		assertEquals(actualFOLError, "untestable-clotted-sample-receipt", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALPBiomarker(), Duration.ofSeconds(10));
		WebElement alpMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALPBiomarker();
		String actualALPValue = alpMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualALPError = alpMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (ALP): "+actualALPValue);
		System.out.println("Primary Barcode Results Error (ALP): "+actualALPValue);
		assertEquals(actualALPValue, "Untestable – Clotted (sample receipt)", "Biomarker value mismatch");
		assertEquals(actualALPError, "untestable-clotted-sample-receipt", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (ALP): "+actualALPValue +"<br>"+"Primary Barcode Results Error (ALP): "+actualALPError);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsNavNextPageBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsNavNextPageBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsGGTBiomarker(), Duration.ofSeconds(10));
		WebElement ggtMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsGGTBiomarker();
		String actualGGTValue = ggtMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualGGTError = ggtMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (GGT): "+actualGGTValue);
		System.out.println("Primary Barcode Results Error (GGT): "+actualGGTError);
		assertEquals(actualGGTValue, "Untestable – Clotted (sample receipt)", "Biomarker value mismatch");
		assertEquals(actualGGTError, "untestable-clotted-sample-receipt", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (GGT): "+actualGGTValue +"<br>"+"Primary Barcode Results Error (GGT): "+actualGGTError);
		
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (Liver Health): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (Liver Health): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualLHErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedLHError = "Alkaline Phosphatase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (Liver Health): "+actualLHErrorMsg);
		assertEquals(actualLHErrorMsg, expectedLHError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Liver Health): "+actualLHErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
	}
	
	public void partialReportTC9() throws InterruptedException, IOException {
		generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Female");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", Barcode1);
		goldReplacements.put("19.9", "Inhibitory");
		goldReplacements.put("55", "Inhibitory");
		goldReplacements.put("44", "Inhibitory");
		goldReplacements.put("39.9", "Inhibitory");
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Untestable");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsALPBiomarker(), Duration.ofSeconds(10));
		String alpValue = soft_1405_Partial_Report_Locators.get_timsALPBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsALPBiomarker().getText() +" : "+alpValue);
		assertEquals(alpValue, "Untestable");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsALPBiomarker().getText() +" : "+alpValue);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsALTBiomarker(), Duration.ofSeconds(10));
		String altValue = soft_1405_Partial_Report_Locators.get_timsALTBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsALTBiomarker().getText() +" : "+altValue);
		assertEquals(altValue, "Untestable");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsALTBiomarker().getText() +" : "+altValue);
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsGGTBiomarker(), Duration.ofSeconds(10));
		String ggtValue = soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().getText() +" : "+ggtValue);
		assertEquals(ggtValue, "Untestable");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsGGTBiomarker().getText() +" : "+ggtValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Inhibitory", "Biomarker value mismatch");
		assertEquals(actualFOLError, "inhibitory", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALPBiomarker(), Duration.ofSeconds(10));
		WebElement alpMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALPBiomarker();
		String actualALPValue = alpMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualALPError = alpMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (ALP): "+actualALPValue);
		System.out.println("Primary Barcode Results Error (ALP): "+actualALPValue);
		assertEquals(actualALPValue, "Inhibitory", "Biomarker value mismatch");
		assertEquals(actualALPError, "inhibitory", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (ALP): "+actualALPValue +"<br>"+"Primary Barcode Results Error (GGT): "+actualALPError);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsNavNextPageBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsNavNextPageBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALTBiomarker(), Duration.ofSeconds(10));
		WebElement ggtMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsALTBiomarker();
		String actualGGTValue = ggtMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualGGTError = ggtMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (ALT): "+actualGGTValue);
		System.out.println("Primary Barcode Results Error (ALT): "+actualGGTError);
		assertEquals(actualGGTValue, "Inhibitory", "Biomarker value mismatch");
		assertEquals(actualGGTError, "inhibitory", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (ALT): "+actualGGTValue +"<br>"+"Primary Barcode Results Error (ALT): "+actualGGTError);
		
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (Liver Health): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (Liver Health): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualLHErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedLHError = "Alanine Transaminase, Alkaline Phosphatase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (Liver Health): "+actualLHErrorMsg);
		assertEquals(actualLHErrorMsg, expectedLHError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Liver Health): "+actualLHErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (FOL): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
	}
	
	public void partialReportTC10() throws InterruptedException, IOException {
		generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Female");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", Barcode1);
		goldReplacements.put("19.9", "Untestable – Clotted (post-analytical)");
		goldReplacements.put("51.9", "Untestable – Clotted (post-analytical)");
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), Barcode1);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_testKitStatusTims(), Duration.ofSeconds(10));
		String kitStatus = soft_1405_Partial_Report_Locators.get_testKitStatusTims().getText();
		System.out.println("Kit Status (Tims): "+kitStatus);
		assertEquals(kitStatus, "error", "Kit Status Mismatch");
		ExtentManager.getTest().log(Status.PASS, "Kit Status: "+kitStatus);
		
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(60));
		WebWait.visibilityOfElement(driver, customer_landing_actions.getViewTestBtn(Barcode1), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, customer_landing_actions.getViewTestBtn(Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, customer_landing_actions.getViewTestBtn(Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(customer_landing_actions.getViewTestBtn(Barcode1), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_testKitStatusDashboard(), Duration.ofSeconds(20));
		String kitStatusDb = soft_1405_Partial_Report_Locators.get_testKitStatusDashboard().getText();
		System.out.println("Kit Status (Dashboard): " + kitStatusDb);
		assertEquals(kitStatusDb, "Rejected", "Kit Status Mismatch");
		ExtentManager.getTest().log(Status.PASS, "Kit Status (Dashboard): " + kitStatusDb);

	}
	
	public void partialReportTC11() throws InterruptedException, IOException {
		generateSingleBarcode("Vitamins & Minerals Profile Test");
		activateTestKitSingleBarcode();
		markKitAsReceived("Single");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGI-DEJ-5273", Barcode1);
		goldReplacements.put("17", "Untestable – Insufficient (post-analytical)");
		
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.vitaminMineralResultsCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Insufficient");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Untestable – Insufficient (post-analytical)", "Biomarker value mismatch");
		assertEquals(actualFOLError, "untestable-insufficient-post-analytical", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_dbTestReportYourResultsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dbTestReportYourResultsBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (Vit. & Min. Profile test): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (Vit. & Min. Profile test): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
		
	}
	
	public void partialReportTC12() throws InterruptedException, IOException {
		generateSingleBarcode("Vitamins & Minerals Profile Test");
		activateTestKitSingleBarcode();
		markKitAsReceived("Single");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGI-DEJ-5273", Barcode1);
		goldReplacements.put("17", "Untestable – Clotted (post-analytical)");
		
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.vitaminMineralResultsCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Clotted");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Untestable – Clotted (post-analytical)", "Biomarker value mismatch");
		assertEquals(actualFOLError, "untestable-clotted-post-analytical", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_dbTestReportYourResultsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dbTestReportYourResultsBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (Vit. & Min. Profile test): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (Vit. & Min. Profile test): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
	}
	
	public void partialReportTC13() throws InterruptedException, IOException {
		generateSingleBarcode("Vitamins & Minerals Profile Test");
		activateTestKitSingleBarcode();
		markKitAsReceived("Single");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGI-DEJ-5273", Barcode1);
		goldReplacements.put("17", "Untestable – Clotted (post-analytical)");
		goldReplacements.put("15", "Untestable – Clotted (post-analytical)");
		
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.vitaminMineralResultsCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), Barcode1);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_testKitStatusTims(), Duration.ofSeconds(10));
		String kitStatus = soft_1405_Partial_Report_Locators.get_testKitStatusTims().getText();
		System.out.println("Kit Status (Tims): "+kitStatus);
		assertEquals(kitStatus, "error", "Kit Status Mismatch");
		ExtentManager.getTest().log(Status.PASS, "Kit Status: "+kitStatus);
		
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(60));
		WebWait.visibilityOfElement(driver, customer_landing_actions.getViewTestBtn(Barcode1), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, customer_landing_actions.getViewTestBtn(Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, customer_landing_actions.getViewTestBtn(Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(customer_landing_actions.getViewTestBtn(Barcode1), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_testKitStatusDashboard(), Duration.ofSeconds(20));
		String kitStatusDb = soft_1405_Partial_Report_Locators.get_testKitStatusDashboard().getText();
		System.out.println("Kit Status (Dashboard): " + kitStatusDb);
		assertEquals(kitStatusDb, "Rejected", "Kit Status Mismatch");
		ExtentManager.getTest().log(Status.PASS, "Kit Status (Dashboard): " + kitStatusDb);
	}
	
	public void partialReportTC14() throws InterruptedException, IOException {
		generateDoubleBarcode("Weight Management Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Female");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGR-VXG-1223", Barcode1);
		goldReplacements.put("4.9", "Untestable – Grossly haemolysed");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLK-GHI-3405", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.weightManagementGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.weightManagementLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_glucoseGroupStatusDrp(), "1", driver);
		
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Haemolysed");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText().trim();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Untestable – Grossly haemolysed", "Biomarker value mismatch");
		assertEquals(actualFOLError, "untestable–grossly-haemolysed", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (Vit. & Min.): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (Vit. & Min.): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
	
	}
	
	public void partialReportTC15() throws InterruptedException, IOException {
		generateDoubleBarcode("Weight Management Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Female");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGR-VXG-1223", Barcode1);
		goldReplacements.put("4.9", "Untestable – Clotted (post-analytical)");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLK-GHI-3405", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.weightManagementGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.weightManagementLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_glucoseGroupStatusDrp(), "1", driver);
		
		assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker(), Duration.ofSeconds(10));
		String folateValue = soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		assertEquals(folateValue, "Clotted");
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_timsFolateBiomarker().getText() +" : "+folateValue);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker(), Duration.ofSeconds(10));
		WebElement folateMarker = soft_1405_Partial_Report_Locators.get_timsPrimaryBarcodeResultsFolateBiomarker();
		String actualFOLValue = folateMarker.findElement(By.xpath("./following-sibling::td[1]")).getText();
		String actualFOLError = folateMarker.findElement(By.xpath("./following-sibling::td[4]")).getText().trim();
		System.out.println("Primary Barcode Results Value (FOL): "+actualFOLValue);
		System.out.println("Primary Barcode Results Error (FOL): "+actualFOLError);
		assertEquals(actualFOLValue, "Untestable – Clotted (post-analytical)", "Biomarker value mismatch");
		assertEquals(actualFOLError, "untestable-clotted-post-analytical", "Error reason mismatch");
		ExtentManager.getTest().log(Status.PASS, "Primary Barcode Results Value (FOL): "+actualFOLValue +"<br>"+"Primary Barcode Results Error (FOL): "+actualFOLError);
	
		dashboardViewReport();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_dashboardReportsInfoIcon(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip(), Duration.ofSeconds(20));
		System.out.println("Tooltip Error Message (Vit. & Min.): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
		assertEquals(soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText(), "Some biomarker (s) couldn't be analysed");
		ExtentManager.getTest().log(Status.PASS, "Tooltip Error Message (Vit. & Min.): "+soft_1405_Partial_Report_Locators.get_dashboardReportsTooltip().getText());
	
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualErrorMsg);
	}
	
	public void partialReportTC16() throws InterruptedException, IOException {
		generateDoubleBarcode("Weight Management Test", "Gold", "Lavender");
		activateTestKitDoubleBarcode("Female");
		markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGR-VXG-1223", Barcode1);
		goldReplacements.put("3.9", "Untestable – Clotted (post-analytical)");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLK-GHI-3405", Barcode2);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.weightManagementGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.weightManagementLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), Barcode1);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_testKitStatusTims(), Duration.ofSeconds(10));
		String kitStatus = soft_1405_Partial_Report_Locators.get_testKitStatusTims().getText();
		System.out.println("Kit Status (Tims): "+kitStatus);
		assertEquals(kitStatus, "error", "Kit Status Mismatch");
		ExtentManager.getTest().log(Status.PASS, "Kit Status: "+kitStatus);
		
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(60));
		WebWait.visibilityOfElement(driver, customer_landing_actions.getViewTestBtn(Barcode1), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, customer_landing_actions.getViewTestBtn(Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, customer_landing_actions.getViewTestBtn(Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(customer_landing_actions.getViewTestBtn(Barcode1), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_testKitStatusDashboard(), Duration.ofSeconds(20));
		String kitStatusDb = soft_1405_Partial_Report_Locators.get_testKitStatusDashboard().getText();
		System.out.println("Kit Status (Dashboard): " + kitStatusDb);
		assertEquals(kitStatusDb, "Rejected", "Kit Status Mismatch");
		ExtentManager.getTest().log(Status.PASS, "Kit Status (Dashboard): " + kitStatusDb);
	}
	
	public void assertInvisibility(WebElement element, String label) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.pollingEvery(Duration.ofMillis(100));
		boolean invisible = wait.until(ExpectedConditions.invisibilityOf(element));
		assertTrue(invisible, label+" is displayed");
		System.out.println("Validation: " +label+ " biomarker group is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Validation: " +label+ " is not displayed");
	}
}
