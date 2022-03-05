package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.yahoo.com/");
driver.manage().window().maximize();
       WebElement newsbutton= driver.findElement(By.id("root_2"));
       newsbutton.click();

        List<WebElement> headers= driver.findElements(By.xpath("//h3"));
        int counter=0;
      for(int i =0;i<headers.size();i++){
         // headers.get(i).getText();
          if(headers.get(i).getText().toUpperCase().contains("COVID")){
              System.out.println(headers.get(i).getText());
              counter++;
          }
      }
        System.out.println(counter);

    }
}
