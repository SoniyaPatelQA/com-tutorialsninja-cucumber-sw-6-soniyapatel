Feature: Desktops Product
As a user I want to check desktop products and add products into cart

  @author_SoniyaPatel @sanity @smoke @regression
  Scenario:Verify Product Arrange In AlphaBatical Order
    Given I am on homepage
    When Mouse hover on Desktops Tab.and click
    And Click on Show All Desktops
    And Select Sort By position "Name (Z - A)"
    Then Verify the Product will arrange in Descending order

  @author_SoniyaPate @smoke @regression
  Scenario Outline: Verify Product Added To Shopping Cart SuccessFully
    When Mouse hover on Currency Dropdown and click
    And Mouse hover on £Pound Sterling and click
    And Mouse hover on Desktops Tab
    And Click on Show All Desktops
    And Select Sort By position "Name (A - Z)"
    And Select product name "<product>"
    And Verify the Text "<product>"
    And Enter Qty "1" using Select class.
    And Click on “Add to Cart” button
    Then Verify the Message “Success: You have added "<product>" to your shopping cart!”
    When Click on link “shopping cart” display into success message
    Then Verify the shopping cart text "Shopping Cart"
    Then Verify the Product name "<product>"
    Then Verify the Model "<model>"
    Then Verify the Total "<price>"
    Examples:
      | product      | model      | price   |
      | HTC Touch HD | Product 1  | £74.73  |
      | iPhone       | product 11 | £75.46  |
      | iPod Classic | product 20 | £74.73  |
      | MacBook      | Product 16 | £368.73 |
      | MacBook Air  | Product 17 | £736.23 |
      | Sony VAIO    | Product 19 | £736.23 |



