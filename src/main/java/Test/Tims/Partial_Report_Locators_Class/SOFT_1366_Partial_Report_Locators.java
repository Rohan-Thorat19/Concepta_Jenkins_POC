package Test.Tims.Partial_Report_Locators_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SOFT_1366_Partial_Report_Locators {
	public WebDriver driver;

	public SOFT_1366_Partial_Report_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//a[@href='/admin/test-reports/' and contains(normalize-space(.), 'Test reports')]")
	private WebElement testReportSideMenuItem;

	public WebElement get_testReportSideMenuItem() {
		return testReportSideMenuItem;
	}
	
	@FindBy(xpath = "//a[@href='/admin/test-kits/' and contains(normalize-space(.), 'Test kits')]")
	private WebElement testKitsSideMenuItem;

	public WebElement get_testKitsSideMenuItem() {
		return testKitsSideMenuItem;
	}
	
	@FindBy(xpath = "//input[@placeholder='Primary barcode']")
	private WebElement primaryBarcodeSearchTxtBox;

	public WebElement get_primaryBarcodeSearchTxtBox() {
		return primaryBarcodeSearchTxtBox;
	}
	
	@FindBy(xpath = "//p[contains(text(),'tests ready for review')]")
	private WebElement readyForReviewBtn;

	public WebElement get_readyForReviewBtn() {
		return readyForReviewBtn;
	}
	@FindBy(xpath = "//table[@id='test-report-table']//tbody//tr[1]//td[@class='sorting_1']//a")
	private WebElement firstIDItem;

	public WebElement get_firstIDItem() {
		return firstIDItem;
	}
		
	@FindBy(xpath = "//button[@id='assign-btn']")
	private WebElement assignBtn;

	public WebElement get_assignBtn() {
		return assignBtn;
	}
	
	@FindBy(xpath = "(//button[contains(text(),'Assign')])[2]")
	private WebElement assignBtnInAlertBox;

	public WebElement get_assignBtnInAlertBox() {
		return assignBtnInAlertBox;
	}
	
	@FindBy(xpath = "//a[@id='nav-report-tab']")
	private WebElement reportTabBtn;

	public WebElement get_reportTabBtn() {
		return reportTabBtn;
	}
	
	
	@FindBy(xpath = "//div[@class='accordion summary-tab-accordion']")
	private WebElement groupsDisplayed;

	public WebElement get_groupsDisplayed() {
		return groupsDisplayed;
	}
	@FindBy(xpath = "//button[@id='generalButton']")
	private WebElement generalBtn;

	public WebElement get_generalBtn() {
		return generalBtn;
	}
	
	@FindBy(xpath = "//h6[contains(text(),'Kidney health')]")
	private WebElement kidneyHealthBtn;

	public WebElement get_kidneyHealthBtn() {
		return kidneyHealthBtn;
	}
	
	@FindBy(xpath = "//h6[contains(text(),'Thyroid Profile')]")
	private WebElement thyroidProfileBtn;

	public WebElement get_thyroidProfileBtn() {
		return thyroidProfileBtn;
	}
	
	@FindBy(xpath = "//h6[contains(text(),'Vitamins & Minerals')]")
	private WebElement vitaminsAndMineralsBtn;

	public WebElement get_vitaminsAndMineralsBtn() {
		return vitaminsAndMineralsBtn;
	}
	
	@FindBy(xpath = "//h6[contains(text(),'Full blood count')]")
	private WebElement fullBloodCountBtn;

	public WebElement get_fullBloodCountBtn() {
		return fullBloodCountBtn;
	}
	
	@FindBy(xpath = "//h6[contains(text(),'Glucose')]")
	private WebElement glucoseBtn;

	public WebElement get_glucoseBtn() {
		return glucoseBtn;
	}
	
	@FindBy(xpath = "//h6[contains(text(),'Cholesterol')]")
	private WebElement cholesterolBtn;

	public WebElement get_cholesterolBtn() {
		return cholesterolBtn;
	}
	
	@FindBy(xpath = "//h6[contains(text(),'Liver health')]")
	private WebElement liverHealthBtn;

	public WebElement get_liverHealthBtn() {
		return liverHealthBtn;
	}
	
	
	@FindBy(xpath = "//select[@id='cholesterol-groupStatusSelect']")
	private WebElement cholesterolGroupStatusDrp;

	public WebElement get_cholesterolGroupStatusDrp() {
		return cholesterolGroupStatusDrp;
	}
	
	
	@FindBy(xpath = "//table[@id='test-kits-table']//tr[1]/td[1]/a")
	private WebElement testKitId;

	public WebElement get_testKitId() {
		return testKitId;
	}
	
	@FindBy(xpath = "//a[contains(text(),'View report')]")
	private WebElement viewReportLink;

	public WebElement get_viewReportLink() {
		return viewReportLink;
	}
	
	@FindBy(xpath = "//h5[contains(text(),'Assigned')]")
	private WebElement assignedTabBtn;

	public WebElement get_assignedTabBtn() {
		return assignedTabBtn;
	}
	
	@FindBy(xpath = "//select[@id='glucose-groupStatusSelect']")
	private WebElement glucoseGroupStatusDrp;

	public WebElement get_glucoseGroupStatusDrp() {
		return glucoseGroupStatusDrp;
	}
	@FindBy(xpath = "//select[@id='liverhealth-groupStatusSelect']")
	private WebElement liverHealthGroupStatusDrp;

	public WebElement get_liverHealthGroupStatusDrp() {
		return liverHealthGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='kidneyhealth-groupStatusSelect']")
	private WebElement kidneyGroupStatusDrp;

	public WebElement get_kidneyGroupStatusDrp() {
		return kidneyGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='thyroidprofile-groupStatusSelect']")
	private WebElement thyroidGroupStatusDrp;

	public WebElement get_thyroidGroupStatusDrp() {
		return thyroidGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='vitaminsminerals-groupStatusSelect']")
	private WebElement vitaminGroupStatusDrp;

	public WebElement get_vitaminGroupStatusDrp() {
		return vitaminGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='fullbloodcount-groupStatusSelect']")
	private WebElement bloodCountGroupStatusDrp;

	public WebElement get_bloodCountGroupStatusDrp() {
		return bloodCountGroupStatusDrp;
	}
	@FindBy(xpath = "//select[@id='overallStatusSelect']")
	private WebElement overallStatusDrp;

	public WebElement get_overallStatusDrp() {
		return overallStatusDrp;
	}
	
	
	@FindBy(xpath = "//h6[contains(text(),'No group page')]")
	private WebElement noGroupAgeBtn;

	public WebElement get_noGroupAgeBtn() {
		return noGroupAgeBtn;
	}
	
	@FindBy(xpath = "//select[@id='nogrouppage-groupStatusSelect']")
	private WebElement groupStatusDrp;

	public WebElement get_groupStatusDrp() {
		return groupStatusDrp;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Save changes')]")
	private WebElement saveChangesBtn;

	public WebElement get_saveChangesBtn() {
		return saveChangesBtn;
	}
	
	@FindBy(xpath = "//button[@id='publish-btn']")
	private WebElement publishBtn;

	public WebElement get_publishBtn() {
		return publishBtn;
	}
	
	@FindBy(xpath = "(//button[contains(text(),'Yes')])[2]")
	private WebElement yesAlertBtn;

	public WebElement get_yesAlertBtnn() {
		return yesAlertBtn;
	}
	
	@FindBy(xpath = "//h5[contains(text(),'Result published')]")
	private WebElement resultPublishedBtn;

	public WebElement get_resultPublishedBtn() {
		return resultPublishedBtn;
	}
		
	@FindBy(xpath = "(//table//tbody//tr[3]//td[3]//a)[1]")
	private WebElement viewReportID;

	public WebElement get_viewReportID() {
		return viewReportID;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Liver health')]")
	private WebElement liverHealthOption;

	public WebElement get_liverHealthOption() {
		return liverHealthOption;
	}
	
			@FindBy(xpath = "(//div[@class='marker-card-container marker-card-low-normal'])[7]")
			private WebElement allOptionDisplayed;

			public WebElement get_allOptionDisplayed() {
				return allOptionDisplayed;
			}
	
	@FindBy(xpath = "//div[@class='marker-card-container']//strong[contains(normalize-space(.),'Alkaline Phosphatase')]")
	private WebElement ALT_GGT_ALP_Text;

	public WebElement get_ALT_GGT_ALP_Text() {
		return ALT_GGT_ALP_Text;
	}
	
	@FindBy(xpath = "//div[@class='marker-card-container']//strong[contains(normalize-space(.),'Alanine Transaminase')]")
	private WebElement ALT_Text;

	public WebElement get_ALT_Text() {
		return ALT_Text;
	}

	@FindBy(xpath = "(//td[contains(text(),'error')])[1]")
	private WebElement Error_Status_For_Test_Kit;

	public WebElement get_Error_Status_For_Test_Kit() {
		return Error_Status_For_Test_Kit;
	}
	
	@FindBy(xpath = "//h5[contains(text(),'Error')]")
	private WebElement Error_Tab;

	public WebElement get_Error_Tab() {
		return Error_Tab;
	}
	
	
	@FindBy(xpath = "//*[@id='test-report-table']/tbody/tr")
	private WebElement Entry_Available_In_Error_Tab;

	public WebElement get_Entry_Available_In_Error_Tab() {
		return Entry_Available_In_Error_Tab;
	}
	@FindBy(xpath = "//div[@class='marker-card-container']//strong[contains(normalize-space(.),'Gamma-Glutamyl Transferase')]")
	private WebElement GGT_Text;

	public WebElement get_GGT_Text() {
		return GGT_Text;
	}
	
	@FindBy(xpath = "//div[@class='marker-card-container']//strong[contains(normalize-space(.),'Alanine Transaminase')]")
	private WebElement ALP_Text;

	public WebElement get_ALP_Text() {
		return ALP_Text;
	}
	
	@FindBy(xpath = "//div[@class='marker-card-container']//strong[contains(normalize-space(.),'Alanine Transaminase & Gamma-Glutamyl Transferase')]")
	private WebElement ALT_GGT_Text;

	public WebElement get_ALT_GGT_Text() {
		return ALT_GGT_Text;
	}
	
	@FindBy(xpath = "//div[@class='marker-card-container']//strong[contains(normalize-space(.),'Alkaline Phosphatase & Alanine Transaminase')]")
	private WebElement ALT_ALP_Text;

	public WebElement get_ALT_ALP_Text() {
		return ALT_ALP_Text;
	}
	
	@FindBy(xpath = "//div[@class='marker-card-container']//strong[contains(normalize-space(.),'Alkaline Phosphatase & Gamma-Glutamyl Transferase')]")
	private WebElement ALP_GGT_Text;

	public WebElement get_ALP_GGT_Text() {
		return ALP_GGT_Text;
	}
	
	
	@FindBy(xpath = "//textarea[@id='doctorsLetter']")
	private WebElement Doctors_Letter;

	public WebElement get_Doctors_Letter() {
		return Doctors_Letter;
	}
}
