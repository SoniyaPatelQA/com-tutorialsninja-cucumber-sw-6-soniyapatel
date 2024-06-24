package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.browserfactory.ManageBrowser;
import com.tutorialsninja.demo.propertyreader.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.tutorialsninja.demo.utility.Utility.getScreenShot;

public class Hooks extends ManageBrowser {

    @Before
    public void setUp() {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = getScreenShot();
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        closeBrowser();
    }

}
