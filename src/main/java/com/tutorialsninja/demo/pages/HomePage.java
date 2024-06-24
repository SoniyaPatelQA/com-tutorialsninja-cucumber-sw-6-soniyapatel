package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountMenu;

    //@CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountMenuOptions;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndNoteBooksMenu;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllLaptops & Notebooks')]")
    WebElement showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopsMenu;

    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement showAllDeskTopLink;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyMenu;

    @CacheLookup
    @FindBy(css = "button[name='GBP']")
    WebElement poundSterling;

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> menus;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsTab;

    //this method will select menus and click on it
    public void selectMenu(String menu) {
        List<WebElement> menuList = menus;
        for (WebElement m : menus) {
            try {
                if (m.getText().equalsIgnoreCase(menu)) {
                    m.click();
                }
            } catch (StaleElementReferenceException e) {
                menuList = menus;
            }
        }
        log.info("Select menu: " + menu + " and redirect to" + menu + " page");
    }

    public void clickOnMyAccountMenu() {
        clickOnElement(myAccountMenu);
        log.info("clicking on My Account Menu " + myAccountMenu.toString());
    }


    public List<WebElement> getMyAccountMenuOptions() {
        log.info("Get My Account menu options" + myAccountMenuOptions.toString());
        return webElementList(myAccountMenuOptions);

    }

    /**
     * This method will click on the options whatever name is passed as parameter.
     */
    public void selectMyAccountOptions(String option) {
        List<WebElement> options = myAccountMenuOptions;
        try {
            for (WebElement optionName : options) {
                if (optionName.getText().equalsIgnoreCase(option)) {
                    optionName.click();
                }
            }

        } catch (StaleElementReferenceException e) {
            options = myAccountMenuOptions;
        }
        log.info("Select account option: " + option + " and redirect to" + option + " page");
    }

    public void mouseHoverOnLaptopsAndNoteBooksAndClick() {
        mouseHoverToElementAndClick(laptopAndNoteBooksMenu);
        log.info("Mouse Hover On LaptopsAndNoteBooks And Click" + laptopAndNoteBooksMenu.toString());
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        clickOnElement(showAllLaptopsAndNotebooks);
        log.info("click on show All LaptopsAndNotebooks" + showAllLaptopsAndNotebooks.toString());
    }

    public void mouseHoverToDesktopTabAndClick() {
        mouseHoverToElementAndClick(desktopsMenu);
        log.info("Mouse Hover On DesktopTab And Click" + desktopsMenu.toString());
    }

    public void clickOnShowAllDesktops() {
        clickOnElement(showAllDeskTopLink);
        log.info("click on show All DeskTop " + showAllDeskTopLink.toString());
    }

    public void mouseHoverOnCurrencyDropDownAndClick() {
        mouseHoverToElementAndClick(currencyMenu);
        log.info("Mouse hover on Currency Dropdown and click" + currencyMenu.toString());
    }

    public void mouseHoverOnPoundSterlingAndClick() {
        mouseHoverToElementAndClick(poundSterling);
        log.info("Mouse hover on £Pound Sterling and click" + poundSterling.toString());
    }


    public void mouseHoverOnComponentsTabAndClick() {
        mouseHoverToElementAndClick(componentsTab);
        log.info("Mouse hover on “Components” Tab and click" + componentsTab.toString());
    }
}
