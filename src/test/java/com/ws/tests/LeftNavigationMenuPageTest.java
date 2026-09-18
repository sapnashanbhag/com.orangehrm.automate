package com.ws.tests;

import com.ws.page.LeftNavigationMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeftNavigationMenuPageTest extends BaseTest {
    private LeftNavigationMenuPage leftNavigationMenuPage;

    @BeforeMethod
    public void setUpMenu() {
        loginPage.login("Admin", "admin123");
        leftNavigationMenuPage = new LeftNavigationMenuPage(driver);
    }
    @Test
    public void collapseAndExpandLeftNavigationMenu() {
        Assert.assertTrue(leftNavigationMenuPage.isMenuExpanded(), "Left navigation menu should be expanded by default");
        leftNavigationMenuPage.collapseMenu();
        Assert.assertTrue(leftNavigationMenuPage.isMenuCollapsed(), "Left navigation menu should be collapsed after clicking the collapse button");
        leftNavigationMenuPage.expandMenu();
        Assert.assertTrue(leftNavigationMenuPage.isMenuExpanded(), "Left navigation menu should be expanded after clicking the expand button");
    }
    @Test
    public void leftNavigationMenuShouldBeDisplayed() {
        Assert.assertTrue(leftNavigationMenuPage.isAdminVisible(), "Admin menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isPimVisible(), "PIM menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isLeaveVisible(), "Leave menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isTimeVisible(), "Time menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isRecruitmentVisible(), "Recruitment menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isMyInfoVisible(), "My Info menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isPerformanceVisible(), "Performance menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isDashboardVisible(), "Dashboard menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isDirectoryVisible(), "Directory menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isMaintenanceVisible(), "Maintenance menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isClaimVisible(), "Claim menu item is not displayed");
        Assert.assertTrue(leftNavigationMenuPage.isBuzzVisible(), "Buzz menu item is not displayed");
    }

    @Test
    public void clickDashboardMenuItem() {
        leftNavigationMenuPage.clickDashboard();
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard/index"), "Dashboard page was not opened");
    }

    @Test
    public void clickAdminMenuItem() {
        leftNavigationMenuPage.clickAdmin();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/viewSystemUsers"), "Admin page was not opened");
    }

    @Test
    public void clickPimMenuItem() {
        leftNavigationMenuPage.clickPIM();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewEmployeeList"), "PIM page was not opened");
    }

    @Test
    public void clickLeaveMenuItem() {
        leftNavigationMenuPage.clickLeave();
        Assert.assertTrue(driver.getCurrentUrl().contains("/leave/viewLeaveList"), "Leave page was not opened");
    }

    @Test
    public void clickTimeMenuItem() {
        leftNavigationMenuPage.clickTime();
        Assert.assertTrue(driver.getCurrentUrl().contains("/time/viewEmployeeTimesheet"), "Time page was not opened");
    }

    @Test
    public void clickRecruitmentMenuItem() {
        leftNavigationMenuPage.clickRecruitment();
        Assert.assertTrue(driver.getCurrentUrl().contains("/recruitment/viewCandidates"), "Recruitment page was not opened");
    }

    @Test
    public void clickMyInfoMenuItem() {
        leftNavigationMenuPage.clickMyInfo();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewPersonalDetails"), "My Info page was not opened");
    }

    @Test
    public void clickPerformanceMenuItem() {
        leftNavigationMenuPage.clickPerformance();
        Assert.assertTrue(driver.getCurrentUrl().contains("/performance/searchEvaluatePerformanceReview"), "Performance page was not opened");
    }

    @Test
    public void clickDirectoryMenuItem() {
        leftNavigationMenuPage.clickDirectory();
        Assert.assertTrue(driver.getCurrentUrl().contains("/directory/viewDirectory"), "Directory page was not opened");
    }

    @Test
    public void clickMaintenanceMenuItem() {
        leftNavigationMenuPage.clickMaintenance();
        Assert.assertTrue(driver.getCurrentUrl().contains("/maintenance/purgeEmployee"), "Maintenance page was not opened");
    }

    @Test
    public void clickClaimMenuItem() {
        leftNavigationMenuPage.clickClaim();
        Assert.assertTrue(driver.getCurrentUrl().contains("/claim/viewAssignClaim"), "Claim page was not opened");
    }

    @Test
    public void clickBuzzMenuItem() {
        leftNavigationMenuPage.clickBuzz();
        Assert.assertTrue(driver.getCurrentUrl().contains("/buzz/viewBuzz"), "Buzz page was not opened");
    }
}
