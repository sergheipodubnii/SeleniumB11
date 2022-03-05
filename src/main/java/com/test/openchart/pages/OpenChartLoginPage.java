package com.test.openchart.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class OpenChartLoginPage {
    public OpenChartLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
   @FindBy (xpath = "//input[@id='input-username']")
    WebElement username;
    @FindBy(xpath ="//input[@id='input-password']")
    WebElement password;
    @FindBy (xpath ="//button[@type='submit']")
    WebElement login;
    public void loginpage(){
        username.clear();
        this.username.sendKeys("demo");
        password.clear();
        this.password.sendKeys("demo");
        login.click();
    }
}
