package Test.Tims.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Email_fields_Locators {
	public WebDriver driver;

	public Email_fields_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Enable Later']") 
	WebElement btnEnableLater;

	public WebElement getbtnEnableLater() {
		return btnEnableLater;
	}

	@FindBy(xpath = "//h1[normalize-space()='Assessment details']")
	WebElement textAssessmentDetails;

	public WebElement gettextAssessmentDetails() {
		return textAssessmentDetails;
	}

}
