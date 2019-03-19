package com.qe.engineering_nexus.page;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OverlayPage extends LoginPage {

//    By dialogAlert = By.xpath("//*[@role='dialog' and @aria-describedby=\"dialog-window\"]");
    By dialogAlert = By.xpath("//*[@role='dialog' and (@aria-describedby=\"dialog-window\" or @aria-describedby=\"export-dialog-message\")]");
    By headerAlert = By.xpath(".//*[@class='ui-dialog-title']");
    By btnCloseAlert = By.xpath(".//button[@title='Close']");
    By btnOK = By.xpath("//button[contains(@id,'DialogOk')]");
    By btnCancel = By.xpath("//button[text()='Cancel']");

    //stop move
    By ddToNewRoute = By.id("DestinationRouteNumberDDL");
    By txtComment = By.id("stopModificationComment");

    public WebElement getAlertWindowElement(){
        handleBrowserAlert();
        List<WebElement> alertWindowElements = syscoLabUI.findElements(dialogAlert);
        for (WebElement alertWindowElement : alertWindowElements){
            if (syscoLabUI.isDisplayed(alertWindowElement))
                return alertWindowElement;
            }
        return null;
    }

    public boolean isAlertDisplayed(){
        syscoLabUI.sleep(4);
        return syscoLabUI.isDisplayed(getAlertWindowElement());
    }

    public void handleBrowserAlert(){
        syscoLabUI.sleep(5);
        if (syscoLabUI.isAlertDisplayed()) {
            syscoLabUI.sleep(3);
            syscoLabUI.clickOkInWindowsAlert();
        }
    }

    public String getAlertTitle(){
        handleBrowserAlert();
        syscoLabUI.sleep(3);
        try {
            return syscoLabUI.getText(syscoLabUI.findElement(dialogAlert, headerAlert));
        }catch (UnhandledAlertException e) {
            return getAlertTitle();
        }
    }

    public void clickCloseButton(){
        syscoLabUI.click(syscoLabUI.findElement(getAlertWindowElement(), btnCloseAlert));
//        syscoLabUI.click(syscoLabUI.findElement(dialogAlert, btnCloseAlert));
    }

    public void clickOKButton(){
        syscoLabUI.click(syscoLabUI.findElement(dialogAlert, btnOK));
    }

    public void clickOKCancel(){
        handleBrowserAlert();
        syscoLabUI.sleep(3);
        syscoLabUI.click(syscoLabUI.findElement(dialogAlert, btnCancel));
    }

    public void setStopMoveComment(String comment){
        handleBrowserAlert();
        syscoLabUI.sleep(3);
        syscoLabUI.sendKeys(txtComment, comment);
    }

    //stop move

    public void selectToNewRoute(String newRoute){
       handleBrowserAlert();
       List<WebElement> newRouteElements = syscoLabUI.findElements(syscoLabUI.findElement(ddToNewRoute), By.xpath("./option"));
       for (WebElement newRouteElement : newRouteElements){
           if (syscoLabUI.getText(newRouteElement).contains(newRoute)){
               syscoLabUI.click(newRouteElement);
               break;
           }
       }
//        syscoLabUI.select(ddToNewRoute, newRoute);
    }
}
