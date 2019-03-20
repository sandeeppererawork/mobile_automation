package com.qe.engineering_nexus.common;

import io.appium.java_client.remote.MobilePlatform;

import java.io.File;

public class AppiumConstants {

    // Appium related
    public final static String DEVICE_UUID = System.getProperty("device.udid", "330025a29d538377");
    public final static String DEVICE_NAME= System.getProperty("device.name", "ANDROID");
    public final static String APPIUM_SERVER_URL = System.getProperty("appium.server.url", "http://0.0.0.0:4723/wd/hub");
    public final static String APP_PATH = new File("src/main/resources/ApiDemos-debug.apk").getAbsolutePath();
    public final static String PLATFORM_NAME = System.getProperty("platform.name", MobilePlatform.ANDROID);
    public final static String PLATFORM_VERSION = System.getProperty("platform.version", "7.0");
    public final static String AUTOMATION_NAME = System.getProperty("automation.name", "uiautomator2");
    public final static String BROWSER_NAME = System.getProperty("browser.name", "Chrome");
}
