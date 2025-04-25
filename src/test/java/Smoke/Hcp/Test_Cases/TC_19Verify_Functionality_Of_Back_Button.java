package Smoke.Hcp.Test_Cases;
import java.io.IOException;
import org.testng.annotations.Test;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Hcp.Actions_Class.Patients_Details_Actions;
import initializer.BaseClass;


public class TC_19Verify_Functionality_Of_Back_Button extends BaseClass {
	// Declaration
	public Patients_Details_Actions patients_details_actions;
	//public Login_Action Login_action;
	public Login_Health_Professional_Actions login_health_professional_actions;    	    
	public TC_16Verify_Accurate_Display_Of_Patient_Information_and_NotEditable_feilds tc16Object;
	
    @Test
    public void Verify_Functionality_Of_Back_Button() throws InterruptedException, IOException
    {	tc16Object = new TC_16Verify_Accurate_Display_Of_Patient_Information_and_NotEditable_feilds();
        tc16Object.Verify_Accurate_Display_Of_Patient_Information_and_NotEditable_feilds();
		patients_details_actions.PatientDetailsDisplayCorrectly();
    	patients_details_actions.functionality_Of_Back_Button();
    }


}
