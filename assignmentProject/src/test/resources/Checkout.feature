Feature: Successful checkout process on Sauce Demo

  @TC1
  Scenario: Verify that user is able to add item to cart to successfully order
    Given The user wants to go to Sauce Demos website
    When The user wants to login with valid credentials
    Then The user wants to add Sauce Labs Bike Light to the Cart
    Then The user wants to navigate to the Cart and click Checkout button
    Then The user wants to input Randomized valid First Name, Last Name and Zip_Postal Code
    Then The user wants to click Continue button, navigate to checkout: Overview then click Finish Button
    Then The user wants to verify that item has successfully been ordered

