package com.qe.engineering_nexus.function;

import com.qe.engineering_nexus.page.HeaderNavigationPage;
import com.qe.engineering_nexus.page.HomePage;
import com.qe.engineering_nexus.page.OverlayPage;
import com.qe.engineering_nexus.page.ProductPage;

public class Product {
    static ProductPage productPage = new ProductPage();
    static OverlayPage overlayPage = new OverlayPage();


    public static void addToCart(){
        productPage.clickAddToCart();
    }

    public static void continueShopping(){
        overlayPage.clickContinueShopping();
    }

    public static void proceedToCheckout(){
        overlayPage.clickProceedToCheckout();
    }
}
