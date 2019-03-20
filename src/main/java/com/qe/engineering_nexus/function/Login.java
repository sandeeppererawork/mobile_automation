package com.qe.engineering_nexus.function;

import com.qe.engineering_nexus.common.Constants;
import com.qe.engineering_nexus.data.LoginData;
import com.qe.engineering_nexus.page.HeaderNavigationPage;
import com.qe.engineering_nexus.page.LoginPage;

public class Login {
    static LoginPage loginPage = new LoginPage();
    static HeaderNavigationPage headerNavigationPage = new HeaderNavigationPage();

    public static void openApplication(){
        loginPage.loadLoginPage(Constants.APP_URL);
    }

    public static void loginToApplication(LoginData loginData){
        loginPage.clickSignInButton();
        loginPage.setUsername(loginData.username);
        loginPage.setPassword(loginData.password);
        loginPage.clickLoginButton();
        headerNavigationPage.clickMainLogo();
    }

    public static void quitDriver(){
        loginPage.quitDriver();
    }
}
