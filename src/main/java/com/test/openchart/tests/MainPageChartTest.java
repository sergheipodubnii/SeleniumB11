package com.test.openchart.tests;

import com.test.openchart.pages.MainPageChart;
import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.annotations.Test;

public class MainPageChartTest extends TestBaseOpenChart{
    @Test
    public void validationinfo(){
        OpenChartLoginPage login=new OpenChartLoginPage(driver);
        login.loginpage();
        MainPageChart main=new MainPageChart(driver);
        main.validationmainpage("12K","11.8M","144.8K");
    }
}
