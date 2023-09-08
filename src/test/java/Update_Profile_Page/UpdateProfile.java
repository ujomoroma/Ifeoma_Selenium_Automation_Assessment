package Update_Profile_Page;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class UpdateProfile extends Update_Profile_PO{
	
	@Test(description="Verify user can update his/her details successfully")
	public void Update_User_Profile() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Login_Successful();
		click_On_Profile_Icon();
		Enter_new_fullname_and_username();
		click_on_update_button();
		confirm_Profile_Update();
	}
}
