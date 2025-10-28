package Tims.Partial_Report_SOFT_1407_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1407_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_19_Verify_Partial_Report_For_Energy_Profile_Test_Biomarker_Other_Than_FBC_Untestable_Insufficiant_sample_receipt extends BaseClass{

	SOFT_1407_Partial_Report_Actions soft_1407_partial_report_actions;

	@Test
	public void TC_19_Verify_partial_report_energy_profile_test_biomarker_other_than_FBC_untestable_insufficient_sample() throws InterruptedException, IOException {
		soft_1407_partial_report_actions = new SOFT_1407_Partial_Report_Actions(getDriver());
		soft_1407_partial_report_actions.partialReportTC19();
	}
}
