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

public class TC_22_Verify_Display_Selection_Behavior_Of_Group_Status_for_Liver_Health_Area_Partial_Reporting_Energy extends BaseClass{
	
	Test_Kits_Locators test_kits_locators;
	Test_Kits_Actions test_kits_actions;
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	SOFT_1366_Partial_Report_Actions sOFT_1366_Partial_Report_Actions;
	
	@Test
	public void TC_22_Verify_display_selection_behavior_of_group_status_for_liver_health_area_partial_reporting_energy () throws Exception
	{
		String NewValue = "Untestable – Clotted (sample receipt)";
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboard();
		activate_test_kit_Actions.createDoubleBarcodeFromTimsToUseInDashboard();
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.successfulActivationOfATestKitUsingBothBarcodesValidInputs();
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.markAsReceivedBothResultsUploadedForPartialResultOfSoft1366("EnergyProfilePrimary.csv", "EnergyProfileSecondary.csv","854","958","458",NewValue,NewValue,NewValue);
		sOFT_1366_Partial_Report_Actions = new SOFT_1366_Partial_Report_Actions(getDriver());	
		activate_test_kit_Actions.assignKitAndCheckStatusForEnergyProfile();
}

}

