package test_cases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CurrencyExchangeCalculatorPage;
import pages.CurrencyExchangeLadingPage;
import run_test_case.RunTestCases;
import utils.HelperClass;

public class PSCC001_ValidateLandingPage extends HelperClass {
    public PSCC001_ValidateLandingPage(WebDriver driver) {
        super(driver);
    }

    public PSCC001_ValidateLandingPage pscc001_checkLandingPage(){
        RunTestCases.test = RunTestCases.extent.createTest("Validate the landing page of PaySear currency exchange");

        waitForVisibilityOf(CurrencyExchangeLadingPage.logoPS());
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("On the HOME page", ExtentColor.CYAN));

        Assert.assertEquals(CurrencyExchangeLadingPage.logoPS().isDisplayed(), true);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("PaySear logo found", ExtentColor.GREEN));

        String actualTextCurrencyExchange = CurrencyExchangeLadingPage.txtCurrencyExchangeHeader().getText();
        Assert.assertEquals(actualTextCurrencyExchange, "Online Currency Exchange");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Online Currency Exchange header text found", ExtentColor.GREEN));

        Assert.assertEquals(CurrencyExchangeLadingPage.btnSeeRates().isDisplayed(), true);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("See Rates button found", ExtentColor.GREEN));

        Assert.assertEquals(CurrencyExchangeLadingPage.btnChat().isDisplayed(), true);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Chet button found", ExtentColor.GREEN));

        Assert.assertEquals(CurrencyExchangeLadingPage.imaAppSS().isDisplayed(), true);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("App screenshot found", ExtentColor.GREEN));

        CurrencyExchangeLadingPage.btnSeeRates().click();
        waitForVisibilityOf(CurrencyExchangeCalculatorPage.txtCurrencyCalculator());
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("See Rates button performed perfectly", ExtentColor.GREEN));



        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Landing page check test Passed", ExtentColor.GREEN));
        return new PSCC001_ValidateLandingPage(driver);
    }
}