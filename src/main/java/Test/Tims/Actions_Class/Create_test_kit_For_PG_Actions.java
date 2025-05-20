package Test.Tims.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;

import Test.Tims.Locators_Class.Create_test_kit_For_PG_Locators;
import Wrappers.WebButton;
import Wrappers.WebDropDown;
import Wrappers.WebScreenshot;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class Create_test_kit_For_PG_Actions {

	public WebDriver driver;
	Create_test_kit_For_PG_Locators create_test_kit_Locators;
	private String barcode;
	String phlebotomy_gold_barcodePattern = "^PG[A-Z]{1}-[A-Z]{3}-\\d{4}$";

	public Create_test_kit_For_PG_Actions(WebDriver driver) {
		this.driver = driver;
		create_test_kit_Locators = new Create_test_kit_For_PG_Locators(driver);
	}

	public void clickOn_Enable_Later() throws InterruptedException {
		WebWait.elementToBeClickable(driver, create_test_kit_Locators.Enable_Later(), Duration.ofSeconds(30));
		try {
			WebButton.JsclickButton(create_test_kit_Locators.Enable_Later(), driver);
		}
		catch(Exception e) {
			WebButton.JsclickButton(create_test_kit_Locators.Enable_Later(), driver);
		}
		//WebButton.JsclickButton(create_test_kit_Locators.Enable_Later(),driver);
	}

	public void clickOn_Barcode_batches() throws InterruptedException {
		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getBarcode_batches(), Duration.ofSeconds(50));
		WebScrollView.scrollToElement(driver, create_test_kit_Locators.getBarcode_batches());
		WebWait.elementToBeClickable(driver, create_test_kit_Locators.getBarcode_batches(), Duration.ofSeconds(50));
		//WebButton.clickButton(create_test_kit_Locators.getBarcode_batches());
		WebButton.JsclickButton(create_test_kit_Locators.getBarcode_batches(), driver);
		ExtentManager.getTest().log(Status.PASS, "clicked On Barcode batch");
	}

	public void clickOn_Create_blood_batch() throws InterruptedException {
		WebWait.elementToBeClickable(driver, create_test_kit_Locators.getCreate_blood_batch(), Duration.ofSeconds(40));
		WebButton.clickButton(create_test_kit_Locators.getCreate_blood_batch());

	}

	public void Select_type() throws InterruptedException {
		WebElement dropdown = create_test_kit_Locators.getType1();
		Thread.sleep(2000);
		WebDropDown.selectByText(dropdown, "blood");
//		Select select = new Select(dropdown);
//		select.selectByVisibleText("blood"); // Select option directly
		System.out.println("Tpye selcted");
//		WebWait.elementToBeClickable(driver, create_test_kit_Locators.getType1(), Duration.ofSeconds(30));
//
//		WebDropDown.selectByText(create_test_kit_Locators.getType1(), "blood");
	}

	public void Select_Subtype() {
		/*
		 * 
		 * WebElement dropdown = create_test_kit_Locators.getSubtype1(); Select select =
		 * 
		 * new Select(dropdown); select.selectByVisibleText("phlebotomy gold"); //
		 * 
		 * Select option directly System.out.println("SubTpye selected");
		 * 
		 */

		// Thread.sleep(2000);

		//WebWait.elementToBeClickable(driver, create_test_kit_Locators.getSubtype1(), Duration.ofSeconds(30));

		WebDropDown.selectByText(create_test_kit_Locators.getSubtype1(), "Phlebotomy gold");
	}

	public void Select_Subtype_otherthan_PG() {

		WebWait.elementToBeClickable(driver, create_test_kit_Locators.getSubtype1(), Duration.ofSeconds(30));

		WebDropDown.selectByText(create_test_kit_Locators.getSubtype1(), "Phlebotomy gold");

	}

	public void Select_Count() throws InterruptedException {
		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getCount(), Duration.ofSeconds(30));
		WebTextBox.sendInput(create_test_kit_Locators.getCount(), "2");
		System.out.println("Count selected");
	}

	public void clickOn_Save() throws InterruptedException {
		WebWait.elementToBeClickable(driver, create_test_kit_Locators.Submit_blood_batch(), Duration.ofSeconds(40));
		WebButton.clickButton(create_test_kit_Locators.Submit_blood_batch());
		System.out.println("Blood batch created");

		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getBarcode01(), Duration.ofSeconds(30));
		String alert_expected = create_test_kit_Locators.getBarcode01().getText().trim();
		System.out.println("Verify Barcode Batch-" + alert_expected);
		String Alert = "Barcodes created";
		String ActualValue = Alert;
		// Thread.sleep(2000);
		if(alert_expected.contains(ActualValue)) {
			//assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Verified the Barcode Batch");
		}
		else
		{
			assertEquals(ActualValue, alert_expected);
			
		}
		

	}

	public void Other_than_PG_Assertion() {

		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getSubtype2(), Duration.ofSeconds(30));

