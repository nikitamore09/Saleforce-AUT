package com.testng.pages;

import com.training.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.training.base.BasePage.driver;

public class OpportunitiesPage  extends BasePage {

        //call the constructor
    OpportunitiesPage(WebDriver driver)
    {
        //call the constructor of the Parent Class
        super(driver);
    }

    @FindBy (id = "Opportunity_Tab" )
    WebElement oppoLink;


    public void selectOppoTab()
    {
        oppoLink.click();
    }



}
