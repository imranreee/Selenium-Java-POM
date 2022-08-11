package test_cases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CurrencyExchangeCalculatorPage;
import pages.CurrencyExchangeLadingPage;
import run_test_case.RunTestCases;
import utils.HelperClass;

public class PSCC003_ValidateLossCalculation extends HelperClass {
    public PSCC003_ValidateLossCalculation(WebDriver driver) {
        super(driver);
    }

    public PSCC003_ValidateLossCalculation pscc003_validateLossCalculation() throws InterruptedException {
        RunTestCases.test = RunTestCases.extent.createTest("Validate the loss calculation by comparing Bank and PaySera");

        driver.navigate().refresh();

        waitForVisibilityOf(CurrencyExchangeLadingPage.logoPS());
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("On the HOME page", ExtentColor.CYAN));

        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//form/div[1]/input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForVisibilityOf(CurrencyExchangeCalculatorPage.txtBoxSell());
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Scroll tot he sell input field", ExtentColor.CYAN));

        Thread.sleep(5000);
        String defaultValueSell = CurrencyExchangeCalculatorPage.txtBoxSell().getAttribute("value");
        Assert.assertEquals(defaultValueSell, "100");
        String defaultValueBuy = CurrencyExchangeCalculatorPage.txtBoxBuy().getAttribute("value");
        Assert.assertEquals(defaultValueBuy, "");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Default value of Sell and Buy field are showing as expected", ExtentColor.GREEN));

        //For setting currency as USD to convert from buy side
        CurrencyExchangeCalculatorPage.dropdownListBuyCurrency().click();
        CurrencyExchangeCalculatorPage.dropdownListValueUSD().click();
        Assert.assertEquals(CurrencyExchangeCalculatorPage.dropdownListBuyCurrency().getText(), "USD");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Currency set as expected", ExtentColor.GREEN));

        //Click on the Filter button and wait for the expected search result
        CurrencyExchangeCalculatorPage.btnFilter().click();
        waitForVisibilityOf(CurrencyExchangeCalculatorPage.txtCurrencyNameSearchResult());
        Thread.sleep(5000);
        Assert.assertEquals(CurrencyExchangeCalculatorPage.txtCurrencyNameSearchResult().getText(), "USD (US Dollar)");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Search result found as per the filter", ExtentColor.GREEN));

        //For validating the loss amount between expected and actual in case of SELL
        String paySeraAmountTxt = CurrencyExchangeCalculatorPage.txtPaySearAmount().getText();
        String swedBankAmountTxt = CurrencyExchangeCalculatorPage.txtSwedBankAmount().getText();
        String actualLossAmount = CurrencyExchangeCalculatorPage.txtLossAmount().getText();
        actualLossAmount = actualLossAmount.replace(")","");
        actualLossAmount = actualLossAmount.replace("(","");

        float paySeraAmountFlt = Float.parseFloat(paySeraAmountTxt);
        float swedBankAmountFlt = Float.parseFloat(swedBankAmountTxt);

        //System.out.println(paySeraAmountFlt);
        //System.out.println(swedBankAmountFlt);

        float expectedLoss = swedBankAmountFlt - paySeraAmountFlt;
        String expectedLossAmount = String.format("%.2f", expectedLoss);

        //System.out.println(actualLossAmount);
        //System.out.println(expectedLossAmount);

        Assert.assertEquals(actualLossAmount, expectedLossAmount);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("In Case of SELL loss amount found as expected, actual loss amount is "+actualLossAmount, ExtentColor.GREEN));

        //For validating the loss amount between expected and actual in case of BUY
        CurrencyExchangeCalculatorPage.txtBoxBuy().click();
        CurrencyExchangeCalculatorPage.txtBoxBuy().clear();
        CurrencyExchangeCalculatorPage.txtBoxBuy().sendKeys("100");
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Value inputted to the buy field", ExtentColor.CYAN));

        CurrencyExchangeCalculatorPage.btnFilter().click();
        waitForVisibilityOf(CurrencyExchangeCalculatorPage.txtCurrencyNameSearchResult());
        Thread.sleep(5000);
        Assert.assertEquals(CurrencyExchangeCalculatorPage.txtCurrencyNameSearchResult().getText(), "EUR (Euro)");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Search result found as per the filter", ExtentColor.GREEN));

        paySeraAmountTxt = CurrencyExchangeCalculatorPage.txtPaySearAmount().getText();
        swedBankAmountTxt = CurrencyExchangeCalculatorPage.txtSwedBankAmount().getText();
        actualLossAmount = CurrencyExchangeCalculatorPage.txtLossAmount().getText();
        actualLossAmount = actualLossAmount.replace(")","");
        actualLossAmount = actualLossAmount.replace("(","");

        paySeraAmountFlt = Float.parseFloat(paySeraAmountTxt);
        swedBankAmountFlt = Float.parseFloat(swedBankAmountTxt);

        //System.out.println(paySeraAmountFlt);
        //System.out.println(swedBankAmountFlt);

        expectedLoss = paySeraAmountFlt - swedBankAmountFlt;
        expectedLossAmount = String.format("%.2f", expectedLoss);
        //System.out.println(actualLossAmount);
        //System.out.println(expectedLossAmount);
        Assert.assertEquals(actualLossAmount, expectedLossAmount);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("In case of BUY loss amount found as expected, actual loss amount is "+actualLossAmount, ExtentColor.GREEN));

        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Sell and Buy loss amount shown as expected", ExtentColor.GREEN));
        return new PSCC003_ValidateLossCalculation(driver);
    }
}