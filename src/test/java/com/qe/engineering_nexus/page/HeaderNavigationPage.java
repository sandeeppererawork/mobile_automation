package com.qe.engineering_nexus.page;

import org.openqa.selenium.By;

public class HeaderNavigationPage extends LoginPage{

    By lnkRoute = By.xpath("//a[text()='Route']");
    By lnkManager = By.xpath("//a[text()='Manager']");

    public void clickRoute(){
        syscoLabUI.click(lnkRoute);
        syscoLabUI.sleep(2);
    }

    public void clickManager(){
        syscoLabUI.click(lnkManager);
    }
}
