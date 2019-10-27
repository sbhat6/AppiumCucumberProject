package com.bbc.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//This class maintains all the input variables that can be re-used anywhere in the project.
public class ReadInputVariables {

	public Properties prop;

	public ReadInputVariables() { // Java OOP concept 'Constructors' is used here
		File fl = new File("./inputs/inputvariables.properties");
		try {
			FileInputStream fs = new FileInputStream(fl); // Java Properties & FileInputStream classes are used here
			prop = new Properties();
			prop.load(fs);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	// Following are the methods to read input variables from properties file
	// present in ínputs'folder of the project
	public String getServerIp() {
		String serverIp = prop.getProperty("serverip");
		return serverIp;
	}

	public String getServerPort() {
		String serverPort = prop.getProperty("serverport");
		return serverPort;
	}

	public String getPlatformName() {
		String platformName = prop.getProperty("platformname");
		return platformName;
	}

	public String getDeviceId() {
		String deviceId = prop.getProperty("deviceudid");
		return deviceId;
	}

	public String getDeviceName() {
		String deviceName = prop.getProperty("devicename");
		return deviceName;
	}

	public String getApkPath() {
		String apkPath = prop.getProperty("apkpath");
		return apkPath;
	}

	public String getAppPackageName() {
		String packageName = prop.getProperty("apkpackage");
		return packageName;
	}

	public String getAppActivityName() {
		String activityName = prop.getProperty("apkactivity");
		return activityName;
	}

}
