package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FINDELEMENTS {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement abstesting=driver.findElement(By.linkText("ng"));
        System.out.println(abstesting.getText());
        List<WebElement> alllinks=driver.findElements(By.xpath("//li/a"));
        int count=0;
        for(WebElement link:alllinks){
         //   System.out.println(link.getText());
            if(link.getText().length()<=12){
                System.out.println(link.getText());
                count++;
            }
        }

        System.out.println(count);




    //can you find only the links that have size less then 12 and count
        //how many we have










    }




}
