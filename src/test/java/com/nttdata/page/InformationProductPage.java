package com.nttdata.page;

import org.openqa.selenium.By;

public class InformationProductPage {
    public static By productName = By.xpath("//span[@class='product-name']");
    public static By addProductButton = By.xpath("//button[@id='buy-now']");
    public static By messageConfimation = By.xpath("//h2[@class='added-product  highlight']");
}
