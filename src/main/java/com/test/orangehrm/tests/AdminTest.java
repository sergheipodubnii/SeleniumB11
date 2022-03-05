package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class AdminTest extends TestBase  {

    @Test
    public void validateTheCreationOfEmployeeMessage() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();
      // Assert.assertTrue(adminPage.ValidationTheEmployeeIsCreated("zaza1234"));

    }
    @Test (dataProvider = "UserRoles",dataProviderClass = DataAdminPage.class)
    public void ValidateTheSelectRoleFunctions(String RoleName){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
            MainPage mainPage=new MainPage(driver);
            mainPage.clickAdminButton();
            AdminPage adminPage=new AdminPage(driver);
            adminPage.SelectUserRole(RoleName,driver);
          Assert.assertTrue(adminPage.validateRoleText(RoleName));
    }
  /*  @Test
    public void ValidateTheSelectRoleFunctions2(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage=new AdminPage(driver);
        adminPage.SelectUserRole("ESS",driver);
      Assert.assertTrue(adminPage.validateRoleText("ESS"));
    }*/

}
