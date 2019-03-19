package com.qe.engineering_nexus.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RouteManagerPage extends LoginPage {

    By ddCenter = By.id("RouteCenterSelector");
    By ddRouteTimingDateRange = By.id("RouteTimingTypeSelectorleft");
    By txtRouteNameNumber = By.id("RouteNameNumberleft");
//    By lstRouteStop = By.xpath("//*[@id='routeListleft']/div[@class=\"route-item\"]");
    String lstRouteStopLeft = "//*[@id='routeListleft']/div[@data-routenumber=\"ROUTENUMBERVALUE\"]";
    String lstRouteStopRight = "//*[@id='routeListright']/div[@data-routenumber=\"ROUTENUMBERVALUE\"]";
//    By dropPin = By.xpath("//*[@class=\"pin-number\"]");
    By dropPinLeftPane = By.xpath("//*[@style=\"background-color: #f08080;\"]/*[@class=\"pin-number\"]");
    By dropPinRightPane = By.xpath("//*[@style=\"background-color: #BDB76B;\"]/*[@class=\"pin-number\"]");
    By lblInfoWindow = By.xpath("//*[@class=\"info-window-content\"]");
    By btnCloseInfoWindow = By.xpath("//*[@class=\"gm-ui-hover-effect\" and @title=\"Close\"]");
    By btnCloseRightRouteWindow = By.xpath("//*[@id='rightRoute']//*[@class=\"fa fa-times\" and @title=\"Close Panel\"]");
    By lblStopItem = By.xpath("//*[@class=\"stop-list-content\"]//*[@class=\"panel-body\"]/*[@class=\"stop-item\"]");


//    By btnCloseStopListLeft = By.xpath("//*[@class='overlay overlay-right stop-list stop-list-is-displayed']//*[@class=\"stop-closebtn stop-list-toggle\"]");
    By btnRouteCloseStopListRight = By.xpath("//*[contains(@class,'overlay overlay-right')]//*[@class=\"closebtn\"]");
    By btnCloseStopListRight = By.xpath("//*[@class='overlay overlay-right stop-list stop-list-is-displayed']//*[@class=\"stop-closebtn stop-list-toggle\"]");

    public void selectCenter(String center){
        syscoLabUI.select(ddCenter, center);
    }

    public void selectRouteTimeDateRange(String dateRange){
        syscoLabUI.sleep(2);
        syscoLabUI.select(ddRouteTimingDateRange, dateRange);
    }

    public void setRouteNameNumber(String routeNameNumber){
        syscoLabUI.sleep(2);
        syscoLabUI.sendKeys(txtRouteNameNumber, routeNameNumber);
    }

    public WebElement getFirstRouteStopElementInLeftPane(String routeNumber){
//        List<WebElement> routeStopElements = syscoLabUI.findElements(lstRouteStop);
//        for (WebElement routeStopElement : routeStopElements){
//            //todo handle the logic to comply with a given condition
//            return routeStopElement;
//        }
//        return null;

        syscoLabUI.waitTillElementLoaded(By.xpath(lstRouteStopLeft.replace("ROUTENUMBERVALUE", routeNumber)));
        return syscoLabUI.findElement(By.xpath(lstRouteStopLeft.replace("ROUTENUMBERVALUE", routeNumber)));
    }

    public void clickFirstRouteStopCheckboxInLeftPane(String routeNumber){
        syscoLabUI.click(getFirstRouteStopElementInLeftPane(routeNumber), By.xpath(".//input"));
        waitTillLoadingSpinnerIsDisappear();
    }

    public WebElement getFirstRouteStopElementInRightPane(String routeNumber){
//        List<WebElement> routeStopElements = syscoLabUI.findElements(lstRouteStop);
//        for (WebElement routeStopElement : routeStopElements){
//            //todo handle the logic to comply with a given condition
//            return routeStopElement;
//        }
//        return null;

        syscoLabUI.waitTillElementLoaded(By.xpath(lstRouteStopRight.replace("ROUTENUMBERVALUE", routeNumber)));
//        syscoLabUI.waitTillElementLoaded(By.xpath(lstRouteStopLeft.replace("ROUTENUMBERVALUE", routeNumber)));
        return syscoLabUI.findElement(By.xpath(lstRouteStopRight.replace("ROUTENUMBERVALUE", routeNumber)));
//        return syscoLabUI.findElement(By.xpath(lstRouteStopLeft.replace("ROUTENUMBERVALUE", routeNumber)));
    }

    public void clickFirstRouteStopCheckboxInRightPane(String routeNumber){
        syscoLabUI.click(getFirstRouteStopElementInRightPane(routeNumber), By.xpath(".//input"));
        waitTillLoadingSpinnerIsDisappear();
    }

    public void clickFirstDisplayedRouteStopDropPin(){
        List<WebElement> dropPinsElements = syscoLabUI.findElements(dropPinLeftPane);
        for (WebElement dropPinsElement : dropPinsElements){
            if (syscoLabUI.isClickable(dropPinsElement) && syscoLabUI.isDisplayed(dropPinsElement))
                syscoLabUI.click(dropPinsElement);
        }
        waitTillLoadingSpinnerIsDisappear();
    }

    public String getFirstDisplayedRouteStopDropPinNumberLeftPane(){
        List<WebElement> dropPinsElements = syscoLabUI.findElements(dropPinLeftPane);
        for (WebElement dropPinsElement : dropPinsElements){
            if (syscoLabUI.isClickable(dropPinsElement) && syscoLabUI.isDisplayed(dropPinsElement))
                try {
//                    syscoLabUI.move(dropPinsElement);
                    syscoLabUI.click(dropPinsElement);
                    return syscoLabUI.getText(dropPinsElement);
                }catch (Exception e){

                }
        }
        waitTillLoadingSpinnerIsDisappear();
        return null;
    }

    public String getFirstDisplayedRouteStopDropPinNumberRightPane(){
        List<WebElement> dropPinsElements = syscoLabUI.findElements(dropPinRightPane);
        for (WebElement dropPinsElement : dropPinsElements){
            if (syscoLabUI.isClickable(dropPinsElement) && syscoLabUI.isDisplayed(dropPinsElement))
                try {
                    syscoLabUI.move(dropPinsElement);
//                    ((JavascriptExecutor) syscoLabUI.driver).executeScript("arguments[0].scrollIntoView(true);", dropPinsElement);

                    syscoLabUI.click(dropPinsElement);
                    return syscoLabUI.getText(dropPinsElement);
                }catch (Exception e){

                }
        }
        waitTillLoadingSpinnerIsDisappear();
        return null;
    }

    public void clickExpandRouteStopToggleLeftPane(String routeNumber){
        WebElement btnStopListToggle = syscoLabUI.findElement(getFirstRouteStopElementInLeftPane(routeNumber), By.xpath(".//a[@class=\"stop-list-toggle \"]/i"));
        if (syscoLabUI.getAttribute(btnStopListToggle, "style").contains("opacity: 0.25")){
            syscoLabUI.click(btnStopListToggle);
            syscoLabUI.sleep(4);
        }
        waitTillLoadingSpinnerIsDisappear();
    }

    public void clickExpandRouteStopToggleRightPane(String routeNumber){
        WebElement btnStopListToggle = syscoLabUI.findElement(getFirstRouteStopElementInRightPane(routeNumber), By.xpath(".//a[@class=\"stop-list-toggle stop-list-toggle-right\"]/i"));
        if (syscoLabUI.getAttribute(btnStopListToggle, "style").contains("opacity: 0.25"))
            syscoLabUI.click(btnStopListToggle);
        waitTillLoadingSpinnerIsDisappear();
    }

    public String getDropPinInfoWindowContent(){
        return syscoLabUI.getText(lblInfoWindow);
    }

    public void clickCloseInfoWindow(){
        syscoLabUI.click(btnCloseInfoWindow);
    }

    public void clickCloseRightRouteWindow(){
        syscoLabUI.sleep(3);
        try {
            syscoLabUI.click(btnCloseRightRouteWindow);
        }catch (Exception e){
            syscoLabUI.sleep(3);
            syscoLabUI.click(btnCloseRightRouteWindow);
        }
    }

    public void clickCloseStopListRight(){
        syscoLabUI.sleep(3);
        syscoLabUI.move(btnCloseStopListRight);
        syscoLabUI.sleep(2);
        syscoLabUI.click(btnCloseStopListRight);
    }

    public WebElement getStopItemElement(String stopNumber){
        List<WebElement> stopItemElements = syscoLabUI.findElements(lblStopItem);
        for (WebElement stopElement : stopItemElements){
            syscoLabUI.move(syscoLabUI.findElement(stopElement, By.xpath("./div[@class=\"row stop-header\"]/div/span")));
            if (stopNumber.equals(syscoLabUI.getText(syscoLabUI.findElement(stopElement, By.xpath("./div[@class=\"row stop-header\"]/div/span")))))
                return stopElement;
        }
        return null;
    }

    public void clickNavigationInStopItem(String stopNumber){
        syscoLabUI.click(getStopItemElement(stopNumber), By.xpath(".//div/a[@class=\"primary-stop-toggle\"]"));
    }

    public void clickStopMoveInStopItem(String stopNumber){
        syscoLabUI.click(getStopItemElement(stopNumber), By.xpath(".//div/a[@class=\"stop-move-btn\"]"));
    }

}
