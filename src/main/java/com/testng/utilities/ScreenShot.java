package com.testng.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

    public void takescreenshot(WebDriver driver) {

        //Takescreenshot object is created using the driver
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        //screenshot object have a method getScreenShotAs
        //Convert the Takescreenshot Object to FIle Object
        File srcFile =screenshot.getScreenshotAs(OutputType.FILE);

        Date currentDate = new Date();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);

        //Create a image format - png
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath+"//screenshots//salesforce"+timestamp+".png";

        //Create an File Object to store the screenshot
        File destfile = new File(filePath);

        try {
            //Usign file utils copy the source object - screenshot - to destination image object
            FileUtils.copyFile(srcFile, destfile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




    }



}