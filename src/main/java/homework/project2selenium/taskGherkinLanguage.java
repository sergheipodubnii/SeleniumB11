package homework.project2selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class taskGherkinLanguage {
    //Given the user on saucedemo home page
    //Then user click the burger button on saucedemo home page
    //And the user will click the logout button
    //And user should see the login page
    //When the user navigate back from login page
    //Then the user still should see login page
    //Description: The user should not see the home page after
    //logout since the user already click the logout button. Write the
    // test case to test this function and validate it is working correctly or not.
    //Functionality-Acceptance
    //Criteria(Gherkin Language)

  @Test
    public void taskgherkinlanguage() throws InterruptedException {
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
      WebElement burgerbutton=driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
      burgerbutton.click();
      WebElement logoutbutton=driver.findElement(By.id("logout_sidebar_link"));
      logoutbutton.click();

  }



}
