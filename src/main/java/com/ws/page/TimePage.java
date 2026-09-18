package com.ws.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimePage {
    private final WebDriver driver;

    @FindBy(xpath = "//h6[normalize-space()='Time']")
    private WebElement timeHeader;

    public TimePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText() {
        return timeHeader.getText();
    }

    public boolean isTimePageDisplayed() {
        return timeHeader.isDisplayed();
    }
}
