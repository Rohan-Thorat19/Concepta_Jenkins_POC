package Test.Tims.Partial_Report_Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SOFT_1409_Partial_Report_Locators {

	public WebDriver driver;
	
	public SOFT_1409_Partial_Report_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
