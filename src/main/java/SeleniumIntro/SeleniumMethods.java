package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException {
        // what is the diffrence between get() and navigate.to()?
        //interview questions !!!
        //what is the difference between driver.quit and driver.close?
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        //Driver .navigate .to()---->its navigates to the webpage.
        driver.navigate().to("https://www.google.com/");
        //driver.quit();
       // driver.close();
       // Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //
       // System.out.println(driver.getPageSource());  it gives html source
        driver.navigate().to("https://www.techtorialacademy.com");
        Thread.sleep(3000);
        driver.navigate().back();//amazon
        driver.navigate().forward();//techtorial again
        Thread.sleep(3000);
        driver.navigate().refresh();//refresh
        driver.close();
    }
}
