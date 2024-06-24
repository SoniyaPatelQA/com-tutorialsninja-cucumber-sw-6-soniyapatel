package com.tutorialsninja.demo.browserfactory;

import com.tutorialsninja.demo.propertyreader.PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ManageBrowser {
    private static Logger log = LogManager.getLogger(ManageBrowser.class);

    public static WebDriver driver;
    static String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    static int implicitlyWait = Integer.parseInt(PropertyReader.getInstance().getProperty("implicitlyWait"));

    public ManageBrowser() {
        PageFactory.initElements(driver, this);
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/propertiesfile/log4j.properties");
    }

    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            log.info("Chrome Browser Launch ...");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            log.info("Firefox Browser Launch ...");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            log.info("Edge Browser Launch ...");
        } else {
            //System.out.println("Wrong browser");
            log.info("Wrong Browser");
        }

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
        log.info("Close Browser");
    }
}
