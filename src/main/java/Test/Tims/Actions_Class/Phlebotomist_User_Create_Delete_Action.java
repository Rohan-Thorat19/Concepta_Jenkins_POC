package Test.Tims.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Test.Tims.Locators_Class.Create_test_kit_For_PG_Locators;
import Test.Tims.Locators_Class.Phlebotomist_User_Create_Delete_Locators;
import Wrappers.GenerateRandomEmail;
import Wrappers.GetCurrentEmailString;
import Wrappers.GetCurrentEmailString2;
import Wrappers.Table_Traverse;
import Wrappers.WebButton;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class Phlebotomist_User_Create_Delete_Action {
	public WebDriver driver;
	Phlebotomist_User_Create_Delete_Locators phlebotomist_user_create_delete_locators;
	Create_test_kit_For_PG_Actions Create_test_kit_Actions;
	String user_Email_Address = GenerateRandomEmail.generateRandomEmail();
	

	public Phlebotomist_User_Create_Delete_Action(WebDriver driver) {
		this.driver = driver;
		phlebotomist_user_create_delete_locators = new Phlebotomist_User_Create_Delete_Locators(driver);
		Create_test_kit_Actions = new Create_test_kit_For_PG_Actions(driver);
	}
	

	public void selected_HCP_User_Menu() throws InterruptedException {
		Create_test_kit_Actions.clickOn_Enable_Later();
		WebWait.elementToBeClickable(driver, phlebotomist_user_create_delete_locators.getHCP_User(),
				Duration.ofSeconds(50));
		WebButton.clickButton(phlebotomist_user_create_delete_locators.getHCP_User());
		ExtentManager.getTest().log(Status.PASS, "clicked On HCP User");
	}
	

	public void Add_New_Phleb() throws InterruptedException {
		WebWait.elementToBeClickable(driver, phlebotomist_user_create_delete_locators.get_Add_New_Phleb_btn(),
				Duration.ofSeconds(50));
		WebButton.clickButton(phlebotomist_user_create_delete_locators.get_Add_New_Phleb_btn());
		Thread.sleep(2000);
		WebTextBox.sendInput(phlebotomist_user_create_delete_locators.enter_Phleb_Fisrt_Name(), "Test");
		WebTextBox.sendInput(phlebotomist_user_create_delete_locators.enter_Phleb_Last_Name(), "Concepta");
		WebTextBox.sendInput(phlebotomist_user_create_delete_locators.enter_Phleb_Email(),
				GenerateRandomEmail.generateRandomEmail());
		Thread.sleep(2000);
		WebButton.JsclickButton(phlebotomist_user_create_delete_locators.get_Phleb_Save_Btn(), driver);	
	}
	
	
	public void get_Phleb_Creation_Msg() {
		try {
			WebElement addedMsgElement = phlebotomist_user_create_delete_locators.get_Phleb_Added_Msg();

			if (addedMsgElement.isDisplayed()) {
				WebWait.visibilityOfElement(driver, addedMsgElement, Duration.ofSeconds(30));

				String alert_expected = addedMsgElement.getText().trim();
				System.out.println("Verify Message: " + alert_expected);

				String Alert = "Phlebotomist added";
				String ActualValue = Alert;

				assertEquals(ActualValue, alert_expected);
				ExtentManager.getTest().log(Status.PASS, "Verified the Phlebotomist added.");
			} else {
				Assert.assertTrue(phlebotomist_user_create_delete_locators.get_Phleb_Exists_Msg().isDisplayed(),
						"Phlebotomist user exists message is not displayed");
			}
		} catch (NoSuchElementException e) {
			// If element is not found, handle the case and proceed
			Assert.assertTrue(phlebotomist_user_create_delete_locators.get_Phleb_Exists_Msg().isDisplayed(),
					"Phlebotomist user exists message is not displayed");
		}
		
	}
	
	public void validate_Invalid_Phleb_EmailID() throws InterruptedException {
		WebWait.elementToBeClickable(driver, phlebotomist_user_create_delete_locators.get_Add_New_Phleb_btn(),
				Duration.ofSeconds(50));
		WebButton.clickButton(phlebotomist_user_create_delete_locators.get_Add_New_Phleb_btn());
		Thread.sleep(2000);
		WebTextBox.sendInput(phlebotomist_user_create_delete_locators.enter_Phleb_Fisrt_Name(), "Test");
		WebTextBox.sendInput(phlebotomist_user_create_delete_locators.enter_Phleb_Last_Name(), "Concepta");
		WebButton.clickButton(phlebotomist_user_create_delete_locators.get_Phleb_Save_Btn());
		Boolean errorMsgDisplayed = phlebotomist_user_create_delete_locators.get_Email_Error_Msg().isDisplayed();

		if (errorMsgDisplayed) {
			Thread.sleep(2000);
			System.out.println(phlebotomist_user_create_delete_locators.get_Email_Error_Msg().getText());

		}
		phlebotomist_user_create_delete_locators.enter_Phleb_Email().clear();

		WebTextBox.sendInput(phlebotomist_user_create_delete_locators.enter_Phleb_Email(), "test@test@.com");
		if (errorMsgDisplayed) {
			Thread.sleep(2000);
			System.out.println(phlebotomist_user_create_delete_locators.get_Email_Error_Msg().getText());

		}
		phlebotomist_user_create_delete_locators.enter_Phleb_Email().clear();

		WebTextBox.sendInput(phlebotomist_user_create_delete_locators.enter_Phleb_Email(), "test@testcom");
		if (errorMsgDisplayed) {
			Thread.sleep(2000);
			System.out.println(phlebotomist_user_create_delete_locators.get_Email_Error_Msg().getText());
		}
		phlebotomist_user_create_delete_locators.enter_Phleb_Email().clear();

		WebTextBox.sendInput(phlebotomist_user_create_delete_locators.enter_Phleb_Email(),
				GenerateRandomEmail.generateRandomEmail());
		WebButton.JsclickButton(phlebotomist_user_create_delete_locators.get_Phleb_Save_Btn(), driver);

	}
	

	public void get_Email_Verfication() throws Exception {
		String url = GetCurrentEmailString2.getVerificationLink(user_Email_Address);
        if (url != null) {
            System.out.println("Verification link found: " + url);
            
            // Step 4: Open the verification link
            driver.get(url);
            
            // Step 5: Verify success message
            WebElement successMessage = driver.findElement(By.xpath("//h2[contains(text(),'Account Verified')]"));
            if (successMessage.isDisplayed()) {
                System.out.println("✅ Account successfully verified!");
            } 
            else {
                System.out.println("❌ Account verification failed.");
            }
        } 
        else {
            System.out.println("❌ No verification email found.");
 
    } 
//        catch(Exception e) {
//        e.printStackTrace();
//    } 
}
	

	

	public void select_User_To_Delete() throws InterruptedException {
		int j = Table_Traverse.getColoumnName(phlebotomist_user_create_delete_locators.get_Table_Headers(), "Email");

		user_Email_Address = "conceptauser5138@testmail.com";
		Thread.sleep(2000);
		List<WebElement> table_Value = driver.findElements(By.xpath("//tbody/tr/td[" + j + "]"));
		for (int i = 0; i < table_Value.size(); i++) {
			if (table_Value.get(i).getText().trim().equalsIgnoreCase(user_Email_Address)) {
				System.out.println("Selected Email ID is :" + table_Value.get(i).getText());
				WebElement delete_Btn = driver
						.findElement(By.xpath("//tr[" + (i + 1) + "]/td/button[@class= 'btn delete-location-btn']"));
				WebWait.elementToBeClickable(driver, delete_Btn, Duration.ofSeconds(50));
				WebButton.clickButton(delete_Btn);
				WebWait.visibilityOfElement(driver, phlebotomist_user_create_delete_locators.get_Confirm_Dlt_Btn(),
						Duration.ofSeconds(10));
				WebButton.clickButton(phlebotomist_user_create_delete_locators.get_Confirm_Dlt_Btn());
			}
		}

		
	}
	public void get_Phleb_Delete_Msg() {
		WebWait.visibilityOfElement(driver, phlebotomist_user_create_delete_locators.deleted_Msg(),
				Duration.ofSeconds(30));
		String alert_expected = phlebotomist_user_create_delete_locators.deleted_Msg().getText().trim();
		System.out.println("Verify Message -" + alert_expected);
		String Alert = "Phlebotomist deleted";
		String ActualValue = Alert;
		assertEquals(ActualValue, alert_expected);
		ExtentManager.getTest().log(Status.PASS, "Verified the Phlebotomist deleted.");
	}

	public void delete_User() throws InterruptedException {
		selected_HCP_User_Menu();
		select_User_To_Delete();
		get_Phleb_Delete_Msg();
	}

	public void create_phleb_Account() throws Exception {
		selected_HCP_User_Menu();
		Add_New_Phleb();
		 get_Phleb_Creation_Msg();
		get_Email_Verfication();
		

	}

	public void validated_Email_Field() throws InterruptedException {
		selected_HCP_User_Menu();
		validate_Invalid_Phleb_EmailID();
		get_Phleb_Creation_Msg();

	}

}
