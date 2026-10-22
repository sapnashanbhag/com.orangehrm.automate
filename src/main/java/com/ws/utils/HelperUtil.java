package com.ws.utils;

import com.ws.driver.DriverScript;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class HelperUtil extends DriverScript {
    public static String captureScreenshot(WebDriver driver) throws IOException {
       File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       String screenshotPath = System.getProperty("user.dir")+"./src/test/resources/testreports/screenshots/screen_"+System.currentTimeMillis()+".png";
       FileHandler.copy(src, new File(screenshotPath));
       return screenshotPath;
    }
}
