package Test.Tims.Partial_Report_Locators_Class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SOFT_1417_Partial_Report_Locators {
	public WebDriver driver;

	public SOFT_1417_Partial_Report_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//a[@href='/admin/test-reports/' and contains(normalize-space(.), 'Test reports')]")
	private WebElement testReportSideMenuItem;

	public WebElement get_testReportSideMenuItem() {
		return testReportSideMenuItem;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Your Results')]")
	private WebElement yourResultTab;

	public WebElement get_yourResultTab() {
		return yourResultTab;
	}

	@FindBy(xpath = "//h2[@class='marker-card-title']")
	private List<WebElement> markerCardTitles;

	public List<WebElement> get_markerCardTitles() {
	    return markerCardTitles;
	}
	
	@FindBy(xpath = "//h6[@class='accordion-header']")
	private List<WebElement> groupStatusSH;

	public List<WebElement> get_groupStatusSH() {
	    return groupStatusSH;
	}
		
	@FindBy(xpath = "//h6[contains(text(),'Sexual Health')]")
	private WebElement sexualHealthBtn;

	public WebElement get_sexualHealthBtn() {
		return sexualHealthBtn;
	}
	
	@FindBy(xpath = "//select[@id='sexualhealth-groupStatusSelect']")
	private WebElement sexualHealthDrp;

	public WebElement get_sexualHealthDrp() {
		return sexualHealthDrp;
	}
	
	
	@FindBy(xpath = "//div[@class='marker-card-container']//strong[contains(normalize-space(.),'HIV & Syphilis')]")
	private WebElement HIV_SYPH_Text;

	public WebElement get_HIV_SYPH_Text() {
		return HIV_SYPH_Text;
	}
}
