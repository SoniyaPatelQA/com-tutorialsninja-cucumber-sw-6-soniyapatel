package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;


    public String getReturningCustomerText() {
        log.info("Get Returning Customer text " + returningCustomerText.getText());
        return getTextFromElement(returningCustomerText);
    }

    public void enterTextToEmailAddress(String emaiText) {
        sendTextToElement(emailAddress, emaiText);
        log.info("Enter email address: " + emaiText + emailAddress.toString());
    }

    public void enterTextToPassword(String passwordText) {
        sendTextToElement(password, passwordText);
        log.info("Enter password: " + passwordText + password.toString());
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        log.info("Click on login button" + loginButton.toString());
    }
}
