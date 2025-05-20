package Test.Tims.Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.Tims.Actions_Class.Create_test_kit_For_PL_Actions;

public class Phlebotomist_csv_import_Locators {
	public WebDriver driver;
	

	public Phlebotomist_csv_import_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath= "//a[@href='/admin/manage-phlebotomists']")
	private WebElement hcp_User_Menu;
	
	public WebElement gethcp_User_Menu() {
		return hcp_User_Menu;
	}

	@FindBy(xpath= "//a[@href='/admin/phlebotomist-download-csv/']")
	private WebElement download_CSV;
	
	public WebElement getdownload_CSV() {
		return download_CSV;
	}
	
	@FindBy(xpath= "//button[contains(text(),'Import phlebotomists')]")
	private WebElement import_CSV;
	
	public WebElement getimport_CSV() {
		return import_CSV;
	}
	
	@FindBy(id ="csvFile")
	private WebElement chooes_CSV;
	
	public WebElement getchooes_CSV() {
		return chooes_CSV;
	}
	
	@FindBy(id ="upload_csv_for_location")
	private WebElement save_file;
	
	public WebElement save_file() {
		return save_file;
	}
	
	@FindBy(xpath = "//p[contains(text(),'CSV data is being processed.')]")
	private WebElement cvs_Process_Msg;
	
	public WebElement cvs_Process_Msg() {
		return cvs_Process_Msg;
	}
	
	@FindBy(xpath = "//span[text()='CSV uploaded. Success: 1, Failures: 0']")
	private WebElement cvs_Upload_Success_Msg;
	
	public WebElement get_cvs_Upload_Success_Msg() {
		return cvs_Upload_Success_Msg;
	}
	
	@FindBy(xpath = "//span[text()='CSV not uploaded. Failures: 1']")
	private WebElement cvs_Upload_Fail_Msg;
	
	public WebElement cvs_Upload_Fail_Msg() {
		return cvs_Upload_Fail_Msg;
	}

	@FindBy(xpath = "//a[@href='/admin/test-kits/']")
	WebElement  Testkit;

	public WebElement  getTestkit() {
		return Testkit;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Upload blood result CSV')]")
	WebElement  upload_Blood_Result_CSV;

	public WebElement  get_upload_Blood_Result_CSV() {
		return upload_Blood_Result_CSV;
	}
	
	@FindBy(xpath = "(//input[@id='kit_csv_result'])[1]")
	WebElement  upload_File_Button;

	public WebElement  getupload_File_Button() {
		return upload_File_Button;
	}
	@FindBy(id = "uploadButton")
	WebElement file_upload_Btn;

	public WebElement  get_file_upload_Btn() {
		return file_upload_Btn;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Mark kit received')]")
	WebElement mark_Kit_Received_btn;

	public WebElement  get_Mark_Kit_Received_btn() {
		return mark_Kit_Received_btn;
	}
	
	@FindBy(id = "barcode")
	WebElement mark_Kit_Barcode_Field;

	public WebElement  get_Mark_Kit_Barcode_Field() {
		return mark_Kit_Barcode_Field;
	}
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement next_Button;

	public WebElement  get_next_Buttond() {
		return next_Button;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Mark as received')]")
	WebElement mark_Received_Button;

	public WebElement  get_mark_Received_Button() {
		return mark_Received_Button;
	}
	
	@FindBy(xpath = "//thead/tr/th")
	List<WebElement> table_Headers;

	public List<WebElement> get_Table_Headers() {
		return table_Headers;
	}

	
	

}
