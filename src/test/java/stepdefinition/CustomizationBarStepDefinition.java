package stepdefinition;

import cucumber.api.java8.En;

/**
 * Step definition class testing CustomizationBar present in SlotMachine Page
 */
public class CustomizationBarStepDefinition extends StepDefinition implements En {

    public CustomizationBarStepDefinition() {
        When("^Change Background button is clicked \"([^\"]*)\" time\\(s\\) in customization bar$", (Integer clickCount) -> slotMachineHomePage
                .getCustomizationBarComponent()
                .clickBtnChangeBackground(clickCount));

        When("^Change Icons button is clicked \"([^\"]*)\" time\\(s\\) in customization bar$", (Integer clickCount) -> slotMachineHomePage
                .getCustomizationBarComponent()
                .clickBtnChangeReels(clickCount));

        When("^Change Machine button is clicked \"([^\"]*)\" time\\(s\\) in customization bar$", (Integer clickCount) -> slotMachineHomePage
                .getCustomizationBarComponent()
                .clickBtnChangeMachine(clickCount));
        When("^Slot Machine \"([^\"]*)\" is displayed$", (Integer clickCount) ->slotMachineHomePage
                .getCustomizationBarComponent()
                .clickBtnChangeMachine(clickCount - 1));
    }
}
