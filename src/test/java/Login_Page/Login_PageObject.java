package Login_Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Base.Base_File;

public class Login_PageObject extends Base_File {
	
	//Locators
	private String login_btn="//button[contains(text(),'LOG IN')]";
	private String email_textbox= "//input[@placeholder='example@gmail.com']";
	private String password_textbox="//input[@placeholder='password']";
	private String signin_btn="//button[@class='button btn_colored']";
	private String WelcomeMsg= "//div[contains(text(),'Welcome to your dashboard')]";
	private String login_Message= "//div[contains(text(),'Login Successful')]";
	
	// Config_Files
	private String Expected_Dashboard_URL="https://alphapay.netlify.app/dashboard/overview";
	private String Expected_Login_Message="Login Successful";
	private String Expected_Welcome_Message= "Welcome to your dashboard";

	
	//Actions
	public void click_On_Login_button() {
		driver.findElement(By.xpath(login_btn)).click();
	}
	
	public void enter_EmailAddress(String Email) {
		driver.findElement(By.xpath(email_textbox)).sendKeys(Email);
	}
	
	public void enter_Password(String Password) {
		driver.findElement(By.xpath(password_textbox)).sendKeys(Password);
	}
	
	public void click_On_Signin_Button() {
		driver.findElement(By.xpath(signin_btn)).click();
	}
	
	public String get_Signin_Welcome_Msg() {
		String Welcome_Msg= driver.findElement(By.xpath(WelcomeMsg)).getText();
		return Welcome_Msg;
	}
	
	public String get_login_Message() {
		String Login_Message= driver.findElement(By.xpath(login_Message)).getText();
		return Login_Message;
	}
	
	
	public void confirm_Successful_Login() {
		//Instantiating the soft assertion
		SoftAssert softassert= new SoftAssert();
		//Instantiating the Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(56));
		
		//Gets the login message
		String Actual_LoginIn_message= get_login_Message();
		
		//Gets the URL of the overview dashboard
		String Actual_Dashboard_URL= driver.getCurrentUrl();
		
		//Asserts that the displayed login Message is correct
		softassert.assertEquals(Actual_LoginIn_message, Expected_Login_Message);
		
		//Saves the element of in a webelement
		WebElement Signup_Msg= driver.findElement(By.xpath(WelcomeMsg));
		
		//Waits until that element is displayed
		wait.until(ExpectedConditions.visibilityOf(Signup_Msg));
		
		//Gets the welcome message
		String Actual_Welcome_message= get_Signin_Welcome_Msg();
		
		//Asserts that the displayed welcome Message is correct
		softassert.assertEquals(Actual_Welcome_message, Expected_Welcome_Message);
		
		//Asserts that the URL is correct
		softassert.assertEquals(Actual_Dashboard_URL, Expected_Dashboard_URL);
		
		softassert.assertAll();
		
	}
	

}
