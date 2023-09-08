package Logout_page;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import Change_Password_Page.Change_Password_PageObject;

public class Logout_PageObject extends Change_Password_PageObject {
	
	//Locators
	private String logout_btn= "//a[normalize-space()='Log Out']";
	private String logout_text= "//p[@class='head_info']";	
	
	//Config
	private String Expected_logout_text= "Welcome back, Please log in to your account to access your dashboard";
	
	//Actions
	public void click_on_logout_button() {
		driver.findElement(By.xpath(logout_btn)).click();
	}
	
	private String get_logoutText() {
		String logoutText= driver.findElement(By.xpath(logout_text)).getText();
		return logoutText;
	}
	
	public void confirm_Logout() {
		SoftAssert softassert= new SoftAssert();
		
		String Actual_logout_text= get_logoutText();
		
		softassert.assertEquals(Actual_logout_text, Expected_logout_text);
		softassert.assertAll();
		
	}
}
