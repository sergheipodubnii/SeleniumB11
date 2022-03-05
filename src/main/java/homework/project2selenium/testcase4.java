package homework.project2selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class testcase4 {
    //Steps
    //Navigate to "https://www.saucedemo.com/"
    //Enter username "standard_user"
    //Enter password "secret_sauce"
    //Click Login button
    //Find the highest priced two product on the page
    //Add them to the cart
    //Click cart button
    //Click CheckOut Button
    //Fill out First Name, Last Name and Zip Code
    //Click continue button
    //Validate Item total price is equals to total price of
    //selected product
    //Validate Total is equals to Item Total price plus Tax
    //amount
    //Validate the Url contains "checkout"
    //Click finish button
    //Validate "THANK YOU FOR YOUR ORDER"


 @Test
    public void testcase4highestprice() throws InterruptedException {
     WebDriver driver=new ChromeDriver();
     driver.get("https://www.saucedemo.com/");
     driver.manage().window().maximize();
     WebElement username= driver.findElement(By.xpath("//input[@id='user-name']"));
     username.sendKeys("standard_user");
     WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
     password.sendKeys("secret_sauce");
     WebElement loginbutton= driver.findElement(By.xpath("//input[@id='login-button']"));
     loginbutton.click();
     Thread.sleep(2000);
     WebElement dropdown= driver.findElement(By.xpath("//select[@class='product_sort_container']"));
    // i wil sort products from High price to Low and i will store it in List and print out
     //Using LOOP JUST FIRST TWO PRODUCTS .

     Thread.sleep(1000);
     Select highlow=new Select(dropdown);
     highlow.selectByValue("hilo");
     Thread.sleep(2000);
     List<WebElement> priceorders= driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
     Set<String> higherpriceproduct=new LinkedHashSet<>();
     for(int i=0;i<2;i++){
         higherpriceproduct.add((priceorders.get(i).getText().trim().substring(1)));
         //i substring 1 because i dont need $ sign in the front of amount.
         System.out.println(priceorders.get(i).getText().trim().substring(1));
     }
     // i select first two elements and add it to the card
     List<WebElement> products= driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
     for(int i=0;i<2;i++){
         products.get(i).click();
     }
     WebElement shoppingcard=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
     shoppingcard.click();
     Thread.sleep(2000);
     WebElement checkoutButton =driver.findElement(By.xpath("//button[@id='checkout']"));
     checkoutButton.click();
     WebElement firstname =driver.findElement(By.id("first-name"));
     firstname.sendKeys("Tech");
     WebElement lastname= driver.findElement(By.id("last-name"));
     lastname.sendKeys("Torial");
     WebElement zipcode=driver.findElement(By.id("postal-code"));
     zipcode.sendKeys("60004");
     WebElement continuebutton=driver.findElement(By.id("continue"));
     continuebutton.click();
     //from set with 2 higher price with LOOP

    // PARSE FROM STRING TO DOUBLE AND ADD IT TO THE SUM !
  double SumofhigherpriceproductExpected=0.0;
  for(String product:higherpriceproduct){
  SumofhigherpriceproductExpected+= Double.parseDouble(product);
  }
  WebElement totalprice=driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
  String totalpriceamount=totalprice.getText().substring(13).trim();
  System.out.println(totalpriceamount);
  double totalpriceamountactual=Double.parseDouble(totalpriceamount);
  Assert.assertEquals(totalpriceamountactual,SumofhigherpriceproductExpected);
  // validate total with taxes
  WebElement taxamounts=driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
  String taxamount=taxamounts.getText().substring(6);

  double amounttax=Double.parseDouble(taxamount)+0.00;
  System.out.println(amounttax);
  double pricetotalexpected=SumofhigherpriceproductExpected+amounttax;
  System.out.println(SumofhigherpriceproductExpected);
  System.out.println(pricetotalexpected);
  WebElement totalactuals= driver.findElement(By.xpath("//div[@class='summary_total_label']"));
  double totalactual=Double.parseDouble(totalactuals.getText().substring(8));
  System.out.println(totalactual);
  Assert.assertEquals(totalactual,pricetotalexpected);
  Thread.sleep(2000);
  String actualUrl= driver.getCurrentUrl();
  boolean containexpected=true;
  boolean containsactual=actualUrl.contains("checkout");
  Assert.assertEquals(containsactual,containexpected);
  WebElement finishbutton = driver.findElement(By.id("finish"));
  finishbutton.click();
  Thread.sleep(2000);
  WebElement textdispalyed=driver.findElement(By.xpath("//h2"));
  String actualtext=textdispalyed.getText().toUpperCase();
  String expectedtext="THANK YOU FOR YOUR ORDER";
  Assert.assertEquals(actualtext,expectedtext);







 }



}
