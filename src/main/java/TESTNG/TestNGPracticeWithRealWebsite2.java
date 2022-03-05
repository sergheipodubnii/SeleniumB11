package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestNGPracticeWithRealWebsite2 {

    @Test
    public void validationofAscendingOrderofOptions() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));

        catalogBar.click();
        Thread.sleep(1000);
        WebElement options= driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(1000);
        List<WebElement> alloptions= driver.findElements(By.xpath("//tbody/tr/td[2]"));
        Set<String> actualOptions=new LinkedHashSet<>(); // insertion order
        //it accepts insertion order
        Set<String> expectedOptionsOrder=new TreeSet<>(); //ascending order
        for(WebElement option:alloptions){
            actualOptions.add(option.getText().trim());
            expectedOptionsOrder.add(option.getText().trim());
        }
        Assert.assertEquals(actualOptions,expectedOptionsOrder);





    }

    @Test
    public void validationofDescendingOrderOptions() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));

        catalogBar.click();
        Thread.sleep(1000);
        WebElement options= driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(1000);
        WebElement optionamebutton= driver.findElement(By.xpath("//a[.='Option Name']"));
        optionamebutton.click();
        List<WebElement> descenddingalloptions= driver.findElements(By.xpath("//tbody/tr/td[2]"));
        List<String> actualdescendingOrder=new LinkedList<>();
        List<String> expectedDescendingorder1=new ArrayList<>();
        for(int i=0;i<descenddingalloptions.size();i++){
            actualdescendingOrder.add(descenddingalloptions.get(i).getText().trim());
            expectedDescendingorder1.add(descenddingalloptions.get(i).getText().trim());
            Collections.sort(expectedDescendingorder1);
            Collections.reverse(expectedDescendingorder1);

        }  Assert.assertEquals(actualdescendingOrder,expectedDescendingorder1);





    }
    @Test
    public void validationSortOrderDescending() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));

        catalogBar.click();
        Thread.sleep(1000);
        WebElement options= driver.findElement(By.xpath("//a[.='Options']"));
        options.click();
        Thread.sleep(3000);
        WebElement sortorderbutton= driver.findElement(By.xpath("//a[.='Sort Order']"));
        sortorderbutton.click();
        Thread.sleep(2000);
        List<WebElement> descendingorder= driver.findElements(By.xpath("//tbody/tr/td[3]"));
        List<String> actualdescendingOrder=new LinkedList<>();
        List<String> expectedDescendingorder=new ArrayList<>();

        for(int i=0;i<descendingorder.size();i++){
            actualdescendingOrder.add(descendingorder.get(i).getText());
            expectedDescendingorder.add(descendingorder.get(i).getText());


        }  Assert.assertEquals(actualdescendingOrder,expectedDescendingorder);


    }

   @Test
    public void validatesortorderAscending() throws InterruptedException {
       WebDriver driver=new ChromeDriver();
       driver.navigate().to("https://demo.opencart.com/admin/");
       driver.manage().window().maximize();
       WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
       loginButton.click();
       WebElement catalogBar= driver.findElement(By.id("menu-catalog"));

       catalogBar.click();
       Thread.sleep(1000);
       WebElement options= driver.findElement(By.xpath("//a[.='Options']"));
       options.click();
       Thread.sleep(1000);
       WebElement sortorderbutton= driver.findElement(By.xpath("//a[.='Sort Order']"));
       sortorderbutton.click();
       WebElement sortorderbutton1= driver.findElement(By.xpath("//a[.='Sort Order']"));
       sortorderbutton1.click();
       List<WebElement> sortorder= driver.findElements(By.xpath("//tbody/tr/td[3]"));
       Set<String> actualsortOrder=new LinkedHashSet<>(); // insertion order
       //it accepts insertion order
       Set<String> expectedSortOrder=new TreeSet<>(); //ascending order
       for(WebElement order:sortorder){
           actualsortOrder.add(order.getText().trim());
           expectedSortOrder.add(order.getText().trim());
       }
       Assert.assertEquals(actualsortOrder,expectedSortOrder);
   }





}
