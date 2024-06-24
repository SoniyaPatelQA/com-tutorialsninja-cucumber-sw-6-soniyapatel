package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends Utility {
    private static final Logger log = LogManager.getLogger(LogoutPage.class);

    // @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;

    public String getAccountLogoutText() {
        log.info("Get Account Logout text" + accountLogoutText.getText());
        return getTextFromElement(accountLogoutText);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        log.info("Click on continue button" + continueButton.toString());
    }
}
