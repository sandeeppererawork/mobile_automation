package com.qe.engineering_nexus.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends LoginPage {

    By paneProduct = By.xpath("//*[@class='product-image-container']");

    public WebElement getProductElement(String productName) {
        List<WebElement> productElements = syscoLabUI.findElements(paneProduct);
        for (WebElement productElement : productElements) {
            if (productName.equals(syscoLabUI.getText(syscoLabUI.findElement(productElement, By.xpath("./../following-sibling::div//a[@class=\"product-name\"]"))).trim())) {
                return syscoLabUI.findElement(productElement, By.xpath("./../following-sibling::div//a[@class=\"product-name\"]"));
            }
        }
        return null;
    }

    public void clickProduct(String productName) {
        WebElement productElement = getProductElement(productName);
        syscoLabUI.sleep(5);
        syscoLabUI.mouseHover(productElement);
        syscoLabUI.sleep(2);
        syscoLabUI.click(productElement);
    }
}
