package com.tutorialsninja.demo.steps;

import com.google.common.base.Verify;
import com.tutorialsninja.demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTestSteps {
    public List<WebElement> products;
    public List<Double> afterSortProduct;
    public List<Double> beforeSortProduct;


    //1.1 Mouse hover on Laptops & Notebooks Tab.and click, 2.1 Mouse hover on Laptops & Notebooks Tab and click
    @When("Mouse hover on Laptops & Notebooks Tab and click")
    public void mouseHoverOnLaptopsNotebooksTabAndClick() {
        new HomePage().mouseHoverOnLaptopsAndNoteBooksAndClick();
    }

    //1.2 Click on “Show All Laptops & Notebooks” , 2.2 Click on “Show All Laptops & Notebooks”
    @And("Click on Show All Laptops & Notebooks")
    public void clickOnShowAllLaptopsNotebooks() {
        new HomePage().clickOnShowAllLaptopsAndNotebooks();
    }

    //1.3 Select Sort By "Price (High > Low)", 2.3 Select Sort By "Price (High > Low)"
    @And("Select Sort By {string}")
    public void selectSortBy(String option) {
        //before sorting by price filter
        products = new ProductListPage().getLaptopAndNoteBookProducts();
        beforeSortProduct = new ArrayList<>();
        for (WebElement p : products) {
            beforeSortProduct.add(Double.valueOf(p.getText().split("\n")[0].replace("$", "").replace(",", "").trim()));
        }

        //sort price
        beforeSortProduct.sort(Collections.reverseOrder());

        // Select Sort By "Price (High > Low)"
        new ProductListPage().selectOptionFromSortByDropDown(option);
    }

    //1.4 Verify the Product price will arrange in High to Low order.
    @Then("Verify the Product price will arrange in High to Low order")
    public void verifyTheProductPriceWillArrangeInHighToLowOrder() {
        //After sorting by price
        products = new ProductListPage().getLaptopAndNoteBookProducts();
        afterSortProduct = new ArrayList<>();
        for (WebElement p : products) {
            afterSortProduct.add(Double.valueOf(p.getText().split("\n")[0].replace("$", "").replace(",", "").trim()));
        }
        //Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(afterSortProduct, beforeSortProduct, "Price is not sorted by high to low order");
    }

    //2.4 Select Product “HP LP3065”
    @And("Select Product “HP LP3065”")
    public void select_product_hp_lp3065() {
        new ProductListPage().clickOnHpLpProduct();
    }

    //2.5 Verify the text “HP LP3065”
    @Then("Verify the product text {string}")
    public void verifyTheProductText(String productName) {
        Assert.assertEquals(new ProductPage().getProductTitleText(), productName, "HP LP3065 name is not match");
    }

    //2.6 Click on ‘Add To Cart’ button
    @When("Click on Add To Cart button")
    public void clickOnAddToCartButton() throws InterruptedException {
        new ProductPage().clickOnAddToCartButton();
        Thread.sleep(5000);
    }

    //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
    @Then("Verify the success message {string}")
    public void verifyTheSuccessMessage(String notificationText) {
        Assert.assertTrue(new ProductPage().getNotificationBarText().contains(notificationText), "Notification text is not match");
    }

    //2.8 Click on link “shopping cart” display into success message
    @When("Click on link shopping cart display into success message")
    public void clickOnLinkShoppingCartDisplayIntoSuccessMessage() {
        new ProductPage().clickOnShoppingCartLink();
    }
    //2.9 Verify the text "Shopping Cart"  -- this is common steps in feature file Desktop


    //2.10 Verify the Product name "HP LP3065" --this  is common steps in features file so defined in DesktopsTestSteps

    //2.11 Change Quantity "2"
    @When("Change Quantity {string}")
    public void changeQuantity(String qty) {
        new CartPage().clearTextFromQtyField();
        new CartPage().enterTextToQty(qty);
    }

    //2.12 Click on “Update” Tab
    @And("Click on Update Tab")
    public void clickOnUpdateTab() {
        new CartPage().clickOnUpdateTab();
    }

    //2.13 Verify the message “Success: You have modified your shopping cart!”
    @Then("Verify the message {string}")
    public void verifyTheMessage(String updateNotificationText) {
        Assert.assertTrue(new CartPage().getGreenBarNotificationText().contains(updateNotificationText), "Notification text is not updated");
    }

    //2.14 Verify the Total £737.45 -- this is  common steps in features file so defined in DesktopsTestSteps

    //2.15 Click on “Checkout” button
    @When("Click on Checkout button")
    public void clickOnCheckoutButton() {
        new CartPage().clickOnCheckoutButton();
    }

    //2.16 Verify the text “Checkout”
    @Then("Verify the text {string}")
    public void verifyTheText(String checkoutText) {
        Assert.assertEquals(new CheckoutPage().getCheckoutText(), checkoutText, "Checkout text in not displayed");
    }

    //2.17 Verify the Text “New Customer”
    @And("Verify the new customer Text {string}")
    public void verifyTheNewCustomerText(String customerText) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(new CheckoutPage().getNewCustomerText().contains("New Customer"), "New Customer text is not displayed");
    }

    //2.18 Click on “Guest Checkout” radio button
    @When("Click on Guest Checkout radio button")
    public void clickOnGuestCheckoutRadioButton() {
        new CheckoutPage().clickOnGuestCheckoutRadioButton();
    }

    //2.19 Click on “Continue” tab
    @And("Click on Continue tab")
    public void clickOnContinueTab() {
        new CheckoutPage().clickOnContinueButton();
    }

    //2.20 Fill the mandatory fields
    @And("Fill the mandatory fields")
    public void fillTheMandatoryFields() {
        new CheckoutPage().enterTextToFirstName("Test FirstName");
        new CheckoutPage().enterTextToLastName("Test LastName");
        new CheckoutPage().enterTextToEmail("testfnln32@gmail.com");
        new CheckoutPage().enterTextToTelephone("04532674323");
        new CheckoutPage().enterTextToAddress1("Test RD");
        new CheckoutPage().enterTextToCity("Test City");
        new CheckoutPage().enterTextToPostCode("T5 7TA");
        new CheckoutPage().selectOptionFromCountry("United Kingdom");
        new CheckoutPage().selectOptionFromRegionState("Bristol");
        new CheckoutPage().clickOnContinueGuestButton();
    }

    //2.21 Click on “Continue” Button
    @And("Click on Shipping Method Continue Button")
    public void clickOnShippingMethodContinueButton() {
        new CheckoutPage().clickOnShippingMethodContinueButton();
    }

    //2.22 Add Comments About your order into text area
    @And("Add Comments About your order into text area {string}")
    public void addCommentsAboutYourOrderIntoTextArea(String textboxMessage) {
        new CheckoutPage().enterTextToCommentBox(textboxMessage);
    }

    //2.23 Check the Terms & Conditions check box
    @And("Check the Terms & Conditions check box")
    public void checkTheTermsConditionsCheckBox() {
        new CheckoutPage().clickOnTermAndAgreementCheckBox();
    }

    //2.24 Click on “Continue” button
    @And("Click on Payment Method Continue button")
    public void clickOnPaymentMethodContinueButton() {
        new CheckoutPage().clickOnPaymentMethodContinueButton();
    }


}
