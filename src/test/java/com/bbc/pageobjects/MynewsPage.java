package com.bbc.pageobjects;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//Page object class for App's My News page
public class MynewsPage {

	public MynewsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(uiAutomator = "text(\"OK, let's get started\")")
	@CacheLookup
	AndroidElement addTopicButton;

	public void clickAddTopicButton() {
		addTopicButton.click();
	}
}
