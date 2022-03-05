package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class iframePractice {
    @Test
    public void iframeTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        WebElement textremove= driver.findElement(By.id("tinymce"));
        textremove.clear();
        textremove.sendKeys("i love selenium");
        driver.switchTo().parentFrame();

        WebElement header= driver.findElement(By.xpath("//h3"));
        System.out.println(header.getText());
        String actual = header.getText().trim();
        String expected="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actual,expected);

    }





}
