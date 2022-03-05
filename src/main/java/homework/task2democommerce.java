package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task2democommerce {
    public static void main(String[] args) throws InterruptedException {
//TASK 2:Creating an account for nopcommerce and validation
//1-NAVIGATE TO THE WEBSITE https://demo.nopcommerce.com/
//2-Click Register
//3-Fill the information
//4-Newsletter box should be left unclicked
//5-Click Register
//6-Validate “Your registration completed”
//7-Click Continue (edited)
//demo.nopcommerce.comdemo.nopcommerce.com
//nopCommerce demo store
//nopCommerce is the open-source eCommerce solution. nopCommerce is available for free.
// It has everything you need to get started in selling physical and digital goods over the internet.

        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
       WebElement register=driver.findElement(By.xpath("//a[@class='ico-register']"));
       register.click();
       Thread.sleep(2000);
       WebElement gender= driver.findElement(By.xpath("//input[@value='M']"));
       gender.click();
       Thread.sleep(1000);
       WebElement firstname= driver.findElement(By.xpath("//input[@id='FirstName']"));
       firstname.sendKeys("Serghei");
       WebElement lastname=driver.findElement(By.xpath("//input[@id='LastName']"));
       lastname.sendKeys("Podub");
       WebElement daybirth=driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
       daybirth.sendKeys("12");
       WebElement monthbirth= driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
     monthbirth.sendKeys("July");
     WebElement yearbirth= driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
     yearbirth.sendKeys("1990");
     WebElement email= driver.findElement(By.xpath("//input[@name='Email']"));
     email.sendKeys("as2d@gmail.com");
     WebElement company= driver.findElement(By.xpath("//input[@name='Company']"));
     company.sendKeys("RET Logistics");//input[@value='M'
     WebElement newsletter=driver.findElement(By.xpath("//input[@id='Newsletter']"));
     newsletter.click();
     WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
     password.sendKeys("Meduza1234");
     WebElement confirmpassword= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
     confirmpassword.sendKeys("Meduza1234");
     WebElement registerbutton= driver.findElement(By.xpath("//button[@id='register-button']"));
     registerbutton.click();
     Thread.sleep(1000);
     WebElement validation=driver.findElement(By.xpath("//div[@class='result']"));
        System.out.println(validation.getText());
        String expect="Your registration completed";
        if (validation.getText().equals(expect)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        WebElement continuebutton =driver.findElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        continuebutton.click();












    }


}
