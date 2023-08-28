package com.sauce.stepDefinitions;

import com.sauce.pages.CartPage;
import com.sauce.pages.CheckoutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import com.sauce.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EndToEnd_StepDef {

    LoginPage loginPage= new LoginPage();
    ProductsPage productsPage= new ProductsPage();
    CartPage cartPage= new CartPage();
    CheckoutPage checkoutPage= new CheckoutPage();

    @When("The user enters {string} and {string}")
    public void theUserEntersAnd(String username, String password) {
        loginPage.login(username, password);
    }
    @Then("The user should be able to login and see {string} header")
    public void theUserShouldBeAbleToLoginAndSeeHeader(String expectedMessage) {
        BrowserUtils.verifyElementDisplayed(productsPage.productsText);
    }

    @When("The user sorts products as {string}")
    public void theUserSortsProductsAs(String sortType) {
        BrowserUtils.waitFor(1);
        productsPage.sortProduct(sortType);
        BrowserUtils.waitFor(1);
    }
    @And("The user adds the cheapest as {string} and the second costliest as {string}")
    public void theUserAddsTheCheapestAsAndTheSecondCostliestAs(String cheapest, String secondCost) {
        productsPage.addProduct(cheapest);
        BrowserUtils.waitFor(1);
        productsPage.addProduct(secondCost);
    }
    @And("The user opens basket")
    public void theUserOpensBasket() {
        productsPage.cartBtn.click();
    }
    @And("The user clicks on checkout")
    public void theUserClicksOnCheckout() {
        cartPage.checkoutBtn.click();
    }

    @And("The user enters details as {string} {string} {string} and finishes the purchase")
    public void theUserEntersDetailsAsAndFinishesThePurchase(String firstname, String lastname, String zipCode) {
        checkoutPage.enterDetails(firstname, lastname, zipCode);
    }

    @Then("The user verifies that the items are {string}")
    public void theUserVerifiesThatTheItemsAre(String expectedTotal) {
        Assert.assertEquals(expectedTotal,checkoutPage.summaryTotal.getText());
    }
}
