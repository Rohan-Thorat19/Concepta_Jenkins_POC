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

public class TC_43_Verify_The_Auto_Population_Of_Additional_Default_Content_for_Partial_Reporting_Genereal_Health_Test extends BaseClass{
	
	Test_Kits_Locators test_kits_locators;
	Test_Kits_Actions test_kits_actions;
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	SOFT_1366_Partial_Report_Actions sOFT_1366_Partial_Report_Actions;
	
	@Test
	public void TC_43_Verify_the_auto_population_of_additional_default_content_for_partial_reporting_genereal_health_test () throws Exception
	{
		String NewValue = "Inhibitory";
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboard();
		activate_test_kit_Actions.createDoubleBarcodeFromTimsToUseInDashboardForGeneralHealthTest();
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.successfulActivationOfATestKitUsingBothBarcodesValidInputs();
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.markAsReceivedBothResultsUploadedOfGeneralHealthProfileForPartialResultOfSoft1366("GeneralHealthProfilePrimary.csv", "GeneralHealthProfileSecondary.csv","854","958","458",NewValue,"958",NewValue);
		sOFT_1366_Partial_Report_Actions = new SOFT_1366_Partial_Report_Actions(getDriver());	
		sOFT_1366_Partial_Report_Actions.autoPopulationOfAdditionalDefaultContent();
}

}
