Feature: Top Menu feature
  As a user, I navigate to selected menu page

  @author_SoniyaPatel @smoke @sanity @regression
  Scenario: Verify User Should Navigate To Desktops Page Successfully
    Given I am on homepage
    When Mouse hover on Desktops Tab and click
    And call selectMenu method and pass the menu "Show AllDesktops"
    Then Verify the desktop page text "Desktops"

  @author_SoniyaPatel @smoke  @regression
  Scenario: Verify User Should Navigate To Laptops And Notebooks Page Successfully
    Given I am on homepage
    When Mouse hover on “Laptops & Notebooks” Tab and click
    And call selectMenu method and pass the menu "Show AllLaptops & Notebooks"
    Then Verify the laptop page text "Laptops & Notebooks"

  @author_SoniyaPatel  @regression
  Scenario: verify User Should Navigate To Components Page Successfully
    Given I am on homepage
    When Mouse hover on Components Tab and click
    And call selectMenu method and pass the menu "Show AllComponents"
    Then Verify the component page text "Components"