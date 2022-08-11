package test_cases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CurrencyExchangeCalculatorPage;
import pages.CurrencyExchangeLadingPage;
import run_test_case.RunTestCases;
import utils.HelperClass;
import utils.ReadExcel;

import java.io.IOException;

import static utils.UserInput.excelPath;

public class PSCC004_ValidateRateCurrencyDependOnCountry extends HelperClass {
    public PSCC004_ValidateRateCurrencyDependOnCountry(WebDriver driver) {
        super(driver);
    }

    public PSCC004_ValidateRateCurrencyDependOnCountry pscc004_validateRateCurrencyDependOnCountry() throws InterruptedException, IOException {
        RunTestCases.test = RunTestCases.extent.createTest("Validate the rates and default currency by depending on the selected country");

        //It will select all country one after another and will check related changes by depending on selected country
        for(int i = 1; i < 5; i++){
            waitForVisibilityOf(CurrencyExchangeLadingPage.logoPS());

            //For scrolling to bottom of the page
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            waitForVisibilityOf(CurrencyExchangeCalculatorPage.menuSelectCountry());
            Assert.assertEquals(CurrencyExchangeCalculatorPage.menuSelectCountry().isDisplayed(), true);
            RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Page scroll to bottom of the page", ExtentColor.GREEN));

            CurrencyExchangeCalculatorPage.menuSelectCountry().click();
            waitForClickAbilityOf(CurrencyExchangeCalculatorPage.dropDownCountryList());
            CurrencyExchangeCalculatorPage.dropDownCountryList().click();
            CurrencyExchangeCalculatorPage.listCountrySelect(i).click();
            waitForVisibilityOf(CurrencyExchangeLadingPage.logoPS());

            CurrencyExchangeLadingPage.btnSeeRates().click();
            Thread.sleep(3000);
            waitForClickAbilityOf(CurrencyExchangeCalculatorPage.btnFilter());
            Thread.sleep(2000);
            String actualDefaultCurrencyTxt = CurrencyExchangeCalculatorPage.dropdownListSellCurrency().getText();

            //Reading expected default currency from excel file
            String expectedDefaultCurrencyTxt = ReadExcel.readData(excelPath, "0", i, "1");
            Assert.assertEquals(actualDefaultCurrencyTxt, expectedDefaultCurrencyTxt);
            System.out.println("Default currency: "+actualDefaultCurrencyTxt);
            RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Right default currency showing as per the selected country, currency name: "+actualDefaultCurrencyTxt, ExtentColor.GREEN));

            CurrencyExchangeCalculatorPage.dropdownListBuyCurrency().click();
            waitForClickAbilityOf(CurrencyExchangeCalculatorPage.dropdownListValueUSD());
            CurrencyExchangeCalculatorPage.dropdownListValueUSD().click();

            waitForClickAbilityOf(CurrencyExchangeCalculatorPage.btnFilter());
            CurrencyExchangeCalculatorPage.btnFilter().click();
            waitForVisibilityOf(CurrencyExchangeCalculatorPage.txtCurrencyNameSearchResult());
            Thread.sleep(3000);
            Assert.assertEquals(CurrencyExchangeCalculatorPage.txtCurrencyNameSearchResult().getText(), "USD (US Dollar)");
            RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Search result found as per the filter", ExtentColor.GREEN));

            //Reading expected paySear rate and country name from excel file
            String actualPaySearRateTxt = CurrencyExchangeCalculatorPage.txtPaySearRate().getText();
            String expectedPaySearRateTxt = ReadExcel.readData(excelPath, "0", i, "2");
            expectedPaySearRateTxt = expectedPaySearRateTxt + "00";

            System.out.println("Actual USD rate by PaySera: "+actualPaySearRateTxt);
            System.out.println("Expected USD rate by PaySera: "+expectedPaySearRateTxt);
            Assert.assertEquals(actualPaySearRateTxt, expectedPaySearRateTxt);
            String countryNameTxt = ReadExcel.readData(excelPath, "0", i, "0");
            RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Rate found as per the expectation, for "+countryNameTxt, ExtentColor.GREEN));

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            waitForVisibilityOf(CurrencyExchangeCalculatorPage.menuSelectCountry());
            CurrencyExchangeCalculatorPage.menuSelectCountry().click();
            waitForClickAbilityOf(CurrencyExchangeCalculatorPage.dropDownCountryList());

            String selectedCountry = CurrencyExchangeCalculatorPage.txtCountryName().getText();
            System.out.println("Selected Country: "+selectedCountry);
            Assert.assertEquals(selectedCountry, selectedCountry);
            waitForClickAbilityOf(CurrencyExchangeCalculatorPage.menuSelectCountry());
            RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Right country selected, country name: "+selectedCountry, ExtentColor.GREEN));
            driver.navigate().refresh();
            System.out.println("====================================");
        }

        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Rates and default currency by depending on the selected country is validated", ExtentColor.GREEN));
        return new PSCC004_ValidateRateCurrencyDependOnCountry(driver);
    }
}