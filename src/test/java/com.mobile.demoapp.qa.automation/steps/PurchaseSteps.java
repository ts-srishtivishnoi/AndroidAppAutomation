package com.mobile.demoapp.qa.automation.steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import com.mobile.demoapp.qa.automation.core.DriverManager;


public class PurchaseSteps {

    protected AppiumDriver driver;

    @Given("User installs & launches Purchase app")
    public void installApp() {
        try {
            this.driver = new DriverManager().getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @And("User enters Username {string} and Password {string}")
    public void loginToApp(String userId, String password) {

    }

    And User clicks on "Continue" button
    Then User clicks on "Add to Cart" button
    Then User clicks on "Purchase" button
    Then User clicks on "Finish Purchase" button
    @And("User clicks on {string} button")
    public void clickOnButton(String buttonName) {

    }

    @Then("verify Message is displayed as User {string} logged in successfully")
    public void checkLoginStatus(String userId) {

    }

    Then User is navigated to "Confirm Purchase" screen
    Then User is navigated to "Address" screen
    Then User navigates to "Cart" screen
    Then User is navigated to "Item" screen
    Then User is navigated to "Item" screen
    Then User navigates back to "Showcase" screen
    @When("User is on Login Screen")
    @Then("User is navigated to {string} screen")
    public void navigateToScreen(String screenName) {

    }

    @And("Item list is displyed to user")
    public void dispalyItmeList() {

    }

    Then User selects item 2 from Screen
    @Then("User selects item {int} from Screen")
    public void selectItem(Integer itemNumber) {

    }

    @And("Item details are displayed on Item screen")
    public void displayItmDetails() {

    }

    @Then("item {int} is added to Cart")
    public void addtItem(Integer itemNumber) {

    }

    @And("verify the number of items added in Cart")
    public void verifyItemCount() {

    }

    @Then("User enters complete address")
    public void addAddress() {

    }

    @Then("verify that purchase is successful")
    public void verifyPurchase(Integer itemNumber) {

    }
}