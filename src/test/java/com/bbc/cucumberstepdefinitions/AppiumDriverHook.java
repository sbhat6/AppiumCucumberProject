package com.bbc.cucumberstepdefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.bbc.utilities.ReadInputVariables;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDriverHook {

	protected AndroidDriver<AndroidElement> driver;

//Methods for input variable created in Utilities package are called here
	ReadInputVariables read = new ReadInputVariables();
	private String serverip = read.getServerIp();
	private String serverport = read.getServerPort();
	private String platformname = read.getPlatformName();
	private String devicename = read.getDeviceName();
	private String deviceid = read.getDeviceId();
	private String apkpath = read.getApkPath();
	// private String apkpackage = read.getAppPackageName();
	// private String apkactivity = read.getAppActivityName();

//Appium driver instance is created here through a Cucumber hook, in order to achieve code re-usability, that can be accessed my as many as Step Definitions.
	@Before
	public void driverSetup() throws MalformedURLException {
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
		dcap.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		dcap.setCapability(MobileCapabilityType.UDID, deviceid);
		dcap.setCapability(MobileCapabilityType.APP, apkpath);
		// dcap.setCapability("appPackage", apkpackage);
		// dcap.setCapability("appActivity", apkactivity);
		dcap.setCapability("noReset", false);
		dcap.setCapability("newCommandTimeout", 300);
		String serverUrl = "http://" + serverip + ":" + serverport + "/wd/hub";

		try { // Java error handling technique 'try-catch'is used here.
			driver = new AndroidDriver<AndroidElement>(new URL(serverUrl), dcap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (NullPointerException ex) {
			throw new RuntimeException("Appium driver could not be initialised for this device");
		}
	}

	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}
}
