package stepdefinition;

import config.webdriver.DriverType;
import config.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.SlotMachineHomePage;

/**
 * Abstract step definition class defining default behavior of all step definition classes
 */
public abstract class StepDefinition {

    public static final String SLOTMACHINE_URL = "http://slotmachinescript.com/";
    protected static SlotMachineHomePage slotMachineHomePage;
    protected WebDriver driver;
    protected Logger logger;

    public StepDefinition() {
        logger = LoggerFactory.getLogger(this.getClass());
        driver = WebDriverFactory.getDriver(
                DriverType.valueOf(System.getProperty("driver", "chrome").toUpperCase()));
    }
}
