package com.nttdata.steps;

import org.openqa.selenium.WebDriver;
import com.nttdata.page.BestQualificationsPage;
public class BestQualificationsSteps {
    WebDriver driver;

    public BestQualificationsSteps(WebDriver driver){
        this.driver = driver;
    }

    public void selectItemProduct(){
        driver.findElement(BestQualificationsPage.productItem).click();
    }

}
