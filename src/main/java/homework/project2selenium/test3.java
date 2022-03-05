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
import java.util.TreeSet;

public class test3 {
    //Steps
    //Navigate to "https://www.saucedemo.com/"
    //Enter username "standard_user"
    //Enter password "secret_sauce"
    //Click Login button
    //Find the cheapest two product on the page
    //Add them to the cart
    //Click cart button
    //Validate these two products is added to the cart
    //Steps
    @Test
    public void validateaddedproducts() throws InterruptedException {
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
        // I WILL SORT PRODUCT FROM LOW TO HIGH PRICE
        //STORE FIRST TWO IN LIST
        //AND THEN COMPARE IT WITH PRODUCT FROM CHECKOUT List
        Thread.sleep(1000);
        Select lowhigh=new Select(dropdown);
        lowhigh.selectByValue("lohi");
        Thread.sleep(2000);
        List<WebElement> priceorders= driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        Set<String> expectedchepeastproduct=new LinkedHashSet<>();

        for(int i=0;i<2;i++){
        expectedchepeastproduct.add((priceorders.get(i).getText().trim()));
            System.out.println(priceorders.get(i).getText().trim());
        }
        // i select two chepeast product and added to the card
        List<WebElement> products= driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for(int i=0;i<2;i++){
            products.get(i).click();
        }
        WebElement shoppingcard=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingcard.click();

        List<WebElement>  actuallistproducts= driver.findElements(By.className("inventory_item_price"));
        Set<String> actualchepeastproduct=new LinkedHashSet<>();
        for(WebElement product:actuallistproducts){
            actualchepeastproduct.add(product.getText().trim());
            System.out.println(product.getText().trim());

        } Assert.assertEquals(actualchepeastproduct,expectedchepeastproduct);
    }




}
