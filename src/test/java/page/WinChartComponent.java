package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Component class representing Win Chart present in SlotMachine Page
 */
public class WinChartComponent extends Page {
    public WinChartComponent(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getPrizesIconsBySetId(String reelSetId) {
        return driver.findElements(By.cssSelector(".reelSet" + reelSetId + " #prizes_list_slotMachine1 .reelIcon"));
    }

    public WebElement getWinChartByMachineId(String machineId) {
        return driver.findElement(By.cssSelector("#prizes_list_slotMachine" + machineId));
    }

    public List<WebElement> getPrizeRows() {
        return driver.findElements(By.cssSelector(".prizes_list_slot_machine .trPrize .tdPayout")).stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
    }

    public WebElement getPrizeRowByPrizeId(String prizeId) {
        return driver.findElement(By.id("trPrize_" + prizeId));
    }
}
