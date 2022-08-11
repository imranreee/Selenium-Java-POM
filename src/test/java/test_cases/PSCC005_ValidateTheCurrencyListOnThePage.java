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
import utils.ReadExcel;

import java.io.IOException;

import static utils.UserInput.excelPath;

public class PSCC005_ValidateTheCurrencyListOnThePage extends HelperClass {
    public PSCC005_ValidateTheCurrencyListOnThePage(WebDriver driver) {
        super(driver);
    }

    public PSCC005_ValidateTheCurrencyListOnThePage pscc005_validateTheCurrencyListOnThePage() throws InterruptedException, IOException {
        RunTestCases.test = RunTestCases.extent.createTest("Validate the all currency list on the page");
        driver.navigate().refresh();
        waitForVisibilityOf(CurrencyExchangeLadingPage.logoPS());
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//strong[. = 'Online currency exchange calculator']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        waitForVisibilityOf(CurrencyExchangeCalculatorPage.txtCurrencyList(1));

        for (int i = 1; i < 33; i++){
            String actualCurrencyText = CurrencyExchangeCalculatorPage.txtCurrencyList(i).getText();
            String expectedCurrencyText = ReadExcel.readData(excelPath, "1", i, "0");
            Assert.assertEquals(actualCurrencyText, expectedCurrencyText);
            System.out.println("Actual Currency name: "+actualCurrencyText);
            System.out.println("Expected Currency name: "+expectedCurrencyText);
            System.out.println("====================================");
            Thread.sleep(1000);
            RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Currency showing as expected, expected currency is: "+actualCurrencyText, ExtentColor.GREEN));
        }

        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Currency list showing as expected", ExtentColor.GREEN));
        return new PSCC005_ValidateTheCurrencyListOnThePage(driver);
    }
}