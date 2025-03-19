package Test.Hcp.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Patients_Details_Locators 
{
	public WebDriver driver;

	public Patients_Details_Locators(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	@FindBy(xpath = "//input[@name = 'first_name']")
	private WebElement txtFirstName;

	public WebElement getFirstName() {
		return txtFirstName;
	}
	
	
	@FindBy(xpath = "//input[@name='booking_id']")
	private WebElement txtBookingId;

	public WebElement getBookingId() {
		return txtBookingId;
	}
	
	
	@FindBy(xpath = "//div[@class='server-error']")
	private WebElement noBookingCustomerError;

	public WebElement getnoBookingCustomerErrorMsg() {
		return noBookingCustomerError;
	}
	
	
	@FindBy(xpath = "//input[@name = 'last_name']")
	private WebElement txtLastName;

	public WebElement getLastName() {
		return txtLastName;
	}
	
	
	@FindBy(xpath = "//input[@name = 'email']")
	private WebElement txtEmail;

	public WebElement getEmail() {
		return txtEmail;
	}
	
	
	@FindBy(xpath = "//input[@name = 'phone_number_primary']")
	private WebElement txtPhoneNumber;

	public WebElement getPhoneNumber() {
		return txtPhoneNumber;
	}
	
	
	@FindBy(xpath = "//button[@type= 'submit']")
	private WebElement searchButton;

	public WebElement ClickSearchButton() {
		return searchButton;
	}
	
	
	@FindBy(xpath = "//div[@class= 'patient-record-form']")
	private WebElement patientRecordForm;

	public WebElement DisplayPatientRecordForm() {
		return patientRecordForm;
	}
	
	
	@FindBy(xpath = "//input[@name='dob']")
	private WebElement txtDobOfPatientRecordPage;

	public WebElement getDobOfPatientRecordPage() {
		return txtDobOfPatientRecordPage;
	}
	
	
	@FindBy(xpath = "//input[@type= 'date']")
	private WebElement txtDob;

	public WebElement getDob() {
		return txtDob;
	}
	
	
	@FindBy(xpath = "//a[normalize-space()='Patient record']")
	WebElement patient_Record_Link;

	public WebElement Patient_Record_Link() {
		return patient_Record_Link;
}
	
	
	@FindBy(xpath = "//a[normalize-space()='Account']")
	WebElement action_Link;

	public WebElement Action_Link() {
		return action_Link;
}
	
	@FindBy(xpath = "//a[normalize-space()='Resources']")
	WebElement resource_Link;

	public WebElement Resource_Link() {
		return resource_Link;
}
	
	@FindBy(xpath = "//button[text()='Enable Later']")
	WebElement enable_later;

	public WebElement Enable_Later() {
		return enable_later;
}
	
	@FindBy(xpath = "//span[normalize-space()='Registered']")
	WebElement registered_Button;

	public WebElement getRegistered_Button() {
		return registered_Button;
}
	
	@FindBy(xpath = "//label[contains(text(),'Patient name')]")
	WebElement patient_Name;

	public WebElement getpatient_Name() {
		return patient_Name;
}
	
	@FindBy(xpath = "//input[@placeholder='Enter patient name...']")
	WebElement patient_Name_AutoPopulated;

	public WebElement getpatient_Name_AutoPopulated() {
		return patient_Name_AutoPopulated;
}
	
	@FindBy(xpath = "//label[contains(text(),'D.O.B')]")
	WebElement patient_DOB;

	public WebElement getDOB() {
		return patient_DOB;
}

	@FindBy(xpath = "//input[@placeholder='Enter your email address']")
	WebElement patient_DOB_AutoPopulated;

	public WebElement getDOB_AutoPopulated() {
		return patient_DOB_AutoPopulated;
}
	
	
	@FindBy(xpath = "//label[contains(text(),'Email')]")
	WebElement patient_Email;

	public WebElement getpatient_Email() {
		return patient_Email;
}
	
	@FindBy(xpath = "//input[@placeholder='Enter email address...']")
	WebElement patient_Email_AutoPopulated;

	public WebElement getpatient_Email_AutoPopulated() {
		return patient_Email_AutoPopulated;
}	
	
	
	@FindBy(xpath = "//label[contains(text(),'Phone')]")
	WebElement patient_Phone;

	public WebElement getpatient_Phone() {
		return patient_Phone;
}
	
	@FindBy(xpath = "//input[@placeholder='Enter phone number...']")
	WebElement patient_Phone_AutoPopulated;

	public WebElement getpatient_Phone_AutoPopulated() {
		return patient_Phone_AutoPopulated;
}	
	
	
	@FindBy(xpath = "//label[contains(text(),'Test type')]")
	WebElement patient_Test_Type;

	public WebElement getpatient_Test_Type() {
		return patient_Test_Type;
}

	@FindBy(xpath = "//input[contains(@name,'test_type')]")
	WebElement patient_Test_Type_AutoPopulated;

	public WebElement getpatient_Test_Type_AutoPopulated() {
		return patient_Test_Type_AutoPopulated;
}	
	
	@FindBy(xpath = "//label[contains(text(),'Vessel type')]")
	WebElement patient_Vessel_Type;

	public WebElement getpatient_Vessel_Type() {
		return patient_Vessel_Type;
}
	
	
	@FindBy(xpath = "//input[@name='vessel_info_1']")
	WebElement patient_Vessel_Type_AutoPopulated;

	public WebElement getpatient_Vessel_Type_AutoPopulated() {
		return patient_Vessel_Type_AutoPopulated;
}	
	
	@FindBy(xpath = "//label[contains(text(),'Repeated test')]")
	WebElement patient_Repeated_Test;

	public WebElement getpatient_Repeated_Test() {
		return patient_Repeated_Test;
}
	
	@FindBy(xpath = "//input[@name='repeated_test']")
	WebElement patient_Repeated_Test_AutoPopulated;

	public WebElement getpatient_Repeated_Test_AutoPopulated() {
		return patient_Repeated_Test_AutoPopulated;
}		
	
	@FindBy(xpath = "//input[@aria-autocomplete='list']")
	WebElement patient_Store_Location;

	public WebElement getpatient_patient_Store_Location() {
		return patient_Store_Location;
}		
	
	@FindBy(xpath = "//div[@class='confirm-details-buttons']//button[@type='button']")
	WebElement back_Button;

	public WebElement getback_Button() {
		return back_Button;
}	
	
}
