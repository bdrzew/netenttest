package stepdefinition;

import assertion.WinChartAssertions;
import cucumber.api.java8.En;

/**
 * Step definition class testing WinChart present in SlotMachine Page
 */
public class WinChartStepDefinition extends StepDefinition implements En {

    public WinChartStepDefinition() {
        Then("^Every payout in Win Chart is equal to base payout multiplied by \"([^\"]*)\"$", (Integer bet) -> slotMachineHomePage
            .getWinChartComponent()
            .check(WinChartAssertions.class)
                .validateWinChartRatio(bet));

        Then("^Reel prize icons are changed to \"([^\"]*)\" in Win Chart$", (String reelSet) -> slotMachineHomePage
            .getWinChartComponent()
            .check(WinChartAssertions.class)
                .validateWinChartIconsAreDisplayed(reelSet));

        And("^Win Chart is changed to Machines \"([^\"]*)\"$", (String machineId) -> slotMachineHomePage
            .getWinChartComponent()
            .check(WinChartAssertions.class)
                .validateWinChartByMachineIdIsDisplayed(machineId));

        And("^Win Chart has \"([^\"]*)\" combinations displayed$", (Integer numberOfRows) -> slotMachineHomePage
            .getWinChartComponent()
            .check(WinChartAssertions.class)
                .validateNumberOfDisplayedPrizes(numberOfRows));

        And("^Win Chart winning position \"([^\"]*)\" is lighted up$", (String prizeId) -> slotMachineHomePage
            .getWinChartComponent()
            .check(WinChartAssertions.class)
                .validatePrizeRowIsInWonState(prizeId));
    }
}
