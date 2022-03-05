package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1 {
    public static void main(String[] args) throws InterruptedException {
     //navigate to "https://demoqa.com/text-box"
        //Enter your full name, email, current and permanent address
        //Click submit button.
        //Validate that all of your information is displayed and
        //matching correctly.
        //TIPS:Think about if conditions.
        //Example:
        //Name:David
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement fullname= driver.findElement(By.id("userName"));
        //  we can use by xpath //input[@id='userName'];
        fullname.sendKeys("Serghei Podubnii");



        WebElement email= driver.findElement(By.id("userEmail"));
        //xpath //input[@type='email']

        email.sendKeys("spmlog@gmail.com");
        WebElement currentadress= driver.findElement(By.id("currentAddress"));
        currentadress.sendKeys("1234 w argyle Chicago Il");
        WebElement permanentadress= driver.findElement(By.id("permanentAddress"));
        permanentadress.sendKeys("4321 e foster chicago il");
        // CHECK SUBLINE SOMETIMES WE NEED JAVASCRIPT FOR CLICK BUTTON !!!!!!!
        WebElement button= driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(500);

        button.click();


       WebElement actualname= driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(actualname.getText());
        String expectname="Name:Serghei Podubnii";
        if(expectname.equals(actualname.getText())){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        };

        WebElement actualemail=driver.findElement(By.xpath("//p[2]"));
        System.out.println(actualemail.getText());
        String expecteemail="Email:spmlog@gmail.com";
        if(expecteemail.equals(actualemail.getText())){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        };
        WebElement actualcurrentadress=driver.findElement(By.xpath("//p[3]"));
        System.out.println(actualcurrentadress.getText());
        String expectedcurrentadress="Current Address :1234 w argyle Chicago Il";
        if(expectedcurrentadress.equals(actualcurrentadress.getText())){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        };
        WebElement actualpermanentadress=driver.findElement(By.xpath("//p[4]"));
        System.out.println(actualpermanentadress.getText());
        String expectedpermanentadress="Permananet Address :4321 e foster chicago il";
        if(actualpermanentadress.getText().equals(expectedpermanentadress)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }






















    }






}
