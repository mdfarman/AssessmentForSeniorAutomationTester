package com.sourcefuse.AssessmentForSeniorAutomationTester;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utils extends BaseTest{
	public synchronized static void scrollToElement(String locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(locator));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println("unable to scroll to element");
		}
	}
	
	public synchronized static void click(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("unable to click on element");
			e.printStackTrace();
		}
	}

	public static String findElementGetByAttributeValue(String locatorXpath) {
		WebElement element = driver.findElement(By.xpath(locatorXpath));
		String validationMessage = element.getAttribute("validationMessage");
		return validationMessage;
	}

	public static void ValidateText(String FieldName, String UiValue, String ExpectedUiValue) {
		
		if(UiValue.equals(ExpectedUiValue)) {
			System.out.println("Field: "+FieldName+" ->"+" Error: "+UiValue);
		}
		else {
			assertTrue(false);
		}
		
	}

	public static void enterValue(String LocatorXpath, String value) {
		
		 driver.findElement(By.xpath(LocatorXpath)).clear();
		 driver.findElement(By.xpath(LocatorXpath)).sendKeys(value);
	}

	public static String determineFieldType(WebElement field) {
		String fieldType;

		if (field.getAttribute("multiple") != null || field.getAttribute("options") != null) {
			fieldType = "Dropdown";
		} else if ("radio".equalsIgnoreCase(field.getAttribute("type"))) {
			fieldType = "Radio Button";
		} else if ("text".equalsIgnoreCase(field.getAttribute("type"))
				|| "password".equalsIgnoreCase(field.getAttribute("type"))
				|| "email".equalsIgnoreCase(field.getAttribute("type"))
				|| "number".equalsIgnoreCase(field.getAttribute("type"))) {
			fieldType = "Textbox";
		} else {
			fieldType = "Unknown Field Type";
		}

		return fieldType;
	}
}
	
