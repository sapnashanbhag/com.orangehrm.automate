package com.ws.tests;

import com.ws.page.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest {
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void openDashboard() {
        loginPage.login("Admin", "admin123");
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void dashboardPageShouldBeDisplayed() {
        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed(), "Dashboard page is not displayed");
        Assert.assertEquals(dashboardPage.getDashboardHeaderText(), "Dashboard", "Dashboard header text mismatch");
        Assert.assertTrue(dashboardPage.isUserMenuVisible(), "User menu is not visible on dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard/index"), "Dashboard URL is not opened");
    }

    @Test
    public void timeAtWorkWidgetShouldBeDisplayed() {
        Assert.assertTrue(dashboardPage.isTimeAtWorkWidgetDisplayed(), "Time at Work widget is not displayed");
        Assert.assertEquals(dashboardPage.getTimeAtWorkHeaderText(), "Time at Work", "Time at Work header text mismatch");
        Assert.assertTrue(dashboardPage.isPunchStatusDisplayed(), "Punch status is not displayed in Time at Work widget");
    }

    @Test
    public void myActionsWidgetShouldBeDisplayed() {
        Assert.assertTrue(dashboardPage.isMyActionsWidgetDisplayed(), "My Actions widget is not displayed");
        Assert.assertEquals(dashboardPage.getMyActionsHeaderText(), "My Actions", "My Actions header text mismatch");
    }

    @Test
    public void quickLaunchWidgetShouldBeDisplayed() {
        Assert.assertTrue(dashboardPage.isQuickLaunchWidgetDisplayed(), "Quick Launch widget is not displayed");
        Assert.assertEquals(dashboardPage.getQuickLaunchHeaderText(), "Quick Launch", "Quick Launch header text mismatch");
    }

    @Test
    public void buzzLatestPostsWidgetShouldBeDisplayed() {
        Assert.assertTrue(dashboardPage.isBuzzLatestPostsWidgetDisplayed(), "Buzz Latest Posts widget is not displayed");
        Assert.assertEquals(dashboardPage.getBuzzLatestPostsHeaderText(), "Buzz Latest Posts", "Buzz Latest Posts header text mismatch");
    }

    @Test
    public void employeesOnLeaveTodayWidgetShouldBeDisplayed() {
        Assert.assertTrue(dashboardPage.isEmployeesOnLeaveTodayWidgetDisplayed(), "Employees on Leave Today widget is not displayed");
        Assert.assertEquals(dashboardPage.getEmployeesOnLeaveTodayHeaderText(), "Employees on Leave Today", "Employees on Leave Today header text mismatch");
    }

    @Test
    public void employeeDistributionBySubUnitWidgetShouldBeDisplayed() {
        Assert.assertTrue(dashboardPage.isEmployeeDistributionBySubUnitWidgetDisplayed(), "Employee Distribution by Sub Unit widget is not displayed");
        Assert.assertEquals(dashboardPage.getEmployeeDistributionBySubUnitHeaderText(), "Employee Distribution by Sub Unit", "Employee Distribution by Sub Unit header text mismatch");
    }

    @Test
    public void employeeDistributionByLocationWidgetShouldBeDisplayed() {
        Assert.assertTrue(dashboardPage.isEmployeeDistributionByLocationWidgetDisplayed(), "Employee Distribution by Location widget is not displayed");
        Assert.assertEquals(dashboardPage.getEmployeeDistributionByLocationHeaderText(), "Employee Distribution by Location", "Employee Distribution by Location header text mismatch");
    }
}
