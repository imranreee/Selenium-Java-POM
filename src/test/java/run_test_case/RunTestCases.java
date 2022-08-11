package run_test_case;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.qameta.allure.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import test_cases.*;
import utils.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunTestCases extends WebSettings {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh-mm-ssaa");
    Date date = new Date();
    String currentDate = dateFormat.format(date);

    DateFormat dateFormatNew = new SimpleDateFormat("dd-MMM-yyyy");
    Date dateNew = new Date();
    String currentDateNew = dateFormatNew.format(dateNew);

    String allureResultPathDes = UserInput.allureReportDestination+ currentDate;


    @BeforeClass(groups = {"regression", "system"})
    public void setUpWeb(){
        upAndRunWeb("chrome", UserInput.stagingUrl);
    }

    @BeforeTest(groups = {"regression", "system"})
    public void config() throws Exception {
        File file = new File(UserInput.resultFolderPath + currentDateNew);
        if (!file.exists()) {
            file.mkdir();
        } else {
            //System.out.println("Unable to make folder");
        }

        File file2 = new File(allureResultPathDes);
        if (!file2.exists()) {
            file2.mkdir();
        } else {
            //System.out.println("Unable to make folder for Allure report");
        }


        htmlReporter = new ExtentSparkReporter(file + "\\PSCurrencyExchangeTestResult_" + UserInput.autVersion + "_" + currentDate + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Machine", "Windows");
        extent.setSystemInfo("Platform Name", "Web");
        extent.setSystemInfo("Application Name", "PSCurrency Exchange");
        extent.setSystemInfo("Application Version", UserInput.autVersion);
        extent.setSystemInfo("Script developed by", "Al Imran(imranreee@gmail.com)");

        htmlReporter.config().setDocumentTitle("Automation Test Results");
        htmlReporter.config().setReportName("Automation Test Results of PSCurrencyExchange_"+UserInput.autVersion+" Web App");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Test(priority = 1, enabled = true, groups = {"regression", "system"})
    @Description("Validate the landing page of Online Currency Exchange")
    @Epic("SSCC-001")
    @Feature("Landing page")
    @Story("SSCC-002")
    @Severity(SeverityLevel.MINOR)
    @Issue("SSCL-007")
    public void PSCC001_ValidateLandingPage(){
        new PSCC001_ValidateLandingPage(driver).pscc001_checkLandingPage();
    }


    @Test(priority = 2, enabled = true, groups = {"regression"})
    @Description("Validate the behaviour of Sell and Buy input box")
    @Epic("SSCC-001")
    @Feature("Online currency exchange calculator")
    @Story("SSCC-003")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("SSCL-008")
    public void PSCC002_ValidateBuySellAmountBox() throws InterruptedException {
        new PSCC002_ValidateBuySellAmountBox(driver).pscc002_validateBuySellAmountBox();
    }


    @Test(priority = 3, enabled = true, groups = {"regression", "system"})
    @Description("Validate the loss calculation")
    @Epic("SSCC-001")
    @Feature("Online currency exchange calculator")
    @Story("SSCC-003")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("SSCL-009")
    public void PSCC003_ValidateLossCalculation() throws InterruptedException {
        new PSCC003_ValidateLossCalculation(driver).pscc003_validateLossCalculation();
    }

    @Test(priority = 4, enabled = true, groups = {"regression"})
    @Description("Validate default currency and rate by depending on the selected country")
    @Epic("SSCC-001")
    @Feature("Online currency exchange calculator")
    @Story("SSCC-003")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("SSCL-010")
    public void PSCC004_ValidateRateCurrencyDependOnCountry() throws InterruptedException, IOException {
        new PSCC004_ValidateRateCurrencyDependOnCountry(driver).pscc004_validateRateCurrencyDependOnCountry();
    }

    @Test(priority = 5, enabled = true, groups = {"regression", "system"})
    @Description("Validate the currency list on the page")
    @Epic("SSCC-001")
    @Feature("Online currency exchange calculator")
    @Story("SSCC-003")
    @Severity(SeverityLevel.MINOR)
    @Issue("SSCL-011")
    public void PSCC005_ValidateCurrencyListOnPage() throws InterruptedException, IOException {
        new PSCC005_ValidateTheCurrencyListOnThePage(driver).pscc005_validateTheCurrencyListOnThePage();
    }

    @Test(priority = 6, enabled = true, groups = {"regression"})
    @Description("Validate FAQ section")
    @Epic("SSCC-001")
    @Feature("Online currency exchange calculator")
    @Story("SSCC-003")
    @Severity(SeverityLevel.NORMAL)
    @Issue("SSCL-012")
    public void PSCC006_ValidateTheFAQSection() throws InterruptedException, IOException {
        new PSCC006_ValidateTheFAQSection(driver).pscc006_validateTheFAQSection();
    }


    @AfterMethod(groups = {"regression", "system"})
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE){
            GetScreenshot.capture(driver, result.getName() + "_" + currentDate);
            String screenShotPath = "./../error_screenshots/"+result.getName() + "_" + currentDate+".png";
            test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath((screenShotPath)).build());
        }

    }

    @AfterTest(groups = {"regression", "system"})
    public void saveReport() {
        extent.flush();
    }

    @AfterClass(groups = {"regression", "system"})
    public void endTest() throws IOException {
        driver.quit();
        MoveFiles.moveFiles(UserInput.allureReportSource, allureResultPathDes);
    }
}
