package com.ws.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class DriverScript {
    public static WebDriver driver;
    Properties prop;

    // Constructor to load the config.properties file
    public DriverScript(){
        try{
            File file = new File("./src/test/resources/config/config.properties");
            FileInputStream fis = new FileInputStream(file);
            prop = new Properties();
            prop.load(fis);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error loading config.properties file: " + e.getMessage());
        }
    }

    public WebDriver launchBrowser()
    {
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        else{
            throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(prop.getProperty("url"));
        return driver;
    }

    public void closeBrowser()
    {
        if(driver != null){
            driver.quit();
        }
    }
}
