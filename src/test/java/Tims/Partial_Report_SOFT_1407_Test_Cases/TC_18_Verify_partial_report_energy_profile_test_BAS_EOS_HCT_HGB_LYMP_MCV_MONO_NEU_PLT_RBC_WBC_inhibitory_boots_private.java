package Tims.Partial_Report_SOFT_1407_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1407_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_18_Verify_partial_report_energy_profile_test_BAS_EOS_HCT_HGB_LYMP_MCV_MONO_NEU_PLT_RBC_WBC_inhibitory_boots_private extends BaseClass {

	SOFT_1407_Partial_Report_Actions soft_1407_partial_report_actions;

	@Test
	public void TC_10_Verify_partial_report_energy_profile_test_BAS_EOS_HCT_HGB_LYMP_MCV_MONO_NEU_PLT_RBC_WBC_inhibitory_boots_private() throws InterruptedException, IOException {
		soft_1407_partial_report_actions = new SOFT_1407_Partial_Report_Actions(getDriver());
		soft_1407_partial_report_actions.partialReportTC18();
	}
}
