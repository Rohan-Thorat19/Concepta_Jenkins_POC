package Tims.Partial_Report_SOFT_1407_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Action_Class.SOFT_1407_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_15_Verify_Partial_Reporting_Energy_Profile_Test_FBC_Group_Inhibitory_Remaining_Biomarker_Different_Error_Reason extends BaseClass{

	SOFT_1407_Partial_Report_Actions soft_1407_partial_report_actions;

	@Test
	public void TC_15_Verify_partial_reporting_energy_profile_test_FBC_group_inhibitory_remaining_biomarker_different_error_reason() throws InterruptedException, IOException {
		soft_1407_partial_report_actions = new SOFT_1407_Partial_Report_Actions(getDriver());
		soft_1407_partial_report_actions.partialReportTC15();
	}
}
