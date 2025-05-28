package com.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver) {
        super(driver);
    }




    @FindBy(xpath="//a[text()='Home']")
    WebElement HomeTab;

    @FindBy(id="name")
    WebElement firstName;

    public void ClickOnHomeTab() {
        waitForElement(HomeTab,2);
        HomeTab.click();
    }

    public void enterIntoFirstName(String strFirstName) {
        firstName.sendKeys(strFirstName);
    }


}