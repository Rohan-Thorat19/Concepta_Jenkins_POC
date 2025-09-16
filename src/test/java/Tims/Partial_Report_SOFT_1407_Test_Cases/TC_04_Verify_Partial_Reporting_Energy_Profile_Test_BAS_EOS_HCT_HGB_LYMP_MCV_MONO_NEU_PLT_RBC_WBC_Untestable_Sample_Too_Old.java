package Tims.Partial_Report_SOFT_1407_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Action_Class.SOFT_1407_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_04_Verify_Partial_Reporting_Energy_Profile_Test_BAS_EOS_HCT_HGB_LYMP_MCV_MONO_NEU_PLT_RBC_WBC_Untestable_Sample_Too_Old extends BaseClass{

	SOFT_1407_Partial_Report_Actions soft_1407_partial_report_actions;

	@Test
	public void TC_04_Verify_partial_reporting_energy_profile_test_BAS_EOS_HCT_HGB_LYMP_MCV_MONO_NEU_PLT_RBC_WBC_untestable_sample_too_old() throws InterruptedException, IOException {
		soft_1407_partial_report_actions = new SOFT_1407_Partial_Report_Actions(getDriver());
		soft_1407_partial_report_actions.partialReportTC04();
	}
}
