package Test.Tims.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tims_Customer_Events_Locators {
	public WebDriver driver;

	public Tims_Customer_Events_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Enable Later']")
	WebElement btnEnableLater;

	public WebElement getbtnEnableLater() {
		return btnEnableLater;
	}

	@FindBy(xpath = "//a[normalize-space()='User']")
	WebElement txtUserOption;

	public WebElement gettxtUserOption() {
		return txtUserOption;
	}

	@FindBy(xpath = "//a[normalize-space()='sagar d']")
	WebElement txtUserName;

	public WebElement gettxtUserName() {
		return txtUserName;
	}

	@FindBy(id = "nav-emails-tab")
	WebElement txtEmailTab;

	public WebElement gettxtEmailTab() {
		return txtEmailTab;
	}

	@FindBy(xpath = "//tbody/tr[1]/td[1]/a[1]")
	WebElement txtTriggerEmail;

	public WebElement gettxtTriggerEmail() {
		return txtTriggerEmail;
	}
}
