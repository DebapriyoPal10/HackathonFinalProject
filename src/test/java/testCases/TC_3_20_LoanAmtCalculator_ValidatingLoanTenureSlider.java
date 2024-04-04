package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_20_LoanAmtCalculator_ValidatingLoanTenureSlider extends BaseClass{
	//Creating an instance of the AddFluentWait utility
	AddFluentWait wait = new AddFluentWait();

	//Creating an instance of the Assertions utility
	Assertions myAssert = new Assertions();
	@Test
	public void validateLoanTenureSlider() {

		logger.info("**** TC_3_20_LoanAmtCalculator_ValidatingLoanTenureSlider Started ****");
		try {
			//Creating an instance of the PageObject
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);

			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);

			//Navigating to the respective page
			obj1.navigatorForLoanAmountCalc();

			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			//Validating if Loan Tenure Slider is visible
			if(obj1.getLoanTenureSlider().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_20 got failed, Loan Tenure Slider is not visible.");
				System.out.println("TC_3_20 got failed, Loan Tenure Slider is not visible.");
				myAssert.fail();
			}

			//Validating if Loan Tenure Slider is enabled
			if(obj1.getLoanTenureSlider().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_20 got failed, Loan Tenure Slider is not enabled.");
				System.out.println("TC_3_20 got failed, Loan Tenure Slider is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_20 got failed, validation of Loan Tenure Slider was "
					+ "unsuccessful");

			logger.error("TC_3_20 got failed, validation of Loan Tenure Slider was not successful");
			myAssert.fail();
		}

		logger.info("**** TC_3_20_LoanAmtCalculator_ValidatingLoanTenureSlider Ended ****");
	}
}
