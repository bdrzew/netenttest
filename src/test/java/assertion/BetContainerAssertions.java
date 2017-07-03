package assertion;

import config.webdriver.SMExpectedConditions;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.BetContainerComponent;

import static org.junit.Assert.*;

public class BetContainerAssertions extends Assertions<BetContainerComponent> {
    public BetContainerAssertions validateSpinButtonIsDisabled() {
        assertTrue("Spin button is not disabled",
            page.waitUntil(ExpectedConditions.visibilityOf(page.getDisabledSpinButton())).isDisplayed());
        return this;
    }

    public BetContainerAssertions validateSpinButtonIsEnabled() {
        assertTrue("Spin button is not enabled",
            page.waitUntil(ExpectedConditions.visibilityOf(page.getSpinButton())).isDisplayed());
        assertTrue("Spin button is not enabled",
            page.waitUntil(SMExpectedConditions.elementNotExists(page.getDisabledSpinButton()), 12));
        return this;
    }

    public BetContainerAssertions validateBetValue(String betValue) {
        assertEquals("Bet value is not as expected", betValue, page.getBet().getText());
        return this;
    }

    public BetContainerAssertions validateLastWinValue(String lastWin) {
        assertTrue("Last Win value is not as expected",
                page.waitUntil(ExpectedConditions.textToBePresentInElement(page.getLastWin(), lastWin), 12));
        return this;
    }

    public BetContainerAssertions validateCreditsValue(String credits) {
        assertTrue("Credits value is not as expected",
                page.waitUntil(ExpectedConditions.textToBePresentInElement(page.getCredits(), credits), 12));
        return this;
    }

    public BetContainerAssertions validateBetContainerContent(DataTable betContainerContent) {
        betContainerContent.cells(0).get(0).forEach(column -> {
            WebElement elementToValidate;
            switch(column){
                case "LAST WIN":
                    elementToValidate = page.getLastWin();
                    break;
                case "TOTAL SPINS":
                    elementToValidate = page.getCredits();
                    break;
                case "BET":
                    elementToValidate = page.getBet();
                    break;
                case "BETSPIN UP":
                    elementToValidate = page.getBetSpinUp();
                    break;
                case "BETSPIN DOWN":
                    elementToValidate = page.getBetSpinDown();
                    break;
                case "DAY WINS":
                    elementToValidate = page.getDayWinnings();
                    break;
                case "LIFETIME WINS":
                    elementToValidate = page.getLifetimeWinnings();
                    break;
                default:
                    elementToValidate = null;
                    fail("Unknown type of column in feature file.");
            }
            assertTrue("Bet container field " + column + " is not displayed as expected", elementToValidate.isDisplayed());
        });
        return this;
    }
}
