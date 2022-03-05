package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {

        //Step 1:
        // We need to define chrome driver into the project
        System.getProperty("webdriver.chrome.driver", "cromedriver");

        //Step 2:
        //We need to instantiate or declare our driver
        WebDriver driver = new ChromeDriver();

        //Note: Driver is a reference name
        //WebDriver -- interface
        //new ChromeDriver() -- new Object
        // Q: Where do you use polymorphism in your testing framework?
        // A: I use it ti initiate my driver like --> WebDriver driver = new ChromeDriver();
        // Q: Can you instantiate your driver like  WebDriver driver = new WebDriver();
        // A: NO

        // First method:
        //Get() --> navigates to the given url.
        driver.get("https://www.techtorialacademy.com");
        // getTitle()---> methods get the title of the page .
        String title=driver.getTitle();
        System.out.println(title);
        if(title.equals("Home Page - Techtorial")){
            System.out.println("your test is passed");
        }else {
            System.out.println("your test is failed");
        }
        //getCurrentUrl()--->it gets the current url of the website
       String actual= driver.getCurrentUrl();
        String expected ="https://www.techtorialacademy.com/";
        if(actual.equals(expected)){
            System.out.println("Passed");
         }else{
            System.out.println("Failed");
        }


    }
}
