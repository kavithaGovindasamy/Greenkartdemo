package First.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class countrypage {
	
	WebDriver driver;
	
	public countrypage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="select[style='width: 200px;']")
	WebElement countrybox;
	
	@FindBy(css=".chkAgree")
	WebElement agree;
	
	@FindBy(xpath=".//button[text()='Proceed' ]")
	WebElement proceed;

	//WebElement countrybox = driver.findElement(By.cssSelector("select[style='width: 200px;']"));
	
	public void selectcountry(String Country) {
	Select country = new Select(countrybox);
	country.selectByVisibleText(Country);
    agree.click();
	if (agree.isEnabled())

	{
		proceed.click();
	}

	else {
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='errorAlert']")).isDisplayed());
	}

     }
}
	


	
	

	

