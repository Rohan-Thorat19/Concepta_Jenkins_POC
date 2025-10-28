package Tims.Partial_Report_SOFT_1405_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1405_Partial_Report_Actions;
import initializer.BaseClass;



public class TC_01_Verify_Published_Test_Report_Functionality_With_Full_Blood_Results extends BaseClass{
	
	SOFT_1405_Partial_Report_Actions soft_1405_partial_report_actions;

	@Test
	public void TC_01_Verify_published_test_report_functionality_with_full_blood_results() throws InterruptedException, IOException {
		soft_1405_partial_report_actions = new SOFT_1405_Partial_Report_Actions(getDriver());
		soft_1405_partial_report_actions.fullBloodResultPublishedReport();
	}
}
