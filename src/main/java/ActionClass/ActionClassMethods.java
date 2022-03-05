package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {
    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
       WebElement contextMenu= driver.findElement(By.partialLinkText("Context"));
       contextMenu.click();
       WebElement box= driver.findElement(By.id("hot-spot"));
       Actions actions=new Actions(driver);
       //ACTION CLASS YOU MUST USE PERFORM AT THE END .
       actions.contextClick(box).perform();





    }

    @Test
    public void HoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);
        WebElement Hover=driver.findElement(By.linkText("Hovers"));
        Hover.click();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
       List<WebElement> names= driver.findElements(By.tagName("h5"));
        List<WebElement> pictures= driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        for(int i=0;i< names.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform();// hover over here

            Assert.assertEquals(BrowserUtils.getTextMethod(names.get(i)),expectedNames.get(i));
            System.out.println( BrowserUtils.getTextMethod(names.get(i)));;//get text here
        }
    }
    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
       // WebElement doubleclikbutton=driver.findElement(By.xpath("//button"));
        // Actions actions=new Actions(driver);
       // actions.doubleClick(doubleclikbutton).perform();
      //  actions.doubleClick(driver.findElement(By.xpath("//button"))).perform();
        WebElement rightclick= driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions1=new Actions(driver);
        actions1.contextClick(rightclick).perform();


    }

    @Test
    public void Task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://selenium08.blogspot.com/2019/11/double-click.html");
        WebElement DOUBLECLICK=driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions=new Actions(driver);
        actions.doubleClick(DOUBLECLICK).perform();
        Thread.sleep(2000);
        driver.quit();

    }
    @Test
    public void dragAndDrop() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
    driver.manage().window().maximize();
        WebElement acceptCookies=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Thread.sleep(2000);
        acceptCookies.click();
        Actions actions=new Actions(driver);
       // for(int i=0;i<5;i++) {
         //   actions.sendKeys(Keys.ARROW_DOWN).perform();
        //}
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
    WebElement orangebox= driver.findElement(By.xpath("//div[@class='test2']"));
    String actualMessage=BrowserUtils.getTextMethod(orangebox);
    String expectedMessage="... Or here.";
    Assert.assertEquals(actualMessage,expectedMessage);

    actions.dragAndDrop(draggable,orangebox).perform();
    Thread.sleep(3000);
        orangebox= driver.findElement(By.xpath("//div[@class='test2']"));
    String actualAfterDragAndDown=BrowserUtils.getTextMethod(orangebox);
    String expectedAfterDragandDown="You did great!";
    Assert.assertEquals(actualAfterDragAndDown,expectedAfterDragandDown);

    String actualcssValue=orangebox.getCssValue("background-color");
    String expectedCssValue="rgba(238, 111, 11, 1)";
      //  System.out.println(actualcssValue);
        Assert.assertEquals(actualcssValue,expectedCssValue);





}
@Test
    public void ClickAndHold(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement bluebox=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueboxMessage=BrowserUtils.getTextMethod(bluebox);
        String expectedBlueBoxMessage="Drag the small circle here ...";
        Assert.assertEquals(actualBlueboxMessage,expectedBlueBoxMessage);
    WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
    Actions actions=new Actions(driver);
    actions.clickAndHold(draggable).moveToElement(bluebox).release().build().perform();


}
@Test
    public void MoveByOffSet(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider= driver.findElement(By.xpath("//input"));
        Actions actions=new Actions(driver);
        //x means ---> horizontal y means---->vertical
        actions.clickAndHold(slider).moveByOffset(40,0).perform();


}
@Test
    public void SliderShortCut() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/horizontal_slider");
    driver.manage().window().maximize();
    WebElement slider= driver.findElement(By.xpath("//input"));
    WebElement range= driver.findElement(By.xpath("//span[@id='range']"));
  String myrange="3.5";
    while (!range.getText().trim().equals(myrange)){
        Thread.sleep(1000);
        slider.sendKeys(Keys.ARROW_RIGHT);
    }





}
@Test
    public void Task() throws InterruptedException {
        //TASK FOR STUDENTS:
    //1)navigate to the Website "https://text-compare.com/"
    //2)Type with the Keys --> "Good Bye Keys"
    //3)with CTRL(COMMAND)+A --> select all text
    //4)Copy this text CTRL(COMMAND) + C --> it will copy the text
    //5)Go to the second box and paste CTRL(COMMAND) + V-->it will paste the text
    //6) Validate this two boxes text are matching
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://text-compare.com/");
    driver.manage().window().maximize();
    WebElement buttons1=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
    WebElement buttons2= driver.findElement(By.xpath("//textarea[@id='inputText2']"));
    Thread.sleep(2000);
    Actions actions=new Actions(driver);
    actions.moveToElement(buttons1).sendKeys(buttons1,"Good Bye Keys")
            .keyDown(Keys.COMMAND)
            .sendKeys("a")
            .keyUp(Keys.COMMAND)
            .keyDown(Keys.COMMAND)
            .sendKeys("c")
            .keyUp(Keys.COMMAND).moveToElement(buttons2).click()
            .keyDown(Keys.COMMAND)
            .sendKeys("v")
            .keyUp(Keys.COMMAND)
            .perform();





}
@Test
    public  void MovebyOffSet(){
        // by using movebyoofset and point class click contact us
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.techtorialacademy.com/");
    driver.manage().window().maximize();
    WebElement contactus= driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
   Point coordinateOfContactUs=contactus.getLocation();
   int xCoordinates=coordinateOfContactUs.getX();
   int yCoordinates=coordinateOfContactUs.getY();

   Actions actions=new Actions(driver);
   actions.moveByOffset(xCoordinates,yCoordinates).click().perform();




}



}
