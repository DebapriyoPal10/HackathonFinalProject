package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.InterestAmountForCurrentYearPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_1_02_DisplayingTheEMIPaymentTable extends BaseClass{
	//Creating an instance of the AddFluentWait utility
	AddFluentWait wait = new AddFluentWait();
		
	//Creating an instance of the Assertions utility
	Assertions myAssert = new Assertions();
	@Test
	public void displayResult() {
		
		logger.info("**** TC_1_02_DisplayingTheEMIPaymentTable Started ****");
		try {
			//Creating the instance of the Page Object
			InterestAmountForCurrentYearPage obj1 = new InterestAmountForCurrentYearPage(driver);
			
			//Scroll to Table
			obj1.scrollToTable();

			//Click on the Years
			obj1.clickOnYears();
			
			//Displaying the datas
			obj1.printTheEMIPaymentTable();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_1_02 got failed, displaying the datas wasn't successful");
			
			logger.error("TC_1_02 got failed, displaying the datas wasn't successful");
			myAssert.fail();
		}
		
		logger.info("**** TC_1_02_DisplayingTheEMIPaymentTable Ended ****");
	}
}
