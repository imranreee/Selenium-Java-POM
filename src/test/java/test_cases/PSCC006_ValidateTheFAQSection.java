package test_cases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.CurrencyExchangeCalculatorPage;
import pages.CurrencyExchangeLadingPage;
import run_test_case.RunTestCases;
import utils.HelperClass;
import utils.ReadExcel;

import java.io.IOException;

import static utils.UserInput.excelPath;

public class PSCC006_ValidateTheFAQSection extends HelperClass {
    @FindBy(how = How.XPATH, using = "//strong[. = 'Frequently asked questions about online currency exchange']")
    WebElement txtFaqTitle;

    @FindBy(how = How.XPATH, using = "//div[2]/div[1]/div/a")
    WebElement btnHowToExchange;

    @FindBy(how = How.XPATH, using = "//div[2]/div[2]/div/a")
    WebElement btnHowToSendAbroad;

    @FindBy(how = How.XPATH, using = "//div[2]/div[3]//a")
    WebElement btnCanICovert;

    @FindBy(how = How.XPATH, using = "//div[4]/div/a")
    WebElement btnDoIGet;

    @FindBy(how = How.XPATH, using = "//div[2]/div[2]/div/a")
    WebElement txtCheckHowToExchange;

    @FindBy(how = How.XPATH, using = "//div[2]/div[2]/div/a")
    WebElement txtCheckHowToSendAbroad;

    @FindBy(how = How.XPATH, using = "//div[2]/div[2]/div/a")
    WebElement txtCheckCanICovert;

    @FindBy(how = How.XPATH, using = "//div[2]/div[2]/div/a")
    WebElement txtCheckDoIGet;

    public PSCC006_ValidateTheFAQSection(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PSCC006_ValidateTheFAQSection pscc006_validateTheFAQSection() throws InterruptedException, IOException {
        RunTestCases.test = RunTestCases.extent.createTest("Validate FAQ section");
        driver.navigate().refresh();
        waitForVisibilityOf(CurrencyExchangeLadingPage.logoPS());
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//strong[. = 'Frequently asked questions about online currency exchange']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
        waitForVisibilityOf(txtFaqTitle);
        Assert.assertEquals(txtFaqTitle.getText(), "Frequently asked questions about online currency exchange");
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("FAQ title found", ExtentColor.GREEN));

        btnHowToExchange.click();
        waitForVisibilityOf(txtCheckHowToExchange);
        Assert.assertEquals(txtCheckHowToExchange.isDisplayed(), true);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("How to exchange currency via Paysera? section expanded successfully", ExtentColor.GREEN));
        btnHowToExchange.click();

        btnHowToSendAbroad.click();
        waitForVisibilityOf(txtCheckHowToSendAbroad);
        Assert.assertEquals(txtCheckHowToSendAbroad.isDisplayed(), true);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("How to send money abroad? section expanded successfully", ExtentColor.GREEN));
        btnHowToSendAbroad.click();

        btnCanICovert.click();
        waitForVisibilityOf(txtCheckCanICovert);
        Assert.assertEquals(txtCheckCanICovert.isDisplayed(), true);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Can I convert currency via the web? section expanded successfully", ExtentColor.GREEN));
        btnCanICovert.click();

        btnDoIGet.click();
        waitForVisibilityOf(txtCheckDoIGet);
        Assert.assertEquals(txtCheckDoIGet.isDisplayed(), true);
        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("Do I get a discount when exchanging section expanded successfully", ExtentColor.GREEN));
        btnDoIGet.click();


        RunTestCases.test.log(Status.PASS, MarkupHelper.createLabel("FAQ Section expand button working successfully", ExtentColor.GREEN));
        return new PSCC006_ValidateTheFAQSection(driver);
    }
}