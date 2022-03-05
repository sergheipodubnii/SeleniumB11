package homework.project2selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.geom.QuadCurve2D;
import java.util.*;

public class task2 {
    //Steps
    //Navigate to "https://www.saucedemo.com/"
    //Enter username "standard_user"
    //Enter password "secret_sauce"
    //Click Login button
    //Select Price (low-high) from drop down box
    //Validate the products are displayed according to their price
    //and they are displayed low price to high price
    //Steps
    @Test
    public void productordertothepricevalidation() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement username= driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginbutton= driver.findElement(By.xpath("//input[@id='login-button']"));
        loginbutton.click();
        Thread.sleep(2000);
        WebElement dropdown= driver.findElement(By.xpath("//select[@class='product_sort_container']"));

        Thread.sleep(1000);
        Select lowhigh=new Select(dropdown);
        lowhigh.selectByValue("lohi");
        Thread.sleep(2000);
        List<WebElement> priceorders= driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        Set<String> actualpriceorder=new LinkedHashSet<>();
        Set<String> expectedpriceorder=new TreeSet<>();
        for(int i=0;i< priceorders.size();i++){
            actualpriceorder.add((priceorders.get(i).getText().trim()));
            expectedpriceorder.add((priceorders.get(i).getText().trim()));
        }

        Assert.assertEquals(actualpriceorder,expectedpriceorder);
    }
}
