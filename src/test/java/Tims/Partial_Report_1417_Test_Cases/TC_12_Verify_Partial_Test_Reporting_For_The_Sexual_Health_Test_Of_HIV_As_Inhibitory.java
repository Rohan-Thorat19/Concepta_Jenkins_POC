package Tims.Partial_Report_1417_Test_Cases;

import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Tims.Actions_Class.SH_Actions;
import Test.Tims.Actions_Class.Test_Kits_Actions;
import Test.Tims.Locators_Class.SH_Locators;
import Test.Tims.Locators_Class.Test_Kits_Locators;
import Test.Tims.Partial_Report_Actions_Class.SOFT_1417_Partial_Report_Actions;
import Test.Tims.Partial_Report_Locators_Class.SOFT_1417_Partial_Report_Locators;
import initializer.BaseClass;

public class TC_12_Verify_Partial_Test_Reporting_For_The_Sexual_Health_Test_Of_HIV_As_Inhibitory extends BaseClass{
	
	Test_Kits_Locators test_kits_locators;
	Test_Kits_Actions test_kits_actions;
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	SOFT_1417_Partial_Report_Actions sOFT_1417_Partial_Report_Actions;
	SH_Actions sH_Actions;
	
	@Test
	public void TC_12_Verify_partial_test_reporting_for_the_sexual_health_test_of_HIV_as_inhibitory() throws Exception
	{
		String NewValue = "Inhibitory";
		sH_Actions = new SH_Actions(getDriver());		
		sH_Actions.TimsUrl();	
		sH_Actions.createBarcodes();
		sH_Actions.dashboardLogin();
		sH_Actions.activateKitJourney();
		sH_Actions.TimsUrl();
		sH_Actions.markAsReceivedBothResultsUploadedForPartialResultOfSoft1417("SH_Primary.csv", "SH_Secondary.csv","Untestable – Grossly haemolysed",NewValue,"Not detected","Not detected");
		sOFT_1417_Partial_Report_Actions = new SOFT_1417_Partial_Report_Actions(getDriver());	
		sOFT_1417_Partial_Report_Actions.publishKitAndCheckStatusForEnergyProfileForAllOptionsSexualHealthProfile("HIV SYPH Text");
}

}


