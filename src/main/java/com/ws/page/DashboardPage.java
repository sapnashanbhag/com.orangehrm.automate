package com.ws.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    private final WebDriver driver;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//p[normalize-space()='Time at Work']")
    private WebElement timeAtWorkHeader;

    @FindBy(xpath = "//div[.//p[normalize-space()='Time at Work']]")
    private WebElement timeAtWorkWidget;

    @FindBy(xpath = "//div[.//p[normalize-space()='Time at Work']]//*[contains(normalize-space(.), 'Punched Out')]")
    private WebElement punchStatus;

    @FindBy(xpath = "//p[normalize-space()='My Actions']")
    private WebElement myActionsHeader;

    @FindBy(xpath = "//div[.//p[normalize-space()='My Actions']]")
    private WebElement myActionsWidget;

    @FindBy(xpath = "//p[normalize-space()='Quick Launch']")
    private WebElement quickLaunchHeader;

    @FindBy(xpath = "//div[.//p[normalize-space()='Quick Launch']]")
    private WebElement quickLaunchWidget;

    @FindBy(xpath = "//p[normalize-space()='Buzz Latest Posts']")
    private WebElement buzzLatestPostsHeader;

    @FindBy(xpath = "//div[.//p[normalize-space()='Buzz Latest Posts']]")
    private WebElement buzzLatestPostsWidget;

    @FindBy(xpath = "//p[normalize-space()='Employees on Leave Today']")
    private WebElement employeesOnLeaveTodayHeader;

    @FindBy(xpath = "//p[normalize-space()='Employees on Leave Today']/ancestor::div[contains(@class,'emp-leave-chart')][1]")
    private WebElement employeesOnLeaveTodayWidget;

    @FindBy(xpath = "//p[normalize-space()='Employee Distribution by Sub Unit']")
    private WebElement employeeDistributionBySubUnitHeader;

    @FindBy(xpath = "//p[normalize-space()='Employee Distribution by Sub Unit']/ancestor::div[contains(@class,'emp-distribution-chart')][1]")
    private WebElement employeeDistributionBySubUnitWidget;

    @FindBy(xpath = "//p[normalize-space()='Employee Distribution by Location']")
    private WebElement employeeDistributionByLocationHeader;

    @FindBy(xpath = "//p[normalize-space()='Employee Distribution by Location']/ancestor::div[contains(@class,'emp-distribution-chart')][1]")
    private WebElement employeeDistributionByLocationWidget;

    @FindBy(xpath = "//button[contains(@class,'oxd-userdropdown') or contains(@class,'userdropdown')] | //i[contains(@class,'bi-caret-down-fill')]")
    private WebElement userMenu;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getDashboardHeaderText() {
        return dashboardHeader.getText();
    }

    public boolean isDashboardPageDisplayed() {
        return dashboardHeader.isDisplayed();
    }

    public boolean isTimeAtWorkWidgetDisplayed() {
        return timeAtWorkWidget.isDisplayed();
    }

    public String getTimeAtWorkHeaderText() {
        return timeAtWorkHeader.getText();
    }

    public boolean isPunchStatusDisplayed() {
        return punchStatus.isDisplayed();
    }

    public boolean isMyActionsWidgetDisplayed() {
        return myActionsWidget.isDisplayed();
    }

    public String getMyActionsHeaderText() {
        return myActionsHeader.getText();
    }

    public boolean isQuickLaunchWidgetDisplayed() {
        return quickLaunchWidget.isDisplayed();
    }

    public String getQuickLaunchHeaderText() {
        return quickLaunchHeader.getText();
    }

    public boolean isBuzzLatestPostsWidgetDisplayed() {
        return buzzLatestPostsWidget.isDisplayed();
    }

    public String getBuzzLatestPostsHeaderText() {
        return buzzLatestPostsHeader.getText();
    }

    public boolean isEmployeesOnLeaveTodayWidgetDisplayed() {
        return employeesOnLeaveTodayWidget.isDisplayed();
    }

    public String getEmployeesOnLeaveTodayHeaderText() {
        return employeesOnLeaveTodayHeader.getText();
    }

    public boolean isEmployeeDistributionBySubUnitWidgetDisplayed() {
        return employeeDistributionBySubUnitWidget.isDisplayed();
    }

    public String getEmployeeDistributionBySubUnitHeaderText() {
        return employeeDistributionBySubUnitHeader.getText();
    }

    public boolean isEmployeeDistributionByLocationWidgetDisplayed() {
        return employeeDistributionByLocationWidget.isDisplayed();
    }

    public String getEmployeeDistributionByLocationHeaderText() {
        return employeeDistributionByLocationHeader.getText();
    }

    public void clickUserMenu() {
        userMenu.click();
    }

    public boolean isUserMenuVisible() {
        return userMenu.isDisplayed();
    }
}
