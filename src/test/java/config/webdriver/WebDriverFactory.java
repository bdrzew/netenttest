package config.webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Factory for different types of drivers.
 * This can be controlled via command line parameter.
 */
public class WebDriverFactory {
    private static WebDriver driver;

    private WebDriverFactory() {}

    public static WebDriver getDriver(DriverType browser) {
        if (driver == null) {
            driver = initializeDriver(browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initializeDriver(DriverType browser) {
        switch (browser) {
            case FIREFOX:
                return getFirefoxDriver();
            case CHROME:
                return getChromeDriver();
            case IE:
                return getInternetExplorerDriver();
            default:
                return null;
        }
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxDriverManager.getInstance().setup();
        FirefoxProfile fp = new FirefoxProfile();
        fp.setAcceptUntrustedCertificates(true);
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("ignoreZoomSetting", true);
        return new FirefoxDriver(fp);
    }

    private static WebDriver getChromeDriver() {
        ChromeDriverManager.getInstance().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors", "no-sandbox");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return new ChromeDriver(capabilities);
    }

    private static WebDriver getInternetExplorerDriver() {
        InternetExplorerDriverManager.getInstance().setup();
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("ignoreZoomSetting", true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        return new InternetExplorerDriver(caps);
    }
}
