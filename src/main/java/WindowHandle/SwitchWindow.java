package WindowHandle;

import Utils.BrowserUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;

public class SwitchWindow {
    @Test
    public  void practice1() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getWindowHandle());
        WebElement clickhere= driver.findElement(By.xpath("//a[.='Click Here']"));
        clickhere.click();
       Thread.sleep(2000);
        System.out.println(driver.getWindowHandles());
        String mainPageID= driver.getWindowHandle();
        Set<String> allpagesId= driver.getWindowHandles();
        //this implementation for only 2 tabs
        for(String id: allpagesId){
            System.out.println(id);
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
            }
        }
        WebElement header= driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(header.getText());
        String actualtext= header.getText();
       String expectedtext="New Window";
        Assert.assertEquals(actualtext,expectedtext);
    }

    @Test
    public void practice2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
       WebElement CLICKHERE= driver.findElement(By.xpath("//button[@id='newTabBtn']"));
       String mainpageid= driver.getWindowHandle();
       CLICKHERE.click();
     //  Set<String> allids= driver.getWindowHandles();
       //for(String id:allids){
         //  if(!id.equals(mainpageid)){
           //    driver.switchTo().window(id);
          // }
      // }
        BrowserUtils.SwithTwoTabs(driver,mainpageid);
       WebElement gettextmain= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        System.out.println(gettextmain.getText());
        String actual=gettextmain.getText();
        String expected="AlertsDemo";
        Assert.assertEquals(actual,expected);

        WebElement clicksecond= driver.findElement(By.xpath("//button[@id='alertBox']"));
        clicksecond.click();
    }
}
