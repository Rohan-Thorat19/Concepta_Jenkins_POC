package Tims.Partial_Report_SOFT_1409_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1409_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_04_Verify_Partial_Test_Report_For_The_General_Health_Test_For_HbA1c_GGT_with_Error_Untestable_Insufficient_Sample_Receipt extends BaseClass{

SOFT_1409_Partial_Report_Actions soft_1409_partial_report_actions;
	
	@Test
	public void TC_04_Verify_partial_test_report_for_the_general_health_test_for_biomarkers_HbA1c_GGT_with_error_reason_untestable_insufficient_sample_receipt() throws InterruptedException, IOException {
		soft_1409_partial_report_actions = new SOFT_1409_Partial_Report_Actions(getDriver());
		soft_1409_partial_report_actions.partialReportTC4();
		
	}
}
