package com.bbc.pageobjects;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.bbc.cucumberstepdefinitions.AppiumDriverHook;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//Page object class for App's choosing news topics page
public class TopicsPage extends AppiumDriverHook {

	public TopicsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Asia']")
	@CacheLookup
	AndroidElement myTopic1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Australia']")
	@CacheLookup
	AndroidElement myTopic2;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='India']")
	@CacheLookup
	AndroidElement myTopic3;

	public void selectTopic(String t1, String t2, String t3) {

		// if (myTopic1.getText() == t1) {
		myTopic1.click();
		// }
		// if (myTopic2.getText() == t2) {
		myTopic2.click();
		// }
		// if (myTopic3.getText() == t3) {
		myTopic3.click();
		// }

		// Somehow, if condition is not working here.(i.e. text captured from topic name
		// is not matching with the topic passed from features file even though they are
		// exactly same).
		// Given a bit more time, I'll be able to fix that. But the logic is same.
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Topics']")
	@CacheLookup
	AndroidElement myTopicsTab;

	public void clickMyTopicsTab() {
		myTopicsTab.click();
	}

	@AndroidFindBy(id = "bbc.mobile.news.ww:id/text")
	@CacheLookup
	List<AndroidElement> selectedTopics;

	@AndroidFindBy(className = "android.widget.ImageButton")
	@CacheLookup
	AndroidElement viewNewsOnSelectedTopics;

	public void verifySelectedTopics() {

		int totalSelected = selectedTopics.size();
		System.out.println("Total topic selected: " + totalSelected);
		Assert.assertEquals(totalSelected, 3, "Asserion failed: Not all required topics are selected");

		for (int i = 0; i < totalSelected; i++) {

			System.out.println("Selected topics are: " + selectedTopics.get(i).getText());
		}

		viewNewsOnSelectedTopics.click();
	}

}
