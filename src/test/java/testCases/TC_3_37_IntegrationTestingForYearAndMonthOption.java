package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_3_37_IntegrationTestingForYearAndMonthOption extends BaseClass{
	//Creating an instance of the AddFluentWait utility
	AddFluentWait wait = new AddFluentWait();

	//Creating an instance of the Assertions utility
	Assertions myAssert = new Assertions();
	@Test
	public void validatingDataFlowBetweenYearAndMonthButton() {

		logger.info("**** TC_3_37_IntegrationTestingForYearAndMonthOption Started ****");
		try {
			//Creating an instance of the PageObject
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);

			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);

			//Navigating to the EMI Calculator Section
			obj1.navigatorForEMICalc();

			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			//Clicking on the year button
			obj1.clickYear();

			//Storing the value of year in a string 
			String yearVal = obj1.getLoanTenureTextBoxValue();

			//Converting the year value to the month value
			int yearValInInt = Integer.parseInt(yearVal);

			//Clicking on the month Button
			obj1.clickMonth();

			//Storing the value of month in a string 
			String monthVal = obj1.getLoanTenureTextBoxValue();

			//Asserting the values
			if(monthVal.equals(Integer.toString(yearValInInt*12))) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_37 got failed, The data flow b/w the year and month is not proper"
						+ " in the EMI Calculator Section.");
				System.out.println("TC_3_37 got failed, The data flow b/w the year and month is not "
						+ " proper in the EMI Calculator Section..");
				myAssert.fail();
			}

			//Navigating to the Loan Amount Calculator Section
			obj1.navigatorForLoanAmountCalc();;

			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);

			//Clicking on the year button
			obj1.clickYear();

			//Storing the value of year in a string 
			String yearVal2 = obj1.getLoanTenureTextBoxValue();

			//Converting the year value to the month value
			int yearValInInt2 = Integer.parseInt(yearVal2);

			//Clicking on the month Button
			obj1.clickMonth();

			//Storing the value of month in a string 
			String monthVal2 = obj1.getLoanTenureTextBoxValue();

			//Asserting the values
			if(monthVal.equals(Integer.toString(yearValInInt*12))) {
				myAssert.pass();
			}
			else {
				logger.error("TC_3_37 got failed, The data flow b/w the year and month is not proper"
						+ " in the Loan Amount Calculator Section.");
				System.out.println("TC_3_37 got failed, The data flow b/w the year and month is not "
						+ " proper in the Loan Amount Calculator Section..");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_3_37 got failed, Integration Testing for Year and Month Button "
					+ "was unsuccessful");

			logger.error("TC_3_37 got failed, Integration Testing for Year and Month Button was not successful");
			myAssert.fail();
		}

		logger.info("**** TC_3_37_IntegrationTestingForYearAndMonthOption Ended ****");
	}
}
