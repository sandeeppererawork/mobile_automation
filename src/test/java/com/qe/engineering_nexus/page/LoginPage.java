package com.qe.engineering_nexus.page;


import com.qe.engineering_nexus.common.AppiumConstants;
import com.qe.engineering_nexus.util.DriverEnvironmentSetUpUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.mobile.SyscoLabMUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginPage {

    By txtUsername = By.id("username");
    By txtPassword = By.id("password");
    By btnLogin = By.id("Login");
    By imgLoadingSpinner = By.xpath("//*[@class=\"loading-cover\"]");

    static protected SyscoLabUI syscoLabUI;

    public static void main(String args[]) throws MalformedURLException {
        loadLoginPage("http://www.google.com");
    }

    public static void loadLoginPage(String url) throws MalformedURLException {
//        DriverEnvironmentSetUpUtil.setToRunLocally();
//        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "330025a29d538377");
//        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");

//        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, AppiumConstants.DEVICE_NAME);
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, AppiumConstants.APP_PATH);

//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, AppiumConstants.PLATFORM_NAME);
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, AppiumConstants.PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
//        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");

        System.setProperty("appium.hub.url1", "http://0.0.0.0:4723/wd/hub");
        syscoLabUI = new SyscoLabMUI(desiredCapabilities);
//        AndroidDriver androidDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
//        AndroidDriver androidDriver = new AndroidDriver(desiredCapabilities);
//        syscoLabUI.navigateTo(url);
//        syscoLabUI.driver.manage().window().maximize();
//        androidDriver.get("http://www.google.com");
        syscoLabUI.navigateTo("http://automationpractice.com");
        syscoLabUI.sleep(40);
    }

//    public void loadLoginPage(LoginData loginData){
//        DriverEnvironmentSetUpUtil.setToRunLocally();
//        syscoLabUI = new SyscoLabWUI(null);
////        syscoLabUI.navigateTo("http://USERNAME:PASSWORD@ms084webqa/routetracker".replace("USERNAME", loginData.username).replace("PASSWORD",loginData.pw));
//        syscoLabUI.navigateTo("http://USERNAME:PASSWORD@sygmanet/".replace("USERNAME", loginData.username).replace("PASSWORD",loginData.pw));
//        syscoLabUI.driver.manage().window().maximize();
//    }

    public void setUsername(String username){
        syscoLabUI.sendKeys(txtUsername, username);
    }

    public void setPassword(String password){
        syscoLabUI.sendKeys(txtPassword, password);
    }

    public void clickLoginButton(){
        syscoLabUI.click(btnLogin);
    }

    public void waitTillLoadingSpinnerIsDisappear(){
        syscoLabUI.waitTillElementDisappear(imgLoadingSpinner);
    }

    public void quitDriver(){
        if (syscoLabUI.driver != null)
            syscoLabUI.quit();
    }
}
