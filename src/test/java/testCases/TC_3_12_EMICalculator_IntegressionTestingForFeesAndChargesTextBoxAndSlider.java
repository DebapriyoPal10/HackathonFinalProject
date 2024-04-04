package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_12_EMICalculator_IntegressionTestingForFeesAndChargesTextBoxAndSlider extends BaseClass{
	//Creating an instance of the AddFluentWait utility
	AddFluentWait wait = new AddFluentWait();

	//Creating an instance of the Assertions utility
	Assertions myAssert = new Assertions();

	@Test
	public void validatingDataFlowBetweenFeesAndChargesSliderAndTextBox() {

		logger.info("**** TC_3_12_EMICalculator_IntegressionTestingForFeesAndChargesTextBoxAndSlider Started ****");
		try {
			//Creating an instance of the PageObject
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);

			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);

			//Navigating to the respective page
			obj1.navigatorForEMICalc();

			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			//Moving the Slider to Initial Position
			obj1.moveFeesAndChargesSlider(0);

			//Validating if the value passed to the text box is same as it is showing in the slider
			myAssert.assertIt(obj1.getFeesAndChargesTextBoxValue(), "10,000", "The initial value of"
					+ " the fees and charges textbox is not"
					+ " 10,000");

			//Moving the slider to Desired Position
			obj1.moveFeesAndChargesSlider(97);

			//Validating if the value passed to the text box is same as it is showing in the slider
			if(obj1.getFeesAndChargesTextBoxValue().equals("25,000")) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_12 got failed, Integration Testing for Fees And Charges Text Box "
						+ "and slider was not successful");
				System.out.println("TC_3_12 got failed, Integration Testing for Fees And Charges Text "
						+ "Box and Slider was unsuccessful");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_12 got failed, Integration Testing for Fees And Charges Text "
					+ "Box and Slider was unsuccessful");

			logger.error("TC_3_12 got failed, Integration Testing for Fees And Charges Text Box and Slider was not successful");
			myAssert.fail();
		}

		logger.info("**** TC_3_12_EMICalculator_IntegressionTestingForFeesAndChargesTextBoxAndSlider Ended ****");
	}
}
