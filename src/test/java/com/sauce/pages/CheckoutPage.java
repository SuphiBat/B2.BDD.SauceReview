package com.sauce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
    @FindBy(id="first-name")
    public WebElement inputFirstname;
    @FindBy(id="last-name")
    public WebElement inputLastname;
    @FindBy(id="postal-code")
    public WebElement inputPostalCode;
    @FindBy(id="continue")
    public WebElement continueBtn;
    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    public WebElement summaryTotal;
    public void enterDetails(String firstName, String lastName, String zipCode){
        inputFirstname.sendKeys(firstName);
        inputLastname.sendKeys(lastName);
        inputPostalCode.sendKeys(zipCode);
        continueBtn.click();
    }

}
