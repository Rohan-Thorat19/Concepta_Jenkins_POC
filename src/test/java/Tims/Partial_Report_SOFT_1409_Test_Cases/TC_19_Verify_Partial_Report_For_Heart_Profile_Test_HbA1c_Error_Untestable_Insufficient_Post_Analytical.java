package Tims.Partial_Report_SOFT_1409_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1409_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_19_Verify_Partial_Report_For_Heart_Profile_Test_HbA1c_Error_Untestable_Insufficient_Post_Analytical extends BaseClass{

SOFT_1409_Partial_Report_Actions soft_1409_partial_report_actions;
	
	@Test
	public void TC_19_Verify_partial_report_for_heart_profile_test_for_biomarkers_HbA1c_with_error_reason_untestable_insufficient_post_analytical() throws InterruptedException, IOException {
		soft_1409_partial_report_actions = new SOFT_1409_Partial_Report_Actions(getDriver());
		soft_1409_partial_report_actions.partialReportTC19();
		
	}
}
