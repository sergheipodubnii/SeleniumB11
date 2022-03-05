package homework.project4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class task4 {
    //Navigate to "https://www.cars.com/" Select "Certified Cars" from drop down Select "Lexus" from All Makes
    //Select "ES 350" from drop down Select max price is "$50000"
    //Select 50 miles from drop down box
    //Insert 60016 as zip code
    //Click search button
    //Get count of all the cars which is displayed on first page
    //Validate count of the cars is not more than 20
    //Get all car names in first page
    //Validate All car names has "Lexus ES 350"
    //Get the Mile distance from zip code for every car Validate mile distance is no more than 50mil in first page
    // Select Sort By --> Price:Highest in drop down
    //Validate highest price is not more than $50000
    @Test
    public void test4() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        WebElement newandused= driver.findElement(By.id("make-model-search-stocktype"));
        Select select=new Select(newandused);
        select.selectByValue("all");
        WebElement makecar= driver.findElement(By.xpath("//select[@id='makes']"));
        Select make=new Select(makecar);
        make.selectByValue("lexus");
        WebElement models=driver.findElement(By.xpath("//select[@id='models']"));
        Select model=new Select(models);
        model.selectByValue("lexus-es_350");
        WebElement pricemax= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select price=new Select(pricemax);
        price.selectByValue("50000");
        WebElement distances= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        Select distance=new Select(distances);
        distance.selectByValue("50");
        WebElement zipcode=driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        Thread.sleep(1000);
        zipcode.sendKeys("60016");
        WebElement submitbutton= driver.findElement(By.xpath("//button[@class='sds-button' and @data-linkname='search-all-make']"));
        submitbutton.click();
        List<WebElement> allcars= driver.findElements(By.xpath("//a[@class='vehicle-card-link js-gallery-click-link']"));
        int countactual=0;
        int countexpected=20;
        boolean expected=true;

        for(WebElement car:allcars){
            countactual++;
           // System.out.println(car.getText());
            if(car.getText().trim().contains("Lexus ES 350")){
                expected=true;
            }else{
                expected=false;
            }
        }
        Assert.assertEquals(countactual,countexpected);
        Assert.assertTrue(expected);
      // int count=50;
      List<WebElement> milesfrom= driver.findElements(By.xpath("//div[@class='miles-from '] "));
      List<String> miles=new ArrayList<>();
      for(WebElement mile:milesfrom){
        miles.add(mile.getText().trim());
      }

      for(String mile:miles){
         if(!mile.isEmpty()){
             if (50>Integer.parseInt(mile.substring(0,2).trim())){
                 System.out.println("passed");
             }else{
                 System.out.println("failed");
             }

         }

      }
      WebElement sortby= driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
      Select select1=new Select(sortby);
      select1.selectByValue("list_price_desc");
      List<WebElement> prices= driver.findElements(By.xpath("//span[@class='primary-price']"));
      for(WebElement price1:prices){
        //  System.out.println(price1.getText().trim().substring(1).replace(",",""));

         if(50000>Double.parseDouble(price1.getText().trim().substring(1).replace(",",""))){
              System.out.println("highest price is not more than 50000$");
          }else{
              System.out.println("failed .Price is highest than 50000$");
          }
      }

    }
}
