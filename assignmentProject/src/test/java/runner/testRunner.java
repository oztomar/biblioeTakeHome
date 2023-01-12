package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // Connecting JUnit here
@CucumberOptions(
        features = "src/test/resources",  //This is to connect feature files with runner class
        //We need to copy path from content root
        glue = "stepsDefintion", //This is to connect steps with runner class
        //We need to copy path from source root
        tags= "@TC1",
        dryRun = false, //This determines if we want to run test scenarios headless or not
        plugin= {
                "pretty", //This is to have more understandable console logs. Printing "pretty" format.
                "rerun:target/rerun.txt", //This will help us to store failed scenarios in rerun.txt file
                // We can then run them again from FailedRunner class.
                "html:target/default-cucumber-reports.html",
                "json:target/cucumber.json",
        }
)
public class testRunner {
}
