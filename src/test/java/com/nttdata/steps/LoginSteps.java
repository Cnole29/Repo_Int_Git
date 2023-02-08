package com.nttdata.steps;

import org.openqa.selenium.WebDriver;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private WebDriver driver;
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void typeEmail(String email){
        WebElement emailInputElement = driver.findElement(LoginPage.emailInput);
        emailInputElement.sendKeys(email);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));
    }

    public void typeContras(String contras){
      WebElement contrasInputElement = driver.findElement(LoginPage.contrasInput);
      contrasInputElement.sendKeys(contras);

    }

    public void login(){
        driver.findElement(LoginPage.loginButton).click();
    }

}
