package Test.Tims.Partial_Report_Action_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Test.Dashboard.Locators_Class.Health_Assessment_Locators;
import Test.Tims.Partial_Report_Locators_Class.SOFT_1405_Partial_Report_Locators;
import Test.Tims.Partial_Report_Locators_Class.SOFT_1407_Partial_Report_Locators;
import Test.Tims.Partial_Report_Locators_Class.SOFT_1409_Partial_Report_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebScrollView;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class SOFT_1409_Partial_Report_Actions {
	
	public WebDriver driver;
	
	SOFT_1409_Partial_Report_Locators soft_1409_Partial_Report_Locators;
	SOFT_1405_Partial_Report_Actions soft_1405_Partial_Report_actions;
	SOFT_1405_Partial_Report_Locators soft_1405_Partial_Report_Locators;
	SOFT_1407_Partial_Report_Locators soft_1407_Partial_Report_Locators;
	Health_Assessment_Locators health_assessment_locators;
	SOFT_1407_Partial_Report_Actions soft_1407_Partial_Report_actions;
	
	public SOFT_1409_Partial_Report_Actions(WebDriver driver) {
		this.driver = driver;
		soft_1409_Partial_Report_Locators = new SOFT_1409_Partial_Report_Locators(driver);
		soft_1405_Partial_Report_actions = new SOFT_1405_Partial_Report_Actions(driver);
		soft_1405_Partial_Report_Locators = new SOFT_1405_Partial_Report_Locators(driver);
		health_assessment_locators = new Health_Assessment_Locators(driver);
		soft_1407_Partial_Report_actions = new SOFT_1407_Partial_Report_Actions(driver);
		soft_1407_Partial_Report_Locators = new SOFT_1407_Partial_Report_Locators(driver);
	}
	
	public void partialReportTC1() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Grossly haemolysed");
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
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList(), Duration.ofSeconds(10));
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Haemolysed");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Grossly haemolysed");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "Untestable – Grossly haemolysed");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), "Glucose");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
	}
	
	public void partialReportTC15() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.5", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("10.6", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("14", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("0.32", "Untestable – Clotted (sample receipt)");
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
//		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), Duration.ofSeconds(10));
//		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), driver);
//		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), Duration.ofSeconds(10));
//		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_liverHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), "1", driver);
//		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
//		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
//		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
//		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList(), Duration.ofSeconds(10));
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Alanine Transaminase", "Clotted");
		expectedValues.put("Alkaline Phosphatase", "Clotted");
		expectedValues.put("Gamma-Glutamyl Transferase", "Clotted");
		expectedValues.put("Eosinophils", "Clotted");
		expectedValues.put("HbA1c", "Clotted");
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Full blood count");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("ALP", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("ALT", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("GGT", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("EOS", "Untestable – Clotted (sample receipt)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("ALP", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("ALT", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("GGT", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("EOS", "untestable-clotted-sample-receipt");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);

		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), "Glucose");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "Full blood count & HbA1c could not be reported.";
		System.out.println("Error (FBC & HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FBC & HbA1c): "+actualErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedFBCError = "Alanine Transaminase, Alkaline Phosphatase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (ALP, ALT & GGT): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALP, ALT & GGT): "+actualFBCErrorMsg);
	}
	
	public void partialReportTC18() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Erectile Dysfunction Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGB-GHV-9078", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("40.9", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("MLD-ZVK-3219", SOFT_1405_Partial_Report_Actions.Barcode2);
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.erectileDysfunctionGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.erectileDysfunctionLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(20));
		System.out.println("Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Result upload: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.assignDoctor();
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_overallStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_overallStatusDrp(), "1", driver);

		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportHormonesBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportHormonesBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_hormonesGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_hormonesGroupStatusDrp(), "1", driver);

		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		WebScrollView.scrollToElement(driver, soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn());
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportSaveChangesBtn(), driver);
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_toasterMsg(), Duration.ofSeconds(30));
		assertTrue(soft_1405_Partial_Report_Locators.get_toasterMsg().isDisplayed(), "Report not Published");
		System.out.println("Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+soft_1405_Partial_Report_Locators.get_toasterMsg().getText());
		
		soft_1405_Partial_Report_actions.testResultInfoPagevalidation();
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_headerReportTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList(), Duration.ofSeconds(10));
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Insufficient");
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Insufficient (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-insufficient-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);

		soft_1405_Partial_Report_actions.dashboardViewReport();
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), "Glucose");
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
	}
}
