package Logout_page;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class LogOut extends Logout_PageObject {
	
	@Test(description = "Verify that user is logged out successfully")
	public void Logout_Successfully() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// User enters his/her email and password then logs in successfully
		login_successfully("ifeomaujomor@gmail.com", "Password@12345");
		// User clicks on the profile icon
		click_On_Profile_Icon();
		//User clicks on logout button
		click_on_logout_button();
		//Perform Assert
		confirm_Logout();
	}

}
