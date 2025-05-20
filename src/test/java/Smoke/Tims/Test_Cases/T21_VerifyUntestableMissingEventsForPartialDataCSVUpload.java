package Smoke.Tims.Test_Cases;
import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Actions_Class.Phlebotomist_csv_import_Actions;
import Test.Tims.Actions_Class.Store_Location_Actions;
import Test.Tims.Actions_Class.Testkit_Uplaodcsv_Partial_Event_Logs_Actions;
import initializer.BaseClass;

public class T21_VerifyUntestableMissingEventsForPartialDataCSVUpload extends BaseClass
{
	Login_Action Login_action;
	Testkit_Uplaodcsv_Partial_Event_Logs_Actions testkit_Uplaodcsv_Partial_Event_Logs_Actions;
	
	@Test
	public void VerifyUntestableMissingEventsForPartialDataCSVUpload() throws Exception 
	{
		Login_action = new Login_Action(getDriver());	
		Login_action.login_Tims_dev();
		testkit_Uplaodcsv_Partial_Event_Logs_Actions = new Testkit_Uplaodcsv_Partial_Event_Logs_Actions(getDriver());
		testkit_Uplaodcsv_Partial_Event_Logs_Actions.CsvPartialEventLogStatus();
		
	}

}
