package Test.Tims.Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Barcode_Batches_Locators {

	public WebDriver driver;
	
	public Barcode_Batches_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//h5[@id='addlocationsModalLabel'][text()='Create blood batch']")
	private WebElement createBloodBatchWindow;
	
	public WebElement get_createBloodBatchWindow() {
		return createBloodBatchWindow;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//p[contains(text(),'How many barcodes')]")
	private WebElement howManyBarcodesHelpTxt;
	
	public WebElement get_howManyBarcodesHelpTxt() {
		return howManyBarcodesHelpTxt;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//textarea[@id='comment']")
	private WebElement commentFieldTxt;
	
	public WebElement get_commentFieldTxt() {
		return commentFieldTxt;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//label[@for='btype']/following-sibling::div[@id='btype_error']")
	private WebElement typeDrpErrorMsg;
	
	public WebElement get_typeDrpErrorMsg() {
		return typeDrpErrorMsg;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//label[@for='sub_type']/following-sibling::div[@id='sub_type_error']")
	private WebElement subtypeDrpErrorMsg;
	
	public WebElement get_subtypeDrpErrorMsg() {
		return subtypeDrpErrorMsg;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//label[@for='barcode_count']/following-sibling::div[@id='barcode_count_error']")
	private WebElement countDrpErrorMsg;
	
	public WebElement get_countDrpErrorMsg() {
		return countDrpErrorMsg;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//button[@type='button'][normalize-space()='Cancel']")
	private WebElement createBloodBatchCancelBtn;
	
	public WebElement get_createBloodBatchCancelBtn() {
		return createBloodBatchCancelBtn;
	}
	
	@FindBy(xpath ="//h5[@id='addlocationsModalLabel' and text()='Create blood batch']")
	private WebElement createBloodBatchTitleTxt;
	
	public WebElement get_createBloodBatchTitleTxt() {
		return createBloodBatchTitleTxt;
	}
	
	@FindBy(xpath ="//div[@class='toast-body']//p")
	private WebElement toasterAlert;
	
	public WebElement get_toasterAlert() {
		return toasterAlert;
	}
	
	@FindBy(xpath ="//button[normalize-space()='Create DNA batch']")
	private WebElement createDNABatchBtn;
	
	public WebElement get_createDNABatchBtn() {
		return createDNABatchBtn;
	}
	
	@FindBy(xpath ="//h5[@id='addlocationsModalLabel'][text()='Create DNA batch']")
	private WebElement createDNABatchForm;
	
	public WebElement get_createDNABatchForm() {
		return createDNABatchForm;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//select[@id='btype']")
	private WebElement createDNABatchTypeDrp;
	
	public WebElement get_createDNABatchTypeDrp() {
		return createDNABatchTypeDrp;
	}
	
	@FindBy(xpath ="//input[@id='sub_type']")
	private WebElement createDNABatchSubTypeDrp;
	
	public WebElement get_createDNABatchSubTypeDrp() {
		return createDNABatchSubTypeDrp;
	}
	
	@FindBy(xpath = "//form[@id='add_wellness_form']//input[@id='barcode_count']") // 2
	private WebElement barcodeCountTxtDNA;

	public WebElement get_barcodeCountTxtDNA() {
		return barcodeCountTxtDNA;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//p[contains(text(),'How many barcodes')]")
	private WebElement howManyBarcodesHelpTxtDNA;
	
	public WebElement get_howManyBarcodesHelpTxtDNA() {
		return howManyBarcodesHelpTxtDNA;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//label[@for='barcode_count']/following-sibling::div[@id='barcode_count_error']")
	private WebElement countDrpErrorMsgDNA;
	
	public WebElement get_countDrpErrorMsgDNA() {
		return countDrpErrorMsgDNA;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//select[@id='customer']")
	private WebElement createDNABatchCustDrp;
	
	public WebElement get_createDNABatchCustDrp() {
		return createDNABatchCustDrp;
	}
	
	@FindBy(xpath ="//h5[@id='addlocationsModalLabel' and text()='Create DNA batch']")
	private WebElement createDNABatchTitleTxt;
	
	public WebElement get_createDNABatchTitleTxt() {
		return createDNABatchTitleTxt;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//button[@type='button'][normalize-space()='Cancel']")
	private WebElement createDNABatchCancelBtn;
	
	public WebElement get_createDNABatchCancelBtn() {
		return createDNABatchCancelBtn;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//button[@id='save_button']")
	private WebElement createDNABatchSaveBtn;
	
	public WebElement get_createDNABatchSaveBtn() {
		return createDNABatchSaveBtn;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//label[@for='btype']/following-sibling::div[@id='btype_error']")
	private WebElement dnaBatchTypeDrpErrorMsg;
	
	public WebElement get_dnaBatchTypeDrpErrorMsg() {
		return dnaBatchTypeDrpErrorMsg;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//div[@id='barcode_count_error']")
	private WebElement dnaBatchCountErrorMsg;
	
	public WebElement get_dnaBatchCountErrorMsg() {
		return dnaBatchCountErrorMsg;
	}
	
	@FindBy(xpath ="//h5[@id='addlocationsModalLabel'][text()='Create DNA batch']")
	private WebElement createDNABatchWindow;
	
	public WebElement get_createDNABatchWindow() {
		return createDNABatchWindow;
	}
	
	@FindBy(xpath ="//div[@id='toster-msg']//p[contains(text(),'Barcodes created')]")
	private WebElement barcodeCreatedToaster;
	
	public WebElement get_barcodeCreatedToaster() {
		return barcodeCreatedToaster;
	}
	
	@FindBy(xpath ="//button[normalize-space()='Edit']")
	private WebElement barcodeBatchEditBtn;
	
	public WebElement get_barcodeBatchEditBtn() {
		return barcodeBatchEditBtn;
	}
	
	@FindBy(xpath ="//form[@id='edit_batch_form']//select[@id='customer']")
	private WebElement editBatchFormCustDrp;
	
	public WebElement get_editBatchFormCustDrp() {
		return editBatchFormCustDrp;
	}
	
	@FindBy(xpath ="//form[@id='edit_batch_form']//textarea[@id='comment']")
	private WebElement editBatchFormCommentTxt;
	
	public WebElement get_editBatchFormCommentTxt() {
		return editBatchFormCommentTxt;
	}
	
	@FindBy(xpath ="//form[@id='edit_batch_form']//button[@id='save_edit_button']")
	private WebElement editBatchFormSaveBtn;
	
	public WebElement get_editBatchFormSaveBtn() {
		return editBatchFormSaveBtn;
	}
	
	@FindBy(xpath ="//th[normalize-space()='Customer name:']/following-sibling::td")
	private WebElement batchDetailsCustNameValue;
	
	public WebElement get_batchDetailsCustNameValue() {
		return batchDetailsCustNameValue;
	}
	
	@FindBy(xpath ="//th[normalize-space()='Comment:']/following-sibling::td")
	private WebElement batchDetailsCommentValue;
	
	public WebElement get_batchDetailsCommentValue() {
		return batchDetailsCommentValue;
	}
	
	@FindBy(xpath ="//div[@id='toaster-msg']//p")
	private WebElement batchUpdatedToasterMsg;
	
	public WebElement get_batchUpdatedToasterMsg() {
		return batchUpdatedToasterMsg;
	}
	
	@FindBy(xpath ="//form[@id='edit_batch_form']//button[text()='Cancel']")
	private WebElement editBatchFormCancelBtn;
	
	public WebElement get_editBatchFormCancelBtn() {
		return editBatchFormCancelBtn;
	}
	
	@FindBy(xpath ="//table[@id='user-table']//tr[1]/td[1]/a")
	private WebElement latestBatchTypeBatchDetails;
	
	public WebElement get_latestBatchTypeBatchDetails() {
		return latestBatchTypeBatchDetails;
	}
	
	@FindBy(xpath ="//a[@id='nav-profile-tab']")
	private WebElement batchDetailsTab;
	
	public WebElement get_batchDetailsTab() {
		return batchDetailsTab;
	}
	
	@FindBy(xpath ="//table[@id='barcode-table']//td[1]/a")
	private List<WebElement> listOfGeneratedBarcodes;
	
	public List<WebElement> get_listOfGeneratedBarcodes() {
		return listOfGeneratedBarcodes;
	}
	
	@FindBy(xpath ="//table[@id='barcode-table']/tbody/tr")
	private List<WebElement> barcodeRows;
	
	public List<WebElement> get_barcodeRows() {
		return barcodeRows;
	}
	
	@FindBy(xpath ="//div[@id='nav-tab']/a[text()='Barcode details']")
	private WebElement barcodeDetailsTab;
	
	public WebElement get_barcodeDetailsTab() {
		return barcodeDetailsTab;
	}
	
//	@FindBy(xpath ="//table[@id='barcode-table']//tr[1]/td[1]/a")
//	private WebElement latestBarcode;
//	
//	public WebElement get_latestBarcode() {
//		return latestBarcode;
//	}
	
}
