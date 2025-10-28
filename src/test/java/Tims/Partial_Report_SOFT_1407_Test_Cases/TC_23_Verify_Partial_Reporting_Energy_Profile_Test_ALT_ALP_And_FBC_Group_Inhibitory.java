package Tims.Partial_Report_SOFT_1407_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1407_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_23_Verify_Partial_Reporting_Energy_Profile_Test_ALT_ALP_And_FBC_Group_Inhibitory extends BaseClass{

	SOFT_1407_Partial_Report_Actions soft_1407_partial_report_actions;

	@Test
	public void TC_23_Verify_partial_reporting_energy_profile_test_ALT_ALP_and_FBC_group_inhibitory() throws InterruptedException, IOException {
		soft_1407_partial_report_actions = new SOFT_1407_Partial_Report_Actions(getDriver());
		soft_1407_partial_report_actions.partialReportTC23();
	}
	
}
