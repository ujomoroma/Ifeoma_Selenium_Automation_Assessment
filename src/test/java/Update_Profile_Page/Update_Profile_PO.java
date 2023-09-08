package Update_Profile_Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;


import Login_Page.Login;

public class Update_Profile_PO extends Login{
	Faker random = new Faker();

	private String profile_img = "//img[@alt='profile_image']";
	private String fullname_textbox = "//input[@name='full_name']";
	private String username_textbox = "//input[@name='username']";
	private String Update_button = "//button[@class='button btn_colored']";
	private String Successfull_update_Msg="//div[@role='status']";

	// Config
	private String Expected_Success_msg = "Update Successful";

	// Generate Random Data
	private String Firstname = random.name().firstName();
	private String Lastname = random.name().lastName();
	public String Fullname = Firstname + " " + Lastname;
	public String Username = Firstname + "." + Lastname;

	
	
	
	
	//Actions
	public void click_On_Profile_Icon() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(profile_img)).click();
	}
	
	private void scroll_down() {
		JavascriptExecutor jscript = (JavascriptExecutor) driver;
		jscript.executeScript("window.scrollBy(0, 500);");
	}
	
	private void clear_text_field(String locator) {
		JavascriptExecutor jscript = (JavascriptExecutor) driver;
		
		WebElement textField = driver.findElement(By.xpath(locator));
		jscript.executeScript("arguments[0].value = '';", textField);
	}

	public void Enter_new_fullname_and_username() throws InterruptedException {
		//Scrolls down to the details
		scroll_down();
		//Hard wait for 3 seconds for scroll to complete
		Thread.sleep(3000);
		
		//Clears the current value of the fullname
		clear_text_field(fullname_textbox);
		
		//Enters the new value of the fullname
		driver.findElement(By.xpath(fullname_textbox)).sendKeys(Fullname);
		
		//Clears the current value of the username
		clear_text_field(username_textbox);
		driver.findElement(By.xpath(username_textbox)).click();
		clear_text_field(username_textbox);
		
		//Enter the new value of the user name
		driver.findElement(By.xpath(username_textbox)).sendKeys(Username);
	}
	
	public void click_on_update_button() {
		driver.findElement(By.xpath(Update_button)).click();
	}

	private String get_update_SuccessMsg() {
		String Success_Message = driver.findElement(By.xpath(Successfull_update_Msg)).getText();
		return Success_Message;
	}

	public void confirm_Profile_Update() {
		SoftAssert softassert = new SoftAssert();
		String Actual_Success_msg = get_update_SuccessMsg();
		softassert.assertEquals(Actual_Success_msg, Expected_Success_msg);
		softassert.assertAll();
	}

}
