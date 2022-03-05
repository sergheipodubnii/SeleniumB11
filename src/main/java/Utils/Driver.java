package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    //private variables
    private static WebDriver driver;
    // private constructor to make sure they do not create an object from this class
    private Driver(){
    }
    public static WebDriver getDriver(){

        if(driver==null){// I am checking  driver whether it is null or not
            //if driver is null i am going to create a new one
            //if not , it is not going to create a new Driver . it will use the existing (current) one.
            switch (ConfigReader.readProperty("browsers")){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();

                    break;

                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver=new FirefoxDriver();

                    break;
                default:

                    driver=new ChromeDriver();

                    break;


            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            //this implicity wait will wait for the elements until 10 second to be loaded.
        }
        return driver;
    }
    public static void tearDown(){
        driver.quit();
        driver=null;
    }
}
