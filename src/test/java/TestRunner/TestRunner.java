package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/Features/Login.feature",
                "src/test/resources/Features/AddItem.feature",
                "src/test/resources/Features/CheckOutInformationData.feature",
                "src/test/resources/Features/CheckOut.feature",
        },
        glue = {"StepDef"},
        plugin = {"pretty","json:target/cucumber.json"})

public class TestRunner {
}
