package Login_Page;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class Login extends Login_PageObject {
		
		@SuppressWarnings("deprecation")
		@Test(description="Verify that user Login Successfully")
		public void Login_Successful() {
			//Implicit Wait
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//User Clicks on Login Button
			click_On_Login_button();
			
			//User enters his/her email
			enter_EmailAddress("ifeomaujomor@gmail.com");
			
			//User enters password
			enter_Password("Password@12345");
			
			//User Clicks on Sigin
			click_On_Signin_Button();
			
			//Performs Assertions
			confirm_Successful_Login();
		}
}
