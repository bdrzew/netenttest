package stepdefinition;

import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.MDC;
import page.SlotMachineHomePage;

import java.io.File;
import java.io.IOException;

/**
 * Step definition class containing hooks and background steps
 */
public class CommonBrowsingStepDefinition extends StepDefinition implements En {
    private String scenarioId;

    public CommonBrowsingStepDefinition() {
        Before((Scenario scenario) -> {
            this.scenarioId = scenario.getName().replace(" ", "") + "_" + scenario.hashCode();
            MDC.put("appendername", scenarioId);
        });

        After((Scenario scenario) -> {
            File logFile = new File("./target/cucumber/log/" + scenarioId + ".log");
            scenario.write("<a href=\"" + logFile.getAbsolutePath() + "\">Log file</a>");
            if(scenario.isFailed()) {
                File scrnsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                File jpgFile = new File("./target/cucumber/log/" + scenarioId + ".jpg");
                try {
                    FileUtils.copyFile(scrnsht, jpgFile);
                } catch (IOException e) {
                    logger.error(ExceptionUtils.getFullStackTrace(e));
                }
                scenario.write("<a href=\"" + jpgFile.getAbsolutePath() + "\">" +
                        "<img src=\"" + jpgFile.getAbsolutePath() +
                        "\" width=\"192\" height=\"108\" /></a>");
            }
        });

        Given("^User goes to Slot Machine page$", () -> {
            slotMachineHomePage = new SlotMachineHomePage(driver, SLOTMACHINE_URL);
        });
    }

}

