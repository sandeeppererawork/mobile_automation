package com.qe.engineering_nexus.common;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;

public class AppiumConstants {

    // Appium related
    public final static boolean RUN_IN_DEVICE = Boolean.parseBoolean(System.getProperty("run.in.device", "false"));
//    public final static String DEVICE_NAME = System.getProperty("device.name", "iPadPro");
    public final static String DEVICE_UUID = System.getProperty("device.udid", "330025a29d538377");
    public final static String APPIUM_SERVER_URL = System.getProperty("appium.server.url", "http://0.0.0.0:4723/wd/hub");
//    public final static String APP_PATH = System.getProperty("app.path", System.getProperty("user.dir") + "/src/main/resources/application/GuestManager.ipa");
    public final static String APP_PATH = new File("src/main/resources/ApiDemos-debug.apk").getAbsolutePath();
    public final static String APP_PACKAGE_NAME = System.getProperty("app.package", "com.leapset.Order-Pad.enterprise");
    public final static String APP_ACTIVITY = System.getProperty("app.activity", "com.leapset.Order-Pad.enterprise.MainActivity");
    public final static String PLATFORM_NAME = System.getProperty("platform.name", MobilePlatform.ANDROID);
//    public final static String AUTOMATION_NAME = System.getProperty("appium.automation.name", "XCUITest");
//    public final static String PLATFORM_VERSION = System.getProperty("platform.version", "11.0");
}
