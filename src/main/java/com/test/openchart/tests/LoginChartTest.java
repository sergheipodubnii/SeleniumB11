package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.annotations.Test;

public class LoginChartTest extends  TestBaseOpenChart{

    @Test
    public void validationloginchart(){
        OpenChartLoginPage login=new OpenChartLoginPage(driver);
        login.loginpage();
    }
}
