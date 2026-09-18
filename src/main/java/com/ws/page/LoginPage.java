package com.ws.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(.,'Forgot your password?')]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement invalidCredentialsError;

    @FindBy(xpath = "//span[text()='Required']")
    private WebElement requiredValidationMessage;

    @FindBy(xpath = "//img[@alt='company-branding']")
    private WebElement brandLogo;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isLoginPageDisplayed() {
        return usernameInput.isDisplayed() && passwordInput.isDisplayed() && loginButton.isDisplayed();
    }

    public String getForgotPasswordText() {
        return forgotPasswordLink.getText();
    }

    public String getInvalidCredentialsMessage() {
        return invalidCredentialsError.getText();
    }

    public boolean isInvalidCredentialsMessageDisplayed() {
        return invalidCredentialsError.isDisplayed() && getInvalidCredentialsMessage().toLowerCase().contains("invalid credentials");
    }

    public boolean isRequiredValidationDisplayed() {
        return requiredValidationMessage.isDisplayed() && requiredValidationMessage.getText().equals("Required");
    }

    public boolean isBrandLogoDisplayed() {
        return brandLogo.isDisplayed();
    }
}
