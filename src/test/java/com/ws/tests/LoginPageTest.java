package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
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
}
