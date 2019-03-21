package com.qe.engineering_nexus.tests;

import com.qe.engineering_nexus.data.LoginData;
import com.qe.engineering_nexus.data.ProductData;
import com.qe.engineering_nexus.function.*;
import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckoutTest {
    LoginData loginData = new LoginData();
    ProductData productData = new ProductData();

    @BeforeClass
    public void init(){
        Login.openApplication();
    }

    @Test(description = "TC-001")
    public void testPurchaseItems(){
        Login.loginToApplication(loginData);
        Home.clickOnProduct(productData.product1);
        Product.addToCart();
        Product.continueShopping();
        Header.navigateToHome();
        Home.clickOnProduct(productData.product2);
        Product.addToCart();
        Product.proceedToCheckout();
        ShoppingCart.proceedToCheckoutInSummary();
        ShoppingCart.proceedToCheckoutInAddress();
        ShoppingCart.checkTermsAndConditions();
        ShoppingCart.proceedToCheckoutInShipping();
        ShoppingCart.clickPayByCheck();
        ShoppingCart.clickConfirmOrder();
        Assert.assertTrue(ShoppingCart.isOrderSuccessDisplayed(), "Shopping Cart is not success");
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver(){
        Login.quitDriver();
    }
}
