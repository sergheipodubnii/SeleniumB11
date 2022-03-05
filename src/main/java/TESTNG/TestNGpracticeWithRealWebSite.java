package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGpracticeWithRealWebSite {

  @Test // i am testing the website is correct or not
    public void validateWebsite(){
    WebDriver driver=new ChromeDriver();

    driver.get("https://demo.opencart.com/admin/");
    driver.manage().window().maximize();
    String actualWebsite= driver.getCurrentUrl();
    String expectedWebsite="https://demo.opencart.com/admin/";
    Assert.assertEquals(actualWebsite,expectedWebsite);
    WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
    loginButton.click();
  }
  @Test
  public void validateCatalogisDisplay(){
    WebDriver driver=new ChromeDriver();

    driver.get("https://demo.opencart.com/admin/");
    driver.manage().window().maximize();


    WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
    loginButton.click();
    WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
    boolean catalog=catalogBar.isDisplayed();
    boolean ExpectedCtalog=true;
    Assert.assertEquals(catalog,ExpectedCtalog,"CATALOG IS NOT THERE");
    catalogBar.click();
  }
   @Test
  public void validateProductsisDisplayed(){
     WebDriver driver=new ChromeDriver();

     driver.get("https://demo.opencart.com/admin/");
     driver.manage().window().maximize();


     WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
     loginButton.click();
     WebElement catalogBar= driver.findElement(By.id("menu-catalog"));

     catalogBar.click();
     WebElement productBar= driver.findElement(By.xpath("//a[.='Products']"));
     boolean actual =productBar.isDisplayed();
     boolean expected=true;
     Assert.assertEquals(actual,expected);
     productBar.click();



   }
   @Test
  public void validationofBoxes() throws InterruptedException {
     WebDriver driver=new ChromeDriver();

     driver.get("https://demo.opencart.com/admin/");
     driver.manage().window().maximize();


     WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
     loginButton.click();
     WebElement catalogBar= driver.findElement(By.id("menu-catalog"));

     catalogBar.click();
     WebElement productBar= driver.findElement(By.xpath("//a[.='Products']"));
     Thread.sleep(200);
     productBar.click();
     List<WebElement> boxes= driver.findElements(By.xpath("//input[@type='checkbox']"));
     for(int i =1;i< boxes.size();i++){
       Thread.sleep(500);
       boxes.get(i).click();
       boolean actualboxValidation=boxes.get(i).isDisplayed();
       boolean expextedvalidationbox=true;
       Assert.assertEquals(actualboxValidation,expextedvalidationbox);
       boolean actualboxValidationisSelected=boxes.get(i).isSelected();
       boolean expectedisSelected=true;
       Assert.assertEquals(actualboxValidationisSelected,expectedisSelected);
     }



   }





}
