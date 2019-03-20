package com.qe.engineering_nexus.page;


import com.qe.engineering_nexus.common.Constants;
import com.qe.engineering_nexus.util.DriverEnvironmentSetUpUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.mobile.SyscoLabMUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LoginPage {
    By btnSignIn = By.className("login");

    By txtUsername = By.id("email");
    By txtPassword = By.id("passwd");
    By btnLogin = By.id("SubmitLogin");


    static protected SyscoLabUI syscoLabUI;

    public static void loadLoginPage(String url) {
        if (Constants.RUN_MOBILE){
            DesiredCapabilities desiredCapabilities = DriverEnvironmentSetUpUtil.setToRunLocally();
            syscoLabUI = new SyscoLabMUI(desiredCapabilities);
        }else {
            DriverEnvironmentSetUpUtil.setToRunLocallyWeb();
            syscoLabUI = new SyscoLabWUI(null);
        }
        syscoLabUI.driver.manage().window().fullscreen();
        syscoLabUI.navigateTo(url);
        syscoLabUI.sleep(5);
    }

    public void clickSignInButton(){
        syscoLabUI.click(btnSignIn);
        syscoLabUI.sleep(5);
    }

    public void setUsername(String username){
        syscoLabUI.waitTillElementLoaded(txtUsername);
        syscoLabUI.sendKeys(txtUsername, username);
        syscoLabUI.sleep(5);
    }

    public void setPassword(String password){
        syscoLabUI.sendKeys(txtPassword, password);
        syscoLabUI.sleep(5);
    }

    public void clickLoginButton(){
        syscoLabUI.click(btnLogin);
        syscoLabUI.sleep(5);
    }

    public void quitDriver(){
        if (syscoLabUI.driver != null)
            syscoLabUI.quit();
    }
}
