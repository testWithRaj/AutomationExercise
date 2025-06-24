package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    ExtentReports extent = ExtentReportManager.getExtentReport();
    ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        BaseTest.setUp();
        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");

            test.log(Status.FAIL, "Scenario Failed");
        } else {
            test.log(Status.PASS, "Scenario Passed");
        }
        extent.flush();
        BaseTest.tearDown();
    }
}
