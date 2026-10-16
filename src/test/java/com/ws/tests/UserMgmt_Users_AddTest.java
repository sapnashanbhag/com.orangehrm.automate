package com.ws.tests;

import com.ws.page.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserMgmt_Users_AddTest extends BaseTest {

    private LeftNavigationMenuPage leftNavigationMenuPage;
    private Admin_JobPage admin_JobPage;
    private UserManagement_UsersPage userManagement_UsersPage;
    private AdminPage adminPage;
    private UserMgmt_Users_Add userMgmt_Users_AddPage;

    @BeforeMethod
    public void openAdminPage() {
        loginPage.login("Admin", "admin123");
        leftNavigationMenuPage = new LeftNavigationMenuPage(driver);
        leftNavigationMenuPage.clickAdmin();
        admin_JobPage = new Admin_JobPage(driver);
        adminPage = new AdminPage(driver);
        userManagement_UsersPage = new UserManagement_UsersPage(driver);
        userMgmt_Users_AddPage = new UserMgmt_Users_Add(driver);
        adminPage.clickUserManagementTab();
        adminPage.clickUsersLink();
        String expectedPageHeader="System Users";
        String actualPageHeader=userManagement_UsersPage.getPageHeaderText();
        Assert.assertEquals(actualPageHeader, expectedPageHeader, "Page header mismatch");

    }

    @Test
    public void addNewUser() {
        adminPage.clickAddButton();
        Assert.assertTrue(adminPage.isAddUserFormDisplayed(), "Add User form is not displayed");
        adminPage.fillAddUserForm("Admin", "Emily Jones", "james12345", "james12345", "james12345");
        adminPage.clickSaveButton();
        Assert.assertTrue(adminPage.isSuccessMessageDisplayed(), "Success message is not displayed after adding a new user");
    }
    @Test
    public void testCancelButton() {
        userManagement_UsersPage.clickAddButton();
        userMgmt_Users_AddPage.clickCancelButton();
        String expectedPageHeader = "System Users";
        String actualPageHeader = userManagement_UsersPage.getPageHeaderText();
        Assert.assertEquals(actualPageHeader, expectedPageHeader, "Page header mismatch after clicking Cancel button");
    }
    @Test
    public void checkValidationMessages(){
        userManagement_UsersPage.clickAddButton();
        userMgmt_Users_AddPage.clickSaveButton();
        Assert.assertTrue(userMgmt_Users_AddPage.validateErrorMessages(), "Error messages are not as expected");
    }
}
