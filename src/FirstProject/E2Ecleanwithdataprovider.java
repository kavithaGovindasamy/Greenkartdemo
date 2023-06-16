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

import First.pageobjects.addToCart;
import First.pageobjects.countrypage;
import First.pageobjects.finalCart;
import First.pageobjects.productSelection;
import First.pageobjects.thankyou;
import abstractcomp.reusable;

import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2Ecleanwithdataprovider extends E2Elaunch {
    @Test (dataProvider="getdata")
	public  void Greenkart( String[] vegetables) {
		// TODO Auto-generated method stub

		String Country= "Congo";
		String exmsg= "Thank you, your order has been placed successfully\nYou'll be redirected to Home page shortly!!"; 
		//String[] vegetables = { "Beetroot", "Beans", "Potato" };
		List vegetableslist = Arrays.asList(vegetables);
		
		//WebDriver driver = launchdriver(); Before method
		productSelection ps=new productSelection(driver);
		addToCart addcart= ps.additem(vegetableslist);
		
		//addToCart addcart=new addToCart(driver);
		addcart.checkout();
		//reusable reuse=new reusable(driver);
		//reuse.waitforstaleness();		
		finalCart finalcartpage=new finalCart(driver);
		finalcartpage.waitforstaleness();
		List<String> productNames=finalcartpage.getProductNames();	
		System.out.println(productNames);		
		
		finalcartpage.submitplaceOrder();
		countrypage cp=new countrypage(driver);
		cp.selectcountry(Country);	
		thankyou thank=new thankyou(driver);
	    String ordermsg=thank.checkmsg();
	
		System.out.println(ordermsg);		
		Assert.assertEquals(ordermsg,exmsg);
		//closebrowser(); after method		
		
	}
	
    @DataProvider
    public String[][] getdata() {
    	String[][] vegetables = {{ "Beetroot", "Beans", "Potato" }, {"Brocolli","Apple"}};
    	return vegetables;
    	
    }
}
