package Test.Tims.Partial_Report_Actions_Class;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Dashboard.Locators_Class.Customer_Landing_Locators;
import Test.Dashboard.Locators_Class.Health_Assessment_Locators;
import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Locators_Class.SH_Locators;
import Test.Tims.Partial_Report_Locators_Class.SOFT_1405_Partial_Report_Locators;
import Test.Tims.Partial_Report_Locators_Class.SOFT_1407_Partial_Report_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class SOFT_1407_Partial_Report_Actions {

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
	SOFT_1407_Partial_Report_Locators soft_1407_Partial_Report_Locators;
	SOFT_1405_Partial_Report_Actions soft_1405_Partial_Report_actions;
	
	public SOFT_1407_Partial_Report_Actions(WebDriver driver) {
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
		soft_1407_Partial_Report_Locators = new SOFT_1407_Partial_Report_Locators(driver);
		soft_1405_Partial_Report_actions = new SOFT_1405_Partial_Report_Actions(driver);
	}
	
	public void partialReportTC01() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("0.32", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("0.37", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("164.9", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("4.4", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("99.9", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("0.7", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("7.4", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("449.9", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("5.7", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("10.9", "Untestable – Insufficient (sample receipt)");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Insufficient");
		expectedValues.put("Eosinophils", "Insufficient");
		expectedValues.put("Haematocrit", "Insufficient");
		expectedValues.put("Haemoglobin", "Insufficient");
		expectedValues.put("Lymphocytes", "Insufficient");
		expectedValues.put("Mean Cell Volume", "Insufficient");
		expectedValues.put("Monocytes", "Insufficient");
		expectedValues.put("Neutrophils", "Insufficient");
		expectedValues.put("Platelet Count", "Insufficient");
		expectedValues.put("Red Blood Cell", "Insufficient");
		expectedValues.put("White Blood Cells", "Insufficient");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("HCT", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Insufficient (sample receipt)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable-insufficient-sample-receipt");
		secondaryResultsExpectedErrors.put("EOS", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("HCT", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("HGB", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("LYMP", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("MCV", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("MONO", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("NEU", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("PLT", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("RBC", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("WBC", "untestable-insufficient-sample-receipt");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC02() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("0.32", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("0.37", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("164.9", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("4.4", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("99.9", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("0.7", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("7.4", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("449.9", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("5.7", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("10.9", "Untestable – Insufficient (post-analytical)");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Insufficient");
		expectedValues.put("Eosinophils", "Insufficient");
		expectedValues.put("Haematocrit", "Insufficient");
		expectedValues.put("Haemoglobin", "Insufficient");
		expectedValues.put("Lymphocytes", "Insufficient");
		expectedValues.put("Mean Cell Volume", "Insufficient");
		expectedValues.put("Monocytes", "Insufficient");
		expectedValues.put("Neutrophils", "Insufficient");
		expectedValues.put("Platelet Count", "Insufficient");
		expectedValues.put("Red Blood Cell", "Insufficient");
		expectedValues.put("White Blood Cells", "Insufficient");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("HCT", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Insufficient (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable-insufficient-post-analytical");
		secondaryResultsExpectedErrors.put("EOS", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("HCT", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("HGB", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("LYMP", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("MCV", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("MONO", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("NEU", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("PLT", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("RBC", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("WBC", "untestable-insufficient-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC03() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("0.32", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("0.37", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("164.9", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("4.4", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("99.9", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("0.7", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("7.4", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("449.9", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("5.7", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("10.9", "Untestable – Damaged/Empty/Not returned");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Untestable");
		expectedValues.put("Eosinophils", "Untestable");
		expectedValues.put("Haematocrit", "Untestable");
		expectedValues.put("Haemoglobin", "Untestable");
		expectedValues.put("Lymphocytes", "Untestable");
		expectedValues.put("Mean Cell Volume", "Untestable");
		expectedValues.put("Monocytes", "Untestable");
		expectedValues.put("Neutrophils", "Untestable");
		expectedValues.put("Platelet Count", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		expectedValues.put("White Blood Cells", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("HCT", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Damaged/Empty/Not returned");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable-damaged-empty-not-returned");
		secondaryResultsExpectedErrors.put("EOS", "untestable-damaged-empty-not-returned");
        secondaryResultsExpectedErrors.put("HCT", "untestable-damaged-empty-not-returned");
        secondaryResultsExpectedErrors.put("HGB", "untestable-damaged-empty-not-returned");
        secondaryResultsExpectedErrors.put("LYMP", "untestable-damaged-empty-not-returned");
        secondaryResultsExpectedErrors.put("MCV", "untestable-damaged-empty-not-returned");
        secondaryResultsExpectedErrors.put("MONO", "untestable-damaged-empty-not-returned");
        secondaryResultsExpectedErrors.put("NEU", "untestable-damaged-empty-not-returned");
        secondaryResultsExpectedErrors.put("PLT", "untestable-damaged-empty-not-returned");
        secondaryResultsExpectedErrors.put("RBC", "untestable-damaged-empty-not-returned");
        secondaryResultsExpectedErrors.put("WBC", "untestable-damaged-empty-not-returned");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC04() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Sample too old");
		lavenderReplacements.put("0.32", "Untestable – Sample too old");
		lavenderReplacements.put("0.37", "Untestable – Sample too old");
		lavenderReplacements.put("164.9", "Untestable – Sample too old");
		lavenderReplacements.put("4.4", "Untestable – Sample too old");
		lavenderReplacements.put("99.9", "Untestable – Sample too old");
		lavenderReplacements.put("0.7", "Untestable – Sample too old");
		lavenderReplacements.put("7.4", "Untestable – Sample too old");
		lavenderReplacements.put("449.9", "Untestable – Sample too old");
		lavenderReplacements.put("5.7", "Untestable – Sample too old");
		lavenderReplacements.put("10.9", "Untestable – Sample too old");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Untestable");
		expectedValues.put("Eosinophils", "Untestable");
		expectedValues.put("Haematocrit", "Untestable");
		expectedValues.put("Haemoglobin", "Untestable");
		expectedValues.put("Lymphocytes", "Untestable");
		expectedValues.put("Mean Cell Volume", "Untestable");
		expectedValues.put("Monocytes", "Untestable");
		expectedValues.put("Neutrophils", "Untestable");
		expectedValues.put("Platelet Count", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		expectedValues.put("White Blood Cells", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("HCT", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Sample too old");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable–sample-too-old");
		secondaryResultsExpectedErrors.put("EOS", "untestable–sample-too-old");
        secondaryResultsExpectedErrors.put("HCT", "untestable–sample-too-old");
        secondaryResultsExpectedErrors.put("HGB", "untestable–sample-too-old");
        secondaryResultsExpectedErrors.put("LYMP", "untestable–sample-too-old");
        secondaryResultsExpectedErrors.put("MCV", "untestable–sample-too-old");
        secondaryResultsExpectedErrors.put("MONO", "untestable–sample-too-old");
        secondaryResultsExpectedErrors.put("NEU", "untestable–sample-too-old");
        secondaryResultsExpectedErrors.put("PLT", "untestable–sample-too-old");
        secondaryResultsExpectedErrors.put("RBC", "untestable–sample-too-old");
        secondaryResultsExpectedErrors.put("WBC", "untestable–sample-too-old");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC05() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("0.32", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("0.37", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("164.9", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("4.4", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("99.9", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("0.7", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("7.4", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("449.9", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("5.7", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("10.9", "Untestable – Grossly haemolysed");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Haemolysed");
		expectedValues.put("Eosinophils", "Haemolysed");
		expectedValues.put("Haematocrit", "Haemolysed");
		expectedValues.put("Haemoglobin", "Haemolysed");
		expectedValues.put("Lymphocytes", "Haemolysed");
		expectedValues.put("Mean Cell Volume", "Haemolysed");
		expectedValues.put("Monocytes", "Haemolysed");
		expectedValues.put("Neutrophils", "Haemolysed");
		expectedValues.put("Platelet Count", "Haemolysed");
		expectedValues.put("Red Blood Cell", "Haemolysed");
		expectedValues.put("White Blood Cells", "Haemolysed");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("HCT", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Grossly haemolysed");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable–grossly-haemolysed");
		secondaryResultsExpectedErrors.put("EOS", "untestable–grossly-haemolysed");
        secondaryResultsExpectedErrors.put("HCT", "untestable–grossly-haemolysed");
        secondaryResultsExpectedErrors.put("HGB", "untestable–grossly-haemolysed");
        secondaryResultsExpectedErrors.put("LYMP", "untestable–grossly-haemolysed");
        secondaryResultsExpectedErrors.put("MCV", "untestable–grossly-haemolysed");
        secondaryResultsExpectedErrors.put("MONO", "untestable–grossly-haemolysed");
        secondaryResultsExpectedErrors.put("NEU", "untestable–grossly-haemolysed");
        secondaryResultsExpectedErrors.put("PLT", "untestable–grossly-haemolysed");
        secondaryResultsExpectedErrors.put("RBC", "untestable–grossly-haemolysed");
        secondaryResultsExpectedErrors.put("WBC", "untestable–grossly-haemolysed");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC06() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("0.32", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("0.37", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("164.9", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("4.4", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("99.9", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("0.7", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("7.4", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("449.9", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("5.7", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("10.9", "Untestable – Clotted (sample receipt)");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Clotted");
		expectedValues.put("Eosinophils", "Clotted");
		expectedValues.put("Haematocrit", "Clotted");
		expectedValues.put("Haemoglobin", "Clotted");
		expectedValues.put("Lymphocytes", "Clotted");
		expectedValues.put("Mean Cell Volume", "Clotted");
		expectedValues.put("Monocytes", "Clotted");
		expectedValues.put("Neutrophils", "Clotted");
		expectedValues.put("Platelet Count", "Clotted");
		expectedValues.put("Red Blood Cell", "Clotted");
		expectedValues.put("White Blood Cells", "Clotted");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("HCT", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Clotted (sample receipt)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("EOS", "untestable-clotted-sample-receipt");
        secondaryResultsExpectedErrors.put("HCT", "untestable-clotted-sample-receipt");
        secondaryResultsExpectedErrors.put("HGB", "untestable-clotted-sample-receipt");
        secondaryResultsExpectedErrors.put("LYMP", "untestable-clotted-sample-receipt");
        secondaryResultsExpectedErrors.put("MCV", "untestable-clotted-sample-receipt");
        secondaryResultsExpectedErrors.put("MONO", "untestable-clotted-sample-receipt");
        secondaryResultsExpectedErrors.put("NEU", "untestable-clotted-sample-receipt");
        secondaryResultsExpectedErrors.put("PLT", "untestable-clotted-sample-receipt");
        secondaryResultsExpectedErrors.put("RBC", "untestable-clotted-sample-receipt");
        secondaryResultsExpectedErrors.put("WBC", "untestable-clotted-sample-receipt");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC07() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("0.32", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("0.37", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("164.9", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("4.4", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("99.9", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("0.7", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("7.4", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("449.9", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("5.7", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("10.9", "Untestable – Clotted (post-analytical)");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Clotted");
		expectedValues.put("Eosinophils", "Clotted");
		expectedValues.put("Haematocrit", "Clotted");
		expectedValues.put("Haemoglobin", "Clotted");
		expectedValues.put("Lymphocytes", "Clotted");
		expectedValues.put("Mean Cell Volume", "Clotted");
		expectedValues.put("Monocytes", "Clotted");
		expectedValues.put("Neutrophils", "Clotted");
		expectedValues.put("Platelet Count", "Clotted");
		expectedValues.put("Red Blood Cell", "Clotted");
		expectedValues.put("White Blood Cells", "Clotted");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("HCT", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Clotted (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable-clotted-post-analytical");
		secondaryResultsExpectedErrors.put("EOS", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("HCT", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("HGB", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("LYMP", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("MCV", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("MONO", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("NEU", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("PLT", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("RBC", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("WBC", "untestable-clotted-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC08() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("0.32", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("0.37", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("164.9", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("4.4", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("99.9", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("0.7", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("7.4", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("449.9", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("5.7", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("10.9", "Untestable – Misc (sample receipt)");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Untestable");
		expectedValues.put("Eosinophils", "Untestable");
		expectedValues.put("Haematocrit", "Untestable");
		expectedValues.put("Haemoglobin", "Untestable");
		expectedValues.put("Lymphocytes", "Untestable");
		expectedValues.put("Mean Cell Volume", "Untestable");
		expectedValues.put("Monocytes", "Untestable");
		expectedValues.put("Neutrophils", "Untestable");
		expectedValues.put("Platelet Count", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		expectedValues.put("White Blood Cells", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("HCT", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Misc (sample receipt)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable-misc-sample-receipt");
		secondaryResultsExpectedErrors.put("EOS", "untestable-misc-sample-receipt");
        secondaryResultsExpectedErrors.put("HCT", "untestable-misc-sample-receipt");
        secondaryResultsExpectedErrors.put("HGB", "untestable-misc-sample-receipt");
        secondaryResultsExpectedErrors.put("LYMP", "untestable-misc-sample-receipt");
        secondaryResultsExpectedErrors.put("MCV", "untestable-misc-sample-receipt");
        secondaryResultsExpectedErrors.put("MONO", "untestable-misc-sample-receipt");
        secondaryResultsExpectedErrors.put("NEU", "untestable-misc-sample-receipt");
        secondaryResultsExpectedErrors.put("PLT", "untestable-misc-sample-receipt");
        secondaryResultsExpectedErrors.put("RBC", "untestable-misc-sample-receipt");
        secondaryResultsExpectedErrors.put("WBC", "untestable-misc-sample-receipt");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC09() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("0.32", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("0.37", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("164.9", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("4.4", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("99.9", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("0.7", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("7.4", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("449.9", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("5.7", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("10.9", "Untestable – Misc (post-analytical)");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Untestable");
		expectedValues.put("Eosinophils", "Untestable");
		expectedValues.put("Haematocrit", "Untestable");
		expectedValues.put("Haemoglobin", "Untestable");
		expectedValues.put("Lymphocytes", "Untestable");
		expectedValues.put("Mean Cell Volume", "Untestable");
		expectedValues.put("Monocytes", "Untestable");
		expectedValues.put("Neutrophils", "Untestable");
		expectedValues.put("Platelet Count", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		expectedValues.put("White Blood Cells", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("HCT", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Misc (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable-misc-post-analytical");
		secondaryResultsExpectedErrors.put("EOS", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("HCT", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("HGB", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("LYMP", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("MCV", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("MONO", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("NEU", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("PLT", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("RBC", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("WBC", "untestable-misc-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC10() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Inhibitory");
		lavenderReplacements.put("0.32", "Inhibitory");
		lavenderReplacements.put("0.37", "Inhibitory");
		lavenderReplacements.put("164.9", "Inhibitory");
		lavenderReplacements.put("4.4", "Inhibitory");
		lavenderReplacements.put("99.9", "Inhibitory");
		lavenderReplacements.put("0.7", "Inhibitory");
		lavenderReplacements.put("7.4", "Inhibitory");
		lavenderReplacements.put("449.9", "Inhibitory");
		lavenderReplacements.put("5.7", "Inhibitory");
		lavenderReplacements.put("10.9", "Inhibitory");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Untestable");
		expectedValues.put("Eosinophils", "Untestable");
		expectedValues.put("Haematocrit", "Untestable");
		expectedValues.put("Haemoglobin", "Untestable");
		expectedValues.put("Lymphocytes", "Untestable");
		expectedValues.put("Mean Cell Volume", "Untestable");
		expectedValues.put("Monocytes", "Untestable");
		expectedValues.put("Neutrophils", "Untestable");
		expectedValues.put("Platelet Count", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		expectedValues.put("White Blood Cells", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Inhibitory");
		secondaryResultsExpectedValues.put("EOS", "Inhibitory");
		secondaryResultsExpectedValues.put("HCT", "Inhibitory");
		secondaryResultsExpectedValues.put("HGB", "Inhibitory");
		secondaryResultsExpectedValues.put("LYMP", "Inhibitory");
		secondaryResultsExpectedValues.put("MCV", "Inhibitory");
		secondaryResultsExpectedValues.put("MONO", "Inhibitory");
		secondaryResultsExpectedValues.put("NEU", "Inhibitory");
		secondaryResultsExpectedValues.put("PLT", "Inhibitory");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "Inhibitory");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "inhibitory");
		secondaryResultsExpectedErrors.put("EOS", "inhibitory");
        secondaryResultsExpectedErrors.put("HCT", "inhibitory");
        secondaryResultsExpectedErrors.put("HGB", "inhibitory");
        secondaryResultsExpectedErrors.put("LYMP", "inhibitory");
        secondaryResultsExpectedErrors.put("MCV", "inhibitory");
        secondaryResultsExpectedErrors.put("MONO", "inhibitory");
        secondaryResultsExpectedErrors.put("NEU", "inhibitory");
        secondaryResultsExpectedErrors.put("PLT", "inhibitory");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "inhibitory");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC11() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Inhibitory");
		lavenderReplacements.put("0.32", "Inhibitory");
		lavenderReplacements.put("0.37", "Inhibitory");
		lavenderReplacements.put("164.9", "Inhibitory");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(40));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Untestable");
		expectedValues.put("Eosinophils", "Untestable");
		expectedValues.put("Haematocrit", "Untestable");
		expectedValues.put("Haemoglobin", "Untestable");
		expectedValues.put("Lymphocytes", "4.4 10⁹/L");
		expectedValues.put("Mean Cell Volume", "99.9 fL");
		expectedValues.put("Monocytes", "0.7 10⁹/L");
		expectedValues.put("Neutrophils", "7.4 10⁹/L");
		expectedValues.put("Platelet Count", "449.9 10⁹/L");
		expectedValues.put("Red Blood Cell", "5.7 10¹²/L");
		expectedValues.put("White Blood Cells", "10.9 10⁹/L");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Inhibitory");
		secondaryResultsExpectedValues.put("EOS", "Inhibitory");
		secondaryResultsExpectedValues.put("HCT", "Inhibitory");
		secondaryResultsExpectedValues.put("HGB", "Inhibitory");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "5.7");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "inhibitory");
		secondaryResultsExpectedErrors.put("EOS", "inhibitory");
        secondaryResultsExpectedErrors.put("HCT", "inhibitory");
        secondaryResultsExpectedErrors.put("HGB", "inhibitory");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "no-error");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC12() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("4.4", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("99.9", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("0.7", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("7.4", "Untestable – Clotted (post-analytical)");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
//		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
//		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "0.05 10⁹/L");
		expectedValues.put("Eosinophils", "0.32 10⁹/L");
		expectedValues.put("Haematocrit", "0.37 %");
		expectedValues.put("Haemoglobin", "164.9 g/L");
		expectedValues.put("Lymphocytes", "Clotted");
		expectedValues.put("Mean Cell Volume", "Clotted");
		expectedValues.put("Monocytes", "Clotted");
		expectedValues.put("Neutrophils", "Clotted");
		expectedValues.put("Platelet Count", "449.9 10⁹/L");
		expectedValues.put("Red Blood Cell", "5.7 10¹²/L");
		expectedValues.put("White Blood Cells", "10.9 10⁹/L");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "5.7");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("MCV", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("MONO", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("NEU", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "no-error");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC13() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("449.9", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("5.7", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("10.9", "Untestable – Insufficient (sample receipt)");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
//		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
//		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "0.05 10⁹/L");
		expectedValues.put("Eosinophils", "0.32 10⁹/L");
		expectedValues.put("Haematocrit", "0.37 %");
		expectedValues.put("Haemoglobin", "164.9 g/L");
		expectedValues.put("Lymphocytes", "4.4 10⁹/L");
		expectedValues.put("Mean Cell Volume", "99.9 fL");
		expectedValues.put("Monocytes", "0.7 10⁹/L");
		expectedValues.put("Neutrophils", "7.4 10⁹/L");
		expectedValues.put("Platelet Count", "Insufficient");
		expectedValues.put("Red Blood Cell", "Insufficient");
		expectedValues.put("White Blood Cells", "Insufficient");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Insufficient (sample receipt)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("RBC", "untestable-insufficient-sample-receipt");
        secondaryResultsExpectedErrors.put("WBC", "untestable-insufficient-sample-receipt");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC14() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Report error – investigate");
		lavenderReplacements.put("0.32", "Report error – investigate");
		lavenderReplacements.put("0.37", "Report error – investigate");
		lavenderReplacements.put("164.9", "Report error – investigate");
		lavenderReplacements.put("4.4", "Report error – investigate");
		lavenderReplacements.put("99.9", "Report error – investigate");
		lavenderReplacements.put("0.7", "Report error – investigate");
		lavenderReplacements.put("7.4", "Report error – investigate");
		lavenderReplacements.put("449.9", "Report error – investigate");
		lavenderReplacements.put("5.7", "Report error – investigate");
		lavenderReplacements.put("10.9", "Report error – investigate");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);

		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), SOFT_1405_Partial_Report_Actions.Barcode1);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testKitId(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testKitId(), driver);

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "0.05 10⁹/L");
		expectedValues.put("Eosinophils", "0.32 10⁹/L");
		expectedValues.put("Haematocrit", "0.37 %");
		expectedValues.put("Haemoglobin", "164.9 g/L");
		expectedValues.put("Lymphocytes", "4.4 10⁹/L");
		expectedValues.put("Mean Cell Volume", "99.9 fL");
		expectedValues.put("Monocytes", "0.7 10⁹/L");
		expectedValues.put("Neutrophils", "7.4 10⁹/L");
		expectedValues.put("Platelet Count", "Insufficient");
		expectedValues.put("Red Blood Cell", "Insufficient");
		expectedValues.put("White Blood Cells", "Insufficient");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Report error – investigate");
		secondaryResultsExpectedValues.put("EOS", "Report error – investigate");
		secondaryResultsExpectedValues.put("HCT", "Report error – investigate");
		secondaryResultsExpectedValues.put("HGB", "Report error – investigate");
		secondaryResultsExpectedValues.put("LYMP", "Report error – investigate");
		secondaryResultsExpectedValues.put("MCV", "Report error – investigate");
		secondaryResultsExpectedValues.put("MONO", "Report error – investigate");
		secondaryResultsExpectedValues.put("NEU", "Report error – investigate");
		secondaryResultsExpectedValues.put("PLT", "Report error – investigate");
		secondaryResultsExpectedValues.put("RBC", "Report error – investigate");
		secondaryResultsExpectedValues.put("WBC", "Report error – investigate");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "report-error-investigate");
		secondaryResultsExpectedErrors.put("EOS", "report-error-investigate");
        secondaryResultsExpectedErrors.put("HCT", "report-error-investigate");
        secondaryResultsExpectedErrors.put("HGB", "report-error-investigate");
        secondaryResultsExpectedErrors.put("LYMP", "report-error-investigate");
        secondaryResultsExpectedErrors.put("MCV", "report-error-investigate");
        secondaryResultsExpectedErrors.put("MONO", "report-error-investigate");
        secondaryResultsExpectedErrors.put("NEU", "report-error-investigate");
        secondaryResultsExpectedErrors.put("PLT", "report-error-investigate");
        secondaryResultsExpectedErrors.put("RBC", "report-error-investigate");
        secondaryResultsExpectedErrors.put("WBC", "report-error-investigate");
        
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(40));
		WebWait.visibilityOfElement(driver, customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1), driver);
		WebWait.visibilityOfElement(driver, soft_1407_Partial_Report_Locators.get_dbTestSummaryStatus(), Duration.ofSeconds(20));
		WebElement status = soft_1407_Partial_Report_Locators.get_dbTestSummaryStatus();
		String kitStatus = status.findElement(By.xpath("./following-sibling::h5")).getText();
		
		String expectedStatus = "Rejected";
		System.out.println("Status: "+kitStatus);
		assertEquals(kitStatus, expectedStatus, "Kit Status mismatch");
		ExtentManager.getTest().log(Status.PASS, "Status: "+kitStatus);
		
	}
	
	public void partialReportTC15() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		goldReplacements.put("51.9", "Untestable – Insufficient (sample receipt)");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Inhibitory");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);

		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), SOFT_1405_Partial_Report_Actions.Barcode1);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testKitId(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testKitId(), driver);

		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		WebElement albRow = primaryBiomarkerRowsPage1.get(0);
		String albBiomarker = albRow.findElement(By.xpath("./td[1]")).getText();
		String albActualValue = albRow.findElement(By.xpath("./td[2]")).getText();
		String albActualError = albRow.findElement(By.xpath("./td[5]")).getText();
		
		String albExpectedValue = "Untestable – Insufficient (sample receipt)";
		String albExpectedError = "untestable-insufficient-sample-receipt";
		
		System.out.println(albBiomarker +", "+ albActualValue +", "+ albActualError);
		assertEquals(albActualValue, albExpectedValue, "Biomarker value mismatch");
		assertEquals(albActualError, albExpectedError, "Biomarker error mismatch");
		
//		Map<String, String> expectedValues = new HashMap<>();
//		expectedValues.put("Basophils", "0.05 10⁹/L");
//		expectedValues.put("Eosinophils", "0.32 10⁹/L");
//		expectedValues.put("Haematocrit", "0.37 %");
//		expectedValues.put("Haemoglobin", "164.9 g/L");
//		expectedValues.put("Lymphocytes", "4.4 10⁹/L");
//		expectedValues.put("Mean Cell Volume", "99.9 fL");
//		expectedValues.put("Monocytes", "0.7 10⁹/L");
//		expectedValues.put("Neutrophils", "7.4 10⁹/L");
//		expectedValues.put("Platelet Count", "Insufficient");
//		expectedValues.put("Red Blood Cell", "Insufficient");
//		expectedValues.put("White Blood Cells", "Insufficient");
//		
//		validateBiomarkersReportDetails(expectedValues);
//		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(40));
		WebWait.visibilityOfElement(driver, customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1), driver);
		WebWait.visibilityOfElement(driver, soft_1407_Partial_Report_Locators.get_dbTestSummaryStatus(), Duration.ofSeconds(20));
		WebElement status = soft_1407_Partial_Report_Locators.get_dbTestSummaryStatus();
		String kitStatus = status.findElement(By.xpath("./following-sibling::h5")).getText();
		
		String expectedStatus = "Rejected";
		System.out.println("Status: "+kitStatus);
		assertEquals(kitStatus, expectedStatus, "Kit Status mismatch");
		ExtentManager.getTest().log(Status.PASS, "Status: "+kitStatus);
		
	}
	
	public void partialReportTC16() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		goldReplacements.put("44", "Inhibitory");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Inhibitory");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
//		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
//		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Alanine Transaminase", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

		Map<String, String> primaryResultsExpectedValues = new HashMap<>();
		primaryResultsExpectedValues.put("ALT", "Inhibitory");
		
		Map<String, String> primaryResultsExpectedErrors = new HashMap<>();
		primaryResultsExpectedErrors.put("ALT", "inhibitory");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedFBCError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualFBCErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardALTCouldNotBeReportedError(), Duration.ofSeconds(20));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardALTCouldNotBeReportedError().getText();
		String expectedALTError = "Alanine Transaminase could not be reported.";
		System.out.println("Error (Alanine Transaminase): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC17() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		goldReplacements.put("55", "Inhibitory");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Inhibitory");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
//		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
//		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Alkaline Phosphatase", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

		Map<String, String> primaryResultsExpectedValues = new HashMap<>();
		primaryResultsExpectedValues.put("ALP", "Inhibitory");
		
		Map<String, String> primaryResultsExpectedErrors = new HashMap<>();
		primaryResultsExpectedErrors.put("ALP", "inhibitory");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
	}
	
	public void partialReportTC21() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		goldReplacements.put("39.9", "Inhibitory");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Inhibitory");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
//		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
//		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Gamma-Glutamyl Transferase", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

		Map<String, String> primaryResultsExpectedValues = new HashMap<>();
		primaryResultsExpectedValues.put("GGT", "Inhibitory");
		
		Map<String, String> primaryResultsExpectedErrors = new HashMap<>();
		primaryResultsExpectedErrors.put("GGT", "inhibitory");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualGGTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedGGTError = "Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (GGT): "+actualGGTErrorMsg);
		assertEquals(actualGGTErrorMsg, expectedGGTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (GGT): "+actualGGTErrorMsg);
	}
	
	public void partialReportTC22() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		goldReplacements.put("39.9", "Inhibitory");
		goldReplacements.put("44", "Inhibitory");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Inhibitory");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
//		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
//		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Gamma-Glutamyl Transferase", "Untestable");
		expectedValues.put("Alanine Transaminase", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

		Map<String, String> primaryResultsExpectedValues = new HashMap<>();
		primaryResultsExpectedValues.put("GGT", "Inhibitory");
		primaryResultsExpectedValues.put("ALT", "Inhibitory");
		
		Map<String, String> primaryResultsExpectedErrors = new HashMap<>();
		primaryResultsExpectedErrors.put("GGT", "inhibitory");
		primaryResultsExpectedErrors.put("ALT", "inhibitory");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualGGTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedGGTError = "Alanine Transaminase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (ALT & GGT): "+actualGGTErrorMsg);
		assertEquals(actualGGTErrorMsg, expectedGGTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALT & GGT): "+actualGGTErrorMsg);
	}
	
	public void partialReportTC23() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		goldReplacements.put("55", "Inhibitory");
		goldReplacements.put("44", "Inhibitory");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Inhibitory");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
//		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
//		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Alkaline Phosphatase", "Untestable");
		expectedValues.put("Alanine Transaminase", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

		Map<String, String> primaryResultsExpectedValues = new HashMap<>();
		primaryResultsExpectedValues.put("ALP", "Inhibitory");
		primaryResultsExpectedValues.put("ALT", "Inhibitory");
		
		Map<String, String> primaryResultsExpectedErrors = new HashMap<>();
		primaryResultsExpectedErrors.put("ALP", "inhibitory");
		primaryResultsExpectedErrors.put("ALT", "inhibitory");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedALPError = "Alanine Transaminase & Alkaline Phosphatase could not be reported.";
		System.out.println("Error (ALT & ALP): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALT & ALP): "+actualALPErrorMsg);
	}
	
	public void partialReportTC24() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		goldReplacements.put("55", "Inhibitory");
		goldReplacements.put("39.9", "Inhibitory");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Inhibitory");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
//		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
//		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
//		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Alkaline Phosphatase", "Untestable");
		expectedValues.put("Gamma-Glutamyl Transferase", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

		Map<String, String> primaryResultsExpectedValues = new HashMap<>();
		primaryResultsExpectedValues.put("ALP", "Inhibitory");
		primaryResultsExpectedValues.put("GGT", "Inhibitory");
		
		Map<String, String> primaryResultsExpectedErrors = new HashMap<>();
		primaryResultsExpectedErrors.put("ALP", "inhibitory");
		primaryResultsExpectedErrors.put("GGT", "inhibitory");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedALPError = "Alkaline Phosphatase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (GGT & ALP): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (GGT & ALP): "+actualALPErrorMsg);
	}
	
	public void partialReportTC25() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("55", "Inhibitory");
		goldReplacements.put("39.9", "Inhibitory");
		goldReplacements.put("19.9", "Inhibitory");
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Inhibitory");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Alkaline Phosphatase", "Untestable");
		expectedValues.put("Folate", "Untestable");
		expectedValues.put("Gamma-Glutamyl Transferase", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_vitaminsMineralsBiomarkerList());
		
		Map<String, String> primaryResultsExpectedValues = new HashMap<>();
		primaryResultsExpectedValues.put("ALP", "Inhibitory");
		primaryResultsExpectedValues.put("FOL", "Inhibitory");
		primaryResultsExpectedValues.put("GGT", "Inhibitory");
		
		Map<String, String> primaryResultsExpectedErrors = new HashMap<>();
		primaryResultsExpectedErrors.put("ALP", "inhibitory");
		primaryResultsExpectedErrors.put("FOL", "inhibitory");
		primaryResultsExpectedErrors.put("GGT", "inhibitory");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage2 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage2, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedALPError = "Alkaline Phosphatase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (GGT & ALP): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (GGT & ALP): "+actualALPErrorMsg);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualFOLErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedFOLError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualFOLErrorMsg);
		assertEquals(actualFOLErrorMsg, expectedFOLError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualFOLErrorMsg);
	}
	
	public void partialReportTC26() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("55", "Untestable – Insufficient (post-analytical)");
		goldReplacements.put("44", "Untestable – Insufficient (post-analytical)");
		goldReplacements.put("19.9", "Untestable – Insufficient (post-analytical)");
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Untestable – Insufficient (post-analytical)");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Alkaline Phosphatase", "Insufficient");
		expectedValues.put("Folate", "Insufficient");
		expectedValues.put("Alanine Transaminase", "Insufficient");
		expectedValues.put("Red Blood Cell", "Insufficient");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_vitaminsMineralsBiomarkerList());
		
		Map<String, String> primaryResultsExpectedValues = new HashMap<>();
		primaryResultsExpectedValues.put("ALP", "Untestable – Insufficient (post-analytical)");
		primaryResultsExpectedValues.put("FOL", "Untestable – Insufficient (post-analytical)");
		primaryResultsExpectedValues.put("ALT", "Untestable – Insufficient (post-analytical)");
		
		Map<String, String> primaryResultsExpectedErrors = new HashMap<>();
		primaryResultsExpectedErrors.put("ALP", "untestable-insufficient-post-analytical");
		primaryResultsExpectedErrors.put("FOL", "untestable-insufficient-post-analytical");
		primaryResultsExpectedErrors.put("ALT", "untestable-insufficient-post-analytical");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage2 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage2, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedALPError = "Alanine Transaminase & Alkaline Phosphatase could not be reported.";
		System.out.println("Error (ALT & ALP): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALT & ALP): "+actualALPErrorMsg);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualFOLErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedFOLError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualFOLErrorMsg);
		assertEquals(actualFOLErrorMsg, expectedFOLError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualFOLErrorMsg);
	}
	
	public void partialReportTC27() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("39.9", "Untestable – Insufficient (post-analytical)");
		goldReplacements.put("44", "Untestable – Insufficient (post-analytical)");
		goldReplacements.put("19.9", "Untestable – Insufficient (post-analytical)");
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Untestable – Insufficient (post-analytical)");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
		
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Gamma-Glutamyl Transferase", "Insufficient");
		expectedValues.put("Folate", "Insufficient");
		expectedValues.put("Alanine Transaminase", "Insufficient");
		expectedValues.put("Red Blood Cell", "Insufficient");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_vitaminsMineralsBiomarkerList());
		
		Map<String, String> primaryResultsExpectedValues = new HashMap<>();
		primaryResultsExpectedValues.put("GGT", "Untestable – Insufficient (post-analytical)");
		primaryResultsExpectedValues.put("FOL", "Untestable – Insufficient (post-analytical)");
		primaryResultsExpectedValues.put("ALT", "Untestable – Insufficient (post-analytical)");
		
		Map<String, String> primaryResultsExpectedErrors = new HashMap<>();
		primaryResultsExpectedErrors.put("GGT", "untestable-insufficient-post-analytical");
		primaryResultsExpectedErrors.put("FOL", "untestable-insufficient-post-analytical");
		primaryResultsExpectedErrors.put("ALT", "untestable-insufficient-post-analytical");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "0.05");
		secondaryResultsExpectedValues.put("EOS", "0.32");
		secondaryResultsExpectedValues.put("HCT", "0.37");
		secondaryResultsExpectedValues.put("HGB", "164.9");
		secondaryResultsExpectedValues.put("LYMP", "4.4");
		secondaryResultsExpectedValues.put("MCV", "99.9");
		secondaryResultsExpectedValues.put("MONO", "0.7");
		secondaryResultsExpectedValues.put("NEU", "7.4");
		secondaryResultsExpectedValues.put("PLT", "449.9");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("WBC", "10.9");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "no-error");
		secondaryResultsExpectedErrors.put("EOS", "no-error");
        secondaryResultsExpectedErrors.put("HCT", "no-error");
        secondaryResultsExpectedErrors.put("HGB", "no-error");
        secondaryResultsExpectedErrors.put("LYMP", "no-error");
        secondaryResultsExpectedErrors.put("MCV", "no-error");
        secondaryResultsExpectedErrors.put("MONO", "no-error");
        secondaryResultsExpectedErrors.put("NEU", "no-error");
        secondaryResultsExpectedErrors.put("PLT", "no-error");
        secondaryResultsExpectedErrors.put("RBC", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("WBC", "no-error");
        
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage2 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage2, primaryResultsExpectedValues, primaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedALPError = "Alanine Transaminase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (ALT & ALP): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALT & ALP): "+actualALPErrorMsg);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualFOLErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedFOLError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualFOLErrorMsg);
		assertEquals(actualFOLErrorMsg, expectedFOLError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualFOLErrorMsg);
	}
	
	public void partialReportTC28() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("39.9", "Untestable – Insufficient (post-analytical)");
		goldReplacements.put("44", "Untestable – Insufficient (post-analytical)");
		goldReplacements.put("19.9", "Untestable – Insufficient (post-analytical)");
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("5.7", "Untestable – Insufficient (post-analytical)");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, soft_1407_Partial_Report_Locators.get_doctorsLetterTextAreaTims(), Duration.ofSeconds(10));
		//String doctorsLetter = soft_1407_Partial_Report_Locators.get_doctorsLetterTextAreaTims().getText();
		String doctorsLetter = soft_1407_Partial_Report_Locators.get_doctorsLetterTextAreaTims().getAttribute("value");
		
		String[] lines = doctorsLetter.split("\n");
		String actualFirstLine = (lines.length > 0) ? lines[0] : "";
		System.out.println("First Line: " + actualFirstLine);
		
		String actualSecondLine = (lines.length > 2) ? lines[2] : "";
		System.out.println("Second Line: " + actualSecondLine);
		
		String expectedFirstLine = "Please accept my apologies, the lab wasn’t able to process all results in your test. I’ve reviewed the available results from your test.";
		String expectedSecondLine = "For the results reported, everything looks good with your Energy Profile Test results.";
		
		assertEquals(actualFirstLine, expectedFirstLine, "First line mismatch");
		assertEquals(actualSecondLine, expectedSecondLine, "Second line mismatch");
		
		ExtentManager.getTest().log(Status.PASS, "First Line: " + actualFirstLine);
		ExtentManager.getTest().log(Status.PASS, "Second Line: " + actualSecondLine);
		
	}
	
	public void fullBloodResultPublishedReportGeneralHealth() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		soft_1405_Partial_Report_actions.uploadBloodResultsCsv("General_Health_Test_Gold.csv", health_assessment_locators.get_uploadBloodResultCsvInput(),
				"RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		soft_1405_Partial_Report_actions.uploadBloodResultsCsv("General_Health_Test_Lavender.csv", health_assessment_locators.get_uploadBloodResultCsvInput(),
				"RLB-SVW-0605", SOFT_1405_Partial_Report_Actions.Barcode2);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		WebWait.elementToBeClickable(driver, sh_locators.get_testReportSideMenu(), Duration.ofSeconds(20));
	    WebButton.clickButton(sh_locators.get_testReportSideMenu());
	    WebWait.elementToBeClickable(driver, sh_locators.get_ReadyForReviewBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_ReadyForReviewBtn());	
		
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), SOFT_1405_Partial_Report_Actions.Barcode1);
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
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), driver);
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), "1", driver);
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), driver);
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_glucoseGroupStatusDrp(), "1", driver);
		
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
	
	public void partialReportTC31() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLO-IBP-4769", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("0.32", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("0.37", "Untestable – Damaged/Empty/Not returned");
		lavenderReplacements.put("60", "Untestable – Sample too old");
		lavenderReplacements.put("4.4", "Untestable – Grossly haemolysed");
		lavenderReplacements.put("99.9", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("0.7", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("24", "Untestable – Misc (sample receipt)");
		lavenderReplacements.put("449.9", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("5.7", "Inhibitory");
		lavenderReplacements.put("10.9", "Untestable – Insufficient (post-analytical)");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.generalHealthGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.generalHealthLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
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
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_glucoseGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Insufficient");
		expectedValues.put("Eosinophils", "Insufficient");
		expectedValues.put("Haematocrit", "Untestable");
		expectedValues.put("Haemoglobin", "Untestable");
		expectedValues.put("Lymphocytes", "Haemolysed");
		expectedValues.put("Mean Cell Volume", "Clotted");
		expectedValues.put("Monocytes", "Clotted");
		expectedValues.put("Neutrophils", "Untestable");
		expectedValues.put("Platelet Count", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		expectedValues.put("White Blood Cells", "Insufficient");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("HCT", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Sample too old");
		secondaryResultsExpectedValues.put("LYMP", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("MCV", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("MONO", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("NEU", "Untestable – Misc (sample receipt)");
		secondaryResultsExpectedValues.put("PLT", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Insufficient (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable-insufficient-sample-receipt");
		secondaryResultsExpectedErrors.put("EOS", "untestable-insufficient-post-analytical");
        secondaryResultsExpectedErrors.put("HCT", "untestable-damaged-empty-not-returned");
        secondaryResultsExpectedErrors.put("HGB", "untestable–sample-too-old");
        secondaryResultsExpectedErrors.put("LYMP", "untestable–grossly-haemolysed");
        secondaryResultsExpectedErrors.put("MCV", "untestable-clotted-sample-receipt");
        secondaryResultsExpectedErrors.put("MONO", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("NEU", "untestable-misc-sample-receipt");
        secondaryResultsExpectedErrors.put("PLT", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "untestable-insufficient-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
	}
	
	public void partialReportTC32() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		goldReplacements.put("10.6", "Untestable – Clotted (post-analytical)");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLO-IBP-4769", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("21", "Untestable – Clotted (post-analytical)");
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.generalHealthGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.generalHealthLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);

		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Clotted");
		expectedValues.put("HbA1c", "Clotted");
		expectedValues.put("Alkaline Phosphatase", "Clotted");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("ALP", "Untestable – Clotted (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "untestable-clotted-post-analytical");
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-clotted-post-analytical");
        secondaryResultsExpectedErrors.put("ALP", "untestable-clotted-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedFBCError = "Full blood count & HbA1c could not be reported.";
		System.out.println("Error (Full blood count): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualFBCErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedALPError = "Alkaline Phosphatase could not be reported.";
		System.out.println("Error (ALP): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALPErrorMsg);
		
	}
	
	public void partialReportTC33() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();	
		lavenderReplacements.put("5.7", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("21", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("MLO-IBP-4769", SOFT_1405_Partial_Report_Actions.Barcode2);
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.generalHealthGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.generalHealthLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);

		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Red Blood Cell", "Untestable");
		expectedValues.put("HbA1c", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("RBC", "Untestable – Misc (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-misc-post-analytical");
        secondaryResultsExpectedErrors.put("RBC", "untestable-misc-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedFBCError = "Full blood count & HbA1c could not be reported.";
		System.out.println("Error (Full blood count): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualFBCErrorMsg);
		
	}
	
	public void partialReportTC18() throws InterruptedException, IOException {
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		
		soft_1405_Partial_Report_actions.generateBarcodeBatch("Barcode1", "Boots private label", "Gold", "2");
		soft_1405_Partial_Report_actions.generateBarcodeBatch("Barcode2", "Boots private label", "Lavender", "2");

		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(10));
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_createKitBtn(), Duration.ofSeconds(10));
		WebButton.clickButton(activate_test_kit_locators.get_createKitBtn());

		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Duration.ofSeconds(10));
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(),SOFT_1405_Partial_Report_Actions.Barcode1);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_secondaryBarcodeTxtForCreateKit(), Duration.ofSeconds(10));
		WebTextBox.sendInput(activate_test_kit_locators.get_secondaryBarcodeTxtForCreateKit(), SOFT_1405_Partial_Report_Actions.Barcode2);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_createBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_createBtn(), driver);
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_assignKitTypeHeaderMenu(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_assignKitTypeHeaderMenu(), driver);
		WebWait.waitForDOMLoad(driver, Duration.ofSeconds(20));
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_typeOfTestKitDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_typeOfTestKitDrp(), "Boots Energy Profile Test");
		Thread.sleep(2000);
		WebElement selectedOption = WebDropDown.getSelectedOption(driver,activate_test_kit_locators.get_typeOfTestKitDrp());
		System.out.println("Kit Type: "+selectedOption.getText());
		ExtentManager.getTest().log(Status.INFO, "Kit Type: "+selectedOption.getText());
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), SOFT_1405_Partial_Report_Actions.Barcode1);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_AssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_AssignBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		lavenderReplacements.put("0.05", "Inhibitory");
		lavenderReplacements.put("0.32", "Inhibitory");
		lavenderReplacements.put("0.37", "Inhibitory");
		lavenderReplacements.put("164.9", "Inhibitory");
		lavenderReplacements.put("4.4", "Inhibitory");
		lavenderReplacements.put("99.9", "Inhibitory");
		lavenderReplacements.put("0.7", "Inhibitory");
		lavenderReplacements.put("7.4", "Inhibitory");
		lavenderReplacements.put("449.9", "Inhibitory");
		lavenderReplacements.put("5.7", "Inhibitory");
		lavenderReplacements.put("10.9", "Inhibitory");
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_vitaminsMineralsGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_headerReportTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		
		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Basophils", "Untestable");
		expectedValues.put("Eosinophils", "Untestable");
		expectedValues.put("Haematocrit", "Untestable");
		expectedValues.put("Haemoglobin", "Untestable");
		expectedValues.put("Lymphocytes", "Untestable");
		expectedValues.put("Mean Cell Volume", "Untestable");
		expectedValues.put("Monocytes", "Untestable");
		expectedValues.put("Neutrophils", "Untestable");
		expectedValues.put("Platelet Count", "Untestable");
		expectedValues.put("Red Blood Cell", "Untestable");
		expectedValues.put("White Blood Cells", "Untestable");
		
		validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("BAS", "Inhibitory");
		secondaryResultsExpectedValues.put("EOS", "Inhibitory");
		secondaryResultsExpectedValues.put("HCT", "Inhibitory");
		secondaryResultsExpectedValues.put("HGB", "Inhibitory");
		secondaryResultsExpectedValues.put("LYMP", "Inhibitory");
		secondaryResultsExpectedValues.put("MCV", "Inhibitory");
		secondaryResultsExpectedValues.put("MONO", "Inhibitory");
		secondaryResultsExpectedValues.put("NEU", "Inhibitory");
		secondaryResultsExpectedValues.put("PLT", "Inhibitory");
		secondaryResultsExpectedValues.put("RBC", "Inhibitory");
		secondaryResultsExpectedValues.put("WBC", "Inhibitory");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("BAS", "inhibitory");
		secondaryResultsExpectedErrors.put("EOS", "inhibitory");
        secondaryResultsExpectedErrors.put("HCT", "inhibitory");
        secondaryResultsExpectedErrors.put("HGB", "inhibitory");
        secondaryResultsExpectedErrors.put("LYMP", "inhibitory");
        secondaryResultsExpectedErrors.put("MCV", "inhibitory");
        secondaryResultsExpectedErrors.put("MONO", "inhibitory");
        secondaryResultsExpectedErrors.put("NEU", "inhibitory");
        secondaryResultsExpectedErrors.put("PLT", "inhibitory");
        secondaryResultsExpectedErrors.put("RBC", "inhibitory");
        secondaryResultsExpectedErrors.put("WBC", "inhibitory");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		 
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Full blood count could not be reported.";
		System.out.println("Error (Full blood count): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (Full blood count): "+actualALTErrorMsg);
		
	}
	
	public void partialReportTC19() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Energy Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Female");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGC-YUA-9578", SOFT_1405_Partial_Report_Actions.Barcode1);
		goldReplacements.put("83.9", "Inhibitory");
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("MLQ-USY-4392", SOFT_1405_Partial_Report_Actions.Barcode2);
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		Thread.sleep(2000);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.energyProfileResultsLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(40));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), SOFT_1405_Partial_Report_Actions.Barcode1);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_testKitStatusTims(), Duration.ofSeconds(10));
		String kitStatus = soft_1405_Partial_Report_Locators.get_testKitStatusTims().getText();
		System.out.println("Kit Status (Tims): "+kitStatus);
		assertEquals(kitStatus, "error", "Kit Status Mismatch");
		ExtentManager.getTest().log(Status.PASS, "Kit Status: "+kitStatus);
		
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(60));
		WebWait.visibilityOfElement(driver, customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(customer_landing_actions.getViewTestBtn(SOFT_1405_Partial_Report_Actions.Barcode1), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_testKitStatusDashboard(), Duration.ofSeconds(20));
		String kitStatusDb = soft_1405_Partial_Report_Locators.get_testKitStatusDashboard().getText();
		System.out.println("Kit Status (Dashboard): " + kitStatusDb);
		assertEquals(kitStatusDb, "Rejected", "Kit Status Mismatch");
		ExtentManager.getTest().log(Status.PASS, "Kit Status (Dashboard): " + kitStatusDb);
	}
	
	public void vaidateBiomarkersPrimSecResultsPage(List<WebElement> biomarkerRows, Map<String, String> expectedValues, Map<String, String> expectedErrors) {
		
		SoftAssert softAssert = new SoftAssert();
		StringBuilder reportLogger = new StringBuilder();
		for(WebElement biomarkerRow : biomarkerRows) {
			String biomarkerName = biomarkerRow.findElement(By.xpath("./td[1]")).getText().trim();
			String biomarkerValue = biomarkerRow.findElement(By.xpath("./td[2]")).getText().trim();
			String biomarkerError = biomarkerRow.findElement(By.xpath("./td[5]")).getText().trim();
			
			System.out.println(biomarkerName+", "+biomarkerValue+", "+biomarkerError);
			reportLogger.append(biomarkerName+", "+biomarkerValue+", "+biomarkerError).append("<br>");
			
			if (expectedValues.containsKey(biomarkerName)) {
                String expectedValue = expectedValues.get(biomarkerName);
                String expectedError = expectedErrors.get(biomarkerName);

                softAssert.assertEquals(biomarkerValue, expectedValue, "Mismatch for biomarker value: " + biomarkerName);
                softAssert.assertEquals(biomarkerError, expectedError, "Mismatch for biomarker error: " + biomarkerName);
            } else {
                
                //softAssert.fail("Unexpected biomarker found: " + biomarkerName);
            }
        }
		softAssert.assertAll();
		ExtentManager.getTest().log(Status.PASS, reportLogger.toString());
	}
	
	public void validateBiomarkersReportDetails(Map<String, String> expectedValues, List<WebElement> biomarkerList) {

		SoftAssert softAssert = new SoftAssert();
		StringBuilder reportLogger = new StringBuilder(); 
	
		for(WebElement biomarker : biomarkerList) {
			String biomarkerNameTxt = biomarker.getText();
			String biomarkerOutput =biomarker.findElement(By.xpath("./following-sibling::td")).getText();
//			System.out.println("Biomarker: "+biomarkerNameTxt+", Value: "+biomarkerOutput);
//			reportLogger.append("Biomarker: "+biomarkerNameTxt+", Value: "+biomarkerOutput).append("<br>");
			 if (expectedValues.containsKey(biomarkerNameTxt)) {
				 System.out.println("Biomarker: "+biomarkerNameTxt+", Value: "+biomarkerOutput);
				 reportLogger.append("Biomarker: "+biomarkerNameTxt+", Value: "+biomarkerOutput).append("<br>");
		         String expectedValue = expectedValues.get(biomarkerNameTxt);

		            softAssert.assertEquals(biomarkerOutput, expectedValue, "Mismatch for biomarker: " + biomarkerNameTxt);
		           
		        } else {
		        	//softAssert.fail("Unexpected biomarker found: " + biomarkerNameTxt);
		        }
			 
		}
		
		ExtentManager.getTest().log(Status.PASS, reportLogger.toString());
		softAssert.assertAll();
		 
	}
}
