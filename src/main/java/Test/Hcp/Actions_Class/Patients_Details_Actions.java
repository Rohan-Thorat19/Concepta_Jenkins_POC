package Test.Hcp.Actions_Class;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Test.Hcp.Locators_Class.Patients_Details_Locators;
import Test.Hcp.Locators_Class.Register_Test_Appointment_Locators;
import Test.Kit.Locators_Class.Login_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
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
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getBookingId(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getBookingId(), "QE65534");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getFirstName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getFirstName(), "Concepta");
		
		WebWait.visibilityOfElement(driver, patients_details_locators.getLastName(), Duration.ofSeconds(30));
		WebTextBox.sendInput(patients_details_locators.getLastName(), "Test8");
		
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
	public void Valid_Patients_Details_Case10()
	{
		WebButton.clickButton(patients_details_locators.Enable_Later());
		
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
