package assertion;

import org.openqa.selenium.support.ui.ExpectedConditions;
import page.SlotMachineContainerComponent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Assertions for SlotMachineContainer Component
 */
public class SlotMachineContainerAssertions extends Assertions<SlotMachineContainerComponent> {
    public SlotMachineContainerAssertions validateReelIsSpinning(String reelId, boolean isSpinning) {
        assertEquals("Reel " + reelId + " spin state is not as expected. ", isSpinning, page.isReelSpinning(reelId));
        return this;
    }

    public SlotMachineContainerAssertions validateReelIconsAreDisplayed(String reelSetId) {
        page.waitUntil(ExpectedConditions.visibilityOfAllElements(page.getReelIconsBySetId(reelSetId)));
        return this;
    }

    public SlotMachineContainerAssertions validateSlotMachineIsDisplayed(String machineId) {
        assertTrue("Slot Machine with Id " + machineId + " is not displayed as expected",
                page.waitUntil(ExpectedConditions.visibilityOf(page.getMachineLayoutById(machineId))).isDisplayed());
        return this;
    }

    public SlotMachineContainerAssertions validateSlotOuterContainerInWonState() {
        assertTrue("Slot outer container is not lighted", page.getLightedUpSlotContainer().isDisplayed());
        return this;
    }
}
