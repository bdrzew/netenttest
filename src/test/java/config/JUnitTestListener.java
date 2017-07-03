package config;

import config.webdriver.DriverType;
import config.webdriver.WebDriverFactory;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Listener for cucumber tests, which are based on junit.
 * Thanks to that it is possible to catch when tests are started, finished or failed
 */
public class JUnitTestListener extends RunListener {
    private WebDriver driver;
    private Logger logger = LoggerFactory.getLogger(JUnitTestListener.class);

    @Override
    public void testRunStarted(Description description) throws Exception {
        super.testRunStarted(description);
        driver = WebDriverFactory.getDriver(
                DriverType.valueOf(System.getProperty("driver", "chrome").toUpperCase()));
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        super.testRunFinished(result);
        driver.quit();
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        super.testFailure(failure);
        logger.error(ExceptionUtils.getFullStackTrace(failure.getException()));
    }
}
