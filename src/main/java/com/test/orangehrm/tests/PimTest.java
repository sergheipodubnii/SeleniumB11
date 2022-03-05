package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PimPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PimPage pimPage;

    @BeforeMethod
    public void  initiliazingPages(){
        loginPage=new LoginPage(driver);
        mainPage = new MainPage(driver);
       pimPage=new PimPage(driver);
    }
    @Test
    public void ValidateTheCreationsOfEmployee() throws InterruptedException {
       // LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
        //MainPage mainPage = new MainPage(driver);
        mainPage.clickPimButton();
       // PimPage pimPage=new PimPage(driver);
        pimPage.setAddEmployeeforPIM("serghei","mihail","podubnii","1234","/Users/sergheipodubnii/Desktop/usa.svg.png");
        Assert.assertEquals(pimPage.validateFirstName(),"serghei");
        Assert.assertEquals(pimPage.validateLastName(),"podubnii");
        Assert.assertTrue(pimPage.validateEmployeeId("1234"));

    }

    @Test
    public void ValidatION() throws InterruptedException {
        loginPage.login("Admin","admin123");
        //MainPage mainPage = new MainPage(driver);
        mainPage.clickPimButton();
        Thread.sleep(2000);
        pimPage.setAddEmployeeforPIM("serghei","mihail","podubnii","1234","/Users/sergheipodubnii/Desktop/usa.svg.png");
        pimPage.editPersonalDetails("118","Single","1989-07-19");
        Thread.sleep(2000);
        Assert.assertEquals(pimPage.validateTheNationality(),"Moldovan");

    }




}
