package PreTestDataLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreDataLocators {
	public WebDriver driver;

	public PreDataLocators(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "//a[@role='button']")
	private WebElement createAccountPageFirst;

	public WebElement createAccountButtonPageFirst() {
		return createAccountPageFirst;
	}
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement txtFristName;

	public WebElement getFirstName() {
		return txtFristName;
	}

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement txtLastName;

	public WebElement getLastName() {
		return txtLastName;
	}
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtEmail;

	public WebElement getEmail() {
		return txtEmail;
	}
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPassword;

	public WebElement getPassword() {
		return txtPassword;
	}
	
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-borderAnimation']")
	private WebElement checkboxRecapcha;

	public WebElement checkboxRecapcha() {
		return checkboxRecapcha;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Create account')]")
	private WebElement createAccountPageSecond;

	public WebElement createAccountButtonPageSecond() {
		return createAccountPageSecond;
	}
	
	@FindBy(xpath = "//a[normalize-space()='Sign up']")
	private WebElement btnSignUp;
	
	public WebElement getSignUpBtn() {
		return btnSignUp;
	}
	
	@FindBy(xpath = "//div[@role='progressbar']")
	private WebElement pwdStrengthWeak;
	
	public WebElement getPwdStrength() {
		return pwdStrengthWeak;
	}
	
	
	
}
