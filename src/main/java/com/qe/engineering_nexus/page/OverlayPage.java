package com.qe.engineering_nexus.page;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OverlayPage extends LoginPage {

    By btnContinueShopping = By.xpath("//*[@class='continue btn btn-default button exclusive-medium']");
    By btnProceedToCheckout = By.xpath("//*[@class='btn btn-default button button-medium']");
    By btnClose = By.xpath("//*[@class='fancybox-item fancybox-close']");

    public void clickContinueShopping(){
        syscoLabUI.sleep(4);
        syscoLabUI.scrollToElement(btnContinueShopping);
        syscoLabUI.sleep(4);
        syscoLabUI.click(btnContinueShopping);
    }

    public void clickProceedToCheckout(){
        syscoLabUI.sleep(4);
        syscoLabUI.click(btnProceedToCheckout);
    }

    public void clickCloseButton(){
        syscoLabUI.sleep(4);
        syscoLabUI.click(btnClose);
    }

    public void handleBrowserAlert(){
        syscoLabUI.sleep(5);
        if (syscoLabUI.isAlertDisplayed()) {
            syscoLabUI.sleep(3);
            syscoLabUI.clickOkInWindowsAlert();
        }
    }


}
