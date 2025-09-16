package Tims.Partial_Report_SOFT_1405_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Action_Class.SOFT_1405_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_11_Verify_Partial_Test_Report_Vitamins_Minerals_Profile_Test_For_FOL_Untestable_Insufficient_Post_Analytical extends BaseClass{

	SOFT_1405_Partial_Report_Actions soft_1405_partial_report_actions;

	@Test
	public void TC_11_Verify_partial_test_report_vitamins_minerals_profile_test_for_FOL_untestable_insufficient_post_analytical() throws InterruptedException, IOException {
		soft_1405_partial_report_actions = new SOFT_1405_Partial_Report_Actions(getDriver());
		soft_1405_partial_report_actions.partialReportTC11();
		
	}
}
