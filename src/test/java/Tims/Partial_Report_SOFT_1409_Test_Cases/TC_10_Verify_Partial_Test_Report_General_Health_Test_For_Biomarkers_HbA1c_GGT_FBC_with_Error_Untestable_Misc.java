package Tims.Partial_Report_SOFT_1409_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1409_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_10_Verify_Partial_Test_Report_General_Health_Test_For_Biomarkers_HbA1c_GGT_FBC_with_Error_Untestable_Misc extends BaseClass{

SOFT_1409_Partial_Report_Actions soft_1409_partial_report_actions;
	
	@Test
	public void TC_10_Verify_partial_test_report_general_health_test_for_biomarkers_HbA1c_GGT_FBC_with_error_untestable_misc() throws InterruptedException, IOException {
		soft_1409_partial_report_actions = new SOFT_1409_Partial_Report_Actions(getDriver());
		soft_1409_partial_report_actions.partialReportTC10();
		
	}
}
