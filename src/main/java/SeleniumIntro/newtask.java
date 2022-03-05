package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class newtask {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement title=driver.findElement(By.xpath("//h3"));
        System.out.println(title.getText());
        WebElement paragraf= driver.findElement(By.xpath("//h4[@class='subheader'] "));
        System.out.println(paragraf.getText());
        WebElement powered= driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']"));
        System.out.println(powered.getText());

        //CONTAINS : IT WORKS WITH TEXT

        // tagname[contains(text(),'HorizontalLine'] // %60

        WebElement containsmethod= driver.findElement(By.xpath("//h3[contains(text(),'Horizontal Slider')]"));
        System.out.println(containsmethod.getText());

        //Text: it works with text as well . this is for simplier than contains method .
        //it looks for the exact text

        //h3[.='text']







    }
}
