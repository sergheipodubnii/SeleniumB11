package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practicefacebook {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
       WebElement buttonaccount= driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
       buttonaccount.click();
       Thread.sleep(3000);
       WebElement firstname= driver.findElement(By.name("firstname"));
       firstname.sendKeys("Serg");
       WebElement lastname= driver.findElement(By.name("lastname"));
       lastname.sendKeys("Podub");
       WebElement phone= driver.findElement(By.name("reg_email__"));
       phone.sendKeys("3122898764");
       WebElement password= driver.findElement(By.name("reg_passwd__"));
       password.sendKeys("Meduza1234");
       WebElement month= driver.findElement(By.name("birthday_month"));
       month.sendKeys("Jul");
       WebElement day= driver.findElement(By.name("birthday_day"));
       day.sendKeys("20");
       WebElement year=driver.findElement(By.name("birthday_year"));
       year.sendKeys("1990");
       WebElement gender= driver.findElement(By.xpath("//input[@value='2' ]"));
       gender.click();
       WebElement signin=driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']"));
       signin.click();







    }



}
