package WindowHandle;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeWindowHandling {

    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement multipleTabs=driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        multipleTabs.click();
        BrowserUtils.switchByTitle(driver,"Basic Controls");
        WebElement header= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualheader= header.getText().trim();
        String expectedheader="Basic Controls";
        Assert.assertEquals(actualheader,expectedheader);
        WebElement firstname= driver.findElement(By.id("firstName"));
        firstname.sendKeys("Serghei");
        WebElement lastname= driver.findElement(By.id("lastName"));
        lastname.sendKeys("podubnii");
        WebElement gender= driver.findElement(By.xpath("//input[@id='malerb']"));
        gender.click();
        WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("spmlog.@gmail.com");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("122345");
        WebElement register= driver.findElement(By.id("registerbtn"));
        register.click();
        Thread.sleep(2000);
        String expectedmessage="Registration is Successful";
        WebElement textactual= driver.findElement(By.xpath("//label[@id='msg']"));
        String actual=textactual.getText();
        Assert.assertEquals(actual,expectedmessage);
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement click= driver.findElement(By.id("alertBox"));

        click.click();
        Thread.sleep(3000);
         driver.quit();



    }
}
