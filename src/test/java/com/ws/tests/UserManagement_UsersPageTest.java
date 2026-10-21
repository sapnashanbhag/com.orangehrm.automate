package com.ws.tests;

import com.ws.page.*;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserManagement_UsersPageTest extends BaseTest {
    // Test methods for UserManagement_UsersPage will go here
    private LeftNavigationMenuPage leftNavigationMenuPage;
    private Admin_JobPage admin_JobPage;
    private UserManagement_UsersPage userManagement_UsersPage;
    private AdminPage adminPage;
    private UserMgmt_Users_Add userMgmt_Users_AddPage;

    @BeforeMethod(alwaysRun = true)
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

    @Test(groups={"regression"})
   public void testSearchButton(){
        userManagement_UsersPage.clickSearchButton();
        Assert.assertTrue(userManagement_UsersPage.isSearchResultsDisplayed(), "Search results are not displayed after clicking the Search button");
   }

   //Need to check this for the last field is not getting reset
   @Test
    public void testResetButton() throws InterruptedException {

          userManagement_UsersPage.clickResetButton();

          Assert.assertTrue(userManagement_UsersPage.isSearchFormCleared(), "Search form is not cleared after clicking the Reset button");
            Thread.sleep(2000);
    }

    //in belwo test we have to check for url and cannot check for save button visibility as it is not visible on the users page
    @Test(groups={"regression"})
    public void testAddButton(){
        userManagement_UsersPage.clickAddButton();
        String url = driver.getCurrentUrl();
        System.out.println("Current URL after clicking Add button: " + url);
        Assert.assertTrue(url.contains("/admin/saveSystemUser"), "URL does not contain /admin/saveSystemUser after clicking the Add button");
    }

    //This test implements dynamic deletion of user "cua_ess02" and checks if the record is deleted from the table. It also checks for the delete confirmation message.
    //The xpath is written in such a way that it will find the delete button for the user "cua_ess02" and click it. Then it will check if the delete confirmation message is displayed and click the confirmation button to delete the user.
    // Finally, it will check if the user "cua_ess02" is no longer displayed in the table.
    @Test
    public void testDeleteButtonConfirmation() throws InterruptedException {
       userManagement_UsersPage.clickDeleteButton("cua_ess02");
       Assert.assertTrue(userManagement_UsersPage.isDeleteConfirmationDisplayed(), "Delete confirmation is not displayed after clicking the Delete button");
       userManagement_UsersPage.clickDeleteConfirmationButton();
       userManagement_UsersPage.checkDeletedRecordNotDisplayed("cua_ess02");
    }
    @Test
    public void testDeleteButtonCancel() throws InterruptedException {
        userManagement_UsersPage.clickDeleteButton("cua_ess03");
        Assert.assertTrue(userManagement_UsersPage.isDeleteConfirmationDisplayed(), "Delete confirmation is not displayed after clicking the Delete button");
        userManagement_UsersPage.clickDeleteCancelButton();
        Assert.assertTrue(userManagement_UsersPage.isUserDisplayed("cua_ess03"), "User should still be displayed after cancelling deletion");
    }

    @Test
    public void checkTableHeaderVisibility(){
        Assert.assertTrue(userManagement_UsersPage.checkTableHeaders(), "Table headers are not as expected");
    }

    @Test
    public void checkClickHRMLink(){
        userManagement_UsersPage.clickOrangeHRMLink();
        String expectedurl = driver.getCurrentUrl();
        System.out.println("Current URL after clicking HRM link: " + expectedurl);
        String actualurl = "https://orangehrm.com/";
        Assert.assertEquals(expectedurl, actualurl, "URL mismatch after clicking the HRM link");


    }

}
