package Tims.Partial_Report_SOFT_1409_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1409_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_17_Verify_Partial_Report_For_Weight_Management_Test_For_Biomarkers_FOL_HbA1c_with_Error_Reason_Inhibitory extends BaseClass{

SOFT_1409_Partial_Report_Actions soft_1409_partial_report_actions;
	
	@Test
	public void TC_17_Verify_partial_report_for_weight_management_test_for_biomarkers_FOL_HbA1c_with_error_reason_inhibitory() throws InterruptedException, IOException {
		soft_1409_partial_report_actions = new SOFT_1409_Partial_Report_Actions(getDriver());
		soft_1409_partial_report_actions.partialReportTC17();
		
	}
}
