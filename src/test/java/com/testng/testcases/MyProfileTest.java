package com.testng.testcases;

import com.testng.log.Log;
import com.testng.pages.HomePage;
import com.testng.pages.LoginPage;
import com.testng.pages.MyProfilePage;
import com.testng.pages.UserMenuPage;
import com.testng.utilities.ScreenShot;
import com.training.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyProfileTest extends BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    UserMenuPage userMenuPage;
    MyProfilePage myProfilePage;
    ScreenShot screenshot;

    @BeforeMethod
    public void beforeMethod() {
        driver = launchapplication();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        userMenuPage = new UserMenuPage(driver);
        myProfilePage = new MyProfilePage(driver);
        screenshot = new ScreenShot();
    }


    @Test
    public void selectMyProfileOptionFromUserMenuDropDown() {
        loginPage.enterintoEmail();
        loginPage.enterintoPassword("Cme@2025");
        Log.info("Username entered successfully");
        loginPage.ClickonLoginButton();
        userMenuPage.selectUserMenu();
        myProfilePage.selectMyProfileOption();
        myProfilePage.clickOnEditProfileButton();
        myProfilePage.switchToIframe("contactInfoContentId");
        myProfilePage.navigateToTheAboutSection();
        myProfilePage.clickOnLastName();
        myProfilePage.clickOnSaveAll();
        myProfilePage.switchToDefaultContent();
        myProfilePage.clickOnPostLink();
        myProfilePage.switchToPostLinkIframe();
        myProfilePage.enterTextInsideIFrameBody();
        myProfilePage.switchToDefaultContent();
        myProfilePage.clickOnShareButton();
        myProfilePage.clickOnFileLink();
        myProfilePage.clickOnUploadFileFromComputer();
        myProfilePage.clickOnChooseFile();
        myProfilePage.clickOnShareButton();
        myProfilePage.clickOnAddPhotoLink();
        myProfilePage.switchToIframe("uploadPhotoContentId");
        myProfilePage.uploadPhotoFromSystem();
        myProfilePage.clickOnSaveButtonRelatedToPhotoUpload();
        myProfilePage.cropThePicture();

        //myProfilePage.switchToDefaultContent();


    }
}
