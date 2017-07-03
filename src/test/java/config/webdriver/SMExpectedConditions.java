package config.webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Application specific selenium conditions
 */
public class SMExpectedConditions {

    public static ExpectedCondition<Boolean> spinIsFinished(final WebElement element){
        return driver -> (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return !jQuery(arguments[0]).data(\"spinTimer\");", element);
    }

    public static ExpectedCondition<Boolean> elementNotExists(WebElement element) {
        return driver -> {
            try {
                element.isDisplayed();
                return false;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return true;
            }
        };
    }
}
