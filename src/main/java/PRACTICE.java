import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PRACTICE {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.get("https://thepangaia.com/");
        WebElement signin= driver.findElement(By.xpath("//a[@class='site-header__navigation-link body-2'] "));
        signin.click();







    }
}
