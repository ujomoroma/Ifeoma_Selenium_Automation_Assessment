package Change_Password_Page;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class Change_Password extends Change_Password_PageObject {
	
	@Test(description="Verify that user can change password successfully")
	public void change_users_password() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//User enters his/her email and password then logs in successfully
		login_successfully("ifeomaujomor2@gmail.com", "Password@123");
		//User clicks on the profile icon
		click_On_Profile_Icon();
		//User clicks on the security module
		click_on_security_module();
		//User_enters his/her old password
		enter_old_password("Password@123");
		//User enter his/her new password
		enter_new_password("Password@1234");
		//User clicks on change password
		click_on_Change_Password_button();
		//Performs assertion
		confirm_password_change();
	}
}
