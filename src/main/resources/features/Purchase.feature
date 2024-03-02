Feature: Purchase Items from Showcase Screen

@android @regression @tcid_1603986
Scenario: Successful Login with Valid Credentials
	Given User installs & launches Purchase app
    When User is on Login Screen
	And User enters Username "test_user" and Password "pass$123"
    And User clicks on Submit button
    Then verify Message is displayed as User "username" logged in successfully  
    Then User is navigated to "Showcase" screen
    And Item list is displyed to user
	Then User selects item 1 from Screen
    Then User is navigated to "Item" screen
    And Item details are displayed on Item screen  
	Then User clicks on "Add to Cart" button
    Then item 1 is added to Cart
    Then User navigates back to "Showcase" screen
    And Item list is displyed to user
    Then User selects item 2 from Screen
    Then User is navigated to "Item" screen
    And Item details are displayed on Item screen  
	Then User clicks on "Add to Cart" button
    Then User navigates to "Cart" screen
    And verify the number of items added in Cart
    Then User clicks on "Purchase" button
    Then User is navigated to "Address" screen
    Then User enters complete address
    And User clicks on "Continue" button
    Then User is navigated to "Confirm Purchase" screen
    Then User clicks on "Finish Purchase" button
    Then verify that purchase is successful
