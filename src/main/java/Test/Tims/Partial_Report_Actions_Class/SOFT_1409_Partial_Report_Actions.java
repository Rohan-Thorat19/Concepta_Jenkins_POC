package Test.Tims.Partial_Report_Actions_Class;

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
	
	public void partialReportTC2() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("10.9", "Untestable – Misc (post-analytical)");
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

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Untestable");
		expectedValues.put("White Blood Cells", "Untestable");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full blood count");

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("WBC", "Untestable – Misc (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-misc-post-analytical");
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
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), "Full blood count");

		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedFBCError = "Full blood count could not be reported.";
		System.out.println("Error (FBC): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FBC): "+actualFBCErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
	}
	
	public void partialReportTC3() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.5", "Untestable – Grossly haemolysed");
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
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Haemolysed");
		expectedValues.put("Alanine Transaminase", "Haemolysed");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Grossly haemolysed");
		secondaryResultsExpectedValues.put("ALT", "Untestable – Grossly haemolysed");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable–grossly-haemolysed");
		secondaryResultsExpectedErrors.put("ALT", "untestable–grossly-haemolysed");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALTError = "Alanine Transaminase could not be reported.";
		System.out.println("Error (ALT): "+actualALTErrorMsg);
		assertEquals(actualALTErrorMsg, expectedALTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALT): "+actualALTErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
	}
	
	public void partialReportTC4() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("14", "Untestable – Insufficient (sample receipt)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Insufficient (sample receipt)");
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
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Insufficient");
		expectedValues.put("Gamma-Glutamyl Transferase", "Insufficient");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("GGT", "Untestable – Insufficient (sample receipt)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-insufficient-sample-receipt");
		secondaryResultsExpectedErrors.put("GGT", "untestable-insufficient-sample-receipt");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualGGTErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedGGTError = "Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (GGT): "+actualGGTErrorMsg);
		assertEquals(actualGGTErrorMsg, expectedGGTError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (GGT): "+actualGGTErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
	}
	
	public void partialReportTC5() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.6", "Untestable – Damaged/Empty/Not returned");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Damaged/Empty/Not returned");
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
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Untestable");
		expectedValues.put("Alkaline Phosphatase", "Untestable");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Damaged/Empty/Not returned");
		secondaryResultsExpectedValues.put("ALP", "Untestable – Damaged/Empty/Not returned");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-damaged-empty-not-returned");
		secondaryResultsExpectedErrors.put("ALP", "untestable-damaged-empty-not-returned");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alkaline Phosphatase could not be reported.";
		System.out.println("Error (ALP): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALP): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
	}
	
	public void partialReportTC6() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.5", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("14", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Clotted (sample receipt)");
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
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Clotted");
		expectedValues.put("Alanine Transaminase", "Clotted");
		expectedValues.put("Gamma-Glutamyl Transferase", "Clotted");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("ALT", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("GGT", "Untestable – Clotted (sample receipt)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("ALT", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("GGT", "untestable-clotted-sample-receipt");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alanine Transaminase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (ALT & GGT): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALT & GGT): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
	}
	
	public void partialReportTC7() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.6", "Inhibitory");
		goldReplacements.put("14", "Inhibitory");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Inhibitory");
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
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Untestable");
		expectedValues.put("Alkaline Phosphatase", "Untestable");
		expectedValues.put("Gamma-Glutamyl Transferase", "Untestable");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Inhibitory");
		secondaryResultsExpectedValues.put("ALP", "Inhibitory");
		secondaryResultsExpectedValues.put("GGT", "Inhibitory");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "inhibitory");
		secondaryResultsExpectedErrors.put("ALP", "inhibitory");
		secondaryResultsExpectedErrors.put("GGT", "inhibitory");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alkaline Phosphatase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (ALP & GGT): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALP & GGT): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
	}
	
	public void partialReportTC8() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.6", "Untestable – Misc (post-analytical)");
		goldReplacements.put("10.5", "Untestable – Misc (post-analytical)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("60.2", "Untestable – Misc (post-analytical)");
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
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Untestable");
		expectedValues.put("Alkaline Phosphatase", "Untestable");
		expectedValues.put("Alanine Transaminase", "Untestable");
		expectedValues.put("Haemoglobin", "Untestable");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("ALP", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("ALT", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Misc (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-misc-post-analytical");
		secondaryResultsExpectedErrors.put("ALP", "untestable-misc-post-analytical");
		secondaryResultsExpectedErrors.put("ALT", "untestable-misc-post-analytical");
		secondaryResultsExpectedErrors.put("HGB", "untestable-misc-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alkaline Phosphatase & Alanine Transaminase could not be reported.";
		System.out.println("Error (ALP & ALT): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALP & ALT): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedFBCError = "Full blood count could not be reported.";
		System.out.println("Error (FBC): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FBC): "+actualFBCErrorMsg);
	}
	
	public void partialReportTC9() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.5", "Untestable – Misc (post-analytical)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Misc (post-analytical)");
		lavenderReplacements.put("60.2", "Untestable – Misc (post-analytical)");
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
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");

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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Untestable");
		expectedValues.put("Alanine Transaminase", "Untestable");
		expectedValues.put("Haemoglobin", "Untestable");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("ALT", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Misc (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-misc-post-analytical");
		secondaryResultsExpectedErrors.put("ALT", "untestable-misc-post-analytical");
		secondaryResultsExpectedErrors.put("HGB", "untestable-misc-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alanine Transaminase could not be reported.";
		System.out.println("Error (ALT): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALT): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedFBCError = "Full blood count could not be reported.";
		System.out.println("Error (FBC): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FBC): "+actualFBCErrorMsg);
	}
	
	public void partialReportTC10() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("14", "Untestable – Insufficient (post-analytical)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("60.2", "Untestable – Insufficient (post-analytical)");
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
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full Blood Count");
		
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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Insufficient");
		expectedValues.put("Gamma-Glutamyl Transferase", "Insufficient");
		expectedValues.put("Haemoglobin", "Insufficient");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("GGT", "Untestable – Insufficient (post-analytical)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Insufficient (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-insufficient-post-analytical");
		secondaryResultsExpectedErrors.put("GGT", "untestable-insufficient-post-analytical");
		secondaryResultsExpectedErrors.put("HGB", "untestable-insufficient-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (GGT): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (GGT): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedFBCError = "Full blood count could not be reported.";
		System.out.println("Error (FBC): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FBC): "+actualFBCErrorMsg);
	}
	
	public void partialReportTC11() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.6", "Untestable – Clotted (post-analytical)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Clotted (post-analytical)");
		lavenderReplacements.put("60.2", "Untestable – Clotted (post-analytical)");
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
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full Blood Count");
		
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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Clotted");
		expectedValues.put("Alkaline Phosphatase", "Clotted");
		expectedValues.put("Haemoglobin", "Clotted");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("ALP", "Untestable – Clotted (post-analytical)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Clotted (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-clotted-post-analytical");
		secondaryResultsExpectedErrors.put("ALP", "untestable-clotted-post-analytical");
		secondaryResultsExpectedErrors.put("HGB", "untestable-clotted-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alkaline Phosphatase could not be reported.";
		System.out.println("Error (ALP): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALP): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedFBCError = "Full blood count could not be reported.";
		System.out.println("Error (FBC): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FBC): "+actualFBCErrorMsg);
	}
	
	public void partialReportTC12() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.6", "Untestable – Misc (post-analytical)");
		goldReplacements.put("10.5", "Untestable – Misc (post-analytical)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
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
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");
		
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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Untestable");
		expectedValues.put("Alkaline Phosphatase", "Untestable");
		expectedValues.put("Alanine Transaminase", "Untestable");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("ALP", "Untestable – Misc (post-analytical)");
		secondaryResultsExpectedValues.put("ALT", "Untestable – Misc (post-analytical)");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-misc-post-analytical");
		secondaryResultsExpectedErrors.put("ALP", "untestable-misc-post-analytical");
		secondaryResultsExpectedErrors.put("ALT", "untestable-misc-post-analytical");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alkaline Phosphatase & Alanine Transaminase could not be reported.";
		System.out.println("Error (ALP & ALT): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALP & ALT): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
		
	}
	
	public void partialReportTC13() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.6", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("10.5", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("14", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Clotted (sample receipt)");
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
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_fullBloodCountGroupStatusDrp(), "1", driver);
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");
		
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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Clotted");
		expectedValues.put("Alkaline Phosphatase", "Clotted");
		expectedValues.put("Alanine Transaminase", "Clotted");
		expectedValues.put("Gamma-Glutamyl Transferase", "Clotted");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("ALP", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("ALT", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("GGT", "Untestable – Clotted (sample receipt)");
		
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("ALP", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("ALT", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("GGT", "untestable-clotted-sample-receipt");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alkaline Phosphatase, Alanine Transaminase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (ALP, ALT & GGT): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALP, ALT & GGT): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
		
	}
	
	public void partialReportTC14() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.5", "Untestable – Insufficient (sample receipt)");
		goldReplacements.put("14", "Untestable – Insufficient (sample receipt)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Insufficient (sample receipt)");
		lavenderReplacements.put("60.2", "Untestable – Insufficient (sample receipt)");
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
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full Blood Count");

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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Insufficient");
		expectedValues.put("Haemoglobin", "Insufficient");
		expectedValues.put("Alanine Transaminase", "Insufficient");
		expectedValues.put("Gamma-Glutamyl Transferase", "Insufficient");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("ALT", "Untestable – Insufficient (sample receipt)");
		secondaryResultsExpectedValues.put("GGT", "Untestable – Insufficient (sample receipt)");
		
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-insufficient-sample-receipt");
		secondaryResultsExpectedErrors.put("HGB", "untestable-insufficient-sample-receipt");
		secondaryResultsExpectedErrors.put("ALT", "untestable-insufficient-sample-receipt");
		secondaryResultsExpectedErrors.put("GGT", "untestable-insufficient-sample-receipt");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alanine Transaminase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (ALT & GGT): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALT & GGT): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedFBCError = "Full blood count could not be reported.";
		System.out.println("Error (FBC): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FBC): "+actualFBCErrorMsg);
		
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
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportKidneyHealthBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_kidneyHealthGroupStatusDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportCholesterolBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_cholesterolGroupStatusDrp(), "1", driver);
		
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
	
	public void partialReportTC16() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("General Health Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("10.6", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("14", "Untestable – Clotted (sample receipt)");
		goldReplacements.put("RGO-ENF-9429", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("21", "Untestable – Clotted (sample receipt)");
		lavenderReplacements.put("60.2", "Untestable – Clotted (sample receipt)");
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
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportLiverHealthBtn(), "Liver Health");
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportFullBloodCountBtn(), "Full Blood Count");

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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails(), Duration.ofSeconds(10));
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("HbA1c", "Clotted");
		expectedValues.put("Haemoglobin", "Clotted");
		expectedValues.put("Alkaline Phosphatase", "Clotted");
		expectedValues.put("Gamma-Glutamyl Transferase", "Clotted");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_liverHealthBiomarkerListReportDetails());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_lavenderFullBloodCountBiomarkerList());

		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("HGB", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("ALP", "Untestable – Clotted (sample receipt)");
		secondaryResultsExpectedValues.put("GGT", "Untestable – Clotted (sample receipt)");
		
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("HGB", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("ALP", "untestable-clotted-sample-receipt");
		secondaryResultsExpectedErrors.put("GGT", "untestable-clotted-sample-receipt");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> priamryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(priamryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsTestKitsSecondaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
	
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> secondaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_secondaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(secondaryBiomarkerRowsPage1, secondaryResultsExpectedValues, secondaryResultsExpectedErrors);
		
		WebWait.elementToBeClickable(driver, soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1407_Partial_Report_Locators.get_timsSecondaryBarcodeResultsNavForwardBtn(), driver);
		
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)")), Duration.ofSeconds(10));
		List<WebElement> biomarkerRowsPage2 = driver.findElements(By.xpath("(//table[@id='secondary-test-kit-result-table']/tbody//tr)"));
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(biomarkerRowsPage2, secondaryResultsExpectedValues, secondaryResultsExpectedErrors)	;
		soft_1405_Partial_Report_actions.dashboardViewReport();
	
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_liverHealthHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualALPErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedALPError = "Alkaline Phosphatase & Gamma-Glutamyl Transferase could not be reported.";
		System.out.println("Error (ALP & GGT): "+actualALPErrorMsg);
		assertEquals(actualALPErrorMsg, expectedALPError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (ALP & GGT): "+actualALPErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_glucoseHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedError = "HbA1c could not be reported.";
		System.out.println("Error (HbA1c): "+actualErrorMsg);
		assertEquals(actualErrorMsg, expectedError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (HbA1c): "+actualErrorMsg);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_fullBloodCountHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError(), Duration.ofSeconds(10));
		String actualFBCErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError().getText();
		String expectedFBCError = "Full blood count could not be reported.";
		System.out.println("Error (FBC): "+actualFBCErrorMsg);
		assertEquals(actualFBCErrorMsg, expectedFBCError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FBC): "+actualFBCErrorMsg);
		
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
	
	public void partialReportTC17() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Weight Management Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("4.9", "Inhibitory");
		goldReplacements.put("MGR-VXG-1223", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("40.9", "Inhibitory");
		lavenderReplacements.put("MLK-GHI-3405", SOFT_1405_Partial_Report_Actions.Barcode2);
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.weightManagementGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.weightManagementLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
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
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_testReportThyroidProfileBtn(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByIndex(soft_1405_Partial_Report_Locators.get_thyroidProfileGroupStatusDrp(), "1", driver);

		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportVitaminsMineralsBtn(), "Vitamins & Minerals");
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
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_vitaminsMineralsBiomarkerList(), Duration.ofSeconds(10));

		Map<String, String> expectedValues = new HashMap<>();
		expectedValues.put("Folate", "Untestable");
		expectedValues.put("HbA1c", "Untestable");
		
		soft_1405_Partial_Report_actions.assertInvisibility(soft_1405_Partial_Report_Locators.get_testReportGlucoseBtn(), "Glucose");
		
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_vitaminsMineralsBiomarkerList());
		soft_1407_Partial_Report_actions.validateBiomarkersReportDetails(expectedValues, soft_1407_Partial_Report_Locators.get_glucoseBiomarkerList());

		Map<String, String> primaryResultsExpectedValues = new HashMap<>();
		primaryResultsExpectedValues.put("FOL", "Inhibitory");
		
		Map<String, String> primaryResultsExpectedErrors = new HashMap<>();
		primaryResultsExpectedErrors.put("FOL", "inhibitory");
		
		Map<String, String> secondaryResultsExpectedValues = new HashMap<>();
		secondaryResultsExpectedValues.put("HBA1c", "Inhibitory");
		
		Map<String, String> secondaryResultsExpectedErrors = new HashMap<>();
		secondaryResultsExpectedErrors.put("HBA1c", "inhibitory");
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestReportInfoTab(), driver);
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsViewTestKitHypLnk(), driver);
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_timsTestKitsPrimaryBarcodeResultsTab(), driver);
		Thread.sleep(2000);
		WebWait.visibilityListOfElements(driver, soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows(), Duration.ofSeconds(10));
		List<WebElement> primaryBiomarkerRowsPage1 = soft_1407_Partial_Report_Locators.get_primaryResultsFullBloodCountBiomarkerRows();
		soft_1407_Partial_Report_actions.vaidateBiomarkersPrimSecResultsPage(primaryBiomarkerRowsPage1, primaryResultsExpectedValues, primaryResultsExpectedErrors);

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
		
		WebWait.elementToBeClickable(driver, soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(soft_1405_Partial_Report_Locators.get_vitaminsMineralsHealthAreaBtn(), driver);
		
		WebWait.visibilityOfElement(driver, soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1(), Duration.ofSeconds(10));
		String actualFolateErrorMsg = soft_1405_Partial_Report_Locators.get_dashboardCouldNotBeReportedError1().getText();
		String expectedFolateError = "Folate could not be reported.";
		System.out.println("Error (FOL): "+actualFolateErrorMsg);
		assertEquals(actualFolateErrorMsg, expectedFolateError, "Error message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Error (FOL): "+actualFolateErrorMsg);
	}
	
	public void partialReportTC19() throws InterruptedException, IOException {
		soft_1405_Partial_Report_actions.generateDoubleBarcode("Heart Profile Test", "Gold", "Lavender");
		soft_1405_Partial_Report_actions.activateTestKitDoubleBarcode("Male");
		soft_1405_Partial_Report_actions.markKitAsReceived("Double");
		
		Map<String,String> goldReplacements = new HashMap<>();
		goldReplacements.put("MGS-VXN-4424", SOFT_1405_Partial_Report_Actions.Barcode1);
		
		Map<String,String> lavenderReplacements = new HashMap<>();
		lavenderReplacements.put("40.9", "Untestable – Insufficient (post-analytical)");
		lavenderReplacements.put("MLN-TOW-3131", SOFT_1405_Partial_Report_Actions.Barcode2);
		
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.heartProfileGoldCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), goldReplacements);
		soft_1405_Partial_Report_actions.uploadBloodResultCsvMultipleReplacements(driver, WebCommonPath.heartProfileLavenderCsv, health_assessment_locators.get_uploadBloodResultCsvInput(), lavenderReplacements);
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
//		
	}
	
}
