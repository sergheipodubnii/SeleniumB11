package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.DataLoginIn;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    @BeforeMethod
    public void initializePage(){
        loginPage=new LoginPage(driver);
    }

    @Test
    public void validateLoginPositive(){
     //   LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }

    @Test(dataProvider = "LoginTest",dataProviderClass = DataLoginIn.class)
    public void validateLoginNegative1(String username,String password,String expected){

      // WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
      //  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
        Assert.assertEquals(loginPage.getErrorMessage(),expected);
    }
    //2 more negative scenarious (wromg username ,correct password
    //wrong username ,wrong password

 /*   @Test
    public void validateLoginNegative2(){
       WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","");
        String actualErrorMessage=loginPage.getErrorMessage();
        String expectedErrorMessage="Username cannot be empty";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        String actualColorOfErrorMessage=loginPage.getColorOfTheErrorMessage();
        String expectedColorOfErrorMessage="rgba(221, 119, 0, 1)";
        Assert.assertEquals(actualColorOfErrorMessage,expectedColorOfErrorMessage);
    }*/
}