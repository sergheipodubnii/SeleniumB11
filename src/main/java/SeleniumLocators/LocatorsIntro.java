package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        //getText()---->it gives you the text the element
        WebDriver driver=new ChromeDriver();
        driver.get("file:///Users/sergheipodubnii/Desktop/Techtorial%20(2).html");
        WebElement header= driver.findElement(By.id("techtorial1"));
       String actualText= header.getText();//from the system
       String expectedText="Techtorial Academy";//from the business requirement
        if(actualText.equals(expectedText)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

     WebElement driver1= driver.findElement(By.id("details2"));
        String paragrah=driver1.getText();
        System.out.println(paragrah);
        if(paragrah.equals("To create your account, \n" +
                "        we'll need some basic information about you. This information will be \n" +
                "        used to send reservation confirmation emails, mail tickets when needed \n" +
                "        and contact you if your travel arrangements change. Please fill in the \n" +
                "        form completely.")){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        // Locator :ClassName


        WebElement tools=driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());

        //LOCATOR:Name
    WebElement firstName=driver.findElement(By.name("firstName"));
    firstName.sendKeys("Ahmet");

    WebElement lastname=driver.findElement(By.name("lastName"));
    lastname.sendKeys("Podubnii");

    WebElement phone=driver.findElement(By.name("phone"));
    phone.sendKeys("6626074401");
    WebElement email=driver.findElement(By.name("userName"));
    email.sendKeys("spnmlog@gmail.com");
    WebElement  javaBox=driver.findElement(By.id("cond1"));
        javaBox.click();
        System.out.println(javaBox.isDisplayed());;//return true
        System.out.println(javaBox.isSelected());//return true
    WebElement test=driver.findElement(By.id("cond3"));
    test.click();
    WebElement CUCUMBER=driver.findElement(By.id("cond4"));
    CUCUMBER.click();









    }




}
