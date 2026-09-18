package com.ws.tests;

import com.ws.page.Admin_JobPage;
import com.ws.page.LeftNavigationMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Admin_JobPageTest extends BaseTest {
    private LeftNavigationMenuPage leftNavigationMenuPage;
    private Admin_JobPage admin_JobPage;

    @BeforeMethod
    public void openAdminPage() {
        loginPage.login("Admin", "admin123");
        leftNavigationMenuPage = new LeftNavigationMenuPage(driver);
        leftNavigationMenuPage.clickAdmin();
        admin_JobPage = new Admin_JobPage(driver);
    }

    @Test
    public void testJobPageNavigation() {
        Assert.assertTrue(admin_JobPage.isJobLinkDisplayed(), "Job menu item is not displayed");

        admin_JobPage.clickJobLink();
        Assert.assertTrue(admin_JobPage.isJobTitlesLinkDisplayed(), "Job Titles link is not displayed on the Job page");

        admin_JobPage.clickJobTitlesLink();
        Assert.assertTrue(admin_JobPage.isJobTitlesHeaderDisplayed(), "Job Titles page header is not displayed");
        Assert.assertEquals(admin_JobPage.getJobTitlesHeaderText(), "Job Titles", "Job Titles header text mismatch");
        Assert.assertTrue(admin_JobPage.isAddButtonDisplayed(), "Add button is not displayed on Job Titles page");
    }

    @Test
    public void testAddJobTitleButtonOpensForm() {
        admin_JobPage.clickJobLink();
        admin_JobPage.clickJobTitlesLink();
        admin_JobPage.clickAddButton();

        Assert.assertTrue(admin_JobPage.isAddJobTitleFormDisplayed(), "Add Job Title form is not displayed");
    }

    @Test
    public void testSaveJobTitle() {
        admin_JobPage.clickJobLink();
        admin_JobPage.clickJobTitlesLink();
        admin_JobPage.clickAddButton();
        admin_JobPage.addJobTitle("QA Automation Engineer", "Responsible for test automation execution and maintenance.", "High priority role");
        admin_JobPage.clickSaveButton();
    }

    @Test
    public void testCancelButtonOnJobTitleForm() {
        admin_JobPage.clickJobLink();
        admin_JobPage.clickJobTitlesLink();
        admin_JobPage.clickAddButton();

        Assert.assertTrue(admin_JobPage.isCancelButtonDisplayed(), "Cancel button is not displayed on the Add Job Title form");
        admin_JobPage.clickCancelButton();
        Assert.assertTrue(admin_JobPage.isAddButtonDisplayed(), "Clicking Cancel should return to the Job Titles list");
    }
}
