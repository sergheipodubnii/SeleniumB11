package com.test.openchart.tests;

import com.test.openchart.pages.CustomerChart;
import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.annotations.Test;

public class CustomerChartTest extends TestBaseOpenChart{
    @Test
            public void validationcustomer() throws InterruptedException {
        OpenChartLoginPage objectlogin = new OpenChartLoginPage(driver);
        objectlogin.loginpage();
        CustomerChart customerChart=new CustomerChart(driver);
        customerChart.Customervalidation("SERG","Tech","tech@gmail.com","98374747","demo");


    }
}
