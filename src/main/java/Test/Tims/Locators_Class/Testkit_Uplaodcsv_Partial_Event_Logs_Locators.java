package Test.Tims.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testkit_Uplaodcsv_Partial_Event_Logs_Locators
{
	public WebDriver driver;

	public Testkit_Uplaodcsv_Partial_Event_Logs_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/admin/test-kits/']")
	WebElement Test_Kit_Btn;

	public WebElement getTest_Kit_Btn() {
		return Test_Kit_Btn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Upload blood result CSV']")
	WebElement Upload_blood_result_CSV_Btn;

	public WebElement getUpload_blood_result_CSV_Btn() {
		return Upload_blood_result_CSV_Btn;
	}
	
	@FindBy(xpath = "(//input[@id='kit_csv_result'])[1]")
	WebElement Upload_blood_result_CSV_filepath;

	public WebElement getUpload_blood_result_CSV_filepath(){		
	return Upload_blood_result_CSV_filepath;
	}
	@FindBy(xpath = "//span[contains(text(),'Upload')]")
	WebElement Upload_Btn;

	public WebElement getUpload_Btn() {
		return Upload_Btn;
	}
	
	@FindBy(xpath = "//input[@name='searchInput1']")
	WebElement Id_Search_Txtbox;

	public WebElement getId_Search_Txtbox() {
		return Id_Search_Txtbox;
	}
	//tbody/tr[1]/td[1]
	@FindBy(xpath = "//a[normalize-space()='13905']")
	WebElement first_Entry_in_TestKit;

	public WebElement getfirst_Entry_in_TestKit() {
		return first_Entry_in_TestKit;
	}
	
	@FindBy(xpath = "//a[@id='nav-testkit-events-tab']")
	WebElement testkit_event_menu;

	public WebElement gettestkit_event_menu() {
		return testkit_event_menu;
	}
	
	//a[normalize-space()='Phlebotomist Failed Sample']
	
	@FindBy(xpath = "(//tbody/tr[2]/td[1])[2]")
	WebElement failed_sample_link;

	public WebElement getfailed_sample_link() {
		return failed_sample_link;
	}
	
	@FindBy(xpath = "//button[text()='Enable Later']")
	WebElement enable_later;

	public WebElement Enable_Later() {
		return enable_later;
}
	
	@FindBy(xpath = "//td[normalize-space()='phlebotomist-failed-sample']")
	WebElement failed_sample_link_final_log;

	public WebElement getfailed_sample_link_final_log() {
		return failed_sample_link_final_log;
	}		
}
