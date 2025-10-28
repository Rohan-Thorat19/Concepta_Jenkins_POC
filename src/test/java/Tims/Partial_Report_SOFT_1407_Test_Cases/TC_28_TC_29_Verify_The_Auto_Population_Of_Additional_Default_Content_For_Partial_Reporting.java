package Tims.Partial_Report_SOFT_1407_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Partial_Report_Actions_Class.SOFT_1405_Partial_Report_Actions;
import Test.Tims.Partial_Report_Actions_Class.SOFT_1407_Partial_Report_Actions;
import Test.Tims.Partial_Report_Locators_Class.SOFT_1405_Partial_Report_Locators;
import initializer.BaseClass;

public class TC_28_TC_29_Verify_The_Auto_Population_Of_Additional_Default_Content_For_Partial_Reporting extends BaseClass{
	
	SOFT_1407_Partial_Report_Actions soft_1407_partial_report_actions;
	SOFT_1405_Partial_Report_Actions soft_1405_partial_report_actions;
	SOFT_1405_Partial_Report_Locators soft_1405_partial_report_locators;

	@Test
	public void TC_28_Verify_the_auto_population_of_additional_default_content_for_partial_reporting() throws InterruptedException, IOException {
		soft_1407_partial_report_actions = new SOFT_1407_Partial_Report_Actions(getDriver());
		soft_1407_partial_report_actions.partialReportTC28();
	}
	
	@Test(dependsOnMethods = "TC_28_Verify_the_auto_population_of_additional_default_content_for_partial_reporting")
	public void TC_29_Verify_the_display_and_selection_behavior_of_group_status_for_FBC_area_in_partial_report() {
		soft_1405_partial_report_actions = new SOFT_1405_Partial_Report_Actions(getDriver());
		soft_1405_partial_report_locators = new SOFT_1405_Partial_Report_Locators(getDriver());
		soft_1405_partial_report_actions.assertInvisibility(soft_1405_partial_report_locators.get_testReportFullBloodCountBtn(), "Full blood count");
	}

}
