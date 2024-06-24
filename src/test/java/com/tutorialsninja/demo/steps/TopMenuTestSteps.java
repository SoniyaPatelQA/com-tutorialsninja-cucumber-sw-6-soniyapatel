package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TopMenuTestSteps {
    @Given("I am on homepage")
    public void iAmOnHomepage() {

    }

    //1.1 Mouse hover on “Desktops” Tab and click
    @When("Mouse hover on Desktops Tab and click")
    public void mouseHoverOnDesktopsTabAndClick() {
        new HomePage().mouseHoverToDesktopTabAndClick();
    }

    //1.2 call selectMenu method and pass the menu = “Show All Desktops”
    //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
    //3.2 call selectMenu method and pass the menu = “Show All Components”
    @And("call selectMenu method and pass the menu {string}")
    public void callSelectMenuMethodAndPassTheMenu(String menuOption) {
        new HomePage().selectMenu(menuOption);
    }

    //1.3 Verify the text ‘Desktops’
    @Then("Verify the desktop page text {string}")
    public void verifyTheDesktopPageText(String deskTopText) {
        Assert.assertEquals(new ProductListPage().getProductCategoryText(), deskTopText, "Desktop text is not matched");
    }

    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    @When("Mouse hover on “Laptops & Notebooks” Tab and click")
    public void mouseHoverOnLaptopsNotebooksTabAndClick() {
        new HomePage().mouseHoverOnLaptopsAndNoteBooksAndClick();
    }

    //2.3 Verify the text ‘Laptops & Notebooks’
    @Then("Verify the laptop page text {string}")
    public void verifyTheLaptopPageText(String laptopText) {
        Assert.assertEquals(new ProductListPage().getProductCategoryText(), laptopText, "Laptop text is not displayed");
    }

    //3.1 Mouse hover on “Components” Tab and click
    @When("Mouse hover on Components Tab and click")
    public void mouseHoverOnComponentsTabAndClick() {
        new HomePage().mouseHoverOnComponentsTabAndClick();
    }

    //3.3 Verify the text ‘Components’
    @Then("Verify the component page text {string}")
    public void verifyTheComponentPageText(String componentText) {
        Assert.assertEquals(new ProductListPage().getProductCategoryText(), componentText, "Component text is not displayed");
    }

}
