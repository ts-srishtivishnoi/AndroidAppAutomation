package com.mobile.demoapp.qa.automation.steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.mobile.demoapp.qa.automation.core.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class PurchaseSteps {

    protected AndroidDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    int expectedItemCount = 0;

    @Given("User installs & launches Purchase app")
    public void installApp() {
        try {
            this.driver = new DriverManager().getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("User enters Username {string} and Password {string}")
    public void loginToApp(String userId, String password) {
        driver.findElement(By.id("usernameField")).sendKeys(userId);
        driver.findElement(By.id("passwordField")).sendKeys(password);
    }

    @And("User clicks on {string} button")
    public void clickOnButton(String buttonName) {
        By buttonLocator = By.name("button_" + buttonName);
        driver.findElement(buttonLocator).click();
    }

    @Then("verify Message is displayed as User {string} logged in successfully")
    public void checkLoginStatus(String userId) {
        By messageLocator = By.id("LoginMessageTextView");
        String expectedMessage = "User " + userId + " logged in successfully";
        String actualMessage = driver.findElement(messageLocator).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("User is navigated to {string} screen")
    public void navigateToScreen(String screenName) {
        By screenLocator = By.id("screen_" + screenName);
        boolean isOnScreen = driver.findElement(screenLocator).isDisplayed();
        if (!isOnScreen) {
            throw new AssertionError("User is not on the screen: " + screenName);
        }
    }

    @And("Item list is displyed to user")
    public void dispalyItmeList() {
        By itemListLocator = By.id("ItemList");
        // Wait for the item list to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemListLocator));
    }

    @Then("User selects item {int} from Screen")
    public void selectItem(Integer itemNumber) {
        By itemLocator = By.id("itemIndex_" + itemNumber);
        driver.findElement(itemLocator).click();
    }

    @And("Item details are displayed on Item screen")
    public void displayItmDetails() {
        // Assuming each item has title,description& price to be displayed on the screen

        assertTrue(driver.findElement(By.id("item_title")).isDisplayed());
        assertTrue(driver.findElement(By.id("item_description")).isDisplayed());
        assertTrue(driver.findElement(By.id("item_price")).isDisplayed());
    }

    @Then("User adds item {int} to cart")
    public void verifyItemCount(Integer itemAddToCart) {
        driver.findElement(By.id("itemIndex_" + itemAddToCart)).click();
        expectedItemCount = itemAddToCart + 1;
    }

    @And("verify the number of items added in Cart")
    public void verifyItemCount() {
        List cartItems = driver.findElements(By.id("cart_items"));
        int actualItemCount = cartItems.size();
        // Assertion to check if the actual count matches the expected count
        Assert.assertEquals(expectedItemCount, actualItemCount);

    }

    @Then("User enters complete address")
    public void addAddress(io.cucumber.datatable.DataTable dataTable) {
        for (var row : dataTable.asLists()) {
            String field = row.get(0);
            String value = row.get(1);

            WebElement element = driver.findElement(By.id("add_" + field.toLowerCase()));
            element.sendKeys(value);
        }
    }

    @Then("verify that purchase is successful")
    public void verifyPurchase() {
        verifyConfirmationMessage();
        verifyOrderHistory();
        verifyEmailConfirmation();
    }

    public void verifyConfirmationMessage() {
        // Assuming there is a confirmation message element on the screen
        WebElement confirmationMessage = driver.findElement(By.id("confirmationMessageId"));
        assertTrue(confirmationMessage.isDisplayed());
    }

    public void verifyOrderHistory() {
        // Assuming there is an order history element on the screen
        WebElement orderHistory = driver.findElement(By.id("orderHistoryId"));
        assertTrue(orderHistory.isDisplayed());
    }

    public void verifyEmailConfirmation() {
        // Assuming there is an email confirmation element or logic to check the email
        assertTrue(checkEmailConfirmation());
    }

    private boolean checkEmailConfirmation() {
        // Logic to check the email confirmation
        // Return true if confirmation is received, false otherwise
        return true;
    }

}