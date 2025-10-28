package Tims.Partial_Report_SOFT_1405_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1405_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_04_Verify_Partial_Test_Report_Energy_Profile_Test_For_FOL_GGT_Untestable_Misc_Post_Analytical extends BaseClass {

	SOFT_1405_Partial_Report_Actions soft_1405_partial_report_actions;

	@Test
	public void TC_04_Verify_partial_test_report_energy_profile_test_for_FOL_GGT_untestable_misc_post_analytical() throws InterruptedException, IOException {
		soft_1405_partial_report_actions = new SOFT_1405_Partial_Report_Actions(getDriver());
		soft_1405_partial_report_actions.partialReportTC4();
	}
}
