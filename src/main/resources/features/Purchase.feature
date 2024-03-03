Feature: Purchase Items from Showcase Screen

@android @regression @tcid_1603986
Scenario: Successful Login with Valid Credentials
	Given User installs & launches Purchase app
    When User enters Username "test_user" and Password "pass$123"
    And User clicks on Submit button
    Then verify Message is displayed as User "username" logged in successfully  
    Then User is navigated to "Showcase" screen
    And Item list is displyed to user
	Then User selects item 1 from Screen
    Then User is navigated to "Item" screen
    And Item details are displayed on Item screen  
	Then User adds item 1 to cart
    Then User is navigated to "Showcase" screen
    And Item list is displyed to user
    Then User selects item 2 from Screen
    Then User is navigated to "Item" screen
    And Item details are displayed on Item screen  
	Then User adds item 2 to cart
    Then User is navigated to "Cart" screen
    And verify the number of items added in Cart
    Then User clicks on "Purchase" button
    Then User is navigated to "Address" screen
    Then User enters complete address
        | Field         | Value                |
        | Street        |  Main Street         |
        | City          |  Main City           |
        | State         |  Main State          |
        | Postal Code   |  123-456             |
    And User clicks on "Continue" button
    Then User is navigated to "Confirm Purchase" screen
    Then User clicks on "Finish Purchase" button
    Then verify that purchase is successful
