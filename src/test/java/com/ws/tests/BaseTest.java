package com.ws.tests;

import com.ws.driver.DriverScript;
import com.ws.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private DriverScript driverScript;
   public WebDriver driver;
    public LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
       driverScript = new DriverScript();
       driver = driverScript.launchBrowser();
       loginPage = new LoginPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
