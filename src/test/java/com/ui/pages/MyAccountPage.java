package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccountPage extends BasePage {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]/span");
	private static final By SIGN_OUT_LOCATOR = By.xpath("//a[contains(text(),'Sign out')]");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

	public void clickSignOut() {
		clickOn(SIGN_OUT_LOCATOR);
	}

}
