package Signup_Page;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class SignUp extends SignUp_PageObject {
	
	
	
	@Test(description= "Verify that User can Sign Up Successfully")
	public void Assessment_Two_Solution() throws InterruptedException {
		//implicit Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Visit the AlphaPay and clicks on the signup button
		click_On_SignUp_Btn();
		
		//User Enter his/her Fullname.
		enter_Full_Name(Fullname);
		
		//User Enters his/her username
		enter_Username(Username);
		
		//User Enters his/her email
		enter_Email(Email);
		
		//User Enters his/her phoneNumber
		enter_PhoneNumber(Phone_Number);
		
		//User Enters his/her password
		enter_Password(Password);
		
		//User Confirms his/her password
		confirm_Password(Password);
		
		//User clicks on the signup button
		click_OnCreate_Account();
		
		//Performs Assertions
		confirm_Successful_Signup();
	
	}

}