package NikitaMentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SeleniumPaint {
    public static int y=0;
    public static int x=0;
    public static void main(String[] args) throws InterruptedException {


  System.setProperty("webdriver.chrome.driver","chromedriver");
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("http:kleki.com/");
        WebElement canvas= driver.findElement(By.xpath("//canvas"));

        Actions actions=new Actions(driver);
        actions.moveToElement(canvas).clickAndHold().moveByOffset(40,0).perform();
        actions.release().perform();
       actions.moveByOffset(x,y).clickAndHold().moveByOffset(50,0).perform();
       Thread.sleep(2000);
      //  actions.moveByOffset(x,y).clickAndHold().moveByOffset(0,50).perform();
       // actions.moveByOffset(x,y).clickAndHold().moveByOffset(10,40).perform();
        //actions.moveByOffset(x,y).clickAndHold().moveByOffset(20,30).perform();
        //actions.moveByOffset(x,y).clickAndHold().moveByOffset(30,20).perform();
        //actions.moveByOffset(x,y).clickAndHold().moveByOffset(40,10).perform();
     for (int a=0;a<3000;a+=20){
         for (int b=-2000;b<0;b--){
             actions.moveByOffset(x,y).clickAndHold().moveByOffset(b,a).perform();
         }
     }







    Thread.sleep(10000);
    driver.quit();

}}
