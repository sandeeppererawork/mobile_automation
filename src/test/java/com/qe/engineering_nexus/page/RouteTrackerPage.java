package com.qe.engineering_nexus.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RouteTrackerPage extends LoginPage{

    By drpCenter = By.id("selectCenterDropdown");
    By drpDispatchDate = By.id("dateRangeDropdown");
    By trRoutes = By.xpath("//td[@class='RouteNumber']");
    By btnExportToExcel = By.id("excelExportButton");
    By btnColumnOption = By.id("columnOptionsButton");
    By ddAvailableColumn = By.id("routeAvailableColumns");
    By ddSelectedColumn = By.id("routeSelectedColumns");
    By btnRouteTrackerMoveToSelectedColumns = By.id("routeColumnMoveRight");
    By btnRouteTrackerMoveToAvailableColumns = By.id("routeColumnMoveLeft");


//    ROUTE CURRENTLY RUNNING ON-TIME

    public void setCenter(String center){
        waitTillLoadingSpinnerIsDisappear();
        syscoLabUI.select(drpCenter, center);
    }

    public void setDispatchDate(String dispatchDate){
        waitTillLoadingSpinnerIsDisappear();
        syscoLabUI.select(drpDispatchDate, dispatchDate);
    }

    public WebElement getRouteElement(String routeNumber){
        waitTillLoadingSpinnerIsDisappear();
        List<WebElement> routeElementList = syscoLabUI.findElements(trRoutes);
        for (WebElement routeElement : routeElementList){
            if (routeNumber.equals(syscoLabUI.getText(routeElement)) || routeNumber.equals(syscoLabUI.getText(routeElement).split(" ")[3])){
                return syscoLabUI.findElement(routeElement, By.xpath("./parent::tr"));
            }
        }
        return null;
    }

    public String getRouteNumberInFirstRouteElement(){
        syscoLabUI.sleep(3);
        waitTillLoadingSpinnerIsDisappear();
        List<WebElement> routeElementList = syscoLabUI.findElements(trRoutes);
        for (WebElement routeElement : routeElementList){
            if (syscoLabUI.getText(routeElement).contains(" ")){
                return syscoLabUI.getText(routeElement).split(" ")[3];
            }
            return syscoLabUI.getText(routeElement);
        }
        return null;
    }

    public void clickViewRouteStops(String routeNumber){
        syscoLabUI.sleep(3);
        WebElement routeRow = getRouteElement(routeNumber);
        syscoLabUI.click(routeRow, By.xpath(".//i[@title='View Route Stops']"));
        syscoLabUI.sleep(3);
    }

    public int getRouteStopsCountInRouteDetails(String routeNumber){
        WebElement routeRow = getRouteElement(routeNumber);
        return Integer.valueOf(syscoLabUI.getText(syscoLabUI.findElement(routeRow, By.xpath("./td[@class=\"Stops\"]"))));
    }

    public int getRouteStopsCountInRoute(){
        syscoLabUI.sleep(5);
        List<WebElement> routeStopElements = syscoLabUI.findElements(By.xpath("//td[@class='RouteNumber']/following::td[@data-column-id=\"Stop\"]"));
        int size = routeStopElements.size();
        for (WebElement routeStopElement : routeStopElements){
            if (syscoLabUI.getText(routeStopElement).trim().equals("Dispatch") || syscoLabUI.getText(routeStopElement).trim().equals("Return")){
                size--;
            }
        }

//        Iterator<WebElement> iterator = routeStopElements.iterator();
//        for (iterator = routeStopElements.iterator(); iterator.hasNext(); ) {
//            WebElement routeStopElement = iterator.next();
//            if (syscoLabUI.getText(routeStopElement).trim().equals("Dispatch") || syscoLabUI.getText(routeStopElement).trim().equals("Return")){
//                iterator.remove();
//            }
//        }

//        return Iterators.size(iterator);
        return size;
    }

    public WebElement getRouteStopElement(String stopNumber){
//        WebElement routeRow = getRouteElement(routeNumber);
//        syscoLabUI.findElements(routeRow, By.xpath(".//td[@class='RouteNumber']/following::td[@data-column-id=\"Stop\"]"));

        List<WebElement> routeStopElements = syscoLabUI.findElements(By.xpath("//td[@class='RouteNumber']/following::td[@data-column-id=\"Stop\"]"));
        for (WebElement routeStopElement : routeStopElements){
            if (stopNumber.equals(syscoLabUI.getText(routeStopElement).trim())){
                return routeStopElement;
            }
        }
//        syscoLabUI.findElements(routeRow, By.xpath(".//td[@class='RouteNumber']/following::td[@data-column-id=\"Stop\"]"));
    return null;
    }

    public void clickStopActivityLog(String stopName){
        WebElement stopActivityRow = getRouteStopElement(stopName);
        syscoLabUI.click(stopActivityRow, By.xpath("./following::i[@title=\"View Stop Activity Log\"]"));
        syscoLabUI.sleep(4);
    }

    public void setStopActivityComment(String routeStopName, String comment){
        WebElement stopActivityRow = getRouteStopElement(routeStopName);
        syscoLabUI.sendKeys((syscoLabUI.findElement(stopActivityRow, By.xpath("./following::textarea[@class=\"stop-comment\"]"))), comment);
    }

    public void clickExportToExcel(){
        syscoLabUI.click(btnExportToExcel);
    }

    public void clickColumnOption() {
        syscoLabUI.click(btnColumnOption);
    }

    public void selectRoutesAvailableColumn(String columnName) {
        syscoLabUI.sleep(2);
        syscoLabUI.select(ddAvailableColumn, columnName);
    }

    public String getSelectedColumnValues() {
        syscoLabUI.sleep(3);
        return syscoLabUI.getText(ddAvailableColumn);
    }

    public void clickMoveToSelectedColumn() {
        syscoLabUI.sleep(2);
        syscoLabUI.click(btnRouteTrackerMoveToSelectedColumns);
    }

    public void clickMoveToAvailableColumn() {
        syscoLabUI.click(btnRouteTrackerMoveToAvailableColumns);
    }


    //td[@class='RouteNumber']/parent::tr
}
