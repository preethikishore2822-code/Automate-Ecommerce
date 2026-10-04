package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.driver.DriverManager;
import com.ui.tests.BaseTest;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;
import com.utility.ScreenshotUtility;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	// extentsparkreporter job is to the provide the functionality to create the
	// HTML (look ,style are taken care by it)
	// extentreports does the heavy lifting (dumping of data into the html is done
	// by extents reports)
	// extentTest stores the information about the test(which test started,finished
	// all info are stored by this extenttest)

	public void onTestStart(ITestResult result) {

		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {

		logger.info(result.getMethod().getMethodName() + " " + "PASSED");

		ExtentReportUtility.getExtentTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReportUtility.getExtentTest().log(Status.FAIL, result.getThrowable().getMessage());	
		logger.info("capturing screenshot");
		String screenShotPath = ScreenshotUtility.takeScreenshot(DriverManager.getDriver(),result.getMethod().getMethodName());
		ExtentReportUtility.getExtentTest().addScreenCaptureFromPath(screenShotPath);
	}

	public void onStart(ITestContext rescontextult) {
		logger.info("Test suite started");
		ExtentReportUtility.setupSparkReporter("reports.html");
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReportUtility.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

	}

	public void onFinish(ITestContext context) {
		logger.info("Test finished ");
		ExtentReportUtility.flushReport();
	}
}
