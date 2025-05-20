package Test.Tims.Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Phlebotomist_User_Create_Delete_Locators {
	public WebDriver driver;

	public Phlebotomist_User_Create_Delete_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(.,'Add new phlebotomist')]")
	WebElement add_New_Phleb_btn;

	public WebElement get_Add_New_Phleb_btn() {
		return add_New_Phleb_btn;
	}

	@FindBy(css = "#phlebotomist-firstname")
	WebElement Phleb_Fisrt_Name;

	public WebElement enter_Phleb_Fisrt_Name() {
		return Phleb_Fisrt_Name;
	}

	
	@FindBy(css = "#phlebotomist-lastname")
	WebElement Phleb_Last_Name;

	public WebElement enter_Phleb_Last_Name() {
		return Phleb_Last_Name;
	}
	
	@FindBy(css = "#phlebotomist-email")
	WebElement Phleb_Email;

	public WebElement enter_Phleb_Email() {
		return Phleb_Email;
	}
	
	@FindBy(xpath = "(//button[contains(.,'Save')])[1]")
	WebElement Phleb_Save_Btn;

	public WebElement get_Phleb_Save_Btn() {
		return Phleb_Save_Btn;
	}
	
	@FindBy(id = "email-error")
	WebElement email_Error_Msg;

	public WebElement get_Email_Error_Msg() {
		return email_Error_Msg;
	}
	
	@FindBy(xpath = "//h2[contains(.,'Phlebotomist added')]")
	WebElement Phleb_Added_Msg;

	public WebElement get_Phleb_Added_Msg() {
		return Phleb_Added_Msg;
	}
	
	@FindBy(xpath = "//h2[contains(.,'Phlebotomist already exists')]")
	public WebElement Phleb_exists;

	public WebElement get_Phleb_Exists_Msg() {
		return Phleb_exists;
	}
	@FindBy(xpath = "//a[@href='/admin/manage-phlebotomists']")
	WebElement HCP_User;

	public WebElement getHCP_User() {
		return HCP_User;
	}

	@FindBy(xpath = "//thead/tr/th")
	List<WebElement> table_Headers;

	public List<WebElement> get_Table_Headers() {
		return table_Headers;
	}

	@FindBy(xpath = "//button[text()='Delete']")
	WebElement confirm_Dlt_Btn;

	public WebElement get_Confirm_Dlt_Btn() {
		return confirm_Dlt_Btn;
	}

	@FindBy(xpath = "//h2[contains(.,'Phlebotomist deleted')]")
	WebElement deleted_Msg;

	public WebElement deleted_Msg() {
		return deleted_Msg;
	}

}
