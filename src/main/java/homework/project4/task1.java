package homework.project4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class task1 {
    //Navigate to "http://uitestpractice.com/Students/Select#"
    // Validate India is selected by default on drop down box
    //Validate the size of the Drop down box is 4 Validate the values for Drop down box are :
    //India
    //United States of America
    //China England
    //Select the China with index number Select the England with value
    //Select the United States with visible text
    @Test
    public void TestCase1(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        WebElement defaultvalidation=driver.findElement(By.xpath("//select[@id='countriesSingle']"));
       String actualdefaultvalue= defaultvalidation.getAttribute("value");//india
       String expecteddefaultvalue="india";
        Assert.assertEquals(actualdefaultvalue,expecteddefaultvalue);



        List<WebElement>  validations= driver.findElements(By.xpath("//select[@id='countriesSingle']//option"));
        int actualsize =0;
     Set<String> countrys=new LinkedHashSet<>();

     for(int i=0;i< validations.size();i++ ){
            actualsize++;
            countrys.add(validations.get(i).getText());
        }
        Set<String> expected=new LinkedHashSet<>();

     expected.add("India");
     expected.add("United states of America");
     expected.add("China");
     expected.add("England");
        System.out.println(actualsize);
        int  expectedsize=4;

     Assert.assertEquals(countrys,expected);
     Assert.assertEquals(actualsize,expectedsize);

    }
}
