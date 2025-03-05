package com.sourcefuse.AssessmentForSeniorAutomationTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest 
{
	protected static WebDriver driver;
	final String USERNAME = "sfwebhtml";
	final String PASSWORD = "t63KUfxL5vUyFLG4eqZNUcuRQ";
    @BeforeClass
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "src/main/resource/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://dsnm875e4wmhw.cloudfront.net/");
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
