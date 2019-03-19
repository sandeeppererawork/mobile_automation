package com.qe.engineering_nexus.util;

import com.qe.engineering_nexus.common.Constants;
import com.syscolab.qe.core.ui.SyscoLabCapabilityUtil;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Logger;

public class DriverEnvironmentSetUpUtil {

    DriverEnvironmentSetUpUtil(){

    }

    public static String chromeDriver = "webdriver.chrome.driver";

    public static void setToRunLocally() {
        if (Constants.RUN_WINDOWS) {
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
