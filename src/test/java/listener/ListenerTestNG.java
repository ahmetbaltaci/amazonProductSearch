package listener;

import org.testng.*;
import setUp.BaseTest;

/**
 * Created by ahmetbaltaci on 21.09.2018.
 */
public class ListenerTestNG extends BaseTest implements ITestListener {




    public void onTestStart(ITestResult result) {
        System.out.println("Tests started! "+ result.getName() + "\n");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test PASSED ");
    }

    public void onTestFailure(ITestResult result) {
        ScreenShot.captureScreen(result.getName());
        System.out.println("Test FAILED");
    }

    public void onTestSkipped(ITestResult result) {
        ScreenShot.captureScreen(result.getName());
        System.out.println("TEST SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        System.out.println("Test starting ...");
        goToWebSite();

    }

    public void onFinish(ITestContext context) {
        System.out.println("Test is finished...");
        driver.quit();
    }
}
