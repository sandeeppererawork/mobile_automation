package com.qe.engineering_nexus.page;

import org.openqa.selenium.By;

public class HeaderNavigationPage extends LoginPage{

    By imgMainLogo = By.xpath("//*[@id='header_logo']/a");

    public void clickMainLogo(){
        syscoLabUI.waitTillElementLoaded(imgMainLogo);
        syscoLabUI.sleep(5);
        syscoLabUI.click(imgMainLogo);
        syscoLabUI.sleep(2);
    }

}
