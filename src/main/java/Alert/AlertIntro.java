package Alert;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertIntro {
    @Test
    public void JSBAsicAlertAcceptMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement cLICKJsAlert= driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        cLICKJsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement message=driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage= BrowserUtils.getTextMethod(message);
        String expected="You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expected);

       // WebElement header= driver.findElement(By.xpath("//h3"));// unhandled
        //System.out.println(header.getText());

    }
    @Test
    public void JSDismissMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement click= driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        click.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expected="I am a JS Confirm";
        Assert.assertEquals(actualText,expected);
        alert.dismiss();
        WebElement validation = driver.findElement(By.xpath("//p[@id='result']"));
        String actual= validation.getText();
        String expected1="You clicked: Cancel";
        Assert.assertEquals(actual,expected1);
        WebElement click3=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        click3.click();
        Thread.sleep(1000);
        Alert alert1=driver.switchTo().alert();
        alert1.sendKeys("You entered techtorial");
        alert1.accept();
        Thread.sleep(1000);
        WebElement textvalidation= driver.findElement(By.xpath("//p[@id='result']"));
        String actual3=textvalidation.getText().trim();
        String expected3="You entered: You entered techtorial";
        Assert.assertEquals(actual3,expected3);


    }
}
