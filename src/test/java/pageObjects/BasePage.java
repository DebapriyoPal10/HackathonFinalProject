package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	//Creating the WebDriver instance
	public WebDriver driver;
	
	//The Constructor that will initialize the web elements using PageFactory methods
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
