package utils;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Attach to report
            byte[] screenshot = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed_Screenshot");

            // Save as file
            File srcFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
            String screenshotName = "screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png";
            try {
                FileUtils.copyFile(srcFile, new File(screenshotName));
                System.out.println("📸 Screenshot saved to: " + screenshotName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BaseTest.tearDown();
    }
}
