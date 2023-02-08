package com.nttdata.steps;

import com.nttdata.page.InformationProductPage;
import org.openqa.selenium.WebDriver;

public class InformationProductSteps {
    WebDriver driver;
    public InformationProductSteps(WebDriver driver){
        this.driver = driver;
    }
    public String getProductName(){
        return this.driver.findElement(InformationProductPage.productName).getText();
    }
    public void selectAddButton(){
        driver.findElement(InformationProductPage.addProductButton).click();
    }
    public String getAddConfirmation(){
        return this.driver.findElement(InformationProductPage.messageConfimation).getText();
    }

}
