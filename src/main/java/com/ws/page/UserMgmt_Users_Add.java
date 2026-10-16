package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserMgmt_Users_Add extends DriverScript {
    @FindBy(xpath="//font[text()='Add User']")
    private WebElement addUserHeader;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement saveButton;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
    private WebElement cancelButton;
    @FindBy(xpath="//div[contains(@class,'oxd-select-text-input')][1]")
    private WebElement userRoleDropdown;
    @FindBy(xpath="//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;
    @FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]")
    private WebElement statusDropdown;
    @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement usernameInput;
    @FindBy(xpath="(//input[@type='password'])[1]")
    private WebElement passwordInput;
    @FindBy(xpath="(//input[@type='password'])[2]")
    private WebElement confirmPasswordInput;
    @FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private List<WebElement> errorMessages;


    public UserMgmt_Users_Add(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAddUserHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addUserHeader));
        return addUserHeader.getText();
    }

    public void fillAddUserForm(String userRole, String employeeName, String username, String password, String confirmPassword) {
        selectDropdownOption("User Role", userRole);

        WebElement employeeNameField = driver.findElement(By.xpath("//label[normalize-space()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
        employeeNameField.clear();
        employeeNameField.sendKeys(employeeName);

        WebElement suggestion = driver.findElement(By.xpath("//div[@role='option' and contains(normalize-space(.), '" + employeeName + "')]"));
        suggestion.click();

        WebElement usernameField = driver.findElement(By.xpath("//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
        usernameField.clear();
        usernameField.sendKeys(username);

        selectDropdownOption("Status", "Enabled");

        WebElement passwordField = driver.findElement(By.xpath("//label[normalize-space()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement confirmPasswordField = driver.findElement(By.xpath("//label[normalize-space()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input[@type='password']"));
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword);
    }

    private void selectDropdownOption(String labelText, String optionText) {
        WebElement dropdown = driver.findElement(By.xpath("//label[normalize-space()='" + labelText + "']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]"));
        dropdown.click();

        WebElement option = driver.findElement(By.xpath("//div[@role='option' and normalize-space()='" + optionText + "']"));
        option.click();
    }

    public boolean validateErrorMessages() {
        String[] expectedErrorMessages = {"Required", "Required", "Required", "Required", "Required", "Passwords do not match"};
        boolean flag = true;
        for (int i = 0; i < expectedErrorMessages.length; i++) {
            String actualErrorMessage = errorMessages.get(i).getText();
            if (!actualErrorMessage.equals(expectedErrorMessages[i])) {
                System.out.println("Error message mismatch at index " + i + ": expected '" + expectedErrorMessages[i] + "', but got '" + actualErrorMessage + "'");
                flag = false;
            } else {
                System.out.println("Error Messages are as expected at index " + i + ": '" + expectedErrorMessages[i] + "'");
            }
        }
        return flag;
    }

    public void clickSaveButton() {
      WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(saveButton));
      saveButton.click();

    }

    public boolean isSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-toast oxd-toast--success')]"))).isDisplayed();
    }

    public void clickCancelButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButton.click();
    }
}
