package PreTestDataActions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Wrappers.WebTextBox;
import PreTestDataLocators.PreDataLocators;
import Wrappers.WebButton;
import Wrappers.WebScrollView;
import initializer.BaseClass;

public class PreDataAction extends BaseClass
{
	public WebDriver driver;
	PreDataLocators preDataLocators = null;

	public PreDataAction(WebDriver driver)
	{
		this.driver = driver;
		preDataLocators = new PreDataLocators(driver);
	}
	
	public void Create_Account() throws InterruptedException
	{
		WebButton.clickButton(preDataLocators.createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebTextBox.sendInput(preDataLocators.getFirstName(), "Test");
		WebTextBox.sendInput(preDataLocators.getLastName(), "Test"+RandomGenerator());
		WebTextBox.sendInput(preDataLocators.getEmail(), "testconcepta3+"+RandomGenerator()+"@gmail.com");
		WebTextBox.sendInput(preDataLocators.getPassword(), "Test@753");
		WebScrollView.scrollDownVertically(driver);
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(3000);
		WebButton.JsclickButton(preDataLocators.checkboxRecapcha(), driver);
		driver.switchTo().defaultContent();
		  Thread.sleep(3000);
		//WebButton.clickButton(preDataLocators.createAccountButtonPageSecond());
	}
	
	public int RandomGenerator()
	{	
    int randomNumber = new Random().nextInt(90) + 10; // Generates a number between 100 and 999        
    System.out.println("Generated Random String: " + randomNumber);
    return randomNumber;
	}
}
