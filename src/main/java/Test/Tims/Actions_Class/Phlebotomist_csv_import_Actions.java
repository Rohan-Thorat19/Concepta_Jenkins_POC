package Test.Tims.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Test.Tims.Locators_Class.Create_test_kit_For_PL_Locators;
import Test.Tims.Locators_Class.Phlebotomist_csv_import_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.ExtentManager;

public class Phlebotomist_csv_import_Actions {
	public WebDriver driver;
	Create_test_kit_For_PL_Actions create_test_kit_For_PL_actions;
	Phlebotomist_csv_import_Locators phlebotomist_csv_import_locators;

	public Phlebotomist_csv_import_Actions(WebDriver driver) {
		this.driver = driver;

	}

	public void download_User_Sample_Csv() throws InterruptedException, IOException {
		create_test_kit_For_PL_actions = new Create_test_kit_For_PL_Actions(driver);
		create_test_kit_For_PL_actions.clickOn_Enable_Later();
		phlebotomist_csv_import_locators = new Phlebotomist_csv_import_Locators(driver);
		WebButton.clickButton(phlebotomist_csv_import_locators.gethcp_User_Menu());
		// WebButton.clickButton(phlebotomist_csv_import_locators.getdownload_CSV());
		WebButton.clickButton(phlebotomist_csv_import_locators.getimport_CSV());

		String filePath = System.getProperty("user.dir") +"/TestData/phlebotomist_sample_data.csv";
		phlebotomist_csv_import_locators.getchooes_CSV().sendKeys(filePath);
		Thread.sleep(2000);
		WebButton.clickButton(phlebotomist_csv_import_locators.save_file());
		
			WebWait.visibilityOfElement(driver, phlebotomist_csv_import_locators.get_cvs_Upload_Success_Msg(),
					Duration.ofSeconds(30));
			String alert_expected = phlebotomist_csv_import_locators.get_cvs_Upload_Success_Msg().getText().trim();
			System.out.println("File Importing Success Message= " + alert_expected);
			String ActualValue = "CSV uploaded. Success: 1, Failures: 0']";
			assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Uploaded Successfully");
		
			
			String alert_not_expected = phlebotomist_csv_import_locators.cvs_Upload_Fail_Msg().getText().trim();
			System.out.println("File Importing Failed Message= " + alert_not_expected);
	}

}
