package com.testng.pages;

import com.training.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


public class UserMenuPage extends BasePage{

    public UserMenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy ( xpath="//div[@id='userNavButton']")
    WebElement userMenu ;

    @FindBy(id="userNav-menuItems")
   WebElement userMenuDropDown;

    @FindBy(xpath="//div[@id='userNav-menuItems']/a")
    List<WebElement> userMenuDropDownOptions;

    public void selectUserMenu()
    {
        waitForElement(userMenu,10);
        userMenu.click();
    }


    public boolean isUserMenuDropDownDisplayed()
    {
        return userMenuDropDown.isDisplayed();
    }


    public List<String> getDropDownOptions()
    {
        waitForElement(userMenuDropDown,10);
        return userMenuDropDownOptions.stream().map(e -> e.getText().trim()).collect(Collectors.toList());
    }



}
