package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLoanEMICalculatorPage extends BasePage{
	
	//Creating the JavaScriptExecutor instance
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	//Calling the parent class constructor to initialize the driver
	public HomeLoanEMICalculatorPage(WebDriver driver) {
		super(driver);
	}
	
	//Main Menu Element
	@FindBy(xpath = "//a[@id = 'menu-item-dropdown-2696']")
	WebElement mainMenuBtn;
	
	//Home Loan EMI Calculator
	@FindBy(xpath = "//a[@title = 'Home Loan EMI Calculator']")
	WebElement homeLoanEmiCalcBtn;
	
	@FindBy(xpath = "//table[@class = "
			+ "'noextras']/tbody/tr[@class = 'row no-margin yearlypaymentdetails']")
	List<WebElement> rows;
	
	//Columns
	@FindBy(xpath = "//table[@class = 'noextras']/tbody/tr/th")
	List<WebElement> cols;
	
	//Navigator for the page
	public void navigator() {
		mainMenuBtn.click();
		homeLoanEmiCalcBtn.click();
	}
	//Scrolling to the Year Table
	public void scrollToTable() {
		js.executeScript("arguments[0].scrollIntoView();", rows.get(0));
	}
	
	//Returning The Whole Year Table in array
	public String[][] getDatas() {
		String[][] datas = new String[rows.size()][cols.size()];
		for(int i = 0; i < rows.size(); i++) { //21, 0 - 20
			for(int j = 0; j < cols.size(); j++) { //7, 0 - 6
				datas[i][j] = driver.findElement(By.xpath("//table[@class = 'noextras']/tbody/tr[@class = 'row no-margin yearlypaymentdetails']["+(i+1)+"]/td["+(j+1)+"]")).getText();
			} 
		}
		return datas;
	}
}
