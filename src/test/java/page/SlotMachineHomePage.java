package page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Main Page class
 */
@Getter
public class SlotMachineHomePage extends Page {
    private final BetContainerComponent betContainerComponent;
    private final CustomizationBarComponent customizationBarComponent;
    private final SlotMachineContainerComponent slotMachineContainerComponent;
    private final WinChartComponent winChartComponent;

    public SlotMachineHomePage(WebDriver driver) {
        this(driver, null);
    }
    public SlotMachineHomePage(WebDriver driver, String url) {
        super(driver, url);
        customizationBarComponent = new CustomizationBarComponent(driver);
        betContainerComponent = new BetContainerComponent(driver);
        slotMachineContainerComponent = new SlotMachineContainerComponent(driver);
        winChartComponent = new WinChartComponent(driver);
    }

    public WebElement getBackgroundElementById(String backgroundId) {
        return driver.findElement(By.id("changeable_background_" + backgroundId));
    }

    public SlotMachineHomePage mockEndSpinResponse(String jsonString) {
        ((JavascriptExecutor) driver).executeScript(
                "slotMachine.end_spin($.parseJSON('" + jsonString + "'));");
        return this;
    }
}
