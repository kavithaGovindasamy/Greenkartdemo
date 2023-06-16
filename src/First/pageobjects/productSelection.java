package First.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productSelection {

	WebDriver driver;

	public productSelection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//List<WebElement> veg = driver.findElements(By.cssSelector("h4.product-name"));

	@FindBy(css="h4.product-name")
	List<WebElement>veg;



public addToCart additem(List vegetableslist) {

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
addToCart addcart=new addToCart(driver);
return addcart;
}

}


