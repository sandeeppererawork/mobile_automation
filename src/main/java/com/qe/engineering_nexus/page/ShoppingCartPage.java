package com.qe.engineering_nexus.page;

import org.openqa.selenium.By;

public class ShoppingCartPage extends LoginPage{

    By btnProceedToCheckoutInSummary = By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']");
    By btnProceedToCheckoutInAddress = By.xpath("//*[@class='button btn btn-default button-medium']");
    By btnProceedToCheckoutInShipping = By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']");
    By chkTerms = By.id("cgv");
    By btnPayByCheck = By.xpath("//*[@title='Pay by check.']");
    By btnConfirmMyOrder = By.xpath("//*[@class='button btn btn-default button-medium']");
    By lblOrderSuccess = By.xpath("//*[@class='alert alert-success']");

    public void clickProceedToCheckoutSummary(){
        syscoLabUI.mouseHover(btnProceedToCheckoutInSummary);
        syscoLabUI.sleep(3);
        syscoLabUI.click(btnProceedToCheckoutInSummary);
        syscoLabUI.sleep(3);
    }

    public void clickProceedToCheckoutAddress(){
        syscoLabUI.mouseHover(btnProceedToCheckoutInAddress);
        syscoLabUI.sleep(3);
        syscoLabUI.click(btnProceedToCheckoutInAddress);
        syscoLabUI.sleep(3);
    }

    public void clickProceedToCheckoutShipping(){
        syscoLabUI.mouseHover(btnProceedToCheckoutInShipping);
        syscoLabUI.sleep(3);
        syscoLabUI.click(btnProceedToCheckoutInShipping);
        syscoLabUI.sleep(3);
    }

    public void checkTerms(){
        syscoLabUI.click(chkTerms);
        syscoLabUI.sleep(3);
    }

    public void clickPayByCheck(){
        syscoLabUI.click(btnPayByCheck);
        syscoLabUI.sleep(3);
    }

    public void clickConfirmMyOrder(){
        syscoLabUI.click(btnConfirmMyOrder);
        syscoLabUI.sleep(3);
    }

    public boolean isOrderSuccessDisplayed(){
        syscoLabUI.sleep(3);
        return syscoLabUI.isDisplayed(lblOrderSuccess);
    }
}
