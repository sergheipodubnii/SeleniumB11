package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {

    @Test
    public void validateFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement choosefile= driver.findElement(By.id("file-upload"));
        choosefile.sendKeys("/Users/sergheipodubnii/Desktop/usa.svg.png");
        WebElement uploadButton= driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement validationtext=driver.findElement(By.tagName("h3"));
        String validation=validationtext.getText();
        String expected="File Upload";
        Assert.assertEquals(validation,expected);
        WebElement validationtext1= driver.findElement(By.id("upload-files"));
        String actualmessage2= validationtext1.getText();
        String expected2="usa.svg.png";
        Assert.assertEquals(actualmessage2,expected2);
        WebElement validatemessage= driver.findElement(By.xpath("//h3"));



    }
}
