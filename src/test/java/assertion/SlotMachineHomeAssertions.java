package assertion;

import page.SlotMachineHomePage;

import static org.junit.Assert.assertTrue;

/**
 * Assertions for SlotMachine home page
 */
public class SlotMachineHomeAssertions extends Assertions<SlotMachineHomePage> {
    public SlotMachineHomeAssertions validateSlotMachineBackgroundIsDisplayed(String backgroundId) {
        assertTrue("Background with index " + backgroundId + " is not displaued on page as expected",
                page.waitUntil(p -> page.getBackgroundElementById(backgroundId).isDisplayed()));
        return this;
    }
}
