package Smoke.Hcp.Test_Cases;
import java.io.IOException;
import org.testng.annotations.Test;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Hcp.Actions_Class.Patients_Details_Actions;
import initializer.BaseClass;


public class TC_17Verify_Patient_Details_Display_Correctly extends BaseClass {
	// Declaration
	public Patients_Details_Actions patients_details_actions;
	//public Login_Action Login_action;
	public Login_Health_Professional_Actions login_health_professional_actions;  
	public TC_16Verify_Accurate_Display_Of_Patient_Information_and_NotEditable_feilds tc16Object;

    @Test
    public void Verify_Patient_Details_Display_Correctly() throws IOException, InterruptedException
    {
    	tc16Object = new TC_16Verify_Accurate_Display_Of_Patient_Information_and_NotEditable_feilds();
    	tc16Object.Verify_Accurate_Display_Of_Patient_Information_and_NotEditable_feilds();
		patients_details_actions.PatientDetailsDisplayCorrectly();
    }

}
