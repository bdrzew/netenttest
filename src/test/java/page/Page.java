package page;

import assertion.Assertions;
import assertion.ISupportAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Abstract Page method, which defines all default behavior of all pages and components.
 */
public abstract class Page implements ISupportAssertions {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this(driver, null);
    }

    public Page(WebDriver driver, String url) {
        this.driver = driver;
        if (isNotBlank(url)) {
            driver.navigate().to(url);
        }
        PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
    }

    public <T> T waitUntil(ExpectedCondition<T> expectedCondition) {
        return waitUntil(expectedCondition, 3);
    }

    public <T> T waitUntil(ExpectedCondition<T> expectedCondition, int timeoutSeconds) {
        return new WebDriverWait(driver, timeoutSeconds)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .until(expectedCondition);
    }

    @Override
    public <G extends Page, T extends Assertions<G>> T check(Class<T> clazz) throws RuntimeException {
        try {
            Assertions<G> assertion = clazz.newInstance();
            assertion.setPage((G)this);
            return (T) assertion;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Error occur during creating Assertions.", e);
        }
    }

    protected void repeat(Consumer action, int count) {
        IntStream.range(0, count).forEach(i -> {
            action.accept(null);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
