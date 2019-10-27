package com.bbc.pageobjects;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//Page object class for App Home Page
public class HomePage {

	public HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "android:id/button1")
	@CacheLookup
	AndroidElement notificationAlertOkButton;

	public void clickNotificationAlertOkButton() {
		notificationAlertOkButton.click();
	}

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'NO')]")
	@CacheLookup
	AndroidElement accessibilityAlertNoButton;

	public void clickAccessibilityAlertNoButton() {
		accessibilityAlertNoButton.click();
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My News']")
	@CacheLookup
	AndroidElement myNewsTab;

	public void clickyNewsTab() {
		myNewsTab.click();
	}

}
