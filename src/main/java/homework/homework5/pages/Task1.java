package homework.homework5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Locale;

public class Task1 {
    public Task1(WebDriver driver){
        PageFactory.initElements(driver,this);
        //Navigate to "https://www.audiusa.com/"
        //Click SUVs & Wagons
        // Get all the product prices for SUVs & Wagons
        //Select 2022 Q5
        // Validate the car year and Q5 is matching
        // Click Build button
        //Validate starting price is "44,100"
        // Validate three version of car
        //Premium starting at 44,100 Premium Plus starting at
        //49,100 Prestige starting at 54,800
        //Validate three version has two different options
        // 45 TFSI
        //55 TFSI® e Plug-in hybrid

    }
    @FindBy (xpath="//button[@aria-label='Close' and @class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
  WebElement cookies;
    @FindBy (xpath = "//span[contains(text(),'SUVs & Wagons') and @class='audi-link-m']")
    WebElement suvsandwagons;
    @FindBy (xpath="//ul[@class='nm-model-band-container-types']//..//li[4]//div[@class='nm-model-band-container-item-car-info']//..//span[@class='nm-model-band-container-item-label audi-link-m'and contains(text(),'2022 Audi Q5')]")
    WebElement q5;
    @FindBy (xpath = "//h1")
    WebElement title;
    @FindBy (xpath = "//a[@class='sc-fzqBZW jkEZoQ']")
    WebElement build;
    @FindBy (xpath = "//div[contains(text(),'Premium')]//..//span[contains(text(),'$ 43,300')]")
    WebElement premium;
    @FindBy(xpath = "//div[contains(text(),'Premium Plus')]//..//span[contains(text(),'$ 48,300')]")
    WebElement premiumplus;
    @FindBy(xpath = "//div[contains(text(),'Prestige')]//..//span[contains(text(),'$ 54,000')]")
    WebElement prestige;

    public void task1validation(String titlevalidation,String premiumprice,String premiumplusprice,String prestigeprice) throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(title.getText().trim(),titlevalidation);

        Assert.assertEquals(premium.getText().trim(),premiumprice);
        Assert.assertEquals(premiumplus.getText().trim(),premiumplusprice);
        Assert.assertEquals(prestige.getText().trim(),prestigeprice);
    }
    public String validationPremium(){
        return premium.getText().trim();
    }
    public String validationpremiumplus(){
        return premium.getText().trim();
    }
    public String validateprestige(){
        return prestige.getText().trim();
    }

}
