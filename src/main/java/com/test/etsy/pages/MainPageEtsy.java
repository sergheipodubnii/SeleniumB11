package com.test.etsy.pages;

import com.test.etsy.EtsyTestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

public class MainPageEtsy  {


        public MainPageEtsy(WebDriver driver){
            PageFactory.initElements(driver,this);
        }
        @FindBy(xpath = "//input[@id='global-enhancements-search-query']")
        WebElement searchbuttom;
@FindBy (xpath="//li//h3")
    List<WebElement> allheader;
        public void searchforiphone(String searchitem){
        searchbuttom.sendKeys(searchitem, Keys.ENTER);

        }
        public boolean validateHeader(){
            for(WebElement header:allheader){
                String head=header.getText().trim().toLowerCase(Locale.ROOT);
                if(head.contains("iphone")|| head.contains("13")||head.contains("case")){
                 return false;
                }

            }
            return true;
        }}




