package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Admin_Job_EmpStatusPage extends DriverScript {
    @FindBy(xpath="//a[text()='Employment Status']") private WebElement employmentStatusLink;
    @FindBy(xpath="//h6[text()='Employment Status']") private WebElement employmentStatusHeader;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']") private WebElement addEmpStatusButton;
    @FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space']//i[@class='oxd-icon bi-pencil-fill'])[1]") private WebElement EditEmpStatusButton;
    @FindBy(xpath="(//i[@class='oxd-icon bi-trash'])[1]") private WebElement deleteEmpStatusButton;
    @FindBy(xpath="//h6[text()='Add Employment Status']") private WebElement addEmpStatusHeader;
    @FindBy(xpath="//h6[text()='Edit Employment Status']") private WebElement editEmpStatusHeader;
    @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]") private WebElement empStatusNameInput;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']") private WebElement saveButton;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']") private WebElement cancelButton;
    @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]") private WebElement empStatusNameInputField;
    @FindBy(xpath="//button[contains(@class,'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space')]") private WebElement saveeditedEmpStatusButton;
    public Admin_Job_EmpStatusPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickEmpStatusfromJobMenu() {
        employmentStatusLink.click();

    }

    public void clickAddEmpStatusButton() {
        addEmpStatusButton.click();

    }
    public void clickEditEmpStatusButton(String recordName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement recordRow = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='oxd-table-card' and .//div[text()='" + recordName + "']]"))
        );
        WebElement editButton = recordRow.findElement(By.xpath(".//button[contains(@class,'oxd-icon-button')]//i[contains(@class,'bi-pencil-fill')]"));
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }

    public void clickEdit_SaveEmpStatusButton(String empStatusName) throws InterruptedException {
        clickEditEmpStatusButton(empStatusName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(empStatusNameInputField));
        empStatusNameInputField.clear();
        empStatusNameInputField.sendKeys(empStatusName);
        Thread.sleep(2000);
        saveeditedEmpStatusButton.click();

    }
    public void clickDeleteEmpStatusButton(String empStatusName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement recordRow = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='oxd-table-card' and .//div[text()='" + empStatusName + "']]"))
        );
        //WebElement deleteButton = recordRow.findElement(By.xpath(".//button[contains(@class,'oxd-icon-button')]//i[contains(@class,'bi-trash-fill')]"));
        wait.until(ExpectedConditions.elementToBeClickable(deleteEmpStatusButton)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }
    public String getHeaderText() {
        return employmentStatusHeader.getText();
    }
    public String getAddEmpStatusHeaderText() {
        return addEmpStatusHeader.getText();
    }
    public String getEditEmpStatusHeaderText() {
        return editEmpStatusHeader.getText();
    }
    public void clickSaveEmpStatusButton(String empStatusName) {
        empStatusNameInput.sendKeys(empStatusName);
        saveButton.click();
        // Verify that the new employment status is added to the list
        WebElement newEmpStatus = driver.findElement(By.xpath("//div[@class='oxd-table-card']//div[text()='" + empStatusName + "']"));
        Assert.assertTrue(newEmpStatus.isDisplayed(), "New employment status is not displayed in the list.");
    }

   public void clickCancelEmpStatusButton() {
        cancelButton.click();
    }

}

