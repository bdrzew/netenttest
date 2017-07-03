package page;

import config.webdriver.SMExpectedConditions;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Component class representing SlotMachineContainer present in SlotMachine Page
 */
@Getter
public class SlotMachineContainerComponent extends Page {
    @FindBy(css = "#reel1")
    private WebElement reel1;
    @FindBy(css = "#reel2")
    private WebElement reel2;
    @FindBy(css = "#reel3")
    private WebElement reel3;
    @FindBy(css = "#SlotsOuterContainer.won")
    private WebElement lightedUpSlotContainer;

    public SlotMachineContainerComponent(WebDriver driver) {
        super(driver);
    }

    public SlotMachineContainerComponent waitUntilSpinIsFinished() {
        waitUntil(SMExpectedConditions.spinIsFinished(reel3));
        return this;
    }

    public SlotMachineContainerComponent waitUntilReelSpinIsFinished(String reelId) {
        waitUntil(SMExpectedConditions.spinIsFinished(getReelElementById(reelId)));
        return this;
    }

    public boolean isReelSpinning(String reelId) {
        return !(Boolean) ((JavascriptExecutor) driver)
                .executeScript("return !jQuery(arguments[0]).data(\"spinTimer\");", getReelElementById(reelId));
    }

    private WebElement getReelElementById(String reelId) {
        return driver.findElement(By.id("reel" + reelId));
    }

    public List<WebElement> getReelIconsBySetId(String reelSetId) {
        return driver.findElements(By.cssSelector(".reelSet" + reelSetId + " .reel"));
    }

    public WebElement getMachineLayoutById(String machineId) {
        return driver.findElement(By.cssSelector(".slotMachine" + machineId + " #ReelContainer"));
    }
}
