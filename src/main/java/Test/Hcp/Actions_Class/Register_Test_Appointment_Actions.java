package Test.Hcp.Actions_Class;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Test.Hcp.Locators_Class.Register_Test_Appointment_Locators;
import Wrappers.WebButton;
import Wrappers.WebCurrentTime;
import Wrappers.WebDropDown;
import Wrappers.WebTextBox;
import Wrappers.WebWait;


public class Register_Test_Appointment_Actions {
	public WebDriver driver;
	Register_Test_Appointment_Locators Register_Test_Appointment_Locators;
	Login_Health_Professional_Actions Login_Health_Professional_Actions;
	private String barcode;
	Actions actions;
	
	

	public Register_Test_Appointment_Actions(WebDriver driver) {
		this.driver = driver;
		Register_Test_Appointment_Locators = new Register_Test_Appointment_Locators(driver);
		Login_Health_Professional_Actions = new Login_Health_Professional_Actions(driver);
		actions = new Actions(driver);
	}
	
	public void searchPatientRecord() {
		Login_Health_Professional_Actions.clickOnEnableLaterBtn();
		WebWait.visibilityOfElement(driver, Register_Test_Appointment_Locators.search_First_Name(), Duration.ofSeconds(30));
		WebTextBox.sendInput(Register_Test_Appointment_Locators.search_First_Name(), "Concepta");
		WebWait.visibilityOfElement(driver, Register_Test_Appointment_Locators.search_Last_Name(), Duration.ofSeconds(30));
		WebTextBox.sendInput(Register_Test_Appointment_Locators.search_Last_Name(), "Test7");
		WebWait.visibilityOfElement(driver, Register_Test_Appointment_Locators.search_email_Name(), Duration.ofSeconds(30));
		WebTextBox.sendInput(Register_Test_Appointment_Locators.search_email_Name(), "Aressnashik0+47@gmail.com");
		WebButton.clickButton(Register_Test_Appointment_Locators.click_Search_Btn());
				
	}
	
	public void confirm_Patient_Record() throws InterruptedException {
		Thread.sleep(2000);
		WebButton.clickButton(Register_Test_Appointment_Locators.click_register_Btn());
		WebButton.clickButton(Register_Test_Appointment_Locators.click_drpDown_box());
		WebWait.visibilityOfElement(driver, Register_Test_Appointment_Locators.click_drpDown_box(), Duration.ofSeconds(30));
		WebTextBox.sendInput(Register_Test_Appointment_Locators.click_drpDown_box(), "101");
		new Actions(driver).sendKeys(Register_Test_Appointment_Locators.click_drpDown_box(), Keys.ENTER).build().perform();
		Thread.sleep(3000);
		//WebButton.clickButton(Register_Test_Appointment_Locators.click_save_ContinueBtn());	
		WebButton.JsclickButton(Register_Test_Appointment_Locators.click_save_ContinueBtn(), driver);
	}
	public void patient_Record_Page() throws InterruptedException {
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, Register_Test_Appointment_Locators.enter_Barcode(), Duration.ofSeconds(30));
		WebTextBox.sendInput(Register_Test_Appointment_Locators.enter_Barcode(), "PGS-DMG-3638");
		Register_Test_Appointment_Locators.enter_Barcode().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, Register_Test_Appointment_Locators.calender_Box(), Duration.ofSeconds(30));
		WebTextBox.sendInput(Register_Test_Appointment_Locators.calender_Box(),"03042025");
		WebWait.visibilityOfElement(driver, Register_Test_Appointment_Locators.enter_Time(), Duration.ofSeconds(30));
		WebTextBox.sendInput(Register_Test_Appointment_Locators.enter_Time(), "1039AM");
		WebDropDown.selectByText(Register_Test_Appointment_Locators.click_no_of_Attempts_Dropdown(), "1");
		
		
		actions.scrollByAmount(0, 500).perform();
		Thread.sleep(3000);
		WebButton.clickButton(Register_Test_Appointment_Locators.click_save_ContinueBtn());
		
		
	}
	
	public void confirm_Patient_Details_Page() throws InterruptedException {
//		String patient_Name = first_Name+" "+last_Name;
//		System.out.println("Patient Name is "+Register_Test_Appointment_LocatorspatientNameConfirmation.getText());
//		Assert.assertEquals(patient_Name, driver.findElement(patientNameConfirmation).getText());
		Thread.sleep(2000);
		actions.scrollByAmount(0, 700).perform();
		Thread.sleep(2000);
		//WebButton.clickButton(Register_Test_Appointment_Locators.registeredBtn2());
		WebButton.JsclickButton(Register_Test_Appointment_Locators.registeredBtn2(), driver);
	}
	
	public void confirm_Appointment_Page() throws InterruptedException {
		Thread.sleep(2000);
		String expectedText = "CONFIRMATION OF TEST REGISTRATION";
		String actualText=	Register_Test_Appointment_Locators.confirmationMsg().getText().trim();
		System.out.println("Confirmation Message: " + actualText);
		 Assert.assertEquals(actualText, expectedText, "Confirmation Message does not match!");
	}
	
	public void book_Test_Appointment() throws InterruptedException {
		searchPatientRecord();
		confirm_Patient_Record();
		patient_Record_Page();
		confirm_Patient_Details_Page();
		confirm_Appointment_Page();		
	}
}
