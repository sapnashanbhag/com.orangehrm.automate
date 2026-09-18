package com.ws.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
    private final WebDriver driver;

    @FindBy(xpath = "//h6[normalize-space()='Admin']")
    private WebElement adminHeader;

    @FindBy(xpath = "//h6[normalize-space()='User Management']")
    private WebElement userManagementHeader;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//div[contains(@class,'orangehrm-paper-container')]")
    private WebElement tableHeaderContainer;

    @FindBy(xpath = "//nav[contains(@aria-label,'pagination')]//*[self::button or self::a] | //button[contains(@aria-label,'page') or normalize-space()='Next' or normalize-space()='Previous'] | //a[contains(@aria-label,'page') or normalize-space()='Next' or normalize-space()='Previous']")
    private List<WebElement> paginationControls;

    @FindBy(xpath = "//button[normalize-space()='Next' or contains(@aria-label,'next page') or contains(@class,'next')] | //a[normalize-space()='Next' or contains(@aria-label,'next page') or contains(@class,'next')]")
    private WebElement nextPageButton;

    @FindBy(xpath = "//button[normalize-space()='Previous' or contains(@aria-label,'previous page') or contains(@class,'previous')] | //a[normalize-space()='Previous' or contains(@aria-label,'previous page') or contains(@class,'previous')]")
    private WebElement previousPageButton;

    @FindBy(xpath="//h6[text()='Add User']") private WebElement addUserFormHeader;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText() {
        return adminHeader.getText();
    }

    public boolean isAdminPageDisplayed() {
        return adminHeader.isDisplayed() && userManagementHeader.isDisplayed();
    }

    public boolean isAddButtonDisplayed() {
        return addButton.isDisplayed();
    }

    public boolean isSearchFormDisplayed() {
        return usernameInput.isDisplayed() && employeeNameInput.isDisplayed() && searchButton.isDisplayed();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public boolean isAddUserFormDisplayed() {
        return addUserFormHeader.isDisplayed();
    }

    public void searchUser(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        searchButton.click();
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

    public void clickSaveButton() {
        saveButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElements(By.xpath("//*[contains(@class,'oxd-toast') and contains(normalize-space(.), 'Successfully Saved')] | //p[contains(normalize-space(.), 'Successfully Saved')]" )).size() > 0;
    }

    private void selectDropdownOption(String labelText, String optionText) {
        WebElement dropdown = driver.findElement(By.xpath("//label[normalize-space()='" + labelText + "']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]"));
        dropdown.click();

        WebElement option = driver.findElement(By.xpath("//div[@role='option' and normalize-space()='" + optionText + "']"));
        option.click();
    }

    public String getTableHeaderText() {
        return tableHeaderContainer.getText();
    }

    public boolean isPaginationDisplayed() {
        return !paginationControls.isEmpty();
    }

    public void clickNextPage() {
        if (nextPageButton.isDisplayed() && nextPageButton.isEnabled()) {
            nextPageButton.click();
        }
    }

    public void clickPreviousPage() {
        if (previousPageButton.isDisplayed() && previousPageButton.isEnabled()) {
            previousPageButton.click();
        }
    }

    public void clickPageNumber(int pageNumber) {
        for (WebElement pageButton : paginationControls) {
            String buttonText = pageButton.getText().trim();
            if (buttonText.equals(String.valueOf(pageNumber))) {
                pageButton.click();
                return;
            }
        }
    }

    public int getPaginationPageCount() {
        return paginationControls.size();
    }
}
