package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {
    private static final Logger log = LogManager.getLogger(RegisterPage.class);

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirm;

    @CacheLookup
    @FindBy(xpath = "//input[@value='1'][@name='newsletter']")
    WebElement yesSubscribeRadioOption;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsAndAgreement;

    //@CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;


    public String getRegisterAccountText() {
        log.info("Get Register Account Text" + registerAccountText.getText());
        return getTextFromElement(registerAccountText);
    }

    public void enterTextToFirstName(String firstnameText) {
        sendTextToElement(firstName, firstnameText);
        log.info("Enter firstname: " + firstnameText + "to FirstName field" + firstName.toString());
    }

    public void enterTextToLastName(String lastNameText) {
        sendTextToElement(lastName, lastNameText);
        log.info("Enter lastname: " + lastNameText + "to FirstName field" + lastName.toString());
    }

    public void enterTextToEmail(String emailText) {
        sendTextToElement(email, emailText);
        log.info("Enter email: " + emailText + "to Email field" + email.toString());
    }

    public void enterTextToTelephone(String telephoneText) {
        sendTextToElement(telephone, telephoneText);
        log.info("Enter telephone: " + telephoneText + "to Telephone field" + telephone.toString());
    }

    public void enterTextToPassword(String passwordText) {
        sendTextToElement(password, passwordText);
        log.info("Enter password to Password field" + password.toString());
    }

    public void enterTextToPasswordConfirm(String passwordConfirmText) {
        sendTextToElement(passwordConfirm, passwordConfirmText);
        log.info("Enter password confirm to Password Confirm field" + passwordConfirm.toString());
    }

    public void clickOnYesRadioOption() {
        clickOnElement(yesSubscribeRadioOption);
        log.info("Click on 'Yes' option into Subscribe button" + yesSubscribeRadioOption.toString());
    }

    public void clickOnTermsAndAgreement() {
        clickOnElement(termsAndAgreement);
        log.info("Click on terms and agreement checkbox" + termsAndAgreement.toString());
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        log.info("Click on continue button" + continueButton.toString());
    }
}
