package Change_Password_Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import Base.Base_File;
import Login_Page.Login;

public class Change_Password_PageObject extends Base_File {
	Faker random = new Faker();

	// Locators
	private String login_btn="//button[contains(text(),'LOG IN')]";
	private String email_textbox= "//input[@placeholder='example@gmail.com']";
	private String password_textbox="//input[@placeholder='password']";
	private String signin_btn="//button[@class='button btn_colored']";
	
	private String Security_Module = "//a[normalize-space()='Security']";
	private String profile_img = "//img[@alt='profile_image']";
	private String old_password_textbox = "//input[@placeholder='Old Password']";
	private String new_password_textbox = "//input[@placeholder='New Password']";
	private String change_password_btn = "//button[@type='submit']";
	private String successful_password_Change = "//div[@role='status']";

	// Config
	private String Expected_Success_Message = "Password updated successfully";
	
	
	
	public void login_successfully(String Email, String Password) {
		driver.findElement(By.xpath(login_btn)).click();
		driver.findElement(By.xpath(email_textbox)).sendKeys(Email);
		driver.findElement(By.xpath(password_textbox)).sendKeys(Password);
		driver.findElement(By.xpath(signin_btn)).click();
	}

	public void click_On_Profile_Icon() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(96));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(profile_img)));
		Thread.sleep(5000);
		driver.findElement(By.xpath(profile_img)).click();
	}

	public void click_on_security_module() {
		driver.findElement(By.xpath(Security_Module)).click();
	}
	
	String old_password="";
	public void enter_old_password(String old_password) {
		driver.findElement(By.xpath(old_password_textbox)).sendKeys(old_password);
	}

	public void enter_new_password(String new_password) {
		driver.findElement(By.xpath(new_password_textbox)).sendKeys(new_password);
	}

	public void click_on_Change_Password_button() {
		driver.findElement(By.xpath(change_password_btn)).click();
		
		
	}

	public String get_password_change_success_msg() {
		String passwordchange_message = driver.findElement(By.xpath(successful_password_Change)).getText();
		return passwordchange_message;
	}

	public void confirm_password_change() {
		SoftAssert softassert = new SoftAssert();
		String Actual_Success_Message = get_password_change_success_msg();

		softassert.assertEquals(Actual_Success_Message, Expected_Success_Message);
		softassert.assertAll();
	}
}
