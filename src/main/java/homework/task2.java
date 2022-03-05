package homework;

import com.google.common.hash.HashingOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task2 {
    public static void main(String[] args) throws InterruptedException {

//Navigate to "https://demoqa.com/radio-button"
//Click Yes radio button
//Validate text  is : You have selected Yes
//Click Impressive radio button
//Validate text is : You have selected Impressive
//TIPS: be careful about your xpath if you have any issue with
//getting the text.

        WebDriver driver =new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        WebElement yes = driver.findElement(By.id("yesRadio"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",yes);

        String features="You have selected Yes";
        WebElement text1= driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(text1.getText());
        if(features.equals(text1.getText())){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        WebElement impressive= driver.findElement(By.id("impressiveRadio"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",impressive);

        String feature1="You have selected Impressive";
        WebElement actualimpressive=driver.findElement(By.xpath("//p[@class='mt-3']"));
        System.out.println(actualimpressive.getText());
        if(actualimpressive.getText().equals(feature1)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }









    }
}
