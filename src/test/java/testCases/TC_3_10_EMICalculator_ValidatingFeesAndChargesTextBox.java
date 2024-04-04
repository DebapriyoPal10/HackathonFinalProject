package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_10_EMICalculator_ValidatingFeesAndChargesTextBox extends BaseClass{
	//Creating an instance of the AddFluentWait utility
	AddFluentWait wait = new AddFluentWait();

	//Creating an instance of the Assertions utility
	Assertions myAssert = new Assertions();
	
	@Test
	public void validateFeesAndChargesTextBox() {

		logger.info("**** TC_3_10_EMICalculator_ValidatingFeesAndChargesTextBox Started ****");
		try {
			//Creating an instance of the PageObject
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);

			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);

			//Navigating to the respective page
			obj1.navigatorForEMICalc();

			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			//Validating if Fees And Charges Text Box is visible
			if(obj1.getFeesAndChargesTextBox().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_10 got failed, Fees And Charges Text Box is not visible.");
				System.out.println("TC_3_10 got failed, Fees And Charges Text Box is not visible.");
				myAssert.fail();
			}

			//Validating if Fees And Charges Text Box is enabled
			if(obj1.getFeesAndChargesTextBox().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_10 got failed, Fees And Charges Text Box is not enabled.");
				System.out.println("TC_3_10 got failed, Fees And Charges Text Box is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_10 got failed, validation of Fees And Charges Text Box was "
					+ "unsuccessful");

			logger.error("TC_3_10 got failed, validation of Fees And Charges Text Box was not successful");
			myAssert.fail();
		}

		logger.info("**** TC_3_10_EMICalculator_ValidatingFeesAndChargesTextBox Ended ****");
	}	
}
