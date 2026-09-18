package com.ws.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
    private final WebDriver driver;

    @FindBy(xpath = "//h6[normalize-space()='PIM']")
    private WebElement pimHeader;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText() {
        return pimHeader.getText();
    }

    public boolean isPIMPageDisplayed() {
        return pimHeader.isDisplayed();
    }
}
