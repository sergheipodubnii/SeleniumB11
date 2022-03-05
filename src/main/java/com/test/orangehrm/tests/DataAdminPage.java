package com.test.orangehrm.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class DataAdminPage {
    @DataProvider(name="UserRoles")
    public Object[][] getUserRoleData(){
        return new Object[][]{

                {"Admin"},
                {"ESS"}
        };
    }
}
