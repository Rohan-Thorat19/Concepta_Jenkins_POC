package Hcp.Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Hcp.Actions_Class.Patients_Details_Actions;
import Test.Kit.Actions_Class.Login_Action;
import initializer.BaseClass;

public class Verify_Patients_Details extends BaseClass {

	// Declaration
		public Patients_Details_Actions patients_details_actions;
		public Login_Action Login_action;
		
		@Test
		public void Verify_The_Left_Side_Menu_for_Phlebotomist_Dashboard() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.The_Left_Side_Menu_for_Phlebotomist_Dashboard();						
	    }
		
	    @Test
		public void Verify_Hcp_Patients_Details_Case1() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case1();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_Case2() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case2();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_Case3() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case3();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_Case4() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case4();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_Case5() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case5();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_Case6() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case6();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_Case7() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case7();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_Case8() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case8();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_Case9() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case9();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_Case10() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case10();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_Case11() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.Valid_Patients_Details_Case11();						
	    }
	    
	    @Test
	    public void Verify_Hcp_Patients_Details_InValid_Data() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.InValid_Patients_Details();						
	    }
	    
	    @Test
	    public void Verify_Accurate_Display_Of_Patient_Information_and_NotEditable_feilds() throws IOException, InterruptedException
	    {
			Login_action = new Login_Action(getDriver());
			Login_action.login_HCP();
			patients_details_actions = new Patients_Details_Actions(getDriver());
			patients_details_actions.AccurateDisplayOfPatientInformationAndNotEditableFeilds();	
			
	    }
	    
	    @Test
	    public void Verify_Patient_Details_Display_Correctly() throws IOException, InterruptedException
	    {
	    	Verify_Accurate_Display_Of_Patient_Information_and_NotEditable_feilds();
			patients_details_actions.PatientDetailsDisplayCorrectly();
	    }
	    
	    @Test
	    public void Verify_Store_Location_Search_Functionality() throws InterruptedException, IOException
	    {
	    	Verify_Accurate_Display_Of_Patient_Information_and_NotEditable_feilds();
			patients_details_actions.PatientDetailsDisplayCorrectly();
	    	patients_details_actions.Store_Location_Search_Functionality();
	    }
	    
	    @Test
	    public void Verify_Functionality_Of_Back_Button() throws InterruptedException, IOException
	    {
	    	Verify_Accurate_Display_Of_Patient_Information_and_NotEditable_feilds();
			patients_details_actions.PatientDetailsDisplayCorrectly();
	    	patients_details_actions.functionality_Of_Back_Button();
	    }
	    
	    
}