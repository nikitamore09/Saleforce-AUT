package com.testng.testcases;

import com.testng.pages.HomePage;
import com.testng.pages.LoginPage;
import com.testng.pages.MyProfilePage;
import com.testng.pages.UserMenuPage;
import com.testng.utilities.ScreenShot;
import com.training.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class OpportunitiesTest extends BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ScreenShot screenshot;

    @BeforeMethod
    public void beforeMethod() {
        driver = launchapplication();
        loginPage = new LoginPage(driver);
        screenshot = new ScreenShot();
    }





}

