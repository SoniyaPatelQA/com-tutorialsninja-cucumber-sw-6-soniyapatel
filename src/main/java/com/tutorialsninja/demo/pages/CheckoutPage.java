package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Utility {
    private static final Logger log = LogManager.getLogger(CheckoutPage.class);

    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement checkoutText;

    //@CacheLookup
    @FindBy(css = "body div[id='checkout-checkout'] div[class='row'] div[class='row'] div:nth-child(1) h2:nth-child(1)")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckoutRadioButton;

    @CacheLookup
    @FindBy(id = "button-account")
    WebElement continueButton;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address1;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postCode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement country;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement regionState;

    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement continueGuestButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement shippingMethodContinueButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='collapse-payment-method']//textarea[@name='comment']")
    WebElement commentBox;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsAgreementCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement paymentMethodContinueButton;

    public String getCheckoutText() {
        log.info("Get Checkout Text " + checkoutText.getText());
        return getTextFromElement(checkoutText);
    }

    public String getNewCustomerText() {
        log.info("Get New Customer Text " + newCustomerText.getText());
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton() {
        clickOnElement(guestCheckoutRadioButton);
        log.info("Click on Checkout radio button" + guestCheckoutRadioButton.toString());
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        log.info("Click on continue button" + continueButton.toString());
    }

    public void enterTextToFirstName(String firstNameText) {
        sendTextToElement(firstName, firstNameText);
       log.info("Enter firstname: " + firstNameText + "into FirstName field" + firstName.toString());

    }

    public void enterTextToLastName(String lastNameText) {
        sendTextToElement(lastName, lastNameText);
        log.info("Enter lastname: " + lastNameText + "into LastName field" + lastName.toString());

    }

    public void enterTextToEmail(String emailText) {
        sendTextToElement(email, emailText);
        log.info("Enter email: " + emailText + "into Email field" + email.toString());

    }

    public void enterTextToTelephone(String telephoneText) {
        sendTextToElement(telephone, telephoneText);
        log.info("Enter telephone: " + telephoneText + "into Telephone field" + telephone.toString());
    }

    public void enterTextToAddress1(String address1Text) {
        sendTextToElement(address1, address1Text);
        log.info("Enter address: " + address1Text + "into Address1 field" + address1.toString());
    }

    public void enterTextToCity(String cityText) {
        sendTextToElement(city, cityText);
       log.info("Enter city: " + cityText + "into City field" + city.toString());
    }

    public void enterTextToPostCode(String postcodeText) {
        sendTextToElement(postCode, postcodeText);
        log.info("Enter PostCode: " + postcodeText + "into PostCode field" + postCode.toString());
    }

    public void selectOptionFromCountry(String countryOption) {
        selectByVisibleTextFromDropDown(country, countryOption);
        log.info("Select " + countryOption + " option from Country dropdown field" + country.toString());
    }

    public void selectOptionFromRegionState(String registerStateOption) {
        selectByVisibleTextFromDropDown(regionState, registerStateOption);
        log.info("Select " + registerStateOption + " option from Region/State dropdown field" + regionState.toString());
    }

    public void clickOnContinueGuestButton() {
        clickOnElement(continueGuestButton);
        log.info("Click on continue button" + continueButton.toString());
    }

    public void clickOnShippingMethodContinueButton() {
        clickOnElement(shippingMethodContinueButton);
        log.info("Click on Continue button" + shippingMethodContinueButton.toString());
    }

    public void enterTextToCommentBox(String commentBoxText) {
        sendTextToElement(commentBox, commentBoxText);
        log.info("Enter Comment: " + commentBoxText + "into CommentBox" + commentBox.toString());
    }

    public void clickOnTermAndAgreementCheckBox() {
        clickOnElement(termsAgreementCheckBox);
       log.info("Click on Terms And Agreement CheckBox" + termsAgreementCheckBox);
    }

    public void clickOnPaymentMethodContinueButton() {
        clickOnElement(paymentMethodContinueButton);
        log.info("Click on Continue button" + paymentMethodContinueButton.toString());
    }
}
