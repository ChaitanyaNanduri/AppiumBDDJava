@CToFDemo
Feature: Acceptance testing to validate Celsius to Fahrenheit Convertor Mobile App is working.
  In order to validate that 
  the Celsius to Fahrenheit Convertor Mobile App is working
  Doing the Acceptance Testing

  @CToFDemo
  Scenario: Validate Celsius to Fahrenheit Convertor Mobile App
    Given Start the Appium server
    And Start the Emulator and open the app
    When To verify Celsius to Fahrenheit functionality enter Celsius Value to be converted
    And click on C2F Convertor button
    And Get the Fahrenheit text
    And To verify Fahrenheit to Celsius functionality enter Fahrenheit Value to be converted
    And click on F2C Convertor button
    And Get the Celsius text
    And click on Reset button
    And Stop the Appium Server
    Then Verify the Fahrenheit text and Celsius text with the expected text