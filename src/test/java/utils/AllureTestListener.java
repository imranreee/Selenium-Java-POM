package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class AllureTestListener extends HelperClass implements AllureTestListenerHelper {
    public AllureTestListener(WebDriver driver) {
        super(driver);
    }

    @Override
    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + AllureTestListenerHelper.getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + AllureTestListenerHelper.getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + AllureTestListenerHelper.getTestMethodName(iTestResult) + " failed");
        Object testClass = iTestResult.getInstance();
        //WebDriver driver;
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + AllureTestListenerHelper.getTestMethodName(iTestResult));
            saveFailureScreenShot(driver);
        }
        AllureTestListenerHelper.saveTextLog(AllureTestListenerHelper.getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + AllureTestListenerHelper.getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + AllureTestListenerHelper.getTestMethodName(iTestResult));
    }

}
