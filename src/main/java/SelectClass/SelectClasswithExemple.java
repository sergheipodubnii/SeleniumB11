package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectClasswithExemple {
    @Test
    public void ValidationTripButton(){
        WebDriverManager.chromedriver().setup();//important!!!!!1
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement onewayButton= driver.findElement(By.xpath("//input[@value='oneway']"));
        onewayButton.click();
        Assert.assertTrue(onewayButton.isDisplayed());// it must be true to pass the assertion
        Assert.assertTrue(onewayButton.isSelected());
        WebElement roundTrip= driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertFalse(roundTrip.isSelected());
        Assert.assertTrue(roundTrip.isDisplayed());
    }
    @Test
    public void SecondWay(){
        WebDriverManager.chromedriver().setup();//important!!!!!1
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement onewayButton= driver.findElement(By.xpath("//input[@value='oneway']"));
        onewayButton.click();

        WebElement passengerCount= driver.findElement(By.name("passCount"));
        BrowserUtils.selectBy(passengerCount,"2","value");
      //  Select psnger=new Select(passengerCount);
       // psnger.selectByIndex(1);
        WebElement departfrom= driver.findElement(By.name("fromPort"));
       // Select depart=new Select(departfrom);
        //depart.selectByValue("Sydney");
        BrowserUtils.selectBy(departfrom,"Paris","text");
        WebElement month=driver.findElement(By.name("fromMonth"));
      //  Select mnth=new Select(month);
        //mnth.selectByVisibleText("April");
        BrowserUtils.selectBy(month,"April","text");
        WebElement day=driver.findElement(By.name("fromDay"));
       // Select dy=new Select(day);
        //dy.selectByIndex(10);
        BrowserUtils.selectBy(day,"10","index");
        WebElement towhere= driver.findElement(By.name("toPort"));
      //  Select where=new Select(towhere);
        //where.selectByVisibleText("Seattle");
        BrowserUtils.selectBy(towhere,"Seattle","text");
        WebElement monthreturn= driver.findElement(By.name("toMonth"));
        //Select returnM=new Select(monthreturn);
        //returnM.selectByVisibleText("August");
        BrowserUtils.selectBy(monthreturn,"August","text");
       WebElement returnday=driver.findElement(By.name("toDay"));
     //  Select dayreturn=new Select(returnday);
       //dayreturn.selectByIndex(10);
        BrowserUtils.selectBy(returnday,"10","index");
       WebElement classchoose= driver.findElement(By.xpath("//input[@value='Business']"));
       classchoose.click();
      WebElement selectairline= driver.findElement(By.xpath("//select[@name='airline']"));
     // Select airline=new Select(selectairline);
      //airline.selectByIndex(2);
        BrowserUtils.selectBy(selectairline,"2","index");
      WebElement clickbutton= driver.findElement(By.name("findFlights"));
      clickbutton.click();
      String expected="After flight finder - No Seats Available";
      WebElement actual= driver.findElement(By.xpath("//tbody/tr[1]/td[1]/p[1]/font[1]/b[1]/font[1]"));
      String actualtext=actual.getText().trim();
    //  Assert.assertEquals(actualtext,expected);





    }

    @Test
    public void SelectMethod(){
        WebDriverManager.chromedriver().setup();//important!!!!!1
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement onewayButton= driver.findElement(By.xpath("//input[@value='oneway']"));
        onewayButton.click();

        WebElement passengerCount= driver.findElement(By.name("passCount"));
        Select psnger=new Select(passengerCount);
        psnger.selectByIndex(1);
        WebElement departfrom= driver.findElement(By.name("fromPort"));
        Select depart=new Select(departfrom);
        depart.selectByValue("Sydney");
        WebElement month=driver.findElement(By.name("fromMonth"));
        Select mnth=new Select(month);
        mnth.selectByVisibleText("April");
        WebElement day=driver.findElement(By.name("fromDay"));
        Select dy=new Select(day);
        dy.selectByIndex(10);
        WebElement towhere= driver.findElement(By.name("toPort"));
        Select where=new Select(towhere);
        where.selectByVisibleText("Seattle");
        WebElement monthreturn= driver.findElement(By.name("toMonth"));
        Select returnM=new Select(monthreturn);
        returnM.selectByVisibleText("August");
        WebElement returnday=driver.findElement(By.name("toDay"));
        Select dayreturn=new Select(returnday);
        dayreturn.selectByIndex(10);
        WebElement classchoose= driver.findElement(By.xpath("//input[@value='Business']"));
        classchoose.click();
        WebElement selectairline= driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline=new Select(selectairline);
        airline.selectByIndex(2);
        WebElement clickbutton= driver.findElement(By.name("findFlights"));
        clickbutton.click();
        String expected="After flight finder - No Seats Available";
        WebElement actual= driver.findElement(By.xpath("//tbody/tr[1]/td[1]/p[1]/font[1]/b[1]/font[1]"));
        String actualtext=actual.getText().trim();
        Assert.assertEquals(actualtext,expected);







}



}
