package com.ws.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNavigationMenuPage {
    private final WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Admin']")
    private WebElement adminMenuItem;

    @FindBy(xpath = "//span[normalize-space()='PIM']")
    private WebElement pimMenuItem;

    @FindBy(xpath = "//span[normalize-space()='Leave']")
    private WebElement leaveMenuItem;

    @FindBy(xpath = "//span[normalize-space()='Time']")
    private WebElement timeMenuItem;

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitmentMenuItem;

    @FindBy(xpath = "//span[normalize-space()='My Info']")
    private WebElement myInfoMenuItem;

    @FindBy(xpath = "//span[normalize-space()='Performance']")
    private WebElement performanceMenuItem;

    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    private WebElement dashboardMenuItem;

    @FindBy(xpath = "//span[normalize-space()='Directory']")
    private WebElement directoryMenuItem;

    @FindBy(xpath = "//span[normalize-space()='Maintenance']")
    private WebElement maintenanceMenuItem;

    @FindBy(xpath = "//span[normalize-space()='Claim']")
    private WebElement claimMenuItem;

    @FindBy(xpath = "//span[normalize-space()='Buzz']")
    private WebElement buzzMenuItem;

    @FindBy(xpath="//button[@class='oxd-icon-button oxd-main-menu-button'] //i[@class='oxd-icon bi-chevron-left']")
    private WebElement collapseMenuButton;

    @FindBy(xpath="//button[@class='oxd-icon-button oxd-main-menu-button'] //i[@class='oxd-icon bi-chevron-right']")
    private WebElement expandMenuButton;

    public LeftNavigationMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void collapseMenu() {
        collapseMenuButton.click();
    }

    public void expandMenu() {
        expandMenuButton.click();
    }

    public boolean isMenuExpanded() {
        return collapseMenuButton.isDisplayed();
    }

    public boolean isMenuCollapsed() {
        return expandMenuButton.isDisplayed();
    }

    public boolean isAdminVisible() {
        return adminMenuItem.isDisplayed();
    }

    public boolean isPimVisible() {
        return pimMenuItem.isDisplayed();
    }

    public boolean isLeaveVisible() {
        return leaveMenuItem.isDisplayed();
    }

    public boolean isTimeVisible() {
        return timeMenuItem.isDisplayed();
    }

    public boolean isRecruitmentVisible() {
        return recruitmentMenuItem.isDisplayed();
    }

    public boolean isMyInfoVisible() {
        return myInfoMenuItem.isDisplayed();
    }

    public boolean isPerformanceVisible() {
        return performanceMenuItem.isDisplayed();
    }

    public boolean isDashboardVisible() {
        return dashboardMenuItem.isDisplayed();
    }

    public boolean isDirectoryVisible() {
        return directoryMenuItem.isDisplayed();
    }

    public boolean isMaintenanceVisible() {
        return maintenanceMenuItem.isDisplayed();
    }

    public boolean isClaimVisible() {
        return claimMenuItem.isDisplayed();
    }

    public boolean isBuzzVisible() {
        return buzzMenuItem.isDisplayed();
    }

    public void clickAdmin() {
        adminMenuItem.click();
    }

    public void clickPIM() {
        pimMenuItem.click();
    }

    public void clickLeave() {
        leaveMenuItem.click();
    }

    public void clickTime() {
        timeMenuItem.click();
    }

    public void clickRecruitment() {
        recruitmentMenuItem.click();
    }

    public void clickMyInfo() {
        myInfoMenuItem.click();
    }

    public void clickPerformance() {
        performanceMenuItem.click();
    }

    public void clickDashboard() {
        dashboardMenuItem.click();
    }

    public void clickDirectory() {
        directoryMenuItem.click();
    }

    public void clickMaintenance() {
        maintenanceMenuItem.click();
    }

    public void clickClaim() {
        claimMenuItem.click();
    }

    public void clickBuzz() {
        buzzMenuItem.click();
    }
}
