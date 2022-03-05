package homework.homework5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.bind.Element;
import java.util.List;

public class Task2 {
    public Task2(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    //Select Premium Plus 45 TFSI
    // Click View "View key MSRP info" button
    // Validate MSRP is $44,100
    //Validate Additional Options is $595
    //Validate Destination Charge is $1,095
    // Validate Total price is Base price + Additonal Options +
    //Destination Charge
    //Close the MSRP Info
    @FindBy (xpath="//li[2]//span[@class='audi-checkbox-symbol nm-module-trimline-engine-checkbox']")
    List<WebElement> pemiumplus;
    @FindBy (xpath = "//*[@id=\"dbad:audi:basket\"]/div/div/div/div[2]/button/span")
    WebElement msr;
    @FindBy(xpath="//span[contains(text(),'$ 43,300') and @class='nm-module-trimline-engine-price-tag']")
    WebElement msrp;
    @FindBy(xpath = "//span[@class='audi-copy-m']//span[@class='audi-basket-configuration-value__label' and contains(text(),'$ 595')]")
    WebElement additionaloptions;
    @FindBy(xpath="//span[@class='audi-copy-m']//span[@class='audi-basket-configuration-value__label' and contains(text(),'$ 1,195')]")
    WebElement destinationcharge;
    @FindBy(xpath = "//h3//span[contains(text(),'$ 45,090')and @class='audi-basket-configuration-value__label'] ")
    WebElement TOTALPRICE;
    @FindBy (className = "audi-basket_price-details-layer__close_button-icon")
    WebElement closeMsrp;
    public void validationtask2() throws InterruptedException {

       // Thread.sleep(1000);
      // pemiumplus.get(0).click();
       Thread.sleep(1000);
        msr.click();}
  public   int msrprice=Integer.parseInt(msrp.getText().replace("$","").replace(",","").trim());
  public   int additionaloptionsprice=Integer.parseInt(additionaloptions.getText().replace("$","").trim());
  public  int destinationprice=Integer.parseInt(destinationcharge.getText().replace("$","").replace(",","").trim());
    public int validationmsrp(){

      return msrprice;
    }
    public int validateadditionaloptions(){
        return additionaloptionsprice;
    }
    public int  validatedestinationscharge(){
        return destinationprice;

    }
    public int validatetotalprice(){
        return  msrprice+additionaloptionsprice+destinationprice;

    }
    public void closemsrp(){
        closeMsrp.click();

    }

}
