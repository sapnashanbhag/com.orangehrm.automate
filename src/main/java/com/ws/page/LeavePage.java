package com.ws.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {
    private final WebDriver driver;

    @FindBy(xpath = "//h6[normalize-space()='Leave']")
    private WebElement leaveHeader;

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText() {
        return leaveHeader.getText();
    }

    public boolean isLeavePageDisplayed() {
        return leaveHeader.isDisplayed();
    }
}
