package Tims.Partial_Report_SOFT_1405_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1405_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_10_Verify_Partial_Test_Report_Energy_Profile_Test_Other_Than_FOL_ALT_GGT_ALP_Untestable_Clotted_Post_Analytical extends BaseClass{

	SOFT_1405_Partial_Report_Actions soft_1405_partial_report_actions;

	@Test
	public void TC_10_Verify_partial_test_report_energy_profile_test_other_than_FOL_ALT_GGT_ALP_untestable_clotted_post_analytical() throws InterruptedException, IOException {
		soft_1405_partial_report_actions = new SOFT_1405_Partial_Report_Actions(getDriver());
		soft_1405_partial_report_actions.partialReportTC10();
	}
}
