package Test.Tims.Partial_Report_Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Random;
import java.io.IOException;
import java.time.Duration;
import Wrappers.CSVUploaderWithTextReplacement;
import Wrappers.ReadGmail;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;
import initializer.ExtentManager;
import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import com.aventstack.extentreports.Status;

import Test.Tims.Partial_Report_Locators_Class.SOFT_1366_Partial_Report_Locators;

public class SOFT_1366_Partial_Report_Actions extends BaseClass {

	public WebDriver driver;
	SOFT_1366_Partial_Report_Locators test_1366_locators;

	public SOFT_1366_Partial_Report_Actions(WebDriver driver) {
		this.driver = driver;
		test_1366_locators = new SOFT_1366_Partial_Report_Locators(driver);

	}

	public void publishKitAndCheckStatusForEnergyProfileForAllOptionsEnergyProfile() throws InterruptedException {
		WebButton.clickButton(test_1366_locators.get_testReportSideMenuItem());
		WebButton.clickButton(test_1366_locators.get_readyForReviewBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_firstIDItem(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_firstIDItem());
		WebButton.clickButton(test_1366_locators.get_assignBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_assignBtnInAlertBox(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_assignBtnInAlertBox());

		Thread.sleep(3000);
		WebButton.JsclickButton(test_1366_locators.get_reportTabBtn(), driver);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_generalBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_generalBtn());
		WebButton.clickButton(test_1366_locators.get_generalBtn());
		WebDropDown.selectByText(test_1366_locators.get_overallStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_liverHealthBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_liverHealthBtn());
		WebButton.clickButton(test_1366_locators.get_liverHealthBtn());
		WebDropDown.selectByText(test_1366_locators.get_liverHealthGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_kidneyHealthBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_kidneyHealthBtn());
		WebButton.clickButton(test_1366_locators.get_kidneyHealthBtn());
		WebDropDown.selectByText(test_1366_locators.get_kidneyGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_thyroidProfileBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_thyroidProfileBtn());
		WebButton.clickButton(test_1366_locators.get_thyroidProfileBtn());
		WebDropDown.selectByText(test_1366_locators.get_thyroidGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_vitaminsAndMineralsBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_vitaminsAndMineralsBtn());
		WebButton.clickButton(test_1366_locators.get_vitaminsAndMineralsBtn());
		WebDropDown.selectByText(test_1366_locators.get_vitaminGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_fullBloodCountBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_fullBloodCountBtn());
		WebButton.clickButton(test_1366_locators.get_fullBloodCountBtn());
		WebDropDown.selectByText(test_1366_locators.get_bloodCountGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, test_1366_locators.get_saveChangesBtn());
		WebButton.clickButton(test_1366_locators.get_saveChangesBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_publishBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_publishBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_yesAlertBtnn(), Duration.ofSeconds(60));
		Thread.sleep(3000);
		WebButton.clickButton(test_1366_locators.get_yesAlertBtnn());
		Thread.sleep(5000);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_testReportSideMenuItem(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_testReportSideMenuItem());
		WebButton.clickButton(test_1366_locators.get_testReportSideMenuItem());
		Thread.sleep(3000);
		WebButton.clickButton(test_1366_locators.get_resultPublishedBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_viewReportID(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_viewReportID());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_liverHealthOption(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_liverHealthOption());

		WebWait.visibilityOfElement(driver, test_1366_locators.get_allOptionDisplayed(), Duration.ofSeconds(30));
		Assert.assertTrue(test_1366_locators.get_allOptionDisplayed().isDisplayed(), "All Options are not visible");

	}

	public void publishKitAndCheckStatusForEnergyProfileForAllOptionsGeneralHealthTest() throws InterruptedException {
		WebButton.clickButton(test_1366_locators.get_testReportSideMenuItem());
		WebButton.clickButton(test_1366_locators.get_readyForReviewBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_firstIDItem(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_firstIDItem());
		WebButton.clickButton(test_1366_locators.get_assignBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_assignBtnInAlertBox(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_assignBtnInAlertBox());

		Thread.sleep(3000);
		WebButton.JsclickButton(test_1366_locators.get_reportTabBtn(), driver);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_generalBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_generalBtn());
		WebButton.clickButton(test_1366_locators.get_generalBtn());
		WebDropDown.selectByText(test_1366_locators.get_overallStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_liverHealthBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_liverHealthBtn());
		WebButton.clickButton(test_1366_locators.get_liverHealthBtn());
		WebDropDown.selectByText(test_1366_locators.get_liverHealthGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_kidneyHealthBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_kidneyHealthBtn());
		WebButton.clickButton(test_1366_locators.get_kidneyHealthBtn());
		WebDropDown.selectByText(test_1366_locators.get_kidneyGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_cholesterolBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_cholesterolBtn());
		WebButton.clickButton(test_1366_locators.get_cholesterolBtn());
		WebDropDown.selectByText(test_1366_locators.get_cholesterolGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_fullBloodCountBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_fullBloodCountBtn());
		WebButton.clickButton(test_1366_locators.get_fullBloodCountBtn());
		WebDropDown.selectByText(test_1366_locators.get_bloodCountGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_glucoseBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_glucoseBtn());
		WebButton.clickButton(test_1366_locators.get_glucoseBtn());
		WebDropDown.selectByText(test_1366_locators.get_glucoseGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, test_1366_locators.get_saveChangesBtn());
		WebButton.clickButton(test_1366_locators.get_saveChangesBtn());
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_publishBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_publishBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_yesAlertBtnn(), Duration.ofSeconds(60));
		Thread.sleep(3000);
		WebButton.clickButton(test_1366_locators.get_yesAlertBtnn());
		Thread.sleep(5000);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_testReportSideMenuItem(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_testReportSideMenuItem());
		WebButton.clickButton(test_1366_locators.get_testReportSideMenuItem());
		Thread.sleep(3000);
		WebButton.clickButton(test_1366_locators.get_resultPublishedBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_viewReportID(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_viewReportID());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_liverHealthOption(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_liverHealthOption());

		WebWait.visibilityOfElement(driver, test_1366_locators.get_allOptionDisplayed(), Duration.ofSeconds(30));
		Assert.assertTrue(test_1366_locators.get_allOptionDisplayed().isDisplayed(), "All Options are not visible");

	}

	public void autoPopulationOfAdditionalDefaultContent() throws InterruptedException {
		WebButton.clickButton(test_1366_locators.get_testReportSideMenuItem());
		WebButton.clickButton(test_1366_locators.get_readyForReviewBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_firstIDItem(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_firstIDItem());
		WebButton.clickButton(test_1366_locators.get_assignBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_assignBtnInAlertBox(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_assignBtnInAlertBox());

		Thread.sleep(3000);
		WebButton.JsclickButton(test_1366_locators.get_reportTabBtn(), driver);

		WebWait.visibilityOfElement(driver, test_1366_locators.get_generalBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_generalBtn());
		WebButton.clickButton(test_1366_locators.get_generalBtn());
		WebDropDown.selectByText(test_1366_locators.get_overallStatusDrp(), "Some borderline result");
		WebWait.visibilityOfElement(driver, test_1366_locators.get_Doctors_Letter(), Duration.ofSeconds(30));
		Assert.assertTrue(test_1366_locators.get_Doctors_Letter().isDisplayed(),
				"Does not populated the Default Doctors Letter");

	}

	public void publishKitAndCheckStatusForEnergyProfile(String Scenario) throws InterruptedException {
		WebButton.clickButton(test_1366_locators.get_testReportSideMenuItem());
		WebButton.clickButton(test_1366_locators.get_readyForReviewBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_firstIDItem(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_firstIDItem());
		WebButton.clickButton(test_1366_locators.get_assignBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_assignBtnInAlertBox(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_assignBtnInAlertBox());

		Thread.sleep(3000);
		WebButton.JsclickButton(test_1366_locators.get_reportTabBtn(), driver);

		WebWait.visibilityOfElement(driver, test_1366_locators.get_generalBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_generalBtn());
		WebButton.clickButton(test_1366_locators.get_generalBtn());
		WebDropDown.selectByText(test_1366_locators.get_overallStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_kidneyHealthBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_kidneyHealthBtn());
		WebButton.clickButton(test_1366_locators.get_kidneyHealthBtn());
		WebDropDown.selectByText(test_1366_locators.get_kidneyGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_thyroidProfileBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_thyroidProfileBtn());
		WebButton.clickButton(test_1366_locators.get_thyroidProfileBtn());
		WebDropDown.selectByText(test_1366_locators.get_thyroidGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_vitaminsAndMineralsBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_vitaminsAndMineralsBtn());
		WebButton.clickButton(test_1366_locators.get_vitaminsAndMineralsBtn());
		WebDropDown.selectByText(test_1366_locators.get_vitaminGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_fullBloodCountBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_fullBloodCountBtn());
		WebButton.clickButton(test_1366_locators.get_fullBloodCountBtn());
		WebDropDown.selectByText(test_1366_locators.get_bloodCountGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, test_1366_locators.get_saveChangesBtn());
		WebButton.clickButton(test_1366_locators.get_saveChangesBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_publishBtn(), Duration.ofSeconds(30));
		Thread.sleep(5000);
		WebButton.clickButton(test_1366_locators.get_publishBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_yesAlertBtnn(), Duration.ofSeconds(60));
		Thread.sleep(3000);
		WebButton.clickButton(test_1366_locators.get_yesAlertBtnn());
		Thread.sleep(5000);

		WebWait.visibilityOfElement(driver, test_1366_locators.get_testReportSideMenuItem(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_testReportSideMenuItem());
		WebButton.clickButton(test_1366_locators.get_testReportSideMenuItem());
		Thread.sleep(3000);
		WebButton.clickButton(test_1366_locators.get_resultPublishedBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_viewReportID(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_viewReportID());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_liverHealthOption(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_liverHealthOption());

		switch (Scenario) {
		case "ALT_GGT_ALP_sample_receipt":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALT_GGT_ALP_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALT_GGT_ALP_Text().isDisplayed(),
					"ALT_GGT_ALP_Text is not visible");
			break;

		case "ALT_GGT_ALP_post_analytical":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALT_GGT_ALP_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALT_GGT_ALP_Text().isDisplayed(),
					"ALT_GGT_ALP_Text is not visible");
			break;

		case "ALT_GGT_ALP_damaged":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALT_GGT_ALP_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALT_GGT_ALP_Text().isDisplayed(),
					"ALT_GGT_ALP_Text is not visible");
			break;

		case "ALT_Text":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALT_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALT_Text().isDisplayed(), "ALT Text is not visible");
			break;

		case "GGT_Text":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_GGT_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_GGT_Text().isDisplayed(), "GGT Text is not visible");
			break;

		case "ALP_Text":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALP_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALP_Text().isDisplayed(), "ALP Text is not visible");
			break;

		case "ALT_GGT_Inhibitory":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALT_GGT_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALT_GGT_Text().isDisplayed(), "ALT_GGT Text is not visible");
			break;

		case "ALT_ALP_Untestable":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALT_ALP_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALT_ALP_Text().isDisplayed(), "ALT_GGT Text is not visible");
			break;

		case "ALP_GGT_Inhibitory":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALP_GGT_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALP_GGT_Text().isDisplayed(), "ALT_GGT Text is not visible");
			break;

		default:
			System.out.println("No matching scenario found, using empty replacements");
			break;
		}
	}

