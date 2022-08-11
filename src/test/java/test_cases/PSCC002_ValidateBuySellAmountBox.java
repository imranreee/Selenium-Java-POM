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

public class PSCC002_ValidateBuySellAmountBox extends HelperClass {
    public PSCC002_ValidateBuySellAmountBox(WebDriver driver) {
        super(driver);
    }

    public PSCC002_ValidateBuySellAmountBox pscc002_validateBuySellAmountBox() throws InterruptedException {
        RunTestCases.test = RunTestCases.extent.createTest("Validate the Buy and Sell input box behaviour of PaySear currency exchange");

        waitForVisibilityOf(CurrencyExchangeLadingPage.logoPS());
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("On the HOME page", ExtentColor.CYAN));

        //For scrolling to the buy and sell box
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//strong[. = 'Online currency exchange calculator']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForVisibilityOf(CurrencyExchangeCalculatorPage.txtCurrencyCalculator());
        Assert.assertEquals(CurrencyExchangeCalculatorPage.txtCurrencyCalculator().getText(), "Online currency exchange calculator");

        waitForVisibilityOf(CurrencyExchangeCalculatorPage.txtBoxSell());
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Scroll tot he sell input field", ExtentColor.CYAN));

        //To validate the default value of buy and sell box and currency dropdown menu
        Thread.sleep(5000);
        String defaultValueSell = CurrencyExchangeCalculatorPage.txtBoxSell().getAttribute("value");
        Assert.assertEquals(defaultValueSell, "100");
        String defaultValueBuy = CurrencyExchangeCalculatorPage.txtBoxBuy().getAttribute("value");
        Assert.assertEquals(defaultValueBuy, "");
        Assert.assertEquals(CurrencyExchangeCalculatorPage.dropdownListSellCurrency().getText(), "EUR");
        Assert.assertEquals(CurrencyExchangeCalculatorPage.dropdownListBuyCurrency().getText(), "All");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Default value of Sell and Buy field are showing as expected", ExtentColor.GREEN));

        //To validate the inputted value of buy and sell box
        CurrencyExchangeCalculatorPage.txtBoxSell().click();
        CurrencyExchangeCalculatorPage.txtBoxSell().clear();
        CurrencyExchangeCalculatorPage.txtBoxSell().sendKeys("500");
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Value inputted to the sell field", ExtentColor.CYAN));

        String inputtedValueSell = CurrencyExchangeCalculatorPage.txtBoxSell().getAttribute("value");
        Assert.assertEquals(inputtedValueSell, "500");
        String emptyBoxBuy = CurrencyExchangeCalculatorPage.txtBoxBuy().getAttribute("value");
        Assert.assertEquals(emptyBoxBuy, "");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Inputted value of Sell and Empty Buy field are showing as expected", ExtentColor.GREEN));

        CurrencyExchangeCalculatorPage.txtBoxBuy().click();
        CurrencyExchangeCalculatorPage.txtBoxBuy().clear();
        CurrencyExchangeCalculatorPage.txtBoxBuy().sendKeys("300");
        RunTestCases.test.log(Status.INFO, MarkupHelper.createLabel("Value inputted to the buy field", ExtentColor.CYAN));

        String inputtedValueBuy = CurrencyExchangeCalculatorPage.txtBoxBuy().getAttribute("value");
        Assert.assertEquals(inputtedValueBuy, "300");
        String emptyBoxSell = CurrencyExchangeCalculatorPage.txtBoxSell().getAttribute("value");
        Assert.assertEquals(emptyBoxSell, "");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Inputted value in Buy field and Empty Sell field are showing as expected", ExtentColor.GREEN));

        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Sell and Buy input fields behaviour as expected", ExtentColor.GREEN));
        return new PSCC002_ValidateBuySellAmountBox(driver);
    }
}