package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

	private static final By emailTextBoxLocator = By.id("email");
	private static final By passwordTextBoxLocator = By.id("passwd");
	private static final By submitLoginButton = By.id("SubmitLogin");
	private static final By AUTHENTICATION_FAILED_ERROR_LOCATOR = By
			.xpath("//div[contains(@class,'alert-danger')]/ol/li");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String userName, String password) {
		enterText(emailTextBoxLocator, userName);
		enterText(passwordTextBoxLocator, password);
		clickOn(submitLoginButton);
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		return myAccountPage;

	}

	public LoginPage doLoginWithInvalidCredentials(String userName, String password) {
		enterText(emailTextBoxLocator, userName);
		enterText(passwordTextBoxLocator, password);
		clickOn(submitLoginButton);
//		LoginPage loginPage = new LoginPage(driver);
//		return loginPage;
	    return this; //returns current class object which is login page


	}

	public String getErrorMessage() {
		return getVisibleText(AUTHENTICATION_FAILED_ERROR_LOCATOR);

	}
}
