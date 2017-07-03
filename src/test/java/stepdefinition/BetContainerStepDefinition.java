package stepdefinition;

import assertion.BetContainerAssertions;
import cucumber.api.DataTable;
import cucumber.api.java8.En;

/**
 * Step definition class testing BetContainer present in SlotMachine Page
 */
public class BetContainerStepDefinition extends StepDefinition implements En {

    public BetContainerStepDefinition() {
        When("^Spin button is clicked$", () -> slotMachineHomePage
            .getBetContainerComponent()
            .clickSpinButton());

        Then("^Spin button is disabled$", () -> slotMachineHomePage
            .getBetContainerComponent()
            .check(BetContainerAssertions.class)
                .validateSpinButtonIsDisabled());

        Then("^Spin button is enabled$", () -> slotMachineHomePage
            .getBetContainerComponent()
            .check(BetContainerAssertions.class)
                .validateSpinButtonIsEnabled());

        And("^Bet ratio displayed in Bet Container is equal to \"([^\"]*)\"$", (String betValue) -> slotMachineHomePage
            .getBetContainerComponent()
            .check(BetContainerAssertions.class)
                .validateBetValue(betValue));

        When("^Bet Spin Up is clicked \"([^\"]*)\" time\\(s\\)$", (Integer clickCount) -> slotMachineHomePage
            .getBetContainerComponent()
            .clickBetSpinUp(clickCount));

        When("^Bet Spin Down is clicked \"([^\"]*)\" time\\(s\\)$", (Integer clickCount) -> slotMachineHomePage
            .getBetContainerComponent()
            .clickBetSpinDown(clickCount));

        Then("^Bet Container displays$", (DataTable betContainerContent) -> slotMachineHomePage
            .getBetContainerComponent()
            .check(BetContainerAssertions.class)
                .validateBetContainerContent(betContainerContent));

        Then("^Last Win should be set to \"([^\"]*)\"$", (String lastWin) -> slotMachineHomePage
            .getBetContainerComponent()
            .check(BetContainerAssertions.class)
                .validateLastWinValue(lastWin));
        Then("^Credits should be set to \"([^\"]*)\"$", (String credits) -> slotMachineHomePage
            .getBetContainerComponent()
            .check(BetContainerAssertions.class)
                .validateCreditsValue(credits));
    }
}
