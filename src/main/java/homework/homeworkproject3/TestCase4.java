package homework.homeworkproject3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase4 {
    @Test
    public void testcase4(){
        //Navigate to "https://demos.telerik.com/kendo-
        //ui/websushi#"
        //Validate price of all the products are less than $25
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        List<WebElement> itemsprice= driver.findElements(By.xpath("//span[@data-bind='text: price']"));

        double limit=25.0;
        for(int i =0;i<itemsprice.size();i++){
            if(limit>Double.parseDouble(itemsprice.get(i).getText().trim())){
                System.out.println("There is no items bigger then $25.0");
            }
            else{
                System.out.println("failed");
            }

        }


    }
}
