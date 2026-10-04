package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage extends BasePage {

	private static final By SIGN_IN_LNK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

	public HomePage(WebDriver driver) {
		super(driver);
	}


	public LoginPage gotoLoginPage() {
		clickOn(SIGN_IN_LNK_LOCATOR);
		LoginPage loginpage = new LoginPage(driver);
		return loginpage;
	}

}