package com.test.etsy;

import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class EtsyTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
       driver= Driver.getDriver();
     //   WebDriverManager.chromedriver().setup();
       // driver = new ChromeDriver();
        driver.get("https://www.etsy.com");
       // driver.manage().window().maximize();
        //System.out.println("i am running before every test annotation");
    }

    //  @AfterMethod
    //public void tearDown(){
    // System.out.println("I am running after each test annotation");
    //  driver.quit();
    //}
}
