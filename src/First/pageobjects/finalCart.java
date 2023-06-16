package First.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractcomp.reusable;

public class finalCart extends reusable  {
	WebDriver driver;

	public finalCart(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		

 @FindBy(css=".product-name")
static  List<WebElement>product;
 
 @FindBy(xpath="//button[text()='Place Order']")
 WebElement placeOrderButton;
 

 public void waittoload() {
	 waitforstaleness();
}

//List<WebElement> product = driver.findElements(By.cssSelector(".product-name")); 
public List<String> getProductNames() {
	List<String> productNames = new ArrayList<>();
	for (WebElement products : product) {
		String fullName = products.getText();
		String[] item = fullName.split("-");
		String name = item[0].trim();
		productNames.add(name);
	}
	return productNames;

}

public void submitplaceOrder() {
	placeOrderButton.click();
}
}



