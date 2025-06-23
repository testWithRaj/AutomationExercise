package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features",     // 📂 Feature file path
    glue = {"stepDefinations","utils"},                  // 📦 Step definition package
    plugin = {"pretty", 
              "html:target/cucumber-reports/report.html", 
              "json:target/cucumber.json"},      // 📊 Reporting
    monochrome = true,                           // ✨ Clean console output
    dryRun = false                               // ✅ false = actually run the test
)
public class TestRunner {
	
	

}
