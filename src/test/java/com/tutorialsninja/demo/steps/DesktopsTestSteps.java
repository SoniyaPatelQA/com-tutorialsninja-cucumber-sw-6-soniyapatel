package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.CartPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductListPage;
import com.tutorialsninja.demo.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTestSteps {
    public List<WebElement> products;
    public List<String> beforeSortProducts;
    public List<String> afterSortProducts;

    //1.1 Mouse hover on Desktops Tab.and click
    @When("Mouse hover on Desktops Tab.and click")
    public void mouseHoverOnDesktopsTabAndClick() {
        new HomePage().mouseHoverToDesktopTabAndClick();
    }

    //1.2 Click on “Show All Desktops”
    //2.4 Click on “Show All Desktops”
    @And("Click on Show All Desktops")
    public void clickOnShowAllDesktops() {
        new HomePage().clickOnShowAllDesktops();
    }

    //1.3 Select Sort By position "Name: Z to A"
    @And("Select Sort By position {string}")
    public void selectSortByPosition(String option) {
        //before sorting product by name
        products = new ProductListPage().getDesktopsProducts();
        beforeSortProducts = new ArrayList<>();
        for (WebElement e : products) {
            beforeSortProducts.add(e.getText());
        }
        // beforeSortProducts.sort(Collections.reverseOrder());
        Collections.reverse(beforeSortProducts);

        //1.3 Select Sort By position "Name: Z to A"
        //2.5 Select Sort By position "Name: A to Z"
        new ProductListPage().selectOptionFromSortByDropDown(option);
    }

    //1.4 Verify the Product will arrange in Descending order.
    @Then("Verify the Product will arrange in Descending order")
    public void verifyTheProductWillArrangeInDescendingOrder() {
        //after sorting product by name
        products = new ProductListPage().getDesktopsProducts();
        afterSortProducts = new ArrayList<>();
        for (WebElement e : products) {
            afterSortProducts.add(e.getText());
        }
        //Verify the Product will arrange in Descending order.
        Assert.assertEquals(afterSortProducts, beforeSortProducts, "products are not sorted in descending (Z-A) order");
    }

    //2.1 Mouse hover on Currency Dropdown and click
    @When("Mouse hover on Currency Dropdown and click")
    public void mouseHoverOnCurrencyDropdownAndClick() {
        new HomePage().mouseHoverOnCurrencyDropDownAndClick();
    }

    //2.2 Mouse hover on £Pound Sterling and click
    @And("Mouse hover on £Pound Sterling and click")
    public void mouseHoverOn£PoundSterlingAndClick() {
        new HomePage().mouseHoverOnPoundSterlingAndClick();
    }

    //2.3 Mouse hover on Desktops Tab.
    @And("Mouse hover on Desktops Tab")
    public void mouseHoverOnDesktopsTab() {
        new HomePage().mouseHoverToDesktopTabAndClick();
    }

    //2.6 Select product “<product>”
    @And("Select product name {string}")
    public void selectProductName(String product) {
        new ProductListPage().selectDesktopProducts(product);
    }

    //2.7 Verify the Text "<product>"
    @And("Verify the Text {string}")
    public void verifyTheText(String productText) {
        Assert.assertEquals(new ProductPage().getProductTitleText(), productText, "product text is not displayed");
    }

    //2.8.Enter Qty "1” using Select class.
    @And("Enter Qty {string} using Select class.")
    public void enterQtyUsingSelectClass(String qty) {
        new ProductPage().clearTextFromQty();
        new ProductPage().enterTextToQty(qty);
    }

    //2.9 Click on “Add to Cart” button
    @And("Click on “Add to Cart” button")
    public void clickOnAddToCartButton() throws InterruptedException {
        new ProductPage().clickOnAddToCartButton();
        Thread.sleep(5000);
    }

    //2.10 Verify the Message “Success: You have added “<product>” to your shopping cart!”
    @Then("Verify the Message “Success: You have added {string} to your shopping cart!”")
    public void verifyTheMessageSuccessYouHaveAddedToYourShoppingCart(String product) {
        Assert.assertTrue(new ProductPage().getNotificationBarText().contains(product), "Success Message is not matched for product: " + product + ".");
    }

    //2.11 Click on link “shopping cart” display into success message
    @When("Click on link “shopping cart” display into success message")
    public void clickOnLinkShoppingCartDisplayIntoSuccessMessage() {
        new ProductPage().clickOnShoppingCartLink();
    }

    //2.12 Verify the text "Shopping Cart"
    @Then("Verify the shopping cart text {string}")
    public void verifyTheShoppingCartText(String expectedText) {
        Assert.assertTrue(new CartPage().getShoppingCartText().contains(expectedText), "Shopping Cart text is not matched");
    }

    //2.13 Verify the Product name "<product>"
    @Then("Verify the Product name {string}")
    public void verifyTheProductName(String product) {
        Assert.assertTrue(new CartPage().getProductNameText().contains(product), "product name is not matched for product: " + product + ".");
    }

    //2.14 Verify the Model "<model>"
    @Then("Verify the Model {string}")
    public void verifyTheModel(String model) {
        Assert.assertEquals(new CartPage().getModelNameText(), model, "model Name is not matched");
    }

    //2.15 Verify the Todal "<price>"
    @Then("Verify the Total {string}")
    public void verifyTheTotal(String total) {
        Assert.assertTrue(new CartPage().getTotalPriceText().contains(total), "total price is not match");
    }



}
