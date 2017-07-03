import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Test runner class used to trigger all existaing tests.
 * Can be passed to command line by using -Dtest=SlotMachineTestRunner
 * Produces results report in ./target/cucumber/index.html
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" }
)
public class SlotMachineTestRunner {

}
