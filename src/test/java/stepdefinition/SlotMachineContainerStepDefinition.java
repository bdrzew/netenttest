package stepdefinition;

import assertion.SlotMachineContainerAssertions;
import assertion.SlotMachineHomeAssertions;
import cucumber.api.java8.En;
import model.SpinResponse;

/**
 * Step definition class testing SlotMachineContainer present in SlotMachine Page
 */
public class SlotMachineContainerStepDefinition extends StepDefinition implements En {

    public SlotMachineContainerStepDefinition() {
        And("^Spin is finished$", () -> slotMachineHomePage
            .getSlotMachineContainerComponent()
                .waitUntilSpinIsFinished());

        Then("^Reel \"([^\"]*)\" stops spinning before Reel \"([^\"]*)\"$", (String reel1, String reel2) -> slotMachineHomePage
            .getSlotMachineContainerComponent()
            .waitUntilReelSpinIsFinished(reel1)
            .check(SlotMachineContainerAssertions.class)
                .validateReelIsSpinning(reel1, false)
                .validateReelIsSpinning(reel2, true));

        And("^Reel icons are changed to \"([^\"]*)\" in Slot Machine$", (String reelSetId) -> slotMachineHomePage
            .getSlotMachineContainerComponent()
            .check(SlotMachineContainerAssertions.class)
                .validateReelIconsAreDisplayed(reelSetId));

        Then("^Background image is changed to \"([^\"]*)\"$", (String backgroundId) -> slotMachineHomePage
            .check(SlotMachineHomeAssertions.class)
                .validateSlotMachineBackgroundIsDisplayed(backgroundId));

        Then("^Slot Machine is changed to \"([^\"]*)\"$", (String machineId) -> slotMachineHomePage
            .getSlotMachineContainerComponent()
            .check(SlotMachineContainerAssertions.class)
                .validateSlotMachineIsDisplayed(machineId));

        When("^Slot Machine spin response returns prize number \"([^\"]*)\"$", (String prizeId) -> slotMachineHomePage
            .mockEndSpinResponse(SpinResponse.builder()
                .prizeId(prizeId).build()
                .getWinJsonString()));

        Then("^Slot Machine is lighted up$", () -> slotMachineHomePage
            .getSlotMachineContainerComponent()
            .check(SlotMachineContainerAssertions.class)
                .validateSlotOuterContainerInWonState());

        When("^Slot Machine spin response returns Last Win \"([^\"]*)\"$", (String lastWin) -> slotMachineHomePage
            .mockEndSpinResponse(SpinResponse.builder()
                .lastWin(lastWin).build()
                .getWinJsonString()));

        When("^Slot Machine spin response returns credits \"([^\"]*)\"$", (String credits) -> slotMachineHomePage
            .mockEndSpinResponse(SpinResponse.builder()
                .credits(credits).build()
                .getWinJsonString()));
    }

}
