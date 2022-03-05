package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectBasics {
    @Test
    public void practice1() throws InterruptedException {
        //firefox exemple  !!!!!!!!!
      /*  WebDriverManager.firefoxdriver().setup();
      WebDriver driver=new FirefoxDriver();
      driver.get("https://the-internet.herokuapp.com/");
       */
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropDown= driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement optionBox=driver.findElement(By.id("dropdown"));
        Select option =new Select(optionBox); //provide webelement location
     option.selectByIndex(2);
     Thread.sleep(1000);// return option2
       option.selectByValue("2");
       Thread.sleep(1000);
        option.selectByVisibleText("Option 1");
        Thread.sleep(1000);
        List<WebElement> options=option.getOptions();
        for(WebElement optn: options){
          // String optionsfromoptions= optn.getText().trim();
            System.out.println(optn.getText().trim());
        }

    }




}
