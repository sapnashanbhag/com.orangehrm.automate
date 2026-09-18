package com.ws.tests;

import com.ws.page.AdminPage;
import com.ws.page.LeftNavigationMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPageTest extends BaseTest {
    private LeftNavigationMenuPage leftNavigationMenuPage;
    private AdminPage adminPage;

    @BeforeMethod
    public void openAdminPage() {
        loginPage.login("Admin", "admin123");
        leftNavigationMenuPage = new LeftNavigationMenuPage(driver);
        leftNavigationMenuPage.clickAdmin();
        adminPage = new AdminPage(driver);
    }

    @Test
    public void adminPageShouldBeDisplayed() {
        Assert.assertTrue(adminPage.isAdminPageDisplayed(), "Admin page is not displayed");
        Assert.assertEquals(adminPage.getHeaderText(), "Admin", "Admin header mismatch");
        Assert.assertTrue(adminPage.isAddButtonDisplayed(), "Add button is not displayed");
    }

    @Test
    public void searchFormShouldBeDisplayed() {
        Assert.assertTrue(adminPage.isSearchFormDisplayed(), "Admin search form is not displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/viewSystemUsers"), "Admin system users page is not loaded");
    }

    @Test
    public void searchUserByUsername() {
        adminPage.searchUser("Admin");
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/viewSystemUsers"), "Admin results page not loaded");
    }

    @Test
    public void addNewUser() {
        adminPage.clickAddButton();
        Assert.assertTrue(adminPage.isAddUserFormDisplayed(), "Add User form is not displayed");
        adminPage.fillAddUserForm("Admin", "Luke Ackerman", "james12345", "james12345", "james12345");
        adminPage.clickSaveButton();
        Assert.assertTrue(adminPage.isSuccessMessageDisplayed(), "Success message is not displayed after adding a new user");
    }

    @Test
    public void paginationShouldWork() {
        if (adminPage.isPaginationDisplayed()) {
            adminPage.clickPageNumber(2);
            Assert.assertTrue(driver.getCurrentUrl().contains("/admin/viewSystemUsers"), "Admin page should remain open when changing pages");
            adminPage.clickNextPage();
            Assert.assertTrue(driver.getCurrentUrl().contains("/admin/viewSystemUsers"), "Admin page should remain open after next page action");
        } else {
            Assert.assertEquals(adminPage.getPaginationPageCount(), 0, "Pagination is not required when there is only one page of results");
        }
    }
}
