package JAVAScriptExecution;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSMethods {
    //whenever normal methods are not working then last decision should javaScript
    @Test
    public void TitleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.techtorialacademy.com/");
        System.out.println(driver.getTitle());
     //   JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
       // String title=javascriptExecutor.executeScript("return document.title").toString();
        //System.out.println(title+"from javaScript");
       String actualTitle= BrowserUtils.GetTitleWithJS(driver);
       String expectedTitle="Home Page - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void ClickWithJS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.techtorialacademy.com/");
        WebElement browserCourse= driver.findElement(By.xpath("//a[.='Brown Course']"));
      //  JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;

       // javascriptExecutor.executeScript("arguments[0].click()",browserCourse);
        BrowserUtils.ClickWithJS(driver,browserCourse);

    }
    @Test
    public void ClickWithJsPractice(){
        //click the student loginin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.techtorialacademy.com/");
        WebElement button= driver.findElement(By.xpath("//div[@id='mySidenav']//a[@data-target='#exampleModal2']"));
       // button.click();
        BrowserUtils.ClickWithJS(driver,button);
    }
    @Test
    public void ScrollIntoView(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement copyRight = driver.findElement(By.xpath("//p[contains(text(),'© Copyrights 2021 Techtorial')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",copyRight);
    }
    @Test
    public void Practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement browseCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
        BrowserUtils.ClickWithJS(driver,browseCourse);

        WebElement getStarted = driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a"));

      //  JavascriptExecutor js=(JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true)",getStarted);
        BrowserUtils.ScrollWithJS(driver,getStarted);
        BrowserUtils.ClickWithJS(driver,getStarted);
    }

    @Test
    public void ScroolWithXandYCordTest(){
      //this is a interview questions (point class)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement copyRight = driver.findElement(By.xpath("//p[contains(text(),' Copy')]"));
     //   JavascriptExecutor js=(JavascriptExecutor) driver;
       // Point location=copyRight.getLocation();
        //System.out.println(location.getX());
        //System.out.println(location.getY());
        //int xCord=location.getX();
        //int yCord=location.getY();
        //js.executeScript("window.scrollTo("+xCord+","+yCord+")");
        BrowserUtils.ScrollWithXandYCord(driver,copyRight);


    }


}
