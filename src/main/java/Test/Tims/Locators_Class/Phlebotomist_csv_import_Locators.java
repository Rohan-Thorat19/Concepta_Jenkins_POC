package Test.Tims.Locators_Class;

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


	
	


}
