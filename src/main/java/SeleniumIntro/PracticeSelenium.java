package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSelenium {
    // i want you go the 3 websites . you decide and going back  .get the title
   // currentURL
    //forward with them lastly refresh and quit
    public static void main(String[] args) {
        System.getProperty("webdriver.chrome.driver", "cromedriver");


        WebDriver driver = new ChromeDriver();
        driver.get("https://coinmarketcap.com/");
        driver.manage().window().maximize();
        String url1=driver.getCurrentUrl();

        String title1=driver.getTitle();
        System.out.println(title1);


        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.get("https://www.etsy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();



    }




}
