package homework.project4;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class task3 {
    //Navigate to "https://www.cars.com/" Select "Certified Cars" from drop down Select "Toyota" from All Makes
    //Select "Corolla" from drop down Select max price is "$30000"
    //Select 40 miles from drop down box
    //Insert 60018 as zip code
    //Click search button
    //Validate title has Certified Used
    //Validate "Certified Used Toyota Corolla for Sale" is displayed
    //Validate 40 miles selected in dropdown once you click search button
    //Validate Certified Pre-Owned selected in radio button Validate Toyota is selected in checkbox
    //Validate Corolla is selected in drop down
    @Test
    public void task3() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        WebElement certifiedcars= driver.findElement(By.id("make-model-search-stocktype"));
        Select select=new Select(certifiedcars);
        select.selectByValue("cpo");
        WebElement makecar= driver.findElement(By.xpath("//select[@id='makes']"));
        Select make=new Select(makecar);
        make.selectByValue("toyota");
        WebElement models=driver.findElement(By.xpath("//select[@id='models']"));
        Select model=new Select(models);
        model.selectByValue("toyota-corolla");
        WebElement pricemax= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select price=new Select(pricemax);
        price.selectByValue("30000");
        WebElement distances= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        Select distance=new Select(distances);
        distance.selectByValue("40");
        WebElement zipcode=driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        Thread.sleep(1000);
        zipcode.sendKeys("60018");
        WebElement submitbutton= driver.findElement(By.xpath("//button[@class='sds-button'and @data-linkname='search-cpo-make']"));
        submitbutton.click();


        String expectedheader="Certified used Toyota Corolla for sale";
        WebElement headereactual=driver.findElement(By.xpath("//h1"));
        String actual=headereactual.getText().trim();
        Assert.assertEquals(actual,expectedheader);
        Thread.sleep(2000);
        String actualtitle1= driver.getTitle();
        boolean expected=true;
        boolean actualtitle=actualtitle1.contains("Certified used");
        Assert.assertEquals(actualtitle,expected);
        WebElement distancevalidation= driver.findElement(By.xpath("//select[@id='location-distance']"));
       String actualdistance= distancevalidation.getAttribute("value");
        String expecteddistance="40";
        Assert.assertEquals(actualdistance,expecteddistance);
        WebElement certified= driver.findElement(By.xpath("//select[@id='stock-type-select']//option[5]"));
        String certifiedactual=certified.getText().trim();
        String expectedcertificate="Certified";
        Assert.assertEquals(certifiedactual,expectedcertificate);
        WebElement corollavalidationcheckbox=driver.findElement(By.xpath("//input[@id='model_toyota-corolla']"));
        String carollaactual=corollavalidationcheckbox.getText();
        String expectedcorolla="";
        Assert.assertEquals(carollaactual,expectedcorolla);






    }
}
