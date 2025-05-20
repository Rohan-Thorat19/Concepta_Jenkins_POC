package Regression.Tims.Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Create_test_kit_For_PG_Actions;
import Test.Tims.Actions_Class.Create_test_kit_For_PL_Actions;
import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Actions_Class.Phlebotomist_csv_import_Actions;
import initializer.BaseClass;

public class T02_T03_T04_T07_Create_a_Phlebotomy_Gold_barcode_batches extends BaseClass{
	
	public Create_test_kit_For_PG_Actions create_test_kit_PG_actions;
	Create_test_kit_For_PL_Actions create_test_kit_PL_actions;
//	Login_Tims loginTest;
	Login_Action Login_action;
	
    @Test
	public void Create_kit_For_PG_SOFT_262_F1_Regression() throws IOException, InterruptedException {
		
//		loginTest = new Login_Tims();
		Login_action = new Login_Action(getDriver());
//		loginTest.login_Tims();
		Login_action.login_Tims_dev();
		create_test_kit_PG_actions = new Create_test_kit_For_PG_Actions(getDriver());

		create_test_kit_PG_actions.Test_Kit_Creation_PG();

	}
    

}
