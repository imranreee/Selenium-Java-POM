package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

public interface AllureTestListenerHelper {
    static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "{0}", type = "text/plain")
    static String saveTextLog(String message) {
        return message;
    }

    @Attachment
    byte[] saveFailureScreenShot(WebDriver driver);

    void onStart(ITestContext iTestContext);

    void onFinish(ITestContext iTestContext);

    void onTestStart(ITestResult iTestResult);

    void onTestSuccess(ITestResult iTestResult);

    void onTestFailure(ITestResult iTestResult);

    void onTestSkipped(ITestResult iTestResult);

    void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult);
}
