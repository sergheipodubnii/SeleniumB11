package TESTNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforesuite(){
        System.out.println("Before Suite");
        //You can use to setup your chrome Browser properties
        //(deletecookies)
    }
    @BeforeTest
    public void beforetest(){
        System.out.println("Before Test");
        //you can use to launch your browser
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
        //you can navigate to the website
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
        //You can use it to login the page
    }
    @Test
    public void test1(){
        System.out.println("test-1");

    }
    @Test
    public void test2(){
        System.out.println("test-2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
        //you can take a screeshot for failed test annotations
        //driver.quit ();


    }
    @AfterClass
    public void afterclass(){
        System.out.println("after class");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("After Test");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("After Suite");

    }
}
