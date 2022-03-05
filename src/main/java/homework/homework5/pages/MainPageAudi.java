package homework.homework5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPageAudi {
    public MainPageAudi(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath="//button[@aria-label='Close' and @class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")
    WebElement cookies;
    @FindBy (xpath = "//span[contains(text(),'SUVs & Wagons') and @class='audi-link-m']")
    WebElement suvsandwagons;
    @FindBy (xpath="//ul[@class='nm-model-band-container-types']//..//li[4]//div[@class='nm-model-band-container-item-car-info']//..//span[@class='nm-model-band-container-item-label audi-link-m'and contains(text(),'2022 Audi Q5')]")
    WebElement q5;

    @FindBy (xpath = "//a[@class='sc-fzqBZW jkEZoQ']")
    WebElement build;
    public void mainpagesearch() throws InterruptedException {
        Thread.sleep(1000);
        cookies.click();
        suvsandwagons.click();
        Thread.sleep(1000);
        q5.click();
        Thread.sleep(1000);

        build.click();
    }
}
