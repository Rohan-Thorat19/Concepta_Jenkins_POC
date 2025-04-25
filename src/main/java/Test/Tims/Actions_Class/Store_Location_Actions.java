package Test.Tims.Actions_Class;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Test.Tims.Locators_Class.New_Store_Location_Locators;
import Wrappers.GenerateRandomEmail;
import Wrappers.WebButton;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;



public class Store_Location_Actions {
	public WebDriver driver;
	Create_test_kit_For_PG_Actions create_test_kit_actions;
	New_Store_Location_Locators new_store_location_locators;

	public Store_Location_Actions(WebDriver driver) {
		this.driver = driver;
		create_test_kit_actions = new Create_test_kit_For_PG_Actions(driver);
		new_store_location_locators = new New_Store_Location_Locators(driver);
	}
	
	public void select_Loctaion_Menu() throws InterruptedException {
		create_test_kit_actions.clickOn_Enable_Later();
		WebButton.clickButton(new_store_location_locators.get_Locations());
	}
	
	public void submit_New_Location_Fields() throws InterruptedException {
		Thread.sleep(2000);
		WebButton.clickButton(new_store_location_locators.get_Create_New_Location());
		Thread.sleep(2000);
		WebTextBox.sendInput(new_store_location_locators.get_store_number_Field(), "12345");
		WebTextBox.sendInput(new_store_location_locators.get_store_name_Field(), "Test1");
		WebTextBox.sendInput(new_store_location_locators.get_store_Address_Field(), "Lane1");
		WebTextBox.sendInput(new_store_location_locators.get_store_Area_Field(), "ABC");
		WebTextBox.sendInput(new_store_location_locators.get_store_Region_Field(), "xyz");
		WebTextBox.sendInput(new_store_location_locators.get_store_Manager_Field(), "Concepta");
		WebTextBox.sendInput(new_store_location_locators.get_store_Contact_Email_Field(), GenerateRandomEmail.generateRandomEmail());
		WebTextBox.sendInput(new_store_location_locators.get_store_Telephonel_Field(), "+44 333 333 3333");
		WebButton.clickButton(new_store_location_locators.get_store_save_button());		
		
	}
	
	public void get_Success_Msg() {
		
		WebWait.visibilityOfElement(driver, new_store_location_locators.get_location_Created_Msg(),Duration.ofSeconds(30));
		String alert_expected = new_store_location_locators.get_location_Created_Msg().getText().trim();
		System.out.println("Verify Location Creation success Messsage - " + alert_expected);
		String Alert = "Location added";
		String ActualValue = Alert;
		//Thread.sleep(2000);
		assertEquals(ActualValue, alert_expected);
		ExtentManager.getTest().log(Status.PASS, "Verified the New Store Location Created");
	}
	
	public void create_New_Location() throws InterruptedException {
		select_Loctaion_Menu();
		submit_New_Location_Fields();
		get_Success_Msg();
	}

}
