package com.qe.engineering_nexus.page;


import org.openqa.selenium.By;

public class ProductPage extends LoginPage {

    By iframeProduct = By.xpath("//iframe[contains(@id,'fancybox-frame')]");
    By btnAddToCart = By.xpath("//*[@id='add_to_cart']/button");

    public void switchToProductIframe(){
        syscoLabUI.switchToFrame(iframeProduct);
    }

    public void clickAddToCart(){
//        switchToProductIframe();
        syscoLabUI.scrollToElement(btnAddToCart);
        syscoLabUI.sleep(3);
        syscoLabUI.click(btnAddToCart);
        syscoLabUI.sleep(3);
//        syscoLabUI.switchToDefaultFrame();
        getPageTitle();
    }




}
