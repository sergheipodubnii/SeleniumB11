package homework.homeworkproject3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testcase6 {
    @Test
    public void testcase(){
        //Navigate to "https://demos.telerik.com/kendo-
        //ui/websushi#"
        //Add Shiromi and Ebi Rolls into the cart
        //Click checkout button
        //Validate total price is 17
        //Increase the count of Ebi Roll with 2
        //Validate total is $25
        //Click order now
        //Validate cart is 0
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        
    }
}
