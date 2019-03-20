package com.qe.engineering_nexus.function;

import com.qe.engineering_nexus.page.HeaderNavigationPage;
import com.qe.engineering_nexus.page.HomePage;

public class Header {
    static HeaderNavigationPage headerNavigationPage = new HeaderNavigationPage();


    public static void navigateToHome(){
        headerNavigationPage.clickMainLogo();
    }
}
