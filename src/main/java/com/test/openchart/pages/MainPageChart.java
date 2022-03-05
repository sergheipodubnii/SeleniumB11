package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPageChart {
    public MainPageChart(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    //MainPage-->do these validations
    //3-Validate totalorders is "12K"
    //4-Validate totalsales is "11.8M"
    //5)Validate Customers is "144.8K"
    //CustomerPage-->fill these boxes and validate the message and color
@FindBy(xpath="//i[@class='fa fa-shopping-cart']//..//h2[@class='pull-right']")
    WebElement totalorder;
    @FindBy(xpath = "//i[@class='fa fa-credit-card']//..//h2[@class='pull-right']")
    WebElement totalsales;
    @FindBy(xpath = "//i[@class='fa fa-user']//..//h2[@class='pull-right']")
    WebElement customers;
    public void validationmainpage(String ordertotal,String salestotal,String customertotal){
        Assert.assertTrue(totalorder.getText().trim().equals(ordertotal));
        Assert.assertTrue(totalsales.getText().trim().equals(salestotal));
        Assert.assertTrue(customers.getText().trim().equals(customertotal));

    }
}
