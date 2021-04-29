@CalculatorDemo 
Feature:  Acceptance testing to validate Calculator Mobile App is working. 
	In order to validate that Calculator Mobile App is working
  	Doing the Acceptance Testing

@CalculatorDemo 
Scenario: 
	Validate Addition, Subtraction, Multiplication and Division features in Calculator Native Mobile App 
	Given Start the Appium server for Calculator App 
	And Start the Emulator and open the app for Calculator App 
	When To verify Addition functionality enter two values 
	And click on plus button and get the Addition result 
	And To verify Subtraction functionality enter two values 
	And click on minus button and get the Subtraction result 
	And To verify Multiplication functionality enter two values 
	And click on star button and get the Multiplication result 
	And To verify Division functionality enter two values 
	And click on divided by button and get the Division result 
	And Stop the Appium Server for Calculator App 
	Then Verify the result text of all four operations with the expected text