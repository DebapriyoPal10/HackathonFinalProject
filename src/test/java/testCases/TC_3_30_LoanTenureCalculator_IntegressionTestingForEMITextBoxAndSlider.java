package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_30_LoanTenureCalculator_IntegressionTestingForEMITextBoxAndSlider extends BaseClass{
	//Creating an instance of the AddFluentWait utility
	AddFluentWait wait = new AddFluentWait();

	//Creating an instance of the Assertions utility
	Assertions myAssert = new Assertions();

	@Test
	public void validatingDataFlowBetweenEMISliderAndTextBox() {

		logger.info("**** TC_3_30_LoanTenureCalculator_IntegressionTestingForEMITextBoxAndSlider Started ****");
		try {
			//Creating an instance of the PageObject
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);

			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);

			//Navigating to the respective page
			obj1.navigatorForLoanTenureCalc();;

			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			//Moving the Slider to Initial Position
			obj1.moveEMISlider(0);

			//Validating if the value passed to the text box is same as it is showing in the slider
			myAssert.assertIt(obj1.getEMITextBoxValue(), "21,617.95", "The initial value of"
					+ " the emi textbox is not"
					+ " 21,617.95");

			//Moving the slider to Desired Position
			obj1.moveEMISlider(186);

			//Validating if the value passed to the text box is same as it is showing in the slider
			if(obj1.getEMITextBoxValue().equals("50,000.00")) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_30 got failed, Integration Testing for EMI Text Box and "
						+ "slider was not successful");
				System.out.println("TC_3_30 got failed, Integration Testing for EMI Text "
						+ "Box and Slider was unsuccessful");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_15 got failed, Integration Testing for EMI Text "
					+ "Box and Slider was unsuccessful");

			logger.error("TC_3_15 got failed, Integration Testing for EMI Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("**** TC_3_30_LoanTenureCalculator_IntegressionTestingForEMITextBoxAndSlider Ended ****");
	}
}
