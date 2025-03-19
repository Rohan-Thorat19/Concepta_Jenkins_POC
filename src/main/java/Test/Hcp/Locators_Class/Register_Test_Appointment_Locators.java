package Test.Hcp.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Test_Appointment_Locators {
	public WebDriver driver;
	public Register_Test_Appointment_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name = 'first_name']")
	WebElement f_Name;
 
	public WebElement search_First_Name() {
		return f_Name;
	}
	
	@FindBy(xpath = "//input[@name = 'last_name']")
	WebElement l_Name;
 
	public WebElement search_Last_Name() {
		return l_Name;
	}
	
	@FindBy(xpath = "//input[@name = 'email']")
	WebElement patient_Emalil;
 
	public WebElement search_email_Name() {
		return patient_Emalil;
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;
 
	public WebElement click_Search_Btn() {
		return searchBtn;
	}
 
	@FindBy(xpath = "//span[text()='Registered']")
	WebElement registeredBtn;
 
	public WebElement click_register_Btn() {
		return registeredBtn;
	}
	
	/*@FindBy(id = "react-select-2-input")
	WebElement drpDown;*/
	@FindBy(xpath = "//div[@class='css-19bb58m']")
	WebElement drpDown;
	public WebElement click_drpDown_box() {
		return drpDown;
	}
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit_btn;
 
	public WebElement click_Submit_Btn() {
		return submit_btn;
	}
 
	@FindBy(xpath = "//input[@name='primary_barcode']")
	WebElement barcode;
 
	public WebElement enter_Barcode() {
		return barcode;
	}
 
	@FindBy(name = "sample_collection_date")
	WebElement calendar;
 
	public WebElement calender_Box() {
		return calendar;
	}
 
	@FindBy(xpath = "//input[@name='sample_collection_time']")
	WebElement time;
 
	public WebElement enter_Time() {
		return time;
	}
	
	@FindBy(xpath = "//select[@name='number_of_attempt']")
	WebElement no_of_Attempts_Dropdown;
 
	public WebElement click_no_of_Attempts_Dropdown() {
		return no_of_Attempts_Dropdown;
	}
	
	@FindBy(xpath = "//span[contains(.,'Save & continue')]")
	WebElement save_ContinueBtn;
 
	public WebElement click_save_ContinueBtn() {
		return save_ContinueBtn;
	}
	
	@FindBy(xpath = "//td[text()='Patient name']/following-sibling::td")
	WebElement patientNameConfirmatio;
 
	public WebElement patientNameConfirmatio() {
		return patientNameConfirmatio;
	}
	
	@FindBy(xpath = "//span[text()='REGISTER']")
	WebElement registeredBtn2;
 
	public WebElement registeredBtn2() {
		return registeredBtn2;
	}
	
	@FindBy(xpath = "//div[@class='page-header w-100']/h1")
	WebElement confirmationMsg;
 
	public WebElement confirmationMsg() {
		return registeredBtn2;
	}
	
	
}
