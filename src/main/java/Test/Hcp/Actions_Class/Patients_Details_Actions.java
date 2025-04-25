package Test.Hcp.Actions_Class;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Test.Hcp.Locators_Class.Patients_Details_Locators;
import Test.Hcp.Locators_Class.Register_Test_Appointment_Locators;

import Wrappers.ReadGmail;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;

public class Patients_Details_Actions extends BaseClass
{
	public WebDriver driver;
	Patients_Details_Locators patients_details_locators = null;
	Register_Test_Appointment_Actions register_test_appointment_actions = null;
	

	public Patients_Details_Actions(WebDriver driver)
	{
		this.driver = driver;
		patients_details_locators = new Patients_Details_Locators(driver);
	}
	
	//34
	public void The_Left_Side_Menu_for_Phlebotomist_Dashboard() throws IOException
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		if(patients_details_locators.Patient_Record_Link().isEnabled())
		{
			String getPateintRecordUrl = driver.getCurrentUrl();
			String actualPateintRecordUrl = PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "actualPateintRecordUrl");
			Assert.assertEquals(getPateintRecordUrl, actualPateintRecordUrl);
		}
		
		if(patients_details_locators.Action_Link().isEnabled())
		{
		WebButton.clickButton(patients_details_locators.Action_Link());
		String getActionUrl = driver.getCurrentUrl();
		String actualActionUrl = PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "actualActionUrl");
		Assert.assertEquals(getActionUrl, actualActionUrl);
		driver.navigate().back();
		}
		
		if(patients_details_locators.Resource_Link().isEnabled())
		{
		WebButton.clickButton(patients_details_locators.Resource_Link());
		String getResourceUrl = driver.getCurrentUrl();
		String actualResourceUrl = PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "actualResourceUrl");
		Assert.assertEquals(getResourceUrl, actualResourceUrl);
		driver.navigate().back();
		}
		
	}
	
	//35
	public void Valid_Patients_Details_Case1()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getFirstName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getFirstName(), "Concepta");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getLastName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getLastName(), "Test8");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getDob(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getDob(), "04032007");
		WebButton.clickButton(patients_details_locators.getLastName());
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();
	}
	
	//36
	public void Valid_Patients_Details_Case2()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getFirstName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getFirstName(), "Concepta");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getEmail(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getEmail(), "Aressnashik0+48@gmail.com");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getPhoneNumber(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getPhoneNumber(), "7351596204");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();
	}
	
	//37
	public void Valid_Patients_Details_Case3()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getLastName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getLastName(), "Test8");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getEmail(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getEmail(), "Aressnashik0+48@gmail.com");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getDob(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getDob(), "04032007");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();				
	}
	
	//38
	public void Valid_Patients_Details_Case4()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getPhoneNumber(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getPhoneNumber(), "7351596204");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getEmail(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getEmail(), "Aressnashik0+48@gmail.com");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getDob(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getDob(), "04032007");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();				
	}
	
	//39
	public void Valid_Patients_Details_Case5()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getPhoneNumber(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getPhoneNumber(), "7351596204");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getFirstName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getFirstName(), "Concepta");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getLastName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getLastName(), "Test8");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();				
	}
	
	//40
	public void Valid_Patients_Details_Case6()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getPhoneNumber(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getPhoneNumber(), "7351596204");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getFirstName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getFirstName(), "Concepta");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getDob(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getDob(), "04032007");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();				
	}
	
	//42 
	public void Valid_Patients_Details_Case7()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		/*WebWait.visibilityOfElement(driver, patients_details_locators.getBookingId(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getBookingId(), "QE97101");*/
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getFirstName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getFirstName(), "Testautomationsagar");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getLastName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getLastName(), "Testautomationpawar");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getEmail(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getEmail(), "testconcepta3+100@gmail.com");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();				
	}
	
	
	//43
	public void Valid_Patients_Details_Case8()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getBookingId(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getBookingId(), "QE65534");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getDob(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getDob(), "04032007");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getEmail(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getEmail(), "Aressnashik0+48@gmail.com");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();				
	}
	
	//44
	public void Valid_Patients_Details_Case9()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getBookingId(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getBookingId(), "QE65534");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getPhoneNumber(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getPhoneNumber(), "7351596204");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getEmail(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getEmail(), "Aressnashik0+48@gmail.com");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();				
	}
	
	//45
	public void Valid_Patients_Details_Case10() throws InterruptedException
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, patients_details_locators.getBookingId(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getBookingId(), "QE65534");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getFirstName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getFirstName(), "Concepta");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getDob(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getDob(), "04032007");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();				
	}
	
	//46
	public void Valid_Patients_Details_Case11()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getBookingId(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getBookingId(), "QE65534");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getPhoneNumber(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getPhoneNumber(), "7351596204");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getLastName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getLastName(), "Test8");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();				
	}
	
	//41
	public void InValid_Patients_Details()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getPhoneNumber(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getPhoneNumber(), "7351596000");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getFirstName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getFirstName(), "Moncepta");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getDob(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getDob(), "04032009");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
		ValidPateintSuccess();				
	}
	public void Test_Data_Double_Barcode()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getLastName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getLastName(), "Test78");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getFirstName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getFirstName(), "Concepta");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getBookingId(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getBookingId(), "JN73849");
		
		WebButton.clickButton(patients_details_locators.ClickSearchButton());
		
				
	}
	
	//47
	public void AccurateDisplayOfPatientInformationAndNotEditableFeilds() throws InterruptedException
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
	
		WebWait.visibilityOfElement(driver, patients_details_locators.getBookingId(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getBookingId(), "QE65534");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getFirstName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getFirstName(), "Concepta");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getLastName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getLastName(), "Test8");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getPhoneNumber(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getPhoneNumber(), "7351596204");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getEmail(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getEmail(), "Aressnashik0+48@gmail.com");
	
	    WebButton.clickButton(patients_details_locators.ClickSearchButton());
	
	    ValidPateintSuccess();	
	    Thread.sleep(3000);
	    FeildsAreNotEditable();
		
	}
	
	//48
	public void  PatientDetailsDisplayCorrectly() throws InterruptedException
	{
		WebButton.clickButton(patients_details_locators.getRegistered_Button());
		Thread.sleep(5000);
		if(patients_details_locators.getpatient_Name().isDisplayed())
		{
		String getpatient_Name_AutoPopulated = patients_details_locators.getpatient_Name_AutoPopulated().getAttribute("value");
		Assert.assertTrue(getpatient_Name_AutoPopulated != null , "Field is Not auto-populated!");
		System.out.println(" patient_Name Field is auto-populated!");
		}
		
		if(patients_details_locators.getDOB().isDisplayed())
		{
		String getpatient_DOB_AutoPopulated = patients_details_locators.getDOB_AutoPopulated().getAttribute("value");
		Assert.assertTrue(getpatient_DOB_AutoPopulated != null ,   "Field is NOT auto-populated!");
		System.out.println(" patient_DOB Field is auto-populated!");
		}
		
		if(patients_details_locators.getpatient_Email().isDisplayed())
		{
		String getpatient_Email_AutoPopulated = patients_details_locators.getpatient_Email_AutoPopulated().getAttribute("value");
		Assert.assertTrue(getpatient_Email_AutoPopulated != null ,   "Field is NOT auto-populated!");
		System.out.println(" patient_Email Field is auto-populated!");
		}
		
		if(patients_details_locators.getpatient_Phone().isDisplayed())
		{
		String getpatient_Phone_AutoPopulated = patients_details_locators.getpatient_Phone_AutoPopulated().getAttribute("value");
		Assert.assertTrue(getpatient_Phone_AutoPopulated != null ,   "Field is NOT auto-populated!");
		System.out.println(" patient_Phone Field is auto-populated!");
		}
		
		if(patients_details_locators.getpatient_Test_Type().isDisplayed())
		{
		String getpatient_Test_Type_AutoPopulated = patients_details_locators.getpatient_Test_Type_AutoPopulated().getAttribute("value");
		Assert.assertTrue(getpatient_Test_Type_AutoPopulated != null ,   "Field is NOT auto-populated!");
		System.out.println(" patient_TestType Field is auto-populated!");
		}
		
		if(patients_details_locators.getpatient_Vessel_Type().isDisplayed())
		{
		String getpatient_Vessel_Type_AutoPopulated = patients_details_locators.getpatient_Vessel_Type_AutoPopulated().getAttribute("value");
		Assert.assertTrue(getpatient_Vessel_Type_AutoPopulated != null ,   "Field is NOT auto-populated!");
		System.out.println(" patient_VesselType Field is auto-populated!");
		}
		
		if(patients_details_locators.getpatient_Repeated_Test().isDisplayed())
		{
		String getpatient_Repeated_Test_AutoPopulated = patients_details_locators.getpatient_Repeated_Test_AutoPopulated().getAttribute("value");
		Assert.assertTrue(getpatient_Repeated_Test_AutoPopulated != null ,   "Field is NOT auto-populated!");
		System.out.println(" patient_Repeated Test Field is auto-populated!");
		}
						
	}
	
	//49
	public void Store_Location_Search_Functionality() throws InterruptedException
	{
		    Thread.sleep(3000);
		    WebButton.JsclickButton(patients_details_locators.getpatient_patient_Store_Location(), driver);
			patients_details_locators.getpatient_patient_Store_Location().sendKeys("101");
			patients_details_locators.getpatient_patient_Store_Location().sendKeys(Keys.ENTER);
				
	}
	
	//50
	public void functionality_Of_Back_Button() throws IOException, InterruptedException
	{
		WebScrollView.scrollDownVertically(driver);		
		WebButton.JsclickButton(patients_details_locators.getback_Button(),driver);
		String getPateintRecordUrl = driver.getCurrentUrl();
		String actualPateintRecordUrl = PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "actualPateintRecordDetailsUrl");
		Assert.assertEquals(getPateintRecordUrl, actualPateintRecordUrl);
		Thread.sleep(3000);
		WebButton.clickButton(patients_details_locators.getRegistered_Button());
		String getConfirmationPageUrl = driver.getCurrentUrl();
		String actualConfirmationPageUrl = PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "actualTestConfirmationUrl");
		Assert.assertEquals(getConfirmationPageUrl, actualConfirmationPageUrl);
		
	}
	
	//51
		public void functionality_Test_Name_Populated() throws IOException, InterruptedException
		{
			Valid_Patients_Details_Case7();
			Thread.sleep(3000);
			WebButton.clickButton(patients_details_locators.getRegistered_Button());
			Store_Location_Search_Functionality();
			WebButton.clickButton(patients_details_locators.getsave_and_continue_btn());
			String testType = patients_details_locators.gettest_type_autopopulated().getText();
			if(patients_details_locators.gettest_type_autopopulated().isDisplayed())
			{
			String get_Test_Type_AutoPopulated = patients_details_locators.gettest_type_autopopulated().getAttribute("value");
			Assert.assertTrue(get_Test_Type_AutoPopulated != null ,   "Field is NOT auto-populated!");
			System.out.println(" Test Type Field is auto-populated!");
			}
			
			if(testType != null)
			{
				System.out.println("TestType is autopoupated");
			}
			
		}
		
		//52
		public void functionality_Test_Name_Populated_Correctly() throws IOException, InterruptedException
		{
			functionality_Test_Name_Populated();
			String get_Test_Type_AutoPopulated = patients_details_locators.gettest_type_autopopulated().getAttribute("value");
			String actual_TestType_Value = "Thyroid Profile";
			if(get_Test_Type_AutoPopulated ==actual_TestType_Value )
			{
				System.out.println("Test_Type_AutoPopulated feild is correctly displayed");
			}
					
		}
		
		//53
		public void functionality_Gold_Barcode_Expiry_Date() throws IOException, InterruptedException
		{
			functionality_Test_Name_Populated();
			Thread.sleep(3000);
			WebTextBox.sendInput(patients_details_locators.getprimary_barcode(), "PGS-DMG-3638");
			WebElement ErrorMsg = patients_details_locators.getbarcode_Already_Used_Message();
			assert ErrorMsg.isDisplayed() : "Element is not displayed";
			System.out.println("Assertion Passed: Barcode is expired or already used");
        }
		
		//54 & 55
		public void functionality_PGPL_Barcode_And_Data_Populated() throws IOException, InterruptedException
		{
		functionality_Test_Name_Populated();
		Thread.sleep(3000);
		WebTextBox.sendInput(patients_details_locators.getprimary_barcode(), "PGF-JPE-4433");
		WebTextBox.sendInput(patients_details_locators.getbarcode_date(),"02042025");
		Thread.sleep(2000);
		WebTextBox.sendInput(patients_details_locators.getbarcode_time(),"10:10");
		Thread.sleep(2000);
		WebDropDown.selectByText(patients_details_locators.getbarcode_No_Of_Attempts(),"1");
		WebTextBox.sendInput(patients_details_locators.getbarcode_Notes(), "Testing");
		Thread.sleep(3000);
		WebButton.JsclickButton(patients_details_locators.getsave_and_continue_btn(), driver);	
		Thread.sleep(2000);
		WebElement ConfirmationTableData = patients_details_locators.getconfirmation_table();
		assert ConfirmationTableData.isDisplayed() : "Element is not displayed";
		System.out.println("Assertion Passed: ConfirmationTableData is displayed with all necessary details");
		//WebButton.JsclickButton(patients_details_locators.getconfirmation_table_register_btn(), driver);
		
		// confirmation page steps are pending due to test data
		}
		
		//56
		public void functionality_Expiry_Barcode_And_Proceed_To_Continue() throws IOException, InterruptedException
		{
	     	functionality_Test_Name_Populated();
			Thread.sleep(3000);
			WebTextBox.sendInput(patients_details_locators.getprimary_barcode(), "PGT-EYE-0610");
			WebButton.clickButton(patients_details_locators.getbarcode_image());
			WebElement ErrorMsg1 = patients_details_locators.getbarcode_Already_Used_Message();
			assert ErrorMsg1.isDisplayed() : "Element is not displayed";
			System.out.println("Assertion Passed: Barcode is expired or already used");
			Thread.sleep(3000);
			WebButton.JsclickButton(patients_details_locators.getsave_and_continue_btn(), driver);
			WebElement ErrorMsg2 = patients_details_locators.geterror_msg_without_barcode();
			assert ErrorMsg2.isDisplayed() : "Element is not displayed";
			System.out.println("Assertion Passed: Cannot go further without barcode");
		}
	//57 Test_Data_Double_Barcode
	public void functionality_Double_Lavender_Barcode() throws IOException, InterruptedException
	{
		    Test_Data_Double_Barcode();
			Thread.sleep(3000);
			WebButton.clickButton(patients_details_locators.getRegistered_Button());
			Store_Location_Search_Functionality();
			WebButton.clickButton(patients_details_locators.getsave_and_continue_btn());
			Thread.sleep(2000);
			WebTextBox.sendInput(patients_details_locators.getprimary_barcode(), "PGC-WSH-0181");
			WebButton.clickButton(patients_details_locators.getbarcode_image());
			String LavenderBarcode = patients_details_locators.getsecondary_barcode().getAttribute("value");
			if(LavenderBarcode != null)
	      {
				System.out.println("Secondary Barcode is Auto-Populated");
	      }
			
	}	
	
	//  58 Test_Data_Double_Barcode_with save and continue _success_msg----------
		public void functionality_Double_Lavender_Barcode_Success_Toaster_Msg() throws IOException, InterruptedException
		{
			functionality_Double_Lavender_Barcode();
			WebTextBox.sendInput(patients_details_locators.getbarcode_Notes(), "Testing");
			WebTextBox.sendInput(patients_details_locators.getbarcode_date(),"04042025");
			Thread.sleep(2000);
			WebTextBox.sendInput(patients_details_locators.getbarcode_time(),"10:10");
			Thread.sleep(2000);
			WebDropDown.selectByText(patients_details_locators.getbarcode_No_Of_Attempts(),"1");			
			Thread.sleep(3000);			
			WebButton.JsclickButton(patients_details_locators.getsave_and_continue_btn(), driver);	
			/* if date not selected in first attempt then uncomment the below code
			WebTextBox.sendInput(patients_details_locators.getbarcode_date(),"04042025");
						Thread.sleep(2000);
			WebButton.JsclickButton(patients_details_locators.getsave_and_continue_btn(), driver);
			//Thread.sleep(2000); // Need to add one more step of assertion success msg, not added due to test data*/
		}
		
	//  59,60,61 Test_Data_Double_Barcode_with save and continue _success_msg----------
		public void functionality_Final_Register_And_Confirmation() throws IOException, InterruptedException
		{ 
			functionality_Double_Lavender_Barcode_Success_Toaster_Msg();
			Thread.sleep(3000);
			WebButton.JsclickButton(patients_details_locators.getconfirmation_table_register_btn(), driver);
			Thread.sleep(3000);
			List<WebElement> elements = patients_details_locators.getCheckboxListConfirm();

            // Click each element one by one
            for (WebElement element : elements) {
                element.click();
                Thread.sleep(1000);  // Adding delay to observe clicks (optional)
            }
            Thread.sleep(3000);
            WebButton.JsclickButton(patients_details_locators.getconfirm_btn_after_checkbox(), driver);
            Thread.sleep(3000);
            WebButton.JsclickButton(patients_details_locators.getsuccess_msg(), driver);
            Thread.sleep(3000);
            WebButton.JsclickButton(patients_details_locators.getreturn_patient_record_page(), driver);
                      		
		}
		//65 & 66
		public void functionality_Email_Verification_After_Confirmation() throws Exception
		{ 
			functionality_Test_Name_Populated();
			Thread.sleep(3000);
			Thread.sleep(3000);
			WebTextBox.sendInput(patients_details_locators.getprimary_barcode(), "PGS-LUH-0658");
			WebTextBox.sendInput(patients_details_locators.getbarcode_date(),"21042025");
			Thread.sleep(2000);
			WebTextBox.sendInput(patients_details_locators.getbarcode_time(),"10:10");
			Thread.sleep(2000);
			WebDropDown.selectByText(patients_details_locators.getbarcode_No_Of_Attempts(),"1");
			WebTextBox.sendInput(patients_details_locators.getbarcode_Notes(), "Testing");
			Thread.sleep(3000);
			WebTextBox.sendInput(patients_details_locators.getbarcode_date(),"21042025");
			WebButton.JsclickButton(patients_details_locators.getsave_and_continue_btn(), driver);	
			Thread.sleep(2000);
			WebButton.JsclickButton(patients_details_locators.getconfirmation_table_register_btn(), driver);
			Thread.sleep(3000);
			List<WebElement> elements = patients_details_locators.getCheckboxListConfirm();
			 // Click each element one by one
			 for (WebElement element : elements) 
			 {
			      element.click();
			      Thread.sleep(1000);  // Adding delay to observe clicks (optional)
			 }
			            Thread.sleep(3000);
			            WebButton.JsclickButton(patients_details_locators.getconfirm_btn_after_checkbox(), driver);
			            Thread.sleep(3000);
			            WebButton.JsclickButton(patients_details_locators.getsuccess_msg(), driver);
			            Thread.sleep(3000);
			            WebButton.JsclickButton(patients_details_locators.getreturn_patient_record_page(), driver);
			
		}
		public void ReadGmail (String GetData) throws Exception
		{
			            ReadGmail readGmail = new ReadGmail();
			            readGmail.getButtonURL(GetData);
			           
		}
		
		// 70 71 72
		public void functionality_Reject_Kit_But_Not_Effect_To_Customer() throws Exception
		{
			Valid_Patients_Details_Case7();
			Thread.sleep(3000);
			WebButton.clickButton(patients_details_locators.getRegistered_Button());
			Store_Location_Search_Functionality();
			WebButton.clickButton(patients_details_locators.getsave_and_continue_btn());
			Thread.sleep(2000);
			WebTextBox.sendInput(patients_details_locators.getprimary_barcode(), "PGN-DUZ-9447"); // Barcode A for reject
			WebButton.clickButton(patients_details_locators.getbarcode_image());
			Thread.sleep(3000);
			WebScrollView.scrollDownVertically(driver);	
			WebButton.JsclickButton(patients_details_locators.getreject_btn(),driver);
			WebButton.clickButton(patients_details_locators.getkit_btn());
		    Thread.sleep(3000);
			WebDropDown.selectByText(patients_details_locators.getrejectReason_drpdwn(),"Barcode(s) wasted");
			Thread.sleep(3000);
			WebTextBox.sendInput(patients_details_locators.getbarcode_Notes(), "Testing");
			WebButton.clickButton(patients_details_locators.getreject_btn());
			WebButton.clickButton(patients_details_locators.getconfirmRejection_btn());
			Thread.sleep(3000);
			 
		    WebTextBox.sendInput(patients_details_locators.getprimary_barcode(), "PGZ-HXM-5500"); // Barcode B for completion process
			WebButton.clickButton(patients_details_locators.getbarcode_image());
			Thread.sleep(3000);
				
			WebTextBox.sendInput(patients_details_locators.getbarcode_date(),"15042025");
			Thread.sleep(2000);
			WebTextBox.sendInput(patients_details_locators.getbarcode_time(),"10:10");
			Thread.sleep(2000);
			WebDropDown.selectByText(patients_details_locators.getbarcode_No_Of_Attempts(),"1");
			WebTextBox.sendInput(patients_details_locators.getbarcode_Notes(), "Testing");
			Thread.sleep(3000);
			WebButton.JsclickButton(patients_details_locators.getsave_and_continue_btn(), driver);	
			Thread.sleep(2000);
			WebButton.JsclickButton(patients_details_locators.getconfirmation_table_register_btn(), driver);
			Thread.sleep(3000);
				List<WebElement> elements = patients_details_locators.getCheckboxListConfirm();
				 // Click each element one by one
				 for (WebElement element : elements) 
				 {
				      element.click();
				      Thread.sleep(1000);  // Adding delay to observe clicks (optional)
				 }
				            Thread.sleep(3000);
				            WebButton.JsclickButton(patients_details_locators.getconfirm_btn_after_checkbox(), driver);
				            Thread.sleep(3000);
				            WebButton.JsclickButton(patients_details_locators.getsuccess_msg(), driver);
				            Thread.sleep(3000);
				            WebButton.JsclickButton(patients_details_locators.getreturn_patient_record_page(), driver);
				       
			
		}
		// 73
		public void functionality_Reject_Appointment_Effect_To_Barcode_As_Error() throws Exception
		{
			Valid_Patients_Details_Case7();
			Thread.sleep(3000);
			WebButton.clickButton(patients_details_locators.getRegistered_Button());
			Store_Location_Search_Functionality();
			WebButton.clickButton(patients_details_locators.getsave_and_continue_btn());
			Thread.sleep(2000);
			WebTextBox.sendInput(patients_details_locators.getprimary_barcode(), "PGY-TKK-1426"); // Barcode A for reject
			WebButton.clickButton(patients_details_locators.getbarcode_image());
			Thread.sleep(3000);
			WebScrollView.scrollDownVertically(driver);	
			WebButton.JsclickButton(patients_details_locators.getreject_btn(),driver);
			WebButton.clickButton(patients_details_locators.getAppointment_btn());
		    Thread.sleep(3000);
			WebDropDown.selectByText(patients_details_locators.getrejectReason_drpdwn(),"Feeling faint");
			Thread.sleep(3000);
			WebTextBox.sendInput(patients_details_locators.getbarcode_Notes(), "Testing");
			WebButton.clickButton(patients_details_locators.getreject_btn());
			WebButton.clickButton(patients_details_locators.getconfirmRejection_btn());
			Thread.sleep(3000);
		}
		
	public void ValidPateintSuccess()
	
	{
		if(patients_details_locators.DisplayPatientRecordForm().isDisplayed())
		{
			System.out.print("System displays the patient's details on the dashboard.");			
		}
	}
	
	public void InValidPateintSuccess()
	{
		if(patients_details_locators.getnoBookingCustomerErrorMsg().isDisplayed())
		{
			System.out.print("No Matching Customer Found for the entered Data: Test cases Pass as it was invalid data");			
		}
	}
	
	public void FeildsAreNotEditable()
	{
		String readOnlyEmail = patients_details_locators.getEmail().getAttribute("readOnly");
		String readOnlyDOB = patients_details_locators.getDobOfPatientRecordPage().getAttribute("readOnly");
		System.out.print(readOnlyEmail+ "&" + readOnlyDOB);
		
		if (readOnlyEmail != null || readOnlyDOB != null )
		{
		    System.out.println("One or more text fields are not editable.");
		} else {
		    System.out.println("All text fields are editable.");
		}
		
	}
}
