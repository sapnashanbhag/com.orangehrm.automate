package com.ws.tests;

import com.ws.page.Admin_JobPage;
import com.ws.page.Admin_Job_EmpStatusPage;
import com.ws.page.LeftNavigationMenuPage;
import com.ws.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Admin_Job_EmpStatusPageTest extends BaseTest {
    private LeftNavigationMenuPage leftNavigationMenuPage;
    private Admin_JobPage admin_JobPage;
    private LoginPage loginPage;
    public Admin_Job_EmpStatusPage admin_Job_EmpStatusPage;

    @BeforeMethod
    public void openAdminPage() {
        loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        leftNavigationMenuPage = new LeftNavigationMenuPage(driver);
        leftNavigationMenuPage.clickAdmin();
        admin_JobPage = new Admin_JobPage(driver);
        admin_JobPage.clickJobLink();
        admin_Job_EmpStatusPage = new Admin_Job_EmpStatusPage(driver);
    }

    @Test
    public void clickEmpStatusfromJobMenu() {
        admin_Job_EmpStatusPage.clickEmpStatusfromJobMenu();
        Assert.assertEquals(admin_Job_EmpStatusPage.getHeaderText(), "Employment Status", "Employment Status header mismatch");
    }

    @Test
    public void clickAddEmpStatus() {
        admin_Job_EmpStatusPage.clickEmpStatusfromJobMenu();
        admin_Job_EmpStatusPage.clickAddEmpStatusButton();
        Assert.assertEquals(admin_Job_EmpStatusPage.getAddEmpStatusHeaderText(), "Add Employment Status", "Add Employment Status header mismatch");

    }

    @Test
    public void EditEmpStatus() throws InterruptedException {
        admin_Job_EmpStatusPage.clickEmpStatusfromJobMenu();
        String empStatusName = "EditStatus_" + System.currentTimeMillis();
        admin_Job_EmpStatusPage.clickAddEmpStatusButton();
        admin_Job_EmpStatusPage.clickSaveEmpStatusButton(empStatusName);
        admin_Job_EmpStatusPage.clickEdit_SaveEmpStatusButton(empStatusName);
        Thread.sleep(2000);
        Assert.assertEquals(admin_Job_EmpStatusPage.getEditEmpStatusHeaderText(), "Edit Employment Status", "Edit Employment Status header mismatch");
    }

    @Test
    public void DeleteEmpStatus() {
        admin_Job_EmpStatusPage.clickEmpStatusfromJobMenu();
        admin_Job_EmpStatusPage.clickAddEmpStatusButton();
        String empStatusName = "DeleteStatus_" + System.currentTimeMillis();
        admin_Job_EmpStatusPage.clickSaveEmpStatusButton(empStatusName);
        admin_Job_EmpStatusPage.clickDeleteEmpStatusButton(empStatusName);
    }

    @Test
    public void Add_SaveEmpStatus() {
        admin_Job_EmpStatusPage.clickEmpStatusfromJobMenu();
        admin_Job_EmpStatusPage.clickAddEmpStatusButton();
        admin_Job_EmpStatusPage.clickSaveEmpStatusButton("Test463");
        Assert.assertEquals(admin_Job_EmpStatusPage.getHeaderText(), "Employment Status", "Employment Status header mismatch");
    }

    @Test
    public void Add_CancelEmpStatus() {
        admin_Job_EmpStatusPage.clickEmpStatusfromJobMenu();
        admin_Job_EmpStatusPage.clickAddEmpStatusButton();
        admin_Job_EmpStatusPage.clickCancelEmpStatusButton();
        Assert.assertEquals(admin_Job_EmpStatusPage.getHeaderText(), "Employment Status", "Employment Status header mismatch");
    }
}
