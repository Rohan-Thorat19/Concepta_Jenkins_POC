package Test.Tims.Partial_Report_Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SOFT_1405_Partial_Report_Locators {

	public WebDriver driver;

	public SOFT_1405_Partial_Report_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath ="//div[@id='toaster-msg']//p")
	private WebElement toasterMsg;
	
	public WebElement get_toasterMsg() {
		return toasterMsg;
	}
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/a")
	private WebElement testKitId;

	public WebElement get_testKitId() {
		return  testKitId;
	}
	
	@FindBy(xpath = "//tbody/tr[1]/td[12]")
	private WebElement testKitStatusTims;

	public WebElement get_testKitStatusTims() {
		return  testKitStatusTims;
	}
	
	@FindBy(xpath = "//h4[normalize-space()='Status']/following-sibling::h5")
	private WebElement testKitStatusDashboard;

	public WebElement get_testKitStatusDashboard() {
		return  testKitStatusDashboard;
	}
	
	@FindBy(xpath = "//select[@id='overallStatusSelect']")
	private WebElement overallStatusDrp;

	public WebElement get_overallStatusDrp() {
		return  overallStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='liverhealth-groupStatusSelect']")
	private WebElement liverHealthGroupStatusDrp;

	public WebElement get_liverHealthGroupStatusDrp() {
		return  liverHealthGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='kidneyhealth-groupStatusSelect']")
	private WebElement kidneyHealthGroupStatusDrp;

	public WebElement get_kidneyHealthGroupStatusDrp() {
		return  kidneyHealthGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='thyroidprofile-groupStatusSelect']")
	private WebElement thyroidProfileGroupStatusDrp;

	public WebElement get_thyroidProfileGroupStatusDrp() {
		return  thyroidProfileGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='vitaminsminerals-groupStatusSelect']")
	private WebElement vitaminsMineralsGroupStatusDrp;

	public WebElement get_vitaminsMineralsGroupStatusDrp() {
		return  vitaminsMineralsGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='fullbloodcount-groupStatusSelect']")
	private WebElement fullBloodCountGroupStatusDrp;

	public WebElement get_fullBloodCountGroupStatusDrp() {
		return  fullBloodCountGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='cholesterol-groupStatusSelect']")
	private WebElement cholesterolGroupStatusDrp;

	public WebElement get_cholesterolGroupStatusDrp() {
		return  cholesterolGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='hormones-groupStatusSelect']")
	private WebElement hormonesGroupStatusDrp;

	public WebElement get_hormonesGroupStatusDrp() {
		return  hormonesGroupStatusDrp;
	}
	
	@FindBy(xpath = "//select[@id='glucose-groupStatusSelect']")
	private WebElement glucoseGroupStatusDrp;

	public WebElement get_glucoseGroupStatusDrp() {
		return  glucoseGroupStatusDrp;
	}
	
	@FindBy(xpath = "//div[@id='nav-tab']/a[normalize-space()='Report']")
	private WebElement headerReportTab;

	public WebElement get_headerReportTab() {
		return  headerReportTab;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Save changes']")
	private WebElement testReportSaveChangesBtn;

	public WebElement get_testReportSaveChangesBtn() {
		return  testReportSaveChangesBtn;
	}
	
	@FindBy(xpath = "//button[@id='publish-btn']")
	private WebElement headerMenuPublishBtn;

	public WebElement get_headerMenuPublishBtn() {
		return  headerMenuPublishBtn;
	}
	
	@FindBy(xpath = "//div[@id='publishModal']//button[@type='submit'][normalize-space()='Yes']")
	private WebElement publishYesBtn;

	public WebElement get_publishYesBtn() {
		return  publishYesBtn;
	}
	
	@FindBy(xpath = "//div[@id='toster-msg']//p[contains(text(),'Published Report')]")
	private WebElement reportPublishedToasterMsg;

	public WebElement get_reportPublishedToasterMsg() {
		return  reportPublishedToasterMsg;
	}
	
	@FindBy(xpath = "//button[@id='generalButton']")
	private WebElement testReportGeneralBtn;

	public WebElement get_testReportGeneralBtn() {
		return  testReportGeneralBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Liver health']")
	private WebElement testReportLiverHealthBtn;

	public WebElement get_testReportLiverHealthBtn() {
		return  testReportLiverHealthBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Kidney health']")
	private WebElement testReportKidneyHealthBtn;

	public WebElement get_testReportKidneyHealthBtn() {
		return  testReportKidneyHealthBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Thyroid Profile']")
	private WebElement testReportThyroidProfileBtn;

	public WebElement get_testReportThyroidProfileBtn() {
		return  testReportThyroidProfileBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Vitamins & Minerals']")
	private WebElement testReportVitaminsMineralsBtn;

	public WebElement get_testReportVitaminsMineralsBtn() {
		return  testReportVitaminsMineralsBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Full blood count']")
	private WebElement testReportFullBloodCountBtn;

	public WebElement get_testReportFullBloodCountBtn() {
		return  testReportFullBloodCountBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Cholesterol']")
	private WebElement testReportCholesterolBtn;

	public WebElement get_testReportCholesterolBtn() {
		return  testReportCholesterolBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Hormones']")
	private WebElement testReportHormonesBtn;

	public WebElement get_testReportHormonesBtn() {
		return  testReportHormonesBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Glucose']")
	private WebElement testReportGlucoseBtn;

	public WebElement get_testReportGlucoseBtn() {
		return  testReportGlucoseBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Your results']")
	private WebElement dbTestReportYourResultsBtn;

	public WebElement get_dbTestReportYourResultsBtn() {
		return  dbTestReportYourResultsBtn;
	}
	
	@FindBy(xpath = "//tr[@class='partial-report-row']")
	private WebElement timsPartialReportRow;

	public WebElement get_timsPartialReportRow() {
		return  timsPartialReportRow;
	}
	
	@FindBy(xpath = "//td[normalize-space()='Folate']")
	private WebElement timsFolateBiomarker;

	public WebElement get_timsFolateBiomarker() {
		return  timsFolateBiomarker;
	}
	
	@FindBy(xpath = "//td[normalize-space()='Alanine Transaminase']")
	private WebElement timsALTBiomarker;

	public WebElement get_timsALTBiomarker() {
		return  timsALTBiomarker;
	}
	
	@FindBy(xpath = "//td[normalize-space()='Gamma-Glutamyl Transferase']")
	private WebElement timsGGTBiomarker;

	public WebElement get_timsGGTBiomarker() {
		return  timsGGTBiomarker;
	}
	
	@FindBy(xpath = "//td[normalize-space()='Alkaline Phosphatase']")
	private WebElement timsALPBiomarker;

	public WebElement get_timsALPBiomarker() {
		return  timsALPBiomarker;
	}
	
	@FindBy(xpath = "//a[@id='nav-test-report-info-tab']")
	private WebElement timsTestReportInfoTab;

	public WebElement get_timsTestReportInfoTab() {
		return  timsTestReportInfoTab;
	}
	
	@FindBy(xpath = "//a[normalize-space()='View Test Kit']")
	private WebElement timsViewTestKitHypLnk;

	public WebElement get_timsViewTestKitHypLnk() {
		return  timsViewTestKitHypLnk;
	}
	
	@FindBy(xpath = "//div[@id='nav-tab']/a[normalize-space()='Primary barcode results']")
	private WebElement timsTestKitsPrimaryBarcodeResultsTab;

	public WebElement get_timsTestKitsPrimaryBarcodeResultsTab() {
		return  timsTestKitsPrimaryBarcodeResultsTab;
	}
	
	@FindBy(xpath = "//table[@id='test-kit-result-table']//td[normalize-space()='FOL']")
	private WebElement timsPrimaryBarcodeResultsFolateBiomarker;

	public WebElement get_timsPrimaryBarcodeResultsFolateBiomarker() {
		return  timsPrimaryBarcodeResultsFolateBiomarker;
	}
	
	@FindBy(xpath = "//td[normalize-space()='ALT']")
	private WebElement timsPrimaryBarcodeResultsALTBiomarker;

	public WebElement get_timsPrimaryBarcodeResultsALTBiomarker() {
		return  timsPrimaryBarcodeResultsALTBiomarker;
	}
	
	@FindBy(xpath = "//td[normalize-space()='GGT']")
	private WebElement timsPrimaryBarcodeResultsGGTBiomarker;

	public WebElement get_timsPrimaryBarcodeResultsGGTBiomarker() {
		return  timsPrimaryBarcodeResultsGGTBiomarker;
	}
	
	@FindBy(xpath = "//td[normalize-space()='ALP']")
	private WebElement timsPrimaryBarcodeResultsALPBiomarker;

	public WebElement get_timsPrimaryBarcodeResultsALPBiomarker() {
		return  timsPrimaryBarcodeResultsALPBiomarker;
	}
	
	@FindBy(xpath = "//*[@class='healthArea__header-title']//*[@data-icon='circle-info']")
	private WebElement dashboardReportsInfoIcon;

	public WebElement get_dashboardReportsInfoIcon() {
		return  dashboardReportsInfoIcon;
	}
	
	@FindBy(xpath = "//div[@class='tooltip-inner']")
	private WebElement dashboardReportsTooltip;

	public WebElement get_dashboardReportsTooltip() {
		return  dashboardReportsTooltip;
	}
	
	@FindBy(xpath = "//div[@class='blood-report-main--desktop']//div[@role='alert']//p")
	private WebElement dashboardCouldNotBeReportedError;

	public WebElement get_dashboardCouldNotBeReportedError() {
		return  dashboardCouldNotBeReportedError;
	}
	
	@FindBy(xpath = "(//div[@class='blood-report-main--desktop']//div[@role='alert']//p)[1]")
	private WebElement dashboardCouldNotBeReportedError1;

	public WebElement get_dashboardCouldNotBeReportedError1() {
		return  dashboardCouldNotBeReportedError1;
	}
	
	@FindBy(xpath = "//div[@class='blood-report-main--desktop']//div[@role='alert']//p/strong[text()='Alanine Transaminase']")
	private WebElement dashboardALTCouldNotBeReportedError;

	public WebElement get_dashboardALTCouldNotBeReportedError() {
		return  dashboardALTCouldNotBeReportedError;
	}
	
	@FindBy(xpath = "//div[@class='blood-report-main--desktop']//div[@role='alert']//p/strong[text()='Alkaline Phosphatase']")
	private WebElement dashboardALPCouldNotBeReportedError;

	public WebElement get_dashboardALPCouldNotBeReportedError() {
		return  dashboardALPCouldNotBeReportedError;
	}
	
	@FindBy(xpath = "//span[normalize-space()='Vitamins & Minerals']/ancestor::button")
	private WebElement vitaminsMineralsHealthAreaBtn;

	public WebElement get_vitaminsMineralsHealthAreaBtn() {
		return  vitaminsMineralsHealthAreaBtn;
	}
	
	@FindBy(xpath = "//span[normalize-space()='Liver health']/ancestor::button")
	private WebElement liverHealthHealthAreaBtn;

	public WebElement get_liverHealthHealthAreaBtn() {
		return  liverHealthHealthAreaBtn;
	}
	
	@FindBy(xpath = "//span[normalize-space()='Glucose']/ancestor::button")
	private WebElement glucoseHealthAreaBtn;

	public WebElement get_glucoseHealthAreaBtn() {
		return  glucoseHealthAreaBtn;
	}
	
	@FindBy(xpath = "//button[@aria-label='Next']")
	private WebElement timsPrimaryBarcodeResultsNavNextPageBtn;

	public WebElement get_timsPrimaryBarcodeResultsNavNextPageBtn() {
		return  timsPrimaryBarcodeResultsNavNextPageBtn;
	}
	
	@FindBy(xpath = "//span[normalize-space()='Full blood count']/ancestor::button")
	private WebElement fullBloodCountHealthAreaBtn;

	public WebElement get_fullBloodCountHealthAreaBtn() {
		return  fullBloodCountHealthAreaBtn;
	}
}
