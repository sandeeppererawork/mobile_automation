package com.qe.engineering_nexus.function;

import com.qe.engineering_nexus.page.OverlayPage;
import com.qe.engineering_nexus.page.ShoppingCartPage;

public class ShoppingCart {
    static ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    static OverlayPage overlayPage = new OverlayPage();


    public static void proceedToCheckoutInSummary(){
        shoppingCartPage.clickProceedToCheckoutSummary();
    }

    public static void proceedToCheckoutInAddress(){
        shoppingCartPage.clickProceedToCheckoutAddress();
    }

    public static void proceedToCheckoutInShipping(){
        shoppingCartPage.clickProceedToCheckoutShipping();
    }

    public static void checkTermsAndConditions(){
        shoppingCartPage.checkTerms();
    }

    public static void clickPayByCheck(){
        shoppingCartPage.clickPayByCheck();
    }

    public static void clickConfirmOrder(){
        shoppingCartPage.clickConfirmMyOrder();
    }

    public static boolean isOrderSuccessDisplayed(){
        return shoppingCartPage.isOrderSuccessDisplayed();
    }
}
