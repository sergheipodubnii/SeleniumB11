package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPractice {
    @Test
    public void ValidationDragandDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,droppable).perform();
        Thread.sleep(2000);
        droppable=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Thread.sleep(2000);
       // String actualAfterDragAndDown= BrowserUtils.getTextMethod(droppable);
        WebElement fff=driver.findElement(By.xpath("//div[@class='drop-box ui-droppable ui-state-highlight']"));
        String actualAfterDragAndDown= fff.getText().trim();
        String expected="Dropped!";
        Assert.assertEquals(actualAfterDragAndDown,expected);
        String actualcssValue=droppable.getCssValue("background-color");
        String expectedcc="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualcssValue,expectedcc);




    }
    @Test
    public void ClickAndHoldPractice() throws InterruptedException {
        //1)Navigate to the website :"https://demoqa.com/droppable"
        //        2)Click Accept
        //        3)ClickAndHold notAccepted box and release to Drop box
        //        4)validate the background is still white and message is still Drop here
        //        5)ClickAndHold acceptable box and release to Drop box
        //        6)Validate the background is blue and message is dropped

   WebDriverManager.chromedriver().setup();
   WebDriver driver=new ChromeDriver();
   driver.get("https://demoqa.com/droppable");
   driver.manage().window().maximize();
      //  Actions actions=new Actions(driver);
   Thread.sleep(3000);
   WebElement accept=driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
   accept.click();
   Thread.sleep(3000);
   WebElement notacceptable;
   WebElement DropBox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
   Actions actions=new Actions(driver);
        notacceptable= driver.findElement(By.xpath("//div[@id='notAcceptable']"));
   actions.clickAndHold(notacceptable).moveToElement(DropBox).release(notacceptable).build().perform();

        DropBox= driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
   String actualcolor=DropBox.getCssValue("background-color");
   String EXPECTED="rgba(0, 0, 0, 0)";
   Assert.assertEquals(actualcolor,EXPECTED);
   WebElement accpetable= driver.findElement(By.xpath("//div[@id='acceptable']"));
   WebElement dropbox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
   Actions actions1=new Actions(driver);
   actions1.clickAndHold(accpetable).moveToElement(dropbox).release(accpetable).perform();
   dropbox=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
   String coloractual=dropbox.getCssValue("background-color");
   String colorexpected="rgba(70, 130, 180, 1)";

Assert.assertEquals(coloractual,colorexpected);
String expected="Dropped!";
String actual=dropbox.getText();
Assert.assertEquals(actual,expected);


    }
}
