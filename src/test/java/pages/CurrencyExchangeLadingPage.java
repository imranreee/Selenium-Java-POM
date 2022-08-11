package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HelperClass;

public class CurrencyExchangeLadingPage extends HelperClass {
    private static WebElement element;

    public CurrencyExchangeLadingPage(WebDriver driver) {
        super(driver);
    }

    public static WebElement logoPS(){
        element = driver.findElement(By.xpath("//div/div/div[1]/a/img"));
        return element;
    }

    public static WebElement txtCurrencyExchangeHeader(){
        element = driver.findElement(By.xpath("//*[@id=\"docs-internal-guid-e609898d-7fff-f564-7c52-b4a2029e0bb9\"]"));
        return element;
    }

    public static WebElement btnSeeRates(){
        element = driver.findElement(By.xpath("//div[3]/a"));
        return element;
    }

    public static WebElement btnChat(){
        element = driver.findElement(By.xpath("//body/div//img"));
        return element;
    }

    public static WebElement imaAppSS(){
        element = driver.findElement(By.xpath("//section/div/div/div/div/div[2]//img"));
        return element;
    }
}
