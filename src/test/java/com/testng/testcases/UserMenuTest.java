package com.testng.testcases;

import com.testng.log.Log;
import com.testng.pages.HomePage;
import com.testng.pages.LoginPage;
import com.testng.pages.UserMenuPage;
import com.testng.utilities.ScreenShot;
import com.training.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;


public class UserMenuTest extends BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    UserMenuPage userMenuPage;
    ScreenShot screenshot;

    @BeforeMethod
    public void beforeMethod() {
        driver = launchapplication();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        userMenuPage = new UserMenuPage(driver);
        screenshot = new ScreenShot();
    }

    @Test
    public void validateUserMenuDropDown() {
        loginPage.enterintoEmail();
        loginPage.enterintoPassword("Cme@2025");
        Log.info("Username entered successfully");
        loginPage.ClickonLoginButton();
        userMenuPage.selectUserMenu();
        Assert.assertTrue(userMenuPage.isUserMenuDropDownDisplayed());
        List<String> expectedOptions = List.of(
                "My Profile",
                "My Settings",
                "Developer Console",
                "Switch to Lightning Experience",
                "Logout"
        );
        Assert.assertEquals(userMenuPage.getDropDownOptions(), expectedOptions);
    }

    @AfterMethod
    public void teardown() {
        screenshot.takescreenshot(driver);
        closebrowser();

    }

}
