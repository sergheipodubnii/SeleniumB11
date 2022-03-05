package homework.project2selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class task1 {
    //Navigate to "https://www.saucedemo.com/"
    //Enter username "standard_user"
    //Enter password "secret_sauce"
    //Click Login button
    //Select Name (Z-A) from drop down box
    //Validate the products are displayed in descending order
    //Steps

    @Test
    public  void Productvalidation() throws InterruptedException {
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
        Select AtoZ=new Select(dropdown);
        AtoZ.selectByValue("za");
        Thread.sleep(1000);
        List<WebElement> productorders= driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        Set<String> actualproductorder=new LinkedHashSet<>();
        Set<String> expectedproductOrder=new TreeSet<>();
        for(WebElement productorder:productorders){
            actualproductorder.add(productorder.getText().trim());
            expectedproductOrder.add(productorder.getText().trim());
        }

        Assert.assertEquals(actualproductorder,expectedproductOrder);



    }
}
