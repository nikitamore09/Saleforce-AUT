package com.testng.pages;

import com.training.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyProfilePage extends BasePage {

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    //click My Profile Option from userMenu

    @FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[1]")
    WebElement myProfileOption;


    @FindBy(xpath = "//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img")
    WebElement editProfile;

    @FindBy(xpath = "//*[@id=\"aboutTab\"]/a")
    WebElement aboutTab;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")
    WebElement saveAllButton;

    @FindBy(xpath = "//*[@id=\"publishersharebutton\"]")
    WebElement shareButton;

    //*[@id="publisherAttachTextPost"]/span[1]
    @FindBy(xpath = "//ul[@class='publisherFeedItemTypeChoices']/li[@label='TextPost']/a")
    WebElement postLink;


    //Element Inside the Iframe of the Post link
    @FindBy(xpath = "//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
    WebElement postLinkIframe;

    //Element Inside the Iframe of the Post link
    @FindBy(tagName = "body")
    WebElement postLinkText;


    @FindBy(id = "uploadLink")
    WebElement addLink;

    @FindBy(xpath = "//span[@class='publisherattachtext']")
    WebElement fileLink;

    //select my profile option
    public void selectMyProfileOption() {
        myProfileOption.click();
    }

    //click on edit profile
    public void clickOnEditProfileButton() {
        editProfile.click();
    }

//    //switch to child window
//    public void switchToChildWindow() {
//        BasePage.switchToChildWindow(driver);
//    }

    //Navigate to the About Section
    public void navigateToTheAboutSection() {
        aboutTab.click();
    }

    //click on
    public void clickOnLastName() {
        lastName.click();
        lastName.sendKeys("MR");
    }


    public void clickOnSaveAll() {
        saveAllButton.click();
    }


    public void clickOnPostLink() {
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20).getSeconds());

        //By postLinkLocator = By.id("publisherAttachTextPost");

        // Always re-locate at runtime to avoid stale element
        // WebElement postLink = wait.until(ExpectedConditions.elementToBeClickable(postLink));
        postLink.click();
        //postLink.click();
    }


    public void switchToPostLinkIframe(){
        waitForElement(postLinkIframe, 25);
        driver.switchTo().frame(postLinkIframe);
    }


    public void enterTextInsideIFrameBody() {
        waitForElement(postLinkText, 10);
        postLinkText.clear(); // Optional: clear existing content
        postLinkText.sendKeys("Entered Inside Iframe");
    }


    public void clickOnShareButton() {
        waitForElement(shareButton, 10);
        shareButton.click();
    }

    public void clickOnFileLink() {
        fileLink.click();
    }

    public void clickOnAddPhotoLink() {
        addLink.click();
    }


    //Click on edit profile button to edit contact info
    //click on about tab


}
