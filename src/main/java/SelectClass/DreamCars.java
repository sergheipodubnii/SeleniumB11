package SelectClass;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

public class DreamCars {

    @Test
    public void BMW() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        WebElement  usedcars= driver.findElement(By.id("make-model-search-stocktype"));
        Select select=new Select(usedcars);
        select.selectByValue("used");
        WebElement makecar= driver.findElement(By.xpath("//select[@id='makes']"));
        Select make=new Select(makecar);
        make.selectByValue("acura");
        WebElement models=driver.findElement(By.xpath("//select[@id='models']"));
        Select model=new Select(models);
        model.selectByValue("acura-rl");
        WebElement pricemax= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select price=new Select(pricemax);
        price.selectByValue("45000");
        WebElement distances= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        Select distance=new Select(distances);
        distance.selectByValue("30");
        WebElement zipcode=driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        Thread.sleep(1000);
        zipcode.sendKeys("60074");
        WebElement submitbutton= driver.findElement(By.xpath("//button[@class='sds-button' and @type='submit' and @data-linkname='search-used-make']"));
        submitbutton.click();
      List<WebElement> header1=driver.findElements(By.xpath("//h2"));
      for (WebElement head:header1){
        //  boolean car=head.getText().trim().toLowerCase().contains("volvo");
        //  Assert.assertTrue(car);
          String h=head.getText().trim().toLowerCase();
          String expected="acura";
          if(h.contains(expected)){
              System.out.println("passed");
          }
      }

      String expectedheader="Used Acura RL for sale";
      WebElement headereactual=driver.findElement(By.xpath("//h1"));
      String actual=headereactual.getText().trim();
        Assert.assertEquals(actual,expectedheader);








    }

}
