package Test.Tims.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Tims.Locators_Class.Barcode_Batches_Locators;
import Wrappers.CaptureScreenshot;
import Wrappers.WebButton;
import Wrappers.WebDropDown;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.BaseClass;
import initializer.ExtentManager;

public class Barcode_Batches_Actions extends BaseClass {

	public WebDriver driver;
	Barcode_Batches_Locators barcode_batches_locators;
	Activate_Test_Kit_Actions activate_test_kit_actions;
	Activate_Test_Kit_Locators activate_test_kit_locators;
	
	public Barcode_Batches_Actions(WebDriver driver) {
		this.driver = driver;
		barcode_batches_locators = new Barcode_Batches_Locators(driver);
		activate_test_kit_actions = new Activate_Test_Kit_Actions(driver);
		activate_test_kit_locators = new Activate_Test_Kit_Locators(driver);
	}
	
	
	public void presenceofCreateBloodBatchBtn() throws IOException, InterruptedException {
		activate_test_kit_actions.dashboardUrlOfTims();
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_createBloodBatchBtn(), Duration.ofSeconds(10));
		assertTrue(activate_test_kit_locators.get_createBloodBatchBtn().isDisplayed(), "Create blood batch button is not displayed");
		System.out.println("Validation: '"+activate_test_kit_locators.get_createBloodBatchBtn().getText()+"' is displayed");
		ExtentManager.getTest().log(Status.PASS, "Validation: '"+activate_test_kit_locators.get_createBloodBatchBtn().getText()+"' is displayed");
		CaptureScreenshot.captureAndAttachScreenshot("");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_createBloodBatchBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_createBloodBatchBtn(), driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_createBloodBatchWindow(), Duration.ofSeconds(10));
		assertTrue(barcode_batches_locators.get_createBloodBatchWindow().isDisplayed(), "Create blood batch button is not clickable");
		System.out.println("Validation: '"+activate_test_kit_locators.get_createBloodBatchBtn().getText()+"' is clickable");
		ExtentManager.getTest().log(Status.PASS, "Validation: '"+activate_test_kit_locators.get_createBloodBatchBtn().getText()+"' is clickable");
	}
	
	public void verifyOpeningOfCreateBloodBatchForm() {
		assertTrue(barcode_batches_locators.get_createBloodBatchWindow().isDisplayed(), "Create blood batch form is displayed");
		System.out.println("Validation: '"+barcode_batches_locators.get_createBloodBatchWindow().getText()+"' is displayed");
		ExtentManager.getTest().log(Status.PASS, "Validation: '"+activate_test_kit_locators.get_createBloodBatchBtn().getText()+"' is clickable");
	}
	
	public void verifyTypeDrpContainsOnlyBlood() throws InterruptedException {
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_typeDrp(), Duration.ofSeconds(10));
		WebElement typeDrp = activate_test_kit_locators.get_typeDrp();
		WebButton.JsclickButton(typeDrp, driver);
		List<String> expectedOptions = Arrays.asList("-","blood");
		List<String> actualOptions = WebDropDown.getDropdownOptions(driver, typeDrp);
		StringBuilder recordLog = new StringBuilder();
		System.out.println("Actual dropdown options:");
		for(String option:actualOptions) {
			System.out.println(option);
			recordLog.append(option).append("<br>");
		}
		assertEquals(actualOptions, expectedOptions, "One or more dropdown values are missing");
		ExtentManager.getTest().log(Status.PASS, "Dropdown options:<br> "+recordLog.toString());
	}
	
	public void verifyNoInvalidOptsInTypeDrp() {
		WebElement typeDrp = activate_test_kit_locators.get_typeDrp();
		WebButton.JsclickButton(typeDrp, driver);
		List<String> expectedOptions = Arrays.asList("-","blood");
		List<String> actualOptions = WebDropDown.getDropdownOptions(driver, typeDrp);
		StringBuilder recordLog = new StringBuilder();
		System.out.println("Actual dropdown options:");
		for(String option:actualOptions) {
			System.out.println(option);
			recordLog.append(option).append("<br>");
		}
		assertEquals(actualOptions, expectedOptions, "One or more dropdown values are missing");
		ExtentManager.getTest().log(Status.PASS, "Dropdown options:<br> "+recordLog.toString());
	}
	
	public void verifySubTypeDrpValues() {
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_subTypeDrp(), Duration.ofSeconds(10));
		WebElement SubTypeDrp = activate_test_kit_locators.get_subTypeDrp();
		WebButton.JsclickButton(SubTypeDrp, driver);
		List<String> expectedOptions = Arrays.asList("-","Gold","Lavender","Blue","Phlebotomy gold","Phlebotomy lavender");
		List<String> actualOptions = WebDropDown.getDropdownOptions(driver, SubTypeDrp);
		StringBuilder recordLog = new StringBuilder();
		System.out.println("Actual dropdown options:");
		for(String option:actualOptions) {
			System.out.println(option);
			recordLog.append(option).append("<br>");
		}
		assertEquals(actualOptions, expectedOptions, "One or more dropdown values are missing");
		ExtentManager.getTest().log(Status.PASS, "Dropdown options:<br> "+recordLog.toString());
	}
	
	public void verifyHelpTextForCountField() {
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_howManyBarcodesHelpTxt(), Duration.ofSeconds(10));
		String actualText = barcode_batches_locators.get_howManyBarcodesHelpTxt().getText();
		String expectedText = "How many barcodes would you like to generate?";
		assertEquals(actualText, expectedText, "Help text mismatch");
		System.out.println("Help text: "+actualText);
		ExtentManager.getTest().log(Status.PASS, "Help text: "+actualText);
	}
	
	public void presenceAndFunctionalityOfCommentField() {
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_commentFieldTxt(), Duration.ofSeconds(10));
		assertTrue(barcode_batches_locators.get_commentFieldTxt().isDisplayed(), "Comment field is not displayed");
		assertTrue(barcode_batches_locators.get_commentFieldTxt().isEnabled(), "Comment field is not enabled");
		WebTextBox.sendInputUpdate(barcode_batches_locators.get_commentFieldTxt(), "Blood Test");
		System.out.println("Validation: Comment field is present and allows input");
		ExtentManager.getTest().log(Status.PASS, "Validation: Comment field is present and allows input");
	}
	
	public void verifyCustomerDrpValues() {
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_customerDrp(), Duration.ofSeconds(10));
		WebElement custDrp = activate_test_kit_locators.get_customerDrp();
		WebButton.JsclickButton(custDrp, driver);
		List<String> expectedOptions = Arrays.asList("-","Boots","Lloyds","Pharmacy 2 U","Boots","Boots","Boots private label");
		List<String> actualOptions = WebDropDown.getDropdownOptions(driver, custDrp);
		StringBuilder recordLog = new StringBuilder();
		System.out.println("Actual dropdown options:");
		for(String option:actualOptions) {
			System.out.println(option);
			recordLog.append(option).append("<br>");
		}
		assertEquals(actualOptions, expectedOptions, "One or more dropdown values are missing");
		ExtentManager.getTest().log(Status.PASS, "Dropdown options:<br> "+recordLog.toString());
	}
	
	public void verifyErrorMessageCreateBloodBatch() {
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_saveBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_saveBtn(), driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement typeError = barcode_batches_locators.get_typeDrpErrorMsg();
		WebElement subtypeError = barcode_batches_locators.get_subtypeDrpErrorMsg();
		WebElement countError = barcode_batches_locators.get_countDrpErrorMsg();
		System.out.println("Error message(Type): "+typeError.getText());
		System.out.println("Error message(SubType): "+subtypeError.getText());
		System.out.println("Error message(Count): "+countError.getText());
		assertTrue(typeError.isDisplayed(), "Type error is not displayed");
		assertTrue(subtypeError.isDisplayed(), "SubType error is not displayed");
		assertTrue(countError.isDisplayed(), "Count error is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Error message(Type): "+typeError.getText());
		ExtentManager.getTest().log(Status.PASS, "Error message(SubType): "+subtypeError.getText());
		ExtentManager.getTest().log(Status.PASS, "Error message(Count): "+countError.getText());
	}
	
	public void verifyCancelBtnFunctionality() {
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_createBloodBatchCancelBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_createBloodBatchCancelBtn(), driver);
		assertFalse(barcode_batches_locators.get_createBloodBatchWindow().isDisplayed(), "Create blood batch form is not closed");
		System.out.println("Valiation: Create blood batch form is closed without saving any changes");
		ExtentManager.getTest().log(Status.PASS, "Valiation: Create blood batch form is closed without saving any changes");
	}
	
	public void presenceOfCreateBloodBatchTitle() throws IOException, InterruptedException {
		activate_test_kit_actions.dashboardUrlOfTims();
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_createBloodBatchBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_createBloodBatchBtn(), driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_createBloodBatchTitleTxt(), Duration.ofSeconds(10));
		System.out.println("Title: "+barcode_batches_locators.get_createBloodBatchTitleTxt().getText());
		assertEquals(barcode_batches_locators.get_createBloodBatchTitleTxt().getText(), "Create blood batch", "Title mismatch");
		ExtentManager.getTest().log(Status.PASS, "Title: "+barcode_batches_locators.get_createBloodBatchTitleTxt().getText());
		
	}
	
	public void sucessfulSubmissionBloodBatchForm() throws IOException, InterruptedException {
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_customerDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByText(activate_test_kit_locators.get_customerDrp(), "Boots");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_typeDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByText(activate_test_kit_locators.get_typeDrp(), "blood");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_subTypeDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), "Gold");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeCountTxt(), Duration.ofSeconds(10));
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), "2");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_saveBtn(), Duration.ofSeconds(10));
		WebButton.clickButton(activate_test_kit_locators.get_saveBtn());
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_toasterAlert(), Duration.ofSeconds(10));
		System.out.println("Alert: "+barcode_batches_locators.get_toasterAlert().getText());
		assertTrue(barcode_batches_locators.get_toasterAlert().isDisplayed(), "Alert is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Alert: "+barcode_batches_locators.get_toasterAlert().getText());
		
	}
	
	public void bloodBatchSuccessMsg() {
		assertEquals(barcode_batches_locators.get_toasterAlert().getText(), "2 Barcodes created");
		System.out.println("Alert: "+barcode_batches_locators.get_toasterAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+barcode_batches_locators.get_toasterAlert().getText());
	}
	
	public void countValueZero() throws IOException, InterruptedException {
		activate_test_kit_actions.dashboardUrlOfTims();
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_createBloodBatchBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_createBloodBatchBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeCountTxt(), Duration.ofSeconds(10));
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), "0");
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_countDrpErrorMsg(), Duration.ofSeconds(10));
		System.out.println("Error: "+barcode_batches_locators.get_countDrpErrorMsg().getText());
		assertTrue(barcode_batches_locators.get_countDrpErrorMsg().isDisplayed());
		ExtentManager.getTest().log(Status.PASS, "Error: "+barcode_batches_locators.get_countDrpErrorMsg().getText());
		
	}
	
	public void verifyIncArrowFunction() throws InterruptedException {
		activate_test_kit_locators.get_barcodeCountTxt().sendKeys(Keys.ARROW_UP);
		String initialValue = activate_test_kit_locators.get_barcodeCountTxt().getAttribute("value");
		Thread.sleep(500);
		System.out.println("Initial count: "+initialValue);
		activate_test_kit_locators.get_barcodeCountTxt().sendKeys(Keys.ARROW_UP);
	    Thread.sleep(500);
        String incrementedValue = activate_test_kit_locators.get_barcodeCountTxt().getAttribute("value");
        System.out.println("Incremented count: "+incrementedValue);
        assertEquals(incrementedValue, "3", "Value after increment should be 3");
	}
	
	public void verifyDecArrowFunction() throws InterruptedException {
		String initialValue = activate_test_kit_locators.get_barcodeCountTxt().getAttribute("value");
		System.out.println("Initial count: "+initialValue);
		activate_test_kit_locators.get_barcodeCountTxt().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(500);
        String decrementedValue = activate_test_kit_locators.get_barcodeCountTxt().getAttribute("value");
        System.out.println("Decremented count: "+decrementedValue);
        assertEquals(decrementedValue, "2", "Value after decrement should be 2");
	}
	
	public void verifyCountIsNotDecBelow2() throws InterruptedException {
		String initialValue = activate_test_kit_locators.get_barcodeCountTxt().getAttribute("value");
		System.out.println("Initial count: "+initialValue);
		activate_test_kit_locators.get_barcodeCountTxt().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(500);
        String decrementedValue = activate_test_kit_locators.get_barcodeCountTxt().getAttribute("value");
        System.out.println("Decremented count: "+decrementedValue);
        assertEquals(decrementedValue, "2", "Value after decrement should not be less than 2");
	}
	
	public void verifyPresenceOfIncDecArrows() throws InterruptedException {
		String initialValue = activate_test_kit_locators.get_barcodeCountTxt().getAttribute("value");
		Thread.sleep(500);
		System.out.println("Initial count: "+initialValue);
		activate_test_kit_locators.get_barcodeCountTxt().sendKeys(Keys.ARROW_UP);
	    Thread.sleep(500);
        String incrementedValue = activate_test_kit_locators.get_barcodeCountTxt().getAttribute("value");
        System.out.println("Incremented count: "+incrementedValue);
        assertEquals(incrementedValue, "3", "Value after increment should be 3");
        
		activate_test_kit_locators.get_barcodeCountTxt().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(500);
        String decrementedValue = activate_test_kit_locators.get_barcodeCountTxt().getAttribute("value");
        System.out.println("Decremented count: "+decrementedValue);
        assertEquals(decrementedValue, "2", "Value after decrement should be 2");
        
        System.out.println("Increment/Decrement arrows are present");
        ExtentManager.getTest().log(Status.PASS, "Increment/Decrement arrows are present");
	}
	
	public void verifyPresenceOfCreateDNABatchBtn() throws IOException, InterruptedException {
		activate_test_kit_actions.dashboardUrlOfTims();
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_createDNABatchBtn(), Duration.ofSeconds(10));
		System.out.println("Button displayed: "+barcode_batches_locators.get_createDNABatchBtn().getText());
		assertTrue(barcode_batches_locators.get_createDNABatchBtn().isDisplayed(), "Create DNA Batch button is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Button displayed: "+barcode_batches_locators.get_createDNABatchBtn().getText());
	}
	
	public void verifyOpeningOfCreateDNABatchForm() {
		WebButton.JsclickButton(barcode_batches_locators.get_createDNABatchBtn(), driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_createDNABatchForm(), Duration.ofSeconds(10));
		System.out.println("Form displayed: "+barcode_batches_locators.get_createDNABatchForm().getText());
		assertTrue(barcode_batches_locators.get_createDNABatchForm().isDisplayed(), "Create DNA batc form is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Form displayed: "+barcode_batches_locators.get_createDNABatchForm().getText());
	}
	
	public void verifyCreateDNABatchTypeDrpValues() {
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_createDNABatchTypeDrp(), Duration.ofSeconds(10));
		WebElement typeDrp = barcode_batches_locators.get_createDNABatchTypeDrp();
		WebButton.JsclickButton(typeDrp, driver);
		List<String> expectedOptions = Arrays.asList("-","wellness");
		List<String> actualOptions = WebDropDown.getDropdownOptions(driver, typeDrp);
		StringBuilder recordLog = new StringBuilder();
		System.out.println("Actual dropdown options:");
		for(String option:actualOptions) {
			System.out.println(option);
			recordLog.append(option).append("<br>");
		}
		assertEquals(actualOptions, expectedOptions, "One or more dropdown values are missing");
		ExtentManager.getTest().log(Status.PASS, "Dropdown options:<br> "+recordLog.toString());
	}
	
	public void verifyCreateDNABatchSubTypeNonEditable() {
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_createDNABatchSubTypeDrp(), Duration.ofSeconds(10));
		WebElement SubtypeDrp = barcode_batches_locators.get_createDNABatchSubTypeDrp();
		boolean isReadOnly = SubtypeDrp.getAttribute("readonly") != null;
		System.out.println("Non-editable value: "+SubtypeDrp.getAttribute("value"));
		assertTrue(isReadOnly, "Subtype is editable");
		ExtentManager.getTest().log(Status.PASS, "Non-editable value: "+SubtypeDrp.getAttribute("value"));
	}
	
	public void verifyHelpTextForCountFieldDna() {
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_howManyBarcodesHelpTxtDNA(), Duration.ofSeconds(10));
		String actualText = barcode_batches_locators.get_howManyBarcodesHelpTxtDNA().getText();
		String expectedText = "How many barcodes would you like to generate?";
		assertEquals(actualText, expectedText, "Help text mismatch");
		System.out.println("Help text: "+actualText);
		ExtentManager.getTest().log(Status.PASS, "Help text: "+actualText);
	}
	
	public void verifyFunctionalityOfCountFieldDNA() {
		//Enter zero (e.g., 0)
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_barcodeCountTxtDNA(), Duration.ofSeconds(10));
		WebTextBox.sendInputUpdate(barcode_batches_locators.get_barcodeCountTxtDNA(), "0");
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_countDrpErrorMsgDNA(), Duration.ofSeconds(10));
		System.out.println("Error: "+barcode_batches_locators.get_countDrpErrorMsgDNA().getText());
		assertTrue(barcode_batches_locators.get_countDrpErrorMsgDNA().isDisplayed());
		ExtentManager.getTest().log(Status.PASS, "Error: "+barcode_batches_locators.get_countDrpErrorMsgDNA().getText());
		CaptureScreenshot.captureAndAttachScreenshot("Input=0");
		
		// Enter characters (e.g., abc)
		WebTextBox.sendInputUpdate(barcode_batches_locators.get_barcodeCountTxtDNA(), "abc@#");
	    WebWait.visibilityOfElement(driver, barcode_batches_locators.get_countDrpErrorMsgDNA(), Duration.ofSeconds(10));
	    System.out.println("Error: " + barcode_batches_locators.get_countDrpErrorMsgDNA().getText());
	    assertTrue(barcode_batches_locators.get_countDrpErrorMsgDNA().isDisplayed());
	    ExtentManager.getTest().log(Status.PASS, "Error message for non-numeric input 'abc': " + barcode_batches_locators.get_countDrpErrorMsgDNA().getText());
	    CaptureScreenshot.captureAndAttachScreenshot("Input=abc");
	    
	    // Enter a negative number (e.g., -5)
	    WebTextBox.sendInputUpdate(barcode_batches_locators.get_barcodeCountTxtDNA(), "-5");
	    WebWait.visibilityOfElement(driver, barcode_batches_locators.get_countDrpErrorMsgDNA(), Duration.ofSeconds(10));
	    System.out.println("Error: " + barcode_batches_locators.get_countDrpErrorMsgDNA().getText());
	    assertTrue(barcode_batches_locators.get_countDrpErrorMsgDNA().isDisplayed());
	    ExtentManager.getTest().log(Status.PASS, "Error message for negative input '-5': " + barcode_batches_locators.get_countDrpErrorMsgDNA().getText());
	    CaptureScreenshot.captureAndAttachScreenshot("Input=-5");
	    
	    // Enter a decimal number (e.g., 2.5)
	    WebTextBox.sendInputUpdate(barcode_batches_locators.get_barcodeCountTxtDNA(), "2.5");
	    WebWait.visibilityOfElement(driver, barcode_batches_locators.get_countDrpErrorMsgDNA(), Duration.ofSeconds(10));
	    System.out.println("Error: " + barcode_batches_locators.get_countDrpErrorMsgDNA().getText());
	    assertTrue(barcode_batches_locators.get_countDrpErrorMsgDNA().isDisplayed());
	    ExtentManager.getTest().log(Status.PASS, "Error message for decimal input '2.5': " + barcode_batches_locators.get_countDrpErrorMsgDNA().getText());
	    CaptureScreenshot.captureAndAttachScreenshot("Input=2.5");
	    
	    // Enter a valid number greater than 2 (e.g., 5)
	    WebTextBox.sendInputUpdate(barcode_batches_locators.get_barcodeCountTxtDNA(), "5");
	    WebWait.InvisibilityOfElement(driver, barcode_batches_locators.get_countDrpErrorMsgDNA(), Duration.ofSeconds(10));
	    WebElement errorMsg = barcode_batches_locators.get_countDrpErrorMsgDNA();
	    assertFalse(barcode_batches_locators.get_countDrpErrorMsgDNA().isDisplayed(), "Error message should not be displayed for valid input" );
	    if(!errorMsg.isDisplayed()) {
	    	System.out.println("Validation: Valid input '5' is accepted. No error message.");
	    	ExtentManager.getTest().log(Status.PASS, "Valid input '5' is accepted. No error message.");
	    }else {
	    	System.out.println("Error: " + barcode_batches_locators.get_countDrpErrorMsgDNA().getText());
	    	ExtentManager.getTest().log(Status.PASS, "Error message for input '5': " + barcode_batches_locators.get_countDrpErrorMsgDNA().getText());
	    }
	    
	}
	
	public void verifyCustomerDrpValuesDna() {
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_createDNABatchCustDrp(), Duration.ofSeconds(10));
		WebElement custDrp = barcode_batches_locators.get_createDNABatchCustDrp();
		WebButton.JsclickButton(custDrp, driver);
		List<String> expectedOptions = Arrays.asList("-","Boots","Lloyds","Pharmacy 2 U","Boots","Boots","Boots private label");
		List<String> actualOptions = WebDropDown.getDropdownOptions(driver, custDrp);
		StringBuilder recordLog = new StringBuilder();
		System.out.println("Actual dropdown options:");
		for(String option:actualOptions) {
			System.out.println(option);
			recordLog.append(option).append("<br>");
		}
		assertEquals(actualOptions, expectedOptions, "One or more dropdown values are missing");
		ExtentManager.getTest().log(Status.PASS, "Dropdown options:<br> "+recordLog.toString());
	}
	
	public void presenceOfCreateDNABatchTitle() throws IOException, InterruptedException {
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_createDNABatchTitleTxt(), Duration.ofSeconds(10));
		System.out.println("Title: "+barcode_batches_locators.get_createDNABatchTitleTxt().getText());
		assertEquals(barcode_batches_locators.get_createDNABatchTitleTxt().getText(), "Create DNA batch", "Title mismatch");
		ExtentManager.getTest().log(Status.PASS, "Title: "+barcode_batches_locators.get_createDNABatchTitleTxt().getText());
		
	}
	
	public void presenceOfCancelBtnDnaBatch() {
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_createDNABatchCancelBtn(), Duration.ofSeconds(10));
		System.out.println("Button: "+barcode_batches_locators.get_createDNABatchCancelBtn().getText());
		assertTrue(barcode_batches_locators.get_createDNABatchCancelBtn().isDisplayed(), "Cancel button is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Button displayed: "+barcode_batches_locators.get_createDNABatchCancelBtn().getText());
	}
	
	public void emptyRequiredFieldsDnaBatch() {
		WebButton.JsclickButton(barcode_batches_locators.get_barcodeCountTxtDNA(), driver);
		barcode_batches_locators.get_barcodeCountTxtDNA().sendKeys(Keys.BACK_SPACE);
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_createDNABatchSaveBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_createDNABatchSaveBtn(), driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_dnaBatchTypeDrpErrorMsg(), Duration.ofSeconds(10));
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_dnaBatchCountErrorMsg(), Duration.ofSeconds(10));
		System.out.println("Error message(Type): "+barcode_batches_locators.get_dnaBatchTypeDrpErrorMsg().getText());
		System.out.println("Error message(Count): "+barcode_batches_locators.get_dnaBatchCountErrorMsg().getText());
		assertTrue(barcode_batches_locators.get_dnaBatchTypeDrpErrorMsg().isDisplayed(), "Error message for Type is not displayed");
		assertTrue(barcode_batches_locators.get_dnaBatchCountErrorMsg().isDisplayed(), "Error message for Count is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Error message(Type): "+barcode_batches_locators.get_dnaBatchTypeDrpErrorMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Error message(Count): "+barcode_batches_locators.get_dnaBatchCountErrorMsg().getText());
	}
	
	public void formAlignmentOnDifferentScreenSizes() throws IOException, InterruptedException {
		screenResolutionSizesShowsAllWebelementsProperly(1920, 1080);
		screenResolutionSizesShowsAllWebelementsProperly(1366, 768);
		screenResolutionSizesShowsAllWebelementsProperly(768, 1024);
		screenResolutionSizesShowsAllWebelementsProperly(375, 667);
		screenResolutionSizesShowsAllWebelementsProperly(414, 896);
	}
	
	public void dnaBatchCancelBtnFunctionality() {
		driver.manage().window().maximize();
		WebButton.JsclickButton(barcode_batches_locators.get_createDNABatchCancelBtn(), driver);
		assertFalse(barcode_batches_locators.get_createDNABatchWindow().isDisplayed(), "Create DNA batch form is not closed");
		System.out.println("Valiation: Create DNA batch form is closed without saving any changes");
		ExtentManager.getTest().log(Status.PASS, "Valiation: Create DNA batch form is closed without saving any changes");
	}
	
	public void successfulDnaBatchCreation() {
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_createDNABatchBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_createDNABatchBtn(), driver);
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_createDNABatchCustDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByText(barcode_batches_locators.get_createDNABatchCustDrp(), "Boots");
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_createDNABatchTypeDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByText(barcode_batches_locators.get_createDNABatchTypeDrp(), "wellness");
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_barcodeCountTxtDNA(), Duration.ofSeconds(10));
		WebTextBox.sendInput(barcode_batches_locators.get_barcodeCountTxtDNA(), "2");
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_createDNABatchSaveBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_createDNABatchSaveBtn(), driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_barcodeCreatedToaster(), Duration.ofSeconds(10));
		System.out.println("Alert: "+barcode_batches_locators.get_barcodeCreatedToaster().getText());
		assertEquals(barcode_batches_locators.get_barcodeCreatedToaster().getText(), "2 Barcodes created");
		ExtentManager.getTest().log(Status.PASS, "Alert: "+barcode_batches_locators.get_barcodeCreatedToaster().getText());	
	}
	
	public void verifyCurrentCustIsSelectedByDefault() {
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_barcodeBatchEditBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_barcodeBatchEditBtn(), driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_editBatchFormCustDrp(), Duration.ofSeconds(10));
		String selectedOption = WebDropDown.getSelectedOption(driver, barcode_batches_locators.get_editBatchFormCustDrp()).getText();
		System.out.println("Current selected option: "+selectedOption);
		assertEquals(selectedOption, "Boots");
		ExtentManager.getTest().log(Status.PASS, "Current selected option: "+selectedOption);
		
	}
	
	public void verifyEditBatchCustDrpOptions() {
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_editBatchFormCustDrp(), Duration.ofSeconds(10));
		WebElement custDrp = barcode_batches_locators.get_editBatchFormCustDrp();
		WebButton.JsclickButton(custDrp, driver);
		List<String> expectedOptions = Arrays.asList("-","Boots","Lloyds","Pharmacy 2 U","Boots","Boots");
		List<String> actualOptions = WebDropDown.getDropdownOptions(driver, custDrp);
		StringBuilder recordLog = new StringBuilder();
		System.out.println("Actual dropdown options:");
		for(String option:actualOptions) {
			System.out.println(option);
			recordLog.append(option).append("<br>");
		}
		assertEquals(actualOptions, expectedOptions, "One or more dropdown values are missing");
		ExtentManager.getTest().log(Status.PASS, "Dropdown options:<br> "+recordLog.toString());
	}
	
	public void verifyUserCanUpdateCustField() throws InterruptedException {
		String selectedOption = WebDropDown.getSelectedOption(driver, barcode_batches_locators.get_editBatchFormCustDrp()).getText();
		System.out.println("Selected option(Before edit): "+selectedOption);
		ExtentManager.getTest().log(Status.INFO, "Selected option(Before edit): "+selectedOption);
		WebDropDown.selectByText(barcode_batches_locators.get_editBatchFormCustDrp(), "Lloyds");
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_editBatchFormSaveBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_editBatchFormSaveBtn(), driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_batchUpdatedToasterMsg(), Duration.ofSeconds(10));
		String successMsg = barcode_batches_locators.get_batchUpdatedToasterMsg().getText();
		System.out.println("Alert: "+successMsg);
		assertEquals(successMsg, "Batch Updated successfully.");
		ExtentManager.getTest().log(Status.PASS, "Alert: "+successMsg);
		Thread.sleep(4000);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_batchDetailsCustNameValue(), Duration.ofSeconds(10));
		String custName = barcode_batches_locators.get_batchDetailsCustNameValue().getText();
		System.out.println("Customer name(After edit): "+custName);
		assertEquals(custName, "Lloyds");
		ExtentManager.getTest().log(Status.PASS, "Customer name(After edit): "+custName);
	}
	
	public void verifyUserCanUpdateEditBatchCommentField() throws InterruptedException {
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_barcodeBatchEditBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_barcodeBatchEditBtn(), driver);
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_editBatchFormCommentTxt(), Duration.ofSeconds(10));
		WebTextBox.sendInput(barcode_batches_locators.get_editBatchFormCommentTxt(), "1. Customer changed from Boots to Lloyds");
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_editBatchFormSaveBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_editBatchFormSaveBtn(), driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_batchUpdatedToasterMsg(), Duration.ofSeconds(10));
		String successMsg = barcode_batches_locators.get_batchUpdatedToasterMsg().getText();
		System.out.println("Alert: "+successMsg);
		assertEquals(successMsg, "Batch Updated successfully.");
		ExtentManager.getTest().log(Status.PASS, "Alert: "+successMsg);
		Thread.sleep(4000);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_batchDetailsCommentValue(), Duration.ofSeconds(10));
		String comment = barcode_batches_locators.get_batchDetailsCommentValue().getText();
		System.out.println("Comment updated: "+comment);
		assertEquals(comment, "1. Customer changed from Boots to Lloyds");
		ExtentManager.getTest().log(Status.PASS, "Comment updated: "+comment);
		
	}
	
	public void verifyEditBatchCommentFieldAcceptsAlphanumericCharacters() throws InterruptedException {
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_barcodeBatchEditBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_barcodeBatchEditBtn(), driver);
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_editBatchFormCommentTxt(), Duration.ofSeconds(10));
		WebTextBox.sendInput(barcode_batches_locators.get_editBatchFormCommentTxt(), "1. Customer changed from Boots to Lloyds @#%");
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_editBatchFormSaveBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_editBatchFormSaveBtn(), driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_batchUpdatedToasterMsg(), Duration.ofSeconds(10));
		String successMsg = barcode_batches_locators.get_batchUpdatedToasterMsg().getText();
		System.out.println("Alert: "+successMsg);
		assertEquals(successMsg, "Batch Updated successfully.");
		ExtentManager.getTest().log(Status.PASS, "Alert: "+successMsg);
		Thread.sleep(4000);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_batchDetailsCommentValue(), Duration.ofSeconds(10));
		String comment = barcode_batches_locators.get_batchDetailsCommentValue().getText();
		System.out.println("Comment updated: "+comment);
		assertEquals(comment, "1. Customer changed from Boots to Lloyds @#%");
		ExtentManager.getTest().log(Status.PASS, "Comment updated: "+comment);
	}
	
	public void verifyEditBatchCancelFunctionality() throws InterruptedException {
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_barcodeBatchEditBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_barcodeBatchEditBtn(), driver);
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_editBatchFormCustDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByText(barcode_batches_locators.get_editBatchFormCustDrp(), "Boots");
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_editBatchFormCommentTxt(), Duration.ofSeconds(10));
		WebTextBox.sendInput(barcode_batches_locators.get_editBatchFormCommentTxt(), "1. Customer changed Lloyds from to Boots");
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_editBatchFormCancelBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_editBatchFormCancelBtn(), driver);
		Thread.sleep(4000);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_batchDetailsCustNameValue(), Duration.ofSeconds(10));
		String custName = barcode_batches_locators.get_batchDetailsCustNameValue().getText();
		System.out.println("Customer name: "+custName);
		assertNotEquals(custName, "Boots");
		ExtentManager.getTest().log(Status.PASS, "Customer name: "+custName);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_batchDetailsCommentValue(), Duration.ofSeconds(10));
		String comment = barcode_batches_locators.get_batchDetailsCommentValue().getText();
		System.out.println("Comment: "+comment);
		assertNotEquals(comment, "1. Customer changed Lloyds from to Boots");
		ExtentManager.getTest().log(Status.PASS, "Comment updated: "+comment);
		
	}
	
	
	public void verifyUserRedirectedToBatchDetailsPage() throws IOException, InterruptedException {
		activate_test_kit_actions.dashboardUrlOfTims();
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_createBloodBatchBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_createBloodBatchBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_customerDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByText(activate_test_kit_locators.get_customerDrp(), "Boots");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_typeDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByText(activate_test_kit_locators.get_typeDrp(), "blood");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_subTypeDrp(), Duration.ofSeconds(10));
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), "Gold");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeCountTxt(), Duration.ofSeconds(10));
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), "5");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_saveBtn(), Duration.ofSeconds(10));
		WebButton.clickButton(activate_test_kit_locators.get_saveBtn());
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_toasterAlert(), Duration.ofSeconds(10));
		System.out.println("Alert: "+barcode_batches_locators.get_toasterAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+barcode_batches_locators.get_toasterAlert().getText());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, barcode_batches_locators.get_latestBatchTypeBatchDetails(), Duration.ofSeconds(10));
		WebButton.JsclickButton(barcode_batches_locators.get_latestBatchTypeBatchDetails(), driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_batchDetailsTab(), Duration.ofSeconds(10));
		assertTrue(barcode_batches_locators.get_batchDetailsTab().isDisplayed(), "User did not redirect to batch details page");
		System.out.println("Validation: User redirected to batch details page");
		ExtentManager.getTest().log(Status.PASS, "Validation: User redirected to batch details page");
	}
	
	public void presenceOfGeneratedBarcodes() throws InterruptedException {
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodesHeaderMenuItem(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem(), driver);
		WebWait.visibilityListOfElements(driver, barcode_batches_locators.get_listOfGeneratedBarcodes(), Duration.ofSeconds(10));
		Thread.sleep(3000);
		List<WebElement> barcodes = barcode_batches_locators.get_listOfGeneratedBarcodes();
		int count = 0;
		StringBuilder reportLogger = new StringBuilder();
		for(WebElement barcode : barcodes)
		{
			assertTrue(barcode.isDisplayed(),"One or many barcodes not displayed");
			count++;
			System.out.println(count+". "+barcode.getText());
			reportLogger.append(count+". "+barcode.getText()).append("<br>");
		}
		
		ExtentManager.getTest().log(Status.PASS, reportLogger.toString());
	}
	
	public void verifyGeneratedBarcodesAreCorrect() {
		List<WebElement> barcodes = barcode_batches_locators.get_listOfGeneratedBarcodes();
		int count = 0;
		StringBuilder reportLogger = new StringBuilder();
		for(WebElement barcode : barcodes)
		{
			assertTrue(barcode.isDisplayed(),"One or many barcodes not displayed");
			count++;
			System.out.println(count+". "+barcode.getText());
			reportLogger.append(count+". "+barcode.getText()).append("<br>");
		}
		
		ExtentManager.getTest().log(Status.PASS, reportLogger.toString());
	}
	
	public void verifyCorrectStatusForBarcodes() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> rows = barcode_batches_locators.get_barcodeRows();
		StringBuilder reportLogger = new StringBuilder();
		for(WebElement row : rows)
		{
			WebElement barcodeLink = row.findElement(By.xpath("./td[1]/a"));
			String barcode = barcodeLink.getText();

			WebElement statusCell = row.findElement(By.xpath("./td[2]"));
			String status = statusCell.getText();

			System.out.println("Checking barcode: " + barcode + ", status: " + status);
			softAssert.assertEquals(status, "created", "Status mismatch for barcode " + barcode);
			reportLogger.append("Checking barcode: " + barcode + ", status: " + status).append("<br>");
		}
		softAssert.assertAll();
		ExtentManager.getTest().log(Status.PASS, reportLogger.toString());
	}
	
	public void verifyUserRedirectedToBarcodeDetailsPage() {
		List<WebElement> barcode = barcode_batches_locators.get_listOfGeneratedBarcodes();
		WebElement firstbarcode = barcode.get(0);
		WebWait.elementToBeClickable(driver, firstbarcode, Duration.ofSeconds(10));
		WebButton.JsclickButton(firstbarcode, driver);
		WebWait.visibilityOfElement(driver, barcode_batches_locators.get_barcodeDetailsTab(), Duration.ofSeconds(10));
		assertTrue(barcode_batches_locators.get_barcodeDetailsTab().isDisplayed(), "Barcode details not displayed");
		System.out.println("Validation: "+barcode_batches_locators.get_barcodeDetailsTab().getText() +" page is displayed");
		ExtentManager.getTest().log(Status.PASS, "Validation: "+barcode_batches_locators.get_barcodeDetailsTab().getText()+" page is displayed");
	}

	public void verifyBarodeListOnDifferentScreenSizes() throws IOException, InterruptedException {
		driver.navigate().back();
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodesHeaderMenuItem(), Duration.ofSeconds(10));
		WebButton.JsclickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem(), driver);
		screenResolutionSizesShowsAllWebelementsProperly(1920, 1080);
		screenResolutionSizesShowsAllWebelementsProperly(1366, 768);
		screenResolutionSizesShowsAllWebelementsProperly(768, 1024);
		screenResolutionSizesShowsAllWebelementsProperly(375, 667);
		screenResolutionSizesShowsAllWebelementsProperly(414, 896);
	}
	
	public void screenResolutionSizesShowsAllWebelementsProperly(int width, int height) throws IOException, InterruptedException
	{
		/*
		 * {1920, 1080}, // Desktop full HD {1366, 768}, // Laptop {768, 1024}, //
		 * Tablet Portrait {375, 667}, // iPhone 8 {414, 896} // iPhone XR
		 */
		
		driver.manage().window().setSize(new Dimension(width, height));
		System.out.println("Testing resolution: " + width + "x" + height);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		                                 
	}
	
}
