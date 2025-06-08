package com.testng.pages;

import com.training.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyProfilePage extends BasePage {

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    Actions act = new Actions(driver);

    JavascriptExecutor js = (JavascriptExecutor) driver;


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

    @FindBy(xpath = "//span[normalize-space()='File']")
    WebElement fileLink;

    @FindBy(xpath = "//a[@id='chatterUploadFileAction']")
    WebElement uploadFileFromYourComputerLink;

    @FindBy(xpath = "//form[@id='chatterFileForm']//input[@type='file']")
    WebElement chooseFileButton;

    @FindBy(xpath = "//*[@id=\"j_id0:uploadFileForm:uploadBtn\"]")
    WebElement saveButtonOfUploadFile;

    @FindBy(xpath = "//input[@class='fileInput']")
    WebElement photoChooseFileButton;

    @FindBy(xpath = "//*[@id=\"j_id0:outer\"]/div[1]/div/div/div/div[5]")
    WebElement cropPhotoBox;

    @FindBy(id = "j_id0:j_id7:save")
    WebElement saveButtonAfterCropPhoto;


    public WebElement getAboutTab() {
        return aboutTab;
    }

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


    public void switchToPostLinkIframe() {
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
        driver.navigate().refresh();
        waitForElement(fileLink, 10);
        fileLink.click();
    }

    public void clickOnUploadFileFromComputer() {
        uploadFileFromYourComputerLink.click();
    }

    public void clickOnChooseFile() {
        waitForElement(chooseFileButton, 10);
        chooseFileButton.sendKeys("/Users/nikita/DemoUploadFile.txt");

        //act.moveToElement(chooseFileButton).click().build().perform();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20).getSeconds());
    }

    public void clickOnAddPhotoLink() {
        driver.navigate().refresh();
        waitForElement(addLink, 10);
        //addLink.sendKeys("/Users/nikita/Downloads/8E94F2AC-A4B0-4FF4-85B8-B3AE9CBAE7CC_1_105_c.jpeg");
        act.moveToElement(addLink).click().build().perform();


    }


    public void uploadPhotoFromSystem() {
        waitForElement(photoChooseFileButton, 10);
        //photoChooseFileButton.sendKeys("/Users/nikita/Downloads/8E94F2AC-A4B0-4FF4-85B8-B3AE9CBAE7CC_1_105_c.jpeg");
        //act.moveToElement(photoChooseFileButton).click().build().perform();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        photoChooseFileButton.sendKeys("/Users/nikita/Downloads/8E94F2AC-A4B0-4FF4-85B8-B3AE9CBAE7CC_1_105_c.jpeg");

    }


    public void clickOnSaveButtonRelatedToPhotoUpload() {
        waitForElement(saveButtonOfUploadFile, 10);
        //saveButtonOfUploadFile.click();
        js.executeScript("arguments[0].click();", saveButtonOfUploadFile);
    }

    public void cropThePicture()
    {
        waitForElement(cropPhotoBox,20);
        act.dragAndDropBy(cropPhotoBox, 100, 100).perform();
        saveButtonAfterCropPhoto.click();

    }



}
