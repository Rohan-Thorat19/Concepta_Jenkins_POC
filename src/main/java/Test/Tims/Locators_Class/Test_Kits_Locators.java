package Test.Tims.Locators_Class;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class Test_Kits_Locators {
	public WebDriver driver;

	public Test_Kits_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//a[@href='/admin/test-kits/']")
	private WebElement testKitSideMenuItem;

	public WebElement get_testKitSideMenuItem() {
		return testKitSideMenuItem;
	}
	
	
	@FindBy(xpath = "//button[contains(text(),'Create kit')]")
	private WebElement createKitBtn;

	public WebElement get_createKitBtn() {
		return createKitBtn;
	}
	
	@FindBy(xpath = "//div[@class='modal-content']//h6[contains(text(), 'Create kit')]")
	private WebElement createKitPage;

	public WebElement get_createKitPage() {
		return createKitPage;
	}

}
