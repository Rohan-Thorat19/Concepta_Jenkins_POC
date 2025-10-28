package Tims.Partial_Report_SOFT_1407_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1407_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_30_Verify_Published_Test_Report_Functionality_With_Full_Blood_Results_General_Health extends BaseClass{

	SOFT_1407_Partial_Report_Actions soft_1407_partial_report_actions;

	@Test
	public void TC_30_Verify_published_test_report_functionality_with_full_blood_results_general_health() throws InterruptedException, IOException {
		soft_1407_partial_report_actions = new SOFT_1407_Partial_Report_Actions(getDriver());
		soft_1407_partial_report_actions.fullBloodResultPublishedReportGeneralHealth();
	}
}
