package com.testng.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.pages.HomePage;
import com.testng.pages.LoginPage;
import com.testng.utilities.ScreenShot;
import com.training.base.BaseTest;

public class HomeTest extends BaseTest {

    WebDriver driver;
    LoginPage loginpage ;
    HomePage homepage;
    ScreenShot screenshot;

    @BeforeMethod
    public void beforeMethod() {
        driver=launchapplication();
        loginpage = new LoginPage(driver);
        homepage = new HomePage(driver);
        screenshot = new ScreenShot();
    }


    @Test
    public void loginwithValidusernameandpassword() {
        loginpage.enterintoEmail();
        loginpage.enterintoPassword("admin123");
        loginpage.ClickonLoginButton();
        homepage.ClickOnHomeTab();
        homepage.enterIntoFirstName("Nikita");

    }


    @AfterMethod
    public void teardown() {
        screenshot.takescreenshot(driver);
        closebrowser();

    }



}