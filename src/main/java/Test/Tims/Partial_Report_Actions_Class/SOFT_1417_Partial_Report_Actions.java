package Test.Tims.Partial_Report_Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;
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
import Test.Tims.Partial_Report_Locators_Class.SOFT_1417_Partial_Report_Locators;
import Test.Tims.Partial_Report_Locators_Class.SOFT_1366_Partial_Report_Locators;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;

public class SOFT_1417_Partial_Report_Actions extends BaseClass {

	public WebDriver driver;
	public static String Barcode1;
	public static String Barcode2;
	SOFT_1417_Partial_Report_Locators sOft_1417_Partial_Report_Locators;
	SOFT_1366_Partial_Report_Locators sOft_1366_Partial_Report_Locators;
	Activate_Test_Kit_Locators activate_test_kit_locators;

	public SOFT_1417_Partial_Report_Actions(WebDriver driver) {
		this.driver = driver;
		sOft_1417_Partial_Report_Locators = new SOFT_1417_Partial_Report_Locators(driver);
		sOft_1366_Partial_Report_Locators = new SOFT_1366_Partial_Report_Locators(driver);

	}
	
	public void groupDisplayAndSelectionForSH() throws InterruptedException
	{
		WebButton.clickButton(sOft_1417_Partial_Report_Locators.get_testReportSideMenuItem());
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_readyForReviewBtn());
		WebWait.visibilityOfElement(driver, sOft_1366_Partial_Report_Locators.get_firstIDItem(), Duration.ofSeconds(30));
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_firstIDItem());
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_assignBtn());
		WebWait.visibilityOfElement(driver, sOft_1366_Partial_Report_Locators.get_assignBtnInAlertBox(), Duration.ofSeconds(30));
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_assignBtnInAlertBox());

		Thread.sleep(3000);
		WebButton.JsclickButton(sOft_1366_Partial_Report_Locators.get_reportTabBtn(), driver);
		WebWait.visibilityOfElement(driver, sOft_1366_Partial_Report_Locators.get_generalBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, sOft_1366_Partial_Report_Locators.get_generalBtn());
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_generalBtn());
		WebDropDown.selectByText(sOft_1366_Partial_Report_Locators.get_overallStatusDrp(), "Everything looks good");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, sOft_1417_Partial_Report_Locators.get_sexualHealthBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, sOft_1417_Partial_Report_Locators.get_sexualHealthBtn());
		WebButton.clickButton(sOft_1417_Partial_Report_Locators.get_sexualHealthBtn());
		WebDropDown.selectByText(sOft_1417_Partial_Report_Locators.get_sexualHealthDrp(), "Everything looks good");
		Thread.sleep(3000);
		List<WebElement> titles = sOft_1417_Partial_Report_Locators.get_groupStatusSH();
		for (WebElement title : titles) {
    	Assert.assertTrue(title.isDisplayed(), "Title is not displayed: " + title.getText());
		}
	}

	public void publishKitAndCheckStatusForEnergyProfileForAllOptionsSexualHealthProfile(String Scenario) throws InterruptedException {
		WebButton.clickButton(sOft_1417_Partial_Report_Locators.get_testReportSideMenuItem());
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_readyForReviewBtn());
		WebWait.visibilityOfElement(driver, sOft_1366_Partial_Report_Locators.get_firstIDItem(), Duration.ofSeconds(30));
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_firstIDItem());
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_assignBtn());
		WebWait.visibilityOfElement(driver, sOft_1366_Partial_Report_Locators.get_assignBtnInAlertBox(), Duration.ofSeconds(30));
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_assignBtnInAlertBox());

		Thread.sleep(3000);
		WebButton.JsclickButton(sOft_1366_Partial_Report_Locators.get_reportTabBtn(), driver);
		WebWait.visibilityOfElement(driver, sOft_1366_Partial_Report_Locators.get_generalBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, sOft_1366_Partial_Report_Locators.get_generalBtn());
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_generalBtn());
		WebDropDown.selectByText(sOft_1366_Partial_Report_Locators.get_overallStatusDrp(), "Everything looks good");
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, sOft_1417_Partial_Report_Locators.get_sexualHealthBtn(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, sOft_1417_Partial_Report_Locators.get_sexualHealthBtn());
		WebButton.clickButton(sOft_1417_Partial_Report_Locators.get_sexualHealthBtn());
		WebDropDown.selectByText(sOft_1417_Partial_Report_Locators.get_sexualHealthDrp(), "Everything looks good");
		
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, sOft_1366_Partial_Report_Locators.get_saveChangesBtn());
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_saveChangesBtn());
		Thread.sleep(5000);
		WebWait.visibilityOfElement(driver, sOft_1366_Partial_Report_Locators.get_publishBtn(), Duration.ofSeconds(30));
		Thread.sleep(5000);
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_publishBtn());
		Thread.sleep(5000);
		WebWait.visibilityOfElement(driver, sOft_1366_Partial_Report_Locators.get_yesAlertBtnn(), Duration.ofSeconds(60));
		Thread.sleep(3000);
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_yesAlertBtnn());
		Thread.sleep(5000);
		WebWait.visibilityOfElement(driver, sOft_1366_Partial_Report_Locators.get_testReportSideMenuItem(), Duration.ofSeconds(60));
		WebScrollView.scrollToElement(driver, sOft_1366_Partial_Report_Locators.get_testReportSideMenuItem());
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_testReportSideMenuItem());
		Thread.sleep(3000);
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_resultPublishedBtn());
		WebWait.visibilityOfElement(driver, sOft_1366_Partial_Report_Locators.get_viewReportID(), Duration.ofSeconds(30));
		WebButton.clickButton(sOft_1366_Partial_Report_Locators.get_viewReportID());
		WebWait.visibilityOfElement(driver, sOft_1417_Partial_Report_Locators.get_yourResultTab(), Duration.ofSeconds(30));		
		WebButton.clickButton(sOft_1417_Partial_Report_Locators.get_yourResultTab());
        Thread.sleep(2000);
        
        switch (Scenario) 
        {
		case "All Clean Result":
			List<WebElement> titles = sOft_1417_Partial_Report_Locators.get_markerCardTitles();
			for (WebElement title : titles) {
	    	Assert.assertTrue(title.isDisplayed(), "Title is not displayed: " + title.getText());
			}
			break;
			
		case "HIV SYPH Text":			
		    Assert.assertTrue(sOft_1417_Partial_Report_Locators.get_HIV_SYPH_Text().isDisplayed(), "HIV is not displayed");		    
			break;
			
		default:
			System.out.println("No matching scenario found, using empty replacements");
			break;
			
		}
      }
	}
	


