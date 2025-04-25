package Test.Hcp.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tims_TC_For_HCP_Smoke_Locators {
	public WebDriver driver;

	public Tims_TC_For_HCP_Smoke_Locators(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	@FindBy(xpath = "//a[normalize-space()='Test kits']")
	private WebElement testKitMenu;

	public WebElement gettestKitMenu() {
		return testKitMenu;
	}
	@FindBy(xpath = "//button[normalize-space()='Mark kit received']")
	private WebElement markKitReceivedBtn;

	public WebElement getmarkKitReceivedBtn() {
		return markKitReceivedBtn;
	}
	@FindBy(xpath = "//input[@name='barcode']")
	private WebElement barcodeTxt;

	public WebElement getbarcodeTxt() {
		return barcodeTxt;
	}
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextBtn;

	public WebElement getnextBtn() {
		return nextBtn;
	}
	@FindBy(xpath = "//button[contains(text(),'Mark as received')]")
	private WebElement markAsReceivedBtn;

	public WebElement getmarkAsReceivedBtn() {
		return markAsReceivedBtn;
	}
	@FindBy(xpath = "//button[normalize-space()='Upload blood result CSV']")
	private WebElement uploadCsvBtn;

	public WebElement getuploadCsvBtn() {
		return uploadCsvBtn;
	}
	@FindBy(xpath = "(//input[@accept='.csv'])[2]")
	private WebElement browseCsv;

	public WebElement getbrowseCsv() {
		return browseCsv;
	}
	@FindBy(xpath = "//span[contains(text(),'Upload')]")
	private WebElement uploadCsvAfterAddingFileBtn;

	public WebElement getuploadCsvAfterAddingFileBtn() {
		return uploadCsvAfterAddingFileBtn;
	}
	@FindBy(xpath = "//tbody/tr[1]/td[5]")
	private WebElement barcodeErrorStatus;

	public WebElement getbarcodeErrorStatus() {
		return barcodeErrorStatus;
	}	
	@FindBy(xpath = "//input[@id='searchInput3']")
	private WebElement primaryBarcodeSearch;

	public WebElement getprimaryBarcodeSearch() {
		return primaryBarcodeSearch;
	}

}
