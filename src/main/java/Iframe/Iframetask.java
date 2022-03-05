package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Iframetask {

    @Test
    public void task() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.navigate().to("https://skpatro.github.io/demo/iframes/");
            WebElement pavilion=driver.findElement(By.linkText("Pavilion"));
            pavilion.click();
            BrowserUtils.switchByTitle(driver,"Home - qavalidation");
            WebElement Selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//.."));
            Actions actions = new Actions(driver);
            actions.moveToElement(Selenium).perform();
            WebElement seleniumJava=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']//.."));
            actions.click(seleniumJava).perform();
            WebElement header= driver.findElement(By.tagName("h1"));
            String actualheader=BrowserUtils.getTextMethod(header);
            String expectedheader="Selenium-Java Tutorial – Basic to Advance";
            Assert.assertEquals(actualheader,expectedheader);

        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"iframes");//i am switching the window
        driver.switchTo().frame("Framename1");
        WebElement category= driver.findElement(By.xpath("//a[.='Category1']"));

        category.click();
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
       Assert.assertTrue(driver.getTitle().endsWith("qavalidation"));

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3= driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        String currenturl= driver.getCurrentUrl();
        String expected="https://qavalidation.com/category/softwaretesting/";
        Assert.assertEquals(currenturl,expected);













    }
}
