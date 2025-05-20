package Test.Tims.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class New_Store_Location_Locators {
	public WebDriver driver;

	public New_Store_Location_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/admin/locations']")
	WebElement location_Menu;

	public WebElement get_Locations() {
		return location_Menu;
	}
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Add new location')]")
	WebElement Create_New_Location;

	public WebElement get_Create_New_Location() {
		return Create_New_Location;
	}
	
	@FindBy(id = "store_number")
	WebElement store_number_Field;

	public WebElement get_store_number_Field() {
		return store_number_Field;
	}
	
	@FindBy(id = "store_name")
	WebElement store_Name_Field;

	public WebElement get_store_name_Field() {
		return store_Name_Field;
	}
	
	@FindBy(id = "address")
	WebElement store_Address_Field;

	public WebElement get_store_Address_Field() {
		return store_Address_Field;
	}
	
	@FindBy(id = "area")
	WebElement store_Area_Field;

	public WebElement get_store_Area_Field() {
		return store_Area_Field;
	}
	
	@FindBy(id = "region")
	WebElement store_Region_Field;

	public WebElement get_store_Region_Field() {
		return store_Region_Field;
	}
	
	@FindBy(id = "store_manager")
	WebElement store_Manager_Field;

	public WebElement get_store_Manager_Field() {
		return store_Manager_Field;
	}
	
	@FindBy(id = "contact_email")
	WebElement store_Contact_Email_Field;

	public WebElement get_store_Contact_Email_Field() {
		return store_Contact_Email_Field;
	}
	
	@FindBy(id = "telephone")
	WebElement store_Telephonel_Field;

	public WebElement get_store_Telephonel_Field() {
		return store_Telephonel_Field;
	}
	
	@FindBy(id = "save_button")
	WebElement store_save_button;

	public WebElement get_store_save_button() {
		return store_save_button;
	}
	
	@FindBy(xpath = "(//h2[contains(.,'Location added')])[2]")
	WebElement location_Created;

	public WebElement get_location_Created_Msg() {
		return location_Created;
	}
	
}

