package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HelperClass;

public class CurrencyExchangeCalculatorPage extends HelperClass {
    private static WebElement element;

    public CurrencyExchangeCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public static WebElement txtBoxSell(){
        element = driver.findElement(By.xpath("//form/div[1]/input"));
        return element;
    }

    public static WebElement txtBoxBuy(){
        element = driver.findElement(By.xpath("//div[3]/input"));
        return element;
    }

    public static WebElement btnFilter(){
        element = driver.findElement(By.xpath("//button[contains(text(),'Filter')]"));
        return element;
    }

    public static WebElement dropdownListSellCurrency(){
        element = driver.findElement(By.xpath("//form/div[1]//span[2]"));
        return element;
    }

    public static WebElement dropdownListBuyCurrency(){
        element = driver.findElement(By.xpath("//form/div[3]/div/div/span"));
        return element;
    }

    public static WebElement dropdownListValueUSD(){
        element = driver.findElement(By.xpath("//span[. = 'USD']"));
        return element;
    }

    public static WebElement txtCurrencyNameSearchResult(){
        element = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
        return element;
    }

    public static WebElement txtPaySearAmount(){
        element = driver.findElement(By.xpath("//tr[1]/td[4]/span/span/span"));
        return element;
    }

    public static WebElement txtSwedBankAmount(){
        element = driver.findElement(By.xpath("//tr[1]/td[5]/span/span/span[1]"));
        return element;
    }

    public static WebElement txtCurrencyCalculator(){
        element = driver.findElement(By.xpath("//strong[. = 'Online currency exchange calculator']"));
        return element;
    }

    public static WebElement txtLossAmount(){
        element = driver.findElement(By.xpath("//tr[1]/td[5]//span[2]"));
        return element;
    }

    public static WebElement menuSelectCountry(){
        element = driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/span"));
        return element;
    }

    public static WebElement dropDownCountryList(){
        element = driver.findElement(By.xpath("//form/div[1]/div/div/button/span[2]"));
        return element;
    }

    public static WebElement txtCountryName(){
        element = driver.findElement(By.id("countries-dropdown"));
        return element;
    }

    public static WebElement listCountrySelect(int pos){
        element = driver.findElement(By.xpath("//form/div[1]/div/div/ul/li["+pos+"]/a"));
        return element;
    }

    public static WebElement txtPaySearRate(){
        element = driver.findElement(By.xpath("//*[@id=\"currency-exchange-app\"]/div/div/div[2]/table/tbody/tr/td[3]"));
        return element;
    }

    public static WebElement txtCurrencyList(int pos){
        //element = driver.findElement(By.xpath("//*[@id=\"currency-exchange-app\"]/div/div/div[2]/table/tbody/tr["+pos+"]/td[1]"));
        element = driver.findElement(By.xpath("//tr["+pos+"]/td[1]"));
        return element;
    }
}
