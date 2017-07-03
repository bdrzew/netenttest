package assertion;

import org.openqa.selenium.support.ui.ExpectedConditions;
import page.WinChartComponent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Assertions for WinChart Component
 */
public class WinChartAssertions extends Assertions<WinChartComponent> {
    public WinChartAssertions validateWinChartIconsAreDisplayed(String reelSet) {
        page.waitUntil(ExpectedConditions.visibilityOfAllElements(page.getPrizesIconsBySetId(reelSet)));
        return this;
    }

    public WinChartAssertions validateWinChartByMachineIdIsDisplayed(String machineId) {
        assertTrue("Incorrect Win Chart is displayed according to machine id " + machineId,
                page.waitUntil(ExpectedConditions.visibilityOf(page.getWinChartByMachineId(machineId))).isDisplayed());
        return this;
    }

    public WinChartAssertions validateWinChartRatio(int ratio) {
        page.getPrizeRows().forEach(p -> {
            Double basepayout = Double.valueOf(p.getAttribute("data-basepayout"));
            Double actualpayout = Double.valueOf(p.getText());
            assertEquals("Base payout and actual payout are not as expected",
                    Double.valueOf(basepayout * ratio), actualpayout);
        });
        return this;
    }

    public WinChartAssertions validateNumberOfDisplayedPrizes(Integer numberOfRows) {
        assertEquals("Number of prize rows in Win Chart is not as expected",
                numberOfRows.intValue(), page.getPrizeRows().size());
        return this;
    }

    public WinChartAssertions validatePrizeRowIsInWonState(String prizeId) {
        assertTrue("Prize " + prizeId + " is not lighted up as expected.",
                page.getPrizeRowByPrizeId(prizeId).getAttribute("class").contains("won"));
        return this;
    }
}
