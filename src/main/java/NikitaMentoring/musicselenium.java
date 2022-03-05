package NikitaMentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class musicselenium {

    public static  void playnotes(String[] notes,HashMap<String,WebElement> instrument) throws InterruptedException {
        for(String note:notes){
            instrument.get(note).click();
            Thread.sleep(500);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.musicca.com/piano");
        driver.manage().window().maximize();
      //  List<WebElement> whitekeys= driver.findElements(By.xpath("//span[@class='white-key']"));
       // List<WebElement> blackkeys= driver.findElements(By.xpath("//span[@class='black-key']"));
        //HashMap<WebElement,String> whitekeysMap=new LinkedHashMap<>();
        //HashMap<WebElement,String> blackkeysMap=new LinkedHashMap<>();

        List<WebElement> keys= driver.findElements(By.xpath("//span[@data-key]"));

        HashMap<String,WebElement> keyboard=new HashMap<>();//hashmap no order randomly

        for(WebElement key:keys){
            keyboard.put(key.getAttribute("data-note"),key );

        }

       String[] test={"3ais","2d","2d","3ais","3ais","2d","2d","3ais","3ais","2d","2dis","2d","2c","2c","2c","3a","3a"};
        playnotes(test,keyboard);
        //nullPointException














    }
}
