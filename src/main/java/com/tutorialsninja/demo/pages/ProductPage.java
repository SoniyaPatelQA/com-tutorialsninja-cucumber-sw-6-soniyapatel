package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Utility {
    private final static Logger log = LogManager.getLogger(ProductPage.class);

    //  @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement productTitleText;

    // @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    // @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement greenBarNotification;

    // @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    // @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement qty;

    public String getProductTitleText() {
        log.info("Get product title text" + productTitleText.getText());
        return getTextFromElement(productTitleText);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
        log.info("Click on AddToCart button" + addToCartButton.toString());
    }

    public String getNotificationBarText() {
        log.info("Get Notification Message" + greenBarNotification.getText());
        return getTextFromElement(greenBarNotification);
    }

    public void clickOnShoppingCartLink() {
        clickOnElement(shoppingCartLink);
        log.info("Click on Shopping Cart link from notification message" + shoppingCartLink.toString());
    }

    public void clearTextFromQty() {
        clearTextFromField(qty);
        log.info("Clear pre-populated text from Quantity field" + qty.toString());
    }

    public void enterTextToQty(String qtyValue) {
        sendTextToElement(qty, qtyValue);
        log.info("Enter value " + qtyValue + "into quantity field" + qty.toString());
    }
}
