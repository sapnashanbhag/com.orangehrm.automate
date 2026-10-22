package com.ws.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ws.driver.DriverScript;
import com.ws.page.LoginPage;
import com.ws.utils.HelperUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {
    private DriverScript driverScript;
    public WebDriver driver;
    public LoginPage loginPage;
    public static ExtentReports extentReports;
    public static ExtentTest logger;

    @BeforeSuite(alwaysRun = true)
    public void setupReport(){
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(
                "F:/SeleniumTraining/seleniumworkspace/com.orangehrm.automate/src/test/resources/testreports/ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
       driverScript = new DriverScript();
       driver = driverScript.launchBrowser();
       loginPage = new LoginPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.FAILURE) {
            logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(HelperUtil.captureScreenshot(driver)).build());

        }


        if (driver != null) {
            Thread.sleep(2000);
            extentReports.flush();
            driver.quit();
        }
    }
}
