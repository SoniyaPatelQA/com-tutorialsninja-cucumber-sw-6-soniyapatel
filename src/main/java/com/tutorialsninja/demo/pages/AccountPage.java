package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {
    private static final Logger log = LogManager.getLogger(AccountPage.class);

    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement accountCreatedSuccessMessageText;

    //@CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement myAccountText;


    public String getAccountCreatedSuccessMessageText() {
        log.info("Get Account Create Success Message: " + accountCreatedSuccessMessageText.getText());
        return getTextFromElement(accountCreatedSuccessMessageText);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        log.info("Click on Continue button" + continueButton.toString());
    }


    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
        log.info("Click on My Account menu" + myAccountLink.toString());
    }

    public String getMyAccountText() {
        log.info("Get my account text: " + myAccountText.getText());
        return getTextFromElement(myAccountText);
    }

}
