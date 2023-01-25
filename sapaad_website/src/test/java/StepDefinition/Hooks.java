package StepDefinition;

import base.Config;
import base.FWutility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.util.Strings;

public class Hooks extends Config {

    public static String envData = System.getProperty("env");
    public static String driverType = System.getProperty("browser");
    public static String url;

    @Before
    public void openBrowser() {
        // setup default browser
        if (Strings.isNullOrEmpty(driverType)){
            driverType = "ch";
        }
        // setup default env
        if (Strings.isNullOrEmpty(envData)){
            envData = "stg";
        }
        driver = setupDriver(driverType);
        switch (envData) {
            case "qa":
                url = "http://www-review.sapaad.com";
                break;
            case "stg":
                url = "https://www-stage.sapaad.com";
                break;
            case "prd":
                url = "https://www.sapaad.com";
                break;
        }
        driver.get(url);
    }

    @After
    public void browserClose(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
               FWutility.snapShost(driver, "./Snapshots/"+scenario.getName()+".png");
            }
        } finally {
            driver.quit();
        }
    }
}
