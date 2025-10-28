package Tims.Partial_Report_1366_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Tims.Actions_Class.Test_Kits_Actions;
import Test.Tims.Locators_Class.Test_Kits_Locators;
import Test.Tims.Partial_Report_Actions_Class.SOFT_1366_Partial_Report_Actions;
import initializer.BaseClass;

public class TC_37_Verify_Partial_Report_Genereal_Health_Profile_for_Other_Than_ALP_GGT_ALP_Untestable_Insufficient_Sample_Receipt extends BaseClass{
	
	Test_Kits_Locators test_kits_locators;
	Test_Kits_Actions test_kits_actions;
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	SOFT_1366_Partial_Report_Actions sOFT_1366_Partial_Report_Actions;
	
	@Test
	public void TC_37_Verify_partial_report_general_health_profile_for_other_than_ALP_GGT_ALP_untestable_insufficient_sample_receipt() throws Exception
	{
		String NewValue = "Untestable – Insufficient (sample receipt)";
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboard();
		activate_test_kit_Actions.createDoubleBarcodeFromTimsToUseInDashboardForGeneralHealthTest();
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.successfulActivationOfATestKitUsingBothBarcodesValidInputs();
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.markAsReceivedBothResultsUploadedForPartialResultOfSoft1366OfFailCsvFileGeneralHealthProfile("GeneralHealthProfilePrimary.csv", "GeneralHealthProfileSecondary.csv","9999","1111","2222",NewValue,NewValue,NewValue);	
		activate_test_kit_Actions.publishKitAndCheckStatusForEnergyProfileForFailCsv();
}

}

