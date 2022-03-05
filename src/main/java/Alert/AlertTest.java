package Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AlertTest {

    @Test
    public void task() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
      WebElement first= driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')]//..//button"));
      first.click();
      Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expected="Oops, something went wrong!";
        Assert.assertEquals(actualText,expected);
        alert.accept();

    }
    @Test
    public void task2(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        WebElement second = driver.findElement(By.xpath("//h5[@class='swal-logo']//..//button"));
        //  //button[contains(@onclick,'swal')]
        second.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expected="Something went wrong!";
        Assert.assertEquals(actualText,expected);


    }
    @Test
    public void task3() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        WebElement second = driver.findElement(By.xpath("//h5[@class='swal-logo']//..//button"));
        second.click();
        Thread.sleep(2000);
        WebElement text= driver.findElement(By.xpath("//div[@class='swal-text']"));
        String textactual=text.getText();
        String textexpected="Something went wrong!";
        Assert.assertEquals(textactual,textexpected);
        WebElement clickok= driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        clickok.click();

    }
}
