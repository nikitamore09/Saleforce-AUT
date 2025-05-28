package com.testng.pages;

import com.training.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="username")
    WebElement email;


    @FindBy(id="password")
    WebElement password;

    @FindBy(xpath="//*[@id=\"Login\"]")
    WebElement loginbutton;

    public void enterintoEmail() {
        email.sendKeys("nikmore.888501@agentforce.com");
    }

    public void enterintoPassword(String strpassword) {
        password.sendKeys(strpassword);
    }


    public void ClickonLoginButton() {
        loginbutton.click();
    }




}