package com.nttdata.steps;

import com.nttdata.page.HomePage;
import org.openqa.selenium.WebDriver;
public class HomePageSteps {
    WebDriver driver;
    public HomePageSteps(WebDriver driver){
        this.driver = driver;
    }

    public String getProfileUser(){
        return this.driver.findElement(HomePage.profileUserName).getText();
    }

    public void selectCategoria(){
        driver.findElement(HomePage.bestQualification).click();
    }

}
