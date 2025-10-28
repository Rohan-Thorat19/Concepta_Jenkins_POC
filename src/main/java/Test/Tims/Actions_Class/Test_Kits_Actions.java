package Test.Tims.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Random;
import java.io.IOException;
import java.time.Duration;
import Wrappers.CSVUploaderWithTextReplacement;
import Wrappers.ReadGmail;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;
import initializer.ExtentManager;
import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import com.aventstack.extentreports.Status;

import Test.Tims.Locators_Class.SH_Locators;
import Test.Tims.Locators_Class.Test_Kits_Locators;



public class Test_Kits_Actions extends BaseClass {

	public WebDriver driver;
	Test_Kits_Locators test_kits_locators; 	
	SH_Locators sh_locators;
	
	public Test_Kits_Actions(WebDriver driver) {
		this.driver = driver;
		test_kits_locators = new Test_Kits_Locators(driver);	
		sh_locators = new SH_Locators(driver);
	}
	
	public void TimsUrl() throws IOException, InterruptedException {
		String urlKey = determineUrlKey("tims_URL_For_SH");
		driver.get(urlKey);
		WebTextBox.sendInput(sh_locators.get_emailTxt(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafileTims, "tims_Login"));
		WebTextBox.sendInput(sh_locators.get_passwordTxt(), PropertiesReader
				.getPropertyValue(WebCommonPath.testDatafile, "tims_Password_For_Dashboard_Activate_Kit"));
		WebButton.clickButton(sh_locators.get_submitBtn());
		Thread.sleep(3000);
		WebButton.clickButton(sh_locators.get_enableLaterBtn());
		
	}
	
	public void  createKitPageLoadsSuccessfully() throws InterruptedException
	{
		WebButton.clickButton(test_kits_locators.get_testKitSideMenuItem());
		WebButton.clickButton(test_kits_locators.get_createKitBtn());
		Thread.sleep(2000);
		Assert.assertTrue(test_kits_locators.get_createKitPage().isDisplayed(), "");
	}

}
