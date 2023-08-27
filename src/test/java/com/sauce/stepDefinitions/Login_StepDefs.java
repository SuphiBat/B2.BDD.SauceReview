package com.sauce.stepDefinitions;

import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import com.sauce.utilities.BrowserUtils;
import com.sauce.utilities.ConfigurationReader;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {
    LoginPage loginPage= new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user enters {string} and {string} credential")
    public void the_user_enters_and_credential(String username, String password) {
        loginPage.login(username, password);
    }
    @Then("The user should be able to login swag labs website")
    public void the_user_should_be_able_to_login_swag_labs_website() {
        //Assert.assertTrue(productsPage.productsText.isDisplayed());
        BrowserUtils.verifyElementDisplayed(productsPage.productsText);
    }
    @When("The user enters invalid or empty {string} or {string} credential")
    public void the_user_enters_invalid_or_empty_or_credential(String username, String password) {
        loginPage.login(username, password);
    }
    @Then("The user should be able see the {string}")
    public void the_user_should_be_able_see_the(String errorMessage) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals(errorMessage,loginPage.actualErrorMessage.getText());
    }
}
