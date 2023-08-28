package com.sauce.pages;

import com.sauce.utilities.BrowserUtils;
import com.sauce.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{
    @FindBy(xpath = "//span[.='Products']")
    public WebElement productsText;
    @FindBy(className = "product_sort_container")
    public WebElement sortBtn;
    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBtn;
    public void sortProduct(String sortType){
        Select select= new Select(sortBtn);
        select.selectByVisibleText(sortType);
    }
    public void addProduct(String price){
        //Driver.get().findElement(By.xpath("//div[text()='"+price+"']/../button")).click();
        WebElement product= Driver.get().findElement(By.xpath("//div[text()='"+price+"']/../button"));
        BrowserUtils.clickWithJS(product);
    }
}
