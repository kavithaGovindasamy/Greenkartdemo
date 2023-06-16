package First.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class thankyou {
	
	WebDriver driver;
	
	public thankyou(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".wrapperTwo")
	WebElement message;	
	
	public String checkmsg() {
	String msg = message.getText();
	return msg;
	
}
}
