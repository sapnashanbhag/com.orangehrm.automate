package com.ws.tests;

import com.ws.page.*;
import com.ws.utils.ExcelUtil;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserMgmt_Users_AddTest extends BaseTest {

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

    @DataProvider(name = "userData")
    public Object[][] userDataProvider() throws Exception {
        String filePath = "./src/test/resources/testdata/data.xlsx";
        String sheetName = "Sheet2";
        ExcelUtil excelUtil = new ExcelUtil(filePath);
        int rowCount = excelUtil.getRowCount(sheetName);
        int columnCount = excelUtil.getColumnCount(sheetName, 0); // Assuming first row has all columns
        Object[][] data = new Object[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data[i][j] = excelUtil.getCellData(sheetName, i, j);
            }
        }
        return data;
    }

    @Test(groups={"regression"}, dataProvider = "userData")
    public void addNewUser(String userRole, String employeeName, String username, String password, String confirmPassword) {
        logger = extentReports.createTest("addNewUser", "Verify that a new user can be added successfully");
        adminPage.clickAddButton();
        logger.pass("Clicked on Add button to navigate to Add User page");
        Assert.assertTrue(adminPage.isAddUserFormDisplayed(), "Add User form is not displayed");
        logger.pass("Verified that the Add User form is displayed");
        adminPage.fillAddUserForm(userRole, employeeName, username, password, confirmPassword);
        logger.pass("Filled in the Add User form with userRole: " + userRole + ", employeeName: " + employeeName + ", username: " + username);
        adminPage.clickSaveButton();
        logger.pass("Clicked on Save button to add the new user");
        Assert.assertTrue(adminPage.isSuccessMessageDisplayed(), "Success message is not displayed after adding a new user");
        logger.pass("Verified that the success message is displayed after adding a new user");
    }
    @Test(groups={"regression"})
    public void testCancelButton() {
        logger=extentReports.createTest("testCancelButton", "Verify that clicking the Cancel button on the Add User page returns to the System Users page");
        userManagement_UsersPage.clickAddButton();
        logger.pass("Clicked on Add button to navigate to Add User page");
        userMgmt_Users_AddPage.clickCancelButton();
        logger.pass("Clicked on Cancel button to return to System Users page");
        String expectedPageHeader = "System Users";
        String actualPageHeader = userManagement_UsersPage.getPageHeaderText();
        Assert.assertEquals(actualPageHeader, expectedPageHeader, "Page header mismatch after clicking Cancel button");
        logger.pass("Verified that the page header is 'System Users' after clicking Cancel button");
    }
    @Test
    public void checkValidationMessages(){
        userManagement_UsersPage.clickAddButton();
        userMgmt_Users_AddPage.clickSaveButton();
        Assert.assertTrue(userMgmt_Users_AddPage.validateErrorMessages(), "Error messages are not as expected");
    }
}
