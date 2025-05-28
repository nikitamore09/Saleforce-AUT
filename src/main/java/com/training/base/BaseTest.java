package com.training.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testng.utilities.PropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;

    public class BaseTest {

        WebDriver driver;
        PropertiesFile property = new PropertiesFile();

        public WebDriver launchapplication() {
            if(driver==null) {
                String browser =property.getProperty("browser");
                if(browser.equalsIgnoreCase("chrome")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--incognito");
                    driver = new ChromeDriver(options);
                } else if(browser.equalsIgnoreCase("firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }

            }

            String url = property.getProperty("url");
            driver.get(url);
            return driver;
        }

        public void closebrowser() {
            driver.close();
            driver=null;
        }
    }

