package com.qe.engineering_nexus.function;

import com.qe.engineering_nexus.common.Constants;
import com.qe.engineering_nexus.data.LoginData;
import com.qe.engineering_nexus.data.ProductData;
import com.qe.engineering_nexus.page.HeaderNavigationPage;
import com.qe.engineering_nexus.page.HomePage;
import com.qe.engineering_nexus.page.LoginPage;

public class Home {
    static HomePage homePage = new HomePage();
    static HeaderNavigationPage headerNavigationPage = new HeaderNavigationPage();


    public static void clickOnProduct(String productName){
        homePage.clickProduct(productName);
    }
}
