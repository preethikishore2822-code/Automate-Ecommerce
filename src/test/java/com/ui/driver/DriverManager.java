package com.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public class DriverManager {

	// Holds the driver for the current test/thread

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void createDriver(Browser browserName, boolean isHeadless) {

		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				// launches browser in the headless mode where the gui is not visible while the
				// test runs
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());

			}
		} else if (browserName == Browser.FIREFOX) {

			if (isHeadless) {

				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("--disable-gpu");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());

			}
		} else

		{
			System.out.println("Invalid browser name");
		}
	}
	// * Returns the WebDriver instance.

	public static WebDriver getDriver() {
		return driver.get();
	}

	// * Quits the WebDriver and removes it from ThreadLocal.

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
