package com.sauce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{
    @FindBy(xpath = "//span[.='Products']")
    public WebElement productsText;
}
