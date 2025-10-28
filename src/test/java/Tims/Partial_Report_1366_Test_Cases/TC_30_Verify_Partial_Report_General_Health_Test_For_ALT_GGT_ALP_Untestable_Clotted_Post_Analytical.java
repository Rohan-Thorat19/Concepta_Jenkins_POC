package Tims.Partial_Report_1366_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Tims.Actions_Class.SH_Actions;
import Test.Tims.Actions_Class.Test_Kits_Actions;
import Test.Tims.Locators_Class.SH_Locators;
import Test.Tims.Locators_Class.Test_Kits_Locators;
import Test.Tims.Partial_Report_Actions_Class.SOFT_1366_Partial_Report_Actions;
import Test.Tims.Partial_Report_Locators_Class.SOFT_1366_Partial_Report_Locators;
import initializer.BaseClass;

public class TC_30_Verify_Partial_Report_General_Health_Test_For_ALT_GGT_ALP_Untestable_Clotted_Post_Analytical extends BaseClass{
	
	Test_Kits_Locators test_kits_locators;
	Test_Kits_Actions test_kits_actions;
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	SOFT_1366_Partial_Report_Actions sOFT_1366_Partial_Report_Actions;
	
	@Test
	public void TC_30_Verify_partial_report_general_health_test_for_ALT_GGT_ALP_untestable_clotted_post_analytical () throws Exception
	{
		String NewValue = "Untestable – Clotted (post-analytical)";
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboard();
		activate_test_kit_Actions.createDoubleBarcodeFromTimsToUseInDashboardForGeneralHealthTest();
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.successfulActivationOfATestKitUsingBothBarcodesValidInputs();
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.markAsReceivedBothResultsUploadedOfGeneralHealthProfileForPartialResultOfSoft1366("GeneralHealthProfilePrimary.csv", "GeneralHealthProfileSecondary.csv","854","958","458",NewValue,NewValue,NewValue);
		sOFT_1366_Partial_Report_Actions = new SOFT_1366_Partial_Report_Actions(getDriver());	
		sOFT_1366_Partial_Report_Actions.publishKitAndCheckStatusForGeneralHealthProfile("ALT_GGT_ALP_sample_receipt");
}

}


