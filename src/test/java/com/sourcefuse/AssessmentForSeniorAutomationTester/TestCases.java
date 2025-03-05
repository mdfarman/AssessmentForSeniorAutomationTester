package com.sourcefuse.AssessmentForSeniorAutomationTester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases extends BaseTest {
	@Test(description = "Implement retry logic")
	public void TestCase1() {
		int attempts = 0;
		boolean loginSuccess = false;

		while (attempts < 3 && !loginSuccess) {
			try {
				Thread.sleep(2000);
				Alert alert = driver.switchTo().alert();
				alert.sendKeys(USERNAME + "\t" + PASSWORD);
				alert.accept();
				if (driver.getTitle().contains("Expected Title After Login")) {
					loginSuccess = true;
				}
			} catch (NoAlertPresentException | TimeoutException | InterruptedException e) {
				System.out.println("Login attempt failed, retrying...");
			}
			attempts++;
		}

		if (!loginSuccess) {
			System.out.println("Login failed after 3 attempts.");
		}

	}

	@Test(description = "Implement retry logic")
	public void TestCase2() {
		String url = "https://" + USERNAME + ":" + PASSWORD + "@dsnm875e4wmhw.cloudfront.net/ ";
		driver.get(url);
		Utils.scrollToElement("//*[@id='submit']");

		// validating "First Name" required massage popup box
		Utils.click("//*[@id='submit']");
		Utils.scrollToElement("//*[@id='fnameInput']/input");
		String firstNameField = Utils.findElementGetByAttributeValue("//*[@id='fnameInput']/input");
		Utils.ValidateText("First Name", firstNameField, "Please fill out this field.");
		Utils.enterValue("//*[@id='fnameInput']/input", "Md");

		// validating "Last Name" required massage popup box
		Utils.scrollToElement("//*[@id='submit']");
		Utils.click("//*[@id='submit']");
		Utils.scrollToElement("//*[@id='fnameInput']/input");
		String lastNameField = Utils.findElementGetByAttributeValue("//*[@id='lnameInput']/input");
		Utils.ValidateText("Last Name", lastNameField, "Please fill out this field.");
		Utils.enterValue("//*[@id='lnameInput']/input", "Farman");

		// validating "Email" required massage popup box
		Utils.scrollToElement("//*[@id='submit']");
		Utils.click("//*[@id='submit']");
		Utils.scrollToElement("//*[@id='emailInput']/input");
		String emailField = Utils.findElementGetByAttributeValue("//*[@id='emailInput']/input");
		Utils.ValidateText("Email", emailField, "Please fill out this field.");
		Utils.enterValue("//*[@id='emailInput']/input", "farman@test.com");

		// validating "Current Company" required massage popup box
		Utils.scrollToElement("//*[@id='submit']");
		Utils.click("//*[@id='submit']");
		Utils.scrollToElement("//*[@id='curCompanyInput']/input");
		String CurrentCompany = Utils.findElementGetByAttributeValue("//*[@id='curCompanyInput']/input");
		Utils.ValidateText("Current Company", CurrentCompany, "Please fill out this field.");
		Utils.enterValue("//*[@id='curCompanyInput']/input", "SourceFuse");

		// validating "Mobile No" required massage popup box
		Utils.scrollToElement("//*[@id='submit']");
		Utils.click("//*[@id='submit']");
		Utils.scrollToElement("//*[@id='mobInput']/input");
		String MobileNo = Utils.findElementGetByAttributeValue("//*[@id='mobInput']/input");
		Utils.ValidateText("Mobile No", MobileNo, "Please fill out this field.");
		Utils.enterValue("//*[@id='mobInput']/input", "9812345678");

		// validating "Date Of Birth" required massage popup box
		Utils.scrollToElement("//*[@id='submit']");
		Utils.click("//*[@id='submit']");
		Utils.scrollToElement("//*[@id='DOBInput']/div/input");
		String DateOfBirth = Utils.findElementGetByAttributeValue("//*[@id='DOBInput']/div/input");
		Utils.ValidateText("Date Of Birth", DateOfBirth, "Please fill out this field.");
		Utils.enterValue("//*[@id='DOBInput']/div/input", "05/11/1990");
		Actions actions = new Actions(driver);
		actions.sendKeys(org.openqa.selenium.Keys.TAB).perform();

		// validating "Position you are applying for" required massage popup box
		Utils.scrollToElement("//*[@id='submit']");
		Utils.click("//*[@id='submit']");
		Utils.scrollToElement("//*[@id='positionInput']/input");
		String position = Utils.findElementGetByAttributeValue("//*[@id='positionInput']/input");
		Utils.ValidateText("Position you are applying for", position, "Please fill out this field.");
		Utils.enterValue("//*[@id='positionInput']/input", "Automation Tester");

		// validating "Portfolio Website" required massage popup box
		Utils.scrollToElement("//*[@id='submit']");
		Utils.click("//*[@id='submit']");
		Utils.scrollToElement("//*[@id='portfolioInput']/input");
		String portfolioInput = Utils.findElementGetByAttributeValue("//*[@id='portfolioInput']/input");
		Utils.ValidateText("Portfolio Website", portfolioInput, "Please enter a URL.");
		Utils.enterValue("//*[@id='portfolioInput']/input", "https://www.google.com/");

		// validating "Salary requirements" required massage popup box
		Utils.scrollToElement("//*[@id='submit']");
		Utils.click("//*[@id='submit']");
		Utils.scrollToElement("//*[@id='salaryInput']/input");
		String SalaryRequirements = Utils.findElementGetByAttributeValue("//*[@id='salaryInput']/input");
		Utils.ValidateText("Salary requirements", SalaryRequirements, "Please fill out this field.");
		Utils.enterValue("//*[@id='salaryInput']/input", "123456");

		// validating "Designation" required massage popup box
		Utils.scrollToElement("//*[@id='submit']");
		Utils.click("//*[@id='submit']");
		Utils.scrollToElement("//*[@id='designationDropdown']");
		String Designation = Utils.findElementGetByAttributeValue("//*[@id='designationDropdown']");
		Utils.ValidateText("Salary requirements", Designation, "Please select an item in the list.");
	}

	@Test(description = "Verify presence of all input fields using Soft assertions ")
	public void TestCase3() {
		String url = "https://" + USERNAME + ":" + PASSWORD + "@dsnm875e4wmhw.cloudfront.net/ ";
		driver.get(url);
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> inputFields = driver.findElements(By.xpath("//input"));
		for (WebElement inputField : inputFields) {
			boolean isDisplayed = inputField.isDisplayed();
			softAssert.assertTrue(isDisplayed, "Input field is not displayed: " + inputField.getAttribute("name"));
		}
	}

	@Test(dependsOnMethods = "TestCase2", description = "Submit the form after filling all the required details")
	public void TestCase4() {

		// select the designation dropdown option using Visible text
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='designationDropdown']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Quality Analyst");

		// upload file
		String projectPath = System.getProperty("user.dir");
		String relativePath = "\\src\\main\\resource\\Selenium Automation Interview Test.pdf";
		String filepath = projectPath + relativePath;
		WebElement fileInput = driver.findElement(By.xpath("//*[@id='resume']"));
		fileInput.sendKeys(filepath);

		// select radio button as yes
		WebElement yesRadioButton = driver.findElement(By.id("yes"));
		yesRadioButton.click();

		// click on submit button
		Utils.scrollToElement("//*[@id='submit']");
		Utils.click("//*[@id='submit']");
	}

	@Test(description = "Write a Java method that can detect whether a form field is a text box, radio button, or dropdown without using getTagName().")
	public void TestCase5() {
		String url = "https://" + USERNAME + ":" + PASSWORD + "@dsnm875e4wmhw.cloudfront.net/ ";
		driver.get(url);

		List<WebElement> formFields = driver.findElements(By.cssSelector("input, select, textarea"));
		for (WebElement field : formFields) {
			String fieldName = field.getAttribute("name"); // Get the 'name' or other unique attribute
			String fieldType = Utils.determineFieldType(field); // Determine the type of the field

			// Print the output
			System.out.println("Field: " + fieldName + " -> Type: " + fieldType);
		}
	}

	// @Test(description = " After submitting the form, Verify successful entry is
	// created in DB ")
	public void TestCase6() {
		// Database not available, so the code below will not work.
		// This is like a dry run.

		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		String email = "farman@test.com";
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT * FROM User WHERE Email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("Entry found in the database for email: " + email);
			} else {
				System.out.println("No entry found in the database for email: " + email);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test(description = " Verify Email is triggered after submitting the form using assertion on DB considering an email trigger column as email_sent. ")
	public void TestCase7() {
		// not possible to dry run the code
	}

}
