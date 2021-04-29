package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	AndroidDriver<AndroidElement> driver;

	public Utilities(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void scrollToText(AndroidDriver<AndroidElement> driver, String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}

	public void clearByLocatorId(AndroidDriver<AndroidElement> driver, String elementLocatorID) {
		driver.findElementById(elementLocatorID).clear();
	}
	
	public void clickByLocatorId(AndroidDriver<AndroidElement> driver, String elementLocatorID) {
		driver.findElementById(elementLocatorID).click();
	}
	
	public void sendKeysByLocatorId(AndroidDriver<AndroidElement> driver, String elementLocatorID, String textToEnter) {
		driver.findElementById(elementLocatorID).sendKeys(textToEnter);
	}
	
	public String getTextByLocatorId(AndroidDriver<AndroidElement> driver, String elementLocatorID) {
		return driver.findElementById(elementLocatorID).getText();
	}
}