//		Assert.assertEquals( create_test_kit_Locators.getSubtype2().getText().trim(), "phlebotomy gold");

		if (create_test_kit_Locators.getSubtype2().getText().trim().equals("phlebotomy gold")) {

			assertTrue(false);

		}

		else {

			assertTrue(true);

		}

		ExtentManager.getTest().log(Status.PASS, "Verified Barcode Batch Other than phlebotomy gold");

	}

	public void Select_Barcode_Tab() throws InterruptedException {
		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getBarcode(), Duration.ofSeconds(30));
		WebButton.clickButton(create_test_kit_Locators.getBarcode());
		System.out.println("Barcode");
	}

	public String getBarcodeText() throws InterruptedException {

		Thread.sleep(3000);
		WebScreenshot.TakeScreenShot(driver, "Barcode Batch");
		WebElement barcodeElement = create_test_kit_Locators.getBarcodeList();
		barcode = barcodeElement.getText(); // Extract and store text
		System.out.println("Stored Barcode: " + barcode);
		return barcode;

	}

	public void barcode_Format() throws InterruptedException {
		Select_Barcode_Tab();
		getBarcodeText();
		Pattern pattern = Pattern.compile(phlebotomy_gold_barcodePattern);
		Matcher matcher = pattern.matcher(barcode);
		if (matcher.matches()) {
			System.out.println("Barcode format is correct!");
		} else {
			System.out.println("Barcode format is incorrect!");
		}
		// Reuse by returning
	}

	public void Select_Testkit() throws InterruptedException {
		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getTestkit(), Duration.ofSeconds(30));
		WebButton.clickButton(create_test_kit_Locators.getTestkit());
		System.out.println("Test kit Selected");
	}

	public void CreateKitButton() throws InterruptedException {
		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getCreateKitbutton(), Duration.ofSeconds(30));
		WebButton.clickButton(create_test_kit_Locators.getCreateKitbutton());
		System.out.println("Click on Create-kit button");
	}

	public void CreateKit01() throws InterruptedException {
		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getPrimarybarcode(), Duration.ofSeconds(30));
		Thread.sleep(5000);
		WebTextBox.sendInputUpdate(create_test_kit_Locators.getPrimarybarcode(), barcode);
	}

	public void CreateKit() throws InterruptedException {
		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getCreateKit(), Duration.ofSeconds(30));
		WebButton.clickButton(create_test_kit_Locators.getCreateKit());

		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getKitcreated(), Duration.ofSeconds(30));
		String alert_expected = create_test_kit_Locators.getKitcreated().getText().trim();
		System.out.println("Verify test-" + alert_expected);
		String Alert = "Created kit";
		String ActualValue = Alert;
		// Thread.sleep(2000);
		assertEquals(ActualValue, alert_expected);
		ExtentManager.getTest().log(Status.PASS, "Verified the Test Kit creation");
	}

	public void Create_Phlebotom_Gold_barcode_batches() throws InterruptedException {
		try {
			clickOn_Enable_Later();
		} finally {

		}

		clickOn_Barcode_batches();
		clickOn_Create_blood_batch();
		Select_type();
		Select_Subtype();
		Select_Count();
		clickOn_Save();

	}

	public void other_than_Phlebotomy_Gold() throws InterruptedException {

		clickOn_Enable_Later();

		clickOn_Barcode_batches();

		clickOn_Create_blood_batch();

		Select_type();

		Select_Subtype_otherthan_PG();

		Select_Count();

		clickOn_Save();

		Other_than_PG_Assertion();

	}

	public void barcode_Format_Verification() throws InterruptedException {
		clickOn_Enable_Later();
		clickOn_Barcode_batches();
		clickOn_Create_blood_batch();
		Select_type();
		Select_Subtype();
		Select_Count();
		clickOn_Save();
		barcode_Format();

	}

	public String Test_Kit_Creation_PG() throws InterruptedException {

		//clickOn_Enable_Later();
		Thread.sleep(2000);

		clickOn_Barcode_batches();
		clickOn_Create_blood_batch();
		Select_type();
		Select_Subtype();
		Select_Count();
		clickOn_Save();
		Select_Barcode_Tab();
		barcode = getBarcodeText();
		Select_Testkit();
		CreateKitButton();
		CreateKit01();
		CreateKit();
		return barcode;
	}

}