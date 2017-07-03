package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Component class representing CustomizationBar present in SlotMachine Page
 */
@Getter
public class CustomizationBarComponent extends Page {
    @FindBy(css = ".btnChangeBackground")
    private WebElement btnChangeBackground;
    @FindBy(css = ".btnChangeReels")
    private WebElement btnChangeReels;
    @FindBy(css = ".btnChangeMachine")
    private WebElement btnChangeMachine;

    public CustomizationBarComponent(WebDriver driver) {
        super(driver);
    }

    public CustomizationBarComponent clickBtnChangeBackground(int clickCount) {
        repeat(p -> btnChangeBackground.click(), clickCount);
        return this;
    }

    public CustomizationBarComponent clickBtnChangeReels(int clickCount) {
        repeat(p -> btnChangeReels.click(), clickCount);
        return this;
    }

    public CustomizationBarComponent clickBtnChangeMachine(int clickCount) {
        repeat(p -> btnChangeMachine.click(), clickCount);
        return this;
    }
}
