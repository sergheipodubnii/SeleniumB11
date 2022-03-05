package homework.project4;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class task2 {
    //Navigate to Navigate to "http://uitestpractice.com/Students/Select#" Validate the values for Multiple Select are :
    //India
    //United States of America
    //China England
    //Select China and England Validate "China England" is displayed
    //Deselect all the countries Select All the countries
    //Validate "India United states of America China
    //England" is displayed
    //Deselect the China with index number Deselect the England with value
    @Test
    public void test2() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        List<WebElement> multipleselect=driver.findElements(By.xpath("//select[@id='countriesMultiple']//option"));
        Set<String> countrys=new LinkedHashSet<>();
        Thread.sleep(2000);
        for(WebElement contry:multipleselect){
            countrys.add(contry.getText().trim().toLowerCase(Locale.ROOT));

        }
        Set<String> expected=new LinkedHashSet<>();

        expected.add("india");
        expected.add("united states of america");
        expected.add("china");
        expected.add("england");
        Assert.assertEquals(countrys,expected);
       Thread.sleep(1000);
      WebElement  multipleselectmethod=driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        BrowserUtils.selectBy(multipleselectmethod,"china","value");
        BrowserUtils.selectBy(multipleselectmethod,"england","value");
        WebElement isdisplayed= driver.findElement(By.xpath("//div[@id='result']"));
        String actualisdisplayed=isdisplayed.getText().trim();
        String expecteddisplayed="China England";
        Assert.assertEquals(actualisdisplayed,expecteddisplayed);
        Select listcountrys=new Select(multipleselectmethod);
        listcountrys.deselectAll();
        Thread.sleep(1000);
        for(int i=0;i<=3;i++){
            listcountrys.selectByIndex(i);
        }
        WebElement isdisplayed2= driver.findElement(By.xpath("//div[@id='result']"));
        String actualisdisplayed2=isdisplayed.getText().trim();
        String expecteddisplayed2="India United states of America China England";
        Assert.assertEquals(actualisdisplayed2,expecteddisplayed2);
        listcountrys.deselectByIndex(2);
        listcountrys.deselectByValue("england");
        Thread.sleep(2000);





    }
}
