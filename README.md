--------------------------
	Project Hierarchy
--------------------------

AssessmentForSeniorAutomationTester/
|
|--- pom.xml
|--- src/
|   |--- main/
|   |   |--- java/
|   |   |   |-- com/
|   |   |       |-- sourcefuse/
|   |   |           |-- AssessmentForSeniorAutomationTester/
|   |   |               |--- BaseTest.java
|   |   |               |-- Utils.java
|   |   |-- resources/
|   |       |-- chromedriver.exe (******Kindly update the ChromeDriver to match the version of your browser******)
|   |-- test/
|       |--- java/
|       |   |-- com/
|       |       |-- sourcefuse/
|       |           |-- AssessmentForSeniorAutomationTester/
|       |               |-- TestCases.java
|-- test-output/
    |--- Default suite/
    |   |--- Default test.html
    |   |--- Default test.xml
    |   |--- testng-failed.xml
    |--- emailable-report.html
    |-- index.html

    
------------------------
	Documentation
------------------------

	Key Components:
		BaseTest.java: This class sets up and tears down the WebDriver instance. It initializes the ChromeDriver and navigates to the specified URL.    
		Utils.java: Contains utility methods for common actions such as scrolling to elements, clicking elements, entering values, and validating text fields.
		TestCases.java: This class contains the test cases that perform various actions on the web application, such as form submission, field validation, and retry logic for login attempts.
	
	Dependencies:
		Selenium Java
		TestNG
		JUnit
		MySQL Connector
		
		
Note: Kindly update the ChromeDriver to match the version of your browser