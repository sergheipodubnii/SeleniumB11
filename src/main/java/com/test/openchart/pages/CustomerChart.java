package com.test.openchart.pages;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import homework.homework5.pages.Task1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerChart {
    public CustomerChart(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    //CustomerPage-->fill these boxes and validate the message and color
    //6)Click Customers on the side tab
    //7)Click Customers on the open tab from Customers
    //8)Click + button to add customers
    //9)Fill the all boxes
    //10)Click Save button
    //11)validate the message and color
    @FindBy (xpath = "//a[@href='#collapse33']")
    WebElement customerbutton;
    @FindBy(xpath = "//ul[@id='collapse33']//a[contains(text(),'Customers')]")
    WebElement CUSTOMER;
    @FindBy (xpath = "//I[@class='fa fa-plus']")
    WebElement addbutton;
    @FindBy (xpath = "//input[@id='input-firstname']")
    WebElement FIRSTNAME;
    @FindBy (xpath = "//input[@id='input-lastname']")
    WebElement SecondName;
    @FindBy (xpath = "//input[@id='input-email']")
    WebElement EMAIL;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement PHONE;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement PASSWORD;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement CONFIRMPASSWORD;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement savebutton;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement CONFIRM;

    public void Customervalidation(String firstname,String secondname,String email,String phone,String password) throws InterruptedException {
        customerbutton.click();
        Thread.sleep(2000);
        CUSTOMER.click();
        addbutton.click();
        FIRSTNAME.sendKeys(firstname);
        SecondName.sendKeys(secondname);
        Thread.sleep(2000);
        EMAIL.sendKeys(email);
        PHONE.clear();
        PHONE.sendKeys(phone);
        PASSWORD.clear();
        PASSWORD.sendKeys(password);
        CONFIRMPASSWORD.sendKeys(password);
        Thread.sleep(2000);
        savebutton.click();
       // System.out.println(CONFIRM.getText().trim());
        //System.out.println(CONFIRM.getCssValue("color"));
        Assert.assertEquals(CONFIRM.getText().trim(),"Warning: You do not have permission to modify customers!\n" +
                "×");
        Assert.assertEquals(CONFIRM.getCssValue("color"),"rgba(199, 47, 29, 1)");

    }




}
