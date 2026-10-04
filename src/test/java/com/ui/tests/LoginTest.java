package com.ui.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pojo.User;

public class LoginTest extends BaseTest {
	
	
	@Test(description = "verify the login test using data from the JSON file", groups = {
			"regression,smoke" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginJSONdataprovider", enabled = true)
	public void loginTest(User user) {
		logger.info("login test started");
		
		String userName = homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
	

		Assert.assertEquals("Preethi D", userName);

	}

	@Test(description = "verify the login test using data from the csv file", enabled = false, groups = {
			"regression,e2e" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginCSVDataProvider", retryAnalyzer = com.ui.listeners.RetryAnalyzer.class)
	public void loginTestUsingCSV(User user) {

		String userName = homePage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
				.getUserName();

		Assert.assertEquals("Preethi D", userName);
		System.out.println("user name from the webpage is:" + userName);

	}

	@Test(description="verify the login test for incorrect credentails",groups = "smoke")
	public void loginTestUsingInvalidCredentials() {

		String error_Message = homePage.gotoLoginPage()
				.doLoginWithInvalidCredentials("tileki9948@maxtanie.con", "12345").getErrorMessage();
		System.out.println(error_Message);
		Assert.assertEquals(error_Message, "Authentication failed.");

	}

}
