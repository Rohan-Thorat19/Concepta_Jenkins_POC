package Tims.Partial_Report_SOFT_1407_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1407_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_27_Verify_Partial_Report_Energy_Profile_Test_FOL_ALT_GGT_And_FBC_Group_Untestable_Insufficient_Post_Analytical extends BaseClass{

	SOFT_1407_Partial_Report_Actions soft_1407_partial_report_actions;

	@Test
	public void TC_27_Verify_partial_reporting_energy_profile_test_FOL_ALT_GGT_and_FBC_group_insufficient_post_analytical() throws InterruptedException, IOException {
		soft_1407_partial_report_actions = new SOFT_1407_Partial_Report_Actions(getDriver());
		soft_1407_partial_report_actions.partialReportTC27();
	}
}
