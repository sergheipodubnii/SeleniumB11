package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazontask {
    public static void main(String[] args) throws InterruptedException {
        //Here is your Homework By tomorrow's class. TASK: CREATING AN ACCOUNT FOR AMAZON:
        //1-NAVIGATE TO THE WEBSITE https://www.amazon.com/
        //2_Click Hello, Sign in Button
        //3-Click Create your amazon account button
        //4-Fill the information and click Continue Button
        //5-If there is an error or message. Validate it, if not then you completed the task

        WebDriver driver =new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement signin= driver.findElement(By.xpath("//a[@class='nav-a nav-a-2   nav-progressive-attribute' and @id='nav-link-accountList']"));
        signin.click();
        Thread.sleep(4000);
        WebElement account=driver.findElement(By.id("createAccountSubmit"));
        account.click();
        WebElement name=driver.findElement(By.xpath("//input[@name='customerName']"));
        name.sendKeys("Etiti");
        WebElement phone= driver.findElement(By.xpath("//input[@name='email']"));
        phone.sendKeys("3126854939");
        WebElement password= driver.findElement(By.xpath("//input[@id='ap_password']"));
        password.sendKeys("Meduza1234");
        WebElement reenterpassword=driver.findElement(By.xpath("//input[@id='ap_password_check']"));
        reenterpassword.sendKeys("Meduza1234");
        WebElement button=driver.findElement(By.xpath("//input[@class='a-button-input']"));
        button.click();









    }


}
