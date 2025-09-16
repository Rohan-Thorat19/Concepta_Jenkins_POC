package Test.Tims.Partial_Report_Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SOFT_1407_Partial_Report_Locators {

	public WebDriver driver;

	public SOFT_1407_Partial_Report_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "(//div[@class='table-responsive'])[5]//tbody//td[1]")
	private List<WebElement> lavenderFullBloodCountBiomarkerList;
	
	public List<WebElement> get_lavenderFullBloodCountBiomarkerList() {
		return lavenderFullBloodCountBiomarkerList;
	} 
	
	@FindBy(xpath = "//div[@id='nav-tab']/a[normalize-space()='Secondary barcode results']")
	private WebElement timsTestKitsSecondaryBarcodeResultsTab;

	public WebElement get_timsTestKitsSecondaryBarcodeResultsTab() {
		return  timsTestKitsSecondaryBarcodeResultsTab;
	}
	
	@FindBy(xpath = "(//table[@id='secondary-test-kit-result-table']/tbody//tr)")
	private List<WebElement> secondaryResultsFullBloodCountBiomarkerRows;
	
	public List<WebElement> get_secondaryResultsFullBloodCountBiomarkerRows() {
		return secondaryResultsFullBloodCountBiomarkerRows;
	} 
	
	
	@FindBy(xpath = "//button[@aria-label='Next']")
	private WebElement timsSecondaryBarcodeResultsNavForwardBtn;

	public WebElement get_timsSecondaryBarcodeResultsNavForwardBtn() {
		return  timsSecondaryBarcodeResultsNavForwardBtn;
	}
	
}
