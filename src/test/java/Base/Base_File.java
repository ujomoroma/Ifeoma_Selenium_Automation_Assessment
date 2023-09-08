package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_File {
	public static WebDriver driver;
	private static String browser = "chrome";
	private String URL = "https://alphapay.netlify.app/";
	
	// Launches the web browser based on the choice made
				@BeforeMethod
				public void launch_browser() {
					if (browser.equals("firefox")) {
						WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
						driver.get(URL);
						driver.manage().window().maximize();
					} else if (browser.equals("chrome")) {
						ChromeOptions option = new ChromeOptions();
						option.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
						WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver(option);
						driver.get(URL);
						driver.manage().window().maximize();
					} else if (browser.equals("edge")) {
						WebDriverManager.edgedriver().setup();
						driver = new EdgeDriver();
						driver.get(URL);
						driver.manage().window().maximize();
					}
				}

				// Closes browser after Test has ran
				@AfterMethod
				public void close_browser() {
					driver.quit();
				}



}
