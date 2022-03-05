package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task4 {
    public static void main(String[] args) {
//Navigate to "https://www.saucedemo.com/"
//Enter username "standard_user"
//Enter password "secret_sauce"
//Click Login button
//Validate current url is
//"https://www.saucedemo.com/inventory.html"
//Steps
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username= driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement button= driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        button.click();
        String requiredvalidate="https://www.saucedemo.com/inventory.html";
        System.out.println(driver.getCurrentUrl());
        if(requiredvalidate.equals(driver.getCurrentUrl())){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }









    }
}
