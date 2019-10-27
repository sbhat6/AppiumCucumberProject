//This is the Cucumber Step Definition Class containing implementation for steps written in feature file.

package com.bbc.cucumberstepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import com.bbc.pageobjects.HomePage;
import com.bbc.pageobjects.MynewsPage;
import com.bbc.pageobjects.TopicsPage;

public class StepDefinition {

	private AppiumDriverHook hook;

	public StepDefinition(AppiumDriverHook hook) {
		this.hook = hook;

	}

	@Given("^User launches BBC News App$")
	public void user_launches_bbc_news_app() throws Throwable {
		AndroidDriver<AndroidElement> driver = hook.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			HomePage hp = new HomePage(driver);
			hp.clickNotificationAlertOkButton();
			hp.clickAccessibilityAlertNoButton();
			hp.clickyNewsTab();
		} catch (Exception e) {
			e.getClass().getSimpleName();
			e.printStackTrace();
			Assert.fail();
		}
	}

	@When("^he goes to My News page and adds the topics (.+), (.+) and (.+)$") //Three topics are parameterized from features file. Good example of Data Driven Testing
	public void he_goes_to_my_news_page_and_adds_the_topics_and(String topic1, String topic2, String topic3)
			throws Throwable {
		AndroidDriver<AndroidElement> driver = hook.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			MynewsPage mp = new MynewsPage(driver);
			TopicsPage tp = new TopicsPage(driver);
			mp.clickAddTopicButton();
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(textContains(\"Asia\"));");
			Thread.sleep(3000);
			tp.selectTopic(topic1, topic2, topic3);
			tp.clickMyTopicsTab();
		} catch (Exception e) {
			e.getClass().getSimpleName();
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Then("^he should see the personilized news feed for those topics$")
	public void he_should_see_the_personilized_news_feed_for_those_topics() throws Throwable {
		AndroidDriver<AndroidElement> driver = hook.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			TopicsPage tp = new TopicsPage(driver);
			tp.verifySelectedTopics();
		} catch (Exception e) {
			e.getClass().getSimpleName();
			e.printStackTrace();
			Assert.fail();
		}
	}

}
