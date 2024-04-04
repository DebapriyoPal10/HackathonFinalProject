package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider extends BaseClass{
	//Creating an instance of the AddFluentWait utility
	AddFluentWait wait = new AddFluentWait();

	//Creating an instance of the Assertions utility
	Assertions myAssert = new Assertions();
	
	@Test
	public void validateFeesAndChargesSlider() {

		logger.info("**** TC_3_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider Started ****");
		try {
			//Creating an instance of the PageObject
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);

			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);

			//Navigating to the respective page
			obj1.navigatorForLoanTenureCalc();

			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			//Validating if Fees And Charges Slider is visible
			if(obj1.getFeesAndChargesSlider().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_35 got failed, Fees And Charges Slider is not visible.");
				System.out.println("TC_3_35 got failed, Fees And Charges Slider is not visible.");
				myAssert.fail();
			}

			//Validating if Fees And Charges Slider is enabled
			if(obj1.getFeesAndChargesSlider().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_35 got failed, Fees And Charges Slider is not enabled.");
				System.out.println("TC_3_35 got failed, Fees And Charges Slider is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_35 got failed, validation of Fees And Charges Slider was "
					+ "unsuccessful");

			logger.error("TC_3_35 got failed, validation of Fees And Charges Slider was not successful");
			myAssert.fail();
		}

		logger.info("**** TC_3_35_LoanTenureCalculator_ValidatingFeesAndChargesSlider Ended ****");
	}
}
