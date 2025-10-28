package Tims.Partial_Report_SOFT_1407_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1407_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_13_Verify_Partial_Reporting_Energy_Profile_Test_PLT_RBC_WBC_Untestable_Insufficient_Sample_Receipt extends BaseClass{

	SOFT_1407_Partial_Report_Actions soft_1407_partial_report_actions;

	@Test
	public void TC_13_Verify_partial_reporting_energy_profile_test_PLT_RBC_WBC_untestable_insufficient_sample_receipt() throws InterruptedException, IOException {
		soft_1407_partial_report_actions = new SOFT_1407_Partial_Report_Actions(getDriver());
		soft_1407_partial_report_actions.partialReportTC13();
	}
}