	public void publishKitAndCheckStatusForGeneralHealthProfile(String Scenario) throws InterruptedException {
		WebButton.clickButton(test_1366_locators.get_testReportSideMenuItem());
		WebButton.clickButton(test_1366_locators.get_readyForReviewBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_firstIDItem(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_firstIDItem());
		WebButton.clickButton(test_1366_locators.get_assignBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_assignBtnInAlertBox(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_assignBtnInAlertBox());

		Thread.sleep(3000);
		WebButton.JsclickButton(test_1366_locators.get_reportTabBtn(), driver);

		WebWait.visibilityOfElement(driver, test_1366_locators.get_generalBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_generalBtn());
		WebButton.clickButton(test_1366_locators.get_generalBtn());
		WebDropDown.selectByText(test_1366_locators.get_overallStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_kidneyHealthBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_kidneyHealthBtn());
		WebButton.clickButton(test_1366_locators.get_kidneyHealthBtn());
		WebDropDown.selectByText(test_1366_locators.get_kidneyGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_cholesterolBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_cholesterolBtn());
		WebButton.clickButton(test_1366_locators.get_cholesterolBtn());
		WebDropDown.selectByText(test_1366_locators.get_cholesterolGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_fullBloodCountBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_fullBloodCountBtn());
		WebButton.clickButton(test_1366_locators.get_fullBloodCountBtn());
		WebDropDown.selectByText(test_1366_locators.get_bloodCountGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_glucoseBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_glucoseBtn());
		WebButton.clickButton(test_1366_locators.get_glucoseBtn());
		WebDropDown.selectByText(test_1366_locators.get_glucoseGroupStatusDrp(), "Some borderline result");
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, test_1366_locators.get_saveChangesBtn());
		WebButton.clickButton(test_1366_locators.get_saveChangesBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_publishBtn(), Duration.ofSeconds(30));
		Thread.sleep(5000);
		WebButton.clickButton(test_1366_locators.get_publishBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_yesAlertBtnn(), Duration.ofSeconds(60));
		Thread.sleep(3000);
		WebButton.clickButton(test_1366_locators.get_yesAlertBtnn());
		Thread.sleep(5000);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, test_1366_locators.get_testReportSideMenuItem(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, test_1366_locators.get_testReportSideMenuItem());
		WebButton.clickButton(test_1366_locators.get_testReportSideMenuItem());
		Thread.sleep(3000);
		WebButton.clickButton(test_1366_locators.get_resultPublishedBtn());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_viewReportID(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_viewReportID());
		WebWait.visibilityOfElement(driver, test_1366_locators.get_liverHealthOption(), Duration.ofSeconds(30));
		WebButton.clickButton(test_1366_locators.get_liverHealthOption());

		switch (Scenario) {
		case "ALT_GGT_ALP_sample_receipt":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALT_GGT_ALP_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALT_GGT_ALP_Text().isDisplayed(),
					"ALT_GGT_ALP_Text is not visible");
			break;

		case "ALT_Text":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALT_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALT_Text().isDisplayed(), "ALT Text is not visible");
			break;

		case "GGT_Text":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_GGT_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_GGT_Text().isDisplayed(), "GGT Text is not visible");
			break;

		case "ALP_Text":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALP_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALP_Text().isDisplayed(), "ALP Text is not visible");
			break;

		case "ALT_GGT_Inhibitory":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALT_GGT_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALT_GGT_Text().isDisplayed(), "ALT_GGT Text is not visible");
			break;

		case "ALT_ALP_Untestable":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALT_ALP_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALT_ALP_Text().isDisplayed(), "ALT_GGT Text is not visible");
			break;

		case "ALP_GGT_Inhibitory":
			WebWait.visibilityOfElement(driver, test_1366_locators.get_ALP_GGT_Text(), Duration.ofSeconds(30));
			Assert.assertTrue(test_1366_locators.get_ALP_GGT_Text().isDisplayed(), "ALT_GGT Text is not visible");
			break;

		default:
			System.out.println("No matching scenario found, using empty replacements");
			break;
		}
	}
}