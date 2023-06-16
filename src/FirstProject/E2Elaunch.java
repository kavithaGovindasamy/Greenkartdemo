package FirstProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2Elaunch {
	WebDriver driver;
    
	@BeforeMethod
	public WebDriver launchdriver() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();			
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
			driver.manage().window().maximize();
			return driver;
			
		}
		
	@AfterMethod
		public void closebrowser() {
			driver.quit();
		}
		
	

}
