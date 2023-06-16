package FirstProject;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E {

	 //static int i;
	static String Country= "Congo";
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String[] vegetables = { "Beetroot", "Beans", "Potato" };
		List vegetableslist = Arrays.asList(vegetables);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		List<WebElement> veg = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < veg.size(); i++) {

			String fullveg = veg.get(i).getText();
			String[] item = fullveg.split("-");
			String name = item[0].trim();
			int j = 0;
			if (vegetableslist.contains(name)) {
				j++;
				driver.findElements(By.cssSelector(".product-action button[type='button']")).get(i).click();
				if (j == 3)
					break;
			}

		}

		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
	
		
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".products"))));
		List<WebElement> product = driver.findElements(By.cssSelector(".product-name"));
		
		List<String> productNames = getProductNames(product);
		System.out.println(productNames);
		Assert.assertEquals(productNames, vegetableslist,
				"The product names do not match the expected vegetables list.");
		driver.findElement(By.xpath("//button[text()='Place Order' ]")).click();
		WebElement countrybox = driver.findElement(By.cssSelector("select[style='width: 200px;']"));
		Select country = new Select(countrybox);
		country.selectByVisibleText(Country);
		driver.findElement(By.cssSelector(".chkAgree")).click();
		if (driver.findElement(By.cssSelector(".chkAgree")).isEnabled())

		{
			driver.findElement(By.xpath("//button[text()='Proceed' ]")).click();
		}

		else {

			driver.findElement(By.xpath("//button[text()='Proceed' ]")).click();
			// span[@class='errorAlert']
			Assert.assertTrue(driver.findElement(By.xpath("//span[@class='errorAlert']")).isDisplayed());
		}
		
		String msg = (driver.findElement(By.cssSelector(".wrapperTwo")).getText());
		System.out.println(msg);	
		String exmsg= "Thank you, your order has been placed successfully\nYou'll be redirected to Home page shortly!!";  
		
		Assert.assertEquals(msg,exmsg);
		
	}

	private static List<String> getProductNames(List<WebElement> product) {
		List<String> productNames = new ArrayList<>();
		for (WebElement products : product) {
			String fullName = products.getText();
			String[] item = fullName.split("-");
			String name = item[0].trim();
			productNames.add(name);
		}
		return productNames;

	}

}
