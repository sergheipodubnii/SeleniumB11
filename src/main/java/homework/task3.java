package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task3 {
    public static void main(String[] args) {
//Enter username "Java"
//Enter password "Selenium"
//Click Login button
//Validate "Epic sadface: Username and password do not
//match any user in this service" message
//TIPS:to be able to see this message you need to first see this
//message then try to inspect it. (it means at least run one time
//with the username and password you provided above to see
//the message then inspect the message.*be careful with it is
//fully copied or not.
//Steps
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement  username= driver.findElement(By.id("user-name"));
        username.sendKeys("Java");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement button= driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        button.click();
        WebElement actualtext=driver.findElement(By.xpath("//h3"));
        System.out.println(actualtext.getText());
        String required="Epic sadface: Username and password do not match any user in this service";
        if(actualtext.getText().equals(required)){
            System.out.println("validated");
        }else{
            System.out.println("failed");
        }







    }

}
