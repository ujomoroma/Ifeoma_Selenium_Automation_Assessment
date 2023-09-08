package Signup_Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import Base.Base_File;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUp_PageObject extends Base_File{
	Faker random = new Faker();

	// Locators
	private String signup_button = "(//a[normalize-space()='Sign Up'])[1]";
	private String fullName_textbox = "//input[@name='full_name']";
	private String userName_textbox = "//input[@placeholder='Your Username']";
	private String phoneNumber_textbox= "//input[@placeholder='Your Phone Number']";
	private String email_textbox= "//input[@placeholder='Your Email']";
	private String password_textbox= "//input[@placeholder='Your Password']";
	private String confirmPassword_textbox= "//input[@placeholder='Confirm Password']";
	private String createAccount_button= "//button[@class='button btn_colored']";
	private String signup_welcomeMsg= "//div[contains(text(),'Welcome to your dashboard')]";
	private String signup_SuccessfulMsg="//div[contains(text(),'Signup Successful')]";
	
	
	// Config_Files
	private String Expected_Dashboard_URL="https://alphapay.netlify.app/dashboard/overview";
	public String Password= "Password@12";
	private String Expected_Welcome_Message= "Welcome to your dashboard";
	private String Expected_Signup_Message= "Signup Successful";
	
	
	//Generate Random Data
	private String Firstname= random.name().firstName();
	private String Lastname= random.name().lastName();
	public String Fullname= Firstname+" "+Lastname;
	public String Username= Firstname+"."+Lastname;
	public String Email= Firstname+Lastname+"@gmail.com";
	int randomNumber = random.random().nextInt(123456, 234568); // 234568 is exclusive
	public String Phone_Number= "08033"+randomNumber;
	
	
	
	//Actions	
	public void click_On_SignUp_Btn() {
		driver.findElement(By.xpath(signup_button)).click();
	}
	
	public void enter_Full_Name(String Fullname) {
		driver.findElement(By.xpath(fullName_textbox)).sendKeys(Fullname);
	}
	
	public void enter_Username(String Username) {
		driver.findElement(By.xpath(userName_textbox)).sendKeys(Username);
	}
	
	public void enter_PhoneNumber(String PhoneNumber) {
		driver.findElement(By.xpath(phoneNumber_textbox)).sendKeys(PhoneNumber);
	}
	
	public void enter_Email(String Email) {
		driver.findElement(By.xpath(email_textbox)).sendKeys(Email);
	}
	
	public void enter_Password(String Password) {
		driver.findElement(By.xpath(password_textbox)).sendKeys(Password);
	}
	
	public void confirm_Password(String Password) {
		driver.findElement(By.xpath(confirmPassword_textbox)).sendKeys(Password);
	}
	
	public void click_OnCreate_Account() {
		driver.findElement(By.xpath(createAccount_button)).click();
	}
	
	public String Get_Signup_Welcome_Msg() {
		String WelcomeMsg= driver.findElement(By.xpath(signup_welcomeMsg)).getText();
		return WelcomeMsg;
	}
	
	public String Get_Signup_Msg() {
		String SignupMsg= driver.findElement(By.xpath(signup_SuccessfulMsg)).getText();
		return SignupMsg;
	}
	
	public void confirm_Successful_Signup() {
		//Instantiating the soft assertion
		SoftAssert softassert= new SoftAssert();
		//Instantiating the Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(56));
		
		//Gets the signup message
		String Actual_Signup_message= Get_Signup_Msg();
		
		//Gets the URL of the overview dashboard
		String Actual_Dashboard_URL= driver.getCurrentUrl();
		
		//Asserts that the displayed SignUp Message is correct
		softassert.assertEquals(Actual_Signup_message, Expected_Signup_Message);
		
		//Saves the element of in a webelement
		WebElement Signup_Msg= driver.findElement(By.xpath(signup_welcomeMsg));
		
		//Waits until that element is displayed
		wait.until(ExpectedConditions.visibilityOf(Signup_Msg));
		
		//Gets the welcome message
		String Actual_Welcome_message= Get_Signup_Welcome_Msg();
		
		//Asserts that the displayed welcome Message is correct
		softassert.assertEquals(Actual_Welcome_message, Expected_Welcome_Message);
		
		//Asserts that the URL is correct
		softassert.assertEquals(Actual_Dashboard_URL, Expected_Dashboard_URL);
		
		softassert.assertAll();
		
	}
	
}
