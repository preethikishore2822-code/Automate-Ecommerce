package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class RetryAnalyzer implements IRetryAnalyzer {
	//private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private static final int MAX_NUMBER_OF_ATTEMPTS = 
			Integer.parseInt(PropertiesUtil.readProperty(Env.QA,"MAX_NUMBER_OF_ATTEMPTS"));

	private static int currentAttempts = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (MAX_NUMBER_OF_ATTEMPTS <= currentAttempts) {
			currentAttempts++;
			return true;
		}
		return false;
	}

}
