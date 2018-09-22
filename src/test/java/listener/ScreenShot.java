package listener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import setUp.BaseTest;

import java.io.File;
import java.io.IOException;

/**
 * Created by ahmetbaltaci on 21.09.2018.
 */
class ScreenShot extends BaseTest {

    static void captureScreen(String className) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("build/screenshot/" + className + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
