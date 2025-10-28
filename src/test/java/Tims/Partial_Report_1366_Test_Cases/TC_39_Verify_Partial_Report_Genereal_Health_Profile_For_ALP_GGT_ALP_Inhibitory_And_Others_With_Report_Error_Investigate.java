package Tims.Partial_Report_1366_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Tims.Actions_Class.Test_Kits_Actions;
import Test.Tims.Locators_Class.Test_Kits_Locators;
import Test.Tims.Partial_Report_Actions_Class.SOFT_1366_Partial_Report_Actions;
import initializer.BaseClass;


public class TC_39_Verify_Partial_Report_Genereal_Health_Profile_For_ALP_GGT_ALP_Inhibitory_And_Others_With_Report_Error_Investigate extends BaseClass{
	
	Test_Kits_Locators test_kits_locators;
	Test_Kits_Actions test_kits_actions;
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	SOFT_1366_Partial_Report_Actions sOFT_1366_Partial_Report_Actions;
	
	@Test
	public void TC_39_Verify_partial_report_energy_profile_for_ALP_GGT_ALP_inhibitory_and_others_with_report_error_investigate() throws Exception
	{
		String NewValue1 = "Inhibitory";
		String NewValue2 = "Report error – investigate";
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboard();
		activate_test_kit_Actions.createDoubleBarcodeFromTimsToUseInDashboardForGeneralHealthTest();
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.successfulActivationOfATestKitUsingBothBarcodesValidInputs();
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.markAsReceivedBothResultsUploadedForPartialResultOfSoft1366OfFailCsvFileWithMultipleValuesGenerealHealthProfile("GeneralHealthProfilePrimary.csv", "GeneralHealthProfileSecondary.csv","854","958","458","1111","2222",NewValue1,NewValue1,NewValue1,NewValue2,NewValue2);	
		activate_test_kit_Actions.publishKitAndCheckStatusForEnergyProfileForFailCsv();
}

}

