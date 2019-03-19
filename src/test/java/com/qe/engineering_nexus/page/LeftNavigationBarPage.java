package com.qe.engineering_nexus.page;

import org.openqa.selenium.By;

public class LeftNavigationBarPage extends LoginPage{

    By lnkApplication = By.xpath("//a[text()='Applications']");
    By lnkRouteTracker = By.xpath("//a[text()='Route Tracker']");

    public void clickApplication(){
        syscoLabUI.mouseHover(lnkApplication);
        syscoLabUI.sleep(2);
    }

    public void clickRouteTracker(){
        syscoLabUI.mouseHover(lnkRouteTracker);

        syscoLabUI.getAttribute(lnkRouteTracker, "href");
        syscoLabUI.navigateTo("http://myoo9115:Perp@2010@sygmaatm.sygma.na.sysco.net/RouteTracker");
//        syscoLabUI.clickWithJavascript(lnkRouteTracker);
    }
}
