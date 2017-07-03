package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Component class representing BetContainer present in SlotMachine Page
 */
@Getter
public class BetContainerComponent extends Page {
    @FindBy(id = "spinButton")
    private WebElement spinButton;
    @FindBy(css = "#spinButton.disabled")
    private WebElement disabledSpinButton;
    @FindBy(id = "lastWin")
    private WebElement lastWin;
    @FindBy(id = "credits")
    private WebElement credits;
    @FindBy(id = "bet")
    private WebElement bet;
    @FindBy(id = "dayWinnings")
    private WebElement dayWinnings;
    @FindBy(id = "lifetimeWinnings")
    private WebElement lifetimeWinnings;
    @FindBy(id = "betSpinUp")
    private WebElement betSpinUp;
    @FindBy(id = "betSpinDown")
    private WebElement betSpinDown;

    public BetContainerComponent(WebDriver driver) {
        super(driver);
    }

    public void clickSpinButton() {
        spinButton.click();
    }

    public BetContainerComponent clickBetSpinUp(int clickCount) {
        repeat(p -> betSpinUp.click(), clickCount);
        return this;
    }

    public BetContainerComponent clickBetSpinDown(int clickCount) {
        repeat(p -> betSpinDown.click(), clickCount);
        return this;
    }
}
