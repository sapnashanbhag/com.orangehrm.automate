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
import java.util.Set;

public class UserManagement_UsersPage extends DriverScript {
    //Step1: Identify the elements on the page using @FindBy annotation
    @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement usernameInput;
    @FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
    private WebElement userRoleDropdown;
    @FindBy(xpath="//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;
    @FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]")
    private WebElement statusDropdown;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
    private WebElement resetButton;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private WebElement searchButton;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;
    @FindBy(xpath="//i[@class='oxd-icon bi-trash']")
    private List<WebElement> deleteButton;
    @FindBy(xpath="//i[@class='oxd-icon bi-pencil-fill']")
    private List<WebElement> editButton;
    @FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[1]")
    private WebElement usersManagementTab;
    @FindBy(xpath="//h5[text()='System Users']")
    private WebElement systemUsersHeader;
    @FindBy(xpath="//div[@role='document']")
    private WebElement deleteConfirmationAlert;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    private WebElement deleteConfirmationButton;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost orangehrm-button-margin']")
    private WebElement deleteCancelButton;
    @FindBy(xpath="//div[@class='oxd-table-header']//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th']")
    private List<WebElement> tableHeaders;
    @FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
    private WebElement recordsfoundMessage;
    @FindBy(xpath="//a[contains(text(),'OrangeHRM')]")
    private WebElement orangeHRMLink;


    //Step2: Create a constructor to initialize the elements using PageFactory
    public UserManagement_UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOrangeHRMLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(orangeHRMLink));
        String parentwindowhandle = driver.getWindowHandle();
        orangeHRMLink.click();
        Set<String> windowhandles = driver.getWindowHandles();
        for (String handle : windowhandles) {
            if (!handle.equals(parentwindowhandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }



    }

    public String getPageHeaderText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(systemUsersHeader));
        return systemUsersHeader.getText();
    }
    public void clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }
    public boolean isSearchResultsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(recordsfoundMessage));
            return recordsfoundMessage.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSearchFormCleared() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
           // wait.until(ExpectedConditions.visibilityOf(usernameInput));
            String usernameValue = usernameInput.getAttribute("value");
            String employeeNameValue = employeeNameInput.getAttribute("value");
            String statusValue = statusDropdown.getAttribute("value");
            String userRoleValue = userRoleDropdown.getAttribute("value");
            System.out.println("Username: " + usernameValue);
            System.out.println("Employee Name: " + employeeNameValue);
            System.out.println("Status: " + statusValue);
            System.out.println("User Role: " + userRoleValue);
            return usernameInput.getAttribute("value").equals("") &&
                    employeeNameInput.getAttribute("value").equals("") &&
                     statusDropdown.getAttribute("value") == null &&
                    userRoleDropdown.getAttribute("value") == null;


        }
        catch (Exception e) {
            System.out.println("Exception occurred while checking if the search form is cleared: " + e.getMessage());
            return false;


        }
    }


    public void clickResetButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(resetButton));
        usernameInput.sendKeys("Admin");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.elementToBeClickable(employeeNameInput));
        employeeNameInput.sendKeys("Ran");
        WebElement suggestion = driver.findElement(By.xpath("//div[@role='option' and contains(normalize-space(.), 'Ranga Akunuri')]"));
        suggestion.click();


        Thread.sleep(1000);
        statusDropdown.click();
        WebElement option = driver.findElement(By.xpath("//div[@role='option' and normalize-space()='Enabled']"));
        option.click();
        Thread.sleep(1000);
        userRoleDropdown.click();
        WebElement option1 = driver.findElement(By.xpath("//div[@role='option' and normalize-space()='Admin']"));
        option1.click();
        Thread.sleep(1000);
        resetButton.click();
        Thread.sleep(1000);
    }
    public void clickAddButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }
    //this is a dynamic xpath to click the delete button for a specific user based on the username
    //this method will find the delete button for the user with the given username and click it
    public void clickDeleteButton(String username) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = driver.findElement(
                By.xpath("//div[contains(@class,'oxd-table-card')]" +
                        "[.//div[contains(@class,'oxd-table-cell')]" +
                        "//div[text()='" + username + "']]" +
                        "//button[.//i[contains(@class,'bi-trash')]]")
        );
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
        Thread.sleep(1000);
    }

    public boolean isDeleteConfirmationDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(deleteConfirmationAlert));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickDeleteConfirmationButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmationButton));
        deleteConfirmationButton.click();
    }
    public void clickDeleteCancelButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deleteCancelButton));
        deleteCancelButton.click();
    }
    public void checkDeletedRecordNotDisplayed(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='oxd-table-card']//div[text()='" + username + "']")));
            System.out.println("Record with username '" + username + "' is not displayed in the list.");
        } catch (Exception e) {
            System.out.println("Record with username '" + username + "' is still displayed in the list.");
        }
    }

    public boolean isUserDisplayed(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table-card']//div[text()='" + username + "']")));
            System.out.println("User with username '" + username + "' is displayed in the list.");
            return true;
        } catch (Exception e) {
            System.out.println("User with username '" + username + "' is not displayed in the list.");
            return false;
        }
    }

    public boolean checkTableHeaders(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String[] expectedHeaders = {
                "","Username", "User Role", "Employee Name", "Status", "Actions"
        };
        boolean flag = true;
        for (int i=0; i < expectedHeaders.length; i++) {
                String actualHeaderText = tableHeaders.get(i).getText();
                if (!actualHeaderText.equals(expectedHeaders[i])) {
                    System.out.println("Header mismatch at index " + i + ": expected '" + expectedHeaders[i] + "', but found '" + actualHeaderText + "'");
                    flag = false;
                }
            else {
                System.out.println("Header at index " + i + ": expected '" + expectedHeaders[i] + "'");
            }

            System.out.println("Table Header: " + actualHeaderText);
        }
        return flag;
    }
}
