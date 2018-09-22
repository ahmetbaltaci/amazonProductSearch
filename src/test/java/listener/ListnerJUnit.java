package listener;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import setUp.BaseTest;

/**
 * Created by ahmetbaltaci on 21.09.2018.
 */
class ListnerJUnit extends RunListener{



    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println("Tests started! Number of Test case: " + description.testCount() + "\n");
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("Tests finished! Number of test case: " + result.getRunCount());

    }

    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println(description.getMethodName() + " test is starting...");
        BaseTest base = new BaseTest();
        base.goToWebSite();

    }

    @Override
    public void testFinished(Description description) throws Exception {
        BaseTest.driver.quit();
        System.out.println(description.getMethodName() + " test is finished...\n");

    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        //Write the test name when it is failed.
        System.out.println(failure.getDescription().getMethodName() + " test FAILED!!!");
        ScreenShot.captureScreen(failure.getDescription().getMethodName());
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println(description.getMethodName() + " test SKIPPED!!!");
        ScreenShot.captureScreen(description.getMethodName());

    }
}
