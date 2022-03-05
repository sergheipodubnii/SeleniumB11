package homework.homeworkproject3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
    @Test
    public void TestCase() throws InterruptedException {
        // driver.get("https://demos.telerik.com/kendo-ui/websushi#");
       /* Click picture of the Salmon Teriyaki
        Click Add to cart button 2 times
        Validate total price is $26
        Validate item number is 1
        Click > arrow button
        Click add to cart for Gohan
        Validate total price is $29
        Validate total items 2*/

        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        WebElement salmonteriyaki= driver.findElement(By.xpath("//img[@title='Salmon Teriyaki']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(salmonteriyaki).click().perform();
        Thread.sleep(2000);
        WebElement addtocard= driver.findElement(By.xpath("//button[@class='buy']"));
        Actions actions1=new Actions(driver);
        actions1.moveToElement(addtocard).doubleClick().perform();
        WebElement totalprice= driver.findElement(By.xpath("//p[@class='total-price']"));
        Thread.sleep(2000);
        String actualtotalprice=totalprice.getText();
        String expectedtotalprice="$26.00";
        Assert.assertEquals(actualtotalprice,expectedtotalprice);
        WebElement arrownext= driver.findElement(By.xpath("//a[@id='navigate-next']"));
        Thread.sleep(2000);
        Actions actions2=new Actions(driver);
        actions2.moveToElement(arrownext).click().perform();
        Thread.sleep(2000);
        WebElement addgohan=driver.findElement(By.xpath("//button[@class='buy']"));

       addgohan.click();
        WebElement validatetotalprice=driver.findElement(By.xpath("//p[@class='total-price']"));
        String actualvalidatetotalprice=validatetotalprice.getText();
        String expectedvalidatetotalprice="$29.00";
        Assert.assertEquals(actualvalidatetotalprice,expectedvalidatetotalprice);
        WebElement totalitem= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
     String actualtotalitem=totalitem.getText();
     String expectedactualitem="2";
     Assert.assertEquals(actualtotalitem,expectedactualitem);


    }
}
