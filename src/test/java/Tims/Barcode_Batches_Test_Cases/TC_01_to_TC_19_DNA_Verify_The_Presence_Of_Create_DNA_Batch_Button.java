package Tims.Barcode_Batches_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Barcode_Batches_Actions;
import initializer.BaseClass;

public class TC_01_to_TC_19_DNA_Verify_The_Presence_Of_Create_DNA_Batch_Button extends BaseClass {
	
	Barcode_Batches_Actions barcode_batches_actions;
	
	@Test
	public void TC_01_DNA_Verify_the_presence_of_create_DNA_batch_button() throws IOException, InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyPresenceOfCreateDNABatchBtn();
	}

	@Test(dependsOnMethods = "TC_01_DNA_Verify_the_presence_of_create_DNA_batch_button")
	public void TC_02_DNA_Verify_that_the_create_DNA_batch_button_opens_the_form() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyOpeningOfCreateDNABatchForm();
	}
	
	@Test(dependsOnMethods = "TC_02_DNA_Verify_that_the_create_DNA_batch_button_opens_the_form")
	public void TC_03_Verify_that_the_type_dropdown_has_the_wellness_option() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCreateDNABatchTypeDrpValues();
	}
	
	@Test(dependsOnMethods = "TC_03_Verify_that_the_type_dropdown_has_the_wellness_option")
	public void TC_04_Verify_that_the_sub_type_dropdown_has_the_correct_options() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCreateDNABatchSubTypeNonEditable();
	}
	
	@Test(dependsOnMethods = "TC_04_Verify_that_the_sub_type_dropdown_has_the_correct_options")
	public void TC_05_Verify_that_the_count_field_has_a_help_text() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyHelpTextForCountFieldDna();
	}
	
	@Test(dependsOnMethods = "TC_05_Verify_that_the_count_field_has_a_help_text")
	public void TC_06_Verify_that_the_count_field_only_accepts_numbers_and_greater_than_2() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyFunctionalityOfCountFieldDNA();
	}
	
	@Test(dependsOnMethods = "TC_06_Verify_that_the_count_field_only_accepts_numbers_and_greater_than_2")
	public void TC_07_Verify_dynamic_population_of_customer_dropdown() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCustomerDrpValuesDna();
	}
	
	@Test(dependsOnMethods = "TC_07_Verify_dynamic_population_of_customer_dropdown")
	public void TC_08_Verify_the_title_of_the_form_is_Create_DNA_batch() throws IOException, InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.presenceOfCreateDNABatchTitle();
	}
	
	@Test(dependsOnMethods = "TC_08_Verify_the_title_of_the_form_is_Create_DNA_batch")
	public void TC_09_Verify_that_the_form_has_a_cancel_button() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.presenceOfCancelBtnDnaBatch();
	}
	
	@Test(dependsOnMethods = "TC_09_Verify_that_the_form_has_a_cancel_button")
	public void TC_10_Verify_form_validation_triggers_when_required_fields_are_empty() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.emptyRequiredFieldsDnaBatch();
	}
	
	@Test(dependsOnMethods = "TC_10_Verify_form_validation_triggers_when_required_fields_are_empty")
	public void TC_11_Verify_alignment_and_appearance_of_form_on_different_screen_sizes() throws IOException, InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.formAlignmentOnDifferentScreenSizes();
	}
	
	@Test(dependsOnMethods = "TC_11_Verify_alignment_and_appearance_of_form_on_different_screen_sizes")
	public void TC_12_Verify_that_the_Cancel_button_clears_all_fields_without_saving() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.dnaBatchCancelBtnFunctionality();
	}
	
	@Test(dependsOnMethods = "TC_12_Verify_that_the_Cancel_button_clears_all_fields_without_saving")
	public void TC_13_Verify_user_can_create_DNA_Batch() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.successfulDnaBatchCreation();
	}
	
	@Test(dependsOnMethods = "TC_13_Verify_user_can_create_DNA_Batch")
	public void TC_14_Validate_that_the_current_customer_is_selected_by_default_in_the_customer_field() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCurrentCustIsSelectedByDefault();
	}
	
	@Test(dependsOnMethods = "TC_14_Validate_that_the_current_customer_is_selected_by_default_in_the_customer_field")
	public void TC_15_Validate_that_the_customer_dropdown_list_is_populated_with_existing_customers() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyEditBatchCustDrpOptions();
	}
	
	@Test(dependsOnMethods = "TC_15_Validate_that_the_customer_dropdown_list_is_populated_with_existing_customers")
	public void TC_16_Validate_that_the_customer_can_update_the_customer_field() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyUserCanUpdateCustField();
	}
	
	@Test(dependsOnMethods = "TC_16_Validate_that_the_customer_can_update_the_customer_field")
	public void TC_17_Validate_that_the_user_can_update_the_comment_field() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyUserCanUpdateEditBatchCommentField();
	}
	
	@Test(dependsOnMethods = "TC_17_Validate_that_the_user_can_update_the_comment_field")
	public void TC_18_Validate_that_comment_field_accepts_alphanumeric_characters() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyEditBatchCommentFieldAcceptsAlphanumericCharacters();
	}
	
	@Test(dependsOnMethods = "TC_18_Validate_that_comment_field_accepts_alphanumeric_characters")
	public void TC_19_Validate_that_after_making_changes_the_user_can_cancel_the_update_process() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyEditBatchCancelFunctionality();
	}
}
