package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CustomListener implements ITestListener {
    private final Logger LOGGER = LoggerFactory.getLogger("TestSuite");


    @Override
    public void onStart(ITestContext testContext) {
        LOGGER.info("Testsuite is starting");
    }

    @Override
    public void onTestStart(ITestResult result) {
        Date date = new Date(result.getStartMillis());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Tallinn"));
        String dateFormatted = formatter.format(date);
        LOGGER.info("Test: "
                + result.getMethod().getMethodName() + " at:" + dateFormatted);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Result was: success");
    }

    @Override
    public void onTestFailure(ITestResult result) { LOGGER.info("Result was: failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.info("Test was skipped!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but was in success percentage");
    }

    //...
    @Override
    public void onFinish(ITestContext testContext) {

        LOGGER.info("PASSED TEST CASES");
        testContext.getPassedTests().getAllResults()
                .forEach(result -> {
                    LOGGER.info(result.getName());
                });

        LOGGER.info("FAILED TEST CASES");
        testContext.getFailedTests().getAllResults()
                .forEach(result -> {
                    LOGGER.info(result.getName());
                });

        LOGGER.info(
                "Test completed on: " + testContext.getEndDate().toString());
    }

}



