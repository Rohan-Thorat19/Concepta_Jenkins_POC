package Tims.Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;

import Test.Kit.Actions_Class.Login_Action;
import Wrappers.WebCommonPath;
import dataSources.PropertiesReader;
import initializer.BaseClass;

public class Login_Tims extends BaseClass {

	// Declaration
	public Login_Action login;

	@Test
	public void loginToTims() throws IOException {

		// Initialization
		login = new Login_Action(getDriver());
		// login to Tims
		
//		login.login_Tims(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims"),
//				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims"));
//		login.login(BaseClass.getUsername(),
//				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password"));
		
		
		
	}

}
