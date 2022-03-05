package homework.homeworkproject3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCase5 {


    @Test
    public void testcase() throws InterruptedException {
        //Add 3 items to your cart
        //Click X button on the top added items
        //Validate items number is 2
        //Steps
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
        Thread.sleep(2000);
        WebElement clickX= driver.findElement(By.xpath("//li[@data-uid='c41369b5-5bb1-4ba4-8a03-fc43703bf7a8']//a[@class='view-selected-items']"));
        Actions actions3=new Actions(driver);
        actions3.moveToElement(clickX).click().perform();

    }
}

