package homework.homeworkproject3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
    @Test
    public void TestCase1() throws InterruptedException {
        //Navigate to "https://demos.telerik.com/kendo-
        //ui/websushi#"
        //Click on top of Shiromi picture
        //Click > arrow
        //validate next item is Tekka maki
        //Click < arrow
        //Validate the item is Shiromi
        //Validate number of item 0 in the cart
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
       WebElement shiromi= driver.findElement(By.xpath("//img[@title='Shiromi']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(shiromi).click().perform();
        WebElement navigatenext= driver.findElement(By.xpath("//a[@id='navigate-next']"));
        Actions actions1=new Actions(driver);
        actions1.moveToElement(navigatenext).click().perform();
        Thread.sleep(2000);
        WebElement tekkamaki= driver.findElement(By.xpath("//h1[@data-bind='text: current.name']"));
        String actual= tekkamaki.getText();
        String expected="Tekka maki";
        Assert.assertEquals(actual,expected);
        Thread.sleep(2000);
        WebElement backarrow= driver.findElement(By.xpath("//a[@id='navigate-prev']"));
        Actions actions2=new Actions(driver);
        actions2.moveToElement(backarrow).click().perform();
        Thread.sleep(2000);
        WebElement shiromivalidation=driver.findElement(By.xpath("//h1[@data-bind='text: current.name']"));
        String actualtext=shiromivalidation.getText();
        String expectedtext="Shiromi";
        Assert.assertEquals(actualtext,expectedtext);
        WebElement validationcart= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualtextcart=validationcart.getText();
        String expectedtextcart="0";
        Assert.assertEquals(actualtextcart,expectedtextcart);

    }
}
