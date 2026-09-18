package com.ws.tests;

import com.ws.page.AdminPage;
import com.ws.page.LeftNavigationMenuPage;
import com.ws.page.LeavePage;
import com.ws.page.PIMPage;
import com.ws.page.TimePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModulePagesTest extends BaseTest {
    private LeftNavigationMenuPage leftNavigationMenuPage;

    @BeforeMethod
    public void loginAndOpenDashboard() {
        loginPage.login("Admin", "admin123");
        leftNavigationMenuPage = new LeftNavigationMenuPage(driver);
    }

    @Test
    public void adminPageShouldBeDisplayed() {
        leftNavigationMenuPage.clickAdmin();
        AdminPage adminPage = new AdminPage(driver);
        Assert.assertTrue(adminPage.isAdminPageDisplayed(), "Admin page is not displayed");
        Assert.assertEquals(adminPage.getHeaderText(), "Admin", "Admin header text mismatch");
    }

    @Test
    public void pimPageShouldBeDisplayed() {
        leftNavigationMenuPage.clickPIM();
        PIMPage pimPage = new PIMPage(driver);
        Assert.assertTrue(pimPage.isPIMPageDisplayed(), "PIM page is not displayed");
        Assert.assertEquals(pimPage.getHeaderText(), "PIM", "PIM header text mismatch");
    }

    @Test
    public void leavePageShouldBeDisplayed() {
        leftNavigationMenuPage.clickLeave();
        LeavePage leavePage = new LeavePage(driver);
        Assert.assertTrue(leavePage.isLeavePageDisplayed(), "Leave page is not displayed");
        Assert.assertEquals(leavePage.getHeaderText(), "Leave", "Leave header text mismatch");
    }

    @Test
    public void timePageShouldBeDisplayed() {
        leftNavigationMenuPage.clickTime();
        TimePage timePage = new TimePage(driver);
        Assert.assertTrue(timePage.isTimePageDisplayed(), "Time page is not displayed");
        Assert.assertEquals(timePage.getHeaderText(), "Time", "Time header text mismatch");
    }
}
