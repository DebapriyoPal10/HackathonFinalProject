package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_04_EMICalculator_ValidatingInterestRateTextBox extends BaseClass{
	//Creating an instance of the AddFluentWait utility
	AddFluentWait wait = new AddFluentWait();

	//Creating an instance of the Assertions utility
	Assertions myAssert = new Assertions();
		
	@Test
	public void validateInterestRateTextBox() {
		
		logger.info("**** TC_3_04_EMICalculator_ValidatingInterestRateTextBox Started ****");
		try {
			//Creating an instance of the PageObject
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			obj1.navigatorForEMICalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if Interest Rate Text Box is visible
			if(obj1.getIntRateTextBox().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_04 got failed, Interest Rate Text Box is not visible.");
				System.out.println("TC_3_04 got failed, Interest Rate Text Box is not visible.");
				myAssert.fail();
			}
			
			//Validating if Interest Rate Text Box is enabled
			if(obj1.getIntRateTextBox().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_04 got failed, Interest Rate Text Box is not enabled.");
				System.out.println("TC_3_04 got failed, Interest Rate Text Box is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_04 got failed, validation of Interest Rate Text Box was "
							   + "unsuccessful");
			
			logger.error("TC_3_04 got failed, validation of Interest Rate Text Box was not successful");
			myAssert.fail();
		}
		
		logger.info("**** TC_3_04_EMICalculator_ValidatingInterestRateTextBox Ended ****");
	}
}
