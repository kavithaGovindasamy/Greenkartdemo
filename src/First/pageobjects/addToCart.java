package First.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addToCart {

	WebDriver driver;

	public addToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".cart-icon")
	WebElement cart;
	
	@FindBy(css="div[class='cart-preview active'] button[type='button']")
	WebElement proceed;
	
	public void checkout() {
		cart.click();
		proceed.click();
		
	}
	
}
