package Test.Dashboard.Locators_Class;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;

public class Login_Boot_Locators {
	public WebDriver driver;

	public Login_Boot_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtUsernameboot;

	public WebElement getEmailaddress_boot() {
		return txtUsernameboot;
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPasswordboot;

	public WebElement getPassword_boot() {
		return txtPasswordboot;
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]")
	private WebElement msgIncorrectPassword;
	
	public WebElement getMsgIncorrectPassword_boot() {
		return msgIncorrectPassword;
	}
	
	@FindBy(xpath ="//div[@class='invalid-feedback']")
	private WebElement errorInvalidEmail;
	
	public WebElement getErrorInvalidEmail_boot() {
		return errorInvalidEmail;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnLoginboot;

	public WebElement getLoginBtn_boot() {
		return btnLoginboot;
	}

	@FindBy(xpath = "//button[@class='btn btn-error']")
	private WebElement btnEnableLater;

	public WebElement getEnableLater() {
		return btnEnableLater;
	}
	
	@FindBy(xpath = "//*[contains(text(), 'Boots appointment')]")
	private WebElement boots_Appointment;

	public WebElement getboots_Appointment() {
		return boots_Appointment;
	}

	@FindBy(xpath = "//*[contains(text(), 'Logged in successfully!')]")
	private WebElement txtSuccessMsgBoot;

	public WebElement getSuccessMsg_boot() {
		return txtSuccessMsgBoot;
	}
	
	@FindBy(xpath = "//p[contains(text(),'Welcome to your personalised MyHealthChecked panel')]")
	private WebElement txtWelcomeMsg;
	
	public WebElement getWelcomeMsg_boot() {
		return txtWelcomeMsg;
	}

	@FindBy(xpath = "//a[contains(@href,'/bloods/boots/registration/blood-thyroid')]")
	private WebElement btnContinue;

	public WebElement getContinueBtn() {
		return btnContinue;
	}

	@FindBy(xpath = "(//option[@value='blood-thyroid'])[1]")
	private WebElement dropDownType;

	public WebElement getdropDownType() {
		return dropDownType;

	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement confirmCtnBtn;

	public WebElement getconfirmCtnBtn() {
		return confirmCtnBtn;

	}

	@FindBy(xpath = "//*[contains(text(), 'Test type confirmed!')]")
	private WebElement testTypeCnfm;

	public WebElement gettestTypeCnfm() {
		return testTypeCnfm;
	}

	@FindBy(xpath = "(//select[@id='input-test_type'])")
	private WebElement NoSelectdropDown;

	public WebElement getNoSelectdropDown() {
		return NoSelectdropDown;
	}

	@FindBy(xpath = "(//input[@id='consentGiven'])")
	private WebElement chkboxConsent;

	public WebElement getchkboxConsent() {
		return chkboxConsent;
	}

	@FindBy(xpath = "(//input[@id='termsAccepted'])")
	private WebElement chkboxAccept;

	public WebElement getchkboxAccept() {
		return chkboxAccept;
	}

	@FindBy(xpath = "(//button[@type='submit'])")
	private WebElement submitConsent;

	public WebElement getsubmitConsent() {
		return submitConsent;
	}
	
	@FindBy(xpath = "//*[contains(text(), 'Consent saved!')]")
	private WebElement consentSaveSuccess;

	public WebElement getconsentSaveSuccess() {
		return consentSaveSuccess;
	}
}
