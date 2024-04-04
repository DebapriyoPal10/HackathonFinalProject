package testCases;

import org.testng.annotations.Test;

import pageObjects.InterestAmountForCurrentYearPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TC_1_01_ParsingRequiredValuesToTheRespectiveFields extends BaseClass{
	
	//Creating an instance of the AddFluentWait utility
	AddFluentWait wait = new AddFluentWait();
	
	//Creating an instance of the Assertions utility
	Assertions myAssert = new Assertions();
	
	@Test
	public void parseDatas() {
		
		logger.info("**** TC_1_01_ParsingRequiredValuesToTheRespectiveFields Started ****");
		try {
			//Creating the instance of the Page Object
			InterestAmountForCurrentYearPage obj1 = new InterestAmountForCurrentYearPage(driver);
			
			//Waiting for the main menu element
			wait.waitForMainMenu(driver);
			
			//Navigating to the page - 
			obj1.navigator();
			
			//Waiting for the car loan element to load
			wait.waitForTheCarLoan(driver);
			
			//Clicking on the car loan 
			obj1.clickCarLoan();
			
			//Parsing the required values - 
			obj1.setLoanAmt(p.getProperty("loanAmount"));
			obj1.setInterest(p.getProperty("interest"));
			obj1.moveLoanTenureSlider(-375);
			obj1.clickOnYear();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TC_1_01 got failed, data parsing wasn't successful");
			logger.error("TC_1_01 got failed, data parsing wasn't successful");
			myAssert.fail();
		}
		logger.info("**** TC_1_01_ParsingRequiredValuesToTheRespectiveFields Ended ****");
	}
}
