package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PimPage {

    public PimPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="menu_pim_viewPimModule")
    WebElement PIM;
    @FindBy(id="menu_pim_addEmployee")
    WebElement addEmployee;
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='middleName']")
    WebElement middleName;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='employeeId']")
    WebElement ID;
    @FindBy(xpath = "//input[@id='photofile']")
    WebElement ChooseFile;
    @FindBy(id = "btnSave")
    WebElement save;
    @FindBy(name = "personal[txtEmpFirstName]")
    WebElement validationName;
    @FindBy(name="personal[txtEmpLastName]")
    WebElement validationLastName;
    @FindBy(name="personal[txtEmployeeId]")
    WebElement validationEmployeeId;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement EDIT;
    @FindBy(xpath = "//input[@id='personal_optGender_1']")
    WebElement gender;
    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    WebElement nationality;
    @FindBy(xpath = "//select[@id='personal_cmbMarital']")
    WebElement maritalstatus;
    @FindBy(xpath = "//input[@id='personal_DOB']")
    WebElement dateofbirth;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement Savebutton;

    public void editPersonalDetails(String nation,String MARITALSTATUS,String date){
        EDIT.click();
        gender.click();
        Select select=new Select(nationality);
        select.selectByValue(nation);
        Select select1=new Select(maritalstatus);
        select1.selectByValue(MARITALSTATUS);
        dateofbirth.clear();
        this.dateofbirth.sendKeys(date);
        Savebutton.click();
    }
    public String validateTheNationality(){
        Select select=new Select(nationality);
        return select.getFirstSelectedOption().getText().trim();
    }


    public void setAddEmployeeforPIM(String firstname,String middlename,String lastname,String id,String file) throws InterruptedException {

        this.addEmployee.click();
        this.firstName.sendKeys(firstname);
        this.middleName.sendKeys(middlename);
        this.lastName.sendKeys(lastname);
        this.ID.sendKeys(id);
        this.ChooseFile.sendKeys(file);
        Thread.sleep(1000);
        this.save.click();
        Thread.sleep(1000);
    }
    public String validateFirstName(){
        return validationName.getAttribute("value");

    }
    public String validateLastName(){
        return validationLastName.getAttribute("value");
    }
    public boolean validateEmployeeId(String employeeId){
        return validationEmployeeId.getAttribute("value").endsWith(employeeId);
    }
}
