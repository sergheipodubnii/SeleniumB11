package homework.homeworkproject3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
    @Test
    public void TestCase2() throws InterruptedException {
        //Navigate to "https://demos.telerik.com/kendo-
        //ui/websushi#"
        //Click Add to cart for Edamame
        //Validate Item number is 1
        //Validate price of the product is $4
        //Click empty cart
        //Validate item number is 0
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
       WebElement edamameclick= driver.findElement(By.xpath("//img[@title='Edamame']"));
       Thread.sleep(2000);
       Actions actions=new Actions(driver);
       actions.moveToElement(edamameclick).click().perform();
       WebElement addtocartedamame= driver.findElement(By.xpath("//button[@class='buy']"));
       addtocartedamame.click();
       WebElement validateitem= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
       String actualcartitem= validateitem.getText();
       String expectedcartitem="1";
        Assert.assertEquals(actualcartitem,expectedcartitem);

        WebElement emptycard=driver.findElement(By.xpath("//a[@id='empty-cart']"));
        Thread.sleep(2000);
        emptycard.click();
        WebElement itemnumber=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualitemnumber=itemnumber.getText();
        String expecteditemnumber="0";
        Assert.assertEquals(actualitemnumber,expecteditemnumber);


    }
}
