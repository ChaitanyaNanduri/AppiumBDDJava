package steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CalculatorPageConstants;
import utils.Utilities;
import utils.base;

public class Calculator_DemoSteps extends base{
    
	// Declaring Variables
	public String addResult;
	public String subResult;
	public String multResult;
	public String divResult;
	
	// Calling Page locators Class
     CalculatorPageConstants calConst=new CalculatorPageConstants();
     
 	// Calling Utility methods.
     Utilities util=new Utilities(driver);
  
     @Given("Start the Appium server for Calculator App")
     public void start_the_appium_server_for_calculator_app() {
    	 service=startServer();
     }
   
     @And("Start the Emulator and open the app for Calculator App")
     public void start_the_emulator_and_open_the_app_for_calculator_app() throws IOException, InterruptedException {
    	 AndroidDriver<AndroidElement> driver=capabilities("calculator");
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }

     @When("To verify Addition functionality enter two values")
     public void to_verify_addition_functionality_enter_two_values() {
    	 util.clickByLocatorId(driver, calConst.Number_One);
    	 util.clickByLocatorId(driver, calConst.Number_Zero);
     }

     @When("click on plus button and get the Addition result")
     public void click_on_plus_button_and_get_the_addition_result() {
    	 util.clickByLocatorId(driver, calConst.PlusButton);
    	 util.clickByLocatorId(driver, calConst.Number_Five);
    	 util.clickByLocatorId(driver, calConst.EqualsToButton);
    	 addResult = util.getTextByLocatorId(driver, calConst.ResultText);
    	 util.clickByLocatorId(driver, calConst.ClearButton);    	 
     }

     @When("To verify Subtraction functionality enter two values")
     public void to_verify_subtraction_functionality_enter_two_values() {
    	 util.clickByLocatorId(driver, calConst.Number_One);
    	 util.clickByLocatorId(driver, calConst.Number_Zero);
     }

     @When("click on minus button and get the Subtraction result")
     public void click_on_minus_button_and_get_the_subtraction_result() {
    	 util.clickByLocatorId(driver, calConst.MinusButton);
    	 util.clickByLocatorId(driver, calConst.Number_Five);
    	 util.clickByLocatorId(driver, calConst.EqualsToButton);
    	 subResult = util.getTextByLocatorId(driver, calConst.ResultText);
    	 util.clickByLocatorId(driver, calConst.ClearButton);    
     }

     @When("To verify Multiplication functionality enter two values")
     public void to_verify_multiplication_functionality_enter_two_values() {
    	 util.clickByLocatorId(driver, calConst.Number_One);
    	 util.clickByLocatorId(driver, calConst.Number_Zero);
     }

     @When("click on star button and get the Multiplication result")
     public void click_on_star_button_and_get_the_multiplication_result() {
    	 util.clickByLocatorId(driver, calConst.StarButton);
    	 util.clickByLocatorId(driver, calConst.Number_Five);
    	 util.clickByLocatorId(driver, calConst.EqualsToButton);
    	 multResult = util.getTextByLocatorId(driver, calConst.ResultText);
    	 util.clickByLocatorId(driver, calConst.ClearButton);    
     }

     @When("To verify Division functionality enter two values")
     public void to_verify_division_functionality_enter_two_values() {
    	 util.clickByLocatorId(driver, calConst.Number_One);
    	 util.clickByLocatorId(driver, calConst.Number_Zero);
     }

     @When("click on divided by button and get the Division result")
     public void click_on_divided_by_button_and_get_the_division_result() {
    	 util.clickByLocatorId(driver, calConst.DivisionButton);
    	 util.clickByLocatorId(driver, calConst.Number_Five);
    	 util.clickByLocatorId(driver, calConst.EqualsToButton);
    	 divResult = util.getTextByLocatorId(driver, calConst.ResultText);
    	 util.clickByLocatorId(driver, calConst.ClearButton);    
     }

     @And("Stop the Appium Server for Calculator App")
     public void stop_the_appium_server_for_calculator_app() {
    	 service.stop();
     }
     
     @Then("Verify the result text of all four operations with the expected text")
     public void verify_the_result_text_of_all_four_operations_with_the_expected_text() {
    	if(addResult.equalsIgnoreCase("15") && subResult.equalsIgnoreCase("5") && multResult.equalsIgnoreCase("50") && divResult.equalsIgnoreCase("2")) {
    		 System.out.println("(10 + 5) is displayed as expected with value: 15");    		 
    		 System.out.println("(10 - 5) is displayed as expected with value: 5");
    		 System.out.println("(10 * 5) is displayed as expected with value: 50");    		 
    		 System.out.println("(10 / 5) is displayed as expected with value: 2");
    	 } else {
    		 System.out.println("Addition, Subtraction, Multiplication and Division operations are not working as expected.");
    	 }
     } 
     
	}
