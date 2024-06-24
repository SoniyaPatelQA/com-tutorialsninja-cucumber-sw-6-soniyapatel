package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Utility {
    private static final Logger log = LogManager.getLogger(CartPage.class);

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productNameText;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qty;

    @CacheLookup
    @FindBy(xpath = "//button[@data-original-title='Update']")
    WebElement updateTab;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement greenBarNotificationText;

    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[6]")
    WebElement totalPrice;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutButton;

    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[@class='text-left'][2]")
    WebElement modelName;

    public String getShoppingCartText() {
        log.info("Get Shopping cart text: " + shoppingCartText.getText());
        return getTextFromElement(shoppingCartText);
    }

    public String getProductNameText() {
        log.info("Get Product Name text: " + productNameText.getText());
        return getTextFromElement(productNameText);
    }

    public void clearTextFromQtyField() {
        clearTextFromField(qty);
        log.info("Clear pre-populated text from Quantity field");
    }

    public void enterTextToQty(String qtyValue) {
        sendTextToElement(qty, qtyValue);
        log.info("Enter value " + qtyValue + "into quantity field");
    }

    public void clickOnUpdateTab() {
        clickOnElement(updateTab);
        log.info("Click on Update tab" + updateTab.toString());
    }

    public String getGreenBarNotificationText() {
        log.info("Get notification text: " + greenBarNotificationText.getText());
        return getTextFromElement(greenBarNotificationText);
    }

    public String getTotalPriceText() {
       log.info("Get Total Price text " + totalPrice.getText());
        return getTextFromElement(totalPrice);
    }

    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);
        //log.info("Click on Checkout button" + checkoutButton.toString());
    }

    public String getModelNameText() {
       log.info("Get Model Name text" + modelName.toString());
        return getTextFromElement(modelName);
    }

}
