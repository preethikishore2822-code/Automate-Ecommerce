package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.constants.Env;
import com.ui.driver.DriverManager;
import com.ui.pages.HomePage;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public class BaseTest {

	protected WebDriver driver;
    protected HomePage homePage;

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Parameters({ "browser", "isHeadless" })
	@BeforeMethod

	public void setUp(String browser, boolean isHeadless) {

		// create driver creates a new browser specific session

		logger.info("Starting test");
logger.info("Starting test");

System.out.println("browser = [" + browser + "]");
System.out.println("isHeadless = [" + isHeadless + "]");

DriverManager.createDriver(Browser.valueOf(browser.toUpperCase()), isHeadless);


		driver = DriverManager.getDriver();

		// Common browser setup
		driver.manage().window().maximize();

		// Navigate to application
		

		System.out.println("Luanching the URL:" );
		driver.get(JSONUtility.readJSON(Env.QA).getUrl());
		
		// Initialize page objects
        homePage = new HomePage(driver);

	}

	@AfterMethod
	public void tearDown() {
        // Quit driver
		
		logger.info("Closing browser");

		DriverManager.quitDriver();
	}

}
