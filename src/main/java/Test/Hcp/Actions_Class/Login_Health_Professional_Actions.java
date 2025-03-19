package Test.Hcp.Actions_Class;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;

import Test.Hcp.Locators_Class.Login_Health_Professional_Locators;
import Test.Kit.Locators_Class.Create_test_kit_Locators;
import Wrappers.WebButton;
import Wrappers.WebScreenshot;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;


public class Login_Health_Professional_Actions {

	public WebDriver driver;
	Login_Health_Professional_Locators login_health_professional_Locators;
	 private String barcode;

	public Login_Health_Professional_Actions(WebDriver driver) {
		this.driver = driver;
		login_health_professional_Locators = new Login_Health_Professional_Locators(driver);
	}

	public void clickOnEnableLaterBtn() {
		WebWait.elementToBeClickable(driver, login_health_professional_Locators.getenableLater_btn(), Duration.ofSeconds(30));
	//	WebButton.JsclickButton(login_health_professional_Locators.getenableLater_btn(), driver);
		WebButton.clickButton(login_health_professional_Locators.getenableLater_btn());
 
	}
	public void enter_firstname() {
		//TextBox.sendInput(driver, firstname, Enterfirstname);
		WebWait.visibilityOfElement(driver, login_health_professional_Locators.getfirstname(), Duration.ofSeconds(30));
		WebTextBox.sendInput(login_health_professional_Locators.getfirstname(), "saufin");
 
	}
	public void enter_lastname() {
		//TextBox.sendInput(driver, lastname, Enterlastname);
		WebWait.visibilityOfElement(driver, login_health_professional_Locators.getlastname(), Duration.ofSeconds(30));
		WebTextBox.sendInput(login_health_professional_Locators.getlastname(), "s");
 
	}
	public void clickOnsearchBtn() {
	//	WebMouseOperation.moveToElementClick(driver, search_btn);
		WebButton.clickButton(login_health_professional_Locators.getsearch_btn());
 
	}
	 public void getMsg() {
//	        String ab= WebElementUtils.getText(driver, error_msg);
//	        return ab;// Return the text instead of just calling the method
	        
	        WebWait.visibilityOfElement(driver, login_health_professional_Locators.geterror_msg(),Duration.ofSeconds(30));
			String alert_expected = login_health_professional_Locators.geterror_msg().getText().trim();
			System.out.println("Verify-" + alert_expected);
			String Alert = "Please fill in at least 3 fields to submit the form";
			String ActualValue = Alert;
			//Thread.sleep(2000);
			assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Verified");
	        
	   }

	

	public void verify_hcp_locin() throws InterruptedException {
		clickOnEnableLaterBtn();
		enter_firstname();
		enter_lastname();
		clickOnsearchBtn();
		getMsg();
	
	}

	}	
	