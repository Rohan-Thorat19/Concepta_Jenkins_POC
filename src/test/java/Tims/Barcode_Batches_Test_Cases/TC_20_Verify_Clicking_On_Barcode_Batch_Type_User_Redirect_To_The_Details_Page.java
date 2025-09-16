package Tims.Barcode_Batches_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Barcode_Batches_Actions;
import initializer.BaseClass;

public class TC_20_Verify_Clicking_On_Barcode_Batch_Type_User_Redirect_To_The_Details_Page extends BaseClass {
	
	Barcode_Batches_Actions barcode_batches_actions;
	
	@Test
	public void TC_20_Verify_clicking_on_barcode_batch_type_user_redirect_to_the_details_page() throws IOException, InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyUserRedirectedToBatchDetailsPage();
	}
	
	@Test(dependsOnMethods = "TC_20_Verify_clicking_on_barcode_batch_type_user_redirect_to_the_details_page")
	public void TC_21_Verify_the_ability_to_view_the_list_of_barcodes_for_a_specific_batch() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.presenceOfGeneratedBarcodes();
	}
	
	@Test(dependsOnMethods = "TC_21_Verify_the_ability_to_view_the_list_of_barcodes_for_a_specific_batch")
	public void TC_22_Verify_the_correct_display_of_barcode_code_values_in_the_barcode_listing() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyGeneratedBarcodesAreCorrect();
	}
	
	@Test(dependsOnMethods = "TC_22_Verify_the_correct_display_of_barcode_code_values_in_the_barcode_listing")
	public void TC_23_Verify_the_correct_display_of_status_for_each_barcode_in_the_listing() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCorrectStatusForBarcodes();
	}
	
	@Test(dependsOnMethods = "TC_23_Verify_the_correct_display_of_status_for_each_barcode_in_the_listing")
	public void TC_24_Verify_clicking_on_barcode_in_listing_user_redirect_to_barcode_details_page() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyUserRedirectedToBarcodeDetailsPage();
	}
	
	@Test(dependsOnMethods = "TC_24_Verify_clicking_on_barcode_in_listing_user_redirect_to_barcode_details_page")
	public void TC_25_Verify_that_the_barcode_list_page_is_responsive_across_different_screen_sizes() throws InterruptedException, IOException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyBarodeListOnDifferentScreenSizes();
	}
}
