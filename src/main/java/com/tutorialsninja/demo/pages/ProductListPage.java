package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductListPage.class);

    //@CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByDropDown;

    @FindBy(xpath = "(//p[@class='price'])")
    List<WebElement> laptopAndNoteBookProducts;

    //@CacheLookup
    @FindBy(linkText = "Sony VAIO")
    WebElement productSonyVaio;

    @CacheLookup
    @FindBy(xpath = "//div[@class='caption']//a[contains(text(),'HP LP3065')]")
    WebElement productHpLp;

    //@CacheLookup
    @FindBy(xpath = "//h4//a")
    List<WebElement> desktopsProducts;

    @CacheLookup
    @FindBy(xpath = "//div[@class='caption']//a[contains(text(),'HTC Touch HD')]")
    WebElement productHTCTouchHd;

    @CacheLookup
    @FindBy(css = "div[id='content'] h2")
    WebElement productCategoryTitleText;


    public void selectOptionFromSortByDropDown(String sortByOption) {
        selectByVisibleTextFromDropDown(sortByDropDown, sortByOption);
        log.info("select option '" + sortByOption + "' from SortBy dropdown field" + sortByDropDown.toString());
    }

    public List<WebElement> getLaptopAndNoteBookProducts() {
        log.info("Get laptop and notebook products list" + laptopAndNoteBookProducts.toString());
        return webElementList(laptopAndNoteBookProducts);
    }

    public void clickOnSonyVaioProduct() {
        clickOnElement(productSonyVaio);
        log.info("Click on SonyVAIO Product" + productSonyVaio.toString());
    }
    public void clickOnHpLpProduct() {
        clickOnElement(productHpLp);
        log.info("Click on HP LP3065 Product" + productHpLp.toString());
    }

    public List<WebElement> getDesktopsProducts() {
        log.info("Get desktops products list" + desktopsProducts.toString());
        return webElementList(desktopsProducts);
    }


    /**
     * this method will select desktops product from product list
     *
     * @param product
     */
    public void selectDesktopProducts(String product) {
        List<WebElement> products = webElementList(desktopsProducts);
        try {

            for (WebElement e : products) {
                if (e.getText().equalsIgnoreCase(product)) {
                    e.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            products = getDesktopsProducts();
        }
        log.info("Select product '" + product + "' from desktop page");
    }

    public String getProductCategoryText() {
        log.info("Get product Category title" + productCategoryTitleText.getText());
        return getTextFromElement(productCategoryTitleText);
    }
}
