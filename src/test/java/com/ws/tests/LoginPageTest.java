package com.ws.tests;

import com.ws.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class LoginPageTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() throws Exception {
        String filePath = "./src/test/resources/testdata/data.xlsx";
        String sheetName = "Sheet1";
        ExcelUtil excelUtil = new ExcelUtil(filePath);
        int rowCount = excelUtil.getRowCount(sheetName);
        int columnCount = excelUtil.getColumnCount(sheetName, 0); // Assuming first row has all columns
        Object[][] data = new Object[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data[i][j] = excelUtil.getCellData(sheetName, i, j);
            }
        }
        return data;
    }
    @Test(groups={"regression"},dataProvider = "loginData")
    public void loginWithValidCredentialsfromExcel(String username, String password) {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");

        loginPage.login(username, password);

        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"), "Login was unsuccessful");
    }


    @Test(groups={"regression"})
    public void loginWithValidCredentials() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");

        loginPage.login("Admin", "admin123");

        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"), "Login was unsuccessful");
    }

    @Test
    public void loginWithInvalidCredentials() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");

        loginPage.login("Admin", "wrongpassword");

        Assert.assertTrue(loginPage.isInvalidCredentialsMessageDisplayed(), "Expected invalid credentials message was not displayed");
        Assert.assertTrue(loginPage.getInvalidCredentialsMessage().toLowerCase().contains("invalid credentials"), "Expected 'Invalid credentials' text to be displayed");
    }

    @Test
    public void loginWithBlankUsernameAndPassword() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");

        loginPage.login("", "");

        Assert.assertTrue(loginPage.isRequiredValidationDisplayed(), "Expected 'Required' message below the input boxes");
    }

    @Test
    public void brandLogoIsDisplayedOnLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed");
        Assert.assertTrue(loginPage.isBrandLogoDisplayed(), "OrangeHRM brand logo is not displayed");
    }

    @Test
    public void clickHRMLink(){
        loginPage.clickHRMLink();
        String hrmlinkurl = driver.getWindowHandle();
        System.out.println("Current window handle: " + hrmlinkurl);
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("All window handles: " + allWindows);
        Iterator<String> iterator = allWindows.iterator();
        while (iterator.hasNext()) {
            String window = iterator.next();
            System.out.println("Window handle: " + window);
            if (!window.equals(hrmlinkurl)) {
                driver.switchTo().window(window);
                System.out.println("Current window handle: " + driver.getWindowHandle());
                System.out.println("current window title: " + driver.getTitle());
                System.out.println("current window url: " + driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("https://orangehrm.com"),
                        "OrangeHRM website was not opened in a new tab");
            }
        }


    }

}
