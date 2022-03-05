package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class uploadtask {
    @Test
    public void task(){
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        driver.manage().window().maximize();
        WebElement uploadfile= driver.findElement(By.id("uploadfile_0"));
        uploadfile.sendKeys("/Users/sergheipodubnii/Desktop/usa.svg.png");
        WebElement clickbox=driver.findElement(By.xpath("//input[@id='terms']"));
        clickbox.click();
        Assert.assertTrue(clickbox.isSelected());
        WebElement CLICK=driver.findElement(By.xpath("//button[@id='submitbutton']"));
        CLICK.click();
        WebElement validatemessage= driver.findElement(By.xpath("//h3"));
        String message= validatemessage.getText();
        String expected="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(message,expected);

    }
}
