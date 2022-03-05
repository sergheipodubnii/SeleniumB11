package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAndTags {
    public static void main(String[] args) {


        WebDriver driver= new ChromeDriver();
        driver.get("file:///Users/sergheipodubnii/Desktop/Techtorial%20(2).html");
        driver.manage().window().maximize();
        WebElement javalink= driver.findElement(By.linkText("Java"));
        javalink.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();
        WebElement selenium=driver.findElement(By.linkText("Selenium"));
        selenium.click();

        driver.navigate().back();
        WebElement javalink1= driver.findElement(By.linkText("Java"));
        javalink1.click();
        driver.navigate().back();

       WebElement restApi=driver.findElement(By.partialLinkText("Rest"));
       restApi.click();
       driver.navigate().back();

       WebElement version = driver.findElement(By.tagName("u"));
        System.out.println(version.getText());




    }
}
