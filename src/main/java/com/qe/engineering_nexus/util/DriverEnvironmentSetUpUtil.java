package com.qe.engineering_nexus.util;

import com.qe.engineering_nexus.common.AppiumConstants;
import com.qe.engineering_nexus.common.Constants;
import com.syscolab.qe.core.ui.SyscoLabCapabilityUtil;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Logger;

public class DriverEnvironmentSetUpUtil {

    public static String chromeDriver = "webdriver.chrome.driver";

    DriverEnvironmentSetUpUtil(){

    }

    public static DesiredCapabilities setToRunLocally() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, AppiumConstants.DEVICE_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, AppiumConstants.DEVICE_UUID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, AppiumConstants.PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, AppiumConstants.PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AppiumConstants.AUTOMATION_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, AppiumConstants.BROWSER_NAME);
        System.setProperty("appium.hub.url1", AppiumConstants.APPIUM_SERVER_URL);
        return desiredCapabilities;
    }

    public static void setToRunLocallyWeb() {
        if (Constants.RUN_MOBILE) {
            System.setProperty(chromeDriver, "src/main/resources/chrome_driver/" + System.getProperty("os.arch") + "/chromedriver.exe");
        } else {
            System.setProperty(chromeDriver, "src/main/resources/chrome_driver/" + System.getProperty("os.arch") + "/chromedriver");
        }
        Logger.getLogger(System.getProperty(chromeDriver));
    }

    public static Capabilities setToRunRemotely() {
        DesiredCapabilities capabilities ;
        System.setProperty("hub.url","http://localhost:4444/wd/hub");
        capabilities = SyscoLabCapabilityUtil.getPCCapabilities("MAC","chrome");
        capabilities.setBrowserName(BrowserType.CHROME);
        return capabilities;
    }

}
