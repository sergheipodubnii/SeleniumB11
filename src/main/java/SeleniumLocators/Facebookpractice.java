package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebookpractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        String actualUrl=driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());

        String expectedaURL="https://www.facebook.com/";
        if(actualUrl.equals(expectedaURL)){
            System.out.println("true");
        }else{
            System.out.println("failed");
        }
        WebElement logIn = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        boolean validationbutton=logIn.isDisplayed();
        boolean expextvalidation=true;
        if(validationbutton==expextvalidation){
            System.out.println("button is displayed");
        }else{
            System.out.println("button is not displayed");
        }





        logIn.click();
        Thread.sleep(5000);
        WebElement firstname= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("Serg");
        WebElement lastname=driver.findElement(By.name("lastname"));
        lastname.sendKeys("Podu");
        WebElement number= driver.findElement(By.xpath("//input[@name='reg_email__']"));
        number.sendKeys("3122569605");
        WebElement password= driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("sdfsdwfs@gmail.com");

        WebElement month=driver.findElement(By.name("birthday_month"));
        month.sendKeys("Jul");
        WebElement day=driver.findElement(By.name("birthday_day"));
        day.sendKeys("19");
        WebElement year= driver.findElement(By.name("birthday_year"));
        year.sendKeys("1989");
        WebElement gender=driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
        gender.click();
        WebElement button1=driver.findElement(By.name("websubmit"));
        button1.click();






    }


}
