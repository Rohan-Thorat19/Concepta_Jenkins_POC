package Test.Tims.Actions_Class;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Test.Tims.Locators_Class.Create_test_kit_For_PG_Locators;
import Test.Tims.Locators_Class.Testkit_Uplaodcsv_Partial_Event_Logs_Locators;
import Wrappers.WebButton;
import Wrappers.WebDropDown;
import Wrappers.WebScreenshot;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class Testkit_Uplaodcsv_Partial_Event_Logs_Actions 
{
	public WebDriver driver;
	Testkit_Uplaodcsv_Partial_Event_Logs_Actions testkit_uplaodcsv_partial_event_logs_actions=null;
	Testkit_Uplaodcsv_Partial_Event_Logs_Locators testkit_uplaodcsv_partial_event_logs_locators=null;
	 
	public Testkit_Uplaodcsv_Partial_Event_Logs_Actions(WebDriver driver) 
	{
		this.driver = driver;
		
		testkit_uplaodcsv_partial_event_logs_locators = new Testkit_Uplaodcsv_Partial_Event_Logs_Locators(driver);
	}
	
	public void CsvPartialEventLogStatus() throws InterruptedException
	{
		testkit_uplaodcsv_partial_event_logs_locators = new Testkit_Uplaodcsv_Partial_Event_Logs_Locators(driver) ;
	/* Perform hcp entire jouney and then continue from here
	String filePath = System.getProperty("user.dir") +"/TestData/tims_smoke_thyriod_blood _partial_event_logs.csv";
	WebButton.clickButton(testkit_uplaodcsv_partial_event_logs_locators.getTest_Kit_Btn());
	WebButton.clickButton(testkit_uplaodcsv_partial_event_logs_locators.getUpload_blood_result_CSV_Btn());
	WebTextBox.sendInputUpdate(testkit_uplaodcsv_partial_event_logs_locators.getUpload_blood_result_CSV_filepath(), filePath);
	WebButton.clickButton(testkit_uplaodcsv_partial_event_logs_locators.getUpload_Btn());*/
	WebButton.clickButton(testkit_uplaodcsv_partial_event_logs_locators.Enable_Later());
	Thread.sleep(5000);
	WebButton.clickButton(testkit_uplaodcsv_partial_event_logs_locators.getTest_Kit_Btn());
	Thread.sleep(5000);
	WebTextBox.sendInputUpdate(testkit_uplaodcsv_partial_event_logs_locators.getId_Search_Txtbox(), "13905");
	//testkit_uplaodcsv_partial_event_logs_locators.getId_Search_Txtbox().sendKeys(Keys.ENTER);
	Thread.sleep(5000);
	//WebButton.JsclickButton(testkit_uplaodcsv_partial_event_logs_locators.getfirst_Entry_in_TestKit(),driver);
	WebButton.clickButton(testkit_uplaodcsv_partial_event_logs_locators.getfirst_Entry_in_TestKit());
	Thread.sleep(5000);
	WebButton.clickButton(testkit_uplaodcsv_partial_event_logs_locators.gettestkit_event_menu());
	Thread.sleep(5000);
	WebButton.clickButton(testkit_uplaodcsv_partial_event_logs_locators.getfailed_sample_link());
	Thread.sleep(5000);
	Assert.assertTrue(testkit_uplaodcsv_partial_event_logs_locators.getfailed_sample_link_final_log().isDisplayed());		
	
	}
	

}
