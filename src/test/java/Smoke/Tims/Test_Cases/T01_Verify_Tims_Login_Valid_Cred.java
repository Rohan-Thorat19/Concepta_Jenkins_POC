package Smoke.Tims.Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Login_Action;
import Wrappers.WebCommonPath;
import dataSources.PropertiesReader;
import initializer.BaseClass;

public class T01_Verify_Tims_Login_Valid_Cred extends BaseClass {

	// Declaration
	public Login_Action login;

	@Test
	public void login_To_Tims_SOFT_487_F1() throws IOException {

		// Initialization
		login = new Login_Action(getDriver());
		// login to Tims
		
//		login.login_Tims(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims"),
//				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims"));
//		login.login(BaseClass.getUsername(),
//				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password"));
		
		
		
	}

}
