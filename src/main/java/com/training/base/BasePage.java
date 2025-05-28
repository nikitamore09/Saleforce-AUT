package com.training.base;


import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {

    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //driver.findElement(null)
    }

    public void switchToIframe(String iframeAttribute) {
        try {
            driver.switchTo().frame(iframeAttribute);
            System.out.println("Switched to iframe " + iframeAttribute);
        } catch (NoSuchFrameException e) {
            System.err.println("Iframe with ID '" + iframeAttribute + "' not found.");
        }
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        System.out.println("Switched back to default content.");
    }


    public static void switchToChildWindow(WebDriver driver) {
        String parent = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }




    public static void waitForElement(WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

//    public static void waitForElementClickable(WebElement element, int timeInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
}

