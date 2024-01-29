package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "D:\\Web Testing\\Maven and cucumber projects\\Bank\\src\\test\\resources\\Features\\loginpage.feature",
        glue = {"StepDef"},
        monochrome = true,
        publish = true,
        dryRun = true)

public class TestRunner {

}
