package com.testng.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.testng.log.Log;
import com.testng.pages.HomePage;
import com.testng.pages.LoginPage;
import com.testng.utilities.ScreenShot;
import com.training.base.BaseTest;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseTest{

    WebDriver driver;
    LoginPage loginPage ;
    HomePage homepage;
    ScreenShot screenshot;

    @BeforeMethod
    public void beforeMethod() {
        driver=launchapplication();
        loginPage = new LoginPage(driver);
        homepage = new HomePage(driver);
        screenshot = new ScreenShot();
        DOMConfigurator.configure("log4j.xml");
    }


    @Test(priority=1)
    public void loginwithValidusernameandpassword() {
        Log.startTestCase("Testing case valid username started");
        loginPage.enterintoEmail();
        loginPage.enterintoPassword("Cme@2025");
        Log.info("Username entered sucessfully");
        loginPage.ClickonLoginButton();


    }

    @Test(priority=2)
    public void loginwithValidusernameandInvalidpassword() {
        loginPage.enterintoEmail();
        loginPage.enterintoPassword("admin1234");
        loginPage.ClickonLoginButton();
    }


    @AfterMethod
    public void teardown() {
        screenshot.takescreenshot(driver);
        closebrowser();

    }

}