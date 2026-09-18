package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Admin_JobPage extends DriverScript {
    @FindBy(xpath = "//*[normalize-space()='Job']")
    private WebElement jobLink;

    @FindBy(xpath = "//*[normalize-space()='Job Titles']")
    private WebElement jobTitlesLink;

    @FindBy(xpath = "//*[normalize-space()='Job Titles']")
    private WebElement jobTitlesHeader;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//h6[normalize-space()='Add Job Title']")
    private WebElement addJobTitleHeader;

    @FindBy(xpath = "//label[normalize-space()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement jobTitleInput;

    @FindBy(xpath = "//label[normalize-space()='Job Description']/ancestor::div[contains(@class,'oxd-input-group')]//textarea")
    private WebElement jobDescriptionInput;

    @FindBy(xpath = "//label[normalize-space()='Note']/ancestor::div[contains(@class,'oxd-input-group')]//textarea")
    private WebElement noteInput;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelButton;

    public Admin_JobPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebDriverWait createWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isJobLinkDisplayed() {
        return createWait().until(ExpectedConditions.visibilityOf(jobLink)).isDisplayed();
    }

    public void clickJobLink() {
        createWait().until(ExpectedConditions.elementToBeClickable(jobLink)).click();
    }

    public boolean isJobTitlesLinkDisplayed() {
        return createWait().until(ExpectedConditions.visibilityOf(jobTitlesLink)).isDisplayed();
    }

    public void clickJobTitlesLink() {
        createWait().until(ExpectedConditions.elementToBeClickable(jobTitlesLink)).click();
    }

    public boolean isJobTitlesHeaderDisplayed() {
        return createWait().until(ExpectedConditions.visibilityOf(jobTitlesHeader)).isDisplayed();
    }

    public String getJobTitlesHeaderText() {
        return createWait().until(ExpectedConditions.visibilityOf(jobTitlesHeader)).getText();
    }

    public boolean isAddButtonDisplayed() {
        return createWait().until(ExpectedConditions.visibilityOf(addButton)).isDisplayed();
    }

    public void clickAddButton() {
        createWait().until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public boolean isAddJobTitleFormDisplayed() {
        return createWait().until(ExpectedConditions.visibilityOf(addJobTitleHeader)).isDisplayed();
    }

    public void addJobTitle(String title, String description, String note) {
        createWait().until(ExpectedConditions.visibilityOf(jobTitleInput)).clear();
        jobTitleInput.sendKeys(title);
        jobDescriptionInput.clear();
        jobDescriptionInput.sendKeys(description);
        noteInput.clear();
        noteInput.sendKeys(note);
    }

    public void clickSaveButton() {
        createWait().until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public boolean isCancelButtonDisplayed() {
        return createWait().until(ExpectedConditions.visibilityOf(cancelButton)).isDisplayed();
    }

    public void clickCancelButton() {
        createWait().until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }
}
