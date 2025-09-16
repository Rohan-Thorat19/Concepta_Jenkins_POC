package Dashboard.Health_Assessment_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_44_TC_61_TC_62_Verify_The_Conversion_Accuracy_For_Height_And_Weight_Values_Between_Metric_And_Imperial_Units extends BaseClass{

	Health_Assessment_Actions health_assessment_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_44_Verify_the_conversion_accuracy_for_height_and_weight_values_between_metric_and_imperial_units() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.submitConfirmDetailsForm();
		health_assessment_actions.verifyUnitConversion();
	}
	
	@Test(dependsOnMethods = "TC_44_Verify_the_conversion_accuracy_for_height_and_weight_values_between_metric_and_imperial_units")
	 public void TC_61_Verify_alignment_of_input_fields_and_labels() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyInputFieldsAndLabels();
	 }
	
	@Test(dependsOnMethods = "TC_61_Verify_alignment_of_input_fields_and_labels")
	 public void TC_62_Verify_page_layout_adapts_correctly_on_different_screen_sizes() throws IOException, InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyPageDifferentResolutions();
	 }
	 
	
}
