package steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CToFPageConstants;
import utils.Utilities;
import utils.base;

public class CToF_DemoSteps extends base{
    
	// Declaring Variables
	public String fahrenheitText;
	public String celsiusText;
	
	// Calling Page locators Class
     CToFPageConstants c2f=new CToFPageConstants();
     
 	// Calling Utility methods.
     Utilities util=new Utilities(driver);
  
     @Given("Start the Appium server")
     public void start_the_appium_server() {
    	 service=startServer();
     }
   
     @And("Start the Emulator and open the app")
     public void start_the_emulator_and_open_the_app() throws IOException, InterruptedException {
    	 AndroidDriver<AndroidElement> driver=capabilities("celsiusToFarenheit");
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }

     @When("To verify Celsius to Fahrenheit functionality enter Celsius Value to be converted")
     public void to_verify_celsius_to_fahrenheit_functionality_enter_celsius_value_to_be_converted() {
    	// Clear Celsius Text, Enter a  value and Convert to Fahrenheit.
    	 util.clearByLocatorId(driver, c2f.CelsiusText);
    	 util.sendKeysByLocatorId(driver, c2f.CelsiusText,"25");
     }

     @And("click on C2F Convertor button")
     public void click_on_c2f_convertor_button() {
    	 util.clickByLocatorId(driver, c2f.ConvertCToFButton);
     }

     @And("Get the Fahrenheit text")
     public void get_the_fahrenheit_text() {
    	 fahrenheitText = util.getTextByLocatorId(driver, c2f.FahrenheitText);
     }

     @And("To verify Fahrenheit to Celsius functionality enter Fahrenheit Value to be converted")
     public void to_verify_fahrenheit_to_celsius_functionality_enter_fahrenheit_value_to_be_converted() {
    	// Clear Fahrenheit Text, Enter a  value and Convert to Celsius.
    	 util.clickByLocatorId(driver, c2f.ResetButton);
    	 util.clearByLocatorId(driver, c2f.FahrenheitText);
    	 util.sendKeysByLocatorId(driver, c2f.FahrenheitText,"77");
     }

     @And("click on F2C Convertor button")
     public void click_on_f2c_convertor_button() {
    	 util.clickByLocatorId(driver, c2f.ConvertFToCButton);
     }

     @And("Get the Celsius text")
     public void get_the_celsius_text() {
    	 celsiusText = util.getTextByLocatorId(driver, c2f.CelsiusText);
     }

     @And("click on Reset button")
     public void click_on_reset_button() {
    	 util.clickByLocatorId(driver, c2f.ResetButton);
     }

     @And("Stop the Appium Server")
     public void stop_the_appium_server() {
    	 service.stop();
     }
     
     @Then("Verify the Fahrenheit text and Celsius text with the expected text")
     public void verify_the_fahrenheit_text_and_celsius_text_with_the_expected_text() {
    	if(fahrenheitText.equalsIgnoreCase("77.0") && celsiusText.equalsIgnoreCase("25.0")) {
    		 System.out.println("Celsius value: 25 converted to Fahrenheit is displayed as expected with value: 77.0");
    		 System.out.println("Fahrenheit value: 77 converted to Celsius is displayed as expected with value: 25.0");
    	 } else {
    		 System.out.println("Neither Celsius to Fahrenheit nor Fahrenheit to Celsius Conversion is not workinng as expected.");
    	 }
     } 
     
	}
