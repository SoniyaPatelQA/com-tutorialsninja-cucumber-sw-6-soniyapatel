Feature: Laptops and notebooks menu
  As a user, i want to check laptop and notebook product and place order successfully

  @author_SoniyaPatel @smoke @sanity @regression
  Scenario: Verify Products Price Display High To Low Successfully
    Given I am on homepage
    When Mouse hover on Laptops & Notebooks Tab and click
    And Click on Show All Laptops & Notebooks
    And Select Sort By "Price (High > Low)"
    Then Verify the Product price will arrange in High to Low order

  @author_SoniyaPatel @smoke @regression
  Scenario: Verify That User Place Order Successfully
    Given I am on homepage
    When Mouse hover on Laptops & Notebooks Tab and click
    And Click on Show All Laptops & Notebooks
    And Select Sort By "Price (High > Low)"
    And Select Product “HP LP3065”
    Then Verify the product text "HP LP3065"
    When  Click on Add To Cart button
    Then Verify the success message "Success: You have added HP LP3065 to your shopping cart!"
    When Click on link shopping cart display into success message
    Then Verify the shopping cart text "Shopping Cart"
    And Verify the Product name "HP LP3065"
    When Change Quantity "2"
    And Click on Update Tab
    Then Verify the message "Success: You have modified your shopping cart!"
    And Verify the Total "$244.00"
    When Click on Checkout button
    Then Verify the text "Checkout"
    And Verify the new customer Text "New Customer"
    When Click on Guest Checkout radio button
    And Click on Continue tab
    And Fill the mandatory fields
    And Click on Shipping Method Continue Button
    And Add Comments About your order into text area "Kindly place near by address"
    And Check the Terms & Conditions check box
    And Click on Payment Method Continue button
    #Then Verify the message “Warning: Payment method required!”